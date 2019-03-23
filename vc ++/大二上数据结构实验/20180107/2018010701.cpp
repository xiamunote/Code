
//simulation.h头文件
//#ifndef SIMULATION_H
//#define SIMULATION_H

#include<iostream>
#include"Queue.h"					//队列类模板
#include<stdlib.h>
#include<conio.h>
#include<iomanip>				//包含操作算子
#include<Vector>
#include"PQueue.h"
using namespace std;

class Event					//事件类型
{
	int time;			//事件发生时间
	int etype;			//事件类型：0表示到达，1、2、3、4...表示从几号窗口离开
public:
	Event():time(0),etype(0){}
	Event(int t,int e):time(t),etype(e){}
	operator int()const{return(time);}			//成员转换函数
	int GetTime()const{return(time);}			//读取事件发生时间
	int GetEventType()const{return(etype);}

};
struct Service					//排队客户信息结构
{
	int arrivalTime;			//客户到达时间
	int serviceTime;			//办理业务时间
};

struct TellerStats
{
	int totalCustomer;			//接待客户总数
	int totalService;			//服务时间总数
	int totalWait;				//客户等待时间总数
};

class Simulation
{
	int SimulationLength;					//模拟时间长度
	int numTellers;							//服务窗口个数
	int arrivalLow,arrivalHigh;				//客户到达的最短和最长时间间隔
	int serviceLow,serviceHigh;				//客户最短和最长的服务时间
	TellerStats t[11];						//最多10个窗口，TellerStats t[1]~TellerStats t[10]
	Queue<Service> Q[11];					//最多10个窗口队列，Q[1]~Q[10]
	PQueue<Event> PQ;				//用优先级队列作为事件表
	int GetIntertime()						//读取客户到达的时间间隔
	{		//取值范围为[arrivalLow,arrivalHigh]
		return(arrivalLow+rand()%(arrivalHigh-arrivalLow+1));
	}			
	int GetServiceTime()					//读取服务时间
	{		//取值范围为[serviceLow,serviceHigh]
		return(serviceLow+rand()%(serviceHigh-serviceLow+1));
	}
	int GetNextTeller();					//取下一个可用窗口
	void Arrived(const Event& e);			//处理一个客户到达事件
	void Daparture(const Event& e);			//处理一个客户离开事件
	void PrintPQueue();						//显示事件表
	void PrintQueue();						//显示窗口队列
public:
	Simulation();							//模拟过程初始化
	Simulation(int L,int nT,int aL,int aH,int sL, int sH);
	void RunSimulation();					//执行模拟
	void PrintSimulationResults();			//显示模拟结果
};

Simulation::Simulation()					//模拟过程初始化
{
	cout<<"Enter the simulation time in minutes:";			//从终端读取数据
	cin>>SimulationLength;
	cout<<"Enter the number of tellers(2~10):";
	cin>>numTellers;
	cout<<"Enter the range of arrival times in minutes:";
	cin>>arrivalLow>>arrivalHigh;
	cout<<"Enter the range of service times in minutes:";
	cin>>serviceLow>>serviceHigh;
	for(int i=1;i<=numTellers;i++)							//窗口信息初始化
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push(Event(0,0));									//一个客户于0时到达
}
Simulation::Simulation(int L,int nT,int aL,int aH,int sL,int sH)
{
	SimulationLength=L;
	numTellers=nT;
	arrivalLow=aL;
	arrivalHigh=aH;
	serviceLow=sL;
	serviceHigh=sH;
	for(int i=1;i<=numTellers;i++)
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push(Event(0,0));
}

int Simulation::GetNextTeller()							//取下一个可用窗口
{
	int i,size=Q[1].Size(),min=1;
	vector<int> v;
	for(i=2;i<=numTellers;i++)
		if(Q[i].Size()<size)
		{
			size=Q[i].Size();
			min=i;
		}
	//（1）到达的客户在人数最少的几个窗口中随机选择一个排队
	for(i=2;i<=numTellers;i++)
		if(Q[i].Size()==size)
		{
			v.push_back(i);
		}
		if(!v.empty())
		{return v[rand()%(v.size())];}
		else
		{return min;}
}
void Simulation::Arrived(const Event& e)				//处理一个客户到达事件
{
	Service s;
	int next,i;
	s.arrivalTime=e.GetTime();							//客户到达时间
	s.serviceTime=GetServiceTime();						//客户服务时间
    i=GetNextTeller();									//取下一个可用窗口队列
	Q[i].Push(s);										//到窗口排队
	if(Q[i].Size()==1)									//如果立即接收服务，则生成离开事件
		PQ.Push(Event(s.arrivalTime+s.serviceTime,i));	
	next=e.GetTime()+GetIntertime();					//计算下一个客户到达时间
	if(next<SimulationLength)							//下一个客户到达时间小于关门时间
		PQ.Push(Event(next,0));
	cout<<"ServiceTime NextTeller next\n";				//显示随机数据
	cout<<setw(5)<<s.serviceTime;						//设置域宽为5，默认为右对齐
	cout<<setw(12)<<i;
	cout<<setw(8)<<next<<endl;
}
//Service Time NextTeller next
//     7            1        5
void Simulation::Daparture(const Event& e)				//处理一个客户离开的事件
{
	int i=e.GetEventType(),size;						//确定离开的窗口
	Service s=Q[i].Pop();								//从窗口队列中删除一个数据
	size=Q[i].Size();
	t[i].totalCustomer++;								//修改窗口的信息记录
	t[i].totalService+=s.serviceTime;
	t[i].totalWait+=e.GetTime()-s.arrivalTime;
	//（2）一个客户从窗口离开后，有其他窗口的人数比该窗口的人数多2，那么从其他窗口队列，有一个客从队尾离开，排到该窗口			
	for(int j=1;j<=numTellers;j++)														
	{
		if(Q[j].Size()-size==2)
		{
			s=Q[j].Pop_back();
			Q[i].Push(s);
		}
	}
	if(!Q[i].Empty())									//若窗口队列不空，则计算出下一客户离开事件，并插入事件表
	{
		s=Q[i].Front();
		PQ.Push(Event(e.GetTime()+s.serviceTime,i));
	}
	
	
	
}

void Simulation::PrintPQueue()					//显示事件表
{
	int n=PQ.Size();							//记录事件表长度
	int i=0;									
	Event e,*p=new Event[n];					//建立动态数组
	cout<<"*****EventQueue*****\n";
	while(!PQ.Empty())							
	{
		e=PQ.Pop();							//取出事件表一元素输出
		cout<<'('<<e.GetTime()<<" "<<e.GetEventType()<<')';		//输出队列元素
		p[i++]=e;								//把事件表出队元素保存到数组
	}
	for(i=0;i<n;i++)							//把数组中元素插入到事件表
		PQ.Push(p[i]);
	cout<<endl;
	delete[]p;
}
void Simulation::PrintQueue()					//显示窗口队列
{
	int n;
	Service s;
	cout<<"*****Tellers*****\n";
	for(int t=1;t<=numTellers;t++)
	{
		cout<<t<<":";
		n=Q[t].Size();
		for(int i=1;i<=n;i++)
		{
			s=Q[t].Pop();
			cout<<'('<<s.arrivalTime<<" "<<s.serviceTime<<')';
			Q[t].Push(s);
		}
		cout<<endl;
	}
}
void Simulation::RunSimulation()				//执行模拟
{
	Event e;
	PrintPQueue();								//显示事件队列
	PrintQueue();								//显示排队窗口
	cout<<endl;									//为了显示清楚而空一行
	getch();									//按任意键继续，头文件conio.h
	while(!PQ.Empty())
	{
		e=PQ.Pop();
		if(e.GetEventType()==0)					//如果是到达事件
		{
			Arrived(e);							//处理到达事件
			PrintPQueue();						//显示事件队列
			PrintQueue();						//显示窗口队列
			cout<<endl;
		}
		else									//如果是到达事件
		{						
			Daparture(e);						//处理离开事件
			PrintPQueue();						//显示事件队列
			PrintQueue();						//显示排队窗口
			cout<<endl;
		}
		getch();
	}
}
void Simulation::PrintSimulationResults()
{
	int i,totalCustomers=0,totalWait=0;
	for(i=1;i<=numTellers;i++)
	{
		totalCustomers+=t[i].totalCustomer;
		totalWait+=t[i].totalWait;
	}
	cout<<totalCustomers<<endl;
	cout<<totalWait<<endl;
}

//#endif

//Queue.h头文件
#ifndef QUEUE_H
#define QUEUE_H
#include <iostream>
#include <List>
using namespace std;
template <class T>
class queue {
private:
	list<T> QueueL;
public:
	queue() {}
	~queue() {}
	int Size() 
	{ return QueueL.size(); }									
	bool Empty()												//求长
	{ return QueueL.empty(); }								
	const T& Front()const										//判空
	{ return QueueL.front(); }
	void Push(const T& item)									//入队
	{ QueueL.push_back(item); }
	T Pop()														//出队
	{ T item = QueueL.front(); 
	QueueL.pop_front(); return item; }
	T Pop_back()												//删除队尾元素
	{
		T item = QueueL.back();
		QueueL.pop_back();
		return item;
	}
	void clear()												//清空
	{ QueueL.clear(); }
};

#endif


//pQueue.h头文件
#ifndef PQUEUE_H
#define PQUEUE_H
#include <iostream>
#include <list>
using namespace std;
template <class T>
class pQueue {
private:
	list<T> QueueL;
public:
	pQueue() {}
	~pQueue() {}
	int Size() 
	{ return QueueL.size(); }									
	bool Empty()												//求长
	{ return QueueL.empty(); }								
	const T& Front()const										//判空
	{ return QueueL.front(); }
	void Push(const T& item)									//入队
	{ QueueL.push_back(item); }
	T Pop()														//出队
	{ 	
		list<T>::iterator itr,min=QueueL.begin();			//令迭代器指向链表首元素
		for(itr=min;itr!=QueueL.end();++itr)				//遍历寻找最小值元素
		{	
			if((*itr)<(*min))
			{
				min=itr;									//指向当前最小元素
			}
		}
		T item=*min;									//存储最小元素
		QueueL.erase(min);								//删除最小元素结点
		return item; 
	}
	void clear()												//清空
	{ QueueL.clear(); }
};



#endif

//main。cpp文件
//#include"simulation.h"
int main()
{
	Simulation S;
	S.RunSimulation();
	S.PrintSimulationResults();
	return(0);
}
