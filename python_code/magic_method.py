# @version : 1.0
# @Author  : 混江龙
# @File    : magic_method.py
# @Time    : 2025/8/29 17:46
class Person:
    def __init__(self, name, age, gender):
        self.name = name
        self.age = age
        self.gender = gender

    # 3.重写__eq__魔术方法
    def __eq__(self, other):
        # 首先判断other和self是否是同一个类
        if isinstance(other, Person):
            # 再比较内容是否相同，这样更为合理
            return (self.name == other.name and
                    self.age == other.age and
                    self.gender == other.gender)
        return False


p1 = Person('smith', 20, 'man')
p2 = Person('smith', 20, 'man')
print(f"p1 == p2:{p1 == p2}")