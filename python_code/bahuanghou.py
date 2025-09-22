# @version : 1.0
# @Author  : 混江龙
# @File    : bahuanghou.py
# @Time    : 2025/9/22 09:12

# 定义一个8X8的棋盘
map = [[0 for x in range(8)] for y in range(8)]
solutions = []  # 存储所有解决方案


def down(n=0):
    """
    尝试放下一个皇后并判断是否冲突，如果不冲突则放置下一个，如果冲突则撤回，尝试下一个位置
    :param n: 当前要放置的第几个皇后（0-7）
    :return:
    """
    if n == 8:
        # 找到一个解决方案，保存当前棋盘状态
        solution = []
        for i in range(8):
            row = []
            for j in range(8):
                row.append(1 if map[i][j] == 1 else 0)
            solution.append(row)
        solutions.append(solution)
        return

    for j in range(8):
        if not jude(n, j):
            # 当前位置可以放置皇后
            map[n][j] = 1
            # 递归放置下一个皇后
            down(n + 1)
            # 回溯，撤销当前选择
            map[n][j] = 0


def jude(x, y):
    """
    判断在(x,y)位置放置皇后是否会与已有皇后冲突
    :param x: 行
    :param y: 列
    :return: Boolean True表示冲突，False表示不冲突
    """
    # 检查同一列是否有皇后
    for i in range(x):
        if map[i][y] == 1:
            return True

    # 检查左上对角线是否有皇后
    i, j = x - 1, y - 1
    while i >= 0 and j >= 0:
        if map[i][j] == 1:
            return True
        i -= 1
        j -= 1

    # 检查右上对角线是否有皇后
    i, j = x - 1, y + 1
    while i >= 0 and j < 8:
        if map[i][j] == 1:
            return True
        i -= 1
        j += 1

    return False


if __name__ == '__main__':
    down()
    print(f"共有 {len(solutions)} 种解决方案")

    # 打印解决方案
    s = 0
    for solution in solutions:
        s += 1
        print(f"\n第{s}个解决方案：")
        for i in solution:
            for j in i:
                print("Q " if j == 1 else ". ", end="")
            print()