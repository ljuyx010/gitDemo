# @version : 1.0
# @Author  : 混江龙
# @File    : wxPython_experson.py
# @Time    : 2025/9/15
import os
import wx

def on_select_dir(event):
    # 选择目录
    with wx.DirDialog( "选择目录",
                      style=wx.DD_DEFAULT_STYLE | wx.DD_DIR_MUST_EXIST) as dialog:
        if dialog.ShowModal() == wx.ID_OK:
            dir_path = dialog.GetPath()
            file_path_text.SetValue(dir_path)

app = wx.App()
# 设置窗口标题，大小，初始位置,第一个None表示没有父窗口
frame = wx.Frame(None,title="图片压缩小程序",size=(600,400),pos=(660,200))
# 设置窗口背景色
frame.SetBackgroundColour("#eee")
frame.Show()

# 选择文件夹面板，frame表示父窗体是frame
panel1 = wx.Panel(frame,size=(580,100),pos=(10,10))
# box盒子水平布局
vbox = wx.BoxSizer(wx.HORIZONTAL)
label1 = wx.StaticText(panel1,label="请选择图片目录：",pos=(0,25))
vbox.Add(label1,1,flag=wx.ALIGN_LEFT|wx.TEXT_ALIGNMENT_CENTER)
label1.SetFont(wx.Font(14,wx.FONTFAMILY_SCRIPT, wx.NORMAL, wx.NORMAL))
# 文件路径显示
file_path_text = wx.TextCtrl(panel1, size=(300, 30),pos=(140,20))
vbox.Add(file_path_text,2, flag=wx.EXPAND|wx.ALL,border=5)
# 设置只读
file_path_text.SetBackgroundColour(wx.WHITE)
file_path_text.SetEditable(False)
# 选择目录按钮
btn_select_dir = wx.Button(panel1, label="选择目录", size=(70, 30),pos=(450,20))
vbox.Add(btn_select_dir,1, flag=wx.EXPAND|wx.ALL,border=5)
btn_select_dir.Bind(wx.EVT_BUTTON, on_select_dir)
# 应用盒子布局
panel1.SetSizer(vbox)

# 设置图片大小，文件类型，保存方式
panel2 = wx.Panel(frame,size=(580,400),style=wx.ALIGN_CENTRE)



# 版权信息
panel3 = wx.Panel(frame,size=(580,20),pos=(10,320))
label = wx.StaticText(panel3,label="by：混江龙",size=(560,20),style=wx.ALIGN_RIGHT)
# 设置静态文本的字号，字体，样式，粗细
label.SetFont(wx.Font(14, wx.FONTFAMILY_SCRIPT, wx.NORMAL, wx.NORMAL))
label.SetForegroundColour('gray')
label.SetWindowStyle(wx.ALIGN_RIGHT)

app.MainLoop()

