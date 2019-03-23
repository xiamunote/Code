package suibi;

public class WeeklyLog implements Cloneable
{
	private Attachment attachment;
	private String name = "b";
	public int n = 0;
	public void setAttachment(Attachment attachment)
	{
		this.attachment = attachment;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setN(int n)
	{
		this.n = n;
	}
	public Attachment getAttachment()
	{
		return this.attachment;
	}
	public String getName()
	{
		return this.name;
	}
	public int getN()
	{
		return this.n;
	}
	public WeeklyLog clone()	//ʹ��clone��������ǳ��¡
	{
		Object obj = null;
		try
		{
			obj = super.clone();
			return (WeeklyLog)obj;
		}
		catch (CloneNotSupportedException e) {
			System.out.println("��֧�ֵĸ��ƣ�");
			return null;
		}
	}
}
