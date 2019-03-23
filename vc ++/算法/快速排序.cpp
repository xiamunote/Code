#include<iostream>
using namespace std;

int Partition1(int low,int high)		//划分序列的算法1 
{
	int i,j,temp;
	int pivot=S[low];
	for(j=low,i=low+1;i<=high;i++)
	{
		if(pivot>S[i]])
		{
			j++;
			temp=S[i];
			S[i]=S[j];
			S[j]=temp;
		}
		temp=S[low];
		S[low]=S[j];
		S[j]=temp;
		return j;
	}
}

int Partition2(int low,int high)
{
	int i=low,j=high,pivot=S[low],temp;
	while(i<j)
	{
		while(i<j && S[j]>=pivot)
			j--;
		if(i<j)
		{
			temp=S[i];
			S[i]=S[j];
			S[j]=temp;
			i++;
		}
		while(i<j && S[i]<=pivot)
			i++;
		if(i<j)
		{
			temp=S[i];
			S[i]=S[j];
			S[j]=temp;
			j--;
		}	
	}
	return j;
}

void QuickSort(int R[],int low,int high)
{
	int pivotpos;
	if(low<high)
	{
		pivotpos=Partition1(R,low,high);
		QuickSort(R,low,pivotops-1);
		QuickSort(R,pivotops+1,high)； 
	}
}

