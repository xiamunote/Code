
//simulation.hͷ�ļ�
//#ifndef SIMULATION_H
//#define SIMULATION_H

#include<iostream>
#include"Queue.h"					//������ģ��
#include<stdlib.h>
#include<conio.h>
#include<iomanip>				//������������
#include<Vector>
#include"PQueue.h"
using namespace std;

class Event					//�¼�����
{
	int time;			//�¼�����ʱ��
	int etype;			//�¼����ͣ�0��ʾ���1��2��3��4...��ʾ�Ӽ��Ŵ����뿪
public:
	Event():time(0),etype(0){}
	Event(int t,int e):time(t),etype(e){}
	operator int()const{return(time);}			//��Աת������
	int GetTime()const{return(time);}			//��ȡ�¼�����ʱ��
	int GetEventType()const{return(etype);}

};
struct Service					//�Ŷӿͻ���Ϣ�ṹ
{
	int arrivalTime;			//�ͻ�����ʱ��
	int serviceTime;			//����ҵ��ʱ��
};

struct TellerStats
{
	int totalCustomer;			//�Ӵ��ͻ�����
	int totalService;			//����ʱ������
	int totalWait;				//�ͻ��ȴ�ʱ������
};

class Simulation
{
	int SimulationLength;					//ģ��ʱ�䳤��
	int numTellers;							//���񴰿ڸ���
	int arrivalLow,arrivalHigh;				//�ͻ��������̺��ʱ����
	int serviceLow,serviceHigh;				//�ͻ���̺���ķ���ʱ��
	TellerStats t[11];						//���10�����ڣ�TellerStats t[1]~TellerStats t[10]
	Queue<Service> Q[11];					//���10�����ڶ��У�Q[1]~Q[10]
	PQueue<Event> PQ;				//�����ȼ�������Ϊ�¼���
	int GetIntertime()						//��ȡ�ͻ������ʱ����
	{		//ȡֵ��ΧΪ[arrivalLow,arrivalHigh]
		return(arrivalLow+rand()%(arrivalHigh-arrivalLow+1));
	}			
	int GetServiceTime()					//��ȡ����ʱ��
	{		//ȡֵ��ΧΪ[serviceLow,serviceHigh]
		return(serviceLow+rand()%(serviceHigh-serviceLow+1));
	}
	int GetNextTeller();					//ȡ��һ�����ô���
	void Arrived(const Event& e);			//����һ���ͻ������¼�
	void Daparture(const Event& e);			//����һ���ͻ��뿪�¼�
	void PrintPQueue();						//��ʾ�¼���
	void PrintQueue();						//��ʾ���ڶ���
public:
	Simulation();							//ģ����̳�ʼ��
	Simulation(int L,int nT,int aL,int aH,int sL, int sH);
	void RunSimulation();					//ִ��ģ��
	void PrintSimulationResults();			//��ʾģ����
};

Simulation::Simulation()					//ģ����̳�ʼ��
{
	cout<<"Enter the simulation time in minutes:";			//���ն˶�ȡ����
	cin>>SimulationLength;
	cout<<"Enter the number of tellers(2~10):";
	cin>>numTellers;
	cout<<"Enter the range of arrival times in minutes:";
	cin>>arrivalLow>>arrivalHigh;
	cout<<"Enter the range of service times in minutes:";
	cin>>serviceLow>>serviceHigh;
	for(int i=1;i<=numTellers;i++)							//������Ϣ��ʼ��
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push(Event(0,0));									//һ���ͻ���0ʱ����
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

int Simulation::GetNextTeller()							//ȡ��һ�����ô���
{
	int i,size=Q[1].Size(),min=1;
	vector<int> v;
	for(i=2;i<=numTellers;i++)
		if(Q[i].Size()<size)
		{
			size=Q[i].Size();
			min=i;
		}
	//��1������Ŀͻ����������ٵļ������������ѡ��һ���Ŷ�
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
void Simulation::Arrived(const Event& e)				//����һ���ͻ������¼�
{
	Service s;
	int next,i;
	s.arrivalTime=e.GetTime();							//�ͻ�����ʱ��
	s.serviceTime=GetServiceTime();						//�ͻ�����ʱ��
    i=GetNextTeller();									//ȡ��һ�����ô��ڶ���
	Q[i].Push(s);										//�������Ŷ�
	if(Q[i].Size()==1)									//����������շ����������뿪�¼�
		PQ.Push(Event(s.arrivalTime+s.serviceTime,i));	
	next=e.GetTime()+GetIntertime();					//������һ���ͻ�����ʱ��
	if(next<SimulationLength)							//��һ���ͻ�����ʱ��С�ڹ���ʱ��
		PQ.Push(Event(next,0));
	cout<<"ServiceTime NextTeller next\n";				//��ʾ�������
	cout<<setw(5)<<s.serviceTime;						//�������Ϊ5��Ĭ��Ϊ�Ҷ���
	cout<<setw(12)<<i;
	cout<<setw(8)<<next<<endl;
}
//Service Time NextTeller next
//     7            1        5
void Simulation::Daparture(const Event& e)				//����һ���ͻ��뿪���¼�
{
	int i=e.GetEventType(),size;						//ȷ���뿪�Ĵ���
	Service s=Q[i].Pop();								//�Ӵ��ڶ�����ɾ��һ������
	size=Q[i].Size();
	t[i].totalCustomer++;								//�޸Ĵ��ڵ���Ϣ��¼
	t[i].totalService+=s.serviceTime;
	t[i].totalWait+=e.GetTime()-s.arrivalTime;
	//��2��һ���ͻ��Ӵ����뿪�����������ڵ������ȸô��ڵ�������2����ô���������ڶ��У���һ���ʹӶ�β�뿪���ŵ��ô���			
	for(int j=1;j<=numTellers;j++)														
	{
		if(Q[j].Size()-size==2)
		{
			s=Q[j].Pop_back();
			Q[i].Push(s);
		}
	}
	if(!Q[i].Empty())									//�����ڶ��в��գ���������һ�ͻ��뿪�¼����������¼���
	{
		s=Q[i].Front();
		PQ.Push(Event(e.GetTime()+s.serviceTime,i));
	}
	
	
	
}

void Simulation::PrintPQueue()					//��ʾ�¼���
{
	int n=PQ.Size();							//��¼�¼�����
	int i=0;									
	Event e,*p=new Event[n];					//������̬����
	cout<<"*****EventQueue*****\n";
	while(!PQ.Empty())							
	{
		e=PQ.Pop();							//ȡ���¼���һԪ�����
		cout<<'('<<e.GetTime()<<" "<<e.GetEventType()<<')';		//�������Ԫ��
		p[i++]=e;								//���¼������Ԫ�ر��浽����
	}
	for(i=0;i<n;i++)							//��������Ԫ�ز��뵽�¼���
		PQ.Push(p[i]);
	cout<<endl;
	delete[]p;
}
void Simulation::PrintQueue()					//��ʾ���ڶ���
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
void Simulation::RunSimulation()				//ִ��ģ��
{
	Event e;
	PrintPQueue();								//��ʾ�¼�����
	PrintQueue();								//��ʾ�ŶӴ���
	cout<<endl;									//Ϊ����ʾ�������һ��
	getch();									//�������������ͷ�ļ�conio.h
	while(!PQ.Empty())
	{
		e=PQ.Pop();
		if(e.GetEventType()==0)					//����ǵ����¼�
		{
			Arrived(e);							//�������¼�
			PrintPQueue();						//��ʾ�¼�����
			PrintQueue();						//��ʾ���ڶ���
			cout<<endl;
		}
		else									//����ǵ����¼�
		{						
			Daparture(e);						//�����뿪�¼�
			PrintPQueue();						//��ʾ�¼�����
			PrintQueue();						//��ʾ�ŶӴ���
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

//Queue.hͷ�ļ�
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
	bool Empty()												//��
	{ return QueueL.empty(); }								
	const T& Front()const										//�п�
	{ return QueueL.front(); }
	void Push(const T& item)									//���
	{ QueueL.push_back(item); }
	T Pop()														//����
	{ T item = QueueL.front(); 
	QueueL.pop_front(); return item; }
	T Pop_back()												//ɾ����βԪ��
	{
		T item = QueueL.back();
		QueueL.pop_back();
		return item;
	}
	void clear()												//���
	{ QueueL.clear(); }
};

#endif


//pQueue.hͷ�ļ�
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
	bool Empty()												//��
	{ return QueueL.empty(); }								
	const T& Front()const										//�п�
	{ return QueueL.front(); }
	void Push(const T& item)									//���
	{ QueueL.push_back(item); }
	T Pop()														//����
	{ 	
		list<T>::iterator itr,min=QueueL.begin();			//�������ָ��������Ԫ��
		for(itr=min;itr!=QueueL.end();++itr)				//����Ѱ����СֵԪ��
		{	
			if((*itr)<(*min))
			{
				min=itr;									//ָ��ǰ��СԪ��
			}
		}
		T item=*min;									//�洢��СԪ��
		QueueL.erase(min);								//ɾ����СԪ�ؽ��
		return item; 
	}
	void clear()												//���
	{ QueueL.clear(); }
};



#endif

//main��cpp�ļ�
//#include"simulation.h"
int main()
{
	Simulation S;
	S.RunSimulation();
	S.PrintSimulationResults();
	return(0);
}
