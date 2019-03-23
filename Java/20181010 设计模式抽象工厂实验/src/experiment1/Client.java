package experiment1;
import java.util.Scanner;

public class Client
{

	public static void main(String[] args)
	{
//		Scanner in = new Scanner(System.in);
//		System.out.println("请输入类型（Sport or SUV）");
//		String type = in.nextLine();
//		System.out.println("请输入类型（Super or Med）");
//		String level = in.nextLine();
//		IAutoFactory factory;
//		if(level.equals("Super"))
//		{
//			factory = new SuperFactory();
//			if(type.equals("Sport"))
//			{
//				ISport sport;
//				sport = factory.creatSport();
//				sport.ignotion();
//				sport.startup();
//			}
//			else if(type.equals("SUV"))
//			{
//				ISUV SUV;
//				SUV = factory.creatSUV();
//				SUV.ignotion();
//				SUV.startup();
//			}
//			else
//			{
//				System.out.println("类型输入错误！");
//			}
//		}
//		else if(level.equals("Med"))
//		{
//			factory = new MedFactory();
//			if(type == "Sport")
//			{
//				ISport sport;
//				sport = factory.creatSport();
//				sport.ignotion();
//				sport.startup();
//			}
//			else if(type == "SUV")
//			{
//				ISUV SUV;
//				SUV = factory.creatSUV();
//				SUV.ignotion();
//				SUV.startup();
//			}
//			else
//			{
//				System.out.println("类型输入错误！");
//			}
//		}
//		else
//		{
//			System.out.println("级别输入错误！");
//		}

		IAutoFactory factory;
		ISport sport;
		factory =(IAutoFactory)XMLUtil.getBean();
		sport = factory.creatSport();
		sport.ignotion();
		sport.startup();
	}

}
