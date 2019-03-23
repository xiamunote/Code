#include<iostream.h>

template<class T>
BTNode<T> * GetBTNode(const T& item,BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
	BTNode<T> *p;
	p=new BTNode<T>(item,lp,rp);
	if(p=NULL)
	{
		cout<<"Memory allocation failure"<<endl;
		exit(1);
	}
	return p;
}
template <class T>
void Level(const BTNode<T>* t)		//层次遍历方法1（结点指针出队后访问结点）
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
		{
			Q.Push(t->left);
		}
		if(t->right)
		{
			Q.Push(t->right);
		}
	}

}

template<class T>
void Level(const BTNode<T>* t)		//层次遍历方法2（结点指针出队前访问结点）
{
	if(t=NULL)
		return;
	Queue<BTNode<T>*> Q;
	cout<<t->data;
	Q.Push(t);
	while(!Q.Empty())
	{
		t=Q.Pop();
		if(t->left)
		{
			cout<<t->left->data;
			Q.Push(t->left);
		}
		if(t->right)
		{
			cout<<t->right->data;
			Q.Push(t->right);
		}
	}
	
}

template <class T>
BTNode<T>*MakeLinked(const Vector<T>& L)		//顺序存储转化为链式存储
{
	if(L.Size()==0)
	{
		return;
	}
	Queue<BTNode<T>*> Q;
	BTNode<T> *t=GetBTNode(L[0]);
	BTNode<T> *parent,*child;
	Q.Push(t);
	while(!Q.Empty())
	{
		parent=Q.Pop();
		if(2*i+1<n&&L[2*i+1]!==T())
		{
			child=GetBTNode(L[2*i+1]);
			parent->left=child;
			Q.Push(child);
		}
		if(2*i+2<n&&L[2*i+2]!==T())
		{
			child=GetBTNode(L[2*i+2]);
			parent->right=child;
			Q.Push(child);
		}
		i++;
		while(i<n&&L[i]==T())
			i++;
	}
	return t;

}

template <class T>
void Preorder(const BTNode<T> *t)		//前序遍历递归算法1
{
	if(t==NULL)
		return;
	cout<<t->data;
	if(t->left)
		Preorder(t->left);
	if(t->right)
		Preorder(t->right);
}

template<class T>
void Preorder(const BTNode<T>* t)		//前序遍历递归算法2
{
	if(t==NULL)
		return ;
	cout<<t->data;
	Preorder(t->left);
	Preoder(t->right);
}

template <class T>
void SimPreorder(BTNode<T>* t)		//前序遍历非递归算法
{
	if(!t)
		return;
	Stack<const BTNode<T>*> S;
	while(t||!S.Empty())
	{
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
}



int main()
{
	BTNode<char> *nullp=NULL;
	BTNode<char> *fp=('F');
	BTNode<char> *dp=('D',fp);
	BTNode<char> *bp=('B',nullp,dp);
	BTNode<char> *ep=('E');
	BTNode<char> *cp=('C',nullp,ep);
	BTNode<char> *ap=('A',bp,cp);
	Level(ap);
	cout<<endl;
	return 0;

}
