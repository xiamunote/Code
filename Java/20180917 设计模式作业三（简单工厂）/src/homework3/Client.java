package homework3;


public class Client
{
	public static void main(String args[])
	{
		Shape shape;
		String test[] = {"circle","rectangle","triangle","other"};
		for (String temp :test)
		{
			try {
				shape = ShapeFactory.getShape(temp);
				shape.draw();
				shape.erase();
				}
			catch (MyException e) 
			{
		
			}
		}
		
	}

}
