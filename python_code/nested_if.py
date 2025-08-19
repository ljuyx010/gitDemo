# @version : 1.0
# @Author  : 混江龙
# @File    : nested_if.py
# @Time    : 2025/8/19 10:23

#参加歌手比赛，如果初赛成绩大于8.0进入决赛，否则提示淘汰。
# 并且根据性别提示进入男子组或女子组。
# 输入成绩和性别，进行判断

# score = float(input("请输入初赛成绩："))
# if score > 8.0:
#     sex = input("请输入性别（男|女）：")
#     if sex == "男" :
#         print("进入男子组决赛")
#     else:
#         print("进入女子组决赛")
# else :
#     print("淘汰")

# 出票系统，根据淡旺季的月份和年龄，打印票价
# 4-10旺季：
#   成人(18-60):60
#   儿童（<18）:半价
#   老人（>60）:1/3
# 淡季：
#   成人：40
#   其他：20

month = int(input("请输入购票月份："))
age = int(input("请输入游客年龄："))
price = 60
if 4 <= month <= 10 :
    if 18 <= age <= 60 :
        price = price
    elif age < 18:
        price = price/2
    else:
        price = price/3
else :
    if 18 <= age <= 60 :
        price = 40
    else:
        price = 20

print(f"游客的票价位{price}元")
