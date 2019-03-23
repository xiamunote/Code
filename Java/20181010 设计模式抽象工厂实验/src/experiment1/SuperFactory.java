package experiment1;

public class SuperFactory implements IAutoFactory
{

	@Override
	public ISport creatSport()
	{
		return new SuperSport();
	}

	@Override
	public ISUV creatSUV()
	{
		// TODO 自动生成的方法存根
		return new SuperSUV();
	}

}
