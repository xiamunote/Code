package book_manage;

import java.util.*;

public class User
{
	String userName;
	String password;
	String email;
	int userNumber;
	Scanner in = new Scanner(System.in);
	User()
	{
		userName = null;
		password =null;
		email = null;
		userNumber = 0;
	}
	
	public void userRegist() 
	{
		System.out.println("请输入用户名： ");
		userName = in.nextLine();
		System.out.println("请输入密码： ");
		password = in.nextLine();
		System.out.println("请输入邮箱： ");
		email = in.nextLine();
		Main.i = Main.i + 1;
		userNumber = Main.i;
		Main.users.add(this);
//		Main.users.put(userNumber, this);
		System.out.println("注册成功！");
	}
	
	public void login()
	{
		Scanner in = new Scanner(System.in);
		boolean userFlag = false;
		boolean passwordFlag = false;
		for(int j = 0;j < 3; j++)
		{
			if(j == 3)
			{
				System.out.println("登录失败！");
				System.exit(0);
			}
			System.out.println("请输入用户名： ");
			String inputName = in.nextLine();
			System.out.println("请输入密码：");
			String inputPassword = in.nextLine();
			for(int k = 0;k < Main.users.size();k++)
			{
				User inputUser = (User)Main.users.get(k);
//				System.out.println(inputUser.userName +  inputUser.password);
//				System.out.println(inputName +  inputPassword);
				if(inputName.equals(inputUser.userName))
				{
					userFlag =true;
					if(userFlag == true)
					{
						passwordFlag = inputPassword.equals(inputUser.password);
						if(passwordFlag == true)
						{
							System.out.println("登录成功！");
							return;
						}
						else
						{
							int temp = 2-j;
							System.out.println("密码错误，你还有"+ temp +"次机会！");
							break;
						}
					}
				}
				else
				{
					int temp = 2-j;
					System.out.println("用户名不存在，你还有"+ temp +"次机会！");
					break;
				}
			}

		}
	}

}
