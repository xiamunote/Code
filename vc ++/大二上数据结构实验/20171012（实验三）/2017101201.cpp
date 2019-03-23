#include<stdio.h>
#include<BTNode.h>
template<class T>
void Inorder(const BTNode<T>* t)
{
	if(!t)
		return;
	if(t->left)
		Inorder(t->left);
	cot<<t->data;
	if(t->right)
		Inorder(t->right);
}

template<class T>
void SimInorder(const BTNode<T>* t)
{
	if(!t)
		return;
	Stack<const BTNode<T>*> S;
	while(t||!S.Empty())
		if(t)
		{
			S.Push(t);
			t=t->left;
		}
		else
		{
			t=S.Pop();
			cout<<t->data;
			t=t->right;
		}
}

template<class T>
void Postorder(const BTNode<T>* t)
{
	if(!t)
		return;
	if(t->left)
		Postorder(t->left);
	if(t->right)
		Postoeder(t->right);
	cout<<t->data;
}

template<class T>
void SimPostorder(const BTNode<T>* t)
{
	if(!t)
		return;
	int tag;
	Stack<const BTNode<T>*> S;
	Stack<int> tagS;
	const BTNode<T>*temp;
	while(t||S.Empty())
		if(t)
		{
			S.Push(t);
			tagS.Push(1);
			t=t->left;
		}
		else
		{
			temp=S.Pop();
			tag=tagS.Pop();
			if(tag==1)
			{
				S.Push(temp);
				tagS.Push(2);
				t=temp->right;
			}
			else
				cout<<temp->data;
		}
}