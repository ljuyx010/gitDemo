# @version : 1.0
# @Author  : 混江龙
# @File    : tools.py
# @Time    : 2025/9/1 19:40
"""
确认信息
"""


def confirm_enter():
    print("确认请输入Y，取消请输入N：", end=" ")
    while True:
        choice = input("")
        if choice.lower() == 'y' or choice.lower() == 'n':
            return choice.lower()
        print("输入错误，请重新输入:", end=" ")


def info_change(tag, default):
    new = input(tag)
    if new != "":
        return new
    else:
        return default
