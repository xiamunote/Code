# 1.打印1~100的偶数和奇数的和
# sum1 = 0
# sum2 = 0
# for i in range(101):
#     if i % 2 == 0:
#         sum2=sum2+i
#     else:
#         sum1=sum1+i
# print('100以内的奇数和：' + str(sum1))
# print('100以内的偶数和：' + str(sum2))

#2.使用for循环打印九九乘法表
# for i in range(1,10):
#     for j in range(1,i+1):
#         print(str(j) + '*' +str(i) + '=' + str(i*j) ,end='\t')
#     print()

#3.设计一个猜数字游戏，每次随机生成一个1~20的秘密数字
# import random
# number = random.randint(1,20)
# flage = False
# for i in range(6):
#     n = int(input('请输入你猜测的数字:'))
#     if n > number:
#         print('猜测数字过大，您还有' + str(6-1-i) + '次机会')
#     elif n < number:
#         print('猜测数字过小，您还有' + str(6 - 1 - i) + '次机会')
#     else:
#         print('恭喜您，猜测正确！')
#         flage = True
#         break
# if flage == False:
#     print('正确数字为：' + str(number))
#
# 4.与电脑玩剪刀石头布，玩家选择：1.石头，2.剪刀，3布，电脑随机选择石头、剪刀、布。判断输赢。
# import random
# number = random.randint(1,3)
# n = int(input('请选择你出的选项，1.石头，2.剪刀，3布')
# if number == n:
#     print('平局')
# elif number == 1 and n == 3:
#     print('你赢了！')
# elif number == 2 and n== 1:
#     print('你赢了！')
# elif number == 3 and n == 2:
#     print('你赢了！')
# else:
#     print('你输了！')

#5.使用函数完成斐波拉契的输出前10个数
# def fb(i):
#     if(i<2):
#         return i
#     else:
#         return (fb(i-1)+fb(i-2))
#
# def printFb(n):
#     for i in range(1,n+1):
#         print(str(fb(i)))
#
# printFb(10)



def yangHuiTriangle(n):     #6.使用列表打印杨辉三角形前10行
    m=[]
    temp=[]
    for i in range(n):
        m.append(1)
        temp.append(1)
    for i in range(1,n+1):       #i表示行数
        print( (n+1- i) * '  ', end = ' ')
        if i == 1 :
            print(1)
            continue
        if i == 2:
            print(1,end = '  ')
            print(1)
            continue
        for j in range (1,i+1):
            if j == 1:
                temp[0]=1
                continue
            elif j == i:
                temp[j-1]=1
                continue
            else:
                temp[j-1] = m[j-1] + m[j-2]     #j表示列数，下标等于j-1
        m = temp[:]     #直接使用等于传递的是指针，加[:]后，n于temp是两个值相同的列表
        for k in range(0,j):
            print(str(temp[k]),end='  ')
        print()

yangHuiTriangle(10)

#7.使用input()在控制台接收三次输入的网站地址，使用列表模拟浏览器的前进后退功能。
# l = [input('请输入第一个网址：'),input('请输入第二个网址：'),input('请输入第三个网址：')]
# a = input('请输入前进或后退：')
# if a == '前进':
#     print(l[2])
# if a == 'houtui':
#     print(l[0])

#8.创建列表，随机生成1000个1~100范围的数值放入列表中，统计列表中每个元素在列表中出现的频数。
# import random
# l=[]
# p=[]    #用来记录频数
# for i in range(100):
#     p.append(0)
# for i in range(1000):
#     number = random.randint(1,100)
#     l.append(number)
#     p[number-1] = p[number-1] +1
# for i in range(100):
#     print(str(i+1) + '出现的频数为：' + str(p[i]))     #数组的下标加一代表当前数字，数组的元素记录的是频数

#9、将列表中的元素从小到大或从大到小排列。
# l=[1,2,5,9,7,3,4,6,10,78,45,64,61,23]
# def sort(l):
#     for i in range(14):
#         for j in range(i+1,14):
#             if l[i] < l[j]:
#                 temp=l[i]
#                 l[i]=l[j]
#                 l[j]=temp
#
# sort(l)
# print(l)