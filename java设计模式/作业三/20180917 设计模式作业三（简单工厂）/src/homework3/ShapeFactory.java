package homework3;

public class ShapeFactory 
{
	public static Shape getShape (String type) throws MyException
	{
		Shape shape =null;
		if(type.equalsIgnoreCase("circle"))
		{
			shape = new CircleShape();
			System.out.println("��ʼ������Բ�Σ�");
		}
		else if(type.equalsIgnoreCase("rectangle"))
		{
			shape = new RectangleShape();
			System.out.println("��ʼ�����þ��Σ�");
		}
		else if(type.equalsIgnoreCase("triangle"))
		{
			shape = new TriangleShape();
			System.out.println("��ʼ�����������Σ�");
		}
		else
		{
			//�׳��쳣
			throw new MyException("�˹���ֻ�ܴ���Բ�Ρ����λ������ζ���");
		}
		return shape;
	}
}
