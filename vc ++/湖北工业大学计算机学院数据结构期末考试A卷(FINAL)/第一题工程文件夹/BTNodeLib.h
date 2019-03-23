#ifndef BTNODELIB_H
#define BTNODELIB_H
#include"BTNode.h"
#include"Vector.h"

template<class T>//创建二叉链表节点
BTNode<T> * GetBTNode(const T& item,BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
	BTNode<T> *p;
	p=new BTNode<T>(item,lp,rp);	
	if(p==NULL)
	{
		cout<<"Memory allocation failure!"<<endl;	
		exit(1);
	}
	return p;
}

//把顺序存储结构转为链式存储结构 
template<class T>
BTNode<T>* MakeLinked(const Vector<T>& L, int size, int pos)
{//把二叉树的顺序存储转化为链式存储的递归算法
	if (pos >= size || L[pos] == T())
		return NULL;
	BTNode<T> *left = MakeLinked(L, size, 2 * pos + 1);
	BTNode<T> *right = _______________________;//（1）此处填空(2 分)
	BTNode<T> *t = ______________________;  //（2）此处填空(2 分)
	return t;
}


//前序遍历递归算法
template<class T>
void Preorder(const BTNode<T>* t)
{
	if (t == NULL)
		return;
	cout<<____________<<" ";//（3）此处填空(2 分)
	if (t->left)
		___________________; //（4）此处填空(2 分)
	if (t->right)
		___________________; //（5）此处填空(2 分)
}

#endif
