#include<iostream.h>
#include"Graph.h"
int main()
{
	Graph<char> G(20);
	G.ReadGraph("E:\\graphin.txt");
	cout<<G;
	G.DeleteV('C');
	cout<<"after deleting 'C':\n";
	cout<<G;
	return(0);
}