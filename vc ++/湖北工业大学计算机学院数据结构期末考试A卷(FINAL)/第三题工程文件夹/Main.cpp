#include<iostream.h>
#include"Graph.h"
#include"List.h"
#include"Display.h"
int main()
{
	Graph<char> G;	//����ͼ����
    _________________;//��6���˴���գ���ȡGraphin.txt
	cout<<G;
	cout<<endl;
	List<char> L;
	_________________; //(7)�˴���գ�������ȱ���          
	cout<<"BFS:";              
	Display(L.begin(),L.end()); 	
	cout<<endl;
	return 0;
}

