import socket

def establecerConexion():
    global s
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(("localhost", 5005))

def recibirDatos():
    '''
    Recibir Input de Stream con \\n al final
    '''
    chunks = []
    chunck = s.recv(4096)
    while chunck != b'':
        chunks.append(chunck)
        chunck= s.recv(4096)
    return b''.join(chunks).decode()

def enviarDatos(datos):
    '''
    Enviar Output Stream con \\n al final
    '''
    s.send((datos+"\n").encode("ascii"))


def cerrarConexion():
    '''Cerrar Conexion'''
    global s
    s.close()
    

