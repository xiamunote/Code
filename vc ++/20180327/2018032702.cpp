#include<stdio.h>
int main()
{
	int x,y,z,m,i=0;
	scanf("%d",&m);
	int a[m],b[m],c[m];
	for(x=1;x<30;x++)
	{
		for(y=1;y<75;y++)
		{
			for(z=1;z<100;z++)
			{
				if(5*x+2*y+z==150&&x+y+z==100)
				{
					a[i]=x;
					b[i]=y;
					c[i]=z;
					i++;
				}
				if(i>=m)
					break;
			}
			if(i>=m)
					break;
		}
		if(i>=m)
					break;
	}
	for(i=0;i<m;i++)
	{
		printf("%d %d %d\n",a[i],b[i],c[i]);
	}
	return 0;
}
