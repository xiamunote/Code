# # 求200以内的质数和
# sum = 2
# for i in range(3, 200, 2):
#     flag = True
#     sum = sum + i
#     if i == 3 or i == 5:
#         print(str(i))
#         continue
#     else:
#         for j in range(3, int(i / 2), 2):
#             if i % j == 0:
#                 sum = sum - i
#                 flag = False
#                 break
#     if flag == True:
#         print(str(i))
# print('200以内质数的和为：' + str(sum))

# a=1
# b=1
# n=0
# for i in range(98):
#     n=a+b
#     print(str(n))
#     a=b
#     b=n

# def fb(i,a=1,b=1,n=0):
#     for i in range(i):
#         n = a + b
#         print(str(n))
#         a = b
#         b = n
#
# fb(5)

# 斐波拉契数列尾递归方法
def fb(i):
    if(i<2):
        return i
    else:
        return (fb(i-1)+fb(i-2))

number = int(input('请所求的斐波拉契数列的项数：'))

# import math
# pai=math.pi
# def circular(r):
#     c=2*pai*r
#     s=pai*r*r
#     print('圆的周长是：'+str(c))
#     print('圆的面积是：'+str(s))
#
# circular(5)

# l=[1,2,5,9,7,3,4,6,10,78,45,64,61,23]
# def sort(l):
#     for i in range(14):
#         for j in range(i+1,14):
#             if l[i]>l[j]:
#                 temp=l[i]
#                 l[i]=l[j]
#                 l[j]=temp
#
# sort(l)
# print(l)


