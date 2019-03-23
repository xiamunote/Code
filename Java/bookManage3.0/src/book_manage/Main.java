package book_manage;
import java.util.*;
public class Main
{
	static ArrayList<User> users = new ArrayList();	//用户数组
	static ArrayList<Book> books = new ArrayList();	//书籍数组
	static int m = 0;	//记录书籍编号
	static int i = 0;	//记录用户编号
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		System.out.println("1、登录");
		System.out.println("2、注册");
		System.out.println("其他数字退出");
		System.out.println("请选择操作编号： ");
		MyInput input = new MyInput();		//自定义输入类
		int j = input.inputInt();	//记录登录界面操作编号
		int k = 1;		//记录书籍管理界面操作编号
		while(j == 1 || j == 2)
		{
			if(j == 1)
			{
				User user = new User();
				user.login();
				boolean judge = false;	//记录书籍管理界面是否返回
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
					k = input.inputInt();
					Book book = new Book();
					switch(k)
					{
					case 1:
						book.addBook();
						break;
					case 2:
						book.showBookByType();
						break;
					case 3:
						book.showBook();
						break;
					case 4:
						book.updateBookByNumber();
						break;
					case 5:
						book.delateBookByNumber();
						break;
					case 6:
						judge = true;
						System.out.println("1、登录");
						System.out.println("2、注册");
						System.out.println("其他数字退出");
						System.out.println("请选择操作编号： ");
						j = input.inputInt();
						break;
					default :
						System.exit(0);	
					}
				}
			}
			if( j == 2)
			{
				User user = new User();
				users.add(user.userRegist());
				i = i + 1;
				System.out.println("1、登录");
				System.out.println("2、注册");
				System.out.println("其他数字退出");
				System.out.println("请选择操作编号： ");
				j = input.inputInt();	
			}
		}
		System.out.println("程序退出！");
		System.exit(0);
	}

}
