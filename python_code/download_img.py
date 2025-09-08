# @version : 1.0
# @Author  : 混江龙
# @File    : download_img.py
# @Time    : 2025/9/8 19:52
# 爬虫下载图片案例
import os
import urllib.request

from bs4 import BeautifulSoup


def url_open(url):
    req = urllib.request.Request(url)
    req.add_header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36" )
    res = urllib.request.urlopen(req)
    if res.status != 200:
        print("url访问失败！")
    return res.read()

def get_imgs(url):
    """
    获取页面中所有的图片
    :param url: 获取的url地址
    :return: 所有图片的地址
    """
    soup = BeautifulSoup(url_open(url), "lxml")
    imgs = []
    for img in soup.select(".article img[src]"):
        img_url = img.get("src")
        imgs.append(img_url)
    return imgs

def mkdir(list):
    current_dir = os.getcwd()
    parent_dir = os.path.dirname(current_dir)
    for item in list:
        path = parent_dir +'/'+ item['name']
        if not os.path.exists(path):
            os.makedirs(path)
        imgs = get_imgs(item['link_url'])
        for img in imgs:
            save_img(path, img)

def save_img(path, img):
    filename = img.split("/")[-1]
    with open(path + "/" + filename, 'wb') as f:
        img_data = url_open(img)
        f.write(img_data)

base_url = "https://tu.heiguang.com/works?"

if __name__ == "__main__":
    # i = 1
    # # while True:
    # url = base_url + "page="+ str(i) +"&per-page=27"
    # # print(url)
    # # i += 1
    # html = url_open(url).decode("utf-8")
    # # print(html)
    # start = html.find('<a class="active" href="/works?page=') + 36
    # end = html.find('&', start)
    # page = int(html[start:end])
    # # if i != page:
    #     # break
    # soup = BeautifulSoup(html, "lxml")
    # boxs = soup.select('.tk_photo .name')
    # # print(boxs)
    # links = []
    # k = 0
    # for box in boxs:
    #     print()
    #     if str(box).find("<span") == 0:
    #         links.append({})
    #         links[k]['name'] = box.get_text().strip()
    #         k += 1
    #     elif str(box).find("<a") == 0:
    #         links[k-1]['link_url'] = box.get('href')
    # # 循环访问页面中所有的链接，并返回所有的imgurl
    mkdir([{"name":"少女私房写真-资深","link_url":"https://www.heiguang.com/photography/syjc/20211105/136255.html"}])
    # imgs = get_imgs("https://www.heiguang.com/photography/syjc/20211105/136255.html")