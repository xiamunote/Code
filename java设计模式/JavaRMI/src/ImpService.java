public class ImpService extends java.rmi.server.UnicastRemoteObject implements InterfaceService 
{
	public ImpService() throws java.rmi.RemoteException 
	{
			super();//
	}
		//}
		/**
		* �ͻ��˽�Ҫ���õķ���ʾ��
		*/
	public Object service(Object obj) 
	{
	
		System.out.println("RMI�ͻ�������: "+obj);
		return System.currentTimeMillis()/1000 + ": "
		+ obj.toString();
	 }
}
