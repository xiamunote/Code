#include<iostream.h>
int CommonOrder(char x[],int m,char y[],int n,char z[]);
int main()
{
	return 0;
}

int CommonOrder(char x[],int m,char y[],int n,char z[])
{
	int i,j,k;
	for(j=0;j<=n;j++)
		L[o][j]=0;
	for(i=0;i<=m;i++)
		L[i][0]=0;
	for(i=1;i<=m;i++)
		for(j=1;j<=n;j++)
			if(x[i]==y[j])
			{
				L[i][j]=L[i-1][j-1]+1;
				S[i][j]=1;
			}
			else
				if(L[i][j-1]>=L[i-1][j])
				{
					L[i][j]=L[i][j-1];
					S[i][j]=2;
				}
				else
				{
					L[i][j]=L[i-1][j];
					S[i][j]=3;
				}
				i=m;
				j=n;
				k=L[m][n];

}