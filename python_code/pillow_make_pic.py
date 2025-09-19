# @version : 1.0
# @Author  : 混江龙
# @File    : pillow_make_pic.py
# @Time    : 2025/9/19 15:55
from PIL import Image,ImageDraw,ImageFont

# 图片批量加水印
file = r'C:\Users\Administrator\Desktop\jjl\www.hbjjl.com.cn\upload\image\20160624\20160624145711.jpg'
im_before = Image.open(file)
# 把图片转成RGBA模式 （A透明度）
rgb_im = im_before.convert('RGBA')
# 创建蒙版层，模式：RGBA，大小和图片一样大，颜色是（255，25,25）透明度10,255不透明，默认不透明  可选，可以不要蒙版直接加水印
text_overlay = Image.new('RGBA', rgb_im.size, (255,25,25,10))
# 绘制水印层
draw = ImageDraw.Draw(text_overlay)
# 水印内容
text = "湖北大鹏网络"
# 字体，字号
font = ImageFont.truetype(r"C:\Users\Administrator\AppData\Local\Microsoft\Windows\Fonts\AlimamaShuHeiTi-Bold.ttf", size=20)
# 文字的尺寸大小
getleng = draw.textbbox((0,0),text = text, font=font)
# 水印位置的x，y坐标 (0,0) 是左上角
text_xy = (rgb_im.size[0]-getleng[2]-15,rgb_im.size[1]-getleng[3]-15) #右下角
draw.text(text_xy,text,font=font,fill=(0,234,224,100))
# 合并图层
im_with_text = Image.alpha_composite(rgb_im, text_overlay)
# 转回rgb格式
im_after_text = im_with_text.convert('RGB')
# 预览
# im_after_text.show()
# 保存
im_after_text.save(r'C:\Users\Administrator\Desktop\jjl\www.hbjjl.com.cn\upload\image\20160624\20160624145711sy.jpg')