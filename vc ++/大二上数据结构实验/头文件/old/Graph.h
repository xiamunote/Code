//Graph类Graph.h
#include<iostream.h>
#include<fstream.h>
#include"List.h"
#include"Queue.h"
#include"PathData.h"
#include"heap.h"

const double MAXCOST=10000;
template<class T>
class Graph
{	//边点结构体
	struct EdgeNode
	{
	int dest;
	double cost;
	operator int(){return dest;}
	};
T * VA;
List<EdgeNode>* HL;
int sizeV,sizeE;
int maxV;
double GetCost(int si,int dj)const;
public:
Graph(int n=100):sizeV(0),sizeE(0),maxV(n)
{
VA=new T[n];
HL=new List<EdgeNode>[n];
}
~Graph(){delete []VA;delete []HL;}
int Empty()const{return(sizeV==0);}
int Full()const{return(sizeV==maxV);}
int SizeV()const{return(sizeV);}
int SizeE()const{return(sizeE);}
double GetCost(const T& v1,const T& v2)const;
int FindNode(const T& v)const;
bool FindNode(T& v,int pos)const;

bool InsertV(const T& v);
bool InsertE(const T& v1,const T& v2,double w);
bool DeleteV(const T& v);
bool DeleteE(const T& v1,const T& v2);
void ReadGraph(const char* filename);
void WriteGraph(const char* filename);
friend ostream& operator<<(ostream& ostr,const Graph<T>& g);
friend istream& operator>>(istream& istr,Graph<T>& g);
void BFS(List<T>& L,const T& v)const;
void BFS(List<T>& L)const;
void BFS(List<T>& L,int pos,bool* visited)const;
void DFS(List<T>& L,int pos,bool* visited)const;
void DFS(List<T>& L,const T& v)const;
void DFS(List<T>& L)const;

void BuildHeap(PathData* E,int size)const;
void PercolateDown(PathData* E,int pos,int size)const;
bool Prim(const T& v,PathData* E,int ne)const;
bool Kruskal(PathData* E,int ne)const;
bool Dijkstra(const T& v,double *D,int *p,int nv)const;
};

template<class T>
int Graph<T>::FindNode(const T& v)const
{
for(int i=0;i<sizeV;i++)
if(VA[i]==v)
return(i);
return(-1);
}

template<class T>
bool Graph<T>::FindNode(T& v,int pos)const
{
if(pos<0||pos>=sizeV)
return(0);
v=VA[pos];
return(1);
}

template<class T>
bool Graph<T>::InsertV(const T& v)
{
if(sizeV==maxV)
return(0);
VA[sizeV]=v;
sizeV++;
return(1);
}

template<class T>
bool Graph<T>::InsertE(const T& v1,const T& v2,double w)
{
int si=FindNode(v1),dj=FindNode(v2);
if(si==-1||dj==-1||si==dj)
return(0);
EdgeNode en;
en.dest=dj; en.cost=w;
HL[si].Insert(HL[si].End(),en);
sizeE++;
return(1);
}

template<class T>
ostream& operator<<(ostream& ostr,const Graph<T>& g)
{
for(int i=0;i<g.sizeV;i++)
{
ostr<<i<<'-'<<g.VA[i]<<':';
List<Graph<T>::EdgeNode>::iterator first=g.HL[i].Begin(),last=g.HL[i].End();
for(;first!=last;++first)
ostr<<'('<<(*first).dest<<','<<(*first).cost<<')'<<' ';
ostr<<endl;
}
return(ostr);
}

template<class T>
istream& operator>>(istream& istr,Graph<T>& g)
{
char s[50];
int n;  double w;
T v1,v2;
istr>>s>>n;
for(int i=1;i<=n;++i)
{
istr>>v1;
g.InsertV(v1);
}
istr>>s>>n;
for(i=1;i<=n;++i)
{
istr>>v1>>v2>>w;
g.InsertE(v1,v2,w);
}
return(istr);
}

template<class T>
void Graph<T>::ReadGraph(const char* filename)
{
char str[50];
int n;
double w;
T v1,v2;
ifstream fin;
fin.open(filename,ios::in|ios::nocreate);
if(!fin)
{
cout<<"cannot open "<<filename<<endl; exit(1);
}
fin>>str>>n;
for(int i=1;i<=n;++i)
{
fin>>v1;
InsertV(v1);
}
fin>>str>>n;
for(i=1;i<=n;++i)
{
fin>>v1>>v2>>w;
InsertE(v1,v2,w);
}
}

template<class T>
void Graph<T>::WriteGraph(const char* filename)
{
ofstream fout;
fout.open(filename,ios::out);
if(!fout)
{
cout<<"cannot open "<<filename<<endl;exit(1);
}

for(int i=0;i<sizeV;i++)
{
fout<<i<<'-'<<VA[i]<<':';
List<Graph<T>::EdgeNode>::iterator first=HL[i].Begin(),last=HL[i].End();
for(;first!=last;++first)
fout<<'('<<(*first).dest<<','<<(*first).cost<<')'<<' ';
fout<<endl;
}
}

//删除顶点
template<class T>
bool Graph<T>::DeleteV(const T& v)
{
int si=FindNode(v);
if(si==-1)
return(0);
int size=HL[si].Size();
for(int i=si;i<sizeV-1;i++)
{
VA[i]=VA[i+1];
HL[i]=HL[i+1];
}
HL[sizeV-1].Clear();
sizeV--;
sizeE=sizeE-size;

List<EdgeNode>::iterator first,last;
for(i=0;i<sizeV;i++)
{
first=HL[i].Begin(),last=HL[i].End();
for(;first!=last;++first)
if((*first).dest==si)
{
HL[i].Erase(first);
sizeE--;
break;
}
}

for(i=0;i<sizeV;i++)
{
first=HL[i].Begin(),last=HL[i].End();
for(;first!=last;++first)
if((*first).dest>si)
(*first).dest--;
}
return(1);
}

//删除边
template<class T>
bool Graph<T>::DeleteE(const T& v1,const T& v2)
{
int si=FindNode(v1),dj=FindNode(v2);
if(si==-1||dj==-1||si==dj)
return(0);
List<EdgeNode>::iterator first=HL[si].Begin(),last=HL[si].End();
for(;first!=last;++first)
if((*first).dest==dj)
{
HL[si].Erase(first);
sizeE--;
return(1);
}
return(0);
}

//读取边的权(私有函数)
template<class T>
double Graph<T>::GetCost(int si,int dj)const
{
if(si<0||si>=sizeV||dj<0||dj>=sizeV||si==dj)
return(0);
List<EdgeNode>::const_iterator first=HL[si].Begin(),last=HL[si].End();
for(;first!=last;++first)
if((*first).dest==dj)
return((*first).cost);
return(0);
}

//读取边的权(公有函数)
template<class T>
double Graph<T>::GetCost(const T& v1,const T& v2)const
{
return(GetCost(FindNode(v1),FindNode(v2)));
}

//图的广度优先遍历1
template<class T>
void Graph<T>::BFS(List<T>& L,const T& v)const
{
int pos=FindNode(v);
if(pos==-1) return;
bool *visited=new bool[sizeV];
for(int i=0;i<sizeV;i++)
visited[i]=0;
Queue<int> Q;
Q.Push(pos);
visited[pos]=1;
List<EdgeNode>::const_iterator first,last;
while(!Q.Empty())
{
pos=Q.Pop();
L.Push_back(VA[pos]);
first=HL[pos].Begin();
last=HL[pos].End();
for(;first!=last;++first)
if(visited[(*first).dest]==0)
{
Q.Push((*first).dest);
visited[(*first).dest]=1;
}
}
delete []visited;
}

//图的广度优先遍历2
template<class T>
void Graph<T>::BFS(List<T>& L)const
{
bool *visited=new bool[sizeV];
for(int i=0;i<sizeV;i++)
visited[i]=0;
for(i=0;i<sizeV;i++)
if(visited[i]==0)
BFS(L,i,visited);
delete []visited;
}


//图的广度优先遍历3
template<class T>
void Graph<T>::BFS(List<T>& L,int pos,bool* visited)const
{
if(pos<0||pos>=sizeV) return;
Queue<int> Q;
Q.Push(pos);
visited[pos]=1;
List<EdgeNode>::const_iterator first,last;
while(!Q.Empty())
{
pos=Q.Pop();
L.Push_back(VA[pos]);
first=HL[pos].Begin();
last=HL[pos].End();
for(;first!=last;++first)
if(visited[(*first).dest]==0)
{
Q.Push((*first).dest);
visited[(*first).dest]=1;
}
}
}


//图的深度优先遍历1
template<class T>
void Graph<T>::DFS(List<T>& L,int pos,bool* visited)const
{
if(pos<0||pos>=sizeV) return;
L.Push_back(VA[pos]);
visited[pos]=1;
List<EdgeNode>::const_iterator first,last;
first=HL[pos].Begin();
last=HL[pos].End();
for(;first!=last;++first)
if(visited[(*first).dest]==0)
DFS(L,(*first).dest,visited);
}

//树的深度优先遍历2
template<class T>
void Graph<T>::DFS(List<T>& L,const T& v)const
{
int pos=FindNode(v);
if(pos==-1) return;
bool *visited=new bool[sizeV];
for(int i=0;i<sizeV;i++)
visited[i]=0;
DFS(L,pos,visited);
}

//树的深度优先遍历3
template<class T>
void Graph<T>::DFS(List<T>& L)const
{
bool *visited=new bool[sizeV];
for(int i=0;i<sizeV;i++)
visited[i]=0;
for(i=0;i<sizeV;i++)
if(visited[i]==0)
DFS(L,i,visited);
delete []visited;
}

//把长度为size的PathData结点数组调整为堆
template<class T>
void Graph<T>::BuildHeap(PathData* E,int size)const
{
for(int i=size/2-1;i>=0;i--)
PercolateDown(E,i,size);
}

//将下标[pos,size)范围内的PathData结点数组元素向下调整为堆
template<class T>
void Graph<T>::PercolateDown(PathData* E,int pos,int size)const
{
int p=pos,c=2*p+1;
PathData temp=E[p];
while(c<size)
{
if(c+1<size&&E[c+1]<E[c])
++c;
if(temp<E[c])
break;
else
	{
	E[p]=E[c];
	p=c;
	c=2*p+1;
	}
}
E[p]=temp;
}

//克鲁斯卡尔Kruskal算法
template<class T>
bool Graph<T>::Kruskal(PathData* E,int ne)const
{
Heap<PathData> H;
int nv=ne+1;
int i,j,id,*DS=new int[nv];
for(i=0;i<nv;i++) DS[i]=-1;
double cost;
PathData e;
for(i=0;i<nv;i++) 
	for(j=i+1;j<nv;j++) 
{
cost=GetCost(i,j);
if(cost!=0)
{e.start=i;
e.dest=j;
e.cost=cost;
H.Insert(e);
}
}
id=0;
while(!H.Empty())
{
H.DeleteMin(e);
i=e.start;
while(DS[i]>=0) i=DS[i];
j=e.dest;
while(DS[j]>=0) j=DS[j];
if(i!=j)
{
if(i<j)
{DS[i]+=DS[j];DS[j]=i;}
else
{DS[j]+=DS[i];DS[i]=j;}
E[id++]=e;
}
}
delete []DS;
return(id==ne?1:0);
}

//单源最短路径迪克斯特拉算法
template<class T>
bool Graph<T>::Dijkstra(const T& v,double *D,int *P,int nv)const
{
int i,j,s,ns,ne=nv-1;
PathData item, *E=new PathData[ne];
double cost;
s=FindNode(v);
if(s==-1)return(0);
D[s]=0;
P[s]=-1;
int id=0;
for(i=0;i<=ne;i++)
if(i!=s)
{
item.start=s;
item.dest=i;
cost=GetCost(s,i);
item.cost=(cost==0?MAXCOST:cost);
E[id++]=item;
D[i]=item.cost;
P[i]=(cost==0?-1:s);
}
int count=0;
BuildHeap(E,ne);
for(i=0;i<ne;i++)
{
if(E[0]<MAXCOST)count++;
ns=E[0].dest;
for(j=1;j<ne-i;j++)
	{
	cost=GetCost(ns,E[j].dest);
	cost=(cost==0?MAXCOST:cost);
	if(E[j]>E[0]+cost)
	{
	E[j].cost=E[0].cost+cost; 
	E[j].start=ns;
	D[E[j].dest]=E[j].cost;
	P[E[j].dest]=ns;
	}
	}
item=E[0];
E[0]=E[ne-1-i];
E[ne-1-i]=item;
PercolateDown(E,0,ne-1-i);
}
delete []E;
return(count==ne?1:0);
}
