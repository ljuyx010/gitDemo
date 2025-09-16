# @version : 1.0
# @Author  : 混江龙
# @File    : wxBox.py
# @Time    : 2025/9/15 14:36
import wx

class MyFrame(wx.Frame):
    def __init__(self):
        super().__init__(None,title="图片压缩小程序",size=(600,400),pos=(660,200))
        super().SetBackgroundColour("#eee")
    # 面板方法
    def creat_panel(self):
        panel = wx.Panel(self)
        statictext = wx.StaticText(panel,label="Hello World")
        btn1 = wx.Button(panel,label="确定")
        btn2 = wx.Button(panel,label="取消")
        hbox = wx.BoxSizer(wx.HORIZONTAL)
        hbox.Add(btn1,proportion=2,flag=wx.ALIGN_CENTRE|wx.ALL,border=10)
        hbox.Add(btn2,proportion=1,flag=wx.ALIGN_CENTRE|wx.BOTH,border=10)
        vbox = wx.BoxSizer(wx.VERTICAL)
        vbox.Add(statictext,proportion=1,flag=wx.ALIGN_CENTRE|wx.TOP,border=10)
        vbox.Add(hbox,proportion=1,flag=wx.ALIGN_CENTRE,border=10)
        panel.SetSizer(vbox)

app = wx.App()
frame = MyFrame()
frame.creat_panel()
frame.Show()
app.MainLoop()