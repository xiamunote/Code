package factory_method_pattern;

public class FileLoggerFactory implements LoggerFactory
{
	//文件日志记录器工厂类，充当具体工厂角色
	public Logger createLogger()
	{
		Logger logger = new FileLogger();	//创建文件日志记录器对象
		//创建文件，代码省略
		return logger;
	}

}
