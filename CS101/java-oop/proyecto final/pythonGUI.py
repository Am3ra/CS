#!/usr/bin/env python3
import tkinter as tk
import pythonClient as client

root = tk.Tk()


def catalogo():
    client.establecerConexion()
    client.enviarDatos("consultarArtistas")
    artistas = client.recibirDatos()
    listArtistas.delete(0, tk.END)
    for i in enumerate(artistas.split("\n")[0].split("&")[0:-1]):
        listArtistas.insert(i[0],i[1])
    client.cerrarConexion()

def cancion():
    pass

def artistaClick(evnt):
    w = evnt.widget
    index = int(w.curselection()[0])
    value = w.get(index)
    client.establecerConexion()
    client.enviarDatos("consultarAlbums")
    client.enviarDatos(value)
    albums = client.recibirDatos()
    listaAlbums.delete(0,tk.END)
    listaSongs.delete(0,tk.END)
    for i in enumerate(albums.split("\n")[0].split("&")[0:-1]):
        listaAlbums.insert(i[0], i[1])
    client.cerrarConexion()

def songClick(evnt):
    w = evnt.widget
    index = int(w.curselection()[0])
    value = w.get(index)
    print(value)
    
def albumClick(evnt):
    w = evnt.widget
    index = int(w.curselection()[0])
    value = w.get(index)
    client.establecerConexion()
    client.enviarDatos("consultarCanciones")
    print(value)
    client.enviarDatos(value)
    songs = client.recibirDatos()
    listaSongs.delete(0, tk.END)
    for i in enumerate(songs.split("\n")[0].split("&")[0:-1]):
        listaSongs.insert(i[0], i[1])
    client.cerrarConexion()

bCatalogo = tk.Button(root, text="Catalogo", command=catalogo)
bCanciones = tk.Button(root, text="Canciones", command=cancion)
lArtista = tk.Label(root, text="Artista:")
bAlbums = tk.Button(root, text="Albums")
eArtistas = tk.Entry(root)
eAlbums = tk.Entry(root)
listArtistas = tk.Listbox(root, selectmode=tk.SINGLE)
listaAlbums = tk.Listbox(root, selectmode=tk.SINGLE)
listaSongs = tk.Listbox(root, selectmode=tk.SINGLE)



bCatalogo.grid(row=0)
eArtistas.grid(row=0, column= 2)
bAlbums.grid(row=0,column=3)
eAlbums.grid(row=0,column=4)
bCanciones.grid(row=0,column=5)
listArtistas.grid(row=1)
listaAlbums.grid(row=1, column=3)
listaSongs.grid(row=1, column=5)

listArtistas.bind('<<ListboxSelect>>', artistaClick)
listaAlbums.bind('<<ListboxSelect>>', albumClick)
listaSongs.bind('<<ListboxSelect>>', songClick)

root.mainloop()

