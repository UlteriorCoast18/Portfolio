import open3d as o3d
import os

width = 1400
height = 900

def create_cube():
    mesh_box = o3d.geometry.TriangleMesh.create_box(width=1.0,
                                                height=1.0,
                                                depth=1.0)
    mesh_box.compute_vertex_normals()
    mesh_box.paint_uniform_color([0.5, 0.5, 0.5])
    return mesh_box

def get_view_status(vis):
    ctr = vis.get_view_control()
    param = ctr.convert_to_pinhole_camera_parameters()

    o3d.io.write_pinhole_camera_parameters(
        "view_status.json",
        param
    )

def main():
    # 1. Initialize the application singleton
    vis = o3d.visualization.VisualizerWithEditing()
    

    # 2. Create window
    window = vis.create_window("Rubik's Cube", width, height)

    print("Let's define some primitives")
    mesh_frame = o3d.geometry.TriangleMesh.create_coordinate_frame(
        size=0.6,
        origin=[0, 0, 0])
    mesh_box = create_cube()
    print("We draw a few primitives using collection.")

    # 3. Add objects

    pcd = mesh_box.sample_points_uniformly(number_of_points=10000)

    vis.add_geometry(pcd)

    # 4. Read and stablish view_status

    if os.path.exists("view_status.json"):
        param = o3d.io.read_pinhole_camera_parameters("view_status.json")
        ctr = vis.get_view_control()
        ctr.convert_from_pinhole_camera_parameters(param)

    print("Shift + click para seleccionar puntos")
    print("Presiona Q o Esc para salir")

    vis.run()
    
    #get_view_status(vis) #decomment this in order to get the json view_status
    
    vis.destroy_window()



    #o3d.visualization.draw_geometries([mesh_box, mesh_frame])

if __name__ == "__main__":
    main()