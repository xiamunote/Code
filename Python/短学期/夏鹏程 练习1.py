# name=input('请输入学生的姓名：')
# age=input('请输入学生的年龄：')
# sex=input('请输入学生的性别：')
# score=input('请输入学生的分数：')
# judge=input('请输入学生是否为大数据方向：')
# print('输出学生信息')
# print('姓名：' + name + ','+'年龄' + age +',' + '性别：' + sex + ',' + '分数：' + score + ',' + '是否为大数据方向：' + judge )
# java=input('请输入java分数：')
# python=input('请输入python分数：')
# zongfen=int(java)+int(python)
# score=str(zongfen)
# print('输出学生信息')
# print('姓名：' + name + ','+'年龄' + age +',' + '性别：' + sex + ',' + '分数：' + score + ',' + '是否为大数据方向：' + judge )
# print('姓名：' + name , '年龄' + age , '性别：' + sex , '分数：' + score , '是否为大数据方向：' + judge ,sep='\t' )

# setLoginName='夏鹏程'
# setPassWord='123456'
# loginName=input('请输入用户名：')
# if setLoginName==loginName :
#     passWord=input('请输入密码：')
#     if setPassWord==passWord :
#         print('登录成功！')
#     else :
#         print('密码错误！')
# else :
#     print('用户名错误！')

# number=input('请输入第一个数字：')
# sum=0.0
# number=float(number)
# if number%2==0 :
#     sum=sum+float(number)
# number=input('请输入第二个数字：')
# number=float(number)
# if number%2==0 :
#     sum=sum+float(number)
# number=input('请输入第三个数字：')
# number=float(number)
# if number%2==0 :
#     sum=sum+float(number)
# number=input('请输入第四个数字：')
# number=float(number)
# if number%2==0 :
#     sum=sum+float(number)
# number=input('请输入第五个数字：')
# number=float(number)
# if number%2==0 :
#     sum=sum+float(number)
# print('整数和为：'+str(sum) )

i=0
sum=0
while i<10 :
    number=input('请输入第'+str(i+1)+ '整数：')
    number=int(number)
    if number%2==0 :
        sum=sum+number
    i=i+1
print('偶数和为：'+str(sum))
