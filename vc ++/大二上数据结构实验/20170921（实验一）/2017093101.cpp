//ʵ��һ  ����5.1  ��α���
//ʵ��� ��һ��Preorder,SimPreorder
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
//ʵ��һ  ����5.1  ��α���

template<class T>
void Preorder(const BTNode<T>* t)    //ʵ��� ��һ��Preorder
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
void SimPreorder(const BTNode<T>* t)		//ʵ��� ��һ��SimPreorder
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
	Level(ap);				//ʵ��һ  ����5.1  ��α���
	cout<<endl;
	Preorder(ap);			//ʵ��� ��һ��Preorder
	cout<<endl;
	SimPreorder(ap);		//ʵ��� ��һ��SimPreorder
	cout<<endl;
	return(0);
}