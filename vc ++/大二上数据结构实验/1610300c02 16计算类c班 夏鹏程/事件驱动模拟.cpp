//模 拟 类 型 声 明 (simulation. h) ：
#include<iostream.h> 
#include<conio.h>
#include<iomanip.h>
#include"PQueue.h"						// 优 先 级 队 列 类 模 板 
#include"Queue.h"						//队列类模版

class Event								//事件类型
{
	int time;							//事件发生时间
	int etype;							//事件类型：0表示到达，1，2，3，4....表示从几号窗口开始
public:
	Event():time(0),etype(0){}
	Event(int t,int e):time(t),etype(e){}
	operator int()const{return(time);}		//成员转换函数
	int GetTime()const{return(time);}		//读取事件发生时间
	int GetEventType()const{return(etype);}		//读取事件类型
};

struct Service									//排队客户信息结构
{
	int arrivalTime;						//客户到达时间
	int serviceTime;						//办理事务时间
};

struct TellerStats							//窗口信息结构
{
	int totalCustomer;						//接待客户总数
	int totalService;						//服务时间总数
	int totalWait;							//客户等待时间总数
};

class Simulation
{ 
	int SimulationLength;				// 模 拟 时 间 长 度 
	int numTellers;						// 服 务 窗 口 个 数 
	int arrivalLow, arrivalHigh;		// 客 户 到 达 的 最 短 和 最 长 时 间 间 隔
	int serviceLow, serviceHigh;		// 客 户 最 短 和 最 长 的 服 务 时 间 
	TellerStats t[11];					// 最 多 10 个 窗 口 TellerStats t[1]~Tellerstats t[10]
	Queue<Service>Q[11];				// 最 多 10 个 窗 口 队 列 ，Q[1]~Q[10]
	PQueue<Event>PQ;					// 用 优 先 级 队 列 作 为 事 件 表  
	int GetIntertime()					// 读 取 客 户 到 达 的 时 间 间 隔 
	{return(arrivalLow+rand()% (arrivalHigh-arrivalLow+1));}
	int GetServiceTime()				// 读 取 服 务 时 间 
	{return(serviceLow+rand()% (serviceHigh-serviceLow+1));} 
	int GetNextTeller();				// 取 下 一 个 可 用 窗 口 
	void Arrived (const Event& e);		// 处 理 一 个 客 户 到 达 事 件 
	void Daparture (const Event& e);	// 处 理 一 个 客 户 离 开 事 件 
	void PrintPQueue();					// 显 示 事 件 表 
	void PrintQueue();
public:
	Simulation();						// 模 拟 过 程 初 始 化  
	Simulation(int L,int nT,int aL,int aH,int sL,int sH);
	void RunSimulation();				// 执 行 模 拟  
	void PrintSimulationResults();		// 显 示 模 拟 结 果
};
//模 拟 类 型 Simulation 实 现  
Simulation::Simulation()				// 模 拟 过 程 初 始 化 
{
	cout<<"input the simulation time in minutes:";		// 从 终 端 读 取 数 据 
	cin>>SimulationLength;
	cout<<"input the number of tellers (2~10):";
	cin>>numTellers;
	cout<<"input the range of arrival times in minutes:";
	cin>>arrivalLow>>arrivalHigh;
	cout<<"input the range of service times in minutes:";
	cin>>serviceLow>>serviceHigh;
	for(int i=1;i<=numTellers;++i)						// 窗 口 信 息 初 始 化
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push(Event(0,0));								// 一 个 客 户 于 0 时 到 达 
} 

Simulation::Simulation (int L,int nT, int aL, int aH, int sL, int sH)
{
	SimulationLength=L;
	numTellers=nT;
	arrivalLow=aL;
	arrivalHigh=aH;
	serviceLow=sL;
	serviceHigh=sH;
	for(int i=1;i<numTellers;++i)						// 窗 口 信 息 初 始 化
	{
		t[i].totalCustomer=0;
		t[i].totalService=0;
		t[i].totalWait=0;
	}
	PQ.Push (Event(0,0));								// 一 个 客 户 于 0 时 到 达


}

int Simulation::GetNextTeller()							//计 算 下 一 个 可 用 窗 口
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

void Simulation::Arrived (const Event& e)				//处 理 一 个 客 户 到 达 事 件
{
	Service s;
	int next,i;
	s.arrivalTime=e.GetTime();							// 客 户 到 达 时 间
	s.serviceTime=GetServiceTime();						// 客 户 服 务 时 间 
	i=GetNextTeller();									// 取 下 一 个 可 用 窗 口
	Q[i].Push(s);										// 到 窗 口 排 队
	if(Q[i].Size()==1)									// 若 立 即 接 受 服 务 ， 则 生 成 离 开 事 件
		PQ.Push(Event(s.arrivalTime+s.serviceTime,i));
	next=GetIntertime()+e.GetTime();					// 计 算 下 一 客 户 到 达 时 间 
	if(next<SimulationLength)							// 下 一 客 户 到 达 时 间 小 于 关 门 时 间					
		PQ.Push(Event(next,0));
	cout<<"ServiceTime NextTeller next"<<endl;			// 显 示 随 机 数 据 
	cout<<setw(5)<<s.serviceTime;
	cout<<setw(12)<<i;
	cout<<setw(8)<<next<<endl;
} 

void Simulation::Daparture (const Event& e)				// 处 理 一 个 客 户 离 开 事 件 
{ 
	int i=e.GetEventType();								// 确 定 离 开 的 窗 口
	Service s=Q[i].Pop();								// 从 窗 口 队 列 中 删 除 一 个 记 录
	t[i].totalCustomer++;								// 修 改 窗 口 的 信 息 记 录 
	t[i].totalService+=s.serviceTime;
	t[i].totalWait+=e.GetTime()-s.arrivalTime;
	if(!Q[i].Empty())									// 若窗口队列不空,则计算出下一客户离开事件,并插人事件表 
	{
		s=Q[i].Front();
		PQ.Push(Event(e.GetTime()+s.serviceTime,i));
	}
}
 
void Simulation::PrintPQueue()							// 显 示 事 件 表 
{
	int n=PQ.Size();									// 记 录 事 件 表 长 度
	int i=0;
	Event e,* p=new Event[n];							// 建 立 动 态 数 组
	cout<<"* * * * EventQueue* * * * "<<endl;			
	while(!PQ.Empty())
	{
		e=PQ.Pop();										// 取 出 事 件 表 一 元 素 输 出
		cout<<'('<<e.GetTime()<<" "<<e.GetEventType()<<')';		// 输 出 队 列 元 素
		cout<<setw(4);
		p[i++]=e;										// 把 事 件 表 出 队 元 素 保 存 到 数 组
	}
	for(i=0;i<n;++i)									// 把 数 组 中 的 元 素 插 人 事 件 表
		PQ.Push(p[i]);
	cout<<endl;
	delete[]p;
} 
 
void Simulation::PrintQueue()							// 显 示 窗 口 队 列
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
 
void Simulation::RunSimulation()						// 执 行 模 拟
{
	Event e;
	PrintPQueue();										// 显 示 事 件 队 列
	PrintQueue();										// 显 示 排 队 窗 口
	cout<<endl;											// 为 了 显 示 清 楚 而 空 一 行
	getch();											// 按 任 意 键 继 续 ， 头 文 件 conio.h
	while(!PQ.Empty())
	{
		e=PQ.Pop();
		if(e.GetEventType()==0)							// 如 果 是 到 达 事 件
		{
			Arrived(e);									// 处 理 到 达 事 件 
			PrintPQueue();								// 显 示 事 件 队 列
			PrintQueue();								// 显 示 排 队 窗 口
			cout<<endl;
		}
		else											// 如 果 是 离 开 事 件 
		{
			Daparture(e);								// 处 理 离 开 事 件
			PrintPQueue();								// 显 示 事 件 队 列
			PrintQueue();								// 显 示 排 队 窗 口
			cout<<endl;									// 为 了 显 示 清 楚 而 空 一 行
		}
		getch();										// 按 任 意 键 继 续 ， 头 文 件 conio.h
	}
} 
 
void Simulation::PrintSimulationResults()				// 显 示 模 拟 结 果
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

//事 件 模 拟 。 

int main()
{	
	Simulation S;					//Simulation S (20 ， 2 ， 3 ， 5 ， 6 ， 10);
	S.RunSimulation(); 
	S.PrintSimulationResults(); 
	return 0; 
}

