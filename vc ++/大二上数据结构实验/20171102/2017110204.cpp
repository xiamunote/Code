#include<iostream.h>
#include"Graph.h"
template<class Iterator>
void Display(Iterator first,Iterator last)
{
	for(;first!=last;first++)
		cout<<*first;
}
int main()
{
	Graph<char> G;
	G.ReadGraph("D:\\graphin1.txt");
	cout<<G;
	List<char> L;
	G.BFS(L,'A');
	Display(L.Begin(),L.End());
	cout<<endl;
	L.Clear();
	G.DFS(L,'A');
	Display(L.Begin(),L.End());
	cout<<endl;
	return(0);
}