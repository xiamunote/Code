package experiment1;
import java.util.Scanner;

public class Client
{

	public static void main(String[] args)
	{
//		Scanner in = new Scanner(System.in);
//		System.out.println("���������ͣ�Sport or SUV��");
//		String type = in.nextLine();
//		System.out.println("���������ͣ�Super or Med��");
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
//				System.out.println("�����������");
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
//				System.out.println("�����������");
//			}
//		}
//		else
//		{
//			System.out.println("�����������");
//		}

		IAutoFactory factory;
		ISport sport;
		factory =(IAutoFactory)XMLUtil.getBean();
		sport = factory.creatSport();
		sport.ignotion();
		sport.startup();
	}

}
