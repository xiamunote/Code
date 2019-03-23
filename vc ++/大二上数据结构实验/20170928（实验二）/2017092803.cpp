#include<stdio.h>
#include"vector.h"
template<class T>
void Display(Vector<Vector<T> >& L)
{
	Vector<Vector<T> >::iterator first=L.Begin(),last=L.End();
	for(;first!=last;++first)
	{
		Vector<T>::iterator f=(*first).Begin(),l=(*first).End();
		for(;f!=l;++f)
			cout<<*f;
		cout<<endl;
	}
}

template<class T>
void Power(Vector<Vector<T> >& outL,Vector<T> &sL,Vector<T> &pL,int pos)
{
	if(sL.Size()==0)
		return;
	if(pos==sL.Size())
	{
		outL.Push_back(pL);
		return;
	}
	pL.Push_back(sL[pos]);
	Power(outL,sL,pL,pos+1);
	pL.Pop_back();
	Power(outL,sL,pL,pos+1);

}

int main()
{
	Vector<char>sL,pL;
	sL.Push_back('a');
	sL.Push_back('b');
	sL.Push_back('c');
	Vector<Vector<char> >outL;
	Power(outL,sL,pL,0);
	Display(outL);
	return(0);
}