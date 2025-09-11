# @version : 1.0
# @Author  : 混江龙
# @File    : tk_menu.py
# @Time    : 2025/9/11 16:30
from tkinter import *

root = Tk()
menu = Menu(root)
def call():
    print("你好~")
# tearoff 撕开，设置菜单能不能移出来
filemenu = Menu(menu,tearoff=False)
editmenu = Menu(menu,tearoff=True)
# 级联菜单
menu.add_cascade(label="菜单",menu=filemenu)
menu.add_cascade(label="编辑",menu=editmenu)
menu.add_command(label="退出",command=root.quit)
filemenu.add_command(label="打开",command=call)
filemenu.add_command(label="保存",command=call)
filemenu.add_separator()
filemenu.add_command(label="退出",command=root.quit)
editmenu.add_command(label="复制",command=call)
editmenu.add_command(label="剪切",command=call)
editmenu.add_command(label="粘贴",command=call)
editmenu.add_command(label="清空",command=call)
root.config(menu=menu)
# 弹出菜单
frame = Frame(root,width=300,height=300)
frame.pack()
def popup(event):
    menubar.post(event.x_root, event.y_root)
# Button-1 左键，Button-2 滑轮，Button-3 右键
frame.bind("<Button-3>",popup)
menubar = Menu(root)
menubar.add_command(label="撤销",command=root.quit)
menubar.add_command(label="重做",command=root.quit)
mainloop()