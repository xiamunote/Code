package suibi;

public class Client
{
	public static void main(String[] args)
	{
//		WeeklyLog log_previous,log_new;
		Weekly week_previous,week_new;
		
//		log_previous = new WeeklyLog();
		week_previous = new Weekly();
		
		Attachment attachment = new Attachment();
//		log_previous.setAttachment(attachment);
		week_previous.setAttachment(attachment);
		
//		log_new = log_previous.clone();
		try
		{
			week_new = week_previous.deepClone();
		}
		catch (Exception e) {
//			e.printStackTrace();
			System.err.println("���¡ʧ�ܣ�");
			week_new =null;
		}
		
//		System.out.println("ǳ��¡�ܱ��Ƿ���ͬ��" + (log_previous == log_new));
//		System.out.println("ǳ��¡�����Ƿ���ͬ��" + (log_previous.getAttachment() == log_new.getAttachment()));
		
		System.out.println("���¡�ܱ��Ƿ���ͬ��" + (week_previous == week_new));
		System.out.println("���¡�����Ƿ���ͬ��" + (week_previous.getAttachment() == week_new.getAttachment()));
	}
}
