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

# 16进制
print(0x10)

# 8进制
print(0o10)

# 2进制
print(0b10)

p = 2 ** 100
# 在python中可以通过sys.getsizeof(obj)返回obj的大小（按照字节单位返回）
print(sys.getsizeof(p))

print(sys.float_info.max)
print(sys.float_info.min)

# 布尔类型
num1 = 100
num2 = 200
if num1 > num2:
    print("num>num2")
result = num1 > num2
print("result=", result)

# 原样输出字符串
cont = """
def any(iterable):
    for element in iterable:
        if element:
            return True
    return False
"""
print(cont)
str = r"jack \n tom \t jeron"
print(str)

str1 = "hello"
str2 = "hello"
str3 = "hello"
# id()函数，可以返回对象/数据的内存地址
print("str1的地址：", id(str1))
print("str2的地址：", id(str2))
print("str3的地址：", id(str3))

str1 = "abc#"
str2 = "abc#"
print(id(str1) == id(str2))

# 进制转换
print(0b110001100) # => 1*2**2+1*2**3+1*2**7+1*2**8 =4+8+128+256=396
print(0o2456) # =>6+40+4*64+2*512=1326
print(0XA45) # =>5+4*16+10*16**2=5+64+2526=2629

# 10进制转其他
print(bin(123))
# 计算过程
# 123/2=61  ...1
# 61/2=30 ...1
#30/2=15 ...0
# 15/2=7 ...1
# 7/2=3 ...1
# 3/2=1 ...1
# 1
#结果是0B1111011
print(oct(678))
# 计算过程如下
# 678/8=84 ...6
# 84/8=10 ...4
# 10/8=1 ...2
# 1
# 结果 0o1246
print(hex(8912))
# 计算过程如下
# 8912/16=557 ...0
# 557/16=34 ...13=>d
# 34/16=2 ...2
# 2
# 结果 0X22d0