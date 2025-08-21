# @version : 1.0
# @Author  : 混江龙
# @File    : recursion_exercise.py
# @Time    : 2025/8/21 14:39

# 求整数n的斐波那契数

def fnb(n):
    """
    功能：返回n对应的斐波那契数
    :param n: 接收一个整数n>=1
    :return:
    """
    if n == 1 or n == 2:
        return 1
    #如果n>2则对应的斐波那契数为n-1 和 n-2对应的斐波那契数的和
    else:
        return fnb(n - 1) + fnb(n - 2)

# print(fnb(7))

# 猴子吃桃子问题：一堆桃子，猴子第一天吃其中一半，并多吃了一个，
# 以后每天都吃其中的一半，然后多吃一个，第10天只有1个桃子了，问共有多少桃子

def eat(day):
    """
    功能：求原来桃子的个数
    :param day: 接收一个天数
    :return: 返回桃子个数
    """
    if day == 10: #如果是第10天就只剩下1个
        return 1
    else:
        total= 2 * (eat(day+1) + 1)
        return total

# print(eat(1))

def hanoi_tower(num,a,b,c):
    """
    功能：汉诺塔游戏输出指定num个盘子移动的顺序
    :param num: 盘子个数
    :param a: 表示A柱子
    :param b: 表示B柱子
    :param c: 表示C柱子
    :return:
    """
    #如果只有一个盘
    if num == 1:
        print("第1个盘从:", a, "->", c)
    else:
        #有多个盘，我们认为只有两个，上面所有的盘和最下面的盘
        #移动上面所有的盘到B柱子，这个过程会借助到C柱子
        hanoi_tower(num-1,a,c,b)
        #移动最下面的盘
        print(f"第{num}个盘从: {a} -> {c}")
        #把上面所有的盘从b柱子移动到C柱子，这个过程会使用到A柱子
        hanoi_tower(num-1,b,a,c)

hanoi_tower(3,"A","B","C")