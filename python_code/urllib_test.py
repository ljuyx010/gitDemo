# @version : 1.0
# @Author  : 混江龙
# @File    : urllib_test.py
# @Time    : 2025/9/8 11:06
# 测试urllib访问网络
import random
import urllib.request

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
# 免费代理ip比较好用的平台：https://www.jiliuip.com/

ips = ['tn10037.jiliuip.com:12866']
proxy = {"http":random.choice(ips), "https":random.choice(ips)}
proxy_support = urllib.request.ProxyHandler(proxy)
opener = urllib.request.build_opener(proxy_support)
# 安装代理，后面的request就可以直接使用代理
urllib.request.install_opener(opener)

req = urllib.request.Request("http://httpbin.org/ip")
# 模拟浏览器
req.add_header('User-Agent', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.6261.95 Safari/537.36')
response = urllib.request.urlopen(req,timeout=10)
html = response.read().decode('utf-8')
print(html)


# 配置代理（请替换为实际代理地址和端口）
# 格式："协议://代理IP:端口"，例如："http://127.0.0.1:8080"
# proxy = "60.171.194.50:9300"
# # 创建代理处理器（支持http和https协议）
# proxy_handler = urllib.request.ProxyHandler({"http": proxy,"https": proxy})
# # 构建带代理的opener
# opener = urllib.request.build_opener(proxy_handler)
#
# # 使用代理opener访问URL（替换原urlopen）
# response = opener.open("http://httpbin.org/ip",timeout=10)
# if response.status == 200:
#     content = response.read().decode('utf-8')
#     print(content)

def test_proxy(proxy_url):
    try:
        proxy_handler = urllib.request.ProxyHandler({'http': proxy_url, 'https': proxy_url})
        opener = urllib.request.build_opener(proxy_handler)
        response = opener.open('http://httpbin.org/ip', timeout=10)
        result = response.read().decode()
        print(f"代理返回的IP: {result}")
        return True
    except Exception as e:
        print(f"代理测试失败: {e}")
        return False

# 测试代理
# test_proxy('8.140.235.207:9001')
