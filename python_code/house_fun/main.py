# @version : 1.0
# @Author  : 混江龙
# @File    : main.py
# @Time    : 2025/9/1 19:40
"""
程序入口文件
"""
import menu

def main():
    while True:
        key = menu.menu()
        if key == '1':
            menu.add_house()
        elif key == '2':
            menu.find_house()
        elif key == '3':
            menu.del_house()
        elif key == '4':
            menu.update_house()
        elif key == '5':
            menu.list_house()
        elif key == '6':
            if menu.exit() :
                break

if __name__ == '__main__':
    main()