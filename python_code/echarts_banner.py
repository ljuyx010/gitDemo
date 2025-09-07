# @version : 1.0
# @Author  : 混江龙
# @File    : echarts_banner.py
# @Time    : 2025/9/7 15:13
from pyecharts import options as opts
from pyecharts.charts import Bar, Timeline
from pyecharts.faker import Faker
from pyecharts.globals import ThemeType

# 目标：2005年-2024年全面人口排名12身份轮播图
with open("分省年度数据.csv", 'r', encoding='gbk') as f:
    file_data = f.readlines()
# 清理前3行和最后2行
for i in range(5):
    if i < 3:
        file_data.pop(0)
    else:
        file_data.pop(-1)
# 最终有用的数据
all_year = file_data.pop(0).replace("\n", "").split(',')
all_year.pop(0)
# 组合年份城市数据{"2005年":[["北京",655],["上海",354]...]}
rank_data = {}
# print(file_data)
k = 0
for year in all_year:
    if year not in list(rank_data):
        rank_data[year] = []
    k += 1
    for line in file_data:
        line = line.replace("\n", "").split(',')
        rank_data[year].append([line[0], int(line[k])])
# y轴数据排序
for year in list(rank_data):
    rank_data[year] = sorted(rank_data[year], key=lambda x: x[1], reverse=True)
    # 切片只保留12个
    rank_data[year] = rank_data[year][0:12]
# y_data = dict(sorted(y_data.items(), key=lambda item: item[1], reverse=True))
# print(rank_data)
# 年份逆序
all_year.reverse()
# 遍历年份，创建bar对象
# 创建时间轴对象
tl = Timeline({"theme":ThemeType.ESSOS})
for year in all_year:
    # 定义Bar的x轴数据
    x_data = []
    # 定义bar的Y轴数据
    y_data = []
    for item in rank_data[year]:
        # print(item)
        x_data.append(item[0])
        y_data.append(item[1])

    bar = Bar()
    # 反转x轴数据（从小到大）
    x_data.reverse()
    bar.add_xaxis(x_data)
    # 反转y_data的数据和X轴保持一致（从小到大）
    y_data.reverse()
    bar.add_yaxis("人口(万)",y_data, label_opts=opts.LabelOpts(position="right"))
    # 转换X和y轴
    bar.reversal_axis()
    # 全局配置 轮播标题，bar的内容必须写在一起，不然不生效
    bar.set_global_opts(title_opts=opts.TitleOpts(title=f"{year}全国人口排名前12省市排名"))
    # 时间轴添加年份
    tl.add(bar, year)
#     对时间线配置
tl.add_schema(play_interval=500,is_auto_play=True)
tl.render("timeline_bar_reversal.html")




# 原始案例
# tl = Timeline()
# for i in range(2015, 2020):
#     bar = (
#         Bar()
#         .add_xaxis(Faker.choose())
#         .add_yaxis("商家A", Faker.values(), label_opts=opts.LabelOpts(position="right"))
#         .add_yaxis("商家B", Faker.values(), label_opts=opts.LabelOpts(position="right"))
#         .reversal_axis()
#         .set_global_opts(
#             title_opts=opts.TitleOpts("Timeline-Bar-Reversal (时间: {} 年)".format(i))
#         )
#     )
#     tl.add(bar, "{}年".format(i))
# tl.render("timeline_bar_reversal.html")
