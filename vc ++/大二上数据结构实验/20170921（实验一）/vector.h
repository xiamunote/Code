#include<iostream.h>
#include<stdlib.h>

template<class T>
class Vector
{
private:
	T *data;						//指向动态数组指针
	int size;						//数组的数据元素个数
	int max;						//数组容量
	void Error(const char* cs)const{cout<<cs<<endl;exit(1);}//错误信息报告
public:
	enum{SPARE_MAX=16};				//枚举常量表示数组最小长度
	explicit Vector(int n=SPARE_MAX):size(0),max(n)
		{if(max>0) data=new T[max];}
	Vector(const Vector& v):data(NULL),max(0){operator=(v);}//复制构造函数
	~Vector(){delete[]data;}
	Vector& operator=(const Vector<T>& v);		//复制赋值函数
	T& operator[](int id){return data[id];}		//下标运算符函数
	const T& operator[](int id)const{return data[id];}//常量型下标运算符函数
	bool Empty()const{return size==0;}			//判空
	int Size()const{return size;}				//求数据个数
	int Max()const{return max;}					//求数组容量
	void Clear(){size=0;}						//清空。删除所有数据元素
//迭代器类型
	typedef T* iterator;						//迭代器
	typedef const T* const_iterator;			//指向const常量的迭代器
	iterator Begin(){return data;}				//使迭代器指向容器起始位置
	const_iterator Begin()const{return data;}
	iterator End(){return data+size;}			//使迭代器指向容器最后一个数据元素的后继
	const_iterator End()const{return data+size;}
	
	const T& Front()const{return data[0];}		//返回首元素的引用(可以返回*begin())
	T& Front(){return data[0];}	
	const T& Back()const{return data[size-1];}	//返回尾元素的引用(不能返回*--end())
	T& Back(){return data[size-1];}
	void Push_back(const T& item){data[size++]=item;}	//尾插
	void Pop_back(){size--;}					//尾删
	void Reserve(int newMax);					//扩大数组容量为newmax，保留原来数据
	void Resize(int newSize,const T& item=T());	//把数据个数增加为newsize，保留原来的数据，其余的值为item
	iterator Insert(iterator itr,const T& item);
	iterator Erase(iterator itr);

};

template<class T>
Vector<T>& Vector<T>::operator=(const Vector<T>& v)//复制赋值函数
{
	if(max!=v.Max())  
	{
		delete[]data;
		max=v.max;
		data=new T[max];
	}
	size=v.Size();
	for(int i=0;i<size;i++)
			data[i]=v.data[i];
	return *this;
}

template<class T>				//模板参数表
Vector<T>::iterator				//返回值类型
Vector<T>::Erase(iterator itr)	//删除指示器指向的元素
{
	for(iterator p=itr,q=itr+1;q!=data+size;++p,++q)
		*p=*q;
	size--;
	return itr;
}
template<class T>	//把元素item插入到迭代器itr的位置
Vector<T>::iterator	
Vector<T>::Insert(iterator itr,const T& item) 
{
	if(size==max)					
		Reserve(2*max+1);	    //如果空间数据已满，就先扩大容量
	for(iterator p=data+size,q=data+size-1;p!=itr;--p,--q) 
			*p=*q;
	*itr=item;					//插入元素到指定位置
	size++;						//数据个数增1
	return itr;
}
template<class T>
void Vector<T>::Reserve(int newmax)							
{
	if(newmax<max)			//如果数组容量已满，则返回
		return;
	T* old=data;			//保留原数组
	data=new T[newmax];		//重新分配新数组		
	for(int i=0;i<size;i++)	//把原数组中的数据复制到新数组
		data[i]=old[i];
	max=newmax;				//修改数组容量
	delete[]old;			//释放原数组空间			
}

template<class T>//数据个数增为newsize，原数据保留，增加的数据元素初始化为item
void Vector<T>::Resize(int newsize,const T& item)				
{
	if(newsize>max)					//如果数据元素个数大于数组容量
		Reserve(newsize*2+1);		//扩大数组容量
	for(int i=size;i<newsize;i++)	//把增加的数据元素初始化为item
		data[i]=item;
	size=newsize;
}
