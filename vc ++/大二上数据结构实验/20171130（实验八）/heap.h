//小根堆Heap类
#include<iostream.h>
#include"vector.h"

template<class T>
class Heap
{
Vector<T> vec;
int size;
void BuildHeap(void);
void PercolateDown(int h);
void PercolateUp();
public:
explicit Heap(int max=100):vec(max),size(0){}
explicit Heap(const Vector<T>& vt);
bool Empty(void)const{return(size==0);}
int Size(void){return(size);}
void Insert(const T&item);
const T& Top(void)const{return(vec[0]);}
void DeleteMin(void);
void DeleteMin(T& item);
void Clear(void){size=0;}
};

//向下起泡排序
template<class T>
void Heap<T>::PercolateDown(int h)
{
int p=h,c=2*p+1;
T temp=vec[p];
while(c<size)
{
if(c+1<size&&vec[c+1]<vec[c])
++c;
if(temp<=vec[c])
break;
else
	{
	vec[p]=vec[c];
	p=c;
	c=2*p+1;
	}
}
vec[p]=temp;
}

//堆删除的两个算法
template<class T>
void Heap<T>::DeleteMin(void)
{
if(size==0)
	{cout<<"Heap empty!";exit(1);}
vec[0]=vec[size-1];
size--;
PercolateDown(0);
}

template<class T>
void Heap<T>::DeleteMin(T& item)
{
if(size==0)
	{cout<<"Heap empty!";exit(1);}
item=vec[0];
vec[0]=vec[size-1];
size--;
PercolateDown(0);
}

//向上起泡排序
template<class T>
void Heap<T>::PercolateUp()
{
int c=size-1,p=(c-1)/2;
T temp=vec[c];
while(c>0)
{
if(vec[p]<=temp)
break;
else
	{
	vec[c]=vec[p];
	c=p;
	p=(c-1)/2;
	}
vec[c]=temp;
}
}

//堆插入算法
template<class T>
void Heap<T>::Insert(const T& item)
{
if(size==vec.Size())
	vec.Resize(vec.Size()*2);
vec[size]=item;
size++;
PercolateUp();
}

//构造函数
template<class T>
Heap<T>::Heap(const Vector<T>& vt):vec(vt.Size()+10),size(vt.Size())
{
for(int i=0;i<size;++i)
vec[i]=vt[i];
BuildHeap();
}

//把向量类调整为堆
template<class T>
void Heap<T>::BuildHeap(void)
{
for(int i=size/2-1;i>=0;i--)
PercolateDown(i);
}