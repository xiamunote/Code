//实验一  程序5.1  层次遍历
//实验二 第一节Preorder,SimPreorder
#include<iostream.h>
#include"BTNode.h"
#include"queue.h"
#include"stack.h"
template<class T>
BTNode<T> * GetBTNode(const T& item, BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
	BTNode<T> *p;
	p=new BTNode<T>(item,lp,rp);
	if(p==NULL)
	{
		cout<<"Menory allocation failure!"<<endl;
		exit(1);
	}
	return(p);
}

template<class T>
void Level(const BTNode<T>* t)
{
	if(t==NULL)
		return;
	Queue<const BTNode<T>*> Q;
	Q.Push(t);
	while(!Q.Empty())
	{
		t=Q.Pop();
		cout<<t->data;
		if(t->left)
			Q.Push(t->left);
		if(t->right)
			Q.Push(t->right);
	}
}
//实验一  程序5.1  层次遍历

template<class T>
void Preorder(const BTNode<T>* t)    //实验二 第一节Preorder
{
	if(t==NULL)
		return;
	cout<<t->data;
	if(t->left)
		Preorder(t->left);
	if(t->right)
		Preorder(t->right);
}

template <class T>
void SimPreorder(const BTNode<T>* t)		//实验二 第一节SimPreorder
{
	if(!t)
		return;
	Stack<const BTNode<T>*> S;
	while(t||!S.Empty())
		if(t)
		{
			cout<<t->data;
			if(t->right)
				S.Push(t->right);
			t=t->left;
		}
		else
			t=S.Pop();
}


int main()
{
	BTNode<char> *nullp=NULL;
	BTNode<char> *fp=GetBTNode('F');
	BTNode<char> *dp=GetBTNode('D',fp);
	BTNode<char> *bp=GetBTNode('B',nullp,dp);
	BTNode<char> *ep=GetBTNode('E');
	BTNode<char> *cp=GetBTNode('C',nullp,ep);
	BTNode<char> *ap=GetBTNode('A',bp,cp);
	Level(ap);				//实验一  程序5.1  层次遍历
	cout<<endl;
	Preorder(ap);			//实验二 第一节Preorder
	cout<<endl;
	SimPreorder(ap);		//实验二 第一节SimPreorder
	cout<<endl;
	return(0);
}