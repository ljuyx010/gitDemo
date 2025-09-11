# @version : 1.0
# @Author  : 混江龙
# @File    : tk_input.py
# @Time    : 2025/9/10 14:43
from tkinter import *
import webbrowser
from attr.setters import validate


def getInput():
    print("作品：", e1.get(), "\n作者：", e2.get())
    print("密码：", e3.get())

def quit():
    root.quit()


root = Tk()
"""
布局管理器grid
核心参数：
row - 行号（从0开始）
column - 列号（从0开始）
rowspan - 跨行数
columnspan - 跨列数
padx, pady - 外部间距
ipadx, ipady - 内部间距
sticky - 组件在单元格内的对齐方式
"""
Label(root, text="作品：").grid(row=0, column=0)
Label(root, text="作者：").grid(row=1, column=0)
Label(root, text="密码：").grid(row=2, column=0)
e1 = Entry(root)
e2 = Entry(root)
# validata = "None" 关闭输入验证，
# focus 获得或失去焦点验证，focusin 获得焦点验证，focusout 失去焦点验证，key 编辑时验证，all 所有情况都验证
e3 = Entry(root,show="*",validate="focus")
e1.grid(row=0, column=1,padx=10,pady=5)
e2.grid(row=1, column=1,padx=10,pady=5)
e3.grid(row=2, column=1,padx=10,pady=5)
Button(root, text="获取信息",command=getInput).grid(row=3, column=0,padx=10,pady=5,sticky=W)
Button(root, text="退出",command=quit).grid(row=3, column=1,padx=10,pady=5,ipadx=20,sticky=E)

frame1 = Frame(root)
sb = Scrollbar(frame1) #创建一个滚动条
sb.pack(side=RIGHT,fill=Y) #滚动条靠右，铺满y轴
# selectmode 选择模式，单选，多选
# height 显示的行数，不是高度，yscrollcommand Y轴滚动条关联sb
theLB = Listbox(frame1,width=40,height=5,selectmode=SINGLE,yscrollcommand=sb.set)
theLB.pack(side=LEFT,fill=BOTH)
frame1.grid(row=4,columnspan=2)
# 滚动条和listbox关联
sb.config(command=theLB.yview)
for item in range(100):
    # 添加列表组件元素
    theLB.insert(END,item)
# 删除列表组件的元素
theLB.delete(0)

frame2 = Frame(root)
# tickinterval 刻度间隔，resolution 步长（精度）
Scale(frame2,from_=10,to=100,tickinterval=10,resolution=10).pack(side=TOP)
# orient 滚动条的样式 HORIZONTAL 水平滚动
Scale(frame2,from_=100,to=200,orient=HORIZONTAL).pack(side=TOP)

frame2.grid(row=5,columnspan=2)

def show():
    print("哟，我被点了一下")
    # text插入图片
    text.image_create(END,image=photo)

# Text组件，显示多行文本
frame3 = Frame(root)
# width,height的单位都是平均字符宽度和高度
text = Text(frame3,width=50,height=30,padx=5,pady=5)
text.pack(side=TOP,padx=10,pady=10)
frame3.grid(row=6,columnspan=2)
text.insert(INSERT,"I love XXX \n") #光标位置插入
text.insert(END,"lj") #结尾处插入
# text组件中插入其他组件
b1 = Button(text,text="点我",command=show)
"""
window_create() 是 Text 组件的一个方法，用于在文本中嵌入其他组件（如按钮、输入框、标签等）
主要参数详解
1. index - 插入位置
text.window_create("1.0", window=widget)      # 开头
text.window_create(END, window=widget)        # 结尾
text.window_create("2.5", window=widget)      # 第2行第5个字符
2. window - 要嵌入的组件
# 必须属于同一个 Text 组件
button = Button(text_widget, text="按钮")
text_widget.window_create(END, window=button)
3. align - 对齐方式
text.window_create(END, window=widget, align="top")     # 顶部对齐
text.window_create(END, window=widget, align="center")  # 居中对齐
text.window_create(END, window=widget, align="bottom")  # 底部对齐
4. padx, pady - 间距
text.window_create(END, window=widget, padx=10, pady=5)
"""
text.window_create("1.0",window=b1,align=TOP)
photo = PhotoImage(file="yezi.png")
text.insert(INSERT,"这是测试tags标签的一段话")
# 给1.1-2.2（第一行，第1个字到第二行，第2个字）和第2行第7个字绑定标签tag1
text.tag_add("tag1",1.1,"2.2","2.7")
# 设置标签tag1的样式
text.tag_config("tag1",foreground="red",background="yellow",font=("宋体",20,"bold"))
# 选中事件
def show_hand_cursor(event):
    text.config(cursor="arrow")
# 离开事件
def show_out_cursor(event):
    text.config(cursor="xterm")
# 点击事件
def click(event):
    # 浏览器打开网页
    webbrowser.open("http://www.starsoft.work")

# 给标签绑定方法
text.tag_bind("tag1",'<Enter>',show_hand_cursor)
text.tag_bind("tag1",'<Leave>',show_out_cursor)
text.tag_bind("tag1",'<Button-1>',click)
mainloop()