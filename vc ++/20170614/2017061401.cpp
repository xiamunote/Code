#include<iostream> 
using namespace std;
int main()
{
	int inputN;
	int outputN=0;
	cout<<"input an integer:"<<endl;
	cin>>inputN;
	while(inputN!=0)
	{
		outputN=outputN*10+inputN%10;
		inputN=inputN/10;
		
	}
	cout<<outputN<<endl<<inputN<<endl;
	return 0;
}
