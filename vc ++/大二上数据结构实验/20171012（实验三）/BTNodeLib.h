#include"BTNode.h"
#include"Queue.h"
#include"Vector.h"
template<class T>
BTNode<T> * GetBTNode(const T& item,BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
	BTNode<T> *p;
	p=new BTNode<T>(item,lp,rp);
	if(p==NULL)
	{
		cout<<"Memory allocation failure!"<<endl; exit(1);
	}
	return(p);
}
template<class T>
void Level(const BTNode<T>* t)
{
	if(t==NULL)
		return;
	Queue<const BTNode<T>*>Q;
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
template<class T>
BTNode<T>* MakeLinked(const Vector<T>& L)
{
//	if(L.Size()==0)
//		return;
	Queue<BTNode<T>*>Q;
	BTNode<T> *t=GetBTNode(L[0]);
	BTNode<T>*parent,*child;
	Q.Push(t);
	int i=0,n=L.Size();
	while(!Q.Empty())
	{
		parent=Q.Pop();
		if(2*i+1<n&&L[2*i+1]!=T())
		{
			child=GetBTNode(L[2*i+1]);
			parent->left=child;
			Q.Push(child);
		}
		if(2*i+2<n&&L[2*i+2]!=T())
		{
			child=GetBTNode(L[2*i+2]);
			parent->right=child;
			Q.Push(child);
		}
		i++;
		while(i<n&&L[i]==T())
			i++;
	}
	return(t);
}
struct Location
{
	int xindent,ylevel;
};
void Gotoxy(int x,int y)
{
	static int level=0,indent=0;
	if(y==0)
	{
		indent=0;level=0;
	}
	if(level!=y)
	{
		cout<<endl;
		indent=0;level++;
	}
	cout.width(x-indent);
	indent=x;
}
template<class T>
void PrintBTree(const BTNode<T>*t,int screenwidth)
{
	if(t==NULL)
		return;
	int level=0,offset=screenwidth/2;
	Location fLoc,cLoc;
	Queue<const BTNode<T>*>Q;
	Queue<Location>LQ;
	fLoc.xindent=offset;
	fLoc.ylevel=level;
	Q.Push(t);
	LQ.Push(fLoc);
	while(!Q.Empty())
	{
		t=Q.Pop();
		fLoc=LQ.Pop();
		Gotoxy(fLoc.xindent,fLoc.ylevel);
		cout<<t->data;
		if(fLoc.ylevel!=level)
		{
			level++;offset=offset/2;
		}
		if(t->left)
		{
			Q.Push(t->left);
			cLoc.ylevel=fLoc.ylevel+1;
			cLoc.xindent=fLoc.xindent-offset/2;
			LQ.Push(cLoc);
		}
		if(t->right)
		{
			Q.Push(t->right);
			cLoc.ylevel=fLoc.ylevel+1;
			cLoc.xindent=fLoc.xindent+offset/2;
			LQ.Push(cLoc);
		}
	}
	cout<<endl;
}
