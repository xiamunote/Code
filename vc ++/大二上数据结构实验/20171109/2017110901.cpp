#include<iostream>
#include<fstream>
#include"Graph.h"
using namespace std; 
template<class T>
void Display(const Graph<T>& g,PathData* E,int ne)
{
	T v1,v2;
	for(int i=ne-1;i>1;i--)
	{
		g.FindNode(v1,E[i].start);
		g.FindNode(v2,E[i].dest);
		cout<<'('<<v1<<','<<v2<<','<<E[i].cost<<')'<<endl;
	}
}

int main()
{
	Graph<char> G;
	G.ReadGraph("D:\\graphin.txt");
	cout<<G;
	PathData *E=new PathData[G.SizeV()-1];
	if(G.Prim('A',E,G.SizeV()-1))
	{
		cout<<"Prim:\n";
		Display(G,E,G.SizeV()-1);
	}
	return(0);
}
