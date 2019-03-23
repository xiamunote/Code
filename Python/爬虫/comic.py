# 爬虫测试
# install 包名
# pip install requests
# pip install beautifulsoup4
import requests
from bs4 import BeautifulSoup

base_url = 'https://www.duitang.com/category/?cat=comic'
header = {'user-agent': 'Mozilla/5.0'}
while True:
    response = requests.get(base_url, headers=header)
    response.raise_for_status()
    # print(response.text)
    doc = BeautifulSoup(response.text, 'html.parser')
    anime_list = doc.select('.stpics > div')
    # print(anime_list)
    with open('A.txt', 'a', encoding='utf-8') as f:
        for anime in anime_list:
            anime_picture = anime.select('.mbpho > a > img')[0].get('src')
            # print(anime_picture)
            user_picture = anime.select('.f > a > img')[0].get('src')
            # print(user_picture)
            anime_name = anime.select('.wooscr > div ')[0].getText()
            # print(anime_name)
            praise = anime.select('.d2 > span')[0].getText()
            # print(praise)
            collect = anime.select('.d1 > span')[0].getText()
            # print(collect)
            passname = anime.select('.p ')[0].getText()
            # print(passname)
            location = anime.select('.f > p > span > a')[0].getText()
            # print(location)
            f.write('动漫图片地址:' + anime_picture + '\t' +
                    '动漫名称:' + anime_name + '\t' +
                    '用户头像地址:' + user_picture + '\t' +
                    '用户名称:' + passname + '\t' +
                    '作品点赞数:' + praise + '\t' +
                    '作品收藏数:' + collect + '\t' +
                    '作品发布到:' + anime_picture + '\n')
        try:
            # 如果没有找到对应的项目内容，会返回一个空。none/null
            next_page = doc.select('.woo-nxt > li')[-1].get('href')
            # print(next_page)
            base_url = 'http://www.duitang.com' + next_page
        except:
            break