import java.rmi.*;
import java.rmi.registry.*;
/**
* ����RMI������,�����������
* @author ������
*/
public class StartRMIServer 
{
	/**��������*/
	public static void main(String[] args) 
	{
		int listerPort=9911; //����RMI��������9911�˿�
//		String serverIP="100.64.0.1";
		String serverIP="localhost"; //������IP
		String serviceObjName="service"; //Ҫ�����ķ����������
		try 
		{
			LocateRegistry.createRegistry(listerPort); //����RMI�����������˿�
			//ImpService.setLog(System.out); //������־����,��ӡ������̨
			ImpService remoteObj = new ImpService(); //���������Ķ���, �󶨷���
			Naming.rebind("rmi://"+serverIP+":"+listerPort+"/"+serviceObjName, remoteObj);
			System.out.println("RMI������"+serverIP+": "+listerPort+" ������Ϊ: "+serviceObjName);
		} 
		catch (Exception e) 
		{
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
