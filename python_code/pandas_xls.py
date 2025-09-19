# @version : 1.0
# @Author  : 混江龙
# @File    : pandas_xls.py
# @Time    : 2025/9/18 15:41
import pandas as pd
# file = r"C:\Users\Administrator\Desktop\2024李俊工资自检表.xlsx"
# read_excel(io,sheet_name,header,names,index_col,usecols,squeeze,dtype...)
# df = pd.read_excel(file,'绩效')
# df.columns 读取出所有列名
# df.loc[i,column] 读取第i行的column列的值
# df的数据类型就是pd类创建的一个生成器
# print(df.isna())
# print(df.isnull())
# print(df["项目"])
# 统计提成和项目总额
"""
tc = 0
count = 0
for index, row in df.iterrows():
    # print(index, pd.isna(row['项目']))
    if not pd.isna(row['项目']):
        # print(index,row['提成'],row['项目金额'])
        if not pd.isna(row['提成']): tc += int(row['提成'])
        if not pd.isna(row['项目金额']): count += int(row['项目金额'])
print(tc, count)

print(df[df['提成'] > 1000])
"""
# pd.concat([生成器1，生成器2,...],ignore_index=True) 把多表纵向拼接
# 作用把生成器1的数据和生成器2的数据拼接起来
# 注意拼接的时候生成器的列名必须一致
# ignore_index=True 忽略原来的数据索引，重新索引

# df.to_excel(path,index=False) 写入excel文件，index=False则不把索引值的列写入文件

# 两个表横向拼接
# pd.merge(生成器1，生成器2,how='inner',on,left_on,right_on，left_index,right_index)
# how 是拼接方式有 left(左表为主)，right(右表为主)，outer(向外扩展，主表不存在副表的值，则填充none，以大表为主) ,inner(筛选两表都有的数据，以小表为主)
# on 作为拼接依据的列
# left_on 和 right_on 当两表的on的列名称不一致时使用
# left_index,right_index 当以两个表的index作为拼接的依据时，把这个两个改成True

# 读取网页中的表格
df = pd.read_html("https://s.askci.com/stock/xsb/")
print(df)