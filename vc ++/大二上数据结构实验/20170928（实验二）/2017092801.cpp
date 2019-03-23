#include<stdio.h>
//ÊµÀý¼û2017092101
template <class T>
void Preorder(const BTNode<T>* t)
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
void SimPreorder(const BTNode<T>* t)
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
