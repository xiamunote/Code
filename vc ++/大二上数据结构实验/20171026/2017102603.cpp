//程序7.3 八皇后。（实验报告5）
#include<conio.h>//getch
#include<stdlib.h>//exit
#include<iostream.h>
void Queuen(int y=0);
void Display(const int *p,int n);
int main()
{
	Queuen();
	return(0);
}
void Queuen(int y)
{
	static int A[22],B[22],C[22],Y[8];
	if(y<0||y>8)
	{
		cout<<"y illeagal";
		exit(1);
	}
	if(y==8)
	{
		Display(Y,8);
		return;
	}
	for(int x=0;x<8;x++)
		if(!A[x+7]&&!B[x+y+7]&&C[x-y+7])
		{
			Y[y]=x;
			A[x+7]=B[x+y+7]=C[x-y+7]=1;
			Queuen(y+1);
			A[x+7]=B[x+y+7]=C[x-y+7]=0;
		}
}
void Dislay(const int *p,int n)
{
	static int total=1;
	for(int y=0;y<n;y++)
	{
		if(y%8==0)
			cout<<total++<<endl;
		for(int x=0;x<8;x++)
			if(x!=p[y])
				cout<<" # ";
			else
				cout<<" @ ";
			cout<<endl;
	}
	cout<<"Press any key to see"<<endl;
	getch();
}