'''Create server and threads.'''

import socket
import threading

FTP_PORT = 21


class FTPserver():
    '''Create instance of FTP server following the IETF RFC 959'''

    def __init__(self, backlog=3):
        '''initialization of class'''
        self.sock = socket.socket()
        self.sock.bind(("localhost", FTP_PORT))
        self.sock.listen(backlog)

    def close_server(self):
        '''Close the server.'''
        self.sock.close()

class FTPthread():
    '''Create thread of server to attend user requests in parallel'''
    def __init__(self):
        '''initialization of class'''

if __name__ == "__main__":
    FTP = FTPserver()
    FTP.close_server()
    print(FTP)
