#ifndef GRAPH_H
#define GRAPH_H
#include<stdlib.h>
#include<iostream.h>
#include<fstream.h>
#include"List.h"
#include"Queue.h"

template<class T>
class Graph
{
	struct EdgeNode			//边结点数据结构
	{
		int dest;			//边的终点下标
		double cost;		//边的权
		operator int(){return dest;}//成员转换函数
	};
private:
	T * VA;					//顶点数组指针
	List<EdgeNode>* HL;		//边链表数组指针
	int sizeV,sizeE;		//顶点数，边数
	int maxV;				//顶点数组空间长度
	
	void BFS(List<T>& L,int pos,bool visited[])const;
	void DFS(List<T>& L,int pos,bool visited[])const;
public:
	Graph(int n=100):sizeV(0),sizeE(0),maxV(n)		//构造函数
	{
		VA=new T[n];
		HL=new List<EdgeNode>[n];
	}
	~Graph(){Clear();delete []VA;delete []HL;}		//析构函数(增加Clear())
	void Clear();									//清图
	int Empty()const{return sizeV==0;}				//判空
	int Full()const{return sizeV==maxV;}			//判满
	int SizeV()const{return sizeV;}					//取顶点数
	int SizeE()const{return sizeE;}					//取边数
	double GetCost(const T& v1,const T& v2)const;	//取权
	int FindNode(const T& v)const;					//取顶点的下标
	bool FindNode(T& v,int pos)const;				//将下标为pos的顶点存储到v中	
	bool InsertV(const T& v);						//插入顶点
	bool InsertE(const T& v1,const T& v2,double w);	//插入边
	void ReadGraph(const char* filename);//从文件读取图的数据
	void WriteGraph(const char* filename);//把图的数据写（输出）到文件
	void BFS(List<T>& L,const T& v)const;			//广度优先遍历一个连同子图
	void BFS(List<T>& L)const;	
	friend ostream& operator<<(ostream& ostr,const Graph<T>& g);//重载输出运算符
	friend istream& operator>>(istream& istr,Graph<T>& g);		//重载输入运算符
};

template<class T>
void Graph<T>::Clear()
{
	sizeV=0;
	for(int i=0;i<sizeV;i++)
		HL[i].Clear();
}

template<class T>
int Graph<T>::FindNode(const T& v)const//取顶点的下标
{
	for(int i=0;i<sizeV;i++)//扫描顶点数组
		if(VA[i]==v)		//找到该顶点
			return i;
	return -1;
}

template<class T>
bool Graph<T>::FindNode(T& v,int pos)const//取下标为pos的顶点，存储到v中
{
	if(pos<0||pos>=sizeV)//pos值非法
		return 0;
	v=VA[pos];
	return 1;
}

template<class T>
bool Graph<T>::InsertV(const T& v)//插入顶点
{
	if(sizeV==maxV)
		return 0;
	VA[sizeV]=v;	//插入顶点数组
	sizeV++;		//顶点个数加1
	return 1;
}

template<class T>
bool Graph<T>::InsertE(const T& v1,const T& v2,double w)//插入边
{
	int si=FindNode(v1),dj=FindNode(v2);//确定边的始点和终点的下标
	if(si==-1||dj==-1||si==dj)
		return(0);
	EdgeNode en;						//边结点数据项
	en.dest=dj;	en.cost=w;				//边结点数据
	HL[si].Insert(HL[si].end(),en);		//插入边链表
	sizeE++;
	return 1;
}

template<class T>
void Graph<T>::ReadGraph(const char* filename)	//从文件中读取图的数据
{
	char str[50];
	int n;
	double w;
	T v1,v2;
	ifstream fin;
	fin.open(filename,ios::in|ios::nocreate);	//打开文件filename
	if(!fin)
	{
		cout<<"cannot open "<<filename<<endl;
		exit(1);
	}
	fin>>str>>n;					//读取顶点个数
	for(int i=1;i<=n;++i)			//读取n个顶点，插入顶点数组
	{
		fin>>v1;
		InsertV(v1);
	}
	fin>>str>>n;					//读取边数				
	for(i=1;i<=n;++i)				//读取n条边，插入邻接链表
	{
		fin>>v1>>v2>>w;			
		InsertE(v1,v2,w);
	}
}

template<class T>
void Graph<T>::WriteGraph(const char* filename)
{
	ofstream fout;
	fout.open(filename,ios::out);	//打开文件filename
	if(!fout)
	{
		cout<<"cannot open "<<filename<<endl;
		exit(1);
	}
	for(int i=0;i<sizeV;i++)
	{
		fout<<i<<'-'<<VA[i]<<':';		//输出顶点下标和顶点
		List<Graph<T>::EdgeNode>::iterator first=HL[i].begin(),last=HL[i].end();
		for(;first!=last;++first)		//输出以该顶点为始点的边链表
			fout<<'('<<(*first).dest<<','<<(*first).cost<<')'<<' ';
		fout<<endl;
	}
}

template<class T>
istream& operator>>(istream& istr,Graph<T>& g)//读取函数
{	
	char str[50];
	int n;
	double w;
	T v1,v2;
	istr>>str>>n;					//读取顶点个数
	for(int i=1;i<=n;++i)			//读取n个顶点，插入顶点链表
	{
		istr>>v1;
		g.InsertV(v1);
	}
	istr>>str>>n;					//读取边数				
	for(i=1;i<=n;++i)				//读取n条边，插入邻接链表
	{
		istr>>v1>>v2>>w;			
		g.InsertE(v1,v2,w);
	}
	return istr;
}

template<class T>
ostream& operator<<(ostream& ostr,const Graph<T>& g)//输出函数
{	
	for(int i=0;i<g.sizeV;i++)
	{
		ostr<<i<<'-'<<g.VA[i]<<':';		//输出顶点下标和顶点
		List<Graph<T>::EdgeNode>::iterator first=g.HL[i].begin(),last=g.HL[i].end();
		for(;first!=last;++first)		//输出以该顶点为始点的边链表
			ostr<<'('<<(*first).dest<<','<<(*first).cost<<')'<<' ';
		ostr<<endl;
	}
	return ostr;
}

template<class T>
void Graph<T>::BFS(List<T>& L,const T& v)const//从一个顶点开始广度优先遍历
{
	int pos=FindNode(v);			//取顶点下标
	if(pos==-1)
		return;
	bool *visited=new bool[sizeV];	//标志数组
	for(int i=0;i<sizeV;i++)			//标志数组初始化
		visited[i]=0;
	Queue<int> Q;
	Q.Push(pos);					//起始顶点下标入队
	visited[pos]=_________;	//(1)此处填空
	List<EdgeNode>::const_iterator first,last;//边链表迭代器
	while(__________)  //(2)此处填空
	{
		pos=__________;	//(3)此处填空
		L.Push_back(VA[pos]);	//存储顶点作为返回值
		first=_______________;//(4)此处填空	
		last=HL[pos].end();
		for(;first!=last;++first)			//扫描边链表，寻找未被访问的邻接点
			if(visited[(*first).dest]==0)	//如果邻接点未被访问
			{
				Q.Push(_______________);//(5)此处填空
				visited[(*first).dest]=1;	//做访问标志
			}
	}
}
#endif