# @version : 1.0
# @Author  : 混江龙
# @File    : aliyunCaptcha.py
# @Time    : 2025/9/12 11:42
import cv2
import numpy as np
import time
import random
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.action_chains import ActionChains
from webdriver_manager.microsoft import EdgeChromiumDriverManager
import base64
import re
import os


class AliyunCaptchaSolver:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    def is_captcha_present(self):
        """检测验证码是否出现"""
        try:
            # 阿里云验证码的各种可能选择器
            selectors = [
                '.aliyun-capcha-container',
                '#aliyun-capcha',
                '.nc-container',
                '.nc_iconfont',
                '[class*="aliyun"]',
                '[class*="nc"]'
            ]

            for selector in selectors:
                elements = self.driver.find_elements(By.CSS_SELECTOR, selector)
                if elements:
                    return True
            return False
        except:
            return False

    def extract_captcha_images(self):
        """提取验证码图片"""
        try:
            # 查找滑块和背景图元素
            bg_element = self.wait.until(
                EC.presence_of_element_located((By.CSS_SELECTOR, "#aliyunCaptcha-img"))
            )
            # 滑块
            slide_element = self.wait.until(
                EC.presence_of_element_located((By.CSS_SELECTOR, "#aliyunCaptcha-puzzle"))
            )

            # 获取图片base64数据
            bg_style = bg_element.get_attribute("style")
            slide_style = slide_element.get_attribute("style")

            # 从style中提取base64图片
            bg_data = self._extract_base64_from_style(bg_style)
            slide_data = self._extract_base64_from_style(slide_style)

            if bg_data and slide_data:
                # 保存图片
                bg_image = self._base64_to_image(bg_data, "background.png")
                slide_image = self._base64_to_image(slide_data, "slider.png")
                return bg_image, slide_image

        except Exception as e:
            print(f"提取图片失败: {e}")
            return None, None

    def _extract_base64_from_style(self, style):
        """从style属性中提取base64数据"""
        match = re.search(r'url\("data:image/[^;]+;base64,([^"]+)"\)', style)
        if match:
            return match.group(1)
        return None

    def _base64_to_image(self, base64_data, filename):
        """base64转图片"""
        try:
            image_data = base64.b64decode(base64_data)
            with open(filename, 'wb') as f:
                f.write(image_data)
            return cv2.imread(filename)
        except:
            return None

    def calculate_slide_distance(self, bg_image, slide_image):
        """计算滑动距离"""
        try:
            # 图像处理：灰度化
            bg_gray = cv2.cvtColor(bg_image, cv2.COLOR_BGR2GRAY)
            slide_gray = cv2.cvtColor(slide_image, cv2.COLOR_BGR2GRAY)

            # 模板匹配
            result = cv2.matchTemplate(bg_gray, slide_gray, cv2.TM_CCOEFF_NORMED)
            min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(result)

            # 获取匹配位置
            x = max_loc[0]

            # 根据实际验证码调整距离（阿里云可能有缩放）
            distance = x * 0.8  # 调整系数，根据实际情况调整

            return distance

        except Exception as e:
            print(f"计算距离失败: {e}")
            return None

    def generate_human_trajectory(self, distance):
        """生成人类滑动轨迹"""

    轨迹 = []
    current = 0
    distance = int(distance)

    # 初始加速
    while current < distance * 0.3:
        move = random.randint(3, 6)
        current += move
        轨迹.append(move)
        time.sleep(random.uniform(0.01, 0.03))

    # 中间减速
    while current < distance * 0.7:
        move = random.randint(2, 4)
        current += move
        轨迹.append(move)
        time.sleep(random.uniform(0.02, 0.05))

    # 最后微调
    remaining = distance - current
    if remaining > 0:
        # 小步调整
        small_moves = []
        while sum(small_moves) < remaining:
            move = random.randint(1, 2)
            if sum(small_moves) + move <= remaining:
                small_moves.append(move)
            else:
                small_moves.append(remaining - sum(small_moves))

        轨迹.extend(small_moves)

    return 轨迹


def slide_verification(self, distance):
    """执行滑动操作"""
    try:
        # 找到滑块按钮
        slide_button = self.wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, ".nc_iconfont"))
        )

        # 生成人类轨迹
        trajectory = self.generate_human_trajectory(distance)

        # 执行滑动
        actions = ActionChains(self.driver)
        actions.click_and_hold(slide_button).perform()

        total_moved = 0
        for move in trajectory:
            actions.move_by_offset(move, 0).perform()
            total_moved += move
            time.sleep(random.uniform(0.01, 0.05))

        # 小幅回弹（模拟人类行为）
        actions.move_by_offset(-random.randint(2, 5), 0).perform()
        actions.move_by_offset(random.randint(1, 3), 0).perform()

        time.sleep(0.2)
        actions.release().perform()

        return True

    except Exception as e:
        print(f"滑动失败: {e}")
        return False


def solve_captcha(self):
    """主解决函数"""
    if not self.is_captcha_present():
        print("未检测到验证码")
        return True

    print("检测到验证码，开始处理...")

    # 获取图片
    bg_image, slide_image = self.extract_captcha_images()
    if bg_image is None or slide_image is None:
        print("获取验证码图片失败")
        return False

    # 计算距离
    distance = self.calculate_slide_distance(bg_image, slide_image)
    if distance is None:
        print("计算滑动距离失败")
        return False

    print(f"计算得到的滑动距离: {distance}px")

    # 执行滑动
    success = self.slide_verification(distance)

    # 检查结果
    time.sleep(2)
    if self.is_verification_success():
        print("验证码通过!")
        return True
    else:
        print("验证码未通过")
        return False


def is_verification_success(self):
    """检查验证是否成功"""
    try:
        # 查找成功提示或失败提示
        success_elements = self.driver.find_elements(By.CSS_SELECTOR, '.nc-lang-cnt')
        for element in success_elements:
            if "验证成功" in element.text or "success" in element.text.lower():
                return True

        # 检查验证码容器是否消失
        captcha_elements = self.driver.find_elements(By.CSS_SELECTOR, '.aliyun-capcha-container')
        if not captcha_elements:
            return True

        return False
    except:
        return False


# 使用示例
def test_aliyun_captcha():
    # 初始化浏览器
    options = webdriver.EdgeOptions()
    options.add_argument('--disable-blink-features=AutomationControlled')
    options.add_experimental_option("excludeSwitches", ["enable-automation"])
    options.add_experimental_option('useAutomationExtension', False)

    service = Service(EdgeChromiumDriverManager().install())
    driver = webdriver.Edge(service=service, options=options)

    # 修改WebDriver属性
    driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")

    try:
        # 访问测试页面（这里需要替换为实际目标页面）
        driver.get("https://目标网站.com")

        # 创建验证码解决器
        solver = AliyunCaptchaSolver(driver)

        # 处理验证码
        if solver.solve_captcha():
            print("验证码处理成功，继续后续操作...")
            # 这里可以继续你的自动化操作
        else:
            print("验证码处理失败")
            # 可以添加重试逻辑

    except Exception as e:
        print(f"程序出错: {e}")

    finally:
        driver.quit()


if __name__ == "__main__":
    test_aliyun_captcha()