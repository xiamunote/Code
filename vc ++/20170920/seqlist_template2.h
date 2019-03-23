#include<stdlib.h>
#include<iostream.h>
template<class T>
class SeqList 
{	
private:   //私有
	T *data;	
	int size; 
    int max;
public:	//公有
//构造函数和析构函数
	SeqList(int n=100);     	//构造
	SeqList(const SeqList& l);  //复制构造
     ~ SeqList(){delete[]data;} 	//析构
//用于修改的成员函数
	SeqList& operator=(const SeqList& l);//复制赋值
	void InsertRear(const T& item);
	void Insert(T *itr,const T& item);
	void Erase(T *itr); 
	void Clear(){size=0;}
	T& operator[](int id);
	const T& operator[](int id)const;
//用于读取的成员函数
    const T& Getdata(int id)const;	
	int Size()const{return size;}		
	int Empty()const{return size==0;}
	int Full()const{return size==max;}
	T * Begin(){return data;}
	const T * Begin()const{return data;}
	T * End(){return data+size;}
	const T * End()const{return data+size;}	
};
template<class T> 
SeqList<T>::SeqList(int n)  
{	
	data=new T[n];    
	if(data==NULL)
	{
		cout<<"Memmory allocation error\n";	//错误类型
		exit(1);        					//停止程序运行
	}
	size=0;
	max=n;
}
template<class T> 
SeqList<T>::SeqList(const SeqList& l)
{
	data=new T[l.max]; 	// this->data=new Type[l.max];
	if(data==NULL)
	{
		cout<<"Memmory allocation error\n";	//错误类型提示
		exit(1);        					//停止程序运行
	}
	for(int i=0;i<l.size;i++)
		data[i]=l.data[i];	
	size=l.size;			
	max=l.max;			
}
template<class T>
SeqList<T>& SeqList<T>::operator=(const SeqList& l)
{
	if(max!=l.max)							//如果数组容量不同
	{
		delete[]data;
		data=new T[l.max];
		if(data==NULL)
		{
			cout<<"Memmory allocation error\n";	//错误类型提示
			exit(1);        					//停止程序运行
		}
	}
	for(int i=0;i<l.size;i++)
		data[i]=l.data[i]; 
	size=l.size;
	max=l.max;
	return *this;             
}
template<class T> 
void SeqList<T>::InsertRear(const T& item)
{	
	if(size==max)
	{
		cout<<"InsertRear: list is full！\n";//错误类型提示
		exit(1);        				//停止程序运行
	}
	data[size]=item;
	size++;
}
template<class T> 
void SeqList<T>::Insert(T *itr,const T& item) //基于指针插入
{	//把元素item插入到指针itr指向的位置
	for(T *p=data+size,*q=data+size-1;p!=itr;--p,--q)
	*p=*q;
	*itr=item;				//插入元素到指定位置
	size++;					//数据个数加1			
}
template<class T> 
void SeqList<T>::Erase(T *itr)
{	//删除指针itr指向的元素
	for(T *p=itr,*q=itr+1;p!=data+size;++p,++q)
	*p=*q;
	size--;	
}

template<class T>
T& SeqList<T>::operator[](int id)	//下标操作符重载
{
	if(id<0||id>size-1)
	{
		cout<<"operator[]:id is illegal！\n";	//错误类型提示
		exit(1);        						//停止程序运行
	}
	return data[id];
}
template<class T>
const T& SeqList<T>::operator[](int id)const//常量型下标操作符重载
{
	if(id<0||id>size-1)
	{
		cout<<"operator[]:id is illegal！\n";	//错误类型提示
		exit(1);        						//停止程序运行
	}
	return  data[id];
}
template<class T> 
const T& SeqList<T>::Getdata(int id)const  
{	
	if(id<0||id>size-1)						
	{
		cout<<"Getdata: id is illegal or list is empty！\n"; //错误类型提示
		exit(1);        							//停止程序运行
	}
	return data[id];							
}
