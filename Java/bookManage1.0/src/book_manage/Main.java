package book_manage;
import java.util.*;
public class Main
{
	static ArrayList users = new ArrayList();	//�û�����
	static ArrayList books = new ArrayList();	//�鼮����
	static int m = 0;	//��¼�鼮���
	static int i = 0;	//��¼�û����
	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		User user = new User();
		Book book = new Book();
		Scanner in = new Scanner(System.in);
		System.out.println("1����¼");
		System.out.println("2��ע��");
		System.out.println("3���˳�");
		System.out.println("��ѡ�������ţ� ");
		int j = in.nextInt();	//��¼��¼����������
		int k = 1;		//��¼�鼮�������������
		boolean judge = false;	//��¼�鼮��������Ƿ񷵻ط���
		while(j != 3)
		{
			if(j == 1)
			{
				user.login();
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
				System.out.println("1����¼");
				System.out.println("2��ע��");
				System.out.println("3���˳�");
				System.out.println("��ѡ�������ţ� ");
				j = in.nextInt();	
			}
		}
		System.exit(0);
	}

}
