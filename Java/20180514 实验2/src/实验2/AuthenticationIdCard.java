package 实验2;

import java.util.Scanner;

public class AuthenticationIdCard 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};		//记录每个月的天数，不分闰年
		System.out.println("请输入18位身份证号：");
		Scanner in =new Scanner(System.in);
		String Id = in.nextLine();		//从键盘读取输入，按换行结束
		if(Id.length()==0)		//判断字符串是否为空
		{
			System.out.println("此身份证号为空！");
			return ;
		}
		if(Id.length()!=18)		//判断字符串长度是否为18
		{
			System.out.println("此身份证号不是18位身份证号！");
			return ;
		}
		for(int i=0;i<17;i++)
		{
			char a=Id.charAt(i);		//取下标为i的字符串并转化为字符
			if(a<48 || a>57) 	//利用ASICII码判断前17位是否为数字，0——9的ASICII码为48——57
			{
				System.out.print("此身份证第");
				System.out.print(i+1);
				System.out.println("位不是数字！");
				return ;
			}	
		}
		char b=Id.charAt(17);
		if(b>=48&&b<=57 || b=='X') 	//判断第18位是否为数字或X
		{
			int year=0;
			for(int i=6;i<10;i++)
			{
				year=year*10+Integer.parseInt(Id.substring(i, i+1));	//读取年份
		//Integer.parseInt(Id.substring(i, i+1))取[i,i+1)(实际上是第i个)字符并转化为整数
			}
			if(year>=1900&&year<=2018)		//判断年份是否合法（1900——2018）
			{
				int month=0;
				for(int i=10;i<12;i++)
				{
					month=month*10+Integer.parseInt(Id.substring(i, i+1));	//读取月份
				}
				if(month>=1&&month<=12)		//判断月份是否合法
				{
					int day =0;
					for(int i=12;i<14;i++)
					{
						day=day*10+Integer.parseInt(Id.substring(i, i+1));	//读取日期
					}
					if(day>0&&day<=days[month])		//根据当前月份天数判断日期是否合法
					{
						System.out.println("此身份证号输入正确！");
					}
					else
					{
						System.out.println("此身份证号的日期输入错误！");
						return ;
					}
				}
				else
				{
					System.out.println("此身份证号的月份输入错误！");
					return ;
				}
			}
			else
			{
				System.out.println("此身份证号的年份输入错误！");
				return ;
			}
		}
		else 
		{
			System.out.println("此身份证号第18位不是数字或X！");
			return ;
		}		
	}
}
