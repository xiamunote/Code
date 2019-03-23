package expriment_4;

public class Circular extends TwoDimensionalShape implements Printable
{
	double radius;
	double area, circumference;

	Circular(double radius)
	{
		this.radius = radius;
	}

	public double getArea()
	{
		area = Math.PI * radius * radius;
		return area;
	}

	public double getCircumference()
	{
		circumference = Math.PI * radius * 2;
		return circumference;
	}

	public String toString()
	{
		String graphicInformation="°ë¾¶£º"+radius;
		return graphicInformation;
	}

	public void printShapeInfo()
	{
		Class circular=Circular.class;
		System.out.println("This is a " +circular.getSimpleName());
		System.out.println(this.toString());
	}
}
