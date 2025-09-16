# @version : 1.0
# @Author  : 混江龙
# @File    : auto_pics_process.py
# @Time    : 2025/9/16 10:13
import os
import wx
import cv2

class MyFrame(wx.Frame):
    file_path = None
    weight = 800
    height = None
    layout = 1
    save = 4
    image_extensions = {'.jpg', '.jpeg', '.png', '.bmp', '.gif', '.tiff', '.webp', '.svg'}
    image_files = []

    def __init__(self,parent):
        super().__init__(None,title="大鹏网络图片压缩工具",size=(600,450),pos=(660,200))
        super().SetBackgroundColour("#eee")

    # 选择文件或文件夹
    def on_select(self,event):
        """选择目录"""
        with wx.DirDialog(self, "选择目录",
        style=wx.DD_DEFAULT_STYLE | wx.DD_DIR_MUST_EXIST) as dialog:
            if dialog.ShowModal() == wx.ID_OK:
                dir_path = dialog.GetPath()
                self.file_path = dir_path
                self.input.SetValue(dir_path)
            # print(self.file_path)

    # 填写验证，判断是否数字
    def is_number(self,event):
        # 检查输入是否为数字
        weight = event.GetEventObject().GetValue()
        # print(weight)
        if len(weight)>0 and not weight.isdigit():
            event.GetEventObject().SetValue(weight[:-1])

    # 保存宽高到变量
    def set_var(self,event):
        id = event.GetEventObject().GetId()
        value = event.GetEventObject().GetValue()
        if id==10:
            self.weight = int(value) if len(value)>0 else None
        else:
            self.height = int(value) if len(value)>0 else None
        if (self.weight == None or self.weight == 0 )and (self.height == None or self.height == 0):
            wx.MessageBox("请确保宽度和高度中至少有一个有效值！","警告：")
            self.weight = 800
            event.GetEventObject().SetValue(str(self.weight))

    # 文件格式选择
    def on_radio_layout(self,event):
        self.layout = event.GetEventObject().GetId()
        # state = event.GetEventObject().GetValue()
        print(self.layout)
    # 保存方式选择
    def on_radio_save(self,event):
        self.save = event.GetEventObject().GetId()
        print(self.save)

    # 循环遍历所有的图片
    def all_files(self,path):
       try:
           with os.scandir(path) as it:
               for entry in it:
                  if entry.is_file():
                    # 检查文件扩展名是否为图片格式
                    filename, ext = os.path.splitext(entry.name)
                    if ext.lower() in self.image_extensions:
                       dic = {"path":entry.path.replace(filename + ext.lower(),""), "name":filename, "ext":ext.lower()}
                       self.image_files.append(dic)
                  elif entry.is_dir():
                     # print(entry.name)
                     # 如果是文件夹，递归遍历
                     self.all_files(entry.path)
           return
       except Exception as e:
           print(e)

    # 开始处理
    def on_start(self,event):
        # 重置image_files列表
        self.image_files = []
        self.all_files(self.file_path)
        print(self.image_files)

    # 退出程序
    def on_quit(self,event):
        self.Destroy()

    # 创建面板
    def creat_panel(self):
        panel = wx.Panel(self)
        vbox = wx.BoxSizer(wx.VERTICAL)
        titleFont = wx.Font(14,wx.FONTFAMILY_SCRIPT, wx.NORMAL, wx.FONTWEIGHT_BOLD)
        # 选择文件
        statictext1 = wx.StaticText(panel,label="请图片所在文件夹")
        statictext1.SetFont(titleFont)
        vbox.Add(statictext1,flag=wx.ALIGN_LEFT|wx.ALL,border=10)
        hbox1 = wx.BoxSizer(wx.HORIZONTAL)
        self.input = wx.TextCtrl(panel)
        self.input.SetEditable(False)
        self.input.SetBackgroundColour(wx.WHITE)
        hbox1.Add(self.input,proportion=5,flag=wx.EXPAND|wx.ALL,border=10)
        fileButton = wx.Button(panel,label="选择...")
        fileButton.Bind(wx.EVT_BUTTON,self.on_select)
        hbox1.Add(fileButton, proportion=1, flag=wx.ALIGN_CENTRE|wx.ALL,border=10)
        vbox.Add(hbox1,flag=wx.LEFT,border=10)
        # 处理尺寸
        statictext2 = wx.StaticText(panel,label="压缩尺寸")
        statictext2.SetFont(titleFont)
        vbox.Add(statictext2, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        hbox2 = wx.BoxSizer(wx.HORIZONTAL)
        statictextW = wx.StaticText(panel,label="宽度(像素)：")
        hbox2.Add(statictextW,proportion=1, flag=wx.ALIGN_LEFT|wx.ALIGN_CENTER_VERTICAL|wx.ALL,border=10)
        inputW = wx.TextCtrl(panel,id=10)
        inputW.SetValue(str(self.weight))
        inputW.Bind(wx.EVT_KEY_UP,self.is_number)
        inputW.Bind(wx.EVT_LEAVE_WINDOW,self.set_var)
        hbox2.Add(inputW, proportion=2, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        statictextH = wx.StaticText(panel,label="高度(像素)：")
        hbox2.Add(statictextH, proportion=1, flag=wx.ALIGN_LEFT | wx.ALIGN_CENTER_VERTICAL | wx.ALL, border=10)
        inputH = wx.TextCtrl(panel,id=11)
        # inputH.SetValue(self.height)
        inputH.Bind(wx.EVT_KEY_UP,self.is_number)
        inputH.Bind(wx.EVT_LEAVE_WINDOW, self.set_var)
        hbox2.Add(inputH, proportion=2, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        vbox.Add(hbox2,flag=wx.LEFT,border=10)
        # 保存格式
        statictext3 = wx.StaticText(panel,label="保存格式")
        statictext3.SetFont(titleFont)
        vbox.Add(statictext3, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        hbox3 = wx.BoxSizer(wx.HORIZONTAL)
        radio_ButtonY = wx.RadioButton(panel,id=1,label="原格式",style=wx.RB_GROUP)
        radio_ButtonJ = wx.RadioButton(panel,id=2,label="JPG")
        radio_ButtonP = wx.RadioButton(panel,id=3,label="PNG")
        radio_ButtonY.Bind(wx.EVT_RADIOBUTTON,self.on_radio_layout)
        self.Bind(wx.EVT_RADIOBUTTON,self.on_radio_layout,id=2,id2=3)
        hbox3.Add(radio_ButtonY,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        hbox3.Add(radio_ButtonJ,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        hbox3.Add(radio_ButtonP,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        vbox.Add(hbox3,flag=wx.LEFT,border=10)
        # 保存方式
        statictext4 = wx.StaticText(panel,label="保存方式")
        statictext4.SetFont(titleFont)
        vbox.Add(statictext4, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        hbox4 = wx.BoxSizer(wx.HORIZONTAL)
        radio_ButtonO = wx.RadioButton(panel, id=4, label="覆盖原图", style=wx.RB_GROUP)
        radio_ButtonN = wx.RadioButton(panel, id=5, label="原位另存")
        self.Bind(wx.EVT_RADIOBUTTON, self.on_radio_save, id=4, id2=5)
        hbox4.Add(radio_ButtonO,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        hbox4.Add(radio_ButtonN,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        vbox.Add(hbox4,flag=wx.LEFT,border=10)
        # 处理按钮
        hbox5 = wx.BoxSizer(wx.HORIZONTAL)
        button_sart = wx.Button(panel,label="开始处理")
        button_sart.Bind(wx.EVT_BUTTON,self.on_start)
        button_quit = wx.Button(panel,label="退出")
        button_quit.Bind(wx.EVT_BUTTON,self.on_quit)
        hbox5.Add(button_sart,proportion=1,flag=wx.CENTER|wx.LEFT|wx.RIGHT,border=30)
        hbox5.Add(button_quit,proportion=1,flag=wx.CENTER|wx.LEFT|wx.RIGHT,border=30)
        vbox.Add(hbox5,flag=wx.CENTER|wx.TOP,border=20)
        # 版权信息
        hboxc = wx.BoxSizer(wx.HORIZONTAL)
        copyFont = wx.Font(10, wx.FONTFAMILY_SWISS, wx.NORMAL, wx.NORMAL)
        statictext5 = wx.StaticText(panel, label="电话：400-6688-605")
        statictext5.SetFont(copyFont)
        statictext5.SetForegroundColour("#999")
        hboxc.Add(statictext5,  flag=wx.ALIGN_LEFT)
        statictext6 = wx.StaticText(panel, label="服务：网站建设/软件开发/微信小程序/400电话")
        statictext6.SetFont(copyFont)
        statictext6.SetForegroundColour("#999")
        hboxc.Add(statictext6, flag=wx.ALIGN_LEFT|wx.LEFT|wx.RIGHT,border=10)
        statictext7 = wx.StaticText(panel, label="版权：湖北大鹏网络科技")
        statictext7.SetFont(copyFont)
        statictext7.SetForegroundColour("#999")
        hboxc.Add(statictext7, flag=wx.ALIGN_LEFT)
        vbox.Add(hboxc, flag=wx.CENTER|wx.TOP, border=20)
        # 应用盒子布局
        panel.SetSizer(vbox)

if __name__ == '__main__':
    app = wx.App()
    frame = MyFrame(None)
    frame.creat_panel()
    frame.Show()
    app.MainLoop()