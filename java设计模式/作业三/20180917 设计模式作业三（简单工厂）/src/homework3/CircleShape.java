package homework3;

public class CircleShape implements Shape
{
	public CircleShape()
	{
		System.out.println("创建圆形对象！");
	}
	public void draw()
	{
		System.out.println("绘制圆形！");
	}
	public void erase()
	{
		System.out.println("擦除圆形！");
	}
}
