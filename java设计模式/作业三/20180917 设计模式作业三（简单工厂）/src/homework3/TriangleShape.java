package homework3;

public class TriangleShape implements Shape
{
	public TriangleShape()
	{
		System.out.println("创建三角形对象！");
	}
	public void draw()
	{
		System.out.println("绘制三角形！");
	}
	public void erase()
	{
		System.out.println("擦除三角形！");
	}
}
