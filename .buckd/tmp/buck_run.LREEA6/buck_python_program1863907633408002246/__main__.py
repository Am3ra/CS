from __future__ import absolute_import
import sys
sys.path.insert(0, "/Users/macbookpro/Documents/CS/.buckd/resources/v2017.05.31.01")
sys.path.insert(0, "/Users/macbookpro/Documents/CS/.buckd/resources/v2017.05.31.01/path_to_pywatchman")
sys.path.insert(0, "/Users/macbookpro/Documents/CS/.buckd/resources/v2017.05.31.01/path_to_typing")
sys.path.insert(0, "/Users/macbookpro/Documents/CS/.buckd/resources/v2017.05.31.01/buck_server")
sys.path.insert(0, "/Users/macbookpro/Documents/CS/.buckd/tmp/buck_run.LREEA6/buck_python_program1863907633408002246")
if __name__ == '__main__':
    try:
        from buck_parser import buck
        buck.main()
    except KeyboardInterrupt:
        print >> sys.stderr, 'Killed by User'
