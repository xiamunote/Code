def add_book(book,m):
    book_manage = {}    #'book_number': 0, 'book_name': 'null ', 'book_type': 0, 'price': 'null'
    book_manage.setdefault('book_name','null ')
    book_manage['book_name'] = input('请输入书籍名：')
    book_manage.setdefault('book_type', 0)
    book_manage['book_type'] = int(input('请输入书籍类型编号：1.文化教育||2.自然科学||3.经典著作||4.其他:'))
    book_manage.setdefault('price', 0.0)
    book_manage['price'] = float(input('请输入书籍价格：'))
    book.setdefault(m + 1,{})
    book[m+1] = book_manage
    print('书籍添加成功！')

def show_book_by_type(book,m):
    k = int (input('请输入书籍类型编号：1.文化教育||2.自然科学||3.经典著作||4.其他:'))
    b_flage = False
    for i in range(m):
        if book[i + 1]['book_type'] == k:
            print(book[i])
            b_flage = True
            continue
    if b_flage == False:
        print('没有找到该类型的书籍！')

def show_book(book):
    for key,value in book.items():
        print('书籍编号：' + str(key) , end='\t')
        print('书籍名称：' + value['book_name'],end = '\t')
        if value['book_type'] == 1:
            print('书籍类型：文化教育',end = '\t' )
        if value['book_type'] == 2:
            print('书籍类型：自然科学',end = '\t')
        if value['book_type'] == 3:
            print('书籍类型：经典著作',end = '\t')
        if value['book_type'] == 4:
            print('书籍类型：其他',end = '\t')
        print('书籍价格：' + str(value['price']))
        print()

def update_book(book):
    k = int(input('请输入要修改的书籍的编号：'))
    if k in book:
        book_name= input('请输入更新后的书籍名：')
        book[k]['book_name'] = book_name
        price= float(input('请输入更新后的书籍价格：'))
        book[k]['price'] = price
        print('修改成功！')
    else:
        print('不存在该编号的书籍！')

def delate_book_by_number(book):
    k = int(input('请输入要删除的书籍的编号：'))
    if k in book:
        book.pop(k)
        print('删除成功！')
        print(book)
    else:
        print('不存在该编号的书籍')


