# @version : 1.0
# @Author  : 混江龙
# @File    : urllib_test.py
# @Time    : 2025/9/8 11:06
# 测试urllib访问网络
import random
import urllib

# response = request.urlopen("http://www.starsoft.work")
# if response.status == 200:
#     content = response.read()
# print(content)
# 模拟浏览器访问url
# request = urllib.request.Request('http://chaipip.com')
# request.add_header('User-Agent', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.95 Safari/537.36')
# response = urllib.request.urlopen(request)
# html = response.read().decode('utf-8')
# print(html)

# 隐藏python默认的header并使用代理访问http://chaipip.com/
'''
ips = ['117.71.155.247:8089']
proxy = {"https":random.choice(ips)}
proxy_support = urllib.request.ProxyHandler(proxy)
opener = urllib.request.build_opener(proxy_support)
# 安装代理，后面的request就可以直接使用代理
urllib.request.install_opener(opener)

req = urllib.request.Request("http://chaipip.com/")
# 模拟浏览器
req.add_header('User-Agent', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.95 Safari/537.36')
response = urllib.request.urlopen(req)
html = response.read().decode('utf-8')
print(html)
'''

# 配置代理（请替换为实际代理地址和端口）
# 格式："协议://代理IP:端口"，例如："http://127.0.0.1:8080"
proxy = "8.219.168.160:3129"
# 创建代理处理器（支持http和https协议）
proxy_handler = urllib.request.ProxyHandler({
    # "http": proxy,
    "https": proxy
})
# 构建带代理的opener
opener = urllib.request.build_opener(proxy_handler)

# 使用代理opener访问URL（替换原urlopen）
response = opener.open("http://chaipip.com/")
if response.status == 200:
    content = response.read().decode('utf-8')
print(content)