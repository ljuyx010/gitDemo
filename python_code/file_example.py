# @version : 1.0
# @Author  : 混江龙
# @File    : file_example.py
# @Time    : 2025/9/9 11:16
import os.path

# 判断文件夹是否存在
path = "../img"
dir = os.path.isdir(path)
# print(dir)

# 获取文件夹下的文件方法1 获取文件及其属性
with os.scandir(path) as it:
    for entry in it:
        print(entry.name, entry.path,entry.is_dir(),entry.stat(), entry.stat().st_size)

# 方法2 只能获取文件名
# listdir = os.listdir(path)
# for item in listdir:
#     print(item)