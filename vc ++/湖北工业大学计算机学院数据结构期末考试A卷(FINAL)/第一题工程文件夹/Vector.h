#ifndef VECTOR_H
#define VECTOR_H

#include<iostream.h>
#include<stdlib.h>

template<class T>
class Vector
{
private:
	T *data;						//数组指针
	int theSize;					//数组中的数据元素个数
	int theMax;						//数组容量
	void Error(const char* cs)const{cout<<cs<<endl;exit(1);}//错误信息报告
public:
	explicit Vector(int n=0):theSize(0),theMax(n+SPARE_MAX)
		{if(theMax>0) data=new T[theMax];}
	Vector(const Vector& v):data(NULL),theMax(0){operator=(v);}//拷贝构造函数
	~Vector(void){delete[]data;}
	Vector& operator=(const Vector<T>& v);		//拷贝赋值函数
	T& operator[](int id){return(data[id]);}	//下标运算符函数
	const T& operator[](int id)const{return(data[id]);}//常量型下标运算符函数
	bool Empty(void)const{return(theSize==0);}	//判空
	int Size(void)const{return(theSize);}		//求数据个数
	int Max(void)const{return(theMax);}			//求数组容量
	void Push_back(const T& item);				//尾插
	void Pop_back(void);						//尾删
	const T& Back(void)const;					//返回尾元素的引用
	const T& Front(void)const;					//返回起始元素的引用
	void Clear(void){theSize=0;}				//删除所有数据元素
	void Reserve(int newMax);					//扩大数组容量为newtheMax，保留原来数据
	void Resize(int newSize,const T& item=T());	//把数据个数增加为newtheSize，原来的数据保留，其余的值为item
	enum{SPARE_MAX=16};							//枚举常量表示数组最小长度
//迭代器类型
	typedef T* iterator;						//迭代器
	typedef const T* const_iterator;			//指向const常量的迭代器
	iterator begin(){return &data[0];}			//使迭代器指向容器起始位置
	const_iterator begin()const{return &data[0];}
	iterator end(){	return(&data[theSize]);}	//使迭代器指向容器结束位置
	const_iterator end()const{	return(&data[theSize]);}
	iterator Insert(iterator itr,const T& item);
	iterator Erase(iterator itr);
};

template<class T>
Vector<T>& Vector<T>::operator=(const Vector<T>& v)//拷贝赋值函数
{
	if(theMax!=v.Max())  
	{
		delete[]data;
		theMax=v.theMax;
		data=new T[theMax];
	}
	theSize=v.Size();
	for(int i=0;i<theSize;i++)
			data[i]=v.data[i];
	return(*this);
}
template<class T>
void Vector<T>::Push_back(const T& item)//尾插
{
	if(theSize==theMax)			//如果空间数据已满，就要先扩大容量
		Reserve(2*theMax+1);
	data[theSize++]=item;		//插入元素到尾部，数据个数增1
}

template<class T>				//模板参数表
Vector<T>::iterator				//返回值类型
Vector<T>::Erase(iterator itr)	//删除指示器指向的元素
{
	if(theSize==0)				//检查是否是空表			
		Error("Erase:an empty Vector!");		
	if(itr<begin()||itr>end()-1)//检查删除位置是否合法					
		Error("Erase: out of illegal!");
	for(iterator p=itr;p!=end();++p)
		*p=*(p+1);
	theSize--;
	return(itr);
}
template<class T>				//模板参数表
Vector<T>::iterator				//返回值类型
Vector<T>::Insert(iterator itr,const T& item)//把元素item插入到指示器指向的位置
{
	if(theSize==theMax)					
		Reserve(2*theMax+1);	//如果空间数据已满，就要先扩大容量
	if(itr<begin()||itr>end())	//检查插入位置是否合法
		Error("Insert:out of range");
	for(iterator p=end();p!=itr;--p)//从尾元素到插入位置上元素往后移动一个位置
		*p=*(p-1);
	*itr=item;					//插入元素到指定位置
	theSize++;					//数据个数增1
	return(itr);
}
template<class T>
void Vector<T>::Pop_back(void)	//尾删
{
	if(theSize==0)
		Error("Empty Vector!");
	theSize--;
}

template<class T>
const T& Vector<T>::Back(void)const//返回尾元素的引用
{
	if(theSize==0)
		Error("Empty Vector!");
	return(data[theSize-1]);
}
template<class T>
const T& Vector<T>::Front(void)const//返回起始元素的引用
{
	if(theSize==0)
		Error("Empty Vector!");
	return(data[0]);
}
template<class T>
void Vector<T>::Reserve(int newMax)	//扩大数组容量为newtheMax，保留原来数据						
{
	if(newMax<theSize)
		return;
	T* old=data;				//令指针指向即将释放的数组
	data=new T[newMax];			//重新分配新数组空间		
	for(int i=0;i<theSize;i++)	//把原数组中的数据考到新数组
		data[i]=old[i];
	theMax=newMax;				//修改容量记录
	delete[]old;				//释放原数组空间			
}
template<class T>//数据个数增为newtheSize，原数据保留，增加的数据元素初始化为item
void Vector<T>::Resize(int newSize,const T& item)				
{
	if(newSize>theMax)//如果增加后的数据元素个数大于数组容量，那么先要扩大数组容量
		Reserve(newSize*2+1);
	for(int i=theSize;i<newSize;i++)//把增加的数据元素初始化为item
		data[i]=item;
	theSize=newSize;
}

	
#endif