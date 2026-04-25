from __future__ import annotations
from screeninfo import get_monitors
import pyvista as pv
import numpy as np
import time

n = 2 #number of cube layers

a = 1 #length of each indiviudal square
r = np.sqrt(2*a**2)

orientations_array = ['x+', 'x-', 'y+', 'y-', 'z+', 'z-']
click_actors = []
FACE_COLORS = {
    'x+': 'red',
    'x-': 'orange',
    'y+': 'green',
    'y-': 'blue',
    'z+': 'white',
    'z-': 'yellow',
}

def generate_rubik_matrix():
    matrices = {}
    cont = 0
    for face_name in orientations_array:
        face = []
        for j in range(n):
            row = []
            for k in range(n):
                row.append(cont)
                cont += 1
            face.append(row)
        matrices[face_name] = face
    return matrices

def print_matrices(matrices):
    width = 6 * n
    for j in range(n):
        for face_name in orientations_array:
            cell = str(matrices[face_name][j])
            print(f"{cell:<{width}}", end="")
        print()

def place_faces(matrices,pl):
    squares = {}
    start = (1.0 * n - a)/2
    cont = 0
    for face_name in orientations_array:
        face = []
        for j in range(n):
            row = []
            for k in range(n):
                if face_name == 'x+': face_mesh = draw_square_face(start, -start + j, -start+k, face_name, pv)
                if face_name == 'x-': face_mesh = draw_square_face(-start, -start + j, -start+k, face_name, pv)
                if face_name == 'y+': face_mesh = draw_square_face(-start + j, start, -start+k, face_name, pv)
                if face_name == 'y-': face_mesh = draw_square_face(-start + j, -start, -start+k, face_name, pv)
                if face_name == 'z+': face_mesh = draw_square_face(-start + j, -start+k, start, face_name, pv)
                if face_name == 'z-': face_mesh = draw_square_face(-start + j, -start+k, -start, face_name, pv)
                actor = pl.add_mesh(face_mesh, show_edges = True, edge_color = 'black', line_width = 3, color = FACE_COLORS[face_name])
                row.append({
                    'face': face_mesh,
                    'actor': actor,
                    'position': matrices[face_name][j][k],
                    'center_coords': face_mesh.center
                })
                cont += 1
            face.append(row)
        squares[face_name] = face
    return squares

def draw_square_face(x,y,z,n,pv):
    #This function draws a square given the center over which is going to be drawn and the direction in which is going to be placed

    #n is a normal vector to the surface we are generating, in this case can be 'x+','x-','y+','y-','z+' or 'z-'.
    if n == 'x+':
        poli = pv.Polygon(n_sides=4,normal=(1,0,0),center=(x+a/2,y,z), radius=r/2)
        poli = poli.rotate_x(45, point=poli.center)
    elif n == 'x-':
        poli = pv.Polygon(n_sides=4,normal=(-1,0,0),center=(x-a/2,y,z), radius=r/2)
        poli = poli.rotate_x(45, point=poli.center)
    elif n == 'y+':
        poli = pv.Polygon(n_sides=4,normal=(0,1,0),center=(x,y+a/2,z), radius=r/2)
        poli = poli.rotate_y(45, point=poli.center)
    elif n == 'y-':
        poli = pv.Polygon(n_sides=4,normal=(0,-1,0),center=(x,y-a/2,z), radius=r/2)
        poli = poli.rotate_y(45, point=poli.center)
    elif n == 'z+':
        poli = pv.Polygon(n_sides=4,normal=(0,0,1),center=(x,y,z+a/2), radius=r/2)
        poli = poli.rotate_z(45, point=poli.center)
    elif n == 'z-':
        poli = pv.Polygon(n_sides=4,normal=(0,0,-1),center=(x,y,z-a/2), radius=r/2)
        poli = poli.rotate_z(45, point=poli.center)
    
    return poli
   
def main():
    #Plot Creation
    pl = pv.Plotter()

    # --- Plot Creation ---
    pl = pv.Plotter(window_size=(1400, 900), title="Rubik Cube Picker")  # Tamaño y título

    # --- Center Plot --- 
    screen = get_monitors()[0]
    window_width, window_height = 800, 600
    x = (screen.width - window_width) // 2
    y = (screen.height - window_height) // 2

    pl.renderer.GetRenderWindow().SetPosition(x, y)


    #Generate Cube Faces and Backend
    matrices = generate_rubik_matrix()
    faces = place_faces(matrices,pl)

    """ Event Definition """

    def callback(point):
        """Add a small cube and label at the click point, removing previous ones."""
        # Delete previous secondary cubes
        for actor in click_actors:
            pl.remove_actor(actor)
        click_actors.clear()

        # Create a small cube in the selection point
        x, y, z = [round(coord, 2) for coord in point]
        point = (x, y, z)
        mesh = pv.Cube(center=point, x_length=0.05, y_length=0.05, z_length=0.05)
        actor = pl.add_mesh(mesh, style='wireframe', color='black')
        click_actors.append(actor)
        if x == y or y == z or z == x:
            print('Just not')
        else:
            #Start Movement
            print('It is possible to move')

        print(f'Clicked point: ({x}, {y}, {z})')

    # Activar picking de superficie
    pl.enable_surface_point_picking(callback=callback, show_point=False)

    #Mostrar plot
    pl.show()

    # Cerrar el plotter al final
    pl.close()


if __name__ == '__main__':
    main()