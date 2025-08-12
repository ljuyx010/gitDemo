# Typora使用指南

## 1.标题

一级标题 # 快捷键 CTRL+1

二级标题 ##  CTRL+2

三级标题 ###  CTRL+3



## 2.代码框

https://www.runoob.com/linux/linux-command-manual.html

``` php
``` 英文的 三个反引号 输入或粘贴内容即可。
    php 显示语言格式
```

## 3.表格

适用于存放命令

```
Markdown官方写法

|姓名|昵称|
|---|---|
|李信息|华江龙|
```

展示效果如下：

| 姓名   | 昵称   |
| ------ | ------ |
| 李信息 | 华江龙 |

Typora方式如下：

快捷键 CRTL+T

| 姓名 | 昵称 |
| ---- | ---- |
| 111  | 222  |

## 4.总结

用于笔记和文档

typora支持markdown符号



# 思维导图工具 XMind

tab键 ：新建新的分支。

enter键：在同一层次新建分支。



# Linux学习

## 1.linux概述

+ linux是一个类似于windows的操作系统
+ 大部分企业与公司会选择这种系统，运行公司的网站，app，小程序，游戏...
+ 原因：
  + linux 开源（定制化），社区活跃，配置与使用通过命令，比较直观。
  + windows Server 收费，大量使用会有各种问题，定期重启。

## 2.LInux发展

诞生 unix 1969年贝尔实验室

谭宁邦 Minit 教学

斯托曼 ：

+ 公司  自由软件基金会 FSF
+ 项目 GNU=Gun is not Unix
+ 项目产生了很多优秀的开源软件
+ 规则：GPL 通用公共许可

Linus Torvalds 托沃兹  Linux内核

## 3.Linux组成 :star2:

+ linux系统内核：控制与操作硬件。
+ Linux命令解释器：运行命令，程序（shell）
+ Linux 系统的程序软件
+ GNU软件+Linux内核 GNU/Linux

## 4.Linux常见发行版本

+ debian 系列 （稳定安全，更新慢）
  + Ubuntu  乌班图  （桌面好看，工具较多，也可以用于服务器）:star:
  + Ubuntu kylin 乌班图 麒麟 Linux 国产 :star:
  + kali  用于安全检测（渗透测试）Linux系统

+ suse（商业版） 、openSUSE （开源） 德国企业开发
+ Red hat 红帽 Linux
  + RHEL 红帽企业版 :star:
  + CentOs 系统 创建一个与RedHat 二进制级别一样的系统。去掉红帽商业软件，logo。:star:
  + Rocky    Linux  CentOs作者自己新建系统。
  + Fedora  红帽系统的测试版本。

+ FreeBSD 类unix系统

## 5.Linux 选型

版本选择：尽量选择最新的**稳定版本**或者长期支持版本（LTS）。

大版本稳定，小版本最新，修复漏洞。

## 6.远程连接工具

| 远程连接工具 |                                                   |
| ------------ | ------------------------------------------------- |
| windows      | Xshell、secureCRT、PUtty、FinalShell....MobaXterm |
| macOs        | iTrem2、FinalShell、SecureCRT                     |
| 手机版本     | JuiceSSH（Android）、Termius（ios）               |



远程连接条件

- 服务器ip地址  使用ip a命令查看

- 用户名  root

- 密码  123456

- 端口：默认22

  

```
[root@lijun ~]# ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default q
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host 
       valid_lft forever preferred_lft forever
2: eth0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state UP group
    link/ether 00:0c:29:13:66:6e brd ff:ff:ff:ff:ff:ff
    inet 192.168.81.128/24 brd 192.168.81.255 scope global noprefixroute dynamic et
       valid_lft 1197sec preferred_lft 1197sec
    inet6 fe80::7400:1501:118b:e122/64 scope link noprefixroute 
       valid_lft forever preferred_lft forever
```



## 7.Bash命令行

- 命令行格式

  ```sh
  [root@lijun ~]# ip a
  root  ---> 当前用户的用户名
  lijun ---> 主机名，反应出机器的作用
  ~     ---> 位置标识  当前所在的位置（你在Linux的那个目录下）
  #    --->  root用户标识符
  $  --->  普通用户标识符
  ```

  

- 命令格式
  空格

  命令：用于控制与操作Linux的指令

  选项：同一个命令的不同功能，类似与条件

  参数:  命令处理的对象或目标（一般是文件或目录）
  
- Linux目录结构

一切文件从根开始（倒挂的树形结构）



## 8.LInux核心命令

1. 关机
   **shutdown -h 时间**

   shutdown -h now   ##立马关机

   shutdown -h 10    ##10分钟后关机

   shutdown -C   ##取消关机

   halt   关机，还需要手动关闭电源

   poweroff   关机，无法取消

   init 0  关机  ##CentOs6命令

2. 重启

   **shutdown -r  时间**

   reboot  重启

   init 6  重启  ##CentOs6命令

## 9.Linux核心命令查询

man 命令  （命令严格区分大小写）

```
[root@lijun ~]# man shutdown
~
SHUTDOWN(8)                         shutdown                        SHUTDOWN(8)

NAME
       shutdown - Halt, power-off or reboot the machine

SYNOPSIS
       shutdown [OPTIONS...] [TIME] [WALL...]

DESCRIPTION
       shutdown may be used to halt, power-off or reboot the machine.

       The first argument may be a time string (which is usually "now").
       Optionally, this may be followed by a wall message to be sent to all
       logged-in users before going down.

       The time string may either be in the format "hh:mm" for hour/minutes
:0...skipping...
SHUTDOWN(8)                         shutdown                        SHUTDOWN(8)

NAME
       shutdown - Halt, power-off or reboot the machine

SYNOPSIS
       shutdown [OPTIONS...] [TIME] [WALL...]

DESCRIPTION
       shutdown may be used to halt, power-off or reboot the machine.

       The first argument may be a time string (which is usually "now").
       Optionally, this may be followed by a wall message to be sent to all
       logged-in users before going down.

       The time string may either be in the format "hh:mm" for hour/minutes
       specifying the time to execute the shutdown at, specified in 24h clock
       format. Alternatively it may be in the syntax "+m" referring to the
       specified number of minutes m from now.  "now" is an alias for "+0",
       i.e. for triggering an immediate shutdown. If no time argument is
       specified, "+1" is implied.

       Note that to specify a wall message you must specify a time argument,
       too.

       If the time argument is used, 5 minutes before the system goes down the
       /run/nologin file is created to ensure that further logins shall not be
       allowed.

OPTIONS
       The following options are understood:

       --help
           Print a short help text and exit.

       -H, --halt
           Halt the machine.
SHUTDOWN(8)                         shutdown                        SHUTDOWN(8)

NAME
       shutdown - Halt, power-off or reboot the machine

SYNOPSIS
       shutdown [OPTIONS...] [TIME] [WALL...]

DESCRIPTION
       shutdown may be used to halt, power-off or reboot the machine.

       The first argument may be a time string (which is usually "now").
       Optionally, this may be followed by a wall message to be sent to all
       logged-in users before going down.

       The time string may either be in the format "hh:mm" for hour/minutes
       specifying the time to execute the shutdown at, specified in 24h clock
       format. Alternatively it may be in the syntax "+m" referring to the
       specified number of minutes m from now.  "now" is an alias for "+0",
       i.e. for triggering an immediate shutdown. If no time argument is
       specified, "+1" is implied.

       Note that to specify a wall message you must specify a time argument,
       too.

       If the time argument is used, 5 minutes before the system goes down the
       /run/nologin file is created to ensure that further logins shall not be
       allowed.

OPTIONS
       The following options are understood:

       --help
           Print a short help text and exit.

       -H, --halt
           Halt the machine.

       -P, --poweroff
           Power-off the machine (the default).

       -r, --reboot
           Reboot the machine.

       -h
           Equivalent to --poweroff, unless --halt is specified.

       -k
           Do not halt, power-off, reboot, just write wall message.

       --no-wall
           Do not send wall message before halt, power-off, reboot.

       -c
           Cancel a pending shutdown. This may be used cancel the effect of an
           invocation of shutdown with a time argument that is not "+0" or
           "now".

EXIT STATUS
       On success, 0 is returned, a non-zero failure code otherwise.

SEE ALSO
       systemd(1), systemctl(1), halt(8), wall(1)
```

命令 --help   （查询linux shell 内置命令）

info 命令   （查询超级详细的帮组，没事别看）

## 10.Linux快捷键

| 快捷键               | 作用                                 |
| -------------------- | ------------------------------------ |
| 必会                 |                                      |
| ctrl+L（clear）      | 清屏，清除屏幕的内容                 |
| ctrl+a               | 把光标移动到行首                     |
| ctrl+e               | 把光标移动到行尾                     |
| ctrl+u               | 把光标到行首的内容剪切               |
| ctrl+c               | 取消当前操作（cancel）               |
| 上 ↑ ，ctrl+p        | 上一个命令                           |
| 下 ↓，ctrl+n         | 下一个命令                           |
| history \| grep 命令 | 历史命令                             |
| ctrl+r               | 搜索使用过的命令                     |
| ctrl+d               | 退出当前用户                         |
| tab                  | 自动补全                             |
| esc+.                | 使用上一个命令的最后一个参数（结尾） |
| 了解                 |                                      |
| ctrl+k               | 把光标到行尾的内容剪切               |
| ctrl+y               | 粘贴                                 |
| ctrl+s               | 锁屏  ctrl+c，ctrl+Q  解锁           |
| ctrl+Z               | 让程序进入后台运行                   |



## 11.Linux常用命令

![image-20250718173915031](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250718173915031.png)

**Tab 键 自动补全**

### **1.cd  进入目录**

cd ~/cd 空格   回到当前用户家目录

cd ..  进入上级目录

cd .   进入当前目录

cd -   回到上次所在位置，目录

### **2.pwd 显示当前所在目录**

### **3.mkdir  （make directory）创建目录**

| 选项          |                          |
| ------------- | ------------------------ |
| mkdir 目录    | 创建目录每次只能创建一级 |
| mkdir -p 目录 | 创建多级目录             |
| mkdir -pv     | 显示多级目录创建过程     |

```sh
[root@lijun tmp]# cd /home/lijun
[root@lijun lijun]# mkdir test
[root@lijun lijun]# cd test/
[root@lijun test]# mkdir -pv 1/2/3
mkdir: 已创建目录 "1"
mkdir: 已创建目录 "1/2"
mkdir: 已创建目录 "1/2/3"
[root@lijun test]# mkdir ll zz dd   ##创建多个目录
[root@lijun test]# ls
1  dd  ll  zz
[root@lijun test]# mkdir /home/lijun/test1 /home/lijun/test2 /home/lijun/test3   ##创建绝对路径多个目录
[root@lijun test]# ls
1  dd  ll  zz
[root@lijun test]# cd ..
[root@lijun lijun]# ls
test  test1  test2  test3
[root@lijun lijun]# 

```



### **4.ls （list）查看目录内容**

| 选项 |                                                        |
| ---- | ------------------------------------------------------ |
| -l   | long 长格式（目录的详细信息）                          |
| -h   | human-readable 人类可读的文件大小                      |
| -t   | time 按照文件修改时间排序（默认）                      |
| -r   | 逆序 （一般和-lrt一起使用）                            |
| -d   | 查看目录本身的信息而不显示目录内容（把目录当文件看待） |
| -S   | size 根据大小排序展示                                  |

```sh
[root@lijun lijun]# ls -l
总用量 0
drwxr-xr-x. 6 root root 45 7月  18 17:53 test
drwxr-xr-x. 2 root root  6 7月  18 17:54 test1
drwxr-xr-x. 2 root root  6 7月  18 17:54 test2
drwxr-xr-x. 2 root root  6 7月  18 17:54 test3

[root@lijun tmp]# ls -l -h
总用量 4.0K
-rwx------. 1 root root 836 7月  18 11:22 ks-script-WqfOoj
drwx------. 3 root root  17 7月  21 11:11 systemd-private-07a01bf0224642ceaa24aa57acf85bf0-chronyd.service-dlEsvR
drwx------. 2 root root   6 7月  21 11:11 vmware-root_1083-4290100999
drwx------. 2 root root   6 7月  18 11:23 vmware-root_1111-3980167380
-rw-------. 1 root root   0 7月  18 11:19 yum.log

#例子：linux /etc目录下被创建了病毒目录，不知晓名字，只知道是最近创建的，怎么查找？
##模拟
mkdir /etc/dingdu
#ls -lt  默认是时间 降序  新（上面）---》旧（下面）
ls -lrt  #-r  逆序

[root@lijun tmp]# ls -ld /etc/hosts /etc/ /tmp/
drwxr-xr-x. 80 root root 8192 7月  21 11:11 /etc/
-rw-r--r--.  1 root root  158 6月   7 2013 /etc/hosts
drwxrwxrwt. 10 root root  281 7月  21 12:39 /tmp/
#应用场景，一般配合其他命令，批量查文件，目录信息的时候使用
-a #显示隐藏文件
```

### **5.touch  创建文件（修改文件的时间戳）**

```sh
#案例 创建txt文件
[root@lijun lijun]# touch oldboy.txt
[root@lijun lijun]# ls -l
总用量 0
-rw-r--r--. 1 root root  0 7月  21 15:10 oldboy.txt
drwxr-xr-x. 6 root root 45 7月  18 17:53 test
drwxr-xr-x. 2 root root  6 7月  18 17:54 test1
drwxr-xr-x. 2 root root  6 7月  18 17:54 test2
drwxr-xr-x. 2 root root  6 7月  18 17:54 test3

#案例02  创建多个文件
[root@lijun lijun]# touch 1.txt 4k-blue-ray.avi
[root@lijun lijun]# ls
1.txt  4k-blue-ray.avi  oldboy.txt  test  test1  test2  test3

```

### 	**6.mv （move）移动文件或改名**

```shell
#案例01  把lijun/1.txt移动到/tmp
[root@lijun lijun]# mv 1.txt test
[root@lijun lijun]# cd test
[root@lijun test]# ls
1  1.txt  dd  ll  zz
#案例02 改名
[root@lijun test]# mv 1.txt new-1.txt
[root@lijun test]# ls
1  dd  ll  new-1.txt  zz

#温馨提示，应用场景
1.mv 移动或改名
2.mv 是一个隐藏的杀手，危险程度仅次于rm。
3.可以使用mv来替代rm。
```

mv  源文件  文件  文件  文件    目标   （windows下的剪切）

mv 从哪里来  ====》到哪里去

### **7.cp（copy）复制文件或目录**

| 选项                         |                                                    |
| ---------------------------- | -------------------------------------------------- |
| 基本格式：cp  源文件    目标 |                                                    |
| -r  （recursive）            | 递归复制，复制目录及目录内容                       |
| -p                           | 复制的时候，保持属性信息不变（搭建网站中应用较多） |
| -a                           | 相当于 -r -p -d   -pdr                             |
| -d                           | 与复制符合连接（软连接，快捷方式）                 |

```shell
#案例
[root@lijun test]# cp /home/lijun/4k-blue-ray.avi ./
[root@lijun test]# ls
1  4k-blue-ray.avi  dd  ll  new-1.txt  zz

[root@lijun test]# ll  #ll  等于  ls -l
总用量 0
drwxr-xr-x. 3 root root 15 7月  18 17:50 1
-rw-r--r--. 1 root root  0 7月  21 15:46 4k-blue-ray.avi
drwxr-xr-x. 2 root root  6 7月  18 17:53 dd
drwxr-xr-x. 2 root root  6 7月  18 17:53 ll
-rw-r--r--. 1 root root  0 7月  21 15:13 new-1.txt
drwxr-xr-x. 2 root root  6 7月  18 17:53 zz

# 操作前备份，操作后检查
```

### **8.echo 输出信息到屏幕**

```sh
#案例
[root@lijun test]# echo {1..10}
1 2 3 4 5 6 7 8 9 10
[root@lijun test]# echo {a..z}
a b c d e f g h i j k l m n o p q r s t u v w x y z

[root@lijun test]# touch file-{1..5}.txt
[root@lijun test]# ll
总用量 0
drwxr-xr-x. 3 root root 15 7月  18 17:50 1
-rw-r--r--. 1 root root  0 7月  21 15:46 4k-blue-ray.avi
drwxr-xr-x. 2 root root  6 7月  18 17:53 dd
-rw-r--r--. 1 root root  0 7月  21 16:14 file-1.txt
-rw-r--r--. 1 root root  0 7月  21 16:14 file-2.txt
-rw-r--r--. 1 root root  0 7月  21 16:14 file-3.txt
-rw-r--r--. 1 root root  0 7月  21 16:14 file-4.txt
-rw-r--r--. 1 root root  0 7月  21 16:14 file-5.txt
drwxr-xr-x. 2 root root  6 7月  18 17:53 ll
-rw-r--r--. 1 root root  0 7月  21 15:13 new-1.txt
drwxr-xr-x. 2 root root  6 7月  18 17:53 zz
[root@lijun test]# echo {1,10,100}  #没有规律的中间加逗号
1 10 100
[root@lijun test]# echo a{b,c}
ab ac
[root@lijun test]# echo a{,c}
a ac
[root@lijun test]# echo 1.txt{,.bak}  #可以实现文件备份
1.txt 1.txt.bak


```

echo小结

1.用于输出信息到屏幕

2.echo+{}输出有规律的内容

3.{}生成序列:数字，字母，linux下面很多命令支持。

4.>标准输出重定向：覆盖文件内容，>>标准输出追加重定向：追加到文件的末尾（重定向符号）

### **9.vi 编辑器**

目标：打开，编辑文件，保存。

```sh
#打开文件
#按i进入编辑模式
#按ESC 退出编辑模式
#保存与退出 
:wq   write(保存) quit（退出）
:q  退出
:q! 强制退出
```



### **10.rm 删除文件或目录**

:warning:工作环境尽量避免使用删除命令或类似工具。

| 选项                    |                      |
| ----------------------- | -------------------- |
| 基本用法: rm 文件或目录 |                      |
| -f                      | force 强制删除不提示 |
| -r                      | 递归删除（删除目录） |

-fr选项可以放在最后在加，避免手抖把根目录删了。

### **11.cat 合并文件并显示文件内容**

concatenate

### **12.tree 树形结构显示目录**

默认没有安装，需要 ` yum install -y tree` 来进行安装

## 12.linux目录结构

### 12.1 目录概述

 - /根目录  存放系统信息，软件，命令。
 - /usr/      存放用户信息，软件，命令。
 - 后期详细规定了/ 下面要有什么目录，目录作用是什么。
 - 规定：FHS目录结构层次标准。[传送门 ](https://www.cnblogs.com/antLaddie/p/17613126.html)

### 12.2 根下核心目录

```sh
[root@lijun /]# ll /
总用量 16
lrwxrwxrwx.   1 root root    7 7月  18 11:19 bin -> usr/bin
dr-xr-xr-x.   5 root root 4096 7月  18 11:22 boot
drwxr-xr-x.  20 root root 3220 7月  21 11:11 dev
drwxr-xr-x.  80 root root 8192 7月  22 15:14 etc
drwxr-xr-x.   3 root root   19 7月  18 11:21 home
lrwxrwxrwx.   1 root root    7 7月  18 11:19 lib -> usr/lib
lrwxrwxrwx.   1 root root    9 7月  18 11:19 lib64 -> usr/lib64
drwxr-xr-x.   2 root root    6 4月  11 2018 media
drwxr-xr-x.   2 root root    6 4月  11 2018 mnt
drwxr-xr-x.   2 root root    6 4月  11 2018 opt
dr-xr-xr-x. 121 root root    0 7月  21 11:11 proc
dr-xr-x---.   2 root root  151 7月  18 16:00 root
drwxr-xr-x.  27 root root  780 7月  22 15:14 run
lrwxrwxrwx.   1 root root    8 7月  18 11:19 sbin -> usr/sbin
drwxr-xr-x.   2 root root    6 4月  11 2018 srv
dr-xr-xr-x.  13 root root    0 7月  21 11:11 sys
drwxrwxrwt.  10 root root  281 7月  22 15:14 tmp
drwxr-xr-x.  13 root root  155 7月  18 11:19 usr
drwxr-xr-x.  19 root root  267 7月  18 11:23 var

```

/bin   binary 二进制文件命令

/sbin  super binary 超级命令  只有root可以使用

/boot 与Linux系统启动与引导相关的文件存放处：存放引导系统启动程序和系统内核镜像

/dev  设备文件，光盘，硬盘分区，U盘

**/etc 系统配置文件存放处**

/home 普通用户家目录 可以用~表示

/root   root用户家目录 可以用~表示

/lib  library 库文件（服务软件的依赖）通常文件后缀.so

/lib64 同上

/lost+found   系统宕机临时保存数据位置

/mnt   mount tempoary 默认的一个挂载点 临时的挂载点（磁盘）临时的入口

/opt   option  第三方软件安装位置

/proc   process(进程) 虚拟目录 存放的是内存中信息 进程 服务信息 内核信息 （践行linux一切皆文件的主旨）

/sys   虚拟目录 存放的是内存中信息 进程 服务信息

/tmp  temporary 临时存放文件的位置  （垃圾堆）

/usr   存放用户安装软件

/var  variable  经常变换的数据存放的位置  日志（服务日志）



### 12.3 linux核心目录的核心文件概述

**1） /etc下面**

- /etc/hosts  主机ip地址与域名（主机名）对应关系

- /etc/hostname  主机名

  ```sh
  #红帽 7 8 9 及更新的系统下修改主机名
  [root@lijun /]# hostnamectl
     Static hostname: lijun
           Icon name: computer-vm
             Chassis: vm
          Machine ID: 15e915eeb42d4df983cc32aac1f8fd87
             Boot ID: 07a01bf0224642ceaa24aa57acf85bf0
      Virtualization: vmware
    Operating System: CentOS Linux 7 (Core)
         CPE OS Name: cpe:/o:centos:centos:7
              Kernel: Linux 3.10.0-1127.el7.x86_64
        Architecture: x86-64
  [root@lijun /]# hostnamectl set-hostname lj
  [root@lijun /]# hostnamectl
     Static hostname: lj
           Icon name: computer-vm
             Chassis: vm
          Machine ID: 15e915eeb42d4df983cc32aac1f8fd87
             Boot ID: 07a01bf0224642ceaa24aa57acf85bf0
      Virtualization: vmware
    Operating System: CentOS Linux 7 (Core)
         CPE OS Name: cpe:/o:centos:centos:7
              Kernel: Linux 3.10.0-1127.el7.x86_64
        Architecture: x86-64
  #临时修改主机名，重启失效
  [root@lijun /]# hostname
  lj
  [root@lijun /]# hostname lij
  [root@lijun /]# hostname
  lij
  
  ```

- /etc/sysconfig/network-scripts/ifcfg-eth0  或者 ifcfg-ens33

  ```sh
  /etc/sysconfig/network-scripts/ifcfg-eth0
  
  /etc       /sys config/network-scripts/if                 cfg      -eth0
  /系统配置文件/系统配置    /网络 -脚本（配置）/interface(接口，网卡)config配置-网卡名
  
  [root@lijun /]# cat /etc/sysconfig/network-scripts/ifcfg-eth0
  TYPE="Ethernet"
  PROXY_METHOD="none"
  BROWSER_ONLY="no"
  BOOTPROTO="dhcp"
  DEFROUTE="yes"
  IPV4_FAILURE_FATAL="no"
  IPV6INIT="yes"
  IPV6_AUTOCONF="yes"
  IPV6_DEFROUTE="yes"
  IPV6_FAILURE_FATAL="no"
  IPV6_ADDR_GEN_MODE="stable-privacy"
  NAME="eth0"
  UUID="f6f89231-e699-4573-80f9-5119356cbf81"
  DEVICE="eth0"
  ONBOOT="yes"
  IPADDR=192.168.81.128   #ip 地址
  ```

  

- 了解/etc/issue  /etc/issue.net  用户登录系统之前显示的信息

  快捷键：CTRL+d 退出当前用户

  建议清除这两个文件的内容，避免其他人知道系统版本找系统漏洞。

- 了解/etc/motd 用户登录后显示的内容

  文件内容会原封不动的显示出来

- 了解 /etc/fstab  开机的时候自动挂载目录

- 了解 /etc/rc.local 开机自动运行的内容存放这个文件

  ```sh
  #红帽7 及之后  第1次用之前 需要配置下 授予权限
  chmod +x /etc/rc.d/rc.local
  ```

- 了解 /etc/profile  /etc/bashrc   存放用户环境变量信息

  ```sh
  /etc/profile  存放各种系统环境变量
  /etc/bashrc   配置别名
  ```

- 小结

  | 文件                                      | 含义                          |
  | ----------------------------------------- | ----------------------------- |
  | /etc/hosts                                | ip地址与主机名解析关系        |
  | /etc/hostname                             | 主机名，hostnamectl，hostname |
  | /etc/sysconfig/network-scripts/ifcfg-eth0 | 网卡配置文件                  |
  | /etc/issue  /etc/issue.net                |                               |
  | /etc/motd                                 |                               |
  | /etc/fstab                                |                               |
  | /etc/rc.local                             | 开机自启动配置文件            |
  | /etc/profile                              |                               |
  | /etc/bashrc                               |                               |

  

**2）/var 目录 经常变化的内容，日志**

​	a. /var/log/messages  系统通用日志，各种信息默认都会写入到这个文件中

​	b. /var/log/secure  用户安全日志，用户登录信息（记录）

```sh
[root@lj ~]# tail -f /var/log/secure  ##查看日志推荐用tail  不建议用cat 和vi，vim，tail是实时更新显示
Jul 22 17:14:15 lj login: FAILED LOGIN 2 FROM tty1 FOR (unknown), User not known to the underlying authentication module
Jul 22 17:14:23 lj unix_chkpwd[1729]: password check failed for user (root)
Jul 22 17:14:23 lj login: pam_unix(login:auth): authentication failure; logname=LOGIN uid=0 euid=0 tty=tty1 ruser= rhost=  user=root
Jul 22 17:14:23 lj login: pam_succeed_if(login:auth): requirement "uid >= 1000" not met by user "root"
Jul 22 17:14:25 lj login: FAILED LOGIN SESSION FROM tty1 FOR root, Authentication failure
Jul 22 17:15:12 lj sshd[1733]: Accepted password for root from 192.168.81.1 port 53178 ssh2
Jul 22 17:15:12 lj sshd[1733]: pam_unix(sshd:session): session opened for user root by (uid=0)
Jul 22 17:36:02 lj sshd[1733]: pam_unix(sshd:session): session closed for user root
Jul 22 17:36:19 lj sshd[1815]: Accepted password for root from 192.168.81.1 port 55122 ssh2
Jul 22 17:36:19 lj sshd[1815]: pam_unix(sshd:session): session opened for user root by (uid=0)

```

**3） /proc/下面核心文件**

- 系统服务信息，进程信息，内核信息，系统信息...

​	a. /proc/cpuinfo cpu信息

```sh
[root@lj ~]# cat /proc/cpuinfo
processor	: 0
vendor_id	: GenuineIntel
cpu family	: 6
model		: 151
model name	: 12th Gen Intel(R) Core(TM) i5-12400
stepping	: 5
microcode	: 0x15
cpu MHz		: 2496.002
cache size	: 18432 KB
physical id	: 0
siblings	: 1
core id		: 0
cpu cores	: 1
apicid		: 0
initial apicid	: 0
fpu		: yes
fpu_exception	: yes
cpuid level	: 32
wp		: yes
flags		: fpu vme de pse tsc msr pae mce cx8 apic sep mtrr pge mca cmov pat pse36 clflush mmx fxsr sse sse2 ss syscall nx pdpe1gb rdtscp lm constant_tsc arch_perfmon rep_good nopl xtopology tsc_reliable nonstop_tsc eagerfpu pni pclmulqdq ssse3 fma cx16 pcid sse4_1 sse4_2 x2apic movbe popcnt tsc_deadline_timer aes xsave avx f16c rdrand hypervisor lahf_lm abm 3dnowprefetch invpcid_single ssbd ibrs ibpb stibp ibrs_enhanced fsgsbase tsc_adjust bmi1 avx2 smep bmi2 erms invpcid avx512f avx512dq rdseed adx smap avx512ifma clflushopt clwb avx512cd sha_ni avx512bw avx512vl xsaveopt xsavec xgetbv1 arat avx512vbmi umip pku ospke avx512_vbmi2 gfni vaes vpclmulqdq avx512_vnni avx512_bitalg avx512_vpopcntdq movdiri movdir64b md_clear spec_ctrl intel_stibp flush_l1d arch_capabilities
bogomips	: 4992.00
clflush size	: 64
cache_alignment	: 64
address sizes	: 45 bits physical, 48 bits virtual
power management:

processor	: 1
vendor_id	: GenuineIntel
cpu family	: 6
model		: 151
model name	: 12th Gen Intel(R) Core(TM) i5-12400
stepping	: 5
microcode	: 0x15
cpu MHz		: 2496.002
cache size	: 18432 KB
physical id	: 2
siblings	: 1
core id		: 0
cpu cores	: 1
apicid		: 2
initial apicid	: 2
fpu		: yes
fpu_exception	: yes
cpuid level	: 32
wp		: yes
flags		: fpu vme de pse tsc msr pae mce cx8 apic sep mtrr pge mca cmov pat pse36 clflush mmx fxsr sse sse2 ss syscall nx pdpe1gb rdtscp lm constant_tsc arch_perfmon rep_good nopl xtopology tsc_reliable nonstop_tsc eagerfpu pni pclmulqdq ssse3 fma cx16 pcid sse4_1 sse4_2 x2apic movbe popcnt tsc_deadline_timer aes xsave avx f16c rdrand hypervisor lahf_lm abm 3dnowprefetch invpcid_single ssbd ibrs ibpb stibp ibrs_enhanced fsgsbase tsc_adjust bmi1 avx2 smep bmi2 erms invpcid avx512f avx512dq rdseed adx smap avx512ifma clflushopt clwb avx512cd sha_ni avx512bw avx512vl xsaveopt xsavec xgetbv1 arat avx512vbmi umip pku ospke avx512_vbmi2 gfni vaes vpclmulqdq avx512_vnni avx512_bitalg avx512_vpopcntdq movdiri movdir64b md_clear spec_ctrl intel_stibp flush_l1d arch_capabilities
bogomips	: 4992.00
clflush size	: 64
cache_alignment	: 64
address sizes	: 45 bits physical, 48 bits virtual
power management:

processor	: 0   #cpu核心的id号  从0开始
physical id	: 0   #几个cpu，物理cpu的id号 从0开始


[root@lj ~]# lscpu
Architecture:          x86_64
CPU op-mode(s):        32-bit, 64-bit
Byte Order:            Little Endian
CPU(s):                2    #cpu核心总数
On-line CPU(s) list:   0,1
Thread(s) per core:    1
Core(s) per socket:    1   #cpu颗数

```



- /proc/meminfo 内存信息

```sh
[root@lj ~]# cat /proc/meminfo
MemTotal:        2027900 kB   #内存容量
MemFree:         1693128 kB   #剩余内存
```

- /proc/mounts 磁盘挂载信息

- /proc/diskstats 磁盘使用情况的信息

  ```sh
  [root@lj ~]# cat /proc/diskstats
     8       0 sda 6350 6 265375 20769 856 139 25160 2672 0 10069 23008
     8       1 sda1 1792 0 12081 750 4 0 4096 74 0 765 805
     8       2 sda2 4528 6 250206 19972 852 139 21064 2598 0 9486 22156
    11       0 sr0 18 0 2056 522 0 0 0 0 0 495 522
   253       0 dm-0 4377 0 241558 20024 991 0 21064 2828 0 9485 23024
   253       1 dm-1 88 0 4408 58 0 0 0 0 0 54 58
  [root@lj ~]# df   #查看磁盘使用情况
  文件系统                   1K-块    已用     可用      已用% 挂载点
  devtmpfs                 1001960       0  1001960    0% /dev
  tmpfs                    1013948       0  1013948    0% /dev/shm
  tmpfs                    1013948    9756  1004192    1% /run
  tmpfs                    1013948       0  1013948    0% /sys/fs/cgroup
  /dev/mapper/centos-root 17811456 2239008 15572448   13% /
  /dev/sda1                1038336  140408   897928   14% /boot
  tmpfs                     202792       0   202792    0% /run/user/0
  [root@lj ~]# df -h  # -h 人类可读方式显示
  文件系统                 容量  已用  可用      已用% 挂载点
  devtmpfs                 979M     0  979M    0% /dev
  tmpfs                    991M     0  991M    0% /dev/shm
  tmpfs                    991M  9.6M  981M    1% /run
  tmpfs                    991M     0  991M    0% /sys/fs/cgroup
  /dev/mapper/centos-root   17G  2.2G   15G   13% /
  /dev/sda1               1014M  138M  877M   14% /boot
  tmpfs                    199M     0  199M    0% /run/user/0
  
  ```

  

- /proc/loadavg 系统平均负载信息（系统繁忙程度）

**4）/usr/local 编译安装默认位置**

### 12.4绝对路径与相对路径

- 绝对路径：从根开始的路径。推荐大家使用。
- 相对路径：不是从根开始的路径。相对于当前路径。

### 12.5查看命令

1. cat 查看文件内容

   | 选项              |                 |
   | ----------------- | --------------- |
   | 基本用法 cat 文件 |                 |
   | -n                | 显示行号 number |

   

2. head 头，显示文件的开头几行，默认显示前10行

   | 选项   |                            |
   | ------ | -------------------------- |
   | -n数字 | 指定行数 -n5  可以简写成-5 |

   

3. tail  显示文件最后几行，默认显示文件最后10行

   | 选项   |                            |
   | ------ | -------------------------- |
   | -n数字 | 显示最后几行 -n5  简写成-6 |
   | -f     | 显示文件的实时更新         |
   | tailf  | 等于 tail -f               |

   

4. less  按页查看文件内容，到最后一行不会退出。
   G到底最后一行。

   g到达文件第1行。（gg  vi/vim快捷键）

   向下翻页 空格 或f或者 ctrl+f

   向上翻页b或者              ctrl+b

   q退出

5. more  按页查看文件内容，到最后以后会退出。

​	不支持快捷键



小结:

查看日志4剑客：head、tail、less、more

企业故障案例，开发人员在linux中查看日志，vi查看，发现系统内存不足？

原因：vi编辑大文件的时候，占用内存，导致内存不足。

解决：结束进程，使用head，tail，less，more等...



6. wc 统计行数

   | 选项 |               |
   | ---- | ------------- |
   | -l   | line 显示行数 |
   |      |               |
   |      |               |

   ```sh
   [root@lj ~]# wc /etc/services
    11176  61033 670293 /etc/services
    #行数   单词数  文件大小
   [root@lj ~]# wc -l /etc/services
   11176 /etc/services
   #案例 企业应用案例，通过wc命令，统计次数，出现了多少个，是否出现。
   #统计 /下第1级文件和目录数量
   [root@lj ~]# ls -l / | wc -l    #  | 管道 作用：把前一个命令的结果，传递给后面的命令使用。
   20
   
   
   ```

   

7. which   查询命令的绝对路径

8. whereis 查询命令的绝对路径，命令相关文件

```sh
[root@lj ~]# which tail tailf
/usr/bin/tail
/usr/bin/tailf
[root@lj ~]# whereis tail tailf
tail: /usr/bin/tail /usr/share/man/man1/tail.1.gz
tailf: /usr/bin/tailf /usr/share/man/man1/tailf.1.gz
[root@lj ~]# whereis -b tail tailf
tail: /usr/bin/tail
tailf: /usr/bin/tailf

```



9. diff  查询两个文件的区别

10. vimdiff  查询两个文件的区别

    ```sh
    [root@lj ~]# diff /etc/sysconfig/network-scripts/ifcfg-eth0  /home/lijun
    12c12
    < NAME="eth0"
    ---
    > NAME="ens33"
    15c15,16
    < ONBOOT="yes"
    ---
    > IPADDR=192.168.8.112
    > ADDname='li'
    
    a表示 append 增加了内容
    c表示 change  修改了内容
    d表示 delete  删除了内容
    
    ```

    

## yum源优化

- yum源 linux下载软件地方，软件仓库。

  ```sh
  curl -o /etc/yum.repos.d/CentOS-Base.repo https://mirrors.aliyun.com/repo/Centos-7.repo
  curl -o /etc/yum.repos.d/epel.repo https://mirrors.aliyun.com/repo/epel-7.repo
  yum install -y tree vim wget bash-completion bash-completion-wxtras lrzsz net-tools sysstat iotop iftop unzip nc nmap telnet bc psmisc httped-tools bind-utils nethogs expect
  ```

  

## sort 排序命令

| sort命令选项 | 默认按照字符排序                 |
| ------------ | -------------------------------- |
| -n           | 按照数字排序                     |
| -r           | reverse 逆序                     |
| -k           | 根据某一列进行排序               |
| -t           | 指定分隔符（每一列通过什么分割） |

## lrzsz  unzip

```sh
#lrzsz 包含2个核心命令  与windows互传文件
linux
rz    上传文件到linux  可以直接拖拽上传
sz    下载文件到windows
#解压 zip格式
unzip XXXX.zip
```

## uniq  unique（独一无二）

去重并显示重复次数。只能去除连续的

| uniq命令选项 |          |
| ------------ | -------- |
| -c           | 重复次数 |

```sh

[root@lj lijun]# uniq oldboy.txt 
a
b
c
d
a
c
d
c
a

[root@lj lijun]# sort oldboy.txt | uniq -c   #通常需要搭配sort一起使用
      1 
      5 a
      1 b
      4 c
      2 d
 

```

## 了解dos2unix

```sh
#windows 回车符号 \n\r
#linux   回车符号 \n

dos2unix
windows  格式转化为  linux格式

```

## date 查询修改日期

| date选项 |                                                   |
| -------- | ------------------------------------------------- |
| +        | 以....格式显示日期（%F年月日，%T时分秒，%w 周几） |
| -d       | 根据描述显示日期                                  |
| -s       | 设置或修改系统时间                                |

```sh
[root@lj lijun]# date +%F   # %F 年月日
2025-07-23
[root@lj lijun]# date +%w   # %w 周几
3
[root@lj lijun]# date +%T  # %T  时分秒
17:48:11

[root@lj lijun]# ls -l `which mkdir`
-rwxr-xr-x. 1 root root 79768 8月  20 2019 /usr/bin/mkdir
[root@lj lijun]# ls -l $(which mkdir)
-rwxr-xr-x. 1 root root 79768 8月  20 2019 /usr/bin/mkdir

#``和$()的作用是一样的，优先执行里面的命令，然后运行其他命令...

[root@lj lijun]# touch log-`date +%F`.log
[root@lj lijun]# ll
总用量 6788
drwxr-xr-x. 3 root root      68 9月   4 2024 1.客户续费系统
drwxr-xr-x. 3 root root      68 9月  10 2024 2.码上见代表小程序
-rw-r--r--. 1 root root       0 7月  21 15:13 4k-blue-ray.avi
-rw-r--r--. 1 root root   19256 6月   4 2018 bei.png
-rw-r--r--. 1 root root     330 7月  23 16:13 ifcfg-eth0
-rw-r--r--. 1 root root       0 7月  23 18:00 log-2025-07-23.log
-rw-r--r--. 1 root root      25 7月  23 17:25 oldboy.txt
drwxr-xr-x. 2 root root       6 7月  18 17:54 test1
drwxr-xr-x. 2 root root       6 7月  18 17:54 test2
drwxr-xr-x. 2 root root       6 7月  18 17:54 test3
drwxr-xr-x. 4 root root     136 7月  22 14:57 test4
-rw-r--r--. 1 root root       0 7月  23 17:36 user.log
-rw-r--r--. 1 root root 6920292 9月  11 2024 软著申请.zip

##自动同步日期时间
[root@lj ~]# yum install -y ntpdate
[root@lj ~]# ntpdate ntp1.aliyun.com   #同步阿里云的时间源
24 Jul 09:15:56 ntpdate[6211]: adjust time server 121.199.69.55 offset -0.002703 sec
```

## 别名

```sh
#配置别名  给rm命令配置别名，只要执行rm显示 command not found

##01）命令行配置（临时）重连失效
#格式：alias 别名='命令'
[root@lj ~]# alias rm='echo 命令没找到'
[root@lj ~]# rm -f /home/lijun/test
命令没找到 -f /home/lijun/test

##02）配置 永久生效
#vim 快捷键
#g：回到第一行  G：到最后一行  o：在本行下插入一行
[root@lj ~]# vim /etc/profile
[root@lj ~]# tail -2 /etc/profile
unset -f pathmunge
alias rm='echo 命令没找到'  #把别名命令写入到文件中
[root@lj ~]# source /etc/profile   #重新加载别名配置
[root@lj ~]# alias rm
alias rm='echo 命令没找到'
#重连测试
[root@lj ~]# alias rm
alias rm='rm -i'  #又回到了原始是因为系统有一个重名的别名
[root@lj ~]# vim .bashrc  #修改.bashrc文件
[root@lj ~]# head .bashrc
# .bashrc

# User specific aliases and functions

#alias rm='rm -i'  #把系统默认的rm别名注释掉
alias cp='cp -i'
alias mv='mv -i'

# Source global definitions
if [ -f /etc/bashrc ]; then
#断开重连别名生效
[root@lj ~]# alias rm
alias rm='echo 命令没找到'



##03）检查

#注意：如果配置别名后，想临时取消
#方法01 \ 反斜线
\rm ip.txt
#方法02 使用命令绝对路径
/bin/rm ip.txt
```

小结：

1.给危险命令设置别名

2.配置流程

命令配置（临时）alias '....'

永久写入配置文件 修改 /etc/profile

调试（测试检查）

3.临时取消别名 \ 或者 命令绝对路径 

## find 查找文件

| find 选项 |                                                              |
| --------- | ------------------------------------------------------------ |
| -type     | 查找什么类型文件 f（file文件）d（directory 目录）l(softlink 软链接，快捷方式) |
| -name     | 指定文件名                                                   |
| -size     | 文件大小  + （大于） -（小于）                               |
| -mtime    | modify time 文件修改时间  +7 （7天之前的） -7（7天之内）     |
| -iname    | ignore case（忽略大小写）指定文件名，不区分大小写            |

```sh
#案例 找出/etc 目录中叫hostname的文件
[root@lj ~]# find /etc -type f -name 'hostname'
/etc/hostname
##liunx系统中.开头的文件是隐藏文件
#格式
find 在哪里查找 -type（类型） f（文件） d（目录） -name（名称） 'XXXX'

#案例2 找出/etc目录中 以.conf结尾的文件
[root@lj ~]# find /etc -type f -name '*.conf'
/etc/resolv.conf
/etc/pki/ca-trust/ca-legacy.conf
/etc/yum/pluginconf.d/fastestmirror.conf
/etc/yum/pluginconf.d/langpacks.conf
/etc/yum/protected.d/systemd.conf
/etc/yum/version-groups.conf
/etc/logrotate.conf
/etc/openldap/ldap.conf
/etc/abrt/abrt-action-save-package-data.conf
/etc/abrt/abrt.conf
/etc/abrt/gpg_keys.conf
/etc/abrt/plugins/xorg.conf

#案例3 找出/目录中 包含test的文件
[root@lj ~]# find / -type f -name '*test*'
/boot/grub2/i386-pc/functional_test.mod
/boot/grub2/i386-pc/cmdline_cat_test.mod
/boot/grub2/i386-pc/cmostest.mod
/boot/grub2/i386-pc/div_test.mod
/boot/grub2/i386-pc/exfctest.mod
/boot/grub2/i386-pc/legacy_password_test.mod
/boot/grub2/i386-pc/signature_test.mod
/boot/grub2/i386-pc/sleep_test.mod
/boot/grub2/i386-pc/test.mod
/boot/grub2/i386-pc/test_blockarg.mod
/boot/grub2/i386-pc/testload.mod
/boot/grub2/i386-pc/testspeed.mod
/boot/grub2/i386-pc/setjmp_test.mod
/boot/grub2/i386-pc/pbkdf2_test.mod
/boot/grub2/i386-pc/usbtest.mod

#案例4 找出/etc目录中 大于100kb文件  大于 = + ，小于 = -

[root@lj ~]# find /etc/ -type f -size +100k|xargs ls -lh
-r--r--r--. 1 root root 159K 7月  18 11:19 /etc/pki/ca-trust/extracted/java/cacerts
-r--r--r--. 1 root root 256K 7月  18 11:19 /etc/pki/ca-trust/extracted/openssl/ca-bundle.trust.crt
-r--r--r--. 1 root root 169K 7月  18 11:19 /etc/pki/ca-trust/extracted/pem/email-ca-bundle.pem
-r--r--r--. 1 root root 217K 7月  18 11:19 /etc/pki/ca-trust/extracted/pem/tls-ca-bundle.pem
-rw-------. 1 root root 376K 4月   1 2020 /etc/selinux/targeted/active/file_contexts
-rw-------. 1 root root 3.8M 4月   1 2020 /etc/selinux/targeted/active/policy.kern
-rw-r--r--. 1 root root 376K 4月   1 2020 /etc/selinux/targeted/contexts/files/file_contexts
-rw-r--r--. 1 root root 1.4M 4月   1 2020 /etc/selinux/targeted/contexts/files/file_contexts.bin
-rw-r--r--. 1 root root 3.8M 4月   1 2020 /etc/selinux/targeted/policy/policy.31
-rw-r--r--. 1 root root 655K 6月   7 2013 /etc/services
-rw-r--r--. 1 root root 569K 8月   9 2019 /etc/ssh/moduli
-r--r--r--. 1 root root 8.0M 7月  18 11:23 /etc/udev/hwdb.bin
[root@lj ~]# ls -lh `find /etc/ -type f -size +100k`
-r--r--r--. 1 root root 159K 7月  18 11:19 /etc/pki/ca-trust/extracted/java/cacerts
-r--r--r--. 1 root root 256K 7月  18 11:19 /etc/pki/ca-trust/extracted/openssl/ca-bundle.trust.crt
-r--r--r--. 1 root root 169K 7月  18 11:19 /etc/pki/ca-trust/extracted/pem/email-ca-bundle.pem
-r--r--r--. 1 root root 217K 7月  18 11:19 /etc/pki/ca-trust/extracted/pem/tls-ca-bundle.pem
-rw-------. 1 root root 376K 4月   1 2020 /etc/selinux/targeted/active/file_contexts
-rw-------. 1 root root 3.8M 4月   1 2020 /etc/selinux/targeted/active/policy.kern
-rw-r--r--. 1 root root 376K 4月   1 2020 /etc/selinux/targeted/contexts/files/file_contexts
-rw-r--r--. 1 root root 1.4M 4月   1 2020 /etc/selinux/targeted/contexts/files/file_contexts.bin
-rw-r--r--. 1 root root 3.8M 4月   1 2020 /etc/selinux/targeted/policy/policy.31
-rw-r--r--. 1 root root 655K 6月   7 2013 /etc/services
-rw-r--r--. 1 root root 569K 8月   9 2019 /etc/ssh/moduli
-r--r--r--. 1 root root 8.0M 7月  18 11:23 /etc/udev/hwdb.bin
#注意，k小写 M G 要大写

#案例5 找出/etc目录中 大于100kb且小于500k文件
[root@lj ~]# ls -lh `find /etc/ -type f -size +100k -size -500k`
-r--r--r--. 1 root root 159K 7月  18 11:19 /etc/pki/ca-trust/extracted/java/cacerts
-r--r--r--. 1 root root 256K 7月  18 11:19 /etc/pki/ca-trust/extracted/openssl/ca-bundle.trust.crt
-r--r--r--. 1 root root 169K 7月  18 11:19 /etc/pki/ca-trust/extracted/pem/email-ca-bundle.pem
-r--r--r--. 1 root root 217K 7月  18 11:19 /etc/pki/ca-trust/extracted/pem/tls-ca-bundle.pem
-rw-------. 1 root root 376K 4月   1 2020 /etc/selinux/targeted/active/file_contexts
-rw-r--r--. 1 root root 376K 4月   1 2020 /etc/selinux/targeted/contexts/files/file_contexts
#案例6 找出/var/log目录中 3天之前的文件
[root@lj ~]# ll -ht `find /var/log -type f -mtime +3`
-rw-------. 1 root root 1.2K 7月  18 14:10 /var/log/vmware-network.4.log
-rw-------. 1 root root 1.5K 7月  18 14:09 /var/log/vmware-network.5.log
-rw-------. 1 root root  775 7月  18 11:23 /var/log/vmware-network.6.log
-rw-r-----. 1 root root    0 7月  18 11:23 /var/log/firewalld
-rw-------. 1 root root 1.6M 7月  18 11:22 /var/log/anaconda/journal.log
-rw-------. 1 root root    0 7月  18 11:22 /var/log/anaconda/ks-script-PZGwck.log
-rw-------. 1 root root    0 7月  18 11:22 /var/log/anaconda/ks-script-WqfOoj.log
-rw-------. 1 root root 3.3K 7月  18 11:22 /var/log/anaconda/ifcfg.log
-rw-------. 1 root root  88K 7月  18 11:22 /var/log/anaconda/storage.log
-rw-------. 1 root root 205K 7月  18 11:22 /var/log/anaconda/packaging.log
-rw-------. 1 root root  33K 7月  18 11:22 /var/log/anaconda/program.log
-rw-------. 1 root root 285K 7月  18 11:22 /var/log/anaconda/syslog
-rw-------. 1 root root  22K 7月  18 11:22 /var/log/anaconda/X.log
-rw-------. 1 root root  24K 7月  18 11:22 /var/log/anaconda/anaconda.log
-rw-------. 1 root root    0 7月  18 11:20 /var/log/spooler
-rw-r--r--. 1 root root  193 7月  18 11:20 /var/log/grubby_prune_debug
```

## grep 

过滤 在文件中查找想要的内容（不要的）

| grep命令选项 |                                                              |
| ------------ | ------------------------------------------------------------ |
| -n           | --line-number 显示内容及行号                                 |
| -i           | --ignore-case  不区分大小写                                  |
| -v           | 取反，排除                                                   |
| -o           | 显示执行过程                                                 |
| -w           | 精确过滤                                                     |
| -R           | 递归查找递归查找                                             |
| -l           | 只显示文件名                                                 |
| -A after     | grep过滤的时候显示内容及下面的一行（-B上面的，-C上面和下面的） |

```sh
#01案例，在/etc/passwd 中找出包含root的行
[root@lj ~]# grep 'root' /etc/passwd
root:x:0:0:root:/root:/bin/bash
operator:x:11:0:operator:/root:/sbin/nologin

#02案例 查找出叫sshd的进程
[root@lj ~]# ps -ef |grep 'sshd'
root       1475      1  0 01:11 ?        00:00:00 /usr/sbin/sshd -D
root       6635   1475  0 10:44 ?        00:00:00 sshd: root@pts/0
root       9037   6639  0 11:45 pts/0    00:00:00 grep --color=auto sshd
#03案例 过滤并显示行号
[root@lj ~]# grep -n 'root' /etc/passwd
1:root:x:0:0:root:/root:/bin/bash
10:operator:x:11:0:operator:/root:/sbin/nologin

#seq  sequence  数字序列  生成一行一个的数字序列 
```

## 13.Linux文件属性

```sh
[root@lj ~]# ls -lhi
总用量 24K
33574978 -rw-------. 1 root root 1.5K 7月  18 11:22 anaconda-ks.cfg
33642221 -rw-r--r--. 1 root root  19K 6月   4 2018 bei.png
inode号(索引号)         所有者 所属用户组 大小  修改时间  文件名（不是文件属性）
第二列：-rw-r--r--.
第一位表示文件类型
2-10位表示文件权限
第三列数字表示硬链接数量（入口数）
```

![image-20250724142035974](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250724142035974.png)

| 文件类型                |                                |
| ----------------------- | ------------------------------ |
| f（file）- （普通文件） | 普通文件                       |
| d（directory）          | 目录                           |
| l                       | 软链接/符号链接（win快捷方式） |
| b（block）              | 块设备（磁盘，U盘，光盘）      |
| c（character）          | 字符设备（特殊场景，生成字符） |
| s（socket）             | 套接字文件                     |

| 普通文件分类 |                                                       |
| ------------ | ----------------------------------------------------- |
| 文本文件     | 可以编辑可以查看                                      |
| 二进制文件   | 命令文件                                              |
| 数据文件     | 压缩包，某些服务特有的文件（通过特定的命令/服务查看） |

```sh
[root@lj ~]# tr -cd 'a-z' </dev/urandom |head -c8
uquryplr
#/dev/urandom  生成随机字符
#head -c8      取前8位
```

一个文件由1个inode + n个block 组成

inode 记录文件的权限，大小，所有者，和block指针等，一般占用256字节空间

block 文件实体（存放文件内容），一般一个block占用4kb（格式化的时候规定好的）

正常情况下block会消耗的更快

- inode使用情况  df -i

  ```sh
  [root@lj ~]# df -i
  文件系统                  Inode 已用(I) 可用(I) 已用(I)% 挂载点
  devtmpfs                 250490     390  250100       1% /dev
  tmpfs                    253487       1  253486       1% /dev/shm
  tmpfs                    253487     741  252746       1% /run
  tmpfs                    253487      16  253471       1% /sys/fs/cgroup
  /dev/mapper/centos-root 8910848   62438 8848410       1% /
  /dev/sda1                524288     326  523962       1% /boot
  tmpfs                    253487       1  253486       1% /run/user/0
  
  ```

  

- block使用情况 df 或者df -h

  ```sh
  [root@lj ~]# df -h
  文件系统                 容量  已用  可用 已用% 挂载点
  devtmpfs                 979M     0  979M    0% /dev
  tmpfs                    991M     0  991M    0% /dev/shm
  tmpfs                    991M  9.6M  981M    1% /run
  tmpfs                    991M     0  991M    0% /sys/fs/cgroup
  /dev/mapper/centos-root   17G  2.2G   15G   13% /
  /dev/sda1               1014M  138M  877M   14% /boot
  tmpfs                    199M     0  199M    0% /run/user/0
  
  ```

  

**排障：inode和block磁盘空间不足案例（no space left on device）**

软链接：也叫符号链接（win 快捷方式）使用 ln -s 创建

```sh
[root@lj lijun]# ln -s oldboy.txt  oldboy.txt.lnk #创建软链接
[root@lj lijun]# ll
总用量 6768
drwxr-xr-x. 3 root root      68 9月   4 2024 1.客户续费系统
drwxr-xr-x. 3 root root      68 9月  10 2024 2.码上见代表小程序
-rw-r--r--. 1 root root       0 7月  21 15:13 4k-blue-ray.avi
-rw-r--r--. 1 root root     330 7月  23 16:13 ifcfg-eth0
-rw-r--r--. 1 root root       0 7月  23 18:00 log-2025-07-23.log
-rw-r--r--. 1 root root      25 7月  23 17:25 oldboy.txt
lrwxrwxrwx. 1 root root      10 7月  24 15:55 oldboy.txt.lnk -> oldboy.txt

```

硬链接：在同一个磁盘分区中，文件的inode号码相同的文件，互为硬链接。使用ln 创建

硬链接相当于一个商场的不同入口（出口），硬链接只能对文件创建，无法对目录创建

删除源文件，软链接无法使用，硬链接没有影响，删除硬链接，软链接，源文件无影响

```sh
[root@lj lijun]# ln oldboy.txt oldboy.txt.hard   #创建硬链接
[root@lj lijun]# ll -i
总用量 6772
33642227 drwxr-xr-x. 3 root root      68 9月   4 2024 1.客户续费系统
16815783 drwxr-xr-x. 3 root root      68 9月  10 2024 2.码上见代表小程序
33575499 -rw-r--r--. 1 root root       0 7月  21 15:13 4k-blue-ray.avi
33642215 -rw-r--r--. 1 root root     330 7月  23 16:13 ifcfg-eth0
33647243 -rw-r--r--. 1 root root       0 7月  23 18:00 log-2025-07-23.log
33647244 -rw-r--r--. 2 root root      25 7月  23 17:25 oldboy.txt
33647244 -rw-r--r--. 2 root root      25 7月  23 17:25 oldboy.txt.hard

```

文件时间（linux）

| Linux文件/目录各种时间 | 含义                         |
| ---------------------- | ---------------------------- |
| mtime                  | modify time 修改时间         |
| atime                  | access time 访问时间         |
| ctime                  | change time 文件属性变化时间 |

```sh
[root@lj lijun]# stat oldboy.txt
  文件："oldboy.txt"
  大小：25        	块：8          IO 块：4096   普通文件
设备：fd00h/64768d	Inode：33647244    硬链接：2
权限：(0644/-rw-r--r--)  Uid：(    0/    root)   Gid：(    0/    root)
环境：unconfined_u:object_r:user_home_t:s0
最近访问：2025-07-24 16:15:56.031244227 +0800
最近更改：2025-07-23 17:25:28.910518466 +0800
最近改动：2025-07-24 16:13:41.051402602 +0800
创建时间：-

```



## 14.用户管理

### 1.用户

| 用户分类             |                                                          | UID                         |
| -------------------- | -------------------------------------------------------- | --------------------------- |
| 超级用户             | root用户                                                 | 0                           |
| 普通用户             | 只能对自己的家目录进行管理，对其他目录只能查看           | >=1000<br />>=500 (centos6) |
| 虚拟用户（默默无闻） | 保证服务，进程能够正常运行，无法直接使用（无法登录系统） | 1-999                       |

补充：用户的id

| 用户的id信息 |                                         |
| ------------ | --------------------------------------- |
| UID          | user id用户的id（用户的身份证号，唯一） |
| GID          | group id 用户组id（户口本的编号）       |

```sh
[root@lj lijun]# id root  #查看指定用户id
uid=0(root) gid=0(root) 组=0(root)
[root@lj lijun]# id    #查看当前用户id
uid=0(root) gid=0(root) 组=0(root) 环境=unconfined_u:unconfined_r:unconfined_t:s0-s0:c0.c1023
[root@lj lijun]# 

```

用户相关的文件

| 存放用户信息的文件 |                                                            |
| ------------------ | ---------------------------------------------------------- |
| **/etc/passwd**    | 存放的是永恒的信息（用户名，uid，GID，家目录，命令解释器） |
| /etc/shadow        | 存放用户的密码信息                                         |
| /etc/group         | 用户组的信息                                               |
| /etc/gshadow       | 用户组的密码信息                                           |

![image-20250724171323238](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250724171323238.png)

用户的增删改查

- 检查用户是否存在

  ```sh
  [root@lj lijun]# id lijun
  uid=1000(lijun) gid=1000(lijun) 组=1000(lijun),10(wheel)
  [root@lj lijun]# id lj
  id: lj: no such user
  [root@lj lijun]# echo $?
  1
  [root@lj lijun]# #$? 上一个命令结果，如果是0则成功，非0就失败
  
  ```

- 添加用户

  ```sh
  [root@lj lijun]# useradd oldboy
  [root@lj lijun]# id oldboy
  uid=1001(oldboy) gid=1001(oldboy) 组=1001(oldboy)
  [root@lj lijun]# grep 'oldboy' /etc/passwd
  oldboy:x:1001:1001::/home/oldboy:/bin/bash
  [root@lj lijun]# ll -a  /home/oldboy/
  总用量 12
  drwx------. 2 oldboy oldboy  62 7月  24 17:32 .
  drwxr-xr-x. 4 root   root    33 7月  24 17:32 ..
  -rw-r--r--. 1 oldboy oldboy  18 4月   1 2020 .bash_logout
  -rw-r--r--. 1 oldboy oldboy 193 4月   1 2020 .bash_profile
  -rw-r--r--. 1 oldboy oldboy 231 4月   1 2020 .bashrc
  # 添加用户并指定用户uid
  [root@lj lijun]# useradd -u 888 oldboy888
  [root@lj lijun]# id oldboy888
  uid=888(oldboy888) gid=1002(oldboy888) 组=1002(oldboy888)
  # 手动添加系统用户（虚拟用户） mysql
  [root@lj lijun]# useradd -s /sbin/nologin -M mysql
  -s 指定命令解释器  -M 不创建家目录
  ```

  | useradd的选项 |                                       |
  | ------------- | ------------------------------------- |
  | -u            | 指定用户的uid                         |
  | -s            | 指定用户的命令解释器，默认是/bin/bash |
  | -M            | 不创建家目录，默认创建家目录          |
  | -g            | 指定用户所属的用户组（名字）          |
  | -G            | 指定用户属于附加组（多个用户组）      |

- 切换用户 su （swich user）

  | su选项         |                                          |
  | -------------- | ---------------------------------------- |
  | -，-l，--login | 切换用户的时候更新用户的信息（环境变量） |
  
  切换用户后想快速返回上一次的用户，快捷键ctrl+d  

- 修改用户 passwd usermod

  passwd 修改或设置用户的密码。

  ```sh
  [root@lj ~]# passwd oldboy #passwd 用户名  修改指定用户密码，只能是root用户。
  更改用户 oldboy 的密码 。
  新的 密码：
  无效的密码： 密码少于 8 个字符
  重新输入新的 密码：
  passwd：所有的身份验证令牌已经成功更新。
  #案例 非交互式设置密码
  [root@lj ~]# echo 123 | passwd --stdin oldboy
  更改用户 oldboy 的密码 。
  passwd：所有的身份验证令牌已经成功更新。
  # --stdin 从标准输入中获取密码， 从管道前面获取密码
  #企业级密码设置与保存
  # 12-20位 大小写字母，数字，特殊符号
  #保存，excel表格（不推荐），keepass（软件）
  #使用堡垒机、跳板机管理与登录Linux
  ```

  usermod 修改已经存在的用户信息，uid，命令解释器，解释说明等。

  ```sh
  [root@lj ~]# usermod -c 'this is a putong user' oldboy #修改用户说明
  [root@lj ~]# grep oldboy /etc/passwd
  oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
  oldboy888:x:888:1002::/home/oldboy888:/bin/bash
  #修改用户为虚拟用户
  [root@lj ~]# usermod -s /sbin/nologin oldboy888
  [root@lj ~]# grep oldboy /etc/passwd
  oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
  oldboy888:x:888:1002::/home/oldboy888:/sbin/nologin
  
  ```

  | usermod选项 |                              |
  | ----------- | ---------------------------- |
  | -u          | 修改指定用户的uid（不推荐）  |
  | -c          | 修改用户说明信息             |
  | -s          | 指定新的命令解释器           |
  | -g          | 指定用户用户组               |
  | -G          | 指定用户属于附加组（多个组） |

- 删除用户 userdel

  删除用户，极其危险。

  | userdel选项 |                      |
  | ----------- | -------------------- |
  | -r          | 删除用户及用户的信息 |

  ````sh
  #01 正常删除用户
  [root@lj ~]# userdel oldboy888
  [root@lj ~]# id oldboy888
  id: oldboy888: no such user
  [root@lj ~]# grep oldboy /etc/passwd
  oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
  [root@lj ~]# ll /home/
  总用量 4
  drwx------. 8 lijun  lijun  4096 7月  24 16:13 lijun
  drwx------. 2 oldboy oldboy   62 7月  24 17:32 oldboy
  drwx------. 2    888   1002   62 7月  24 17:37 oldboy888 #userdel 删除用户不会删除用户的家目录
  
  #02  彻底删除用户，连窝端
  [root@lj ~]# useradd oldboy999
  [root@lj ~]# ll /home
  总用量 4
  drwx------. 8 lijun     lijun     4096 7月  24 16:13 lijun
  drwx------. 2 oldboy    oldboy      62 7月  24 17:32 oldboy
  drwx------. 2       888      1002   62 7月  24 17:37 oldboy888
  drwx------. 2 oldboy999 oldboy999   62 7月  25 16:05 oldboy999
  [root@lj ~]# userdel -r oldboy999
  [root@lj ~]# ll /home
  总用量 4
  drwx------. 8 lijun  lijun  4096 7月  24 16:13 lijun
  drwx------. 2 oldboy oldboy   62 7月  24 17:32 oldboy
  drwx------. 2    888   1002   62 7月  24 17:37 oldboy888
  
  #03  生产环境删除用户的处理推荐
  ##生产环境，不推荐删除用户
  ##有删除用户的需求，可以把/etc/passwd 中用户注释掉
  ````

- /etc/skel  用户家目录的模版

  useradd是时候 从/etc/skel中复制内容到新的用户家目录

  ```sh
  # /etc/skel 默认的内容
  [root@lj ~]# ll -a /etc/skel/
  总用量 24
  drwxr-xr-x.  2 root root   62 7月  18 11:19 .
  drwxr-xr-x. 81 root root 8192 7月  25 16:05 ..
  -rw-r--r--.  1 root root   18 4月   1 2020 .bash_logout #用户退出时执行的内容
  -rw-r--r--.  1 root root  193 4月   1 2020 .bash_profile  #用户的环境变量配置文件 别名
  -rw-r--r--.  1 root root  231 4月   1 2020 .bashrc  #用户的环境变量配置文件
  
  ```

  故障案例分析

  ```sh
  #故障现象
  [root@lj ~]# su oldboy
  [oldboy@lj root]$ rm -fr /*
  [oldboy@lj root]$ exit  #快捷键Ctrl+d
  bash-4.2$ 
  [root@lj ~]# ll -a /home/oldboy
  总用量 4
  drwx------. 2 oldboy oldboy 27 7月  25 16:23 .
  drwxr-xr-x. 5 root   root   50 7月  25 16:05 ..
  -rw-------. 1 oldboy oldboy 47 7月  25 16:27 .bash_history
  #故障原因
  用户不小心删除，家目录下面的隐藏配置文件（用户命令行格式相关）
  导致用户重新登录的时候，用户的命令行变成 bash-4.2$ 
  
  #解决
  把/etc/skel 下的几个隐藏文件复制到用户家目录
  [root@lj ~]# cp .bash_logout .bash_profile .bashrc /home/oldboy
  重新登录
  ```

- chown 修改文件的所有者

  chown  所有者.用户组 文件名 

  ```sh
  [root@lj lijun]# chown oldboy.oldboy oldboy.txt 
  [root@lj lijun]# ll
  总用量 6772
  drwxr-xr-x. 3 root   root        68 9月   4 2024 1.客户续费系统
  drwxr-xr-x. 3 root   root        68 9月  10 2024 2.码上见代表小程序
  -rw-r--r--. 1 root   root         0 7月  21 15:13 4k-blue-ray.avi
  -rw-r--r--. 1 root   root       330 7月  23 16:13 ifcfg-eth0
  -rw-r--r--. 1 root   root         0 7月  23 18:00 log-2025-07-23.log
  -rw-r--r--. 2 oldboy oldboy      25 7月  23 17:25 oldboy.txt
  
  #修改 /home/lijun目录下文件和目录的所有者为oldboy
  [root@lj lijun]# chown -R oldboy.oldboy /home/lijun # -R 循环修改
  [root@lj lijun]# ll
  总用量 6772
  drwxr-xr-x. 3 oldboy oldboy      68 9月   4 2024 1.客户续费系统
  drwxr-xr-x. 3 oldboy oldboy      68 9月  10 2024 2.码上见代表小程序
  -rw-r--r--. 1 oldboy oldboy       0 7月  21 15:13 4k-blue-ray.avi
  -rw-r--r--. 1 oldboy oldboy     330 7月  23 16:13 ifcfg-eth0
  -rw-r--r--. 1 oldboy oldboy       0 7月  23 18:00 log-2025-07-23.log
  -rw-r--r--. 2 oldboy oldboy      25 7月  23 17:25 oldboy.txt
  -rw-r--r--. 2 oldboy oldboy      25 7月  23 17:25 oldboy.txt.hard
  lrwxrwxrwx. 1 oldboy oldboy      10 7月  24 15:55 oldboy.txt.lnk -> oldboy.txt
  drwxr-xr-x. 2 oldboy oldboy       6 7月  18 17:54 test1
  drwxr-xr-x. 2 oldboy oldboy       6 7月  18 17:54 test2
  drwxr-xr-x. 2 oldboy oldboy       6 7月  18 17:54 test3
  drwxr-xr-x. 4 oldboy oldboy     136 7月  22 14:57 test4
  -rw-r--r--. 1 oldboy oldboy       0 7月  23 17:36 user.log
  -rw-r--r--. 1 oldboy oldboy 6920292 9月  11 2024 软著申请.zip
  
  
  ```

- 查询用户登录信息
  last 查看系统中所有用户的登录记录（远程登录）

  lastlog   查看系统中所有用户的最近一次登录记录（远程登录）

  w   显示当前系统的用户登录信息并且正在做什么

  who  显示当前系统的用户登录信息

### 2.用户组

Linux下面创建用户添加一个用户组

用户相当于1个人

用户组相当于1个家庭

```sh
# groupadd 添加用户组
#案例 添加用户 mysql666 指定uid和gid都是666的虚拟用户
[root@lj ~]# groupadd -g 666 mysql666
[root@lj ~]# useradd -u 666 -g mysql666 -M -s /sbin/nologin mysql666
[root@lj ~]# id mysql666
uid=666(mysql666) gid=666(mysql666) 组=666(mysql666)

#让oldboy用户属于多个用户组 属于root用户组
[root@lj ~]# usermod -G root oldboy  #加入到root组
[root@lj ~]# id oldboy
uid=1001(oldboy) gid=1001(oldboy) 组=1001(oldboy),0(root)
[root@lj ~]# usermod -G '' oldboy  #退出root 组
[root@lj ~]# id oldboy
uid=1001(oldboy) gid=1001(oldboy) 组=1001(oldboy)

```



### 3.提权

需求：开发人员需要查看Linux日志（/var/log/secure  /var/log/messages）

如何做？

​	方案1：root用户密码给他，危险。

​	方案2：运维人员通过root下载（sz）日志，发送给开发

​	方案3：普通用户权限，能否查看日志？？？无法查看

​	方案4：给命令授权特殊权限（suid）

​	方案5：EBLK日志收集分析平台

sudo提权：授予普通用户某个命令的权限，让图片用户临时成为root执行命令。

sudo使用流程：

​	root用户授予权限

​	普通用户使用

​	调试

```sh
# 通过root用户授权
visudo  #进入授权配置
100gg   #vi快捷键 到达100行
o       #vi快捷键 在当前下一行插入
#修改配置文件
[root@lj lijun]# grep -n 'oldboy' /etc/sudoers
102:oldboy  ALL=(ALL)       /bin/cat,/bin/less  #授予cat命令，和less命令所有的权限

#切换被授权的用户测试是否有sudo权限
[oldboy@lj ~]$ sudo -l

我们信任您已经从系统管理员那里了解了日常注意事项。
总结起来无外乎这三点：

    #1) 尊重别人的隐私。
    #2) 输入前要先考虑(后果和风险)。
    #3) 权力越大，责任越大。
[oldboy@lj ~]$ sudo cat /var/log/secure   ##sudo授权的用户使用授权的命令前必须加sudo
Jul 25 14:58:22 lj sshd[3152]: Accepted password for root from 192.168.81.1 port 57178 ssh2
Jul 25 14:58:23 lj sshd[3152]: pam_unix(sshd:session): session opened for user root by (uid=0)
Jul 25 15:04:36 lj passwd: pam_unix(passwd:chauthtok): password changed for oldboy
Jul 25 15:10:51 lj passwd: pam_unix(passwd:chauthtok): password changed for oldboy
Jul 25 15:56:21 lj usermod[3371]: change user 'oldboy888' shell from '/bin/bash' to '/sbin/nologin'
Jul 25 16:02:10 lj userdel[3396]: delete user 'oldboy888'
Jul 25 16:02:10 lj userdel[3396]: removed group 'oldboy888' owned by 'oldboy888'
Jul 25 16:02:10 lj userdel[3396]: removed shadow group 'oldboy888' owned by 'oldboy888'
Jul 25 16:05:06 lj useradd[3426]: new group: name=oldboy999, GID=1004
Jul 25 16:05:06 lj useradd[3426]: new user: name=oldboy999, UID=1003, GID=1004, home=/home/oldboy999, shell=/bin/bash


```

授予全部命令并不需要sudo时输入密码

```sh
oldboy ALL=(ALL) NOPASSWD:ALL
```

```sh
#root用户登录切换普通用户后可以使用，切换会root用户
sudo su - 
```

## vi/vim 快捷键

vi 基础功能的编辑器

vim   vi升级版本，更多功能

![image-20250728155625881](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250728155625881.png)

**1）移动光标**

← h   ↓ j   ↑ k  l →

光标移动到文件的第1行：gg,1G,:1

光标移动到文件的最后一行：G,:$

光标移动到文件的第100行：100gg,100G,:100

光标移动到这一行的行首：0（数字零）,^

光标移动到这一行的行尾：$

**2)移动并编辑**

在当行下面插入一个空行并进入编辑模式：o

删除光标所在位置到行尾的内容并进入编辑模式：C

快速到达行尾并进入编辑模式：A

在当行的上面插入一个空行并进入编辑模式：O

删除光标所在位置到行尾的内容：D，d$

清空当前行并进入编辑模式：cc

撤销当前操作：u
恢复刚才的操作:`ctrl+r`

**3)复制移动粘贴**

复制：yy ，2yy（复制2行）

粘贴：p，3p(粘贴3行)

剪切：dd，2dd(剪切2行)

显示行号：`:set nu`

查找：`/`   ,下一个:`n` ,上一个: `N`

取消搜索：`:noh`

vim中查看帮助文档`:help :命令`取消帮助文档`:q`

`:3move10`把第3行移动到第10行后面

`:3,5mo10`把第3到5行移动到第10行

`:3copy10`把第3行复制到第10行后面

`:3,5co10`把第3行到5行复制到第10行

**4）替换**

`:%s#要替换的字符#替换的字符#g` 

**5)删除或复制选中的元素 **

按`V`进入可视块模式，选取（k，j）要处理的行，yy/dd,p

`ctrl+v`进入可视块模式，选取（k，j）要处理的列

批量插入:`ctrl+v`进入可视化模式，选取（k，j）要处理的列，`shift+i`插入内容，esc批量生效。

## 15.打包压缩三剑客

### tar命令 

打包

linux 把压缩分为两步 打包和压缩

**a.创建压缩包**

```sh
#01 打包压缩/etc目录，叫etc.tar.gz 存放在/tmp下
#tar zcvf /tmp/etc.tar.gz /etc/
#tar zcvf 压缩包位置/名字  被压缩的目录 文件  ....
[root@lj lijun]# tar zcvf /tmp/etc.tar.gz /etc/

c  create 打包
z  gzip   通过gzip工具压缩  etc.tar.gz  .tar打包 .gz  gzip压缩
j  bzip2  通过bzip2工具压缩 .bz2
v  verbose  显示过程
f  file     指定文件（压缩包）
# 推荐简写 tar zcf
```



**b.查看压缩包**

```sh
#查看压缩包内容
tar ztvf /tmp/etc.tar.gz
t  list 查看压缩包内容
#推荐简写 tar tf

[root@lj lijun]# du -sh /etc/  查看目录大小
32M	/etc/

```



**c.解压压缩包**

```sh
#01 解压
默认是解压到当前目录
[root@lj lijun]# cd /tmp
[root@lj tmp]# tar zxvf etc.tar.gz 
#推荐简写 tar xf

#02 解压到指定目录，解压到/opt目录下
[root@lj lijun]# tar xf /tmp/etc.tar.gz  -C /opt/

#03 排除目录（了解）
tar zcf /tmp/etc-paichu.tar.gz /etc/ --exclude=/ect/services
```

### zip

zip格式，默认情况下linux和windows都可以识别格式

目前各种压缩软件也可以识别tar.gz格式

```sh
#01 创建.zip压缩包
[root@lj ~]# zip /tmp/etc.zip /etc/hosts
  adding: etc/hosts (deflated 65%)
[root@lj ~]# zip -r /tmp/etc2.zip /etc/  # -r 递归压缩，默认不能直接压缩目录

#02 解压.zip压缩包
#要先使用 yum install -y unzip  安装unzip工具
[root@lj ~]# unzip /tmp/etc.zip  #默认解压到当前目录
[root@lj etc]# unzip /tmp/etc.zip -d etc  # -d 指定解压目录，目录不存在则创建

#02 查看
[root@lj etc]# unzip -l /tmp/etc.zip 
Archive:  /tmp/etc.zip
  Length      Date    Time    Name
---------  ---------- -----   ----
      158  06-07-2013 22:31   etc/hosts
---------                     -------
      158                     1 file

```

### gzip

应用1：压缩文件：临时注释配置文件

应用2：压缩管道中的数据

```sh
#01 创建文件
[root@lj etc]# gzip /tmp/etc/hosts
[root@lj etc]# ll /tmp/etc/ | grep hosts
-rw-r--r--.  1 root root      370 6月   7 2013 hosts.allow
-rw-r--r--.  1 root root      460 6月   7 2013 hosts.deny
-rw-r--r--.  1 root root       80 6月   7 2013 hosts.gz
#压缩后原文件就没有了，只有压缩后的文件

#02 解压文件
[root@lj etc]# gzip -d /tmp/etc/hosts.gz 
[root@lj etc]# ll /tmp/etc/ | grep hosts
-rw-r--r--.  1 root root      158 6月   7 2013 hosts
-rw-r--r--.  1 root root      370 6月   7 2013 hosts.allow
-rw-r--r--.  1 root root      460 6月   7 2013 hosts.deny
#解压后压缩包就消失了，文件就解压到原地
```

**总结**

| 打包压缩命令 | 选项                                                   | 应用场景                       |
| ------------ | ------------------------------------------------------ | ------------------------------ |
| tar          | 创建:`zcf`查看:`tf`解压:`xf`指定目录`-C`               | linux主要打包压缩命令，备份... |
| zip          | 创建:`-r`查看:`uzip -l`解压:`unzip`指定目录:`unzip -d` | 从其他地方下载，在liunx解压    |
| gzip         | 创建:`gzip` 解压:`gzip -d`                             | 压缩文件，注释作用，解压       |

## 关机重启命令

| 关机命令            |                                                           |
| ------------------- | --------------------------------------------------------- |
| shutdown            | `shutdown -h 10`10分钟后关机，`shutdown -h now/0`立马关机 |
| halt                | 关机，手动关闭电源                                        |
| poweroff            | 关机，关闭电源（立刻关闭，无法取消）                      |
| inint 0 （centos6） | 关机，关闭电源                                            |

shutdown -c   取消shutdown命令的关机或重启

| 重启命令 |                              |
| -------- | ---------------------------- |
| shutdown | `shutdown -r 10`10分钟后重启 |
| reboot   | 立刻重启                     |
| init 6   | 立刻重启                     |

## df 和 du查看磁盘空间

```sh
[root@lj etc]# df -h
文件系统                 容量  已用  可用 已用% 挂载点
devtmpfs                 979M     0  979M    0% /dev
tmpfs                    991M     0  991M    0% /dev/shm
tmpfs                    991M  9.5M  981M    1% /run
tmpfs                    991M     0  991M    0% /sys/fs/cgroup
/dev/mapper/centos-root   17G  2.3G   15G   14% /
/dev/sda1               1014M  138M  877M   14% /boot
tmpfs                    199M     0  199M    0% /run/user/0
#查看磁盘总占用量

[root@lj etc]# du -sh /home/lijun
18M	/home/lijun
#查看具体的目录占用大小
```

## 16.文件权限

Linux权限，通过3个字母控制整个linux权限

权限控制用户对于文件或目录的访问

权限的3个字母

| 权限的字母 |                      |
| ---------- | -------------------- |
| r          | read 是否可读        |
| w          | write 是否可写       |
| x          | execute 是否可以执行 |

**权限，文件与用户的关系**

![image-20250730170233565](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250730170233565.png)

```sh
# 文件与用户关系
所有者：    主人 user
所属的用户组:家庭（与所有者在同一个用户组） group
陌生人（其他人）：隔壁老王  other

# 权限也是分为3个部分

```

![image-20250730170926525](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250730170926525.png)

![image-20250730171147300](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250730171147300.png)

**阅读与使用**

通过数字表示权限

| 权限的数字表示 |      |
| -------------- | ---- |
| r（可读）      | 4    |
| w（可写）      | 2    |
| x（可执行）    | 1    |
| -（没有权限）  | 0    |



```sh
#字母权限---->数字权限
drwxr-xr-x. 3 root root  17 7月  30 14:53 etc
d 421 401 401 =》 7 5 5
权限是每个部分的数字加在一起

#数字权限  ==》字母权限
644  rw- r-- r--
```

**修改权限**

通过数字修改（常用，简洁）

通过字符修改权限（用来增加权限）

chown（修改所有者）

| chmod  修改权限 change mod |                          |
| -------------------------- | ------------------------ |
| -R                         | 递归修改权限（修改目录） |
|                            |                          |
|                            |                          |

```sh
#给文件修改755权限
[root@lj etc]# chmod 755 hosts
[root@lj etc]# ll
总用量 4
drwxr-xr-x. 3 root root  17 7月  30 14:53 etc
-rwxr-xr-x. 1 root root 158 6月   7 2013 hosts

# 给目录及内容修改644权限 （极其危险的操作）
[root@lj etc]# chmod -R 644 etc
[root@lj etc]# ll etc
总用量 0
drw-r--r--. 2 root root 19 7月  30 14:53 etc

#通过字符修改权限
格式：chmod  u或g或o  -或+或= rwx

#给用户减去执行权限
[root@lj etc]# ll 
总用量 4
drw-r--r--. 3 root root  17 7月  30 14:53 etc
-rwxr-xr-x. 1 root root 158 6月   7 2013 hosts
[root@lj etc]# chmod u-x hosts 
[root@lj etc]# ll
总用量 4
drw-r--r--. 3 root root  17 7月  30 14:53 etc
-rw-r-xr-x. 1 root root 158 6月   7 2013 hosts

#给所有用户增加X权限  以下方式都可以：
chmod u+x,g+x,o+x oldboy.sh
chmod ugo+x oldboy.sh
chmod a+x oldboy.sh
chmod +x oldboy.sh
```

**rwx对于文件与目录的真正含义**

1. 文件与rwx权限

   | 文件的rwx |                                                              |
   | --------- | ------------------------------------------------------------ |
   | r         | 是否可读文件的内容                                           |
   | w         | 是否能修改文件的内容，需要r权限的配合                        |
   | x         | 是否可以与那些文件的内容（脚本文件/命令）脚本文件`.sh .bash .py`结尾，需要r权限的配合 |

   注意：不要使用root用户进行测试，可以使用root修改权限或所有者。

   ```sh
   [oldboy@lj ~]$ ll -h oldboy.sh 
   -r--r--r--. 1 oldboy oldboy 7 7月  31 15:28 oldboy.sh  #只读权限
   [oldboy@lj ~]$ ./oldboy.sh
   bash: ./oldboy.sh: 权限不够    #不能执行
   [oldboy@lj ~]$ echo 'id' >> oldboy.sh 
   bash: oldboy.sh: 权限不够     #不能写入
   [oldboy@lj ~]$ cat oldboy.sh 
   pwd                          #可以读取
   #注意文件只有w权限，可以通过>>修改文件内容，或vim修改文件，但是vim修改保存后原文件内容丢失，只保存修改后的内容
   #对于文件来说，有w也要有r权限。
   
   #测试执行权限
   [oldboy@lj ~]$ ll -h oldboy.sh 
   ---xr--r--. 1 oldboy oldboy 7 7月  31 15:28 oldboy.sh
   [oldboy@lj ~]$ ./oldboy.sh
   bash: ./oldboy.sh: 权限不够   #只有执行权限，没有读权限是无法执行的
   [root@lj oldboy]# chmod u+r oldboy.sh 
   [root@lj oldboy]# ll
   总用量 4
   -r-xr--r--. 1 oldboy oldboy 7 7月  31 15:28 oldboy.sh
   [oldboy@lj ~]$ ./oldboy.sh
   /home/oldboy
   uid=1001(oldboy) gid=1001(oldboy) 组=1001(oldboy) 环境=unconfined_u:unconfined_r:unconfined_t:s0-s0:c0.c1023
   #添加了读权限，就可以执行了
   ```

2. 目录与rwx权限

| 目录的rwx |                                                          |
| --------- | -------------------------------------------------------- |
| r         | 是否可以查看目录的内容，需要x权限配合                    |
| w         | 是否可以在目录中创建，删除，重命名文件的权限,需要x的配合 |
| x         | 是否可以进入到目录中,可以查看/修改目录下文件的属性信息   |

```sh
#测试目录的r权限
[oldboy@lj ~]$ ll
总用量 4
-r-xr--r--. 1 oldboy oldboy   7 7月  31 15:28 oldboy.sh
dr--r-xr-x. 2 oldboy oldboy 196 7月  31 15:52 perm
[oldboy@lj ~]$ ll -h perm/
ls: 无法访问perm/lidao01.txt: 权限不够
ls: 无法访问perm/lidao02.txt: 权限不够
ls: 无法访问perm/lidao03.txt: 权限不够
ls: 无法访问perm/lidao04.txt: 权限不够
ls: 无法访问perm/lidao05.txt: 权限不够
ls: 无法访问perm/lidao06.txt: 权限不够
ls: 无法访问perm/lidao07.txt: 权限不够
ls: 无法访问perm/lidao08.txt: 权限不够
ls: 无法访问perm/lidao09.txt: 权限不够
ls: 无法访问perm/lidao10.txt: 权限不够
总用量 0
-????????? ? ? ? ?            ? lidao01.txt
-????????? ? ? ? ?            ? lidao02.txt
-????????? ? ? ? ?            ? lidao03.txt
-????????? ? ? ? ?            ? lidao04.txt
-????????? ? ? ? ?            ? lidao05.txt
-????????? ? ? ? ?            ? lidao06.txt
-????????? ? ? ? ?            ? lidao07.txt
-????????? ? ? ? ?            ? lidao08.txt
-????????? ? ? ? ?            ? lidao09.txt
-????????? ? ? ? ?            ? lidao10.txt
#只有r权限，并不能查看目录的内容
[oldboy@lj ~]$ ll
总用量 4
-r-xr--r--. 1 oldboy oldboy   7 7月  31 15:28 oldboy.sh
dr-xr-xr-x. 2 oldboy oldboy 196 7月  31 15:52 perm
[oldboy@lj ~]$ ll perm/
总用量 0
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao01.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao02.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao03.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao04.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao05.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao06.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao07.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao08.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao09.txt
-rw-r--r--. 1 root root 0 7月  31 15:52 lidao10.txt
#rx权限，就可以正常查看目录的内容
#对于目录来说，r权限查看目录内容，需要x的配合
#对于目录来说，x进入目录权限，查看或修改目录中文件属性的权限
#只有w权限 ，无法查看目录内容，也无法创建/删除文件
#授予wx权限  可以创建或删除
#对于目录的w权限，再目录中创建/删除，需要目录x权限配合
#目录只有x权限 无法查看，无法创建删除，只能cd到目录，没有意义
```

删除文件，创建文件，要看 用户与文件所在**目录的**权限，对目录要有w权限，需要x配合

**permission denied  权限拒绝类错误排障**

拍错步骤：

+ 目标：确定用户与文件（目录）有什么权限，缺少什么导致故障...

+ 整体确定：与文件还是与目录权限有关

  用户无文件（目录）关系：主人/家人/陌生人
  文件/目录的对应的权限：前三位，中间三位，还是最后三位
  得出用户对文件/目录的权限是: ？

**特殊权限**

使用频率极低，主要掌握他们的含义

```sh
[root@lj ~]# ll -d /bin/passwd /tmp/
-rwsr-xr-x.  1 root root 27856 4月   1 2020 /bin/passwd
drwxrwxrwt. 17 root root  4096 8月   1 12:39 /tmp/

```

1.设置了suid(set uid)特殊权限的命令，用户运行命令的时候相当于是命令的所有者（root）

```sh
chmod u+s /bin/cat
```

2./tmp 这个目录设置粘滞位后，每个用户都可以在这个目录创建文件，每个用户只能管理自己创建的文件。

3.隐藏属性

应用:给命令或配置文件，加把锁

```sh
#lasttr  查看隐藏属性
[root@lj ~]# lsattr
---------------- ./anaconda-ks.cfg
---------------- ./bei.png
---------------- ./etc

#chattr  修改隐藏属性
#a 属性   append 只能追加
#i 属性   immutable 无敌的，不可摧毁的（只能查看，不能修改删除）
[root@lj ~]# lsattr
---------------- ./anaconda-ks.cfg
---------------- ./bei.png
---------------- ./etc
---------------- ./oldboy.txt
[root@lj ~]# chattr +a oldboy.txt 
[root@lj ~]# lsattr
---------------- ./anaconda-ks.cfg
---------------- ./bei.png
---------------- ./etc
-----a---------- ./oldboy.txt
[root@lj ~]# echo 'oldboy' >oldboy.txt
-bash: oldboy.txt: 不允许的操作
[root@lj ~]# echo 'oldboy' >>oldboy.txt
[root@lj ~]# cat oldboy.txt 
oldboy

[root@lj ~]# chattr +i oldboy.txt
[root@lj ~]# lsattr
---------------- ./anaconda-ks.cfg
---------------- ./bei.png
---------------- ./etc
----i----------- ./oldboy.txt
[root@lj ~]# echo 'oldboy' >>oldboy.txt
-bash: oldboy.txt: 权限不够
[root@lj ~]# cat oldboy.txt 
oldboy

```

**系统默认权限umask**

umask控制系统的默认的权限

```sh
# root 用户的umask
[root@lj ~]# umask
0022

#文件或目录最大权限
file 666
dir  777

#系统默认的权限
file 644
dir  755

# 通过umask 计算 文件的默认的权限
文件的默认权限=文件的最大权限-用户的默认权限 666-022 = 644
目录的默认权限=目录的最大权限-用户的默认权限 777-022 = 755

#注意:如果umask有奇数位，减去umask后，奇数位+1，（目录不受影响）
假设 umask 是023
文件  666-023=643 +001 644
目录  777-023=754
```

## 17.通配符

匹配参数，匹配批量文件/目录名字，如:`*.txt ,*.log,log{1..2}.log`

| 通配符 |                                              |
| ------ | -------------------------------------------- |
| *      | 所有                                         |
| {}     | 生成序列                                     |
| []     | [a-z]匹配小子字母   1个中括号相当于是1个字符 |
| [^]    | 取反，排除                                   |
| ?      | 任何一个字符                                 |

1.匹配所有，*.txt  *.log  *.avi

```sh
#01 列出当前目录下所有的txt文件
ls *.txt

#02 找出/etc 目录下所有的.conf文件
find /etc -type f -name '*.conf'

#03 找出/etc/目录下包含oldboy的文件
find /etc/ -type f -name '*oldboy*'
```

2.生成序列-数字或字母

```sh
[root@lj ~]# echo {1..10}
1 2 3 4 5 6 7 8 9 10
[root@lj ~]# echo {01..10}
01 02 03 04 05 06 07 08 09 10
[root@lj ~]# echo {01..100}
001 002 003 004 005 006 007 008 009 010 011 012 013 014 015 016 017 018 019 020 021 022 023 024 025 026 027 028 029 030 031 032 033 034 035 036 037 038 039 040 041 042 043 044 045 046 047 048 049 050 051 052 053 054 055 056 057 058 059 060 061 062 063 064 065 066 067 068 069 070 071 072 073 074 075 076 077 078 079 080 081 082 083 084 085 086 087 088 089 090 091 092 093 094 095 096 097 098 099 100
[root@lj ~]# echo oldboy{01..10}
oldboy01 oldboy02 oldboy03 oldboy04 oldboy05 oldboy06 oldboy07 oldboy08 oldboy09 oldboy10
[root@lj ~]# echo oldboy{1,9,10}  #没有规律时，可以用，分割不用的内容
oldboy1 oldboy9 oldboy10
[root@lj ~]# echo oldboy.txt{,.bak}  #可以用于备份文件
oldboy.txt oldboy.txt.bak

[root@lj ~]# seq 1 2 10   # seq 从哪开始   步长   到哪结束
1
3
5
7
9
[root@lj ~]# echo {1..10..2} ##{从哪开始..到哪结束..每次步长}
1 3 5 7 9

```

| 引号系列 |                                                              |
| -------- | ------------------------------------------------------------ |
| 单引号   | 所见即所得，单引号里面的内容会被原封不动输出（大部分命令）   |
| 双引号   | 与单引号类似，双引号里面的特色符合会被解析运行，``反引号 $() $ |
| 不加引号 | 与双引号类型，支持通配符                                     |
| 反引号   | 优先执行反引号里面的命令                                     |

```sh
#单引号
[root@lj ~]# echo 'oldboy-li $LANG `hostname` $(whoami) {1..5}'
oldboy-li $LANG `hostname` $(whoami) {1..5}
#双引号
[root@lj ~]# echo "oldboy-li $LANG `hostname` $(whoami) {1..5}"
oldboy-li zh_CN.UTF-8 lj root {1..5}
#不加引号
[root@lj ~]# echo oldboy-li $LANG `hostname` $(whoami) {1..5}
oldboy-li zh_CN.UTF-8 lj root 1 2 3 4 5

```



## 18.正则表达式

主要用来进行匹配字符

注意事项：
1.所有符号都是英文符合

2.刚开始学习的时候推荐使用grep显示，正则执行过程或匹配了什么内容：https://www.jyshare.com/front-end/7625/

3.注意系统的语言与字符集

### 1.正则分类

regular expression （RE）正则表达式

基础正则  BRE （basic）
扩展正则  ERE   （Extended）

| 正则分类 |                                     |
| -------- | ----------------------------------- |
| 基础正则 | ^   $   ^$   .   *    .*    []  [^] |
| 扩展正则 | \|   +  {}  ()  ?                   |

| 通配符与正则区别 | 处理目标不同                                 | 支持的命令不同                                          |
| ---------------- | -------------------------------------------- | ------------------------------------------------------- |
| 通配符           | 文件/目录 文件名 处理的是参数                | linux大部分命令都可以使用                               |
| 正则             | 进行过滤，在一个文件中查找内容，处理的是字符 | linux三剑客，开发语言（Python，golang，php，js...）支持 |

### 2.基础正则（BRE）

**^  表示以...开始的行**

```sh
[root@lj ~]# grep '^Th' oldboy.txt 
The pleasure of ignorance lies in the pleasure it brings us of constant discovery. Because we are ignorant enough, every fact in nature is novel and special. The author gave an example of a naturalist to prove that the pleasure of a naturalist lies in his own ignorance. As he is ignorant, he looks forward to discovering a new world. He hopes to see female cuckoo laying eggs and know the color of cuckoo eggs with his own eyes. The author also gave the example of the new moon, proving that even if you think you know something well, there is still a side to it that you don't know, which is still surprising. Even if we are familiar with when the primroses bloom and when the apple trees bear fruit, we will still marvel at their beauty.
The joy of ignorance also lies in discovering new shining points on the basis of forgetting. For example, learning the names of flowers again every spring. The author also provides numerous examples to prove that the ignorance brought about by forgetting allows us to view things from a new perspective, allowing us to break free from fixed thinking patterns, rethink, and rediscover new knowledge.
The pleasure of ignorance also lies in the pleasure of asking questions, that is, the pleasure of seeking knowledge. Asking questions is not about dogmatic answers, but about being eager to learn and seek knowledge. The author provides examples of Joey only starting to study physiology after reaching his sixties, as well as examples of Socrates feeling ignorant at the age of seventy, indicating that we should be humble, eager to learn, and willing to ask questions and seek knowledge. Admitting one's own ignorance and then retreating into a new round of ignorance in order to seek knowledge.
This article extensively uses factual examples to support the various pleasures brought by ignorance, making the content of the article more accessible, authentic, and credible. In addition, this article also employs a contrasting writing technique, such as Joey, who is in his sixties and still eager to learn, but most people in their sixties have already lost their awareness of ignorance and rely on old age to sell old age. The two form a sharp contrast, further demonstrating that ignorance brings endless joy in seeking knowledge and asking questions.

```

**$ 以...结尾的行**

```sh
[root@lj ~]# grep 's.$' oldboy.txt 
At the beginning of the entire article, we first point out the vastness of our ignorance through the example of an ordinary urbanite walking in the countryside, and then further point out that it is our poor observation that leads to our ignorance. Because we are accustomed to these natural phenomena and have never paid attention to observation, we cannot distinguish them. The first paragraph of the article always describes the current situation of our ignorance, and then describes the benefits of ignorance in different paragraphs.
This article extensively uses factual examples to support the various pleasures brought by ignorance, making the content of the article more accessible, authentic, and credible. In addition, this article also employs a contrasting writing technique, such as Joey, who is in his sixties and still eager to learn, but most people in their sixties have already lost their awareness of ignorance and rely on old age to sell old age. The two form a sharp contrast, further demonstrating that ignorance brings endless joy in seeking knowledge and asking questions.
```

**^$ 匹配空行**

空行表示这一行没有任何字符，如果有空格，不算是空行。

排除文件的空行

```sh
[root@lj ~]# grep -v '^$' /etc/ssh/sshd_config
[root@lj ~]# grep -v '^$' /etc/ssh/sshd_config|grep -v '#'
```

**.(点) 表示任意一个字符**

| 转义字符系列 |                 |
| ------------ | --------------- |
| \            | 去掉特殊含义    |
| \n           | 回车换行        |
| \t           | 制表符（tab键） |

```sh
[root@lj ~]# echo 'lidao\noldboy'
lidao\noldboy
[root@lj ~]# echo -e 'oldboy \n lidao'
oldboy 
 lidao
[root@lj ~]# echo -e 'oldboy \n lidao\tlidao'
oldboy 
 lidao	lidao
[root@lj ~]# echo -e 'oldboy \n lidao\tlidao\n\t\ta'
oldboy 
 lidao	lidao
		a

```

***前一个字符连续出现0次或0次以上**

```sh
#连续出现
		  #连续出现0次，没有出现过
2         #连续出现1次
222		  #连续出现3次
22222     #连续出现多次

[root@lj ~]# grep 't*' oldboy.txt 
At the beginning of the entire article, we first point out the vastness of our ignorance through the example of an ordinary urbanite walking in the countryside, and then further point out that it is our poor observation that leads to our ignorance. Because we are accustomed to these natural phenomena and have never paid attention to observation, we cannot distinguish them. The first paragraph of the article always describes the current situation of our ignorance, and then describes the benefits of ignorance in different paragraphs.

```

正则表达式表示连续出现或所有的时候，会出现尽可能多的匹配，贪婪性

**.*所有的内容**

```sh
#01任意开头，以o结尾
[root@lj ~]# grep '^.*o' oldboy.txt 
#匹配以n开头并且以.结尾的行
[root@lj ~]# grep '^n.*\.$' oldboy.txt 
```

**[] 表示一个整体相当于1个字符，[abc]匹配字符a或b或c，中的任意一个**

```sh
#匹配数字
[0-9]

#匹配大小写字母
[a-z]  #匹配小写 a-z
[A-Z]  #匹配大写 A-Z
[a-zA-Z] #匹配a-z不区分大小写
```

**[^] [ ^abc] 表示一个整体，匹配排查a或b或c外的，任意一个字符**

总结

| BRE  |                                           |
| ---- | ----------------------------------------- |
| ^    | 以..开头的行，如 ^my                      |
| $    | 以..结尾的行，如 M$                       |
| ^$   | 空行，没有任何符合的行                    |
| .    | 任何一个字符                              |
| *    | 前一个字符连续（重复）出现0次或0次以上    |
| .*   | 所有，（贪婪性：尽可能多的匹配）          |
| []   | [abc] [a-z] [A-Z] [0-9]每次匹配1个字符    |
| [^]  | [^anc] 排除a或n或c，匹配除了anc之外的内容 |
| \    | 转义字符                                  |
| \n   | 回车换行                                  |
| \t   | 制表符，tab键                             |

### 3.扩展正则（ERE）

**+前一个字符连续出现1次或者1次以上**

```sh
#01 过滤出连续出现的0
[root@lj ~]# egrep '0+' oldboy.txt  #扩展正则用egrep命令

#02 过滤出连续出现的数字
[root@lj ~]# egrep '[0-9]+' oldboy.txt 

#03 过滤出连续出现的字母
[root@lj ~]# egrep '[a-zA-Z]+' oldboy.txt 
At the beginning of the entire article, we first point out the vastness of our ignorance through theexample of an ordinary urbanite walking in the countryside, and then further point out that it is ou poor observation that leads to our ignorance. Because we are accustomed to these natural phenomena and have never paid attention to observation, we cannot distinguish them. The first paragraph of the article always describes the current situation of our ignorance, and then describes the benefits of ignorance in different paragraphs.
#连续出现
```

**| 或者**

```sh
[root@lj ~]# egrep -o 'and|or' oldboy.txt 
or
or
and
or
or
and
or
and
or
or
or
and
or
or
or
or
# |和[]的区别：|可以表示单个字符或者单词，[]只能表示单个字符
```

**{}  a{n,m} 前一个字符a，连续出现n次，最多m次**

| {}格式 |                                       |
| ------ | ------------------------------------- |
| a{n,m} | 前一个字符a，连续出现至少n次，最多m次 |
| a{n}   | 前一个字符a，连续出现n次              |
| a{,m}  | 前一个字符a，最多出现m次              |
| a{n,}  | 前一个字符a，连续出现至少n次          |



```sh
#01 匹配字母o，出现了至少1次，最多3次
[root@lj ~]# egrep -o 'o{1,3}' oldboy.txt 
o
o
o
o
o
o
o
o
o
o
o
o
o
oo

#02 匹配连续出现2次的字母o
[root@lj ~]# egrep -o 'o{2}' oldboy.txt 
oo
oo
oo
oo
oo
oo

```

**（）被括起来的内容相当于是一个整体；sed命令的后向引用（反向引用）**

```sh
#匹配文件中的 and或amd
[root@lj ~]# egrep 'a(m|n)d' oldboy.txt 

```

**? 表示前一个字符出现0次或一次**

```sh
# gd 或god
[root@lj ~]# egrep 'go?d' oldboy.txt 

```

小结

| ERE  |                                       |
| ---- | ------------------------------------- |
| +    | 前一个字符出现1次或多次               |
| \|   | 或者                                  |
| ()   | 1.表示整体 2.后向引用（反向引用）分组 |
| {}   | a{n,m}  字符a出现至少n次，最多m次     |
| ?    | 前一个字符出现0次或1次                |

### 4.正则总结

| 出现（连续出现/重复） | 连续出现次数 |
| --------------------- | ------------ |
| +                     | 1次及多次    |
| {}                    | 任意次范围   |
| *                     | 0次及多次    |
| ?                     | 0次或1次     |

| 整体（或者） |                               |
| ------------ | ----------------------------- |
| []           | [abc]  其中之一               |
| ()           | 整体 括号内做为整体           |
| [^]          | [^abc] 取反                   |
| \|           | 或者 （可以表示单词中的一个） |

| 其他 |                       |
| ---- | --------------------- |
| ^    | 以^后面的字符作为开头 |
| $    | 以$前面的字符作为结尾 |
| ^$   | 空行                  |
| .*   | 所有                  |
| .    | 任意一个字符          |
| \    | 转移字符              |

括号表达式

```sh
[[:allnum]] ==>[a-zA-Z0-9]
```

grep 命令

| grep选项      |                                                              |
| ------------- | ------------------------------------------------------------ |
| -n            | 行号                                                         |
| -v            | 排除                                                         |
| -i            | 不区分大小写                                                 |
| -o            | 显示执行过程（grep/egrep）                                   |
| -E  ==》egrep | 让grep支持扩展正则                                           |
| -w            | 精确过滤                                                     |
| -R            | 递归查找                                                     |
| -l            | 只显示文件名                                                 |
| -A            | grep过滤的时候显示内容及下面的一行（-B上面的，-C上面和下面的） |

```sh
#通过grep 查找文件内容包含oldboy的文件
#方法1
[root@lj ~]# grep 'oldboy' `find /etc -type f`
/etc/group:oldboy:x:1001:
/etc/gshadow:oldboy:!::
/etc/group-:root:x:0:oldboy
/etc/group-:oldboy:x:1001:
/etc/gshadow-:root:::oldboy
/etc/gshadow-:oldboy:!::
/etc/passwd:oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
/etc/passwd-:oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
/etc/shadow-:oldboy:$6$LHAwVzIJ$Uvp3S9k.5OeN1aMYYv5RL0hDOHSYQJTbLseacOs6d2OpZbwHJQJzLc8wHri7MFRA36eQPPbGDT7yYYQ/j/u8p0:20294:0:99999:7:::
/etc/shadow:oldboy:$6$LHAwVzIJ$Uvp3S9k.5OeN1aMYYv5RL0hDOHSYQJTbLseacOs6d2OpZbwHJQJzLc8wHri7MFRA36eQPPbGDT7yYYQ/j/u8p0:20294:0:99999:7:::
/etc/subgid:oldboy:100000:65536
/etc/subuid:oldboy:100000:65536
/etc/sudoers:oldboy  ALL=(ALL)       /bin/cat,/bin/less
/etc/subuid-:oldboy:100000:65536
/etc/subuid-:oldboy999:231072:65536
/etc/subgid-:oldboy:100000:65536
/etc/subgid-:oldboy999:231072:65536

#方法2 简单过滤与查找 -R
[root@lj ~]# grep -R 'oldboy' /etc/
/etc/group:oldboy:x:1001:
/etc/gshadow:oldboy:!::
/etc/group-:root:x:0:oldboy
/etc/group-:oldboy:x:1001:
/etc/gshadow-:root:::oldboy
/etc/gshadow-:oldboy:!::
/etc/passwd:oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
/etc/passwd-:oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
/etc/shadow-:oldboy:$6$LHAwVzIJ$Uvp3S9k.5OeN1aMYYv5RL0hDOHSYQJTbLseacOs6d2OpZbwHJQJzLc8wHri7MFRA36eQPPbGDT7yYYQ/j/u8p0:20294:0:99999:7:::
/etc/shadow:oldboy:$6$LHAwVzIJ$Uvp3S9k.5OeN1aMYYv5RL0hDOHSYQJTbLseacOs6d2OpZbwHJQJzLc8wHri7MFRA36eQPPbGDT7yYYQ/j/u8p0:20294:0:99999:7:::
/etc/subgid:oldboy:100000:65536
/etc/subuid:oldboy:100000:65536
/etc/sudoers:oldboy  ALL=(ALL)       /bin/cat,/bin/less
/etc/subuid-:oldboy:100000:65536
/etc/subuid-:oldboy999:231072:65536
/etc/subgid-:oldboy:100000:65536
/etc/subgid-:oldboy999:231072:65536

#只显示文件名 -l
[root@lj ~]# grep -Rl 'oldboy' /etc/
/etc/group
/etc/gshadow
/etc/group-
/etc/gshadow-
/etc/passwd
/etc/passwd-
/etc/shadow-
/etc/shadow
/etc/subgid
/etc/subuid
/etc/sudoers
/etc/subuid-
/etc/subgid-

```

## 19.三剑客-sed

sed功能：
1.增删改查
2.取行，替换，查找（更精确）
3.sed命令执行流程

+ sed命令处理的过程按照行为单位处理（1行1行处理）

+ 读取文件的1行，存放内存中

+ sed命令判断，这一行是否满足条件

  + 满足：执行对应的命令

  + 不满足，读取下一行，继续开始

+ 默认读取到最后一行才会结束

  

### sed-查询

| sed命令格式 | 选项                  | 找谁干啥        | 文件         |
| ----------- | --------------------- | --------------- | ------------ |
| sed         | -n                    | '3p'            | sed.txt      |
|             | 取消sed命令的默认输出 | 3=第三行 p=输出 | 要查询的文件 |

| sed选项 |                                 |
| ------- | ------------------------------- |
| -n      | 取消默认输出一般与p使用 -n '3p' |
| -r      | sed支持扩展正则                 |
| -i      | 修改文件内容                    |
| -i.bak  | 修改前先备份，再修改文件        |



```sh
#取出文件的第三行，指定行号的写法
[root@lj ~]# sed -n '3p' oldboy.txt
# -n 取消sed命令的默认输出
#sed默认会显示文件所有内容

#02 取出文件中从第2行到第4行的内容 范围
[root@lj ~]# sed -n '2,4p' oldboy.txt 

#03 类似于grep过滤，包含oldboy的行  模糊查询
[root@lj ~]# sed -n '/^[aA]/p' oldboy.txt #//表示过滤，可以支持正则，-r 支持扩展正则

#04 取出从包含101的行开始，到包含105的行结束  范围
[root@lj ~]# sed -n '/101/,/105/p' oldboy.txt 
[root@lj ~]# sed -n '/从哪里来/,/到哪里去/p' oldboy.txt 
wc -l 文件  #统计文件的行数

```

### sed-删除

```sh
sed '3d' sed.txt #删除第三行
#d 表示删除
sed '2,5d' sed.txt #删除第2至5行

sed ‘/oldboy/d’ sed.txt #删除包含oldboy的行
sed -r '/oldboy|lidao/d' sed.txt # -r 支持扩展正则

#删除/etc/ssh/sshd_config 文件中的空行或包含注释的行
sed -r '/^$|^#/d' /etc/ssh/sshd_config 
```

### sed-增加

+ 类似于 >>
+ 增加 c i a 

```sh
# a append 追加，加到下一行
sed '2a asdfsfsf' sed.txt
# i insert 插入，加到上面
sed '2i asdfsfsf' sed.txt
# c replace 替代，把本行的内容替换成
sed '2c asdfsfsf' sed.txt
```

### sed-修改文件内容

- -i 修改文件内容，这个选项很危险，选项放在最后
- -i.bak 修改文件内容前，会先备份文件

### sed-s修改

修改与替换 sed 's'

```sh
#把sed.txt文件中的oldboy替换成lidao
格式：sed 's#目标#替换成什么#g' 文件
[root@lj ~]# sed 's#this#that#g' oldboy.txt 

#进阶 把文件第2行中的写字母删除
sed '2s#[A-Z]##g' oldboy.txt

p  print  显示
d  delete  删除
s  substitute  替换
g  global  全局替换  一般与 's###g'一起使用 不加g只替换第1个匹配的内容，加上g，只要匹配就替换
```

### 后向引用（反向引用）

```sh
#反向引用：sed命令中使用（）进行分组，然后在后面使用\n（n是数字）来引用分组
[root@lj ~]# echo 123456 |sed 's#123456#<123456>#g'
<123456>
[root@lj ~]# echo 123456 |sed 's#(.*)#<\1>#g'
sed：-e 表达式 #1，字符 13：“s”命令的RHS非法引用\1
[root@lj ~]# echo 123456 |sed -r 's#(.*)#<\1>#g' # 要使用-r使sed支持扩展正则 （.*）作为一个分组，\1 引用第一个分组的内容
<123456>

[root@lj ~]# echo 123456 |sed -r 's#(.)#<\1>#g'
<1><2><3><4><5><6>

#02 把/etc/passwd文件的第一列和最后一列调换位置
[root@lj ~]# cat /etc/passwd
root:x:0:0:root:/root:/bin/bash
bin:x:1:1:bin:/bin:/sbin/nologin
daemon:x:2:2:daemon:/sbin:/sbin/nologin
adm:x:3:4:adm:/var/adm:/sbin/nologin
lp:x:4:7:lp:/var/spool/lpd:/sbin/nologin
sync:x:5:0:sync:/sbin:/bin/sync
shutdown:x:6:0:shutdown:/sbin:/sbin/shutdown
halt:x:7:0:halt:/sbin:/sbin/halt
mail:x:8:12:mail:/var/spool/mail:/sbin/nologin
operator:x:11:0:operator:/root:/sbin/nologin
games:x:12:100:games:/usr/games:/sbin/nologin
ftp:x:14:50:FTP User:/var/ftp:/sbin/nologin
nobody:x:99:99:Nobody:/:/sbin/nologin
systemd-network:x:192:192:systemd Network Management:/:/sbin/nologin
dbus:x:81:81:System message bus:/:/sbin/nologin
polkitd:x:999:998:User for polkitd:/:/sbin/nologin
tss:x:59:59:Account used by the trousers package to sandbox the tcsd daemon:/dev/null:/sbin/nologin
abrt:x:173:173::/etc/abrt:/sbin/nologin
sshd:x:74:74:Privilege-separated SSH:/var/empty/sshd:/sbin/nologin
postfix:x:89:89::/var/spool/postfix:/sbin/nologin
chrony:x:998:996::/var/lib/chrony:/sbin/nologin
lijun:x:1000:1000:lijun:/home/lijun:/bin/bash
ntp:x:38:38::/etc/ntp:/sbin/nologin
oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
mysql:x:1002:1003::/home/mysql:/sbin/nologin
mysql666:x:666:666::/home/mysql666:/sbin/nologin
#通过sed+正则 把第一列，中间内容，最后一列匹配
#通过sed+正则 给3个部分进行分组
#通过sed后向引用 \3 \2 \1 显示
[root@lj ~]# sed -r 's#(^[a-zA-Z0-9-]+)(:.*:)(.*$)#\3 \2 \1#g' /etc/passwd
/bin/bash :x:0:0:root:/root: root
/sbin/nologin :x:1:1:bin:/bin: bin
/sbin/nologin :x:2:2:daemon:/sbin: daemon
/sbin/nologin :x:3:4:adm:/var/adm: adm
/sbin/nologin :x:4:7:lp:/var/spool/lpd: lp
/bin/sync :x:5:0:sync:/sbin: sync
/sbin/shutdown :x:6:0:shutdown:/sbin: shutdown
/sbin/halt :x:7:0:halt:/sbin: halt
/sbin/nologin :x:8:12:mail:/var/spool/mail: mail
/sbin/nologin :x:11:0:operator:/root: operator
/sbin/nologin :x:12:100:games:/usr/games: games
/sbin/nologin :x:14:50:FTP User:/var/ftp: ftp
/sbin/nologin :x:99:99:Nobody:/: nobody
systemd-network:x:192:192:systemd Network Management:/:/sbin/nologin
/sbin/nologin :x:81:81:System message bus:/: dbus
/sbin/nologin :x:999:998:User for polkitd:/: polkitd
/sbin/nologin :x:59:59:Account used by the trousers package to sandbox the tcsd daemon:/dev/null: tss
/sbin/nologin :x:173:173::/etc/abrt: abrt
/sbin/nologin :x:74:74:Privilege-separated SSH:/var/empty/sshd: sshd
/sbin/nologin :x:89:89::/var/spool/postfix: postfix
/sbin/nologin :x:998:996::/var/lib/chrony: chrony
/bin/bash :x:1000:1000:lijun:/home/lijun: lijun
/sbin/nologin :x:38:38::/etc/ntp: ntp
/bin/bash :x:1001:1001:this is a putong user:/home/oldboy: oldboy
/sbin/nologin :x:1002:1003::/home/mysql: mysql
/sbin/nologin :x:666:666::/home/mysql666: mysql666
```

## 20.三剑客-awk

- awk执行流程
- **awk取行和取列**
- awk精确过滤
- awk统计方法（计算）
- awk数组
- awk判断与循环



### awk取行与取列

| awk行与列 |                      |
| --------- | -------------------- |
| 行        | 记录（record）       |
| 列        | 字段（域） （field） |



| awk内置变量（内置规则） |                              |
| ----------------------- | ---------------------------- |
| NR                      | Number of Record记录行号     |
| NF                      | Number of Field 每行有多少列 |
| -F                      | 指定分隔符                   |
| $0                      | 整行内容                     |



```sh
#根据行号取出某一行
[root@lj ~]# awk 'NR==3' /etc/passwd
daemon:x:2:2:daemon:/sbin:/sbin/nologin

#取范围内的行 （2-5行）
[root@lj ~]# awk 'NR>=2&&NR<=5' /etc/passwd
bin:x:1:1:bin:/bin:/sbin/nologin
daemon:x:2:2:daemon:/sbin:/sbin/nologin
adm:x:3:4:adm:/var/adm:/sbin/nologin
lp:x:4:7:lp:/var/spool/lpd:/sbin/nologin

#取包含字符的行默认支持扩展正则
[root@lj ~]# awk '/li/' /etc/passwd
chrony:x:998:996::/var/lib/chrony:/sbin/nologin
lijun:x:1000:1000:lijun:/home/lijun:/bin/bash

#awk显示从li到oldboy的行
[root@lj ~]# awk '/li/,/oldboy/' /etc/passwd
chrony:x:998:996::/var/lib/chrony:/sbin/nologin
lijun:x:1000:1000:lijun:/home/lijun:/bin/bash
ntp:x:38:38::/etc/ntp:/sbin/nologin
oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash

#取出/etc/hosts文件的 所有者和文件名
[root@lj ~]# ll /etc/hosts | awk '{print $1}'  #适合用空格分隔的列
-rw-r--r--.
[root@lj ~]# ll /etc/hosts | awk '{print $NF}'
/etc/hosts
[root@lj ~]# ll /etc/hosts | awk '{print $3,$5,$NF}' 
root 158 /etc/hosts
#awk 指定字符作为列的分隔符  -F ':'  简写成 -F: 分隔符可以指定多个 -F ‘[:/]+’ 以连续的：或/作为分隔符（支持正则）
[root@lj ~]# awk -F: '{print $1,$3}' /etc/passwd |column -t
root             0
bin              1
daemon           2
adm              3
lp               4
sync             5
shutdown         6
halt             7
mail             8
operator         11
games            12
ftp              14
nobody           99
systemd-network  192
dbus             81
polkitd          999
tss              59
abrt             173
sshd             74
postfix          89
chrony           998
lijun            1000
ntp              38
oldboy           1001
mysql            1002
mysql666         666

[root@lj ~]# echo '###1@@@@@2$$$$$$3'|awk -F'[#@$]+' '{print $2,$3,$4}'
1 2 3

```

### awk精确过滤

awk命令格式

`awk 'NR==3{print $3} filename'`

awk '找谁{干啥}' file

找谁：条件 指定你要哪一行

干啥：动作 要执行什么命令 常用print (输出)

**awk条件（模式匹配）pattern**

- 比较表达式 ：> , < , == ,>= ,<=, !=
- 正则
- 范围
- 特殊BEGIN{}和END{}

```sh
#取出/etc/passwd 文件中第3列是以数字1开头的行
[root@lj ~]# awk -F: '$3 ~ /^1/' /etc/passwd
bin:x:1:1:bin:/bin:/sbin/nologin
operator:x:11:0:operator:/root:/sbin/nologin
games:x:12:100:games:/usr/games:/sbin/nologin
ftp:x:14:50:FTP User:/var/ftp:/sbin/nologin
systemd-network:x:192:192:systemd Network Management:/:/sbin/nologin
abrt:x:173:173::/etc/abrt:/sbin/nologin
lijun:x:1000:1000:lijun:/home/lijun:/bin/bash
oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
mysql:x:1002:1003::/home/mysql:/sbin/nologin
#过滤出passwd 文件中第4列以数字0或1结尾的行
[root@lj ~]# awk -F: '$4 ~ /[01]$/' /etc/passwd
root:x:0:0:root:/root:/bin/bash
bin:x:1:1:bin:/bin:/sbin/nologin
sync:x:5:0:sync:/sbin:/bin/sync
shutdown:x:6:0:shutdown:/sbin:/sbin/shutdown
halt:x:7:0:halt:/sbin:/sbin/halt
operator:x:11:0:operator:/root:/sbin/nologin
games:x:12:100:games:/usr/games:/sbin/nologin
ftp:x:14:50:FTP User:/var/ftp:/sbin/nologin
dbus:x:81:81:System message bus:/:/sbin/nologin
lijun:x:1000:1000:lijun:/home/lijun:/bin/bash
oldboy:x:1001:1001:this is a putong user:/home/oldboy:/bin/bash
#过滤出passwd 文件中第4列以数字0或1结尾的行，只显示第1列，第4列和最后一列内容
[root@lj ~]# awk -F: '$4 ~ /[01]$/{print $1,$4,$NF}' /etc/passwd|column -t
root      0     /bin/bash
bin       1     /sbin/nologin
sync      0     /bin/sync
shutdown  0     /sbin/shutdown
halt      0     /sbin/halt
operator  0     /sbin/nologin
games     100   /sbin/nologin
ftp       50    /sbin/nologin
dbus      81    /sbin/nologin
lijun     1000  /bin/bash
oldboy    1001  /bin/bash
#不包含oldboy和li的行
[root@lj ~]# awk '!/oldboy|li/' /etc/passwd
root:x:0:0:root:/root:/bin/bash
bin:x:1:1:bin:/bin:/sbin/nologin
daemon:x:2:2:daemon:/sbin:/sbin/nologin
adm:x:3:4:adm:/var/adm:/sbin/nologin
lp:x:4:7:lp:/var/spool/lpd:/sbin/nologin
sync:x:5:0:sync:/sbin:/bin/sync
shutdown:x:6:0:shutdown:/sbin:/sbin/shutdown
#范围 ：/从哪里/,/到哪里/
awk 's4 ~/11:10:00/,S4 ~/11:20:00/' access.log  #从第4列到第四列中包含XXXX的范围
```

| 符号 |                                              |
| ---- | -------------------------------------------- |
| ~    | 某一列中包含XXX内容（支持正则： //内写正则） |
| !~   | 某一列中不包含XXX内容                        |

| awk特殊模式 |                                                |
| ----------- | ---------------------------------------------- |
| BEGIN{}     | BEGIN{}里面的内容会在awk读取文件之前执行       |
| END{}       | END{}里面的内容会在awk读取文件之后执行（统计） |

```sh
# 显示passwd第1列和第3列前标记user uid
[root@lj ~]# awk -F: 'BEGIN{print "name","uid" }{print $1,$3}' /etc/passwd
name uid
root 0
bin 1
daemon 2
adm 3
lp 4
sync 5
shutdown 6
halt 7
# 统计 /etc/services 中空行的数量（类似于wc -l）
#方法1：
[root@lj ~]# awk '/^$/' /etc/services |wc -l
17
[root@lj ~]# awk '/^$/{i++;print i}' /etc/services #每次符号条件都会输出
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
[root@lj ~]# awk '/^$/{i++}END{print i}' /etc/services #先进行统计，最后END{}输出结果
17

```

