package book_manage;
import java.util.*;

public class Book
{
	Scanner in = new Scanner(System.in);
	MyInput input = new MyInput();
	String bookName;
	int bookType;
	double bookPrice;
	int bookNumber = 0; 
	Book()
	{
		bookNumber = 0;
		bookName = null;
		bookType = 0;
		bookPrice = 0.0;
	}
	public void addBook() 
	{
		System.out.println("请输入书籍名： ");
		bookName = in.nextLine();
		System.out.println("请输入书籍类型编号：1.文化教育||2.自然科学||3.经典著作||其他整数.其他: ");
		bookType = input.inputInt();
		System.out.println("请输入书籍价格： ");
		bookPrice = input.inputDouble();
		Main.m = Main.m + 1;
		bookNumber = Main.m;
		Main.books.add(this);
		System.out.println("书籍添加成功！");
	}
	
	public void showBookByType()
	{
		System.out.println("请输入书籍类型编号：1.文化教育||2.自然科学||3.经典著作||其他整数.其他: ");
		int temp = input.inputInt();
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			if(temp == book.bookType)
			{
				System.out.println("书籍编号：" + book.bookNumber);
				System.out.println("书籍名：" + book.bookName);
				switch(book.bookType)
				{
				case 1:
					System.out.println("书籍类型：文化教育");
					break;
				case 2:
					System.out.println("书籍类型：自然科学");
					break;
				case 3:
					System.out.println("书籍类型：经典著作");
					break;
				default :
					System.out.println("书籍类型：其他");
					break;
				}
				System.out.println("书籍价格：" + book.bookPrice);
			}
		}
	}
	
	public void showBook()
	{
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			System.out.println("书籍编号：" + book.bookNumber);
			System.out.println("书籍名：" + book.bookName);
			switch(book.bookType)
			{
			case 1:
				System.out.println("书籍类型：文化教育");
				break;
			case 2:
				System.out.println("书籍类型：自然科学");
				break;
			case 3:
				System.out.println("书籍类型：经典著作");
				break;
			default :
				System.out.println("书籍类型：其他");
				break;
			}
			System.out.println("书籍价格：" + book.bookPrice);
		}
	}
	
	public void updateBookByNumber()
	{
		System.out.println("请输入要更新的书籍编号：");
		int temp = input.inputInt();
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			if(temp == book.bookNumber)
			{
				System.out.println("请输入更新后书籍名： ");
				bookName = in.nextLine();
				System.out.println("请输入更新后书籍类型编号：1.文化教育||2.自然科学||3.经典著作||其他整数.其他: ");
				bookType = input.inputInt();
				System.out.println("请输入更新后书籍价格： ");
				bookPrice = input.inputDouble();
				bookNumber = temp;
				Main.books.remove(k);
				Main.books.add(k,this);
				System.out.println("书籍修改成功！");
			}
		}
	}
	
	public void delateBookByNumber()
	{
		MyInput input = new MyInput();
		System.out.println("请输入要删除的书籍编号：");
		int temp = input.inputInt();
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			if(temp == book.bookNumber)
			{
				Main.books.remove(k);
			}
		}
	}
}
