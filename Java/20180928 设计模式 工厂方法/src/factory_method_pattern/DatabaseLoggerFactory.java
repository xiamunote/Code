package factory_method_pattern;

public class DatabaseLoggerFactory implements LoggerFactory
{
	//数据库日志记录器工厂类，充当具体工厂角色
	public Logger createLogger()
	{
		//连接数据库，代码省略
		Logger logger = new DatabaseLogger();	//创建数据库日志记录器对象
		//初始化数据库日志记录器，代码省略
		return logger;
	}

}
