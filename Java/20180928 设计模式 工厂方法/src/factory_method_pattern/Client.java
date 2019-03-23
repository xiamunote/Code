package factory_method_pattern;

public class Client
{

	public static void main(String[] args)
	{
		LoggerFactory factory;
		Logger logger;
//		factory = new FileLoggerFactory();	//�����������ļ��ͷ������ʵ��
		factory = (LoggerFactory)XMLUtil.getBean();
		//���������ļ��ͷ�����ƴ����࣬getBean�ķ�������ΪObject����Ҫ����ǿ������ת��
		logger = factory.createLogger();
		logger.writeLog();
		factory = new DatabaseLoggerFactory();	
		logger = factory.createLogger();
		logger.writeLog();
	}

}
