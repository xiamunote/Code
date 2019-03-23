
def user_regist(user,i):
    user_manage = {}    #'user_number': 0, 'user_name': 'null ', 'passworld': 'null', 'email': 'null'
    user_manage.setdefault('user_name','null ')
    user_manage['user_name'] = input('请输入用户名：')
    user_manage.setdefault('passworld', 'null ')
    user_manage['passworld'] = input('请输入密码：')
    user_manage.setdefault('email', 'null ')
    user_manage['email'] = input('请输入邮箱：')
    user.setdefault(i + 1, {})
    user[i] = user_manage
    print('注册成功！')


