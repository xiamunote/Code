package factory_method_pattern;

public class FileLogger implements Logger
{
	//文件日志记录器，充当具体产品角色
	public void writeLog()
	{
		System.out.println("文件日志记录.");

	}

}
