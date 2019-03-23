//第二节 快速排序 Partition,QuickSort
#include<iostream.h>
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

template <class T>
void QuickSort(T* pa,int low,int high)
{
	if(low>=high)
		return;
	int m=Partition(pa,low,high);
	QuickSort(pa,low,m-1);
	QuickSort(pa,m+1,high);
}

template <class T>
void QuickSort(T*pa,int n)
{
	QuickSort(pa,0,n-1);
}

int main()
{
	int a[10]={3,2,1,6,5,4,9,8,11,7};
	QuickSort(a,10);
	for(int i=0;i<10;i++)
		cout<<a[i]<<' ';
	cout<<endl;
	int b[10];
	cout<<"请输入十个整数："<<endl;
	for(int n=0;n<10;n++)
		cin>>b[n];
	QuickSort(b,10);
	for(int m=0;m<10;m++)
		cout<<b[m]<<' ';
	cout<<endl;
	return 0;

}