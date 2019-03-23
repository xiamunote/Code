import java.rmi.*;

/**
* RMI���ÿͻ���
* @author ������
*/
public class RmiClient 
{
	public static void main(String[] args) 
	{
		int listerPort=9911;//����RMI��������9911�˿�,1099��Ĭ�϶˿�
//		String serverIP="100.64.0.1";
		String serverIP="192.168.1.106";//������IP
		String serviceObjName="service";//Ҫ�����ķ����������
		try 
		{
			//���ҷ������ϵķ������
			InterfaceService stub = (InterfaceService)
			Naming.lookup("rmi://"+serverIP+":"+listerPort+"/"+serviceObjName);
			for(int i=0;i<10;i++)
			{
			//���ö���ķ��񷽷�
			Object response = stub.service("��ľ��˵��....."+i);
			System.out.println("RMI������Ӧ��:" + response.toString());
			Thread.sleep(1000);
			}
		} 
		catch (Exception e) 
		{
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		} 
	} 
}
