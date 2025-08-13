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

## 跨团队协助

协助人登录自己的账号访问项目Github的url，并点击Fork

![image-20250813145522687](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813145522687.png)

协助人`git clone [fork远程库url]`下载克隆到本地修改

协作人修改完成后，`git commit -m "更改描述" [file]`提交到本地库

协作人`git push [fork远程库url] master`推送到远程库

协作人发起pull requests

1.

![image-20250813151803418](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813151803418.png)

2.

![image-20250813152318667](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813152318667.png)

3.

![image-20250813152418604](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813152418604.png)

4.

![image-20250813152636299](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813152636299.png)

5.原仓库所有者去接收 pull requests

![image-20250813155550346](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813155550346.png)

![image-20250813155812388](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813155812388.png)

6.合并代码

![image-20250813160048825](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813160048825.png)

7.把远程库拉取到本地

## 设置ssh远程登录

1.本地生成ssh-keygen

```sh
$ ssh-keygen -t rsa -C 649047079@qq.com
Generating public/private rsa key pair.
Enter file in which to save the key (/c/Users/Administrator/.ssh/id_rsa):
Created directory '/c/Users/Administrator/.ssh'.
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /c/Users/Administrator/.ssh/id_rsa
Your public key has been saved in /c/Users/Administrator/.ssh/id_rsa.pub
The key fingerprint is:
SHA256:ginpEGncDG8EtVuvN78UUNSBB2/SONk4lYA/LHwfSjs 649047079@qq.com
The key's randomart image is:
+---[RSA 3072]----+
| ooo    o==oo    |
|..* .  ...O+     |
|oo * ...oB.=     |
|....oo.o.*=.     |
|. o.o ..S.= .    |
| o .  .. E..     |
|  .  . o ..      |
|      . +        |
|         o.      |
+----[SHA256]-----+
#查看生成的key
Administrator@SK-20220401RKFZ MINGW64 ~/.ssh
$ ll
total 5
-rw-r--r-- 1 Administrator 197121 2602 Aug 13 16:14 id_rsa
-rw-r--r-- 1 Administrator 197121  570 Aug 13 16:14 id_rsa.pub
#复制id_rsa.pub的ssh-rsa内容
Administrator@SK-20220401RKFZ MINGW64 ~/.ssh
$ cat id_rsa.pub
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDKKwyzAk2HNnyv2lghJCl8aKbvrTszd03iSGy+9cIcDQVnPBUX1ffFgZ9NSq27pfPIiJgX09aCNwm31fz4vETDVxq09O14FLGPRpDcbupofhWaNC7KEwpT0ewsLlSKrVySkT3XrJOO6CG0OqMhSrFLGNbKc//rrgLvsosoyWmkRg86U2dxEzdVj5859ueCe8QtUhT8zDvUzzLr/l6ty3wI0qcqm7/G6K/hATqso9itYiN/mvP6Eymrk+yHuPzfiLZTYr/3tz79Xt/Fb0BRt0wdW+ywBQr6qj6wGUJNu+2a/4JW/oh4a2KVtRkHOHnvIv4h/kU3fQD9CD6TrabykxxWovIVTVJnjcR1J0DX+XEWDvQ4kgmi/SypKoMNj6+CkF5gvTn3d1dOG+yWpQAl8cSvSEf4AxkpUmh73NNUogr55pFD3E2Qe8ZxCAzO+NxIa6mGqGsKsSbOteWobyVP0VcK3dEdZj429uaEzcfpkZUz5Nd13UREZZJTGTOD3kQQlHc=

```

粘贴到github的账号设置中

![image-20250813162728635](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813162728635.png)

设置ssh的别名

![image-20250813163833129](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250813163833129.png)

````sh
$ git remote add gitDemo_ssh git@github.com:ljuyx010/gitDemo.git
$ git remote -v
gitDemo_ssh     git@github.com:ljuyx010/gitDemo.git (fetch)
gitDemo_ssh     git@github.com:ljuyx010/gitDemo.git (push)
gitdemo https://github.com/ljuyx010/gitDemo.git (fetch)
gitdemo https://github.com/ljuyx010/gitDemo.git (push)

#使用ssh链接推送代码到远程仓库
Administrator@SK-20220401RKFZ MINGW64 /d/www/gitDemo (master)
$ git commit -m "第41-42课" Git\ 学习笔记.md
[master d1fde5a] 第41-42课
 1 file changed, 100 insertions(+), 1 deletion(-)

Administrator@SK-20220401RKFZ MINGW64 /d/www/gitDemo (master)
$ git push gitDemo_ssh master
The authenticity of host 'github.com (20.205.243.166)' can't be established.
ED25519 key fingerprint is SHA256:+DiY3wvvV6TuJJhbpZisF/zLDA0zPMSvHdkr4UvCOqU.
This key is not known by any other names.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added 'github.com' (ED25519) to the list of known hosts.
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 12 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 1.97 KiB | 1009.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To github.com:ljuyx010/gitDemo.git
   e0d2ec8..d1fde5a  master -> master

````

## 忽略文件

忽略文件样例

https://github.com/github/gitignore

可以把忽略文件引入到git配置文件中

```sh
[core]
excludesfile = [忽略配置文件路径]
#注意:忽略配置文件的路径一定要使用'/'，不能使用'\'
```

