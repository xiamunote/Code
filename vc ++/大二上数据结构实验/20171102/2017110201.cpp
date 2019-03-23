#include<iostream.h>
#include"Graph.h"
int main()
{
	Graph<char> G(20);
	cout<<"Input vertices and edges:\n";
	cin>>G;
	cout<<"Output adjacency list:\n";
	cout<<G;
	return(0);
}
