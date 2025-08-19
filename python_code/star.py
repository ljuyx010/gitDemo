# @version : 1.0
# @Author  : 混江龙
# @File    : star.py
# @Time    : 2025/8/19 15:03

'''
打印金字塔
 -先死后活
 1.先不考虑层数的变化，假定就是5层，后面做活
 -化繁为简
 1.打印矩形
 2.打印直角三角形
 3.打印金字塔
 4.打印空心金字塔
'''
"""
# 打印5层矩形
i = 1
j = 1
star = ''
while i <= 5:
    while j <= 5:
        star += "*"
        j +=1
    print(star)
    i +=1

print("-------------------------------")
#使用for循环输出5层※
for i in range(5):
    for j in range(5):
        print("*",end="") #end =""表示输出后不换行
    print("")
"""

# 打印直角三角形
for i in range(1, 6):
    for j in range(i):
        print("*", end="")
        j += 1
    print("")

# 打印金字塔
#      *      1层：1个*  2X1-1 空格数 4
#     ***     2层：3个*  2X2-1 空格数 3
#    *****    3层：5个*  2X3-1 空格数 2
#   *******   4层：7个*  2X4-1 空格数 1
#  *********  5层:9个*  2Xn-1  空格数 0  总层数-n
for i in range(1, 6):
    for j in range(2 * i - 1):
        print("*", end="")
    print("")

for i in range(1, 6):
    for k in range(5 - i):
        print(" ", end="")
    for j in range(2 * i - 1):
        print("*", end="")
    print("")

"""
打印空心金字塔
    *        1层第一个*后0个空格
   * *       2层第一个*后1个空格
  *   *      3层第一个*后3个空格
 *     *     4层第一个*后5个空格
*********    最后一层没有空格
"""
# for i in range(1,6):
#     for k in range(5-i):
#         print(" ",end="")
#     if i==1 or i==5:
#         for j in range(2 * i - 1):
#             print("*",end="")
#     else:
#         print("*", end="")
#         for m in range(2*i - 3):
#             print(" ", end="")
#         print("*", end="")
#     print("")

for i in range(1, 6):
    for k in range(5 - i):  # 每行输出的空格数为总层减当前层
        print(" ", end="")  # 输出第一个星前面的空格
    for j in range(2 * i - 1):  # 每层输出的星总个数
        if j == 0 or j == 2 * (i - 1) or i == 5:  # 如果是最后一行或者是每行的第一个和每行的最后一个星就输出
            print("*", end="")
        else:
            print(" ", end="")  # 否则就输出空格
    print("")

# 先死后活，把层数改成不固定
total_level = 10
for i in range(1, total_level + 1):
    for k in range(total_level - i):  # 每行输出的空格数为总层减当前层
        print(" ", end="")  # 输出第一个星前面的空格
    for j in range(2 * i - 1):  # 每层输出的星总个数
        if j == 0 or j == 2 * (i - 1) or i == total_level:  # 如果是最后一行或者是每行的第一个和每行的最后一个星就输出
            print("*", end="")
        else:
            print(" ", end="")  # 否则就输出空格
    print("")

# 把代码转成while循环写出来
total_level = 8
i = 1
while i <= total_level:
    k = 1
    while k <= total_level - i:  # 每行输出的空格数为总层减当前层
        print(" ", end="")  # 输出第一个星前面的空格
        k += 1
    j = 1
    while j <= 2 * i - 1:  # 每层输出的星总个数
        if j == 1 or j == 2 * i - 1 or i == total_level:  # 如果是最后一行或者是每行的第一个和每行的最后一个星就输出
            print("*", end="")
        else:
            print(" ", end="")  # 否则就输出空格
        j += 1
    i += 1
    print("")
