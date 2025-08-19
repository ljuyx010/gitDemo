# @version : 1.0
# @Author  : 混江龙
# @File    : loop_test.py
# @Time    : 2025/8/19 17:11

# 打印空心菱形

"""
  思路分析：空心金字塔已经可以输出
  把金字塔正着和倒着输出一遍就是个菱形
"""
# 先正着输出一遍

total_level = 9  # 总层高
up_level = total_level // 2  # 向上输出的层高
down_level = total_level - up_level  # 向下输出的层高
for i in range(1, up_level + 1):
    for k in range(up_level - i + 1):  # 每行输出的空格数为总层减当前层+1
        print(" ", end="")  # 输出第一个星前面的空格
    for j in range(2 * i - 1):  # 每层输出的星总个数
        if j == 0 or j == 2 * (i - 1):  # 如果是每行的第一个和每行的最后一个星就输出
            print("*", end="")
        else:
            print(" ", end="")  # 否则就输出空格
    print("")
# 倒着输出一遍
d = 1  # 当前层
while down_level >= d:
    for k in range(d - 1):  # 每行输出的空格数为当前层-1
        print(" ", end="")
    for j in range(2 * (down_level - d) + 1):  # 每层输出的星总个数=2*（总层-当前层数）+1
        if j == 0 or j == 2 * (down_level - d):  # 如果是每行的第一个和每行的最后一个星就输出
            print("*", end="")
        else:
            print(" ", end="")  # 否则就输出空格
    print("")
    d += 1

# 打印出九九乘法表

for i in range(1, 10):
    for j in range(1, i+1):
        print(f"{i} X {j} = {i*j} ", end=" ")
    print("")