#爬虫测试
#pip install requests
#pip install beautifulsoup4
import requests
from bs4 import BeautifulSoup
import time
from selenium import webdriver

base_url = 'https://www.duitang.com/category/?cat=chinoiserie'
header = {'user-agent': 'Mozilla/5.0'}
page = 1
flag = True
option = webdriver.FirefoxOptions()
option.headless = True

while flag == True:
    time.sleep(2)
    print('开始爬取第'+ str(page) + '页...')
    driver = webdriver.Firefox(executable_path='D:\\文件\\编程\\Python\\短学期\\geckodriver.exe',options=option)
    driver.get(base_url)
    scroll = 900
    for i in range(20):
        # 执行JavaScript脚本
        driver.execute_script('$(window).scrollTop(' + str(scroll) + ')')
        scroll += 900
        time.sleep(2)
    # response = requests.get(base_url, headers=header)
    # response.raise_for_status()
    #print(response.text)
    doc = BeautifulSoup(driver.page_source, 'html.parser')
    antiquity_list = doc.select('.stpics > div')
    # print(antiquity_list)
    with open('Antiquity.txt', 'a', encoding='utf-8') as f:
        for antiquity in antiquity_list:
            antiquity_picture = antiquity.select('.mbpho > a > img')[0].get('src')
            # print(antiquity_picture)
            user_picture = antiquity.select('.f > a > img')[0].get('src')
            # print(user_picture)
            antiquity_name = antiquity.select('.wooscr > div ')[0].getText()
            # print(antiquity_name)
            praise = antiquity.select('.d2 > span')[0].getText()
            # print(praise)
            appreciate = antiquity.select('.d1 > span')[0].getText()
            # print(collect)
            user_name = antiquity.select('.p ')[0].getText()
            # print(passname)
            location = antiquity.select('.f > p > span > a')[0].getText()
            # print(location)
            f.write('古风图片地址:' + antiquity_picture + '\n' +
                    '名称:' + antiquity_name.strip() + '\n' +
                    '用户头像地址:' + user_picture.strip() + '\n' +
                    '用户名称:' + user_name.strip() + '\n' +
                    '点赞量:' + praise.strip() + '\n' +
                    '收藏量:' + appreciate.strip() + '\n' +
                    '发布位置:' + location.strip() + '\n' +'\n')
    print('第' + str(page) + '页爬取完成！')
    page = page + 1
    if page == 6:      #爬取前5页
        print('完成，程序退出！')
        flag = False
    else:
        base_url = 'https://www.duitang.com/category/?cat=chinoiserie#!hot-p' + str(page)
        flag = True
        # try:
        #     # 如果没有找到对应的项目内容，会返回一个空。none/null
        # except:
        #     break
