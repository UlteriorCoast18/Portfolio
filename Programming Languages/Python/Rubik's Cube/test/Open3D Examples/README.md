# How to Execute on Linux

Since there are some problems using Wayland, we may encounter the following warning while executing the `main.py` script:

```text
[Open3D WARNING] GLFW Error: Wayland: The platform does not support setting the window position
[Open3D WARNING] Failed to initialize GLEW.
[Open3D WARNING] [DrawGeometries] Failed creating OpenGL window.
```

In order to prevent this error, we must force the app to use the **X11** backend (which is a Wayland compatibility layer) instead of native Wayland. To do this, we must set an environment variable before running the Open3D script:

```bash
export XDG_SESSION_TYPE=x11
```

Since we are using **Python 3.12**, after this we can just execute the script using the terminal or configure VS Code to use this Python version by selecting `Python: Select Interpreter` with `Ctrl + Shift + P`.

```bash
python main.py
```