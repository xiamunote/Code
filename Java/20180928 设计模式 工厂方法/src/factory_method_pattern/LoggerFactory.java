package factory_method_pattern;

public interface LoggerFactory
{
	//日志记录器工厂接口，充当抽象产品角色
	public Logger createLogger();	//抽象工厂方法
}
