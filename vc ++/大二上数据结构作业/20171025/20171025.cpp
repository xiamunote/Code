//�ö�����,���������ߴ�n����Ʒ����ѡ���ܼ�ֵ���Ŷ�������������
#include<iostream.h>
void readdata(); 
void search(int); 
void checkmax(); 
void printresult(); 
int c=35, n=10; //c�� ����������n����Ʒ�� 
int w[10], v[10]; //w[i]��v[i]����i����Ʒ�������ͼ�ֵ 
int a[10], max; //a�����ŵ�ǰ�����Ʒѡȡ�����max����¼����ֵ 
//a[i]=0��ʾ��ѡ��i����Ʒ��a[i]=1��ʾѡ��i����Ʒ 
int main() 
{ 
	readdata(); //�������� search(0); //�ݹ����� 
	printresult(); 
	return 0;
} 
void search(int m) 
{ 
	if(m>=n) 
		checkmax(); //��鵱ǰ���Ƿ��ǿ��н⣬����������ļ�ֵ��max�Ƚ� 
	else 
	{ 
		a[m]=0; //��ѡ��m����Ʒ 
		search(m+1); //�ݹ�������һ����Ʒ 
		a[m]=1; //��ѡ��m����Ʒ 
		search(m+1); //�ݹ�������һ����Ʒ 
	} 
} 
void checkmax() 
{ 
	int i, weight=0, value=0; 
	for(i=0;i<n;i++)
	{ 
		if(a[i]==1) //���ѡȡ�˸���Ʒ 
		{ 
			weight = weight + w[i]; //�ۼ����� 
			value = value + v[i]; //�ۼӼ�ֵ 
		} 
	} 
	if(weight<=c) //��Ϊ���н� 
		if(value>max) //�Ҽ�ֵ����max 
			max=value; //�滻max 
} 
void readdata() 
{ 
	int i; 
	for(i=0;i<n;i++) 
		cin>>w[i]>>v[i];//�����i����Ʒ�����ͼ�ֵ 
} 
void printresult() 
{ 
	cout<<max<<endl; 
} 