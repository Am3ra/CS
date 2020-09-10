from urllib.request import urlopen
import pickle

raw = pickle.load(urlopen("http://www.pythonchallenge.com/pc/def/banner.p"))

print(raw)
