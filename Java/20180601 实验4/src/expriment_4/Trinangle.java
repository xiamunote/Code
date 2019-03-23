package expriment_4;

public class Trinangle extends TwoDimensionalShape implements Printable 
{
	double base,hypotenus1,hypotenus2;
	double area,circumference;
	Trinangle(double base,double hypotenus1,double hypotenus2)
	{
		this.base=base;
		this.hypotenus1=hypotenus1;
		this.hypotenus2=hypotenus2;
	}
	public double getArea()
	{
		double p=(base+hypotenus1+hypotenus2)/2;
		area=Math.sqrt(p*(p-base)*(p-hypotenus1)*(p-hypotenus2));
		return area;
	}
	public double getCircumference()
	{
		circumference=base+hypotenus1+hypotenus2;
		return circumference;
	}
	public String toString()
	{
		String graphicInformation="底："+base+",第一条斜边："+hypotenus1+",第二条斜边："+hypotenus2;
		return graphicInformation;
	}
	public void printShapeInfo()
	{
		Class trinangle=Trinangle.class;
		System.out.println("This is a " +trinangle.getSimpleName());
		System.out.println(this.toString());
	}

}
