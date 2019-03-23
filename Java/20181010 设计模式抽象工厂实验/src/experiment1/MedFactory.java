package experiment1;

public class MedFactory implements IAutoFactory
{

	@Override
	public ISport creatSport()
	{
		// TODO 自动生成的方法存根
		return new MedSport();
	}

	@Override
	public ISUV creatSUV()
	{
		// TODO 自动生成的方法存根
		return new MedSUV();
	}

}
