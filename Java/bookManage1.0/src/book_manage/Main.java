package book_manage;
import java.util.*;
public class Main
{
	static ArrayList users = new ArrayList();	//用户数组
	static ArrayList books = new ArrayList();	//书籍数组
	static int m = 0;	//记录书籍编号
	static int i = 0;	//记录用户编号
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		User user = new User();
		Book book = new Book();
		Scanner in = new Scanner(System.in);
		System.out.println("1、登录");
		System.out.println("2、注册");
		System.out.println("3、退出");
		System.out.println("请选择操作编号： ");
		int j = in.nextInt();	//记录登录界面操作编号
		int k = 1;		//记录书籍管理界面操作编号
		boolean judge = false;	//记录书籍管理界面是否返回返回
		while(j != 3)
		{
			if(j == 1)
			{
				user.login();
				while(judge == false)
				{
					System.out.println("1.添加书籍");
					System.out.println("2.根据书籍类型查看书籍");
					System.out.println("3.查看所有书籍信息");
					System.out.println("4.更新书籍信息");
					System.out.println("5.删除书籍");
					System.out.println("6.返回");
					System.out.println("其他数字退出");
					System.out.println("请选择操作编号：");
					k = in.nextInt();
					switch(k)
					{
					case 1:
						book.addBook();
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					default :
						System.exit(0);	
					}
				}
			}
			if( j == 2)
			{
				user.userRegist();
				i = i + 1;
				System.out.println("1、登录");
				System.out.println("2、注册");
				System.out.println("3、退出");
				System.out.println("请选择操作编号： ");
				j = in.nextInt();	
			}
		}
		System.exit(0);
	}

}
