# @version : 1.0
# @Author  : 混江龙
# @File    : test_click.py
# @Time    : 2025/9/12 15:55
import mouse
import time
import pyautogui

def debug_double_click(x, y):
    """调试双击操作"""
    print(f"准备在 ({x}, {y}) 双击")

    # 先移动并显示位置
    mouse.move(x, y, duration=1)
    time.sleep(0.5)

    # 执行双击
    pyautogui.doubleClick(x, y)
    # pyautogui.click()


    print("双击完成")


# 使用当前鼠标位置调试
current_x, current_y = mouse.get_position()
# 切换到桌面
pyautogui.hotkey('win', 'd')
time.sleep(1)
debug_double_click(current_x, current_y)