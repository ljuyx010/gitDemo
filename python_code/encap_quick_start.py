# @version : 1.0
# @Author  : 混江龙
# @File    : encap_quick_start.py
# @Time    : 2025/8/28 11:36
# 创建父类Base，看构造方法是否都会执行
class Base:
    def __init__(self):
        print("父类的构造方法执行了")
    def set_name(self, name):
        self.name = name

class Clerk(Base):
    name =  None
    __job = None
    __salary = None

    # def __init__(self,name, job, salary):
    #     self.name = name
    #     self.__job = job
    #     self.__salary = salary
    #     print("子类的构造器执行")

    def set_job(self, job):
        self.__job = job

    def get_job(self):
        return self.__job

# clerk = Clerk("tiger", "Python工程师", 20000)
clerk = Clerk()
clerk.name = "jack"
clerk.set_job("php工程师")
print(clerk.name)
# print(clerk.__job)  访问私有属性直接报错
print(clerk.get_job())