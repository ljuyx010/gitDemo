# Python学习笔记

## 一、快速入门案例

用cmd解释器，写出hell world

```python
>>> print("hello world")
hello world
```

用记事本，可发一个hello.py程序，可以输出hello world

```python
#python程序文件的后缀是.py
#print语句的作用是输出内容，输出的内容就是（）内写的内容
#在python中使用#表示注释，及对代码的说明，但是不会被执行

print("hello world")

执行方法：python/py 文件名
PS E:\学习笔记\python_code> python hello.py
hello world
PS E:\学习笔记\python_code> py hello.py
hello world
```

## 二、注意事项

1.python 文件默认以.py做文件名，但不强制，以其他文件名也可以执行

2.python程序默认情况是按顺序执行的

3.python语言区分大小写

4.python程序由一条条语句构成，每条语句后不需要以`;`结束，但是如果带上`;`也不会报错，建议不带`;`(规范)

## 三、pycharm快捷键

1. 删除当前行快捷键：`shift+delete`
2. 复制当前行：`ctrl+D`
3. 添加注释和取消注销：`ctrl+/`
4. 快速格式化代码：`ctrl+alt+L`
5. 快速运行程序，默认是`ctrl+shift+F10/shift+10` 自己定义 `alt+R`
6. 查看类的层级关系：`crtl+H`
7. 拷贝/粘贴/剪切：`ctrl+C/V/X`
8. 查找：`ctrl+F`，替换：`ctrl+R`

## 四、转义字符

- `\t `： 一个制表位，实现对齐的功能
- `\n` ：换行符
- `\\`：一个\
- `\"`：一个"
- `\'`： 一个'
- `\r`：一个回车

## 五、注释

单行注释：`#`

多行注释：`'''注释内容‘’‘`（三组单引号）或者`"""注释内容"""`（三组双引号）

文件编码声明注释：`# coding:编码` 用于指定文件的编码类型，只能放到文件的开头

**python文档：https://docs.python.org/zh-cn/3.13/**

## 六、变量

变量三要素：类型，名称，值

`type(a)` 输出变量a的类型

### 变量格式化输出

- %操作符

  ```python
  age = 20
  score = 78
  sex = "男"
  name = "张三"
  # %操作符输出
  print("姓名：%s %d %s %.1f" % (name,age,sex,score))
  
  # %s 代表输出字符串
  # %d 代表输出整数
  # %.nf 代表输出n位的浮点数
  ```

- format()函数,不用关心数据类型

  ```py
  print("姓名：{} {} {}" .format(name,sex,score))
  ```

- f-strings，自动搜索变量，不关心数据类型，推荐使用

  ```python
  print(f"姓名：{name} {sex} {score}")
  ```

**加号的使用**

如果加号两边是字符串，则是作为连接符，如果两边是数值类型则做加法运算。

**数据类型**

python中的变量再试用期都必须赋值，变量赋值以后该变量才会被创建。

我们所说的“类型”是变量所指的内存数据的类型。

 python 的int类型可以存放4300位的整数，python的整数有十进制，十六进制，八进制和二进制。

十六进制写法：加前缀0x，由0-9和A-F的数字和字母组合

八进制写法：加前缀0o，由0-7数字组合

二进制写法：加前缀0b，只有0和1数字组合

运行时，会自动转换成十进制输出。

```python
# 10进制
print(10)

#16进制
print(0x10)

#8进制
print(0o10)

#2进制
print(0b10)
```

python中整型占多少字节？

1.字节数随着数字增大而增大（即：python整型是变长的）

2.每次的增量是4个字节

```python
# 在python中可以通过sys.getsizeof(obj)返回obj的大小（按照字节单位返回）
p = 2**10   # 2**10 就是2的10次方
print({sys.getsizeof(p)})
# 返回结果：40
```

科学计数法浮点数

5.12e2 = 5.12X10的2次方

5.12e-2 =  5.12/10的2次方

浮点数大小限制

float_info.max = 1.7976931348623157e+308

float_info.min = 2.2250738585072014e-308

浮动类型计算后，存在精度的损失，可以使用Decimal类进行精确计算

27