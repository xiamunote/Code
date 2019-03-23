#ifndef DISPLAY_H
#define DISPLAY_H

template<class Iterator>
void Display(Iterator first,Iterator last) 
{
	for(;first!=last;++first)
		cout<<*first<<' ';
	cout<<endl;
}
template<class T>
void primDisplay(const Graph<T>& g,PathData E[],int ne)//��ʾ����ķ�㷨���
{
	T v1,v2;
	for(int i=ne-1;i>-1;i--)
	{
		g.FindNode(v1,E[i].start);
		g.FindNode(v2,E[i].dest);
		cout<<'('<<v1<<','<<v2<<','<<E[i].cost<<')'<<" ";
	}
	cout<<endl;
}
template<class T>
void kruskalDisplay(const Graph<T>& g,PathData E[],int ne)
{
	T v1,v2;
	for(int i=0;i<ne;i++)
	{
		g.FindNode(v1,E[i].start);
		g.FindNode(v2,E[i].dest);
		cout<<'('<<v1<<','<<v2<<','<<E[i].cost<<')'<<" ";
	}
	cout<<endl;
}
template<class T> 
void dijkstraDisplay(const Graph<T>& G,double D[],int P[],int n) 
{
	T v;
	int parent,i,j,*stack=new int[n],size;
	for(i=0;i<n;i++)
		if(D[i])		
		{
			cout<<D[i]<<": ";
			size=0;			//���ջ
			stack[size++]=i;	//���յ�ѹջ
			parent=P[i];		//ȡ����Vi��·���ϵ�ǰһ������
			while(parent!=-1)
			{
				stack[size++]=parent;
				parent=P[parent];	//ȡǰ������
			}
			for(j=size-1;j>-1;j--)	//��ջ����ʼ�㿪ʼ���
			{
				G.FindNode(v,stack[j]);
				cout<<v;
				if(j>0)			//�������·���յ�
					cout<<"->";
			}
			cout<<endl;
		}
	delete[]stack;
}

template<class T>//���ݶ�����������ٷ���ʱ�����ÿһ�������ʱ
void criticalDisplay(const Graph<T>& G,const double VE[],const double VL[],int nv) 
{
	T vj,vi;
	for(int j=0;j<nv;j++)
		for(int i=0;i<nv;i++)
		{
			G.FindNode(vi,i);
			G.FindNode(vj,j);
			if(G.GetCost(vi,vj)!=0)
				cout<<'<'<<vi<<','<<vj<<'>'
				<<"-----"<<VL[j]-VE[i]-G.GetCost(vi,vj)<<endl;
		}
}

#endif
