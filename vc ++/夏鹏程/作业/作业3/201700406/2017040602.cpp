#include<iostream.h>
class Base
{
	char c;
public:
	Base(char n):c(n){}
	virtual ~Base(){cout<<c;}

};
class Derived:public Base
{
	char c;
public:
	Derived(char n):Base(n+1),c(n){}
	~Derived(){cout<<c;}
};
int main()
{
	Derived('X');
	return 0;
}