# @version : 1.0
# @Author  : 混江龙
# @File    : house_sever.py
# @Time    : 2025/9/2 14:08
"""
房屋处理类
"""
from house import *
class HouseServer:
    list = []
    id_counter = 1 #自增记录id值

    def __init__(self):
        house = House(1,"tim","111","广场街",600,"未出租")
        self.list.append(house)

    def del_by_obj(self,house):
        self.list.remove(house)


    def find_by_id(self,id):
        for house in self.list:
            if house.id == id:
                return house

    def add(self, house:House):
        self.id_counter += 1
        house.id = self.id_counter
        self.list.append(house)

    def get_houses(self):
            return self.list