package book_manage;
import java.util.*;
public class Main
{
	static ArrayList<User> users = new ArrayList();	//�û�����
	static ArrayList<Book> books = new ArrayList();	//�鼮����
	static int m = 0;	//��¼�鼮���
	static int i = 0;	//��¼�û����
	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		System.out.println("1����¼");
		System.out.println("2��ע��");
		System.out.println("���������˳�");
		System.out.println("��ѡ�������ţ� ");
		MyInput input = new MyInput();		//�Զ���������
		int j = input.inputInt();	//��¼��¼����������
		int k = 1;		//��¼�鼮�������������
		while(j == 1 || j == 2)
		{
			if(j == 1)
			{
				User user = new User();
				user.login();
				boolean judge = false;	//��¼�鼮��������Ƿ񷵻�
				while(judge == false)
				{
					System.out.println("1.����鼮");
					System.out.println("2.�����鼮���Ͳ鿴�鼮");
					System.out.println("3.�鿴�����鼮��Ϣ");
					System.out.println("4.�����鼮��Ϣ");
					System.out.println("5.ɾ���鼮");
					System.out.println("6.����");
					System.out.println("���������˳�");
					System.out.println("��ѡ�������ţ�");
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
						System.out.println("1����¼");
						System.out.println("2��ע��");
						System.out.println("���������˳�");
						System.out.println("��ѡ�������ţ� ");
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
				System.out.println("1����¼");
				System.out.println("2��ע��");
				System.out.println("���������˳�");
				System.out.println("��ѡ�������ţ� ");
				j = input.inputInt();	
			}
		}
		System.out.println("�����˳���");
		System.exit(0);
	}

}
