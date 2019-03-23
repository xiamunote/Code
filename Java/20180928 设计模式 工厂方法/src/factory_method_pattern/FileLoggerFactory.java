package factory_method_pattern;

public class FileLoggerFactory implements LoggerFactory
{
	//�ļ���־��¼�������࣬�䵱���幤����ɫ
	public Logger createLogger()
	{
		Logger logger = new FileLogger();	//�����ļ���־��¼������
		//�����ļ�������ʡ��
		return logger;
	}

}
