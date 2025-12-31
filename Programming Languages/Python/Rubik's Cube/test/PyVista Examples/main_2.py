from pyvistaqt import BackgroundPlotter
import pyvista as pv
import numpy as np
import time
import threading

# --- Background Plotter ---
pl = BackgroundPlotter(window_size=(800, 600), title="Rotating Camera Example")

# Cubo en el centro
pl.add_mesh(pv.Cube(), color='red')

# Parámetros del giro
radius = 3.0
center = (0, 0, 0)
angles = np.linspace(0, 360, 360)

# Animación de la cámara en segundo plano
def rotate_camera():
    while True:
        for angle in angles:
            rad = np.deg2rad(angle)
            x = radius * np.cos(rad)
            y = radius * np.sin(rad)
            z = 1.0
            pl.camera_position = [(x, y, z), center, (0, 0, 1)]
            time.sleep(0.01)

# Lanza la animación en un hilo aparte
thread = threading.Thread(target=rotate_camera, daemon=True)
thread.start()

# La ventana ya es interactiva automáticamente
