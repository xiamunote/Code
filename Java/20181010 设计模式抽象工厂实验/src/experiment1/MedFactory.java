package experiment1;

public class MedFactory implements IAutoFactory
{

	@Override
	public ISport creatSport()
	{
		// TODO �Զ����ɵķ������
		return new MedSport();
	}

	@Override
	public ISUV creatSUV()
	{
		// TODO �Զ����ɵķ������
		return new MedSUV();
	}

}
