package book_manage;
import java.util.*;

public class Book
{
	Scanner in = new Scanner(System.in);
	String bookName;
	String bookType;
	double bookPrice;
	int bookNumber = 0; 
//	Integer bookNumber = Integer.valueOf(0);
	Book()
	{
//		bookNumber = Integer.valueOf(0);
		bookNumber = 0;
		bookName = null;
		bookType = null;
		bookPrice = 0.0;
	}
	void addBook() 
	{
		System.out.println("请输入书籍名： ");
		bookName = in.nextLine();
		System.out.println("请输入书籍类型： ");
		bookType = in.nextLine();
		System.out.println("请输入书籍价格： ");
		bookPrice = in.nextDouble();
//		Main.m = Main.m + Integer.valueOf(1);
		Main.m = Main.m + 1;
		bookNumber = Main.m;
		Main.books.add(this);
//		Main.books.put(bookNumber,this);
		System.out.println("书籍添加成功！");
	}
	
	
}
