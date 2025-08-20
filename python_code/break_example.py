# @version : 1.0
# @Author  : 混江龙
# @File    : break_example.py
# @Time    : 2025/8/19 21:23

# random.randint()函数生成随机数
# 使用random需要先导入模块
# import random
#
# k = 0
# while True :
#     num = random.randint(1, 100)
#     print(num)
#     k += 1
#     if num == 97:
#         break
# print(f"循环了{k}次")

# 某人有100000元，每经过一个路口，需要缴费，
# 当现金>50000时，每次交5%，
# 当现金<=50000时，每次交1000
# 使用while - break统计该人可以经过多少次路口
money = 100000
roade = 0
while True :
    if money > 50000:
        money -= 0.05*money
        roade += 1
    elif money >= 1000:
        money -= 1000
        roade += 1
    else:
        break

print(f"可以经过{roade}次路口")