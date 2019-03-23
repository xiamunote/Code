//中序迭代器
#include"Stack.h"
#include"Queue.h"
#include<iostream.h>
template<class T>
class BSTree
{
private:
struct BTNode  
{
T data;
BTNode *left, *right;
BTNode(const T& item,BTNode* lptr=0,BTNode* rptr=0):data(item),left(lptr),right(rptr){}
};

BTNode* root;
int size;
void Insert(const T& x, BTNode* &t);
void Remove(const T& x, BTNode* &t);
BTNode* FindMin(BTNode* t)const;
BTNode* FindMax(BTNode* t)const;
BTNode* FindNode(const T& x, BTNode* t)const;
void Clear(BTNode* &t);
void PrintBTree(const BTNode* t, int w)const;

public:
class const_iterator
	{
	protected:
		BTNode *current;
		T& retrieve()const{return current->data;}
		const_iterator(BTNode* t){current=GoFarLeft(t);}
		Stack<BTNode*> St;
		BTNode* GoFarLeft(BTNode* t)
		{
		if(!t)return(NULL);
		while(t->left)
		{St.Push(t);t=t->left;}
		return(t);
		}
		friend class BSTree<T>;
	public:
		const_iterator():current(NULL){}
		const T& operator*()const{return(retrieve());}
		const_iterator& operator++()//前++
		{
		if(current->right)
			current=GoFarLeft(current->right);
		else if(!St.Empty())current=St.Pop();
		else
			current=NULL;
		return(*this);
		}
		bool operator==(const const_iterator & rhs)const
			{return current==rhs.current;}
		bool operator!=(const const_iterator & rhs)const
			{return current!=rhs.current;}
	};
	class iterator:public const_iterator
	{
	protected:
		iterator(BTNode *t):const_iterator(t){}
		friend class BSTree<T>;
	public:
		iterator(){}
		T& operator*(){return retrieve();}
		const T& operator*()const{return(const_iterator::operator*());}
		iterator& operator++()//前++
		{
			if(current->right)
			current=GoFarLeft(current->right);
		else if(!St.Empty())current=St.Pop();
		else
			current=NULL;
		return(*this);
		}
	};

	const_iterator Begin()const{return(const_iterator(root));}
	iterator Begin(){return(iterator(root));}
	const_iterator End()const{return NULL;}
	iterator End(){return NULL;}

BSTree():root(NULL),size(0){};
~BSTree(){Clear();}
T& FindMin()const{return(FindMin(root)->data);}
T& FindMax()const{return(FindMax(root)->data);}
bool Find(const T& x)const{return(FindNode(x,root)!=NULL);}
bool Find(T& x)const;
bool Empty()const{return(size==0);}
void Clear(){Clear(root);}
int Size(){return(size);}
void Update(const T& x);
void Insert(const T& x){Insert(x,root);}
void Remove(const T& x){Remove(x,root);}
void PrintBTree(int w)const{PrintBTree(root,w);}

};

template<class T>
BSTree<T>::BTNode* BSTree<T>::FindMin(BTNode* t)const
{
if(t!=NULL)
while(t->left!=NULL)
t=t->left;
return t;
}

template<class T>
BSTree<T>::BTNode* BSTree<T>::FindMax(BTNode* t)const
{
if(t!=NULL)
while(t->right!=NULL)
t=t->right;
return t;
}

template<class T>
BSTree<T>::BTNode* BSTree<T>::FindNode(const T& x, BTNode* t)const
{
if(t==NULL)return NULL;
while(t)
if(x<t->data)
t=t->left;
else if(t->data<x)
t=t->right;
else
return t;
return NULL;
}

template<class T>
void BSTree<T>::Clear(BTNode* &t)
{
if(t==NULL)return;
Clear(t->left);
Clear(t->right);
delete t; t=NULL;
}

template<class T>
bool BSTree<T>::Find(T& x)const
{
BTNode* p=FindNode(x,root);
if(p)
{x=p->data;return 1;}
return(0);
}

template<class T>
void BSTree<T>::Update(const T& x)
{
BTNode* p=FindNode(x,root);
if(p)
p->data=x;
else
Insert(x);
}

template<class T>
void BSTree<T>::Insert(const T& x, BTNode* &t)
{
if(t==NULL)
{t=new BTNode(x); size++;}
else if(x<t->data)
	Insert(x,t->left);
	else if(t->data<x)
	Insert(x,t->right);
}

template<class T>
void BSTree<T>::Remove(const T& x, BTNode* &t)
{
if(t==NULL)return;
if(x<t->data)
Remove(x,t->left);
	else if(t->data<x)
	Remove(x,t->right);
else if(t->left!=NULL&&t->right!=NULL)
{
t->data=FindMin(t->right)->data;
Remove(t->data,t->right);
}
else
{
BTNode* old=t;
t=(t->left!=NULL)?t->left:t->right;
delete old;
size--;
}
}



















	



	


	
