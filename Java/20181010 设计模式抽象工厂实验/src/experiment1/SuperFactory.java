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
		// TODO �Զ����ɵķ������
		return new SuperSUV();
	}

}
