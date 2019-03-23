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
	struct EdgeNode			//�߽�����ݽṹ
	{
		int dest;			//�ߵ��յ��±�
		double cost;		//�ߵ�Ȩ
		operator int(){return dest;}//��Աת������
	};
private:
	T * VA;					//��������ָ��
	List<EdgeNode>* HL;		//����������ָ��
	int sizeV,sizeE;		//������������
	int maxV;				//��������ռ䳤��
	
	void BFS(List<T>& L,int pos,bool visited[])const;
	void DFS(List<T>& L,int pos,bool visited[])const;
public:
	Graph(int n=100):sizeV(0),sizeE(0),maxV(n)		//���캯��
	{
		VA=new T[n];
		HL=new List<EdgeNode>[n];
	}
	~Graph(){Clear();delete []VA;delete []HL;}		//��������(����Clear())
	void Clear();									//��ͼ
	int Empty()const{return sizeV==0;}				//�п�
	int Full()const{return sizeV==maxV;}			//����
	int SizeV()const{return sizeV;}					//ȡ������
	int SizeE()const{return sizeE;}					//ȡ����
	double GetCost(const T& v1,const T& v2)const;	//ȡȨ
	int FindNode(const T& v)const;					//ȡ������±�
	bool FindNode(T& v,int pos)const;				//���±�Ϊpos�Ķ���洢��v��	
	bool InsertV(const T& v);						//���붥��
	bool InsertE(const T& v1,const T& v2,double w);	//�����
	void ReadGraph(const char* filename);//���ļ���ȡͼ������
	void WriteGraph(const char* filename);//��ͼ������д����������ļ�
	void BFS(List<T>& L,const T& v)const;			//������ȱ���һ����ͬ��ͼ
	void BFS(List<T>& L)const;	
	friend ostream& operator<<(ostream& ostr,const Graph<T>& g);//������������
	friend istream& operator>>(istream& istr,Graph<T>& g);		//�������������
};

template<class T>
void Graph<T>::Clear()
{
	sizeV=0;
	for(int i=0;i<sizeV;i++)
		HL[i].Clear();
}

template<class T>
int Graph<T>::FindNode(const T& v)const//ȡ������±�
{
	for(int i=0;i<sizeV;i++)//ɨ�趥������
		if(VA[i]==v)		//�ҵ��ö���
			return i;
	return -1;
}

template<class T>
bool Graph<T>::FindNode(T& v,int pos)const//ȡ�±�Ϊpos�Ķ��㣬�洢��v��
{
	if(pos<0||pos>=sizeV)//posֵ�Ƿ�
		return 0;
	v=VA[pos];
	return 1;
}

template<class T>
bool Graph<T>::InsertV(const T& v)//���붥��
{
	if(sizeV==maxV)
		return 0;
	VA[sizeV]=v;	//���붥������
	sizeV++;		//���������1
	return 1;
}

template<class T>
bool Graph<T>::InsertE(const T& v1,const T& v2,double w)//�����
{
	int si=FindNode(v1),dj=FindNode(v2);//ȷ���ߵ�ʼ����յ���±�
	if(si==-1||dj==-1||si==dj)
		return(0);
	EdgeNode en;						//�߽��������
	en.dest=dj;	en.cost=w;				//�߽������
	HL[si].Insert(HL[si].end(),en);		//���������
	sizeE++;
	return 1;
}

template<class T>
void Graph<T>::ReadGraph(const char* filename)	//���ļ��ж�ȡͼ������
{
	char str[50];
	int n;
	double w;
	T v1,v2;
	ifstream fin;
	fin.open(filename,ios::in|ios::nocreate);	//���ļ�filename
	if(!fin)
	{
		cout<<"cannot open "<<filename<<endl;
		exit(1);
	}
	fin>>str>>n;					//��ȡ�������
	for(int i=1;i<=n;++i)			//��ȡn�����㣬���붥������
	{
		fin>>v1;
		InsertV(v1);
	}
	fin>>str>>n;					//��ȡ����				
	for(i=1;i<=n;++i)				//��ȡn���ߣ������ڽ�����
	{
		fin>>v1>>v2>>w;			
		InsertE(v1,v2,w);
	}
}

template<class T>
void Graph<T>::WriteGraph(const char* filename)
{
	ofstream fout;
	fout.open(filename,ios::out);	//���ļ�filename
	if(!fout)
	{
		cout<<"cannot open "<<filename<<endl;
		exit(1);
	}
	for(int i=0;i<sizeV;i++)
	{
		fout<<i<<'-'<<VA[i]<<':';		//��������±�Ͷ���
		List<Graph<T>::EdgeNode>::iterator first=HL[i].begin(),last=HL[i].end();
		for(;first!=last;++first)		//����Ըö���Ϊʼ��ı�����
			fout<<'('<<(*first).dest<<','<<(*first).cost<<')'<<' ';
		fout<<endl;
	}
}

template<class T>
istream& operator>>(istream& istr,Graph<T>& g)//��ȡ����
{	
	char str[50];
	int n;
	double w;
	T v1,v2;
	istr>>str>>n;					//��ȡ�������
	for(int i=1;i<=n;++i)			//��ȡn�����㣬���붥������
	{
		istr>>v1;
		g.InsertV(v1);
	}
	istr>>str>>n;					//��ȡ����				
	for(i=1;i<=n;++i)				//��ȡn���ߣ������ڽ�����
	{
		istr>>v1>>v2>>w;			
		g.InsertE(v1,v2,w);
	}
	return istr;
}

template<class T>
ostream& operator<<(ostream& ostr,const Graph<T>& g)//�������
{	
	for(int i=0;i<g.sizeV;i++)
	{
		ostr<<i<<'-'<<g.VA[i]<<':';		//��������±�Ͷ���
		List<Graph<T>::EdgeNode>::iterator first=g.HL[i].begin(),last=g.HL[i].end();
		for(;first!=last;++first)		//����Ըö���Ϊʼ��ı�����
			ostr<<'('<<(*first).dest<<','<<(*first).cost<<')'<<' ';
		ostr<<endl;
	}
	return ostr;
}

template<class T>
void Graph<T>::BFS(List<T>& L,const T& v)const//��һ�����㿪ʼ������ȱ���
{
	int pos=FindNode(v);			//ȡ�����±�
	if(pos==-1)
		return;
	bool *visited=new bool[sizeV];	//��־����
	for(int i=0;i<sizeV;i++)			//��־�����ʼ��
		visited[i]=0;
	Queue<int> Q;
	Q.Push(pos);					//��ʼ�����±����
	visited[pos]=_________;	//(1)�˴����
	List<EdgeNode>::const_iterator first,last;//�����������
	while(__________)  //(2)�˴����
	{
		pos=__________;	//(3)�˴����
		L.Push_back(VA[pos]);	//�洢������Ϊ����ֵ
		first=_______________;//(4)�˴����	
		last=HL[pos].end();
		for(;first!=last;++first)			//ɨ�������Ѱ��δ�����ʵ��ڽӵ�
			if(visited[(*first).dest]==0)	//����ڽӵ�δ������
			{
				Q.Push(_______________);//(5)�˴����
				visited[(*first).dest]=1;	//�����ʱ�־
			}
	}
}
#endif