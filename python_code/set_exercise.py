# @version : 1.0
# @Author  : 混江龙
# @File    : set_exercise.py
# @Time    : 2025/8/22 21:54

"""
用三个集合表锁三门学科的选课学生姓名（一个学生可以同时选多门课）
s_history = {'小明', '张三', '李四', '王五', 'Lily', 'Bob'}
s_politic = {'小明', '小花', '小红', '二狗'}
s_english = {'小明', 'Lily', 'Bob', 'Davil','李四'}
-求选课学生总共多少人
-求只选了第一个学科（history）的学生数量和学生名字
-求只选了一门学科的学生数量和学生名字
-求选了三门学科的学生数量和学生名字
"""
s_history = {'小明', '张三', '李四', '王五', 'Lily', 'Bob'}
s_politic = {'小明', '小花', '小红', '二狗'}
s_english = {'小明', 'Lily', 'Bob', 'Davil', '李四'}

three_count = s_english | s_politic | s_history
print("选课学生总共:", len(three_count))
only_history = s_history - s_politic - s_english
print("只选了第一门学科的学生有:", len(only_history), "学生有：", only_history)
only_one = only_history | (s_politic - s_english - s_history) | (s_english - s_history - s_politic)
print(f"只选了一门学科的有：{len(only_one)}人,学生名字是：{only_one}")
set_three= s_history & s_english & s_politic
print(f"选了三门学科的有{len(set_three)}人,学生名字是：{set_three}")