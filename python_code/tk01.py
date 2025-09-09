# @version : 1.0
# @Author  : 混江龙
# @File    : tk01.py
# @Time    : 2025/9/9 17:39

import tkinter as tk

app = tk.Tk()
app.title("窗口标题")
theLabel = tk.Label(app, text="我的第一个窗口程序！")
# pack用于自动调整尺寸
theLabel.pack()
# 窗口的主事件循环
app.mainloop()