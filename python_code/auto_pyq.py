# @version : 1.0
# @Author  : 混江龙
# @File    : auto_pyq.py
# @Time    : 2025/9/12 15:23
import pyautogui
import time
import cv2
import numpy as np


class ImageBasedWeChat:
    def __init__(self):
        self.templates = {
            'wechat_icon': 'wechat_icon.png',
            'discover': 'discover_icon.png',
            'moment': 'moment_icon.png',
            'camera': 'camera_icon.png'
        }

    def find_and_click(self, template_name, confidence=0.8):
        """通过图像识别找到并点击元素"""
        template = cv2.imread(self.templates[template_name])
        screenshot = pyautogui.screenshot()
        screenshot = cv2.cvtColor(np.array(screenshot), cv2.COLOR_RGB2BGR)

        result = cv2.matchTemplate(screenshot, template, cv2.TM_CCOEFF_NORMED)
        min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(result)

        if max_val >= confidence:
            center_x = max_loc[0] + template.shape[1] // 2
            center_y = max_loc[1] + template.shape[0] // 2
            pyautogui.click(center_x, center_y)
            return True
        return False

    def send_moment(self, content, image_path=None):
        """发送朋友圈"""
        # 打开微信（假设已经在运行）
        if self.find_and_click('wechat_icon'):
            time.sleep(2)

        # 点击发现
        if self.find_and_click('discover'):
            time.sleep(2)

        # 点击朋友圈
        if self.find_and_click('moment'):
            time.sleep(3)

        # 点击相机
        if self.find_and_click('camera'):
            time.sleep(2)

        # 输入内容
        import pyperclip
        pyperclip.copy(content)
        pyautogui.hotkey('ctrl', 'v')
        time.sleep(1)

        # 发布
        pyautogui.press('enter')