# @version : 1.0
# @Author  : 混江龙
# @File    : selenimu_chome.py
# @Time    : 2025/9/12 10:12
import time

import cv2
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.chrome.service import Service as chrome_service
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# 手动配置chrome浏览器驱动路径
service = chrome_service(executable_path=r"D:\Program Files\python3.13\chromedriver-win64\chromedriver.exe")
options = webdriver.ChromeOptions()
options.add_argument('--start-maximized')          # 最大化窗口
options.add_argument('--disable-extensions')  # 禁用扩展
options.add_argument('--disable-gpu')  # 禁用GPU加速
options.add_argument('--no-sandbox')  # 禁用沙盒
options.add_argument('--disable-dev-shm-usage')  # 禁用共享内存
options.add_argument('--disable-notifications')    # 禁用通知
options.add_argument('--disable-infobars')         # 禁用信息栏
options.add_experimental_option('excludeSwitches', ['enable-automation']) #禁用自动化栏
# 屏蔽保存账号密码提示框
prefs = {'credentials_enable_service': False,'profile.password_manager_enabled': False}
options.add_experimental_option('prefs', prefs)
# 发爬虫特征处理
options.add_argument('--disable-blink-features=AutomationControlled')
# 设置selenimu浏览器驱动和配置项
driver = webdriver.Chrome(service=service, options=options)

# 登录页面
login_url = 'https://passport.damai.cn/login?ru=https%3A%2F%2Fwww.damai.cn%2F'
driver.get(login_url)
driver.switch_to.frame(0)
# 点击账号密码登录
# driver.find_element(By.CSS_SELECTOR,'#login-tabs > div.login-tabs-tab').click()
# 输入账号
driver.find_element(By.CSS_SELECTOR,'#fm-login-id').send_keys('18071185970')
# 输入密码
driver.find_element(By.CSS_SELECTOR,'#fm-login-password').send_keys('528051088@qq.com')
# 勾选同意用户协议
# driver.find_element(By.CSS_SELECTOR,'#regAgree').click()
# 点击登录按钮
driver.find_element(By.CSS_SELECTOR,'#login-form > div.fm-btn > button').click()
"""
过阿里云滑块验证码
1. 检测验证码出现
2. 获取滑块图片和背景图片
3. 图像识别计算滑动距离
4. 模拟人类滑动轨迹
5. 处理验证结果
"""
# 等待验证码iframe加载（根据实际页面调整iframe选择器）
# WebDriverWait(driver, 20).until(EC.frame_to_be_available_and_switch_to_it((By.CSS_SELECTOR, "body > div:nth-child(42) > iframe")))
# 等待验证码iframe加载，进入第一个iframe页面
# WebDriverWait(driver, 20).until(driver.switch_to.frame(0))
# 判断验证码是否出现
if driver.find_element(By.CSS_SELECTOR,'.yidun_popup').is_displayed():

    # 获取验证码背景图和滑块元素
    bg_img = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR, ".yidun_popup .yidun_bgimg img.yidun_bg-img")))
    slider = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR, ".yidun_popup  div.yidun_modal__body  div.yidun_control  div.yidun_slider")))

    # 获取背景图位置和尺寸
    bg_location = bg_img.location
    bg_size = bg_img.size
    bg_left = bg_location['x']
    bg_top = bg_location['y']
    bg_width = bg_size['width']
    bg_height = bg_size['height']

    # 截取验证码区域屏幕并保存
    driver.save_screenshot("captcha_screenshot.png")
    screenshot = cv2.imread("captcha_screenshot.png")
    captcha_img = screenshot[int(bg_top):int(bg_top+bg_height), int(bg_left):int(bg_left+bg_width)]
    cv2.imwrite("captcha_bg.png", captcha_img)

    # 图像识别计算滑动距离（简单边缘检测示例，实际需根据验证码调整）
    gray = cv2.cvtColor(captcha_img, cv2.COLOR_BGR2GRAY)
    blurred = cv2.GaussianBlur(gray, (5, 5), 0)
    edges = cv2.Canny(blurred, 50, 150)
    contours, _ = cv2.findContours(edges.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    # 筛选最大轮廓作为缺口位置（实际需优化）
    if contours:
        max_contour = max(contours, key=cv2.contourArea)
        x, y, w, h = cv2.boundingRect(max_contour)
        slide_distance = x  # 滑动距离为缺口左侧坐标（需根据滑块初始位置调整）

    # 生成模拟人类滑动轨迹
    def get_slide_track(distance):
        track = []
        current = 0
        mid = distance * 3/5
        t = 0.2
        v = 0
        while current < distance:
            if current < mid:
                a = 2
            else:
                a = -3
            v0 = v
            v = v0 + a * t
            move = v0 * t + 0.5 * a * t * t
            current += move
            track.append(round(move))
        return track

    track = get_slide_track(slide_distance)

    # 执行滑动操作
    ActionChains(driver).click_and_hold(slider).perform()
    for x in track:
        ActionChains(driver).move_by_offset(xoffset=x, yoffset=0).perform()
    time.sleep(0.5)
    ActionChains(driver).release().perform()

    # 切回主文档
    driver.switch_to.default_content()

time.sleep(10)