# @version : 1.0
# @Author  : 混江龙
# @File    : override_exercise.py
# @Time    : 2025/8/28 22:14
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def say(self):
        return "%s is %d years old" % (self.name, self.age)


class Student(Person):
    id = None
    score = None

    def __init__(self, name, age, id, score):
        # 调用父类的构造器，完成name，age初始化
        super().__init__(name, age)
        self.id = id
        self.score = score

    def say(self):
        return super().say(), "my id is %d,score is %d" % (self.id, self.score)

person = Person("chanpu", 80)
print(person.say())
student = Student("john", 90,10010,60)
print(student.say())