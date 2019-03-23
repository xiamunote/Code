#include<iostream.h>
#include"Graph.h"
int main()
{
	Graph<char> G;
	G.ReadGraph("D:\\graphin.txt");
	G.WriteGraph("D:\\out.txt");
	return(0);
}