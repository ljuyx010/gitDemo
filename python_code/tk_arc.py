# @version : 1.0
# @Author  : 混江龙
# @File    : tk_arc.py
# @Time    : 2025/9/11 16:01
from tkinter import *
from turtledemo.penrose import start

root = Tk()
a = Canvas(root,width=300,height=300)
a.pack()
# 起始位置（x,y）,终点位置(x,y),start起始角度，extent=180终点角度
a.create_arc(50,50,200,200,fill='red',
             start = 30,extent = 180,
             style='chord',width=2,outline='black'
             )

mainloop()