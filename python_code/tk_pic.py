# @version : 1.0
# @Author  : 混江龙
# @File    : tk_pic.py
# @Time    : 2025/9/11 14:12
from tkinter import *
root = Tk()
w = Canvas(root,width=300,height=300,background="white")
w.pack()
# 实现画板功能
def paint(event):
    x1, y1 = event.x-1, event.y-1
    x2, y2 = event.x+1, event.y+1
    w.create_oval(x1,y1,x2,y2,fill='red')

w.bind('<B1-Motion>',paint)

Label(root,text="按住鼠标左键并移动完成绘画").pack(padx=5,pady=5)
mainloop()