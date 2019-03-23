package homework3;

public class RectangleShape implements Shape
{
	public RectangleShape()
	{
		System.out.println("创建矩形对象！");
	}
	public void draw()
	{
		System.out.println("绘制矩形！");
	}
	public void erase()
	{
		System.out.println("擦除矩形！");
	}
}
