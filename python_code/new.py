# @version : 1.0
# @Author  : 混江龙
# @File    : new.py
# @Time    : 2025/8/15 14:16
import sys

age = 20
score = 78
sex = "男"
name = "张三"
# %操作符输出
# print("姓名：%s %d %s %.1f" % (name,age,sex,score))
# format()函数
# print("姓名：{} {} {}" .format(name,sex,score))
# f-strings 格式化
# print(f"姓名：{name} {sex} {score}")
# print(100 + 100)
# print("100" + "100")
# 获取变量的数据类型
# print("age:", type(age))

# 10进制
print(10)

#16进制
print(0x10)

#8进制
print(0o10)

#2进制
print(0b10)

p=2**100
# 在python中可以通过sys.getsizeof(obj)返回obj的大小（按照字节单位返回）
print(sys.getsizeof(p))

print(sys.float_info.max)
print(sys.float_info.min)