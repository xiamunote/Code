package factory_method_pattern;

public class DatabaseLogger implements Logger
{
	//数据库日志记录器，充当具体产品角色
	public void writeLog()
	{
		System.out.println("数据库日志记录.");
	}

}
