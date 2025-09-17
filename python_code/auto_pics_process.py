# @version : 1.0
# @Author  : 混江龙
# @File    : auto_pics_process.py
# @Time    : 2025/9/16 10:13
import os
import re
import numpy as np
import wx
import cv2

class MyFrame(wx.Frame):
    panel = None
    file_path = None
    weight = 800
    height = None
    layout = 1
    save = 5
    image_extensions = {'.jpg', '.jpeg', '.png', '.bmp', '.gif', '.tiff', '.webp', '.svg'}
    image_files = []

    def __init__(self,parent):
        super().__init__(None,title="大鹏网络图片压缩工具",size=(600,450),pos=(660,200))
        super().SetBackgroundColour("#eee")
        self.creat_panel()
        sizer = wx.BoxSizer(wx.VERTICAL)
        sizer.Add(self.panel,flag=wx.CENTER|wx.TOP,border=15)
        self.SetSizer(sizer)
        self.SetIcon(wx.Icon('./app.ico'))

    def contains_chinese(self,path):
        """
        判断路径字符串是否包含中文字符
        :param path: 待检查的路径字符串
        :return: 如果包含中文字符返回True，否则返回False
        """
        pattern = re.compile(r'[\u4e00-\u9fff]')  # 中文字符的Unicode范围
        return bool(pattern.search(path))

    # 选择文件或文件夹
    def on_select(self,event):
        """选择目录"""
        with wx.DirDialog(self, "选择目录",
        style=wx.DD_DEFAULT_STYLE | wx.DD_DIR_MUST_EXIST) as dialog:
            if dialog.ShowModal() == wx.ID_OK:
                dir_path = dialog.GetPath()
                # print(type(dir_path),dir_path)
                if not self.contains_chinese(dir_path):
                    self.file_path = dir_path
                    self.input.SetValue(dir_path)
                else:
                    wx.MessageBox("不能选择包含中文的路径","警告")
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
        # print(self.layout)
    # 保存方式选择
    def on_radio_save(self,event):
        self.save = event.GetEventObject().GetId()
        # print(self.save)

    # 循环遍历所有的图片
    def all_files(self,path):
       try:
           with os.scandir(path) as it:
               for entry in it:
                  if entry.is_file():
                    # 检查文件扩展名是否为图片格式
                    filename, ext = os.path.splitext(entry.name)
                    if ext.lower() in self.image_extensions:
                       dic = {'src':entry.path, "path":entry.path.replace(filename + ext.lower(),""), "name":filename, "ext":ext.lower()}
                       self.image_files.append(dic)
                  elif entry.is_dir():
                     # print(entry.name)
                     # 如果是文件夹，递归遍历
                     self.all_files(entry.path)
           return
       except Exception as e:
           print(e)

    # 处理图片压缩
    def img_compress(self,file):
        try:
            original = cv2.imread(file['src'], cv2.IMREAD_UNCHANGED)
            # print(file["name"], original.shape)
            height, width = original.shape[:2]
            # 如果有alpha通道并且是png转jpg，把透明通道变白色背景
            if original.shape[2] == 4 and self.layout == 2:
                # 创建白色背景
                white_bg = np.ones((original.shape[0], original.shape[1], 3), dtype=np.uint8) * 255
                # 提取RGB通道
                rgb = original[:, :, :3]
                # 提取alpha通道并归一化
                alpha = original[:, :, 3] / 255.0
                # 对每个通道进行混合
                for c in range(3):
                    white_bg[:, :, c] = rgb[:, :, c] * alpha + white_bg[:, :, c] * (1 - alpha)
                # print(white_bg.shape)
                original = white_bg
            # 设置了宽高，并且图片的宽高至少一个大于设置的值才处理
            if self.weight and self.height and (self.weight < width or self.height < height):
               # 计算缩放比例（取较大值，然后裁切）
               scale = max(self.weight / width, self.height / height)
               new_w, new_h = int(width * scale), int(height * scale)
               # 缩放图片
               resize = cv2.resize(original, (new_w, new_h))
               # print("裁切")
               # 计算裁切位置（居中）
               start_x = (new_w - self.weight) // 2
               start_y = (new_h - self.height) // 2

               # 裁切图片
               resized = resize[start_y:start_y + self.height, start_x:start_x + self.weight]
               return resized
            # 只设置了高度，那么图片必须必设置的值大才处理
            elif self.height and self.height < height:
                scale = self.height / height
                new_w = int(width * scale)
                # print("高度固定")
                # 缩放图片
                resized = cv2.resize(original, (new_w, self.height))
                return resized
            # 只设置了宽度，图片宽度必须大于宽度才处理
            elif self.weight and self.weight < width:
                scale = self.weight / width
                new_h = int(height * scale)
                # print("宽度固定")
                # 缩放图片
                resized = cv2.resize(original, (self.weight, new_h))
                return resized
            return None
        except Exception as e:
            print(e)

    # 开始处理
    def on_start(self,event):
        # 重置image_files列表
        self.image_files = []
        self.all_files(self.file_path)
        count = 0
        # 读取原图片信息
        for f in self.image_files:
            resized_image = self.img_compress(f)
            # print(resized_image)
            if resized_image is None: #跳过后续操作
                continue
            # 判断是否覆盖原图
            if not self.save == 4:
                f['name'] = "reduce_" + f['name']
            output = f['path'] + f['name']
            # 判断输出文件格式并输出
            if self.layout == 2:
                output += '.jpg'
                cv2.imwrite(output, resized_image, [cv2.IMWRITE_JPEG_QUALITY, 80])
            elif self.layout == 3:
                output += '.png'
                cv2.imwrite(output, resized_image, [cv2.IMWRITE_PNG_COMPRESSION, 2])
            else:
                output += f['ext']
                cv2.imwrite(output, resized_image)
            count += 1
        wx.MessageBox(f"处理完成,共处理{count}个文件","完成")
        self.file_path = None
        self.input.SetValue("")

    # 退出程序
    def on_quit(self,event):
        self.Destroy()

    # 创建面板
    def creat_panel(self):
        self.panel = wx.Panel(self)
        vbox = wx.BoxSizer(wx.VERTICAL)
        titleFont = wx.Font(12,wx.FONTFAMILY_SCRIPT, wx.NORMAL, wx.FONTWEIGHT_BOLD)
        # 选择文件
        statictext1 = wx.StaticText(self.panel,label="请图片所在文件夹")
        statictext1.SetFont(titleFont)
        vbox.Add(statictext1,flag=wx.ALIGN_LEFT|wx.LEFT|wx.TOP,border=10)
        hbox1 = wx.BoxSizer(wx.HORIZONTAL)
        self.input = wx.TextCtrl(self.panel)
        self.input.SetEditable(False)
        self.input.SetBackgroundColour(wx.WHITE)
        hbox1.Add(self.input,proportion=5,flag=wx.EXPAND|wx.ALL,border=10)
        fileButton = wx.Button(self.panel,label="选择...")
        fileButton.Bind(wx.EVT_BUTTON,self.on_select)
        hbox1.Add(fileButton, proportion=1, flag=wx.ALIGN_CENTRE|wx.ALL,border=10)
        vbox.Add(hbox1,flag=wx.CENTER,border=10)
        # 处理尺寸
        statictext2 = wx.StaticText(self.panel,label="压缩尺寸")
        statictext2.SetFont(titleFont)
        marktext = wx.StaticText(self.panel,
        label="说明：只填写宽度,则宽度固定高度等比缩放，只填写高度则宽度等比缩放，宽高都填写则等比后居中裁切")
        marktext.SetFont(wx.Font(9,wx.FONTFAMILY_SCRIPT, wx.NORMAL, wx.NORMAL))
        marktext.SetForegroundColour("#888")
        vbox.Add(statictext2,flag=wx.ALIGN_LEFT|wx.LEFT,border=10)
        vbox.Add(marktext,flag=wx.CENTER|wx.LEFT,border=10)
        hbox2 = wx.BoxSizer(wx.HORIZONTAL)
        statictextW = wx.StaticText(self.panel,label="宽度(像素)：")
        hbox2.Add(statictextW,proportion=1, flag=wx.ALIGN_LEFT|wx.ALIGN_CENTER_VERTICAL|wx.ALL,border=10)
        inputW = wx.TextCtrl(self.panel,id=10)
        inputW.SetValue(str(self.weight))
        inputW.Bind(wx.EVT_KEY_UP,self.is_number)
        inputW.Bind(wx.EVT_LEAVE_WINDOW,self.set_var)
        hbox2.Add(inputW, proportion=2, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        statictextH = wx.StaticText(self.panel,label="高度(像素)：")
        hbox2.Add(statictextH, proportion=1, flag=wx.ALIGN_LEFT | wx.ALIGN_CENTER_VERTICAL | wx.ALL, border=10)
        inputH = wx.TextCtrl(self.panel,id=11)
        # inputH.SetValue(self.height)
        inputH.Bind(wx.EVT_KEY_UP,self.is_number)
        inputH.Bind(wx.EVT_LEAVE_WINDOW, self.set_var)
        hbox2.Add(inputH, proportion=2, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        vbox.Add(hbox2,flag=wx.CENTER,border=10)
        # 保存格式
        statictext3 = wx.StaticText(self.panel,label="保存格式")
        statictext3.SetFont(titleFont)
        vbox.Add(statictext3, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        hbox3 = wx.BoxSizer(wx.HORIZONTAL)
        radio_ButtonY = wx.RadioButton(self.panel,id=1,label="原格式",style=wx.RB_GROUP)
        radio_ButtonJ = wx.RadioButton(self.panel,id=2,label="JPG")
        radio_ButtonP = wx.RadioButton(self.panel,id=3,label="PNG")
        radio_ButtonY.Bind(wx.EVT_RADIOBUTTON,self.on_radio_layout)
        self.Bind(wx.EVT_RADIOBUTTON,self.on_radio_layout,id=2,id2=3)
        hbox3.Add(radio_ButtonY,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        hbox3.Add(radio_ButtonJ,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        hbox3.Add(radio_ButtonP,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        vbox.Add(hbox3,flag=wx.ALIGN_LEFT,border=10)
        # 保存方式
        statictext4 = wx.StaticText(self.panel,label="保存方式",style=wx.ALIGN_LEFT)
        statictext4.SetFont(titleFont)
        vbox.Add(statictext4, flag=wx.ALIGN_LEFT | wx.ALL, border=10)
        hbox4 = wx.BoxSizer(wx.HORIZONTAL)
        radio_ButtonO = wx.RadioButton(self.panel, id=4, label="覆盖原图", style=wx.RB_GROUP)
        radio_ButtonN = wx.RadioButton(self.panel, id=5, label="原位另存")
        radio_ButtonN.SetValue(True)
        self.Bind(wx.EVT_RADIOBUTTON, self.on_radio_save, id=4, id2=5)
        hbox4.Add(radio_ButtonO,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        hbox4.Add(radio_ButtonN,proportion=1,flag=wx.CENTER|wx.ALL,border=10)
        vbox.Add(hbox4,flag=wx.ALIGN_LEFT,border=10)
        # 处理按钮
        hbox5 = wx.BoxSizer(wx.HORIZONTAL)
        button_sart = wx.Button(self.panel,label="开始处理")
        button_sart.Bind(wx.EVT_BUTTON,self.on_start)
        button_quit = wx.Button(self.panel,label="退出")
        button_quit.Bind(wx.EVT_BUTTON,self.on_quit)
        hbox5.Add(button_sart,proportion=1,flag=wx.CENTER|wx.LEFT|wx.RIGHT,border=30)
        hbox5.Add(button_quit,proportion=1,flag=wx.CENTER|wx.LEFT|wx.RIGHT,border=30)
        vbox.Add(hbox5,flag=wx.CENTER|wx.TOP,border=20)
        # 版权信息
        hboxc = wx.BoxSizer(wx.HORIZONTAL)
        copyFont = wx.Font(10, wx.FONTFAMILY_SWISS, wx.NORMAL, wx.NORMAL)
        statictext5 = wx.StaticText(self.panel, label="电话：400-6688-605")
        statictext5.SetFont(copyFont)
        statictext5.SetForegroundColour("#999")
        hboxc.Add(statictext5,  flag=wx.ALIGN_LEFT)
        statictext6 = wx.StaticText(self.panel, label="服务：网站建设/软件开发/微信小程序/400电话")
        statictext6.SetFont(copyFont)
        statictext6.SetForegroundColour("#999")
        hboxc.Add(statictext6, flag=wx.ALIGN_LEFT|wx.LEFT|wx.RIGHT,border=10)
        statictext7 = wx.StaticText(self.panel, label="版权：湖北大鹏网络科技")
        statictext7.SetFont(copyFont)
        statictext7.SetForegroundColour("#999")
        hboxc.Add(statictext7, flag=wx.ALIGN_LEFT)
        vbox.Add(hboxc, flag=wx.CENTER|wx.TOP, border=20)
        # 应用盒子布局
        self.panel.SetSizer(vbox)

if __name__ == '__main__':
    app = wx.App()
    frame = MyFrame(None)
    frame.Show()
    app.MainLoop()