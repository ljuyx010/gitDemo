# @version : 1.0
# @Author  : 混江龙
# @File    : abstract_class_exercise.py
# @Time    : 2025/8/30 17:23
from abc import ABC, abstractmethod


class Employee(ABC):
    name = None
    id = None
    __salary = None

    def __init__(self, name, id, salary):
        self.name = name
        self.id = id
        self.__salary = salary

    @abstractmethod
    def work(self):
        pass


class CommonEmployee(Employee):
    def work(self):
        print(f"普通员工 {self.name} 工作中...")


class Manager(Employee):
    __bonus = None

    def __init__(self, name, id, salary, bonus):
        super().__init__(name, id, salary)
        self.__bonus = bonus

    def work(self):
        print(f"经理 {self.name} 工作中...")

satff = CommonEmployee("张三",123,3000)
satff.work()
manager = Manager("高经理", 102, 6000,8000)
manager.work()