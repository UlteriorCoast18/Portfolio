import tkinter as tk
import sqlite3
import requests
from io import BytesIO
from tkinter import messagebox, ttk, filedialog
from screeninfo import get_monitors
import subprocess
from multiprocessing import Process

listaAutores = []
listaCategorias = []
listaEditoriales = []

listaAutoresId = []
listaCategoriasId = []
listaEditorialesId = []

def get_screen_size():
    monitors = get_monitors()
    if monitors:
        return monitors[0].width, monitors[0].height
    return 0

def addAutor(event):
    nom_aut = aut_entry.get()
    if nom_aut != '':
        conexion = sqlite3.connect("/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db", isolation_level=None)
        try:
            conexion.execute('insert into Autor(nom_aut) values(?);', (nom_aut,))
            aut_entry.delete(0,tk.END)
            messagebox.showinfo('Añadir Autor', 'Autor '+nom_aut+' añadido a la base de datos')
            getAutors()
        except sqlite3.OperationalError:
            messagebox.showwarning('Añadir Autor', 'No fue posible añadir el autor a la base de datos')          
        conexion.close()
    else:
        messagebox.showwarning('Añadir Autor', 'Coloque nombre del autor')
    borrarEntriesLibro()

def addCategoria(event):
    nom_cat = cat_entry.get()
    if nom_cat != '':
        conexion = sqlite3.connect("/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db", isolation_level=None)
        try:
            conexion.execute('insert into Categoria(nom_cat) values(?);', (nom_cat,))
            cat_entry.delete(0,tk.END)
            messagebox.showinfo('Añadir Categoria', 'Categoria '+nom_cat+' añadido a la base de datos')
            getCategorias()
        except sqlite3.OperationalError:
            messagebox.showwarning('Añadir Categoria', 'No fue posible añadir la categoria a la base de datos')          
        conexion.close()
    else:
        messagebox.showwarning('Añadir Categoria', 'Coloque nombre de la categoria')
    borrarEntriesLibro()

def addEditorial(event):
    nom_edt = edt_entry.get()
    if nom_edt != '':
        conexion = sqlite3.connect("/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db", isolation_level=None)
        try:
            conexion.execute('insert into Editorial(nom_edit) values(?);', (nom_edt,))
            edt_entry.delete(0,tk.END)
            messagebox.showinfo('Añadir Editorial', 'Editorial '+nom_edt+' añadido a la base de datos')
            getEditoriales()
        except sqlite3.OperationalError:
            messagebox.showwarning('Añadir Editorial', 'No fue posible añadir la editorial a la base de datos')          
        conexion.close()
    else:
        messagebox.showwarning('Añadir Editorial', 'Coloque nombre de la editorial')
    borrarEntriesLibro()

def getAutors():
    deleteAllAutoresList()
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    try:
        cursor = conexion.execute('select id_aut,nom_aut from Autor;')
        for fila in cursor:
            aut_list.insert('', tk.END, text = fila[0], values = (fila[1],))
    except sqlite3.OperationalError:
        messagebox.showwarning('Añadir Autor', 'No fue posible consultar los autores de la base de datos')          
    conexion.close()

def getCategorias():
    deleteAllCategoriasList()
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    try:
        cursor = conexion.execute('select id_cat,nom_cat from Categoria;')
        for fila in cursor:
            cat_list.insert('', tk.END, text = fila[0], values = (fila[1],))
    except sqlite3.OperationalError:
        messagebox.showwarning('Añadir Categoria', 'No fue posible consultar las categorias de la base de datos')          
    conexion.close()

def getEditoriales():
    deleteAllEditorialesList()
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    try:
        cursor = conexion.execute('select id_edit,nom_edit from Editorial;')
        for fila in cursor:
            edt_list.insert('', tk.END, text = fila[0], values = (fila[1],))
    except sqlite3.OperationalError:
        messagebox.showwarning('Añadir Editorial', 'No fue posible consultar las categorias de la base de datos')          
    conexion.close()

def deleteAllAutoresList():
    if aut_list.get_children():
        for item in aut_list.get_children():
            aut_list.delete(item)

def deleteAllCategoriasList():
    if cat_list.get_children():
        for item in cat_list.get_children():
            cat_list.delete(item)

def deleteAllEditorialesList():
    if edt_list.get_children():
        for item in edt_list.get_children():
            edt_list.delete(item)

def showAutorInfo(event):
    item_sel = aut_list.focus()
    if item_sel:
        item = aut_list.item(item_sel)
        optionsWindow('Autor', item)

def showCategoriaInfo(event):
    item_sel = cat_list.focus()
    if item_sel:
        item = cat_list.item(item_sel)
        optionsWindow('Categoria', item)

def showEditorialInfo(event):
    item_sel = edt_list.focus()
    if item_sel: 
        item = edt_list.item(item_sel)
        optionsWindow('Editorial', item)

def optionsWindow(type, info):
    nWindow = tk.Toplevel()
    nWindow.iconphoto(False, p1)
    nWindow.geometry(f'{int(width/2)}x{int(height/20)}+{int(width/4)}+{int(2*height/5)}')
    n_entry = tk.Entry(nWindow)
    nWindow.columnconfigure(0, weight=10)
    nWindow.columnconfigure(1, weight=1)
    nWindow.columnconfigure(2, weight=1)
    nWindow.columnconfigure(3, weight=1)
    nWindow.rowconfigure(0, weight=1)
    del_button = tk.Button(master = nWindow,
                           text = 'Eliminar',
                            width = 0,
                            height = 0,
                            bg = 'Red',
                            fg = 'white',
                            command = None)
    edt_button = tk.Button(master = nWindow,
                           text = 'Editar',
                            width = 0,
                            height = 0,
                            bg = 'yellow',
                            fg = 'black',
                            command = None)
    can_button = tk.Button(master = nWindow,
                           text = 'Cancelar',
                            width = 0,
                            height = 0,
                            bg = 'Dimgray',
                            fg = 'white',
                            command = lambda: nWindow.destroy())
    n_entry.grid(row = 0, column = 0, sticky='nswe')
    del_button.grid(row = 0, column = 1, sticky='nswe')
    edt_button.grid(row = 0, column = 2, sticky='nswe')
    can_button.grid(row = 0, column = 3, sticky='nswe')
    id = info.get('text')
    nom = info.get('values')[0]
    n_entry.insert(0, nom)
    if type == 'Autor':
        nWindow.title('Ver Autor')
        del_button.configure(command = lambda: cBorrar(id, 'Autor', nWindow))
        edt_button.configure(command = lambda: cEditar(id, n_entry, 'Autor', nWindow))
    if type == 'Categoria':
        nWindow.title('Ver Categoria')
        del_button.configure(command = lambda: cBorrar(id, 'Categoria', nWindow))
        edt_button.configure(command = lambda: cEditar(id, n_entry, 'Categoria', nWindow))
    if type == 'Editorial':
        nWindow.title('Ver Editorial')
        del_button.configure(command = lambda: cBorrar(id, 'Editorial', nWindow))
        edt_button.configure(command = lambda: cEditar(id, n_entry, 'Editorial', nWindow))
    nWindow.mainloop()

def cBorrar(id, type, window):
    cont = 0
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    try:
        if type == 'Autor':
            cursor = conexion.execute('SELECT id_lib FROM Lib_Aut WHERE id_aut = ?;', (int(id),))
            for fila in cursor:
                cont += 1
            if cont == 0:
                conexion.execute('DELETE FROM Autor where id_aut = '+str(id)+';')
            window.destroy()
            getAutors()
        if type == 'Categoria':
            cursor = conexion.execute('SELECT id_lib FROM Lib_Cat WHERE id_cat = ?;', (int(id),))
            for fila in cursor:
                cont += 1
            if cont == 0:
                conexion.execute('DELETE FROM Categoria where id_cat = '+str(id)+';')
            window.destroy()
            getCategorias()
        if type == 'Editorial':
            cursor = conexion.execute('SELECT * FROM Libro WHERE id_edit = ?;', (int(id),))
            for fila in cursor:
                cont += 1
            if cont == 0:
                conexion.execute('DELETE FROM Editorial where id_edit = '+str(id)+';')
            window.destroy()
            getEditoriales()
    except sqlite3.OperationalError:
        if type == 'Autor':
            messagebox.showwarning('Borrar Autor','No fue posible eliminar al autor')
        if type == 'Categoria':
            messagebox.showwarning('Borrar Categoria','No fue posible eliminar la categoria')
        if type == 'Editorial':
            messagebox.showwarning('Borrar Editorial','No fue posible eliminar la editorial')
    conexion.close()
    borrarEntriesLibro()

def cEditar(id, entry, type, window):
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    nom = entry.get()
    try:
        if type == 'Autor':
            conexion.execute('UPDATE Autor SET nom_aut = "'+nom+'" WHERE id_aut = '+str(id)+';')
            window.destroy()
            getAutors()
        if type == 'Categoria':
            conexion.execute('UPDATE Categoria SET nom_cat = "'+nom+'" WHERE id_cat = '+str(id)+';')
            window.destroy()
            getCategorias()
        if type == 'Editorial':
            conexion.execute('UPDATE Editorial SET nom_edit = "'+nom+'" WHERE id_edit = '+str(id)+';')
            window.destroy()
            getEditoriales()
    except sqlite3.OperationalError:
        if type == 'Autor':
            messagebox.showwarning('Editar Autor','No fue posible editar al autor')
        if type == 'Categoria':
            messagebox.showwarning('Editar Categoria','No fue posible editar la categoria')
        if type == 'Editorial':
            messagebox.showwarning('Editar Editorial','No fue posible editar la editorial')
    conexion.close()
    borrarEntriesLibro()

def buscarAutor(event):
    nom = aut_sear.get()
    if nom == '':
        getAutors()
    else:
        deleteAllAutoresList()
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_aut, nom_aut FROM Autor WHERE nom_aut LIKE ? OR id_aut LIKE ?;',('%'+nom+'%','%'+nom+'%',))
            for fila in cursor:
                aut_list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Autor', 'No fue posible consultar los autores de la base de datos')
        conexion.close()

def buscarCategoria(event):
    nom = cat_sear.get()
    if nom == '':
        getCategorias()
    else:
        deleteAllCategoriasList()
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_cat, nom_cat FROM Categoria WHERE nom_cat LIKE ? OR id_cat LIKE ?;',('%'+nom+'%','%'+nom+'%',))
            for fila in cursor:
                cat_list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Categoria', 'No fue posible consultar las categorias de la base de datos')
        conexion.close()

def buscarEditorial(event):
    nom = edt_sear.get()
    if nom == '':
        getEditoriales()
    else:
        deleteAllEditorialesList()
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_edit, nom_edit FROM Editorial WHERE nom_edit LIKE ? OR id_edit LIKE ?;',('%'+nom+'%','%'+nom+'%',))
            for fila in cursor:
                edt_list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Editorial', 'No fue posible consultar las editoriales de la base de datos')
        conexion.close()

def addBook(event):
    nWindow = tk.Toplevel()
    nWindow.iconphoto(False, p1)
    nWindow.geometry(f'{int(width/2)}x{int(height/2)}+{int(width/4)}+{int(height/4)}')
    nWindow.title('Añadir Libro')

    nWindow.columnconfigure(0, weight = 0)
    nWindow.columnconfigure(1, weight = 1)
    nWindow.columnconfigure(2, weight = 1)
    nWindow.columnconfigure(3, weight = 1)

    nWindow.rowconfigure(10, weight=1)

    #Entries
    nWEntryNombreLibro = tk.Entry(master = nWindow)
    nWEntryNombreLibro.grid(row = 0, column = 1, sticky='nswe', columnspan=3)
    nWEntryPagsLibro = tk.Entry(master = nWindow)
    nWEntryPagsLibro.grid(row = 1, column = 1, sticky='nswe', columnspan=1)
    nWEntryEdicionLibro = tk.Entry(master = nWindow)
    nWEntryEdicionLibro.grid(row = 1, column = 3, sticky='nswe', columnspan=1)

    nWEntryBuscarAutor = tk.Entry(master = nWindow)
    nWEntryBuscarAutor.grid(row = 4, column = 1, sticky='nswe')
    nWEntryBuscarAutor.bind('<KeyRelease>', lambda event, obj = nWEntryBuscarAutor: searchAutors(event, nWEntryBuscarAutor, nWaut_list))
    
    nWEntryBuscarCategoria = tk.Entry(master = nWindow)
    nWEntryBuscarCategoria.grid(row = 4, column = 2, sticky='nswe')
    nWEntryBuscarCategoria.bind('<KeyRelease>', lambda event, obj = nWEntryBuscarCategoria: searchCategorias(event, nWEntryBuscarCategoria, nWcat_list))

    nWEntryBuscarEditorial = tk.Entry(master = nWindow)
    nWEntryBuscarEditorial.grid(row = 4, column = 3, sticky='nswe')
    nWEntryBuscarEditorial.bind('<KeyRelease>', lambda event, obj = nWEntryBuscarEditorial: searchEditoriales(event, nWEntryBuscarEditorial, nWedt_list))
    
    nWEntryVolumen = tk.Entry(master = nWindow)
    #nWEntryVolumen.grid(row = 7, column=3, sticky='nswe')
    nWEntryISBN = tk.Entry(master = nWindow)
    nWEntryISBN.grid(row = 9, column=1, columnspan=3, sticky='nswe')

    nWLabelAutoresSel = tk.Entry(master = nWindow, state = 'readonly', textvariable=tk.StringVar(value = 'Autores seleccionados:'))
    nWLabelAutoresSel.grid(row = 10, column=1, sticky='nswe')
    nWLabelCategoriasSel = tk.Entry(master = nWindow, textvariable=tk.StringVar(value = 'Categorias seleccionadas: '), state = 'readonly')
    nWLabelCategoriasSel.grid(row = 10, column=2, sticky='nswe')
    nWLabelEditorialesSel = tk.Entry(master = nWindow, textvariable=tk.StringVar(value = 'Editoriales seleccionadas: '), state = 'readonly')
    nWLabelEditorialesSel.grid(row = 10, column=3, sticky='nswe')

    #scrolls
    scroll1 = tk.Scrollbar(master=nWindow, orient='horizontal', command = nWLabelAutoresSel.xview)
    nWLabelAutoresSel.config(xscrollcommand=scroll1.set)
    scroll1.grid(row = 11, column = 1, sticky='nswe')

    scroll2 = tk.Scrollbar(master=nWindow, orient='horizontal', command = nWLabelCategoriasSel.xview)
    nWLabelCategoriasSel.config(xscrollcommand=scroll2.set)
    scroll2.grid(row = 11, column = 2, sticky='nswe')

    scroll3 = tk.Scrollbar(master=nWindow, orient='horizontal', command = nWLabelEditorialesSel.xview)
    nWLabelEditorialesSel.config(xscrollcommand=scroll3.set)
    scroll3.grid(row = 11, column = 3, sticky='nswe')

    #Labels
    nWLabelNombreLibro = tk.Label(master = nWindow, text = 'Nombre del libro:', anchor = 'e')
    nWLabelNombreLibro.grid(row = 0, column = 0, sticky='nswe')
    nWLabelPagsLibro = tk.Label(master = nWindow, text = 'Número de páginas:', anchor = 'e')
    nWLabelPagsLibro.grid(row = 1, column = 0, sticky='nswe')
    nWLabelEdicionLibro = tk.Label(master = nWindow, text = 'Edición:', anchor = 'e')
    nWLabelEdicionLibro.grid(row = 1, column = 2, sticky='nswe')
    nWLabelDirectorioLibro = tk.Label(master = nWindow, text = 'Haga click en el botón para elegir dirección del libro')
    nWLabelDirectorioLibro.grid(row = 2, column = 1, sticky='nswe', columnspan= 3)
    nWLabelNumeroVolumen = tk.Label(master = nWindow, text = 'Número de Volumen:', anchor = 'e')
    #nWLabelNumeroVolumen.grid(row = 7, column = 2, sticky='nswe')
    nWLabelISBN = tk.Label(master = nWindow, text = 'Número ISBN: ', anchor = 'e')
    nWLabelISBN.grid(row = 9, column = 0, sticky='nswe')
    
    #Listas
    nWaut_list = ttk.Treeview(master = nWindow, columns = ('nom_aut'))
    nWaut_list.heading('#0', text = 'Id')
    nWaut_list.heading('nom_aut', text = 'Autor')
    nWaut_list.column('#0', anchor='center', stretch=True, width=30)
    nWcat_list = ttk.Treeview(master = nWindow, columns = ('nom_cat'))
    nWcat_list.heading('#0', text = 'Id')
    nWcat_list.heading('nom_cat', text = 'Categoria')
    nWcat_list.column('#0', anchor='center', stretch=True, width=30)
    nWedt_list = ttk.Treeview(master = nWindow, columns = ('nom_edt'))
    nWedt_list.heading('#0', text = 'Id')
    nWedt_list.heading('nom_edt', text = 'Editorial')
    nWedt_list.column('#0', anchor='center', stretch=True, width=30)

    #checkbox

    var = tk.IntVar()
    c1 = tk.Checkbutton(nWindow, text='¿Es parte de un volumen?', onvalue=1, offvalue=0, variable = var, command=lambda: showHideVolume(var, nWLabelNumeroVolumen, nWEntryVolumen))
    c1.grid(row = 8, column = 1, sticky='nswe')

    #Buttons
    nWButtonDirectorio = tk.Button(master = nWindow,
                                text = 'Elegir directorio',
                                width = 0,
                                height = 0,
                                bg = 'DimGray',
                                fg = 'white',
                                command = lambda: addDirectory(nWLabelDirectorioLibro, nWindow))
    nWButtonDirectorio.grid(row = 2, column=0, sticky='nswe')
    nWButtonAddAutor = tk.Button(master = nWindow,
                                text = 'Añadir Autor/es',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addVariable(nWaut_list, nWLabelAutoresSel, 'Autor'))
    nWButtonAddAutor.grid(row = 6, column=1, sticky='nswe')
    nWButtonAddCategoria = tk.Button(master = nWindow,
                                text = 'Añadir Categoria/s',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addVariable(nWcat_list, nWLabelCategoriasSel, 'Categoria'))
    nWButtonAddCategoria.grid(row = 6, column=2, sticky='nswe')
    nWButtonAddEditorial = tk.Button(master = nWindow,
                                text = 'Añadir Editorial',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addVariable(nWedt_list, nWLabelEditorialesSel, 'Editorial'))
    nWButtonAddEditorial.grid(row = 6, column=3, sticky='nswe')
    
    nWButtonDeleteAutor = tk.Button(master = nWindow,
                                text = 'Eliminar Autor',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command = lambda: deleteVariable(nWaut_list, nWLabelAutoresSel, 'Autor'))
    nWButtonDeleteAutor.grid(row = 7, column=1, sticky='nswe')
    nWButtonDeleteCategoria = tk.Button(master = nWindow,
                                text = 'Eliminar Categoria',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command = lambda: deleteVariable(nWcat_list, nWLabelCategoriasSel, 'Categoria'))
    nWButtonDeleteCategoria.grid(row = 7, column=2, sticky='nswe')
    nWButtonDeleteEditorial = tk.Button(master = nWindow,
                                text = 'Eliminar Editorial',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command = lambda: deleteVariable(nWedt_list, nWLabelEditorialesSel, 'Editorial'))
    nWButtonDeleteEditorial.grid(row = 7, column=3, sticky='nswe')
    
    nWButtonAddLibro = tk.Button(master = nWindow,
                                text = 'Añadir Libro',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addFunction(nWindow, nWEntryNombreLibro.get(), nWEntryPagsLibro.get(), nWEntryEdicionLibro.get(), nWLabelDirectorioLibro.cget('text'), var.get(), nWEntryVolumen.get(), nWEntryISBN.get()))
    nWButtonAddLibro.grid(row = 12, column=2, columnspan=2, sticky='nswe')
    nWButtonCancel= tk.Button(master = nWindow,
                                text = 'Cancelar',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command= lambda: cancelFunction(nWindow))
    nWButtonCancel.grid(row = 12, column=0, columnspan=2, sticky='nswe')

    nWaut_list.grid(row = 5, column= 1, sticky='nswe')
    nWcat_list.grid(row = 5, column= 2, sticky='nswe')
    nWedt_list.grid(row = 5, column= 3, sticky='nswe')
    
    #Funciones de inicio
    
    searchAutors(event, nWEntryBuscarAutor, nWaut_list)
    searchCategorias(event, nWEntryBuscarCategoria, nWcat_list)
    searchEditoriales(event, nWEntryBuscarEditorial, nWedt_list)

    nWindow.bind('<Destroy>', lambda event: onDestroy())
    nWindow.mainloop()

def onDestroy():
    getLibros('', '', '', '', '', lib_list)
    listaAutores.clear()
    listaCategorias.clear()
    listaEditoriales.clear()
    listaAutoresId.clear()
    listaCategoriasId.clear()
    listaEditorialesId.clear()

def showHideVolume(var, label, entry):
    value = var.get()
    if value:
        label.grid(row = 8, column = 2, sticky='nswe')
        entry.grid(row = 8, column=3, sticky='nswe')
    else:
        label.grid_remove()
        entry.grid_remove()

def cancelFunction(window):
    res = messagebox.askyesno(title = 'Confirm', message='¿Está seguro que quiere cancelar el añadir?')
    if res:
        window.destroy()
    else:
        window.focus_force()
        window.lift()

def cancelFunctionEdit(window):
    res = messagebox.askyesno(title = 'Confirm', message='¿Está seguro que quiere cancelar la edición?')
    if res:
        window.destroy()
    else:
        window.focus_force()
        window.lift()

def addFunction(window, nom_lib, num_pag, ed_lib, dir_lib, par_vol, vol_lib, isbn_lib):
    res = messagebox.askyesno(title = 'Añadir Libro', message='¿Está seguro que quiere añadir el libro?')
    if res:
        #checamos que nada esté vacío.
        if nom_lib != '' and num_pag != '' and ed_lib != 'Haga click en el botón para elegir dirección del libro' and dir_lib != '' and listaAutores != [] and listaCategorias != [] and listaEditoriales != []:
            conexion = sqlite3.connect("/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db", isolation_level=None)
            if not par_vol: 
                vol_lib = 0
            try:
                conexion.execute('INSERT INTO Libro(nom_lib, num_pag, dir_lib, ed_lib, par_vol, vol_lib, id_edit, isbn_lib) VALUES(?,?,?,?,?,?,?,?);', (nom_lib, int(num_pag), dir_lib, int(ed_lib), int(par_vol), int(vol_lib), int(listaEditorialesId[0]), isbn_lib, ))
                cursor = conexion.execute('SELECT id_lib FROM Libro WHERE nom_lib = ? AND dir_lib = ?', (nom_lib,dir_lib,))
                for fila in cursor:
                    id_lib = fila[0]
                for id_aut in listaAutoresId:
                    conexion.execute('INSERT INTO Lib_Aut(id_lib, id_aut) VALUES(?,?);', (int(id_lib), id_aut))
                for id_cat in listaCategoriasId:
                    conexion.execute('INSERT INTO Lib_Cat(id_lib, id_cat) VALUES(?,?);', (int(id_lib), id_cat))
                messagebox.showinfo('Añadir Libro', 'Libro '+nom_lib+' añadido a la base de datos')
            except sqlite3.OperationalError as e:
                print(f'Error: {e}')
                messagebox.showwarning('Añadir Libro', 'No fue posible añadir el libro a la base de datos')
            conexion.close()
            window.destroy()
        else:
            messagebox.showerror(title = 'Error', message='No fue posible añadir el libro a la base de datos')
            window.focus_force()
            window.lift()
    else:
        window.focus_force()
        window.lift()
    borrarEntriesLibro()

def addDirectory(label, window):
    filetypes = (('all files', '*.*'), ('pdf', '*.pdf'), ('epub', '*.epub'), ('djuv', '*.djuv'))
    filename = filedialog.askopenfilename(title = 'Seleccionar Archivo', initialdir = '/home/cristodanielalvarado/Documentos/Libros/Drive Books/', filetypes = filetypes)
    if filename != '':
        label.config(text = filename)
    else:
        label.config(text = 'Haga click en el botón para elegir dirección del libro')
    window.focus_force()
    window.lift()

def searchAutors(event, entry, list):
    nom = entry.get()
    borrarLista(list)
    if entry.get() == '':    
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_aut,nom_aut FROM Autor;')
            for fila in cursor:
                list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Autor', 'No fue posible consultar los autores de la base de datos')
        conexion.close()
    else:
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_aut,nom_aut FROM Autor WHERE nom_aut LIKE ? OR id_aut LIKE ?;', ('%'+nom+'%','%'+nom+'%',))
            for fila in cursor:
                list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Autor', 'No fue posible consultar los autores de la base de datos')
        conexion.close()

def searchCategorias(event, entry, list):
    nom = entry.get()
    borrarLista(list)
    if entry.get() == '':    
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_cat,nom_cat FROM Categoria;')
            for fila in cursor:
                list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Categoria', 'No fue posible consultar las categorias de la base de datos')
        conexion.close()
    else:
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_cat,nom_cat FROM Categoria WHERE nom_cat LIKE ? OR id_cat LIKE ?;', ('%'+nom+'%','%'+nom+'%',))
            for fila in cursor:
                list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Categoria', 'No fue posible consultar las categorias de la base de datos')
        conexion.close()

def searchEditoriales(event, entry, list):
    nom = entry.get()
    borrarLista(list)
    if entry.get() == '':
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_edit,nom_edit FROM Editorial;')
            for fila in cursor:
                list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Editorial', 'No fue posible consultar las editoriales de la base de datos')
        conexion.close()
    else:
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT id_edit,nom_edit FROM Editorial WHERE nom_edit LIKE ? OR id_edit LIKE ?;', ('%'+nom+'%','%'+nom+'%',))
            for fila in cursor:
                list.insert('', tk.END, text = fila[0], values = (fila[1],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Editorial', 'No fue posible consultar las editoriales de la base de datos')
        conexion.close()

def addVariable(list, label, text):
    for selected_item in list.selection():
        item = list.item(selected_item)
        if text == 'Autor':
            if item['text'] not in listaAutoresId:
                listaAutoresId.append(item['text'])
                listaAutores.append(item['values'][0])
            escribirLabel(label, 'Autor')
        if text == 'Categoria':
            if item['text'] not in listaCategoriasId:
                listaCategoriasId.append(item['text'])
                listaCategorias.append(item['values'][0])
            escribirLabel(label, 'Categoria')
        if text == 'Editorial':
            if item['text'] not in listaEditorialesId:
                listaEditorialesId.append(item['text'])
                listaEditoriales.append(item['values'][0])
            escribirLabel(label, 'Editorial')

def deleteVariable(list, label, text):
    for selected_item in list.selection():
        item = list.item(selected_item)
        if text == 'Autor':
            if item['text'] in listaAutoresId:
                listaAutoresId.remove(item['text'])
                listaAutores.remove(item['values'][0])
            escribirLabel(label, 'Autor')
        if text == 'Categoria':
            if item['text'] in listaCategoriasId:
                listaCategoriasId.remove(item['text'])
                listaCategorias.remove(item['values'][0])
            escribirLabel(label, 'Categoria')
        if text == 'Editorial':
            if item['text'] in listaEditorialesId:
                listaEditorialesId.remove(item['text'])
                listaEditoriales.remove(item['values'][0])
            escribirLabel(label, 'Editorial')

def escribirLabel(entry, text):
    var = ''
    if text == 'Autor':
        if listaAutoresId == []:
            entry.config(textvariable=tk.StringVar(value = 'Autores seleccionados: '))
        else:
            for item in listaAutores:
                var += str(item) + ', '
            var = var[:-2]
            entry.config(textvariable=tk.StringVar(value = 'Autores seleccionados: '+var))
    if text == 'Categoria':
        if listaCategoriasId == []:
            entry.config(textvariable=tk.StringVar(value = 'Categorias seleccionadas: '))
        else:
            for item in listaCategorias:
                var += str(item) + ', '
            var = var[:-2]
            entry.config(textvariable=tk.StringVar(value = 'Categorias seleccionadas: '+var))
    if text == 'Editorial':
        if listaEditorialesId == []:
            entry.config(textvariable=tk.StringVar(value = 'Editoriales seleccionadas: '))
        else:
            for item in listaEditoriales:
                var += str(item) + ', '
            var = var[:-2]
            entry.config(textvariable=tk.StringVar(value = 'Editoriales seleccionadas: '+var))

def borrarLista(list):
    if list.get_children():
        for item in list.get_children():
            list.delete(item)

def getLibros(nombre, autor, editorial, isbn, categoria, list):
    borrarLista(list)
    vol = ''
    if nombre == autor == editorial == isbn == categoria == '':
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT * FROM Libro;')
            for fila in cursor:
                autores, categorias, editoriales = getAutorsCategoriesEditorial(int(fila[0]), int(fila[7]))
                if fila[5] == 1:
                    vol = fila[6]
                else:
                    vol = ''
                lib_list.insert('', tk.END, text = fila[0], values = (fila[1], autores, fila[2], categorias, editoriales, vol, fila[4], fila[8], fila[3],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Libros', 'No fue posible consultar los libros de la base de datos')
        conexion.close()
    elif nombre != '':
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT * FROM Libro WHERE nom_lib LIKE ?;',('%'+nombre+'%',))
            for fila in cursor:
                autores, categorias, editoriales = getAutorsCategoriesEditorial(int(fila[0]), int(fila[7]))
                if fila[5] == 1:
                    vol = fila[6]
                else:
                    vol = ''
                lib_list.insert('', tk.END, text = fila[0], values = (fila[1], autores, fila[2], categorias, editoriales, vol, fila[4], fila[8], fila[3],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Libros', 'No fue posible consultar los libros de la base de datos')
        conexion.close()
    elif editorial != '':
        id_libs = []
        id_edts = []
        var = '('
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            #encontramos al autor en la base de datos
            cursor = conexion.execute('SELECT * FROM Editorial WHERE nom_edit LIKE ?;', ('%'+editorial+'%',))
            for fila in cursor:
                if fila[0] not in id_edts:
                    id_edts.append(fila[0])
            if id_edts != []:
                #basta con sacar las id de los libros
                for id in id_edts:
                    var += str(id) + ', '
                var = var[:-2] + ')'
                cursor = conexion.execute('SELECT * FROM Libro WHERE id_edit IN ' + var + ';')
                for fila in cursor:
                    autores, categorias, editoriales = getAutorsCategoriesEditorial(int(fila[0]), int(fila[7]))
                    if fila[5] == 1:
                        vol = fila[6]
                    else:
                        vol = ''
                    lib_list.insert('', tk.END, text = fila[0], values = (fila[1], autores, fila[2], categorias, editoriales, vol, fila[4], fila[8], fila[3],))
        except sqlite3.OperationalError as e:
            print(e)
            messagebox.showwarning('Buscar Libros', 'No fue posible consultar los libros de la base de datos')
        conexion.close()
    elif autor != '':
        id_auts = []
        id_libs = []
        var = '('
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            #encontramos al autor en la base de datos
            cursor = conexion.execute('SELECT * FROM Autor WHERE nom_aut LIKE ?;', ('%'+autor+'%',))
            for fila in cursor:
                if fila[0] not in id_auts:
                    id_auts.append(fila[0])
            if id_auts != []:
                #tenemos las id de los autores en la base de datos, falta sacar las id de los libros
                for id in id_auts:
                    cursor = conexion.execute('SELECT * FROM Lib_Aut WHERE id_aut = ?;', (int(id),))
                    for fila in cursor:
                        if fila[0] not in id_libs:
                            id_libs.append(fila[0])
                if id_libs != []:
                    for id in id_libs:
                        var += str(id) + ', '
                    var = var[:-2] + ')'
                    #ahora con las ids de los libros, hacemos consulta en la BD para sacar las id de los libros
                    cursor = conexion.execute('SELECT * FROM Libro WHERE id_lib IN ' + var + ';')
                    for fila in cursor:
                        autores, categorias, editoriales = getAutorsCategoriesEditorial(int(fila[0]), int(fila[7]))
                        if fila[5] == 1:
                            vol = fila[6]
                        else:
                            vol = ''
                        lib_list.insert('', tk.END, text = fila[0], values = (fila[1], autores, fila[2], categorias, editoriales, vol, fila[4], fila[8], fila[3],))
        except sqlite3.OperationalError as e:
            print(e)
            messagebox.showwarning('Buscar Libros', 'No fue posible consultar los libros de la base de datos')
        conexion.close()
    elif isbn != '':
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            cursor = conexion.execute('SELECT * FROM Libro WHERE isbn_lib LIKE ?;',('%'+isbn+'%',))
            for fila in cursor:
                autores, categorias, editoriales = getAutorsCategoriesEditorial(int(fila[0]), int(fila[7]))
                if fila[5] == 1:
                    vol = fila[6]
                else:
                    vol = ''
                lib_list.insert('', tk.END, text = fila[0], values = (fila[1], autores, fila[2], categorias, editoriales, vol, fila[4], fila[8], fila[3],))
        except sqlite3.OperationalError:
            messagebox.showwarning('Buscar Libros', 'No fue posible consultar los libros de la base de datos')
        conexion.close()
    elif categoria != '':
        id_cats = []
        id_libs = []
        var = '('
        conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
        try:
            #encontramos las categorias en la base de datos
            cursor = conexion.execute('SELECT * FROM Categoria WHERE nom_cat LIKE ?;', ('%'+categoria+'%',))
            for fila in cursor:
                if fila[0] not in id_cats:
                    id_cats.append(fila[0])
            if id_cats != []:
                #tenemos las id de las editoriales en la base de datos, falta sacar las id de los libros
                for id in id_cats:
                    cursor = conexion.execute('SELECT * FROM Lib_Cat WHERE id_cat = ?;', (int(id),))
                    for fila in cursor:
                        if fila[0] not in id_libs:
                            id_libs.append(fila[0])
                if id_libs != []:
                    for id in id_libs:
                        var += str(id) + ', '
                    var = var[:-2] + ')'
                    #ahora con las ids de los libros, hacemos consulta en la BD para sacar las id de los libros
                    cursor = conexion.execute('SELECT * FROM Libro WHERE id_lib IN ' + var + ';')
                    for fila in cursor:
                        autores, categorias, editoriales = getAutorsCategoriesEditorial(int(fila[0]), int(fila[7]))
                        if fila[5] == 1:
                            vol = fila[6]
                        else:
                            vol = ''
                        lib_list.insert('', tk.END, text = fila[0], values = (fila[1], autores, fila[2], categorias, editoriales, vol, fila[4], fila[8], fila[3],))
        except sqlite3.OperationalError as e:
            print(e)
            messagebox.showwarning('Buscar Libros', 'No fue posible consultar los libros de la base de datos')
        conexion.close()

def getAutorsCategoriesEditorial(id_lib, id_edit):
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    id_auts = []
    nomAuts = []
    id_cats = []
    nomCats = []
    autores = ''
    categorias = ''
    editoriales = ''
    try:
        #se obtienen los autores y categorias del libro
        cursor = conexion.execute('SELECT * FROM Lib_Aut WHERE id_lib = ?;', (id_lib,))
        for fila in cursor:
            id_auts.append(fila[1])
        cursor = conexion.execute('SELECT * FROM Lib_Cat WHERE id_lib = ?;', (id_lib,))
        for fila in cursor:
            id_cats.append(fila[1])
        #se obtiene el nombre de la editorial
        cursor = conexion.execute('SELECT * FROM Editorial WHERE id_edit = ?;', (id_edit,))
        for fila in cursor:
            nom_edit = fila[1]
        #se obtienen los nombres de los autores y de las categorias
        for id_aut in id_auts:
            cursor = conexion.execute('SELECT * FROM Autor WHERE id_aut = ?;', (id_aut,))
            for fila in cursor:
                nomAuts.append(fila[1])
        for id_cat in id_cats:
            cursor = conexion.execute('SELECT * FROM Categoria WHERE id_cat = ?;', (id_cat,))
            for fila in cursor:
                nomCats.append(fila[1])
        #configuración de texto
        editoriales = nom_edit
        for aut in nomAuts:
            autores += aut + ', '
        autores = autores[:-2]
        for cat in nomCats:
            categorias += cat + ', '
        categorias = categorias[:-2]
    except sqlite3.OperationalError:
        messagebox.showwarning('Buscar datos', 'No fue posible consultar los datos de la base de datos')
    conexion.close()
    return autores, categorias, editoriales

def borrarEntriesLibro():
    lib_bus_nom_entry.delete('0', 'end')
    lib_bus_aut_entry.delete('0', 'end')
    lib_bus_cat_entry.delete('0', 'end')
    lib_bus_isbn_entry.delete('0', 'end')
    lib_bus_edit_entry.delete('0', 'end')
    getLibros('', '', '', '', '', lib_list)

def abrirDocumento(event):
    input_id = lib_list.selection()
    if input_id:
        input_item = lib_list.item(input_id, 'values')
        subprocess.call(['okular', input_item[8]])

def deleteBook():
    input_id = lib_list.selection()
    if input_id:
        res = messagebox.askyesno(title = 'Eliminar Libro', message='¿Está seguro que desea eliminar el libro?')
        if res:
            #eliminar libro
            conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
            id_lib = lib_list.item(input_id, 'text')
            try:
                conexion.execute('DELETE FROM Lib_Aut WHERE id_lib = ?;', (int(id_lib), ))
                conexion.execute('DELETE FROM Lib_Cat WHERE id_lib = ?;', (int(id_lib), ))
                conexion.execute('DELETE FROM Libro WHERE id_lib = ?;', (int(id_lib), ))
            except sqlite3.OperationalError as e:
                print(e)
                messagebox.showwarning('Eliminar Libro', 'No fue posible eliminar el libro de la base de datos')
            conexion.close()
    borrarEntriesLibro()

def editBook():
    input_id = lib_list.selection()
    if input_id:
        editBookE('<Button-1>')

def editBookE(event):
    nWindow = tk.Toplevel()
    nWindow.iconphoto(False, p1)
    nWindow.geometry(f'{int(width/2)}x{int(height/2)}+{int(width/4)}+{int(height/4)}')
    nWindow.title('Editar Libro')

    nWindow.columnconfigure(0, weight = 0)
    nWindow.columnconfigure(1, weight = 1)
    nWindow.columnconfigure(2, weight = 1)
    nWindow.columnconfigure(3, weight = 1)

    nWindow.rowconfigure(10, weight=1)

    #Entries
    nWEntryNombreLibro = tk.Entry(master = nWindow)
    nWEntryNombreLibro.grid(row = 0, column = 1, sticky='nswe', columnspan=3)
    nWEntryPagsLibro = tk.Entry(master = nWindow)
    nWEntryPagsLibro.grid(row = 1, column = 1, sticky='nswe', columnspan=1)
    nWEntryEdicionLibro = tk.Entry(master = nWindow)
    nWEntryEdicionLibro.grid(row = 1, column = 3, sticky='nswe', columnspan=1)

    nWEntryBuscarAutor = tk.Entry(master = nWindow)
    nWEntryBuscarAutor.grid(row = 4, column = 1, sticky='nswe')
    nWEntryBuscarAutor.bind('<KeyRelease>', lambda event, obj = nWEntryBuscarAutor: searchAutors(event, nWEntryBuscarAutor, nWaut_list))
    
    nWEntryBuscarCategoria = tk.Entry(master = nWindow)
    nWEntryBuscarCategoria.grid(row = 4, column = 2, sticky='nswe')
    nWEntryBuscarCategoria.bind('<KeyRelease>', lambda event, obj = nWEntryBuscarCategoria: searchCategorias(event, nWEntryBuscarCategoria, nWcat_list))

    nWEntryBuscarEditorial = tk.Entry(master = nWindow)
    nWEntryBuscarEditorial.grid(row = 4, column = 3, sticky='nswe')
    nWEntryBuscarEditorial.bind('<KeyRelease>', lambda event, obj = nWEntryBuscarEditorial: searchEditoriales(event, nWEntryBuscarEditorial, nWedt_list))
    
    nWEntryVolumen = tk.Entry(master = nWindow)
    #nWEntryVolumen.grid(row = 7, column=3, sticky='nswe')
    nWEntryISBN = tk.Entry(master = nWindow)
    nWEntryISBN.grid(row = 9, column=1, columnspan=3, sticky='nswe')

    nWLabelAutoresSel = tk.Entry(master = nWindow, state = 'readonly', textvariable=tk.StringVar(value = 'Autores seleccionados:'))
    nWLabelAutoresSel.grid(row = 10, column=1, sticky='nswe')
    nWLabelCategoriasSel = tk.Entry(master = nWindow, textvariable=tk.StringVar(value = 'Categorias seleccionadas: '), state = 'readonly')
    nWLabelCategoriasSel.grid(row = 10, column=2, sticky='nswe')
    nWLabelEditorialesSel = tk.Entry(master = nWindow, textvariable=tk.StringVar(value = 'Editoriales seleccionadas: '), state = 'readonly')
    nWLabelEditorialesSel.grid(row = 10, column=3, sticky='nswe')

    #scrolls
    scroll1 = tk.Scrollbar(master=nWindow, orient='horizontal', command = nWLabelAutoresSel.xview)
    nWLabelAutoresSel.config(xscrollcommand=scroll1.set)
    scroll1.grid(row = 11, column = 1, sticky='nswe')

    scroll2 = tk.Scrollbar(master=nWindow, orient='horizontal', command = nWLabelCategoriasSel.xview)
    nWLabelCategoriasSel.config(xscrollcommand=scroll2.set)
    scroll2.grid(row = 11, column = 2, sticky='nswe')

    scroll3 = tk.Scrollbar(master=nWindow, orient='horizontal', command = nWLabelEditorialesSel.xview)
    nWLabelEditorialesSel.config(xscrollcommand=scroll3.set)
    scroll3.grid(row = 11, column = 3, sticky='nswe')

    #Labels
    nWLabelNombreLibro = tk.Label(master = nWindow, text = 'Nombre del libro:', anchor = 'e')
    nWLabelNombreLibro.grid(row = 0, column = 0, sticky='nswe')
    nWLabelPagsLibro = tk.Label(master = nWindow, text = 'Número de páginas:', anchor = 'e')
    nWLabelPagsLibro.grid(row = 1, column = 0, sticky='nswe')
    nWLabelEdicionLibro = tk.Label(master = nWindow, text = 'Edición:', anchor = 'e')
    nWLabelEdicionLibro.grid(row = 1, column = 2, sticky='nswe')
    nWLabelDirectorioLibro = tk.Label(master = nWindow, text = 'Haga click en el botón para elegir dirección del libro')
    nWLabelDirectorioLibro.grid(row = 2, column = 1, sticky='nswe', columnspan= 3)
    nWLabelNumeroVolumen = tk.Label(master = nWindow, text = 'Número de Volumen:', anchor = 'e')
    #nWLabelNumeroVolumen.grid(row = 7, column = 2, sticky='nswe')
    nWLabelISBN = tk.Label(master = nWindow, text = 'Número ISBN: ', anchor = 'e')
    nWLabelISBN.grid(row = 9, column = 0, sticky='nswe')
    
    #Listas
    nWaut_list = ttk.Treeview(master = nWindow, columns = ('nom_aut'))
    nWaut_list.heading('#0', text = 'Id')
    nWaut_list.heading('nom_aut', text = 'Autor')
    nWaut_list.column('#0', anchor='center', stretch=True, width=30)
    nWcat_list = ttk.Treeview(master = nWindow, columns = ('nom_cat'))
    nWcat_list.heading('#0', text = 'Id')
    nWcat_list.heading('nom_cat', text = 'Categoria')
    nWcat_list.column('#0', anchor='center', stretch=True, width=30)
    nWedt_list = ttk.Treeview(master = nWindow, columns = ('nom_edt'))
    nWedt_list.heading('#0', text = 'Id')
    nWedt_list.heading('nom_edt', text = 'Editorial')
    nWedt_list.column('#0', anchor='center', stretch=True, width=30)

    #checkbox

    var = tk.IntVar()
    c1 = tk.Checkbutton(nWindow, text='¿Es parte de un volumen?', onvalue=1, offvalue=0, variable = var, command=lambda: showHideVolume(var, nWLabelNumeroVolumen, nWEntryVolumen))
    c1.grid(row = 8, column = 1, sticky='nswe')

    #id del libro

    curItem = lib_list.focus()
    id_lib = lib_list.item(curItem)['text']

    #Buttons
    nWButtonDirectorio = tk.Button(master = nWindow,
                                text = 'Elegir directorio',
                                width = 0,
                                height = 0,
                                bg = 'DimGray',
                                fg = 'white',
                                command = lambda: addDirectory(nWLabelDirectorioLibro, nWindow))
    nWButtonDirectorio.grid(row = 2, column=0, sticky='nswe')
    nWButtonAddAutor = tk.Button(master = nWindow,
                                text = 'Añadir Autor/es',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addVariable(nWaut_list, nWLabelAutoresSel, 'Autor'))
    nWButtonAddAutor.grid(row = 6, column=1, sticky='nswe')
    nWButtonAddCategoria = tk.Button(master = nWindow,
                                text = 'Añadir Categoria/s',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addVariable(nWcat_list, nWLabelCategoriasSel, 'Categoria'))
    nWButtonAddCategoria.grid(row = 6, column=2, sticky='nswe')
    nWButtonAddEditorial = tk.Button(master = nWindow,
                                text = 'Añadir Editorial',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: addVariable(nWedt_list, nWLabelEditorialesSel, 'Editorial'))
    nWButtonAddEditorial.grid(row = 6, column=3, sticky='nswe')
    
    nWButtonDeleteAutor = tk.Button(master = nWindow,
                                text = 'Eliminar Autor',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command = lambda: deleteVariable(nWaut_list, nWLabelAutoresSel, 'Autor'))
    nWButtonDeleteAutor.grid(row = 7, column=1, sticky='nswe')
    nWButtonDeleteCategoria = tk.Button(master = nWindow,
                                text = 'Eliminar Categoria',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command = lambda: deleteVariable(nWcat_list, nWLabelCategoriasSel, 'Categoria'))
    nWButtonDeleteCategoria.grid(row = 7, column=2, sticky='nswe')
    nWButtonDeleteEditorial = tk.Button(master = nWindow,
                                text = 'Eliminar Editorial',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command = lambda: deleteVariable(nWedt_list, nWLabelEditorialesSel, 'Editorial'))
    nWButtonDeleteEditorial.grid(row = 7, column=3, sticky='nswe')
    
    nWButtonAddLibro = tk.Button(master = nWindow,
                                text = 'Editar Libro',
                                width = 0,
                                height = 0,
                                bg = 'Green',
                                fg = 'white',
                                command = lambda: editFunction(nWindow, int(id_lib), nWEntryNombreLibro.get(), nWEntryPagsLibro.get(), nWEntryEdicionLibro.get(), nWLabelDirectorioLibro.cget('text'), var.get(), nWEntryVolumen.get(), nWEntryISBN.get()))
    nWButtonAddLibro.grid(row = 12, column=2, columnspan=2, sticky='nswe')
    nWButtonCancel= tk.Button(master = nWindow,
                                text = 'Cancelar',
                                width = 0,
                                height = 0,
                                bg = 'Red',
                                fg = 'white',
                                command= lambda: cancelFunctionEdit(nWindow))
    nWButtonCancel.grid(row = 12, column=0, columnspan=2, sticky='nswe')

    nWaut_list.grid(row = 5, column= 1, sticky='nswe')
    nWcat_list.grid(row = 5, column= 2, sticky='nswe')
    nWedt_list.grid(row = 5, column= 3, sticky='nswe')
    
    #Funciones de inicio
    
    putParameters(lib_list, nWEntryNombreLibro, nWEntryPagsLibro, nWEntryEdicionLibro, c1, nWEntryVolumen, nWEntryISBN, nWLabelAutoresSel, nWLabelCategoriasSel, nWLabelEditorialesSel, nWLabelDirectorioLibro)

    searchAutors(event, nWEntryBuscarAutor, nWaut_list)
    searchCategorias(event, nWEntryBuscarCategoria, nWcat_list)
    searchEditoriales(event, nWEntryBuscarEditorial, nWedt_list)

    nWindow.bind('<Destroy>', lambda event: onDestroy())
    nWindow.mainloop()

def editFunction(window, id_lib, nom_lib, num_pag, ed_lib, dir_lib, par_vol, vol_lib, isbn_lib):
    res = messagebox.askyesno(title = 'Editar Libro', message='¿Está seguro que quiere editar el libro?')
    if res:
        #checamos que nada esté vacío.
        if nom_lib != '' and num_pag != '' and ed_lib != '' and dir_lib != 'Haga click en el botón para elegir dirección del libro' and listaAutores != [] and listaCategorias != [] and listaEditoriales != []:
            conexion = sqlite3.connect("/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db", isolation_level=None)
            if not par_vol: 
                vol_lib = 0
            try:
                conexion.execute('UPDATE Libro SET nom_lib = ?, num_pag = ?, dir_lib = ?, ed_lib = ?, par_vol = ?, vol_lib = ?, id_edit = ?, isbn_lib = ? WHERE id_lib = ?;', (nom_lib, int(num_pag), dir_lib, int(ed_lib), int(par_vol), int(vol_lib), int(listaEditorialesId[0]), isbn_lib, id_lib, ))
                conexion.execute('DELETE FROM Lib_Aut WHERE id_lib = ?;', (id_lib,))
                conexion.execute('DELETE FROM Lib_Cat WHERE id_lib = ?;', (id_lib,))
                #se añaden los nuveos autores y categorias
                for id_aut in listaAutoresId:
                    conexion.execute('INSERT INTO Lib_Aut(id_lib, id_aut) VALUES(?,?);', (int(id_lib), id_aut))
                for id_cat in listaCategoriasId:
                    conexion.execute('INSERT INTO Lib_Cat(id_lib, id_cat) VALUES(?,?);', (int(id_lib), id_cat))
                messagebox.showinfo('Editar Libro', 'Libro '+nom_lib+' editado en la base de datos')
            except sqlite3.OperationalError as e:
                print(f'Error: {e}')
                messagebox.showwarning('Editar Libro', 'No fue posible editar el libro en la base de datos')
            conexion.close()
            window.destroy()
        else:
            messagebox.showerror(title = 'Error', message='No fue posible editar el libro en la base de datos')
            window.focus_force()
            window.lift()
    else:
        window.focus_force()
        window.lift()
    borrarEntriesLibro()

def putParameters(item, entry_nom, entry_pag, entry_edic, checbox_vol, entry_vol_num, entry_isbn, entry_aut, entry_cat, entry_edit, label_dir):
    curItem = item.focus()
    val = item.item(curItem)['values']
    id_lib = int(item.item(curItem)['text'])
    #val tiene los datos necesarios para la edición del libro
    #modificación de los entries con los datos del libro
    entry_nom.insert(0, val[0])
    entry_pag.insert(0, val[2])
    entry_edic.insert(0, val[6])
    entry_isbn.insert(0, val[7])
    if val[5] != '':
        checbox_vol.select()
        entry_vol_num.insert(0, val[5])
        entry_vol_num.grid(row = 8, column=3, sticky='nswe')
    entry_aut.config(textvariable=tk.StringVar(value = 'Autores seleccionados:' + val[1]))
    entry_cat.config(textvariable=tk.StringVar(value = 'Categorias seleccionadas: ' + val[3]))
    entry_edit.config(textvariable=tk.StringVar(value = 'Editoriales seleccionadas: ' + val[4]))
    label_dir.config(text = val[8])
    #buscamos ahora los autores y categorias en la bd a partir del id_lib
    conexion = sqlite3.connect('/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm//worm.db', isolation_level=None)
    split_autores = val[1].split(', ')
    split_categorias = val[3].split(', ')
    split_editoriales = val[4].split(', ')
    try:
        #se colocan los datos dentro de los arreglos
        cursor = conexion.execute('SELECT id_aut FROM Lib_Aut WHERE id_lib = ?;', (id_lib,))
        for fila in cursor:
            listaAutoresId.append(fila[0])
        cursor = conexion.execute('SELECT id_cat FROM Lib_Cat WHERE id_lib = ?;', (id_lib,))
        for fila in cursor:
            listaCategoriasId.append(fila[0])
        cursor = conexion.execute('SELECT id_edit FROM Libro WHERE id_lib = ?;', (id_lib,))
        for fila in cursor:
            listaEditorialesId.append(fila[0])
        for item in split_autores:
            listaAutores.append(item)
        for item in split_categorias:
            listaCategorias.append(item)
        for item in split_editoriales:
            listaEditoriales.append(item)
    except sqlite3.OperationalError as e:
        print(e)
    conexion.close()

#Ventana principal

window = tk.Tk()  
window.title('BookWorm')
width, height = get_screen_size()
window.geometry(f'{width}x{height}+0+0')

#Icono

p1 = tk.PhotoImage(file = '/home/cristodanielalvarado/Documentos/Personal/8. Proyectos/Proyecto Worm/Worm/Icon.png')
window.iconphoto(False, p1)

#Labels

aut_label = tk.Label(text = 'Nombre del autor')
cat_label = tk.Label(text = 'Nombre de la categoria')
edt_label = tk.Label(text = 'Nombre de la editorial')

aut_label_sear = tk.Label(text = 'Buscar autor:')
cat_label_sear = tk.Label(text = 'Buscar categoria')
edt_label_sear = tk.Label(text = 'Buscar editorial')

#Entrada de datos

aut_entry = tk.Entry()
cat_entry = tk.Entry()
edt_entry = tk.Entry()

aut_sear = tk.Entry()
cat_sear = tk.Entry()
edt_sear = tk.Entry()

aut_sear.bind('<KeyRelease>', buscarAutor)
cat_sear.bind('<KeyRelease>', buscarCategoria)
edt_sear.bind('<KeyRelease>', buscarEditorial)

lib_bus_nom = tk.Label(text = 'Buscar por nombre:', anchor = 'e')
lib_bus_nom.grid(row = 4, column=0, sticky='nswe')
lib_bus_nom_entry = tk.Entry()
lib_bus_nom_entry.grid(row = 4, column=1, sticky='nswe')
lib_bus_nom_entry.bind('<KeyRelease>', lambda event, obj = lib_bus_nom_entry: getLibros(lib_bus_nom_entry.get(), '', '', '', '', lib_list))

lib_bus_aut = tk.Label(text = 'Buscar por autor:', anchor = 'e')
lib_bus_aut.grid(row = 4, column=3, sticky='nswe')
lib_bus_aut_entry = tk.Entry()
lib_bus_aut_entry.grid(row = 4, column=4, sticky='nswe')
lib_bus_aut_entry.bind('<KeyRelease>', lambda event, obj = lib_bus_aut_entry: getLibros('', lib_bus_aut_entry.get(), '', '', '', lib_list))

lib_bus_cat = tk.Label(text = 'Buscar por categoria:', anchor = 'e')
lib_bus_cat.grid(row = 4, column=6, sticky='nswe')
lib_bus_cat_entry = tk.Entry()
lib_bus_cat_entry.grid(row = 4, column=7, sticky='nswe')
lib_bus_cat_entry.bind('<KeyRelease>', lambda event, obj = lib_bus_cat_entry: getLibros('', '', '', '', lib_bus_cat_entry.get(), lib_list))

lib_bus_isbn = tk.Label(text = 'Buscar por ISBN:', anchor = 'e')
lib_bus_isbn.grid(row = 5, column=0, sticky='nswe')
lib_bus_isbn_entry = tk.Entry()
lib_bus_isbn_entry.grid(row = 5, column=1, sticky='nswe')
lib_bus_isbn_entry.bind('<KeyRelease>', lambda event, obj = lib_bus_isbn_entry: getLibros('', '', '', lib_bus_isbn_entry.get(), '', lib_list))

lib_bus_edit = tk.Label(text = 'Buscar por editorial:', anchor = 'e')
lib_bus_edit.grid(row = 5, column=3, sticky='nswe')
lib_bus_edit_entry = tk.Entry()
lib_bus_edit_entry.grid(row = 5, column=4, sticky='nswe')
lib_bus_edit_entry.bind('<KeyRelease>', lambda event, obj = lib_bus_edit_entry: getLibros('', '', lib_bus_edit_entry.get(), '' , '', lib_list))

#listas con scroll
aut_list = ttk.Treeview(columns = ('nom_aut'))
aut_list.heading('#0', text = 'Id')
aut_list.heading('nom_aut', text = 'Autor')
aut_list.column('#0', anchor='center', width=30)

aut_scroll = tk.Scrollbar(orient='vertical', command = aut_list.yview)
aut_list.config(yscrollcommand=aut_scroll.set)
aut_scroll.grid(row = 1, column = 2, sticky='nswe')

cat_list = ttk.Treeview(columns = ('nom_cat'))
cat_list.heading('#0', text = 'Id')
cat_list.heading('nom_cat', text = 'Categoria')
cat_list.column('#0', anchor='center', stretch=True, width=30)

cat_scroll = tk.Scrollbar(orient='vertical', command = cat_list.yview)
cat_list.config(yscrollcommand=cat_scroll.set)
cat_scroll.grid(row = 1, column = 5, sticky='nswe')

edt_list = ttk.Treeview(columns = ('nom_edt'))
edt_list.heading('#0', text = 'Id')
edt_list.heading('nom_edt', text = 'Editorial')
edt_list.column('#0', anchor='center', stretch=True, width=30)

edt_scroll = tk.Scrollbar(orient='vertical', command = edt_list.yview)
edt_list.config(yscrollcommand=edt_scroll.set)
edt_scroll.grid(row = 1, column = 8, sticky='nswe')

lib_list = ttk.Treeview(columns = ('nom_lib', 'lib_auts', 'num_pag', 'lib_cats', 'edit_lib', 'vol_lib', 'edic_lib', 'isbn_lib', 'dir_lib'), selectmode='browse')
lib_list.heading('#0', text = 'Id')
lib_list.column('#0', anchor = 'center', width=30)
lib_list.heading('nom_lib', text = 'Nombre')
lib_list.heading('lib_auts', text = 'Autores')
lib_list.heading('num_pag', text = 'Páginas')
lib_list.column('num_pag', width=30)
lib_list.heading('lib_cats', text = 'Categorias')
lib_list.heading('edit_lib', text = 'Editorial')
lib_list.heading('vol_lib', text = 'Vol.')
lib_list.column('vol_lib', anchor = 'center', width=30)
lib_list.heading('edic_lib', text = 'Edición')
lib_list.column('edic_lib', anchor = 'center', width=30)
lib_list.heading('isbn_lib', text = 'ISBN') 
lib_list.heading('dir_lib', text = 'Directorio')
lib_list.bind('<Double-Button-1>', abrirDocumento)

lib_scroll = tk.Scrollbar(orient='vertical', command = lib_list.yview)
lib_list.config(yscrollcommand=lib_scroll.set)
lib_scroll.grid(row = 6, column = 8, sticky='nswe')

#Parte de libros

#Botones

aut_button = tk.Button(
    text = 'Insertar Autor',
    width = 0,
    height = 0,
    bg = 'green',
    fg = 'white'
)
aut_button.bind('<Button-1>', addAutor)
aut_show= tk.Button(
    text = 'Ver Autor',
    width = 0,
    height = 0,
    bg = 'DimGray',
    fg = 'white'
)
aut_show.bind('<Button-1>', showAutorInfo)

cat_button = tk.Button(
    text = 'Insertar Categoria',
    width = 0,
    height = 0,
    bg = 'green',
    fg = 'white'
)
cat_button.bind('<Button-1>', addCategoria)
cat_show= tk.Button(
    text = 'Ver Categoria',
    width = 0,
    height = 0,
    bg = 'DimGray',
    fg = 'white'
)
cat_show.bind('<Button-1>', showCategoriaInfo)

edt_button = tk.Button(
    text = 'Insertar Editorial',
    width = 0,
    height = 0,
    bg = 'green',
    fg = 'white'
)
edt_button.bind('<Button-1>', addEditorial)
edt_show= tk.Button(
    text = 'Ver Editorial',
    width = 0,
    height = 0,
    bg = 'DimGray',
    fg = 'white'
)
edt_show.bind('<Button-1>', showEditorialInfo)

lib_bus_clean = tk.Button(
    text = 'Limpiar Buscadores',
    width = 0,
    height = 0,
    bg = 'DimGray',
    fg = 'white',
    command = borrarEntriesLibro
)

edit_libro = tk.Button(
    text = 'Editar Libro',
    width = 0,
    height = 0,
    bg = 'yellow',
    fg = 'black',
    command = editBook
)

delete_libro = tk.Button(
    text = 'Eliminar Libro',
    width = 0,
    height = 0,
    bg = 'red',
    fg = 'white',
    command = deleteBook
)

lib_title = tk.Label(text = 'Libros')
lib_add = tk.Button(
    text = 'Añadir Libro',
    width = 0,
    height = 0,
    bg = 'green',
    fg = 'white',
)
lib_add.bind('<Button-1>', addBook)

#Funciones de inicio

getAutors()
getCategorias()
getEditoriales()
getLibros('', '', '', '', '', lib_list)

#posicionamiento de los elementos

window.columnconfigure(0, weight=0)
window.columnconfigure(1, weight=1)
window.columnconfigure(2, weight=0)
window.columnconfigure(3, weight=0)
window.columnconfigure(4, weight=1)
window.columnconfigure(5, weight=0)
window.columnconfigure(6, weight=0)
window.columnconfigure(7, weight=1)
window.columnconfigure(8, weight=0)
window.rowconfigure(0, weight = 0)
window.rowconfigure(1, weight = 1)
window.rowconfigure(2, weight = 0)
window.rowconfigure(3, weight = 0)
window.rowconfigure(4, weight = 0)
window.rowconfigure(5, weight = 0)
window.rowconfigure(6, weight = 1)
window.rowconfigure(7, weight = 0)
window.rowconfigure(8, weight = 0)
window.rowconfigure(9, weight = 0)

aut_label_sear.grid(row = 0, column = 0, sticky='nswe')
aut_sear.grid(row = 0, column=1, sticky='nswe')

aut_list.grid(row = 1, column = 0, sticky='nswe', columnspan=3)
aut_show.grid(row = 2, column = 0, sticky='nswe', columnspan=3)

cat_label_sear.grid(row = 0, column = 3, sticky='nswe')
cat_sear.grid(row = 0, column=4, sticky='nswe')

cat_list.grid(row = 1, column = 3, sticky='nswe', columnspan=3)
cat_show.grid(row = 2, column = 3, sticky='nswe', columnspan=3)

edt_label_sear.grid(row = 0, column = 6, sticky='nswe')
edt_sear.grid(row = 0, column = 7, sticky='nswe')

edt_list.grid(row = 1, column = 6, sticky='nswe', columnspan=3)
edt_show.grid(row = 2, column = 6, sticky='nswe', columnspan=3)

aut_label.grid(row = 7, column = 0)
aut_entry.grid(row = 7, column = 1, sticky='nswe')
aut_button.grid(row = 7, column = 3, sticky='nswe')

cat_label.grid(row = 8, column = 0)
cat_entry.grid(row = 8, column = 1, sticky='nswe')
cat_button.grid(row = 8, column = 3, sticky='nswe')

edt_label.grid(row = 9, column = 0)
edt_entry.grid(row = 9, column = 1, sticky='nswe')
edt_button.grid(row = 9, column = 3, sticky='nswe')

lib_title.grid(row = 3, column=3, columnspan=1, sticky='nswe')
lib_add.grid(row = 3, column=4, columnspan=1, sticky='nswe')

lib_bus_clean.grid(row = 5, column=6, sticky='nswe', columnspan=2)
lib_list.grid(row = 6, column=0, columnspan=9, sticky='nswe')
edit_libro.grid(row = 7, column=4, columnspan=2, sticky='nswe')
delete_libro.grid(row = 7, column=6, columnspan=3, sticky='nswe')

window.mainloop()
