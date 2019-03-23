package experiment_3;

public class ClashofTitans 
{
	public static void main(String[] args) 
	{
		Titan t=new Titan();	//创建泰坦对象
		Zues  z=new Zues();		//创建宙斯对象
		do
		{
			t.attack(z);	//泰坦攻击宙斯
			if(z.getHP()>0)
			{
				z.attack(t);	//宙斯攻击泰坦
			}
			else
			{
				System.out.println("宙斯HP为"+ z.HP + "，已经失败，胜利者是泰坦!");
				return;
			}
		}while(t.getHP()>0 && z.getHP()>0);
		System.out.println("泰坦HP为"+ t.HP + "，已经失败，胜利者是宙斯!");
		return;
	}
}
