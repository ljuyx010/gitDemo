# JAVA学习笔记

##  第1章 java介绍

1990年 sun公司启动绿色计划

1992年 创建oak（橡树）语言-->java

1994 gosling 参加硅谷大会演示java功能，震惊世界

1995 sun正式发布java第一个版本。

2009年，甲骨文公司宣布收购sun，2011，发布java7

java其他版本：https://www.oracle.com/cn/java/technologies/downloads/

java技术体系平台

**java SE（java Standard Edition）标准版**

支持面向桌面级应用，提供完整的java核心api，此版本之前称为J2SE

**Java EE(java Enterprise Edition)企业版**

是为开发企业环境下的应用程序提供的一套解决方案。该技术体系中包含的技术如：servlet，jsp等，主要针对web应用程序开发，版本以前称为J2EE

**java ME（java Micro Edition）小型版**

支持java程序运行在移动终端（手机，pad）上的平台，对java api有所精简，并加入针对移动终端的支持，此版本以前称为J2ME

java 重要特点

1. java语言是面向对象的（oop）
2. java语言是健壮的，java的强类型机制，异常处理，垃圾的自动收集等是java程序健壮性的重要保证
3. java语言是跨平台型的
4. java语言是解释型的
   解释型语言：JavaScript，PHP，java 编译型语言：c /c++
   区别是：解释型语言，编译后的代码，不能直接被机器执行，需要解释器来执行，编译型语言，编译后的代码，可以直接被机器执行。

JVM java虚拟机是java跨平台的关键。

`javac`命令编译java文件为class文件   `java`命令运行编译后的class文件

JDK java开发工具包 JDK = JRE+java开发工具

JRE java运行环境  JRE = JVM + java的核心类库

11