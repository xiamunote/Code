#include<iostream.h>
#include"Graph.h"
#include"List.h"
#include"Display.h"
int main()
{
	Graph<char> G;	//创建图对象
    _________________;//（6）此处填空，读取Graphin.txt
	cout<<G;
	cout<<endl;
	List<char> L;
	_________________; //(7)此处填空，广度优先遍历          
	cout<<"BFS:";              
	Display(L.begin(),L.end()); 	
	cout<<endl;
	return 0;
}

