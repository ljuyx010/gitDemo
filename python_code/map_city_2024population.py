# @version : 1.0
# @Author  : 混江龙
# @File    : map_city_2024population.py
# @Time    : 2025/9/5 16:25
from pyecharts import options as opts
from pyecharts.charts import Map
from pyecharts.faker import Faker
"""
1.打开文件读取数据
2.创建map对象
3.添加数据并配置
4.生成文件
"""
with open("分省年度数据.csv",'r',encoding='gbk') as f:
    data_inlines = f.readlines()

# 删除前四行无用的数据
for _ in range(4):
    data_inlines.pop(0)
# 创建一个空列表存放地图数据
list = []
for line in data_inlines:
    line = line.split(",")
    if len(line) > 2:
        list.append([line[0], line[1]])

map = Map()
map.add("总人口(万人)",list,"china")
map.set_global_opts(
    title_opts=opts.TitleOpts(title="2024年全国各省市总人口"),
    # VisualMapOpts：视觉映射配置项
    visualmap_opts=opts.VisualMapOpts(min_=100, max_=15000, pos_left="10%", pos_bottom="30%"),
)
# 系列配置，配置标签文字的大小和字体
map.set_series_opts(label_opts=opts.LabelOpts(font_size=8))
map.render("map.html")

# c = (
#     Map()
#     .add("商家A", [list(z) for z in zip(Faker.provinces, Faker.values())], "china")
#     .set_global_opts(title_opts=opts.TitleOpts(title="Map-基本示例"))
#     .render("map_base.html")
# )
