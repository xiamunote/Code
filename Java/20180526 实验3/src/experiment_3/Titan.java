package experiment_3;

public class Titan 
{
	int HP;
	private int getter()	//私有getter方法
	{
		return HP;
	}
	private void setter(int hp)		//私有setter方法
	{
		HP=hp;
	}
	public int getHP()		//公有方法，获取泰坦HP值
	{
		int hp;
		hp=getter();
		return hp;
	}
	Titan()		//空参数泰坦构造方法
	{
		setter(700);	//默认泰坦HP为700
	}
	Titan(int HP)	//带参数泰坦构造方法
	{
		setter(HP);
	}
	public void attack(Zues Z)
	{
		int max=100;
		int min=10;
		int RHP = min + (int)((max-min)*(Math.random()));	//随机产生10-100的整数伤害
		Z.HP=Z.HP-RHP;
		System.out.println("泰坦攻击宙斯，产生" + RHP + "点伤害，宙斯当前HP为" + Z.HP);
	}
}
