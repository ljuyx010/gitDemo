# @version : 1.0
# @Author  : 混江龙
# @File    : homework01.py
# @Time    : 2025/8/27 20:54
from tkinter.font import names

# class A01:
#     def __init__(self):
#         pass
#
#     def get_max(self, float):
#         max = 0.0
#         i = 0
#         while i < len(float):
#             if float[i] > max:
#                 max = float[i]
#             i += 1
#         return max
#
#
# list = [1.1, 2.9, -1.9, 67.9]
# p = A01()
# print("list的最大值是：", p.get_max(list))

# class Book:
#     def __init__(self,name,price):
#           slef.name = name
#           slef.price = price

#     def update_price(self, price):
#         if price > 150:
#             self.price = 150
#         elif price > 100:
#             self.price = 100
#         else:
#               pass
#      def info(self):
#           print(f"{self.name}的价格为{self.price}")
#
# book = Book()
# book.update_price("红楼梦",200)
# book.info()

# class Circle:
#     r = None
#
#     def __init__(self, r):
#         self.r = r
#
#     def zhou(self):
#         PI = 3.14
#         print("圆的周长为:", round(2 * PI * self.r, 2))
#
#
# c = Circle(10)
# c.zhou()

class Cal:
    num1 = 0
    num2 = 0

    def total(self):
        return self.num1 + self.num2

    def cha(self):
        js = input("请输入谁为被减数(num1|num2):")
        if js == "num1":
            return self.num1 - self.num2
        elif js == "num2":
            return self.num2 - self.num1
        else:
            print("输入错误")
            self.cha()

    def ji(self):
        return self.num1 * self.num2

    def shang(self):
        cs = input("请输入谁为被除数(num1|num2):")
        if cs == "num1":
            if self.num2 != 0:
                return self.num1 / self.num2
            else:
                return ("错误，除数不能为0哦")
        elif cs == "num2":
            if self.num1 != 0:
                return self.num2 / self.num1
            else:
                return ("错误，除数不能为0哦")
        else:
            print("输入错误")
            self.shang()


cal = Cal()
cal.num1 = 0
cal.num2 = 20
print("和为", cal.total())
print("差为", cal.cha())
print("积为", cal.ji())
print("商为", cal.shang())
