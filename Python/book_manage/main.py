""" 夏鹏程
    图书管理系统
"""
import datetime
import user_regist
import book_manage
import login
print(datetime.datetime.now())
user = {}
book = {}
m = 0
i = 0
judge = 1
print('1.登录')
print('2.注册')
print('3.退出')
print('请选择操作编号：',end = '')
k = int(input())
while k != 3:
    if k == 1:
        login.login(user, i)
        while judge == 1:
            print('1.添加书籍')
            print('2.根据书籍类型查看书籍')
            print('3.查看所有书籍信息')
            print('4.更新书籍信息')
            print('5.删除书籍')
            print('6.返回')
            print('请选择操作编号：', end='')
            k = int(input())
            if k == 1:
                book_manage.add_book(book, m)
                m = m + 1
                judge = 1
            if k == 2:
                book_manage.show_book_by_type(book, m)
                judge = 1
            if k == 3:
                book_manage.show_book(book)
                judge = 1
            if k == 4:
                book_manage.update_book(book)
                judge = 1
            if k == 5:
                book_manage.delate_book_by_number(book)
                judge = 1
            if k == 6:
                judge = 2
        else:
            print('1.登录')
            print('2.注册')
            print('3.退出')
            print('请选择操作编号：', end='')
            k = int(input())
            judge = 1
            continue
    if k == 2:
        user_regist.user_regist(user,i)
        i = i + 1
        print('1.登录')
        print('2.注册')
        print('3.退出')
        print('请选择操作编号：', end='')
        k = int(input())


