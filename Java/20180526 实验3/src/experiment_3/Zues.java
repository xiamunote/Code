package experiment_3;

public class Zues 
{
	int HP;
	private int getter()	//˽��getter����
	{
		return HP;
	}
	private void setter(int hp)		//˽��setter����
	{
		HP=hp;
	}
	public int getHP()		//���з���,��ȡ��˹HP
	{
		int hp;
		hp=getter();
		return hp;
	}
	Zues()		//�ղ�����˹���췽��
	{
		setter(1000);	//Ĭ����˹HPΪ1000
	}
	Zues(int HP)	//��������˹���췽��
	{
		setter(HP);
	}
	public void attack(Titan T)
	{
		int max=70;
		int min=0;
		int RHP = min + (int)((max-min)*(Math.random()));	//�������0-70�������˺�
		T.HP=T.HP-RHP;
		System.out.println("��˹����̩̹������" + RHP + "���˺���̩̹��ǰHPΪ" + T.HP);
	}
}
