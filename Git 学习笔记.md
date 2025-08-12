# Git 学习笔记

## git的结构

1. 工作区：写代码 通过`git add`把代码提交到暂存区
2. 暂存区：临时存储 通过`git commit`提交到本地库
3. 本地库：历史版本

## git和代码托管中心

代码托管中心的任务：维护远程库

局域网环境下：gitlab服务器

外网环境下：GitHub 码云

## git命令行操作

1. **本地库初始化**

找到项目目录，鼠标左键`open git bash here`打开bash命令行窗口

```sh
#初始化命令
git init
#初始化成功会创建.git的隐藏目录
Administrator@SK-20220401RKFZ MINGW64 /d/wwwroot/chengpinzhanp_ev7h5r/web/.git (GIT_DIR!)
$ ls -l
total 390
-rw-r--r-- 1 Administrator 197121     18 Jul 15 10:12 COMMIT_EDITMSG
-rw-r--r-- 1 Administrator 197121    102 Jul 15 13:58 FETCH_HEAD
-rw-r--r-- 1 Administrator 197121     21 Mar 12  2024 HEAD
-rw-r--r-- 1 Administrator 197121     41 Jun 11  2024 ORIG_HEAD
-rw-r--r-- 1 Administrator 197121    340 Mar 12  2024 config
-rw-r--r-- 1 Administrator 197121     73 Mar 12  2024 description
drwxr-xr-x 1 Administrator 197121      0 Mar 12  2024 hooks/
-rw-r--r-- 1 Administrator 197121 345590 Jul 15 10:12 index
drwxr-xr-x 1 Administrator 197121      0 Mar 12  2024 info/
drwxr-xr-x 1 Administrator 197121      0 Mar 12  2024 logs/
drwxr-xr-x 1 Administrator 197121      0 Jul 15 13:58 objects/
drwxr-xr-x 1 Administrator 197121      0 Mar 12  2024 refs/
```

**注意：.git目录中存放的是本地库相关的子目录和文件，不要删除，也不要胡乱修改.**

2. **设置签名**

形式：
	用户名：ljuyx

​	邮箱地址：

作用：区分不同开发人员的身份

辨析：这里设置的签名和登录远程库（代码托管中心）的账号，密码没有关系。

命令：

- 项目级别/仓库级别：签名仅在当前本地库范围内有效 `git config`

  ```sh
  #设置项目级别签名
  git config user.name 用户名
  git config user.email 邮箱地址
  #存放位置 
  Administrator@SK-20220401RKFZ MINGW64 /d/wwwroot/chengpinzhanp_ev7h5r/web/.git (GIT_DIR!)
  $ cat config
  [core]
          repositoryformatversion = 0
          filemode = false
          bare = false
          logallrefupdates = true
          symlinks = false
          ignorecase = true
  [lfs]
          repositoryformatversion = 0
  [remote "origin"]
          url = https://github.com/ljuyx010/usedfinish-web.git
          fetch = +refs/heads/*:refs/remotes/origin/*
  [branch "main"]
          remote = origin
          merge = refs/heads/main
  ```

- 系统用户级别：登录当前操作系统的用户范围 `git config --global`

  ```sh
  #设置用户级别签名
  git config --global user.name 用户名
  git config --global user.email 邮箱地址
  #配置存放位置
  $ cd ~
  
  Administrator@SK-20220401RKFZ MINGW64 ~
  $ pwd
  /c/Users/Administrator
  $ cat .gitconfig
  [filter "lfs"]
          process = git-lfs filter-process
          required = true
          clean = git-lfs clean -- %f
          smudge = git-lfs smudge -- %f
  [user]
          name = ljuyx
          email = ljuyx@163.com
  [credential "https://gitee.com"]
          provider = generic
  ```

- 级别优先级：1.就近原则，项目级别优先于系统用户级别，二者都有时采用项目级别的签名 2.如果只有系统用户级别的签名，就以系统用户级别的签名为准 3.二者都没有不允许

3. **基本操作**

- 状态查看操作
  `git status`查看工作区，暂存区状态

- 添加操作
  `git add [file name]`将工作区的新建/修改添加到暂存区

- 提交操作
  `git commit -m "修改描述信息" [file name]`将暂存区的内容提交到本地库

- 查看历史记录操作

  ```sh
  # 查看历史记录
  $ git log   #查看详细记录
  commit 54d2750069a1f3138d76c5d585a4245716f64e2e (HEAD -> master)
  Author: ljuyx <ljuyx@163.com>
  Date:   Mon Aug 11 16:07:46 2025 +0800
  
      my first commit new file
  #多屏显示控制方式：空格向下翻页，b向上翻页，q退出
  
  Administrator@SK-20220401RKFZ MINGW64 /d/WWW/huiyuxcx (master)
  $ git log --pretty=oneline  #历史记录信息只显示一行内容
  54d2750069a1f3138d76c5d585a4245716f64e2e (HEAD -> master) my first commit new file
  
  Administrator@SK-20220401RKFZ MINGW64 /d/WWW/huiyuxcx (master)
  $ git log --oneline #历史记录的hash值简写，只显示当前版本之前的记录
  54d2750 (HEAD -> master) my first commit new file
  
  Administrator@SK-20220401RKFZ MINGW64 /d/WWW/huiyuxcx (master)
  $ git reflog  #显示所有历史记录信息并显示当前版本的指针
  54d2750 (HEAD -> master) HEAD@{0}: commit (initial): my first commit new file
  
  ```

  

- 前进后退
  基于索引值操作：

  ```sh
  #版本移动
  git reset --hard 54d2750 (索引值)
  ```

  使用^符号：只能后退

  ```sh
  git reset --hard HEAD^^ #一个^表示后退一步，n个^就表示后退n步
  ```

  使用~符号：也只能后退

  ```sh
  git reset --hard HEAD~n #表示后退n步
  ```

- reset 命令的三个参数对比
  --soft ：仅仅在本地库移动HEAD指针

  --mixed ：在本地库移动HEAD指针，并重置暂存区

  --hard ：在本地库移动HEAD指针，重置暂存区，重置工作区

- 删除文件并找回
  前提：删除前，文件存在时的状态提交到了本地库。
  操作：git reset --hard [指针位置] 
  两种情况：1.删除操作已经提交到本地库，指针位置指向历史记录 2.删除操作尚未提交到本地库：指针位置使用HEAD

- 比较文件差异

  ```sh
  #将工作区中的文件和暂存区进行比较
  git diff 文件名
  
  #将工作区中的文件和本地库历史记录比较
  git diff 本地库中历史版本 文件名
  
  git diff #不带文件名比较多个文件
  ```

  

- 命令帮助

```sh
git hlep 命令 #可以查看命令的帮助文档
```

## 分支管理

- 什么是分支
  在版本控制过程中，使用多条线同时推进多个任务。
  ![image-20250811172503126](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250811172503126.png)

  

- 分支的好处
  1.同时并行推进多个功能开发，提高开发效率

  2.各个分支在开发过程中，如果某个分支开发失败，不会对其他分支有任何影响。失败的分支删除重新开发即可。

- 分支操作

  - 创建分支
    `git branch 分支名`

  - 查看分支
    `git branch -v`

  - 切换分支
    `git checkout 分支名`

  - 合并分支
    第一步：切换到接收修改的分支（被合并，增加新内容）上

    第二步：执行`git merge [分支名]`命令

  - 解决冲突
    ![image-20250811174031444](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250811174031444.png)
    冲突的解决：
    第一步：编辑文件，删除特殊符号
    第二步：把文件修改到满意的程度，保存退出

    第三步：git add [文件名]

    第四步：git commit -m “日志信息”（注意：此时commit一定不能带具体文件名）

    

## 本地库和远程库

远程地址添加别名

```sh
#查看别名
$ git remote -v

#添加别名
git remote add 别名 远程url

#推送到远程服务器
git push 别名 master(分支名)

#克隆远程服务器代码
git clone  远程url

```

邀请加入团队

![image-20250812173431239](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250812173431239.png)

被邀请人加入团队

被邀请人复制链接到浏览器访问，点同意即可。

![image-20250812173605906](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250812173605906.png)

远程库的拉取分两个步骤：pull = fetch + merge

1.`git fetch [远程库别名] [远程库分支]`把远程数据下载到本地并不会修改本地的数据

2.`git merge [远程库别名]/[远程库分支]` 把远程库的数据合并到本地库，本地库的数据改变了

分两步的好处是可以更精细化的管理，避免冲突。

**解决冲突**

如果不是基于`github`远程库的最新版所做的修改，不能推送，必须先拉取。

拉取下来后如果进入冲突状态，则按照“分支冲突解决”操作，解决即可。

41