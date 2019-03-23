#include<iostream.h>
class base
{
public:
	virtual void who()
	{cout<<"base class"<<endl;}
};
class derive1:public base
{
public:
	void who()
	{cout<<"derive1 class"<<endl;}	

};
class derive2:public base
{
public:
	void who()
	{cout<<"derive2 class"<<endl;}	

};
int main()
{
	base obj1,*p;
	derive1 obj2;
	derive2 obj3;
	p=&obj1;
	p->who();
	p=&obj2;
	p->who();
	p=&obj3;
	p->who();
	return 0;

}