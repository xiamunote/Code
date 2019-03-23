package experiment_3;

public class Zues 
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
	public int getHP()		//公有方法,获取宙斯HP
	{
		int hp;
		hp=getter();
		return hp;
	}
	Zues()		//空参数宙斯构造方法
	{
		setter(1000);	//默认宙斯HP为1000
	}
	Zues(int HP)	//带参数宙斯构造方法
	{
		setter(HP);
	}
	public void attack(Titan T)
	{
		int max=70;
		int min=0;
		int RHP = min + (int)((max-min)*(Math.random()));	//随机产生0-70的整数伤害
		T.HP=T.HP-RHP;
		System.out.println("宙斯攻击泰坦，产生" + RHP + "点伤害，泰坦当前HP为" + T.HP);
	}
}
