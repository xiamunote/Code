package book_manage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyInput
{
	Scanner in = new Scanner(System.in);
	public int inputInt() 
	{
		Boolean inFlag= false;
		int temp = 0;
		while(inFlag == false)
		{
			try {
				temp = in.nextInt();	//��¼��¼����������
				inFlag = true;
			}catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("ֻ����������,���������룡");
				in.next();
				continue;
			}
		}
		return temp;
	}
	
	public double inputDouble()
	{
		double temp =0.0;
		boolean inFlag =false;
		while(inFlag == false)
		{
			try {
				temp = in.nextDouble();	//��¼��¼����������
				inFlag = true;
			}catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("ֻ����������,���������룡");
				in.next();
				continue;
			}
		}
		return temp;
	}

}


