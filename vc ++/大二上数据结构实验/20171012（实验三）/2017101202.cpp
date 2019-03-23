//实验三 把二叉树的顺序存储转化为链式存储的递归算法（写实验报告）
#include<iostream.h>
#include"BTNodeLib.h"
//#include"BTNode.h"
//#include"Queue.h"
//#include"Vector.h"
#include"list.h"

template<class T>
BTNode<T>* MakeLinked(const Vector<T>& L,int size,int pos)
{
	if(pos>=size||L[pos]==T())
		return(NULL);
	BTNode<T> *left=MakeLinked(L,size,2*pos+1);
	BTNode<T> *right=MakeLinked(L,size,2*pos+2);
	BTNode<T> *t=GetBTNode(L[pos],left,right);
	return(t);
}

template<class T>
BTNode<T>* CopyTree(const BTNode<T> *t)
{
	if(!t)
		return(NULL);
	BTNode<T> *l=CopyTree(t->left);
	BTNode<T> *r=CopyTree(t->right);
	return(GetBTNode(t->data,l,r));
}

int main()
{
	Vector<char> L;
	char a[15]={'A','B','C','\0','D','\0','E','\0','\0','F'};
	for(int i=0;i<10;i++)
		L.Push_back(a[i]);
	BTNode<char>* t=MakeLinked(L,L.Size(),0);
	BTNode<char>* t1=CopyTree(t);
	PrintBTree(t1,40);
	return 0;

}
