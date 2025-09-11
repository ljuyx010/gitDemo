# @version : 1.0
# @Author  : 混江龙
# @File    : tk02.py
# @Time    : 2025/9/9 20:48
import tkinter as tk
class App:
    def __init__(self, master):
        # 新建一个框架，用于显示内容
        frame = tk.Frame(master)
        frame.pack(side=tk.LEFT,padx=5,pady=5)
        photo = tk.PhotoImage(file="2025-09-09_214636.png")
        self.imgLabel = tk.Label(frame, image=photo)
        self.imgLabel.pack(side=tk.TOP)
        self.textLabel = tk.Label(frame, text="点击下方按钮可以对话",font=("隶书",20,"bold","italic"),fg="green")
        self.textLabel.pack(side=tk.TOP,padx=5,pady=5)
        self.hi_there = tk.Button(frame, text="打招呼",bg="white",fg="red",command=self.say_hello)

    def say_hello(self):
        print("你好呀，我是一个小机器人。")

root = tk.Tk()
app = App(root)
root.mainloop()
