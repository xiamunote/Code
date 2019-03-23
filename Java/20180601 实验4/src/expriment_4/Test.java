package expriment_4;

public class Test
{
	public static void main(String[] args)
	{
		TwoDimensionalShape Shapes[]= {new Rectangle(3, 4),new Trinangle(3, 4, 5),new Circular(3)};
		for(TwoDimensionalShape temp:Shapes)
		{
			temp.printShapeInfo();
			System.out.println("面积："+temp.getArea()+",周长："+temp.getCircumference());
		}
	}
}