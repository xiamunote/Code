//BTNodeLib.h 
#include<iostream.h>
#include"BTNode.h"
#include"Queue.h"
#include"Vector.h"

template<class T>
BTNode<T> * GetBTNode(const T& item, BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
BTNode<T> *p;
p=new BTNode<T>(item,lp,rp);
if(p==NULL)
{
cerr<<"Memory allocation failure!"<<endl; exit(1);
}
return(p);
}

//层次遍历方法1（出队之后访问）
template<class T>
void Level(const BTNode<T>* t)
{
if(t==NULL) return;
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

//把二叉树顺序存储转化为链式存储
template<class T>
BTNode<T>* MakeLinked(const Vector<T>& L)
{
// if(L.Size()==0)return;
Queue<BTNode<T>*> Q;
BTNode<T>* t=GetBTNode(L[0]), *f, *c;
Q.Push(t);
int i=0,n=L.Size();
while(!Q.Empty())
{
f=Q.Pop();
if(2*i+1<n&&L[2*i+1]!=T())//左孩子存在
{
c=GetBTNode(L[2*i+1]);	//生成左孩子
f->left=c;
Q.Push(c);
}
if(2*i+2<n&&L[2*i+2]!=T())//右孩子存在
{
c=GetBTNode(L[2*i+2]);	//生成右孩子
f->right=c;
Q.Push(c);
}
i++;
while(i<n&&L[i]==T())	//i是非0元素下标
i++;
}
return(t);
}


//垂直输出二叉树
struct Location
{
int x,y;
};

template<class T>
void PrintBTree(const BTNode<T>* t,int w)
{
if(t==NULL) return;
int level=0,off=w/2;
Location f,c;
Queue<const BTNode<T>*> Q;
Queue<Location> LQ;
f.x=off;f.y=level;
Q.Push(t);
LQ.Push(f);
while(!Q.Empty())
{
t=Q.Pop();
f=LQ.Pop();
Gotoxy(f.x,f.y);
cout<<t->data;
if(f.y!=level)
{level++;off=off/2;}
if(t->left)
{
Q.Push(t->left);
c.y=f.y+1;
c.x=f.x-off/2;
LQ.Push(c);
}
if(t->right)
{
Q.Push(t->right);
c.y=f.y+1;
c.x=f.x+off/2;
LQ.Push(c);
}
}
cout<<endl;
}

void Gotoxy(int x,int y)
{
static int level=0,indent=0;
if(y==0)
{indent=0;level=0;}
if(level!=y)
{
cout<<endl;
indent=0;
level++;
}
cout.width(x-indent);
indent=x;
}
