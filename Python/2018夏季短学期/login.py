def login(user,i):
    u_flage = False
    p_flage = False
    for j in range(3):
        user_name = input('请输入你的用户名：')
        passworld = input('请输入你的密码：')
        for k in range(i):
            if user[k]['user_name'] == user_name:
                u_flage = True
                if user[k]['passworld'] == passworld:
                    p_flage = True
                    break
        if u_flage == True and p_flage == True:
            print('登录成功！')
            return
        else:
            print('用户名或密码错误，' + '你还有' + str(2-j) + '次机会')
    if j == 3:
        print('登录失败！')
        exit()


