package homework3;

public class ShapeFactory 
{
	public static Shape getShape (String type) throws MyException
	{
		Shape shape =null;
		if(type.equalsIgnoreCase("circle"))
		{
			shape = new CircleShape();
			System.out.println("初始化设置圆形！");
		}
		else if(type.equalsIgnoreCase("rectangle"))
		{
			shape = new RectangleShape();
			System.out.println("初始化设置矩形！");
		}
		else if(type.equalsIgnoreCase("triangle"))
		{
			shape = new TriangleShape();
			System.out.println("初始化设置三角形！");
		}
		else
		{
			//抛出异常
			throw new MyException("此工厂只能创建圆形、矩形或三角形对象！");
		}
		return shape;
	}
}
