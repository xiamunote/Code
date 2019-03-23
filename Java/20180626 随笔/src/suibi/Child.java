package suibi;

class Child extends Parent
{
	Child()
	{
		System.out.println("Child.");
	}

	public static void main(String[] args)
	{
		Child c = new Child();
	}
}

class Ancestor
{
	Ancestor()
	{
		System.out.println("Ancestor.");
	}
}

class Parent extends Ancestor
{
	Parent()
	{
		System.out.println("Parent.");
	}
}
