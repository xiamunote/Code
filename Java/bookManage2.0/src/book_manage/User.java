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
	
	public User userRegist() 
	{
		System.out.println("�������û����� ");
		userName = in.nextLine();
		System.out.println("���������룺 ");
		password = in.nextLine();
		System.out.println("���������䣺 ");
		email = in.nextLine();
		Main.i = Main.i + 1;
		userNumber = Main.i;
		System.out.println("ע��ɹ���");
		return this;
	}
	
	public void login()
	{
		Scanner in = new Scanner(System.in);
		boolean userFlag = false;
		boolean passwordFlag = false;
		for(int j = 0;j < 3; j++)
		{
			System.out.println("�������û����� ");
			String inputName = in.nextLine();
			System.out.println("���������룺");
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
							System.out.println("��¼�ɹ���");
							return;
						}
						else
						{
							int temp = 2-j;
							System.out.println("�û�������������㻹��"+ temp +"�λ��ᣡ");
							break;
						}
					}
				}
			}
			int temp = 2-j;
			System.out.println("�û�������������㻹��"+ temp +"�λ��ᣡ");
		}
		System.out.println("�����˳���");
		System.exit(0);
	}

}
