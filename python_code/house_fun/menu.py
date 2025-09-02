# @version : 1.0
# @Author  : 混江龙
# @File    : menu.py
# @Time    : 2025/9/1 19:40
# 全局变量
from house_fun.tools import info_change
from tools import confirm_enter

list_houses = [{'id': 1, 'name': 'tom', 'phone': '114', 'address': '孝南', 'rent': 600, 'state': '未出租'}]
id_cent = 1
"""
菜单方法
"""


def menu():
    print("房屋出租系统菜单".center(20, '='))
    print("1\t新\t增\t房\t源")
    print("2\t查\t找\t房\t屋")
    print("3\t删\t除\t房\t屋\t信\t息")
    print("4\t修\t改\t房\t屋\t信\t息")
    print("5\t房\t屋\t列\t表")
    print("6\t退\t\t出")
    key = input("请输入你的选择(1-6):")
    return key


def add_house():
    print("添加房屋信息".center(20, '='))
    name = input("姓名：")
    phone = input("电话：")
    address = input("地址：")
    rent = int(input("租金："))
    state = input("状态(未租出/已租出)：")
    global id_cent
    id_cent += 1
    house = {'id': id_cent, 'name': name, 'phone': phone,
             'address': address, 'rent': rent, 'state': state}
    list_houses.append(house)
    print("房屋信息添加成功".center(20, '='))


"""
查找房屋
"""


def find_house():
    print("查找房屋信息".center(20, '='))
    h_id = int(input("请输入房屋信息的id(-1退出):"))
    if h_id == -1:
        return
    house = find_by_id(h_id)
    if house:
        print("ID\t房主\t电话\t地址\t租金\t状态")
        for value in house.values():
            print(value, end='\t')
        print()
    else:
        print("没有找到相应的房屋信息")


"""
删除房屋信息
"""


def del_house():
    print("删除房屋信息".center(20, '='))
    h_id = int(input("请输入要删除房屋信息的id(-1退出):"))
    if h_id == -1:
        return
    house = find_by_id(h_id)
    if house:
        choice = confirm_enter()
        if choice == 'y':
            list_houses.remove(house)
            print("删除成功".center(20, '='))
    else:
        print("删除失败，未找到对应信息的房屋")


"""
修改房屋信息
"""


def update_house():
    print("修改房屋信息".center(20, '='))
    id = int(input("请输入房屋信息的id(-1退出):"))
    if id == -1:
        return
    house = find_by_id(id)
    if house:
        house['name'] = info_change(f"姓名({house['name']})：", house['name'])
        house['phone'] = info_change(f"电话({house['phone']})：", house['phone'])
        house['address'] = info_change(f"地址({house['address']})：", house['address'])
        house['rent'] = int(info_change(f"租金({house['rent']})：", house['rent']))
        house['state'] = info_change(f"状态({house['state']})：", house['state'])
        print("修改成功".center(20, '='))
    else:
        print("未找到对应信息的房屋".center(20, '='))


"""
通过id查找房屋
"""


def find_by_id(find_id):
    for house in list_houses:
        if house['id'] == find_id:
            return house
    return None


"""
房屋列表
"""


def list_house():
    print("房屋信息列表".center(20, '='))
    # 表头信息
    print("ID\t\t房主\t\t电话\t\t地址\t\t租金\t\t状态")
    for house in list_houses:
        for value in house.values():
            print(value, end='\t\t')
        print()
    print("没有更多房屋信息".center(20, '='))


"""
退出程序
"""


def sys_exit():
    print("退出程序".center(20, '='))
    choice = confirm_enter()
    if choice == 'y':
        print("感谢您的使用，欢迎下次再见...")
        return True
    return False
