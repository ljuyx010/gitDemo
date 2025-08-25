# @version : 1.0
# @Author  : 混江龙
# @File    : search_exercise.py
# @Time    : 2025/8/25 22:15
import random
from operator import index

# 随机生成10个整数（1-100范围）保存到列表，使用冒泡排序，对其从大到小排序
int_list = []
for i in range(10):
    int_list.append(random.randint(1, 100))

print("排序前".center(16, "*"))
print(int_list)


def bubble_sort(my_list):
    for j in range(len(my_list) - 1):  # 循环轮数元素个数-1
        for k in range(len(my_list) - 1 - j):  # 循环次数 元素个数-循环轮数
            if my_list[k] < my_list[k + 1]:
                my_list[k], my_list[k + 1] = my_list[k + 1], my_list[k]


bubble_sort(int_list)
print("排序后".center(16, "*"))
print(int_list)

print("==" * 30)


# 使用二分查找，查找上面的列表是否有8这个数，如果有，则返回对应的下标，
# 如果没有返回-1
def binary_search(my_list, item):
    find_index = -1
    low = 0
    high = len(my_list) - 1
    while low <= high:
        mid = (low + high) // 2
        if my_list[mid] > item:
            low = mid + 1
        elif my_list[mid] < item:
            high = mid - 1
        else:
            find_index = mid
            break
    return find_index


result = binary_search(int_list, 8)
if result == -1:
    print("没有找到元素")
else:
    print(f"找到{int_list}中8的下标为{result}")
