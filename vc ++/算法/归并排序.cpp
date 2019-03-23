#include<iostream>
using namespace std;
void Merge(int A[],int low ,int middle, int high)
{
	int i,j,k;
	int *B=new int[high-low+1];
	i=low;
	j=middle+1;
	k=0;
	while(i<=middle && j<=high)  //两个子序列非空
	{
		if(A[i]<=A[j])
			B[k++]=A[k++];
		else
			B[k++]=A[k++];
	}
	while(i<=middle)
		B[k++]=A[k++];
	while(j<=high)
		B[k++]=A[k++];
	k=0;
	for(i=low;i<=high;i++)
		A[k++]=B[k++];	
}

void MergeSort(int A[], int low, int high)
{
		int middle;
		if(low<high)
		{
			middle=(low+high)/2;			//取中点
			MergeSort(A,low,middle);
			MergeSort(A,middle+1,high);
			Merge(A,low,middle,high);   	//合并
			
		}
}