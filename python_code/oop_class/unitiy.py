# @version : 1.0
# @Author  : 混江龙
# @File    : unitiy.py
# @Time    : 2025/9/2 16:48
"""
工具类：各种工具方法写在这里
"""
class Unitiy:

    def confirm(self):
        print("确认请输入Y，取消请输入N：", end=" ")
        while True:
            choice = input("")
            if choice.lower() == 'y' or choice.lower() == 'n':
                return choice.lower()
            print("输入错误，请重新输入:", end=" ")

    def input_tag(self, tag, default):
        new = input(tag)
        if new != "":
            return new
        else:
            return default