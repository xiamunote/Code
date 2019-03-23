
//AvlTree.h
//平衡二叉搜索树
#include<iostream.h>

template<class T>
class AvlTree
{
private:
struct AvlNode  
{
T data;
AvlNode *left, *right;
int height;
AvlNode(const T& item,AvlNode* l=0,AvlNode* r=0,int h=0):data(item),left(l),right(r),height(h){}
};

AvlNode* root;
int size;
int Height(AvlNode* t)const{return(t==NULL?-1:t->height);}
void Insert(const T& x, AvlNode* &t);
AvlNode* FindNode(const T& x, AvlNode* t)const;
int Max(int x1,int x2){return x1<x2?x2:x1;}
void LL(AvlNode* &t);
void RR(AvlNode* &t);
void RL(AvlNode* &t);
void LR(AvlNode* &t);
void Clear(AvlNode* &t);
void PrintAvlTree(const AvlNode* t, int screenwidth)const;

public:
AvlTree(void):root(NULL),size(0){};
AvlTree(const AvlTree& bst);
~AvlTree(void){Clear(root);}

bool Find(const T& x)const{return(FindNode(x,root)!=NULL);}
bool Find(T& x)const;
bool Empty(void)const{return(size==0);}
int Size(void){return(size);}
void Clear(void){Clear(root);size=0;}
void Update(const T& x);
void Insert(const T& x){Insert(x,root);}
void PrintAvlTree(int screenwidth)const{PrintAvlTree(root,screenwidth);}
};

template<class T>
void AvlTree<T>::Insert(const T& x, AvlNode* &t)
{
if(t==NULL)
{t=new AvlNode(x); size++;}
else if(x<t->data)
	{
	Insert(x,t->left);
	if(Height(t->left)-Height(t->right)==2)	
		if(x<t->left->data) LL(t);
		else
		LR(t);
	}
	else if(t->data<x)
	{
	Insert(x,t->right);
	if(Height(t->right)-Height(t->left)==2)	
		if(t->right->data<x) RR(t);
		else
		RL(t);
	}
	t->height=Max(Height(t->left),Height(t->right))+1;
}


template<class T>
void AvlTree<T>::Clear(AvlNode* &t)
{
if(t==NULL)return;
Clear(t->left);
Clear(t->right);
delete t; t=NULL;
}




















	



	


	
