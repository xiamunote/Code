#include<iostream.h>
#include"BTNode.h"
#include"BTNodeLib.h"
#include"Vector.h"

int main()
{
	//二叉树由顺序存储转化为链式存储
	char a[15] = { 'A','B','C','D','\0','E','F','\0','\0','\0','\0','G' };//结点的完全层次序列
	Vector<char> L;
	for (int i = 0; i<12; i++)
		L.Push_back(a[i]);
	BTNode<char>*at;
	at=_________________;	//（6）此处填空，生成二叉链表at (2分)
	cout<<"前序遍历序列为："<<endl;
	_______________;	//（7）此处填空，前序遍历（调用递归的实现）（2分）
	cout<<endl;

	return 0;
}
