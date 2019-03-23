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
		System.out.println("�������鼮���� ");
		bookName = in.nextLine();
		System.out.println("�������鼮���ͱ�ţ�1.�Ļ�����||2.��Ȼ��ѧ||3.��������||��������.����: ");
		bookType = input.inputInt();
		System.out.println("�������鼮�۸� ");
		bookPrice = input.inputDouble();
		Main.m = Main.m + 1;
		bookNumber = Main.m;
		Main.books.add(this);
		System.out.println("�鼮��ӳɹ���");
	}
	
	public void showBookByType()
	{
		System.out.println("�������鼮���ͱ�ţ�1.�Ļ�����||2.��Ȼ��ѧ||3.��������||��������.����: ");
		int temp = input.inputInt();
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			if(temp == book.bookType)
			{
				System.out.println("�鼮��ţ�" + book.bookNumber);
				System.out.println("�鼮����" + book.bookName);
				switch(book.bookType)
				{
				case 1:
					System.out.println("�鼮���ͣ��Ļ�����");
					break;
				case 2:
					System.out.println("�鼮���ͣ���Ȼ��ѧ");
					break;
				case 3:
					System.out.println("�鼮���ͣ���������");
					break;
				default :
					System.out.println("�鼮���ͣ�����");
					break;
				}
				System.out.println("�鼮�۸�" + book.bookPrice);
			}
		}
	}
	
	public void showBook()
	{
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			System.out.println("�鼮��ţ�" + book.bookNumber);
			System.out.println("�鼮����" + book.bookName);
			switch(book.bookType)
			{
			case 1:
				System.out.println("�鼮���ͣ��Ļ�����");
				break;
			case 2:
				System.out.println("�鼮���ͣ���Ȼ��ѧ");
				break;
			case 3:
				System.out.println("�鼮���ͣ���������");
				break;
			default :
				System.out.println("�鼮���ͣ�����");
				break;
			}
			System.out.println("�鼮�۸�" + book.bookPrice);
		}
	}
	
	public void updateBookByNumber()
	{
		System.out.println("������Ҫ���µ��鼮��ţ�");
		int temp = input.inputInt();
		for(int k = 0;k < Main.books.size();k++)
		{
			Book book = (Book)Main.books.get(k);
			if(temp == book.bookNumber)
			{
				System.out.println("��������º��鼮���� ");
				bookName = in.nextLine();
				System.out.println("��������º��鼮���ͱ�ţ�1.�Ļ�����||2.��Ȼ��ѧ||3.��������||��������.����: ");
				bookType = input.inputInt();
				System.out.println("��������º��鼮�۸� ");
				bookPrice = input.inputDouble();
				bookNumber = temp;
				Main.books.remove(k);
				Main.books.add(k,this);
				System.out.println("�鼮�޸ĳɹ���");
			}
		}
	}
	
	public void delateBookByNumber()
	{
		MyInput input = new MyInput();
		System.out.println("������Ҫɾ�����鼮��ţ�");
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
