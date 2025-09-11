# @version : 1.0
# @Author  : 混江龙
# @File    : tk_canvas.py
# @Time    : 2025/9/11 11:14
from tkinter import *
import math as m
from requests import delete

root = Tk()
# Canvas 画布组件
w = Canvas(root,width=200,height=100,bg='white')
w.pack()
# 坐标点（X,y）
line1 = w.create_line(0,0,200,100,fill='red')
line2 = w.create_line(200,0,0,100,fill='blue',dash=(2,2))
rect = w.create_rectangle(50,25,150,75,fill='green')
# 修改图形的三个方法
# coords 移动（x，y）（x，y）
# w.coords(line1,0,25,200,25)
# # 设置图形
# w.itemconfig(rect,fill='yellow')
# # 删除图形
# w.delete(line2)
# 文本图形，默认anchor=center，
w.create_text(100,50,text='文本的内容',fill='white',anchor='e')

# 椭圆形  坐标是长方形就是椭圆，是正方形就是圆形
w.create_oval(50,25,150,75,fill='pink')

# 画五角星
# 中心点坐标
center_x =100
center_y = 50
# 半径50
r = 50
points = [
#     左上点
    center_x - int(r * m.sin(2*m.pi/5)),
    center_y - int(r * m.cos(2*m.pi/5)),
#     右上点
    center_x + int(r * m.sin(2*m.pi/5)),
    center_y - int(r * m.cos(2*m.pi/5)),
#     左下角
    center_x - int(r * m.sin(2*m.pi/5)),
    center_y + int(r * m.cos(2*m.pi/5)),
#     定点
    center_x,
    center_y - r,
#     右下角
    center_x + int(r * m.sin(2*m.pi/5)),
    center_y + int(r * m.cos(2*m.pi/5)),
]
# 多边形
w.create_polygon(points,outline='yellow',fill='red')

Button(root,text="删除全部",command=(lambda x=ALL:w.delete(x))).pack(padx=5,pady=5)

mainloop()