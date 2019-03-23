//ģ �� �� �� �� �� (simulation. h) ��
#include<iostream.h> 
#include<conio.h>
#include<iomanip.h>
#include"PQueue.h"						// �� �� �� �� �� �� ģ �� 
#include"Queue.h"						//������ģ��

class Event								//�¼�����
{
	int time;							//�¼�����ʱ��
	int etype;							//�¼����ͣ�0��ʾ���1��2��3��4....��ʾ�Ӽ��Ŵ��ڿ�ʼ
public:
	Event():time(0),etype(0){}
	Event(int t,int e):time(t),etype(e){}
	operator int()const{return(time);}		//��Աת������
	int GetTime()const{return(time);}		//��ȡ�¼�����ʱ��
	int GetEventType()const{return(etype);}		//��ȡ�¼�����
};

struct Service									//�Ŷӿͻ���Ϣ�ṹ
{
	int arrivalTime;						//�ͻ�����ʱ��
	int serviceTime;						//��������ʱ��
};

struct TellerStats							//������Ϣ�ṹ
{
	int totalCustomer;						//�Ӵ��ͻ�����
	int totalService;						//����ʱ������
	int totalWait;							//�ͻ��ȴ�ʱ������
};

class Simulation
{ 
	int SimulationLength;				// ģ �� ʱ �� �� �� 
	int numTellers;						// �� �� �� �� �� �� 
	int arrivalLow, arrivalHigh;		// �� �� �� �� �� �� �� �� �� �� ʱ �� �� ��
	int serviceLow, serviceHigh;		// �� �� �� �� �� �� �� �� �� �� ʱ �� 
	TellerStats t[11];					// �� �� 10 �� �� �� TellerStats t[1]~Tellerstats t[10]
	Queue<Service>Q[11];				// �� �� 10 �� �� �� �� �� ��Q[1]~Q[10]
	PQueue<Event>PQ;					// �� �� �� �� �� �� �� Ϊ �� �� ��  
	int GetIntertime()					// �� ȡ �� �� �� �� �� ʱ �� �� �� 
	{return(arrivalLow+rand()% (arrivalHigh-arrivalLow+1));}
	int GetServiceTime()				// �� ȡ �� �� ʱ �� 
	{return(serviceLow+rand()% (serviceHigh-serviceLow+1));} 
	int GetNextTeller();				// ȡ �� һ �� �� �� �� �� 
	void Arrived (const Event& e);		// �� �� һ �� �� �� �� �� �� �� 
	void Daparture (const Event& e);	// �� �� һ �� �� �� �� �� �� �� 
	void PrintPQueue();					// �� ʾ �� �� �� 
	void PrintQueue();
public:
	Simulation();						// ģ �� �� �� �� ʼ ��  
	Simulation(int L,int nT,int aL,int aH,int sL,int sH);
	void RunSimulation();				// ִ �� ģ ��  
	void PrintSimulationResults();		// �� ʾ ģ �� �� ��
};
//ģ �� �� �� Simulation ʵ ��  
Simulation::Simulation()				// ģ �� �� �� �� ʼ �� 
{
	cout<<"input the simulation time in minutes:";		// �� �� �� �� ȡ �� �� 
	cin>>SimulationLength;
	cout<<"input the number of tellers (2~10):";
	cin>>numTellers;
	cout<<"input the range of arrival times in minutes:";
	cin>>arrivalLow>>arrivalHigh;
	cout<<"input the range of service times in minutes:";
	cin>>serviceLow>>serviceHigh;
	for(int i=1;i<=numTellers;++i)						// �� �� �� Ϣ �� ʼ ��
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push(Event(0,0));								// һ �� �� �� �� 0 ʱ �� �� 
} 

Simulation::Simulation (int L,int nT, int aL, int aH, int sL, int sH)
{
	SimulationLength=L;
	numTellers=nT;
	arrivalLow=aL;
	arrivalHigh=aH;
	serviceLow=sL;
	serviceHigh=sH;
	for(int i=1;i<numTellers;++i)						// �� �� �� Ϣ �� ʼ ��
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push (Event(0,0));								// һ �� �� �� �� 0 ʱ �� ��


}

int Simulation::GetNextTeller()							//�� �� �� һ �� �� �� �� ��
{
	int i,size=Q[1].Size(),min=1;
	for(i=2;i<=numTellers;++i)
		if(Q[i].Size()<size)
	{
			size=Q[i].Size();
			min=i;
	}
		return min;
}

void Simulation::Arrived (const Event& e)				//�� �� һ �� �� �� �� �� �� ��
{
	Service s;
	int next,i;
	s.arrivalTime=e.GetTime();							// �� �� �� �� ʱ ��
	s.serviceTime=GetServiceTime();						// �� �� �� �� ʱ �� 
	i=GetNextTeller();									// ȡ �� һ �� �� �� �� ��
	Q[i].Push(s);										// �� �� �� �� ��
	if(Q[i].Size()==1)									// �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��
		PQ.Push(Event(s.arrivalTime+s.serviceTime,i));
	next=GetIntertime()+e.GetTime();					// �� �� �� һ �� �� �� �� ʱ �� 
	if(next<SimulationLength)							// �� һ �� �� �� �� ʱ �� С �� �� �� ʱ ��					
		PQ.Push(Event(next,0));
	cout<<"ServiceTime NextTeller next"<<endl;			// �� ʾ �� �� �� �� 
	cout<<setw(5)<<s.serviceTime;
	cout<<setw(12)<<i;
	cout<<setw(8)<<next<<endl;
} 

void Simulation::Daparture (const Event& e)				// �� �� һ �� �� �� �� �� �� �� 
{ 
	int i=e.GetEventType();								// ȷ �� �� �� �� �� ��
	Service s=Q[i].Pop();								// �� �� �� �� �� �� ɾ �� һ �� �� ¼
	t[i].totalCustomer++;								// �� �� �� �� �� �� Ϣ �� ¼ 
	t[i].totalService+=s.serviceTime;
	t[i].totalWait+=e.GetTime()-s.arrivalTime;
	if(!Q[i].Empty())									// �����ڶ��в���,��������һ�ͻ��뿪�¼�,�������¼��� 
	{
		s=Q[i].Front();
		PQ.Push(Event(e.GetTime()+s.serviceTime,i));
	}
}
 
void Simulation::PrintPQueue()							// �� ʾ �� �� �� 
{
	int n=PQ.Size();									// �� ¼ �� �� �� �� ��
	int i=0;
	Event e,* p=new Event[n];							// �� �� �� ̬ �� ��
	cout<<"* * * * EventQueue* * * * "<<endl;			
	while(!PQ.Empty())
	{
		e=PQ.Pop();										// ȡ �� �� �� �� һ Ԫ �� �� ��
		cout<<'('<<e.GetTime()<<" "<<e.GetEventType()<<')';		// �� �� �� �� Ԫ ��
		cout<<setw(4);
		p[i++]=e;										// �� �� �� �� �� �� Ԫ �� �� �� �� �� ��
	}
	for(i=0;i<n;++i)									// �� �� �� �� �� Ԫ �� �� �� �� �� ��
		PQ.Push(p[i]);
	cout<<endl;
	delete[]p;
} 
 
void Simulation::PrintQueue()							// �� ʾ �� �� �� ��
{
	int n;
	Service s;
	cout<<"* * * * Tellers * * * * "<<endl;
	for(int t=1;t<=numTellers;t++)
	{
		cout<<t<<":";
		n=Q[t].Size();
		for(int i=1;i<=n;++i)
		{
			s=Q[t].Pop();
			cout<<'('<<s.arrivalTime<<" "<<s.serviceTime<<')';
			cout<<setw(4);
			Q[t].Push(s);
		}
		cout<<endl;
	}

} 
 
void Simulation::RunSimulation()						// ִ �� ģ ��
{
	Event e;
	PrintPQueue();										// �� ʾ �� �� �� ��
	PrintQueue();										// �� ʾ �� �� �� ��
	cout<<endl;											// Ϊ �� �� ʾ �� �� �� �� һ ��
	getch();											// �� �� �� �� �� �� �� ͷ �� �� conio.h
	while(!PQ.Empty())
	{
		e=PQ.Pop();
		if(e.GetEventType()==0)							// �� �� �� �� �� �� ��
		{
			Arrived(e);									// �� �� �� �� �� �� 
			PrintPQueue();								// �� ʾ �� �� �� ��
			PrintQueue();								// �� ʾ �� �� �� ��
			cout<<endl;
		}
		else											// �� �� �� �� �� �� �� 
		{
			Daparture(e);								// �� �� �� �� �� ��
			PrintPQueue();								// �� ʾ �� �� �� ��
			PrintQueue();								// �� ʾ �� �� �� ��
			cout<<endl;									// Ϊ �� �� ʾ �� �� �� �� һ ��
		}
		getch();										// �� �� �� �� �� �� �� ͷ �� �� conio.h
	}
} 
 
void Simulation::PrintSimulationResults()				// �� ʾ ģ �� �� ��
{
	int i,totalCustomers=0,totalWait=0;
	for(i=1;i<numTellers;++i)
	{
		totalCustomers+=t[i].totalCustomer; 
		totalWait+=t[i].totalWait; 
	}
	cout<<totalCustomers<<endl;
	cout<<totalWait<<endl;
}

//�� �� ģ �� �� 

int main()
{	
	Simulation S;					//Simulation S (20 �� 2 �� 3 �� 5 �� 6 �� 10);
	S.RunSimulation(); 
	S.PrintSimulationResults(); 
	return 0; 
}

