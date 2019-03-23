package factory_method_pattern;

public class Client
{

	public static void main(String[] args)
	{
		LoggerFactory factory;
		Logger logger;
//		factory = new FileLoggerFactory();	//可引入配置文件和反射机制实现
		factory = (LoggerFactory)XMLUtil.getBean();
		//引入配置文件和反射机制创建类，getBean的返回类型为Object，需要进行强制类型转换
		logger = factory.createLogger();
		logger.writeLog();
		factory = new DatabaseLoggerFactory();	
		logger = factory.createLogger();
		logger.writeLog();
	}

}
