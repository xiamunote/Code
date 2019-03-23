package expriment_4;

public class Rectangle extends TwoDimensionalShape implements Printable
{
	double area,circumference;
	double length,width;
	Rectangle(double length,double width)
	{
		this.length=length;
		this.width=width;
	}
	public double getArea()
	{
		area=length*width;
		return area;
	}
	public double getCircumference()
	{
		circumference=2*(length+width);
		return circumference;
	}
	public String toString()
	{
		String graphicInformation="³¤£º"+length+",¿í£º"+width;
		return graphicInformation;
	}
	public void printShapeInfo()
	{
		Class rectangle=Rectangle.class;
		System.out.println("This is a " +rectangle.getSimpleName());
		System.out.println(this.toString());
	}
}
