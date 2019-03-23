package factory_method_pattern;

public class DatabaseLoggerFactory implements LoggerFactory
{
	//���ݿ���־��¼�������࣬�䵱���幤����ɫ
	public Logger createLogger()
	{
		//�������ݿ⣬����ʡ��
		Logger logger = new DatabaseLogger();	//�������ݿ���־��¼������
		//��ʼ�����ݿ���־��¼��������ʡ��
		return logger;
	}

}
