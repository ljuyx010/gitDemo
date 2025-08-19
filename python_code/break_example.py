# @version : 1.0
# @Author  : 混江龙
# @File    : break_example.py
# @Time    : 2025/8/19 21:23

# random.randint()函数生成随机数
# 使用random需要先导入模块
import random

k = 0
while True :
    num = random.randint(1, 100)
    print(num)
    k += 1
    if num == 97:
        break
print(f"循环了{k}次")
