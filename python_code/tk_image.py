# @version : 1.0
# @Author  : 混江龙
# @File    : tk_image.py
# @Time    : 2025/9/10 10:18
import os
from random import choice
from tkinter import *
from tkinter import PhotoImage

def callback():
    str = e.get()
    # var.set("Hello,我说了可以向你打招呼的")
    var.set(str)

def choese():
    for val in c:
        print(val,val.get())

root = Tk()
# 定义两个框架，用于存放text标签和button标签
frame1 = Frame(root)
frame2 = Frame(root)
frame3 = Frame(root)
# 定义字符串变量
var = StringVar()
# 设置字符串变量的值
var.set("测试文字压图片效果")
# 定义整型变量
photo = PhotoImage(file="yezi.png")
#compound 参数是 Tkinter Label 组件中一个非常实用的功能，它控制文本和图像的组合显示方式。
image_label = Label(frame1, textvariable=var, image=photo,compound=CENTER,font=("隶书",18),fg="#666")
image_label.pack(side=TOP)
button_label = Button(frame2, text="Hello",compound=CENTER,font=("宋体",16),fg="green",command=callback)
button_label.pack(side=TOP,padx=10,pady=10)
# 多选按钮
girls = ['西施','王昭君','杨玉环','貂蝉']
c = []
for girl in girls:
    c.append(IntVar())
    check = Checkbutton(frame3, text=girl, variable=c[-1],command=choese)
    # anchor 参数用于控制组件内内容（文本或图像）的对齐方式
    '''
    "n" - 北（上居中）
    "s" - 南（下居中）
    "e" - 东（右居中）
    "w" - 西（左居中）
    "nw" - 西北（左上角）
    "ne" - 东北（右上角）
    "sw" - 西南（左下角）
    "se" - 东南（右下角）
    "center" - 中心（默认
    '''
    check.pack(anchor="w")
# 标签分组标签
group = LabelFrame(frame3, text="你最喜欢的零食是？", padx=5, pady=5)
Radiobutton(group, text="牛奶",variable=var,value="牛奶",indicatoron=False).pack(anchor="w",fill="x")
Radiobutton(group, text="香蕉",variable=var,value="香蕉").pack(anchor="w")
Radiobutton(group, text="巧克力",variable=var,value="巧克力").pack(anchor="w")
group.pack(anchor="w")
# 输入框组件 textvariable 绑定变量，可以输入的内容直接传给变量
e = Entry(frame1)
e.pack(anchor="center",padx=5,pady=5)
e.insert(0,"默认文本...")
e.delete(0,END) #删除输入框中所有的字符

frame1.pack()
frame3.pack()
frame2.pack()
root.mainloop()