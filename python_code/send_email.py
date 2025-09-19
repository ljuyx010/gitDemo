# @version : 1.0
# @Author  : 混江龙
# @File    : send_email.py
# @Time    : 2025/9/19 11:22
import  smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

# 建立一个邮件，并设置邮箱服务器地址和端口
smtp = smtplib.SMTP('smtp.163.com', 25)
# 登录邮箱 用户名和密码（SMTP授权码）
smtp.login('<EMAIL>', '<PASSWORD>')
# 发送邮件：设置发件人，收件人，邮件内容
sender = '<EMAIL>'
receiver = '<EMAIL>'
msg = MIMEMultipart('mixed') # mixed 邮件内容可以带附件
msg['From'] = '<EMAIL>' #发件人
msg['To'] = '<EMAIL>' #收件人
msg['Subject'] = '<UNK>' #邮件主题
html = f"""
这里是邮件的内容{sender}可以直接用变量
"""
# 邮件正文，MIMEText()设置正文发送内容支持的格式和编码
msg.attach(MIMEText(html, 'html','utf-8'))
smtp.sendmail(sender,receiver,msg.as_string())
# 退出邮箱
smtp.quit()