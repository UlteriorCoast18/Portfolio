import tkinter as tk
import pdf_methods as pm

window_height = 900
window_width = 1400

#Número que determina número de páginas de un booklet, ideal entre 6 y 10 
size_booklet = 6

class App(tk.Frame):
    def __init__(self, master):
        super().__init__(master)
        self.pack()

        #Create Objects within the frame

        self.label_1 = tk.Label(text = "Hello")
        self.label_1.place(relx=0.5, rely=0.5, anchor='center')
        self.label_1.pack()
        

        """
        self.entrythingy = tk.Entry()
        self.entrythingy.pack()

        # Create the application variable.
        self.contents = tk.StringVar()
        # Set it to some value.
        self.contents.set("this is a variable")
        # Tell the entry widget to watch this variable.
        self.entrythingy["textvariable"] = self.contents

        # Define a callback for when the user hits return.
        # It prints the current value of the variable.
        self.entrythingy.bind('<Key-Return>', self.print_contents)
        """

    def print_contents(self, event):
        print("Hi. The current entry content is:", self.contents.get())


if __name__ == "__main__":
    #Window configuration
    """
    root = tk.Tk()
    screen_height = root.winfo_screenheight()
    screen_width = root.winfo_screenwidth()
    root.geometry(f"{window_width}x{window_height}+{int((screen_width - window_width)/2)}+{int((screen_height-window_height)/2)}")
    root.title("Python Booklet Project")
    root.positionfrom()
    
    #Window Init
    myapp = App(root)
    myapp.mainloop()
    """
    route = '/home/cristoalvarado/Documents/Books To Print/Libro Mau 1/test_1.pdf'
    output = '/home/cristoalvarado/Documents/Books To Print/Libro Mau 1/output.pdf'
    pm.resize_pdf(route,output,size_booklet)
