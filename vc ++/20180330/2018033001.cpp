#include<stdio.h>
#include<stdlib.h>
int main()
{
	int i,j,x,n,m;
	int s=1;
	scanf("%d",&m);
	int *a=NULL;
	a=(int *)malloc(sizeof(int)*m);
	for(i=0;i<m;i++)
	{
		scanf("%d",&a[i]);
	}
	for(i=0;i<m;i++)
	{
		for(j=1;j<=a[i];j++)
			s=s*j;
		while(s%10==0)
		{
			x=x+1;
			s=s/10;
		}
		printf("%d\n",x);
	}
	return 0;
}