//散列表类HashTable.h
//分离链接法
#include<iostream.h>
#include<iomanip.h>
#include"List.h"
#include"vector.h"

template<class Iterator,class T>
Iterator Find(Iterator first,Iterator last,const T& x)
{
while(first!=last&&*first!=x)
++first;
return(first);
}

template<class T>
class HashTable
{
private:
int nt;
Vector<List<T> > ht;
int size;
int (*hf)(const T& x);

public:
explicit HashTable(int n,int (*hash)(const T& x)):nt(n),hf(hash),size(0){ht.Resize(n);}
bool Insert(const T& x);
bool Remove(const T& x);
bool Find(const T& x)const;
int Size(void)const{return(size);}
int Empty(void)const{return(size==0);}
int NumberOfBucket(void)const{return(nt);}
friend ostream& operator<<(ostream& ostr,const HashTable<T>& ht);
};
//散列表类的实现
template<class T>
bool HashTable<T>::Insert(const T& x)
{
List<T>& L=ht[hf(x)];
if(::Find(L.Begin(),L.End(),x)!=L.End())
return(0);
L.Push_back(x);
size++;
return(1);
}

template<class T>
bool HashTable<T>::Remove(const T& x)
{
List<T>& L=ht[hf(x)];
List<T>::iterator itr=::Find(L.Begin(),L.End(),x);

if(itr==L.End())
return(0);
L.Erase(itr);
size--;
return(1);
}

template<class T>
bool HashTable<T>::Find(const T& x)const
{
const List<T>& L=ht[hf(x)];
if(::Find(L.Begin(),L.End(),x)!=L.End())
return(1);
return(0);
}

template<class T>
ostream& operator<<(ostream& ostr,const HashTable<T>& ht)
{
int n=ht.NumberOfBucket();
List<T>::const_iterator first,last;
for(int i=0;i<n;i++)
{
first=ht.ht[i].Begin(),last=ht.ht[i].End();
for(;first!=last;++first)
cout<<setw(4)<<*first<<' ';
cout<<endl;
}
return(ostr);
}






















	



	


	
