//实验二 程序5.2  二叉链表的生成、垂直输出和层次遍历。
#include<iostream.h>
#include"BTNodeLib.h"
int main()
{
	Vector<char> L;
	char a[15]={'A','B','C','\0','D','\0','E','\0','\0','F'};
	for(int i=0;i<10;i++)
		L.Push_back(a[i]);
	BTNode<char>* t=MakeLinked(L);
	PrintBTree(t,40);
	Level(t);
	return(0);
}