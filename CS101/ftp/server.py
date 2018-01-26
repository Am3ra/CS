'''Create server and threads.'''

import socket
import threading
import os

FTP_PORT = 21
LOCAL_IP = "localhost"


class FTPserver():
    '''Create instance of FTP server following the IETF RFC 959'''

    def __init__(self, backlog=3):
        '''initialization of class'''
        self.sock = socket.socket()
        self.sock.bind((LOCAL_IP, FTP_PORT))
        self.backlog = backlog

    def start(self):
        '''Start server listening'''
        self.sock.listen(self.backlog)

    def stop(self):
        '''Close the server.'''
        self.sock.close()

class FTPthread():
    '''Create thread of server to attend user requests in parallel'''
    def __init__(self):
        '''initialization of class'''

if __name__ == "__main__":
    FTP = FTPserver()
    FTP.start()
    print("FTP Server currently running")
    input('Enter to end...\n')
    FTP.stop()