# @version : 1.0
# @Author  : 混江龙
# @File    : poly_exercise.py
# @Time    : 2025/8/29 15:47

class Employee:
    """
    私有属性姓名，月工资
    计算年工资方法get_annual()
    """
    __name = None
    __salary = None

    def __init__(self, name, salary):
        self.__name = name
        self.__salary = salary

    def get_annual(self):
        return self.__salary * 12
    def set_name(self, name):
        self.__name = name
    def get_name(self):
        return self.__name
    def set_salary(self, salary):
        self.__salary = salary
    def get_salary(self):
        return self.__salary

class Worker(Employee):
    # def __init__(self, name, salary):
    #     super().__init__(name, salary)

    def work(self):
        print("这是一个工作方法")

    # def get_annual(self):
    #     return self.get_salary() * 13

class Manager(Employee):
    __bonus = None
    def __init__(self, name, salary, bonus):
        super().__init__(name, salary)
        self.__bonus = bonus

    def get_annual(self):
        return super().get_annual() + self.__bonus

    def manage(self):
        print("这是一个管理方法")

#使用类的多态，实现不同对象调用相同的方法
def show_emp_annual(e:Employee):
    print(f"{e.get_name()}的年工资是{e.get_annual()}")

def working(e:Employee):
    if isinstance(e, Worker):
        e.work()
    elif isinstance(e, Manager):
        e.manage()
    else:
        print("对象不正确")

worker = Worker("老张", 5000)
manager = Manager("高总", 8000, 6000)
show_emp_annual(worker)
show_emp_annual(manager)
working(worker)
working(manager)