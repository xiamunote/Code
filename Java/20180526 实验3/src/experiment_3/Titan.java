package experiment_3;

public class Titan 
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
	public int getHP()		//���з�������ȡ̩̹HPֵ
	{
		int hp;
		hp=getter();
		return hp;
	}
	Titan()		//�ղ���̩̹���췽��
	{
		setter(700);	//Ĭ��̩̹HPΪ700
	}
	Titan(int HP)	//������̩̹���췽��
	{
		setter(HP);
	}
	public void attack(Zues Z)
	{
		int max=100;
		int min=10;
		int RHP = min + (int)((max-min)*(Math.random()));	//�������10-100�������˺�
		Z.HP=Z.HP-RHP;
		System.out.println("̩̹������˹������" + RHP + "���˺�����˹��ǰHPΪ" + Z.HP);
	}
}
