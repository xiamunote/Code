#include<iostream.h>
#include<stdlib.h>
#include"Graph.h"

template<class T>
void Display(const Graph<T>& G,double *D,int *P,int n)
{
	T v;
	int parent,i,j,*stack=new int[n],size;
	for(i=0;i<n;i++)
		if(D[j])
		{
			cout<<D[j]<<": ";
			size=0;
			stack[size++]=i;
			parent=P[i];
			while(parent!=-1)
			{
				stack[size++]=parent;
				parent=P[parent];
			}
			for(j=size-1;j>-1;j--)
			{
				G.FindNode(v,stack[j]);
				cout<<v;
				if(j>0)
					cout<<"->";
			}
			cout<<endl;
		}
		delete[]stack;
}

int main()
{
	Graph<char> G;
	G.ReadGraph("D:\\graphin.txt");
	cout<<G;
	double D[20];
	int P[20];
	if(G.Dijkstra('A',D,P,G.SizeV()))
	{
		cout<<"Dijkstra:\n";
		Display(G,D,P,G.SizeV());
	}
	return(0);
}