#include<iostream.h>

int main()
{
	int c,n,i,j;
	cin>>c>>n;
	int *w=new int [n];
	for(i=0;i<n;i++)
	{
		cin>>w[i];
	}
	int *v=new int [n];
	for(i=0;i<n;i++)
	{
		cin>>v[i];
	}
	int **V=new int*[n+1];
	for(i=0;i<n+1;i++)
		V[i]=new int[c+1];
	for(i=0;i<=n;i++)
	{
		V[i][0]=0;
	}
	for(j=0;j<=c;j++)
		V[0][j]=0;
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=c;j++)
			if(j<w[i])
				V[i][j]=V[i-1][j];
			else 
			{
				if(V[i-1][j]<V[i-1][j-w[i]]+v[i])
					V[i][j]=V[i-1][j-w[i]]+v[i];
				else
					V[i][j]=V[i-1][j];
			}
	}
	cout<<V[n][c];
	for(i=0;i<n+1;i++)
		delete V[i];
	delete[] V;
	return 0;

}