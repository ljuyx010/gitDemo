# @version : 1.0
# @Author  : 混江龙
# @File    : game.py
# @Time    : 2025/8/27 22:36
import random

class Game:
    def __init__(self, name):
        self.name = name
        self.loop = True
        self.res = {"choice": [], "computer": [], "win": []}
        print("请输入0,1,2参与游戏，输入9结束游戏，\n 0代表石头/1代表剪刀/2代表布")

    def play(self):
        """
        电脑随机生成 0 1 2 分别代表 石头，剪刀，布
        用户输入 0 1 2 参与比赛
        输入其他结束比赛，输出游戏结果
        :return:
        """
        while self.loop:
            choice = int(input("请输入您的选择："))
            if choice == 0 or choice == 1 or choice == 2:
                computer = random.randint(0, 2)
                self.res["computer"].append(computer)
                self.res["choice"].append(choice)
                if computer == choice:
                    win = "平"
                elif choice - computer == -1 or choice - computer == 2:
                    win = "赢"
                else:
                    win = "输"
                self.res["win"].append(win)
            elif choice == 9:
                self.loop = False
            else:
                print("输入错误，请输入正确数字")

        print("比赛结果如下：")
        print(self.name, "电脑", "结果")
        for i in range(len(self.res["choice"])):
            # print(i, self.res["choice"][i])
            print(f" {self.res["choice"][i]} \t {self.res["computer"][i]} \t {self.res["win"][i]}")
#测试游戏1
game = Game("龙哥")
game.play()