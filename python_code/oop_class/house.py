# @version : 1.0
# @Author  : 混江龙
# @File    : house.py
# @Time    : 2025/9/2 14:08
"""
房屋数据对象
"""


class House:

    # 重新魔术方法__str__
    def __str__(self):
        return f"{self.id}\t\t{self.name}\t\t{self.phone}\t\t{self.address}\t\t{self.rent}\t\t{self.state}"

    def __init__(self, id, name, phone, address, rent, state):
        self.name = name
        self.phone = phone
        self.address = address
        self.rent = rent
        self.state = state
        self.id = id
