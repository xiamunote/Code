package experiment_3;

public class ClashofTitans 
{
	public static void main(String[] args) 
	{
		Titan t=new Titan();	//����̩̹����
		Zues  z=new Zues();		//������˹����
		do
		{
			t.attack(z);	//̩̹������˹
			if(z.getHP()>0)
			{
				z.attack(t);	//��˹����̩̹
			}
			else
			{
				System.out.println("��˹HPΪ"+ z.HP + "���Ѿ�ʧ�ܣ�ʤ������̩̹!");
				return;
			}
		}while(t.getHP()>0 && z.getHP()>0);
		System.out.println("̩̹HPΪ"+ t.HP + "���Ѿ�ʧ�ܣ�ʤ��������˹!");
		return;
	}
}
