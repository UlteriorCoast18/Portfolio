import time
import numpy as np
import matplotlib
import trimesh
import viser

def main() -> None:
    grid_shape = (4, 5)
    server = viser.ViserServer()

    # GUI para mostrar coordenadas del último clic
    with server.gui.add_folder("Last clicked"):
        x_value = server.gui.add_number(label="x", initial_value=0, disabled=True)
        y_value = server.gui.add_number(label="y", initial_value=0, disabled=True)
        z_value = server.gui.add_number(label="z", initial_value=0, disabled=True)

    # Guardamos meshes para raycasting usando nombres como llaves
    mesh_dict = {}

    def add_swappable_mesh(i: int, j: int) -> None:
        colormap = matplotlib.colormaps["tab20"]

        # Crear mesh
        index = (i * grid_shape[1] + j) / (grid_shape[0] * grid_shape[1])
        color_rgb = colormap(index)[:3]
        color_rgba = np.array([*color_rgb, 1.0])

        mesh = trimesh.creation.box(extents=(0.5, 0.5, 0.5))
        mesh.apply_translation([i, j, 0.0])
        mesh.visual.vertex_colors = np.tile(color_rgba, (len(mesh.vertices), 1))

        # Nombre único del mesh
        name = f"/mesh_{i}_{j}"
        handle = server.scene.add_mesh_trimesh(name=name, mesh=mesh)

        # Guardamos el mesh para raycasting
        mesh_dict[name] = mesh

    # Crear todos los meshes
    for i in range(grid_shape[0]):
        for j in range(grid_shape[1]):
            add_swappable_mesh(i, j)


    # Mantener el servidor corriendo
    while True:
        time.sleep(10.0)

if __name__ == "__main__":
    main()
