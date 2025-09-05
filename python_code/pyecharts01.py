# @version : 1.0
# @Author  : 混江龙
# @File    : pyecharts01.py
# @Time    : 2025/9/5 10:11
from pyecharts import options as opts
from pyecharts.charts import Pie, Line
from pyecharts.faker import Faker
from pyecharts.options import TitleOpts

"""
创建饼状图
1.pie()创建了pie对象
2..add()给饼状图添加数据
3..set_global_opts()设置全局配置项
4..set_series_opts()设置标签配置项
formatter="{b}: {c}"表示标签显示的形式是 名称：值
"""
# data = [['衬衫',138],['毛衣',40],['领带',74],['裤子',112],['风衣',147],['高跟鞋',104],['袜子',65]]
# c = (
#     Pie()
#     .add("商品销量", data)
#     .set_global_opts(title_opts=opts.TitleOpts(title="Pie-商品销售情况"),toolbox_opts=opts.ToolboxOpts(is_show=True))
#     .set_series_opts(label_opts=opts.LabelOpts(formatter="{b}: {c}",font_size=14))
#     .render("pie_base.html")
# )

# print([list(z) for z in zip(Faker.choose(), Faker.values())])


# 折线图案例
# 打开文件获取数据
file = open("分省年度数据.csv",'r',encoding='gbk')
data = file.readlines()
file.close()
for _ in range(3):
    data.pop(0)
data_year = data.pop(0).replace('\n', '').split(',')
data_year.pop(0)
data_year.reverse()
# x轴数据完成
x_data = data_year

#处理y轴四个直辖市的数据
bj_data = []
tj_data = []
sh_data = []
cq_data = []
for line in data:
    line = line.replace('\n', '').split(',')
    if line[0] == '北京市':
        line.pop(0)
        line.reverse()
        bj_data = line
    elif line[0] == '天津市':
        line.pop(0)
        line.reverse()
        tj_data = line
    elif line[0] == '上海市':
        line.pop(0)
        line.reverse()
        sh_data = line
    elif line[0] == '重庆市':
        line.pop(0)
        line.reverse()
        cq_data = line
# x_data = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
# y_data = [820, 932, 901, 934, 1290, 1330, 1320]
#
#
linecharts = Line()
linecharts.set_global_opts(
    title_opts=TitleOpts(
        is_show=True,
        title='2005-2024年直辖市总人口折线图',
        pos_bottom='1%',
        pos_right='center'
    )
)
linecharts.add_xaxis(xaxis_data=x_data)
linecharts.add_yaxis(
    series_name="北京市",
    y_axis=bj_data,
    symbol="emptyCircle",
    is_symbol_show=True,
    label_opts=opts.LabelOpts(is_show=False),
)
linecharts.add_yaxis(
    series_name="上海市",
    y_axis=sh_data,
    symbol="emptyCircle",
    is_symbol_show=True,
    label_opts=opts.LabelOpts(is_show=False),
)
linecharts.add_yaxis(
    series_name="天津市",
    y_axis=tj_data,
    symbol="emptyCircle",
    is_symbol_show=True,
    label_opts=opts.LabelOpts(is_show=False),
)
linecharts.add_yaxis(
    series_name="重庆市",
    y_axis=cq_data,
    symbol="emptyCircle",
    is_symbol_show=True,
    label_opts=opts.LabelOpts(is_show=False),
)
linecharts.render("city_people_chart.html")