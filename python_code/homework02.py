# @version : 1.0
# @Author  : 混江龙
# @File    : homework02.py
# @Time    : 2025/9/4 15:19
"""
1.实现登录验证，如果用户名是列表中的元素["smith","tom","hsp"],密码"888"则登录成功，否则失败
2.不管登录是否成功，都需要再文件中记录登录的信息
3.登录成功，可以看到相应的操作菜单提示，请实现相应的功能
"""
import time
def index():
    user = input("请输入登录账号：")
    pwd = input("请输入登录密码：")
    log = open("./login.log", "a", encoding="utf-8")
    stat = "登录成功"
    if not (user in ["smith","tom","hsp"] and pwd=="888"):
        stat = "登录失败"
        print(stat)
        log.write(f"用户名{user}，登录密码{pwd}于{time.strftime('%Y-%m-%d %H:%I:%S')}尝试登录，{stat}\n")
        return
    print(stat)
    log.write(f"用户名{user}，登录密码{pwd}于{time.strftime('%Y-%m-%d %H:%I:%S')}尝试登录，{stat}\n")
    log.close()
    menu = login(user)
    menu.menu()

class login:
    def __init__(self,user):
        self.user = user

    def menu(self):
        while True:
            print()
            print("请选择操作".center(32,"="))
            print("\t\t1\t查\t看\t当\t前\t登\t录\t用\t户")
            print("\t\t2\t查\t看\t登\t录\t日\t志")
            print("\t\t3\t退\t\t出")
            key = input("请输入你的选择(1-3):")
            if key == "1":
                print(f"当前登录用户：{self.user}")
            elif key == "2":
                with open("./login.log", "r", encoding="utf-8") as f:
                    for line in f:
                        print(line,end="")
            elif key == "3":
                print("退出成功")
                break

if __name__ == '__main__':
    index()