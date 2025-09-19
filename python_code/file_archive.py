# @version : 1.0
# @Author  : 混江龙
# @File    : file_archive.py
# @Time    : 2025/9/19 15:30
# 整理文件归档
import os
import  shutil
import glob

# 设置分类汇总的文件夹
mkdir_path = r'E:\桌面\归档文件'
goal_dir = r'E:\桌面'
# 如果文件夹不存在就创建
if not os.path.exists(mkdir_path):
    os.makedirs(mkdir_path)
# 取出全部的文件 recursive递归
all = glob.glob(r'E:\桌面/**/*', recursive=True)
# print(all)
# 循环取出一个个文件
for file in all:
    if os.path.isfile(file):
        # 取后缀名
        suffix = file.split('.')[-1]
        # 判断后缀名是否是文档类的文件
        if suffix in ['doc','docx','txt','xls', 'xlsx','ppt','pptx']:
            # print(file)
            # 文件拷贝到归队文件夹
            shutil.copy(file, mkdir_path)