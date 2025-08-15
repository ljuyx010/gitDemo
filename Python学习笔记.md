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