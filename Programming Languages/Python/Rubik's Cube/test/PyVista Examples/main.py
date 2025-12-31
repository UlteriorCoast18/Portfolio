from __future__ import annotations
import pyvista as pv
import numpy as np
import time

a = 1
r = np.sqrt(2*a**2)

print(a)

def draw_square_face(x,y,z,n,pv):
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
        
"""

# Cubo principal
main_cube = pv.Cube()
main_actor = pl.add_mesh(main_cube, show_edges=True, line_width=20, color = "white")

# Lista para llevar los cubos clickeados
click_actors = []

def callback(point):
    #Add a small cube and label at the click point, removing previous ones
    # Eliminar todos los cubos secundarios anteriores
    for actor in click_actors:
        pl.remove_actor(actor)
    click_actors.clear()

    # Crear cubo pequeño en el punto
    mesh = pv.Cube(center=point, x_length=0.05, y_length=0.05, z_length=0.05)
    actor = pl.add_mesh(mesh, style='wireframe', color='r')
    click_actors.append(actor)

    print(f'{point[0]:.2f}, {point[1]:.2f}, {point[2]:.2f}')

# Activar picking de superficie
pl.enable_surface_point_picking(callback=callback, show_point=False)

"""
pl = pv.Plotter()

faces = {}
for face_name in ['x+', 'x-', 'y+', 'y-', 'z+', 'z-']:
    face_mesh = draw_square_face(0, 0, 0, face_name, pv)
    actor = pl.add_mesh(face_mesh, show_edges=True)
    faces[face_name] = (face_mesh, actor)

click_actors = []

def callback(point):
    """Add a small cube and label at the click point, removing previous ones."""
    # Eliminar todos los cubos secundarios anteriores
    for actor in click_actors:
        pl.remove_actor(actor)
    click_actors.clear()

    # Crear cubo pequeño en el punto
    mesh = pv.Cube(center=point, x_length=0.05, y_length=0.05, z_length=0.05)
    actor = pl.add_mesh(mesh, style='wireframe', color='black')
    click_actors.append(actor)

    print(f'{point[0]:.2f}, {point[1]:.2f}, {point[2]:.2f}')

# Activar picking de superficie
pl.enable_surface_point_picking(callback=callback, show_point=False)

pl.show()

# Cerrar el plotter al final
pl.close()
#draw_face(0,0,0,'x-',pv)
