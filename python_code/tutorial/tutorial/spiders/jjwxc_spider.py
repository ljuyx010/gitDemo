# @version : 1.0
# @Author  : 混江龙
# @File    : jjwxc_spider.py
# @Time    : 2025/9/9 15:03
import json

import scrapy
from tutorial.items import *

class JjwxcSpider(scrapy.Spider):
    name = 'jjwxc'
    allowed_domains = ['m.jjwxc.com']
    start_urls = ['https://m.jjwxc.com/free','https://m.jjwxc.com/rank']
    def parse(self, response):
        # 测试spider是否能正常工作
        # filename = response.url.split('/')[-1]
        # with open(filename, 'wb') as f:
        #     f.write(response.body)
        # 创建节点规则
        selector = scrapy.Selector(response=response)
        sites = selector.xpath('//ul/li')
        # print(sites)
        items = []
        file = open('items.json','a',encoding="utf-8")
        for site in sites:
            item = JjwxcItem()
            item['title'] = site.xpath('.//a/text()').extract_first()
            item['link'] = 'https://m.jjwxc.com' + site.xpath('.//a/@href').extract_first()
            items.append(item)
            items.append(item)
            file.write('{"title":"%s","link":"%s"},\n' %(item['title'],item['link']))
        file.close()
        return items