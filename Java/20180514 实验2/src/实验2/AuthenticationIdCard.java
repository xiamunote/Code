package ʵ��2;

import java.util.Scanner;

public class AuthenticationIdCard 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};		//��¼ÿ���µ���������������
		System.out.println("������18λ���֤�ţ�");
		Scanner in =new Scanner(System.in);
		String Id = in.nextLine();		//�Ӽ��̶�ȡ���룬�����н���
		if(Id.length()==0)		//�ж��ַ����Ƿ�Ϊ��
		{
			System.out.println("�����֤��Ϊ�գ�");
			return ;
		}
		if(Id.length()!=18)		//�ж��ַ��������Ƿ�Ϊ18
		{
			System.out.println("�����֤�Ų���18λ���֤�ţ�");
			return ;
		}
		for(int i=0;i<17;i++)
		{
			char a=Id.charAt(i);		//ȡ�±�Ϊi���ַ�����ת��Ϊ�ַ�
			if(a<48 || a>57) 	//����ASICII���ж�ǰ17λ�Ƿ�Ϊ���֣�0����9��ASICII��Ϊ48����57
			{
				System.out.print("�����֤��");
				System.out.print(i+1);
				System.out.println("λ�������֣�");
				return ;
			}	
		}
		char b=Id.charAt(17);
		if(b>=48&&b<=57 || b=='X') 	//�жϵ�18λ�Ƿ�Ϊ���ֻ�X
		{
			int year=0;
			for(int i=6;i<10;i++)
			{
				year=year*10+Integer.parseInt(Id.substring(i, i+1));	//��ȡ���
		//Integer.parseInt(Id.substring(i, i+1))ȡ[i,i+1)(ʵ�����ǵ�i��)�ַ���ת��Ϊ����
			}
			if(year>=1900&&year<=2018)		//�ж�����Ƿ�Ϸ���1900����2018��
			{
				int month=0;
				for(int i=10;i<12;i++)
				{
					month=month*10+Integer.parseInt(Id.substring(i, i+1));	//��ȡ�·�
				}
				if(month>=1&&month<=12)		//�ж��·��Ƿ�Ϸ�
				{
					int day =0;
					for(int i=12;i<14;i++)
					{
						day=day*10+Integer.parseInt(Id.substring(i, i+1));	//��ȡ����
					}
					if(day>0&&day<=days[month])		//���ݵ�ǰ�·������ж������Ƿ�Ϸ�
					{
						System.out.println("�����֤��������ȷ��");
					}
					else
					{
						System.out.println("�����֤�ŵ������������");
						return ;
					}
				}
				else
				{
					System.out.println("�����֤�ŵ��·��������");
					return ;
				}
			}
			else
			{
				System.out.println("�����֤�ŵ�����������");
				return ;
			}
		}
		else 
		{
			System.out.println("�����֤�ŵ�18λ�������ֻ�X��");
			return ;
		}		
	}
}
