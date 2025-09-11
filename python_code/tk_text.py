# @version : 1.0
# @Author  : 混江龙
# @File    : tk_text.py
# @Time    : 2025/9/11 10:14
from tkinter import *
import hashlib

root = Tk()
# undo = True 开启撤销功能
text= Text(root,width=50,height=20,padx=5,pady=5,font=14,undo=True,autoseparators=False)
text.pack(padx=5,pady=5)
text.insert(INSERT,'Hello World this is my idle')
contents = text.get("1.0",END)
# 获取hash摘要
def getSig(contents):
    m = hashlib.md5(contents.encode('utf-8'))
    return m.hexdigest()
# 元素内容的摘要
sig = getSig(contents)
def check():
    ontents = text.get("1.0",END)
    if sig == getSig(ontents):
        print("ok")
    else:
        print("内容发生变动")
def getIndex(text,index):
    return tuple(map(int,text.index(index).split('.')))

def search():
    start = 1.0
    while True:
        pos = text.search("o",start,stopindex=END)
        if not pos:
            break
        print("找到啦，位置是：",getIndex(text,pos))
        # +1c移动到后面的一个字符
        start = pos + '+1c'
# 绑定事件，必须传入event
def callback(event):
    # 插入分隔符
    text.edit_separator()
# 每一下操作键盘都插入一个分隔符
text.bind('<Key>',callback)
def goBack():
    # 文本撤销方法
    text.edit_undo()
Button(root,text="检测",command=check).pack(padx=5,pady=5)
Button(root,text="搜索",command=search).pack(padx=5,pady=5)
Button(root,text="撤销",command=goBack).pack(padx=5,pady=5)
mainloop()