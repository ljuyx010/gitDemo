# @version : 1.0
# @Author  : 混江龙
# @File    : calssa.py
# @Time    : 2025/9/3 15:02
from  classb import *
class A:
    def get_a(self):
        C().get_c()
        print("<UNK>A<UNK>")

a = A()
a.get_a() #结果可以看到，多级引用时，顶级的可以直接使用多级下的方法