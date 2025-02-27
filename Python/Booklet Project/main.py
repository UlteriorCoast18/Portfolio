import tkinter as tk
from tkinter import filedialog, ttk
from PIL import Image, ImageTk
import pdf_methods as pm
import os

window_height = 1000
window_width = 1600

click_num = 0
x1, y1 ,x2, y2 = 0, 0, 0, 0

pdf_selected = False

#Image Escale
image_escale = 4

#Número que determina número de páginas de un booklet, ideal entre 6 y 10 
size_booklet = 6
file_path = ""

class App(tk.Frame):
    def __init__(self, master):
        super().__init__(master)
        self.master = master
        self.create_widgets()

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

    def create_widgets(self):
        #Button choose file
        self.direct_button = tk.Button(self, text="File Directory", command=self.open_file_dialog)
        self.direct_button.grid(row=1, column=0, sticky="nsew", padx=5, pady=5)
        
        #File Directory
        self.direct_entry = tk.Label(self, text="Empty")
        self.direct_entry.grid(row=1, column=1, sticky="nsew", padx=5, pady=5)

        #Operations Label
        self.label_operations = tk.Label(self, text="Options")
        self.label_operations.grid(row=2, column=1, sticky="nsew", padx=5, pady=5)

        #Crop Button
        self.crop_button = tk.Button(self, text="Start Cropping PDF", command=self.show_pdf_to_crop)
        self.crop_button.grid(row=3, column=1, sticky="nsew", padx=5, pady=5)
        
        #Prepare to Booklet PrintJob
        self.booklet_print = tk.Button(self, text="Prepare PDF to Booklet")
        self.booklet_print.grid(row=4, column=1, sticky="nsew", padx=5, pady=5)

        #Resize PDF
        self.resize_pdf = tk.Button(self, text="Resize PDF")
        self.resize_pdf.grid(row=5, column=1, sticky="nsew", padx=5, pady=5)

        #Select size PDF
        self.combo_size = ttk.Combobox(
            self,
            state="readonly",
            values = ["A1","A2","A3","A4","A5","A6"]
        )
        self.combo_size.grid(row=6, column=1, sticky="nsew", padx=5, pady=5)

        #Canva Draw
        self.pdf_display = tk.Canvas(self, width=image_escale *148, height=image_escale *210, background="white")
        self.pdf_display.grid(row=2, column=0, padx=5, pady=5, rowspan=10)
        self.pdf_display.bind('<ButtonPress-1>', self.draw_line)
        self.pdf_display.bind('<ButtonRelease-1>', self.end_draw)
        self.pdf_display.bind("<Motion>", self.update_position)
        self.icon_size = tk.Label(self)
        self.change_image(os.getcwd() + '/images/placeholder_pdf.png')

        #Clear Canva
        self.clea_pdf_display = tk.Button(self, text='Clear Lines', command=lambda: self.pdf_display.delete('lines'))
        self.clea_pdf_display.grid(row=7, column=1, sticky="nsew", padx=5, pady=5)
        
    def open_file_dialog(self):
        file_path = filedialog.askopenfilename(initialdir="/home/cristoalvarado/Documents/Books To Print/", title="Select a PDF", filetypes=[("PDF", "*.pdf"), ("All files", "*.*")])
        if file_path:
            self.direct_entry.config(text = f"{file_path}")
            self.show_pdf(file_path)

    def show_pdf(self, file_path):
        png_path = os.getcwd()+'/aux/aux.png'
        pm.showcase_pdf(file_path, png_path)

        #Change frame image
        self.change_image(png_path)

    def show_pdf_to_crop(self):
        file_path=self.direct_entry.cget('text')
        global pdf_selected
        pdf_selected=True
        aux_path = os.getcwd()+'/aux/aux.pdf'
        png_path = os.getcwd()+'/aux/aux.png'
        pm.overlay_pdf(file_path,aux_path)
        pm.pdf_to_png(aux_path,png_path)

        #Change frame image
        self.change_image(png_path)

    def change_image(self, png_path):
        self.img = Image.open(png_path)
        self.img = self.img.resize((image_escale *148,image_escale *210))
        self.img = ImageTk.PhotoImage(self.img)
        self.pdf_display.delete('all')
        self.pdf_display.create_image(0,0, anchor = 'nw', image = self.img)

    def refresh(self):
        self.destroy()
        self.__init__(self.master)

    def draw_line(self, event):
        global pdf_selected
        global click_num
        global x1, y1
        if click_num == 0 and pdf_selected:
            self.pdf_display.delete('lines')
            x1 = event.x
            y1 = event.y
            click_num = 1

    def update_position(self, event):
        global pdf_selected
        global click_num
        global x1, y1, x2, y2
        if click_num == 1 and pdf_selected:
            x2 = event.x
            y2 = event.y
            if x2 < 0: x2 = 0
            if x2 > image_escale *148: x2 = image_escale *148
            if y2 < 0: y2 = 0
            if y2 > image_escale *210: y2 = image_escale *210
            self.pdf_display.delete('lines')
            self.pdf_display.create_rectangle(x1, y1, x2, y2, fill="lightblue", width=3, tags='lines', outline='#2bebf9', stipple='gray50')

    def end_draw(self, event):
        global pdf_selected
        if pdf_selected:
            global click_num
            click_num = 0
        

if __name__ == "__main__":
    
    #Window configuration
    root = tk.Tk()
    screen_height = root.winfo_screenheight()
    screen_width = root.winfo_screenwidth()
    root.geometry(f"{window_width}x{window_height}+{int((screen_width - window_width)/2)}+{int((screen_height-window_height)/2)}")
    root.title("Python Booklet Project")
    root.positionfrom()

    #Window Init
    myapp = App(root)
    myapp.grid(row=1, column=1)
    myapp.columnconfigure(0, weight=1)
    myapp.columnconfigure(1, weight=2)
    root.mainloop()