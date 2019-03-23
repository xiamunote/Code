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
			System.err.println("深克隆失败！");
			week_new =null;
		}
		
//		System.out.println("浅克隆周报是否相同？" + (log_previous == log_new));
//		System.out.println("浅克隆附件是否相同？" + (log_previous.getAttachment() == log_new.getAttachment()));
		
		System.out.println("深克隆周报是否相同？" + (week_previous == week_new));
		System.out.println("深克隆附件是否相同？" + (week_previous.getAttachment() == week_new.getAttachment()));
	}
}
