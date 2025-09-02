# @version : 1.0
# @Author  : 混江龙
# @File    : house_view.py
# @Time    : 2025/9/2 14:07
"""
界面类：展示程序界面
"""
from house_sever import *
from unitiy import *
class HouseView:
    house_controller:HouseServer = HouseServer()

    #  退出系统
    def exit_sys(self):
        print("退出程序".center(20, '='))
        choice = Unitiy().confirm()
        if choice == 'y':
            return True
        return False

    # 修改房屋信息
    def update_house(self):
        print("修改房屋信息".center(20, '='))
        id = int(input("请输入房屋信息的id(-1退出):"))
        if id == -1:
            return
        house = self.house_controller.find_by_id(id)
        if house:
            house.name = Unitiy().input_tag(f"姓名({house.name})：", house.name)
            house.phone = Unitiy().input_tag(f"电话({house.phone})：", house.phone)
            house.address = Unitiy().input_tag(f"地址({house.address})：", house.address)
            house.rent = int(Unitiy().input_tag(f"租金({house.rent})：", house.rent))
            house.state = Unitiy().input_tag(f"状态({house.state})：", house.state)
            print("修改成功".center(20, '='))
        else:
            print("未找到对应信息的房屋".center(20, '='))

    # 删除房屋
    def del_house(self):
        print("删除房屋信息".center(20, '='))
        id = int(input("请输入要删除房屋信息的id(-1退出):"))
        if id == -1:
            return
        house = self.house_controller.find_by_id(id)
        if house:
            choice = Unitiy().confirm()
            if choice == 'y':
                self.house_controller.del_by_obj(house)
                print("删除成功".center(20, '='))
        else:
            print("删除失败，未找到对应信息的房屋")

    # 查找房屋
    def find_house(self):
        print("查找房屋信息".center(20, '='))
        id = int(input("请输入房屋信息的id(-1退出):"))
        if id == -1:
            return
        house = self.house_controller.find_by_id(id)
        if house:
            print("ID\t\t房主\t\t电话\t\t地址\t\t租金\t\t状态")
            print(house)
        else:
            print("没有找到相应的房屋信息")

    # 添加房屋信息
    def add_house(self):
        print("添加房屋信息".center(30, '='))
        name = input("姓名：")
        phone = input("电话：")
        address = input("地址：")
        rent = int(input("租金："))
        state = input("状态(未租出/已租出)：")
        house = House(0, name, phone, address, rent, state)
        self.house_controller.add(house)
        print("房屋信息添加成功".center(30, '='))


    # 展示房屋列表
    def house_list(self):
        print("房屋信息列表".center(30, '='))
        # 表头信息
        print("ID\t\t房主\t\t电话\t\t地址\t\t租金\t\t状态")
        houses = self.house_controller.get_houses()
        for house in houses:
            print(house)
        print("没有更多房屋信息".center(30, '='))

    def menu(self):
        while True:
            print()
            print("房屋出租系统菜单".center(30, '='))
            print("\t\t1\t新\t增\t房\t源")
            print("\t\t2\t查\t找\t房\t屋")
            print("\t\t3\t删\t除\t房\t屋\t信\t息")
            print("\t\t4\t修\t改\t房\t屋\t信\t息")
            print("\t\t5\t房\t屋\t列\t表")
            print("\t\t6\t退\t\t出")
            key = input("请输入你的选择(1-6):")
            if key == '1':
                self.add_house()
            elif key == '2':
                self.find_house()
            elif key == '3':
                self.del_house()
            elif key == '4':
                self.update_house()
            elif key == '5':
                self.house_list()
            elif key == '6':
                if self.exit_sys():
                    break