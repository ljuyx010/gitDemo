# @version : 1.0
# @Author  : 混江龙
# @File    : autogui.py
# @Time    : 2025/9/23 09:07
import ctypes
import sys
import time
import pyautogui
import mouse

# 基础设置
pyautogui.PAUSE = 1 #调用在执行动作后暂停的秒数，time.sleep(1)去暂停更好
pyautogui.FAILSAFE = True #启动自动防故障功能

# 判断屏幕的尺寸
screenwidth,screenheight = pyautogui.size()
print(screenwidth,screenheight)

# 获取鼠标的位置
currentMouseX,currentMouseY = pyautogui.position()
print(currentMouseX,currentMouseY)
# 点击一下鼠标，让目标处于前台
# pyautogui.click(687,724)
# 鼠标的移动,duration持续时间
# pyautogui.moveTo(323,182,duration=1)
# 鼠标的拖拽 ,button =left 一直按着左键拖拽，x,y 移动到的坐标放开鼠标
# pyautogui.dragTo(561,432,button='left',duration=1)
# 鼠标单击
# pyautogui.click()
# time.sleep(2)
# pyautogui.click()
# 鼠标双击 interval 双击时间间隔,对文件或文件夹双击打开不好用
# pyautogui.doubleClick(button='left',interval=0.05)
# 滚轮操作，500向上滚动500像素，-500是向下滚动500
# pyautogui.scroll(-500)
# 键盘的操作 输入文字
# pyautogui.typewrite('nihao')
# 按空格键
# pyautogui.press('space')
# 长按键盘上的键
# pyautogui.keyDown('shift')
# pyautogui.press('4')
# 组合键
pyautogui.dragTo(currentMouseX,currentMouseY,1,button='left')
pyautogui.hotkey('ctrl', 'c')
pyautogui.click(currentMouseX,currentMouseY+60)
pyautogui.hotkey('ctrl', 'v')




'''
def troubleshoot_double_click():
    print("开始双击故障排除...")

    # 获取屏幕尺寸
    screen_width, screen_height = pyautogui.size()
    print(f"屏幕尺寸: {screen_width}x{screen_height}")

    # 移动到屏幕中央
    center_x, center_y = screen_width // 2, screen_height // 2
    pyautogui.moveTo(center_x, center_y)
    print(f"移动到屏幕中央: ({center_x}, {center_y})")

    # 测试不同的间隔时间
    intervals = [0.05, 0.075, 0.1, 0.125, 0.15, 0.2]

    for interval in intervals:
        print(f"测试间隔: {interval}秒")
        time.sleep(1)

        try:
            pyautogui.doubleClick(interval=interval)
            print(f"✓ 间隔 {interval} 秒工作正常")
            return interval
        except Exception as e:
            print(f"✗ 间隔 {interval} 秒失败: {e}")

    return None


# 运行故障排除
optimal_interval = troubleshoot_double_click()
if optimal_interval:
    print(f"推荐使用间隔: {optimal_interval}秒")
else:
    print("请尝试其他解决方案")
'''