#include<iostream.h>
#include"queue.h"


typedef T int ;

template<class T>
int Partition(T* pa,int low,int high)
{
	int i=low,j=high;
	T temp=pa[i];
	while(i!=j)
	{
		while(pa[j]>=temp&&j>i)
			j--;
		if(j>i)
			pa[i++]=pa[j];
		while(pa[i]<=temp&&i<j)
			i++;
		if(i<j)
			pa[j--]=pa[i];
	}
	pa[i]=temp;
	return(i);
}

template<class T>
void SimQuickSort(T*pa,int low,int high)
{
	if(low>=high)
		return;
	for(;low<high;high--,low++)
		int m=Partition(pa,low,high)
}

int main()
{
	T pa[10];
	cout<<"请输入10个整数："<<endl;
	for(i=0;i<10;i++)
		cin>>a[i];
	SimQuickSort(pa,0,9);
	return 0;

}