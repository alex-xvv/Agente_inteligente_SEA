import win32com.client as win
from sys import argv
script, texto = argv
speaker = win.Dispatch("SAPI.SpVoice")
speaker.Speak(texto)