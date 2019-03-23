#include<iostream.h>
#include"Graph.h"

template<class Iterator>
void Display(Iterator first,Iterator last)
{
	for(;first!=last;++first)
		cout<<*first<<' ';
	cout<<endl;
}

int main()
{
	Graph<char> G;
	G.ReadGraph("D:\\graphin.txt");
	cout<<G;
	List<char> L;
	G.TopSort(L);
	cout<<"TopSort:"<<endl;
	Display(L.Begin(),L.End());
	return(0);
}