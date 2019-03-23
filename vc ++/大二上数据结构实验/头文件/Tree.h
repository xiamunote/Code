//Tree类Tree.h
#include<iostream.h>
#include"List.h"
#include"Queue.h"
template<class T>
class Tree
{
T * NA;
List<int>* HL;
int root;
int sizeN,sizeC;
int maxN;
public:
Tree(int n=100):root(-1),sizeN(0),sizeC(0),maxN(n)
{
NA=new T[n];
HL=new List<int>[n];
}
~Tree(){delete []NA;delete []HL;}
int Empty()const{return(sizeN==0);}
int Full()const{return(sizeN==maxN);}
int SizeN()const{return(sizeN);}
int SizeC()const{return(sizeC);}
int FindNode(const T& v)const;
bool FindNode(T& v,int pos)const;

bool InsertN(const T& node);
bool InsertC(const T& parent,const T& child);
void ReadTree(const char* filename);
void WriteTree(const char* filename);
friend ostream& operator<<(ostream& ostr,const Tree<T>& t);
friend istream& operator>>(istream& istr,Tree<T>& t);
void BFS(List<T>& L)const;
void DFS(List<T>& L,int t)const;
void DFS(List<T>& L)const;
};

template<class T>
int Tree<T>::FindNode(const T& node)const
{
for(int i=0;i<sizeN;i++)
if(NA[i]==node)
return(i);
return(-1);
}

template<class T>
bool Tree<T>::FindNode(T& node,int pos)const
{
if(pos<0||pos>=sizeN)
return(0);
node=NA[pos];
return(1);
}

template<class T>
bool Tree<T>::InsertN(const T& node)
{
if(sizeN==maxN)
return(0);
NA[sizeN]=node;
sizeN++;
return(1);
}

template<class T>
bool Tree<T>::InsertC(const T& parent,const T& child)
{
int pi=FindNode(parent),cj=FindNode(child);
if(pi==-1||cj==-1||pi==cj)
return(0);
HL[pi].Insert(HL[pi].End(),cj);
sizeC++;
return(1);
}

template<class T>
ostream& operator<<(ostream& ostr,const Tree<T>& t)
{
for(int i=0;i<=t.sizeN;++i)
{
ostr<<i<<'-'<<t.NA[i]<<':';
List<int>::iterator first=t.HL[i].Begin(),last=t.HL[i].End();
for(;first!=last;++first)
ostr<<'('<<*first<<')'<<' ';
ostr<<endl;
}
return(ostr);
}

template<class T>
istream& operator>>(istream& istr,Tree<T>& t)
{
char str[50];
int n;
T parent,child;
istr>>str>>n;
istr>>str>>parent;
t.InsertN(parent);
t.root=t.sizeN-1;
istr>>str;
for(int i=1;i<=n-1;++i)
{
istr>>child;
t.InsertN(child);
}
istr>>str>>n;
for(i=1;i<=n;++i)
{
istr>>parent>>child;
t.InsertC(parent,child);
}
return(istr);
}

//树的广度优先遍历
template<class T>
void Tree<T>::BFS(List<T>& L)const
{
if(sizeN==0) return;
Queue<int> Q;
Q.Push(root);
List<int>::const_iterator first,last;
while(!Q.Empty())
{
int pos=Q.Pop();
L.Push_back(NA[pos]);
first=HL[pos].Begin();
last=HL[pos].End();
for(;first!=last;++first)
Q.Push(*first);
}
}

//树的深度优先遍历
template<class T>
void Tree<T>::DFS(List<T>& L,int t)const
{
if(t<0||t>sizeN) return;
L.Push_back(NA[t]);
List<int>::const_iterator first,last;
first=HL[t].Begin();
last=HL[t].End();
for(;first!=last;++first)
DFS(L,*first);
}

//树的深度优先遍历2
template<class T>
void Tree<T>::DFS(List<T>& L)const
{
DFS(L,root);
}



