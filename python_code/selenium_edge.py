# @version : 1.0
# @Author  : 混江龙
# @File    : selenium_edge.py
# @Time    : 2025/9/12 09:12
from sys import executable
from  selenium import webdriver
from selenium.webdriver.edge.service import service as EdgeService
from selenium.webdriver.edge.options import Options
"""
selenium 工作流程  selenium 操作浏览器驱动，浏览器驱动再来操作浏览器
"""
# 使用 Chrome 浏览器 并配置驱动位置
# dirver = webdriver.Chrome(executable_path=r"D:\Program Files\python3.13\chromedriver-win64")
# 使用 Edge 浏览器 配置驱动路径
# 手动指定 Edge 驱动路径
# edge_driver_path = r'D:\Program Files\python3.13\edgedriver_win64\msedgedriver.exe'  # 替换为你的实际路径
# service = EdgeService(executable_path = edge_driver_path)
edge_options = Options()
edge_options.add_argument('--start-maximized')          # 最大化窗口
edge_options.add_argument('--disable-notifications')    # 禁用通知
edge_options.add_argument('--disable-infobars')         # 禁用信息栏
# edge_options.add_argument('--headless')               # 无头模式（不显示浏览器）
# edge_options.add_argument('--incognito')              # 隐身模式
driver = webdriver.Edge(options=edge_options)
driver.get("http://www.baidu.com")
print("成功打开百度页面!")
print(f"标题: {driver.title}")
driver.quit()