#include<stdlib.h>
#include<iostream.h>
class SeqList 
{	
private:   //私有
	Type *data;	
	int size; 
    int max;
public:	//公有
//构造函数和析构函数
	SeqList(int n=100);     	//缺省构造
	SeqList(const SeqList& l);	//复制构造函数
     ~ SeqList(){delete[]data;} 	//析构
//用于修改的的成员函数
SeqList& SeqList::operator=(const SeqList& l);
	void InsertRear(const Type& item);
	void Insert(Type *itr,const Type& item);
	void Erase(Type *itr); 
	void Clear(){size=0;}
Type& SeqList::operator[](int id);
const Type& SeqList::operator[](int id)const;
//用于读取的成员函数
    const Type& Getdata(int id)const;	
	int Size()const{return size;}		
	int Empty()const{return size==0;}
	int Full()const{return size==max;}
	Type * Begin(){return data;}
	const Type * Begin()const{return data;}
	Type * End(){return data+size;}
	const Type * End()const{return data+size;}
};

SeqList::SeqList(int n)  
{	
	data=new Type[n];    
	if(data==NULL)
	{
		cout<<"Memmory allocation error\n";	//错误类型提示
		exit(1);        					//停止程序运行
	}
	size=0;
	max=n;
}
SeqList::SeqList(const SeqList& l)
{
	data=new Type[l.max]; 	// this->data=new Type[l.max];
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
SeqList& SeqList::operator=(const SeqList& l)
{
	if(max!=l.max)							//如果数组容量不同
	{
		delete[]data;
		data=new Type[l.max];
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

Type& SeqList::operator[](int id)	//下标操作符重载
{
	if(id<0||id>size-1)
	{
		cout<<"id illegal!";
		exit(1);
	}
	return data[id];
}
const Type& SeqList::operator[](int id)const//常量型下标操作符重载
{
	if(id<0||id>size-1)
	{
		cout<<"id illegal!";
		exit(1);
	}
	return data[id];
}

void SeqList::InsertRear(const Type& item)
{	
	if(size==max)
	{
		cout<<"InsertRear: list is full！\n";//错误类型提示
		exit(1);        				//停止程序运行
	}
	data[size]=item;
	size++;
}
void SeqList::Insert(Type *itr,const Type& item) //基于指针插入
{	//把元素item插入到指针itr指向的位置
	for(Type *p=data+size,*q=data+size-1;p!=itr;--p,--q)
	*p=*q;
	*itr=item;				//插入元素到指定位置
	size++;					//数据个数加1			
}

void SeqList::Erase(Type *itr)
{	//删除指针itr指向的元素
	for(Type *p=itr,*q=itr+1;p!=data+size;++p,++q)
	*p=*q;
	size--;	
}
const Type& SeqList::Getdata(int id)const  
{	
	if(id<0||id>size-1)						
	{
		cout<<"Getdata: id is illegal or list is empty！\n"; //错误类型提示
		exit(1);        						//停止程序运行
	}
	return data[id];							
}
