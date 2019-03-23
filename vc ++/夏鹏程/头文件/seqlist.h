
#include<stdlib.h>
#include<stdio.h>
struct SeqList						//顺序表结构
{	
		Type *data;					//Type表示待定的顺序表元素类型
		int size;					//顺序表的数据元素个数
		int max;
}; 
typedef struct SeqList SeqList;	

//准构造函数和准析构函数
void IniList(SeqList *l,int n);				//给结构体成员赋初值，生成空表
void FreeList(SeqList *l);					//释放动态数组空间
//用于修改的基本操作函数
void InsertRear(SeqList *l, Type item);		//尾插。在最后一个数据之后插入一个数据
void Insert(SeqList *l,int id,Type item);	//定点插入。在下标id处插入一个数据
void Erase(SeqList *l,int id);				//定点删除。将下标id的数据删除
void Clear(SeqList *l);						//清表。令数据个数size为0
//用于读取的基本操作函数
Type Getdata(const SeqList *l,int id);		//取值。读取下标为id的数据
int Size(const SeqList *l);					//取数据个数。读取size的值
int Empty(const SeqList *l);				//判空
int Full(const SeqList *l);					//判满



void IniList(SeqList *l,int n) 
{	
	l->data=(Type*)malloc(n*sizeof(Type));
	if(l->data==NULL)							//如果动态数组空间分配失败
	{
		printf("Memmory allocation error\n");	//提示
		exit(1);        						//停止程序运行
	}
	l->size=0;
	l->max=n;
}
void FreeList(SeqList *l)
{
	free(l->data);
}
void InsertRear(SeqList *l, Type item)
{	
	if(l->size==l->max)					//如果表满
	{
		printf("InsertRear: list is full！\n");//错误类型提示
		exit(1);        				//停止程序运行
	}
	l->data[l->size]=item;				//插入
	l->size++;							//数据个数增1
}
void Insert(SeqList *l,int id,Type item) 
{	
	int i;
	if(id<0||id>l->size||l->size==l->max)		//步骤1）		
	{
		printf("Insert: id is illegal or list is full！\n"); //错误类型提示
		exit(1);        						//停止程序运行
	}
	for(i=l->size-1;i>=id;i--)					//步骤2）					
		l->data[i+1]=l->data[i];
	l->data[id]=item;  							//步骤3）
	l->size++;								
}

void Erase(SeqList *l,int id) 
{	
	int i;
	if(id<0||id>l->size-1)      //步骤1）如果删除位置不合法或表空		
	{ 
		printf("Erase: id is illegal or list is empty！\n"); //错误类型提示
		exit(1);        						//停止程序运行
	}
	for(i=id+1;i<l->size;i++)					//步骤2）
		l->data[i-1]=l->data[i];
	l->size--;									//步骤3）
}
void Clear(SeqList *l) 
{	
	l->size=0;
}
Type Getdata(const SeqList *l,int id) 
{	
	if(id<0||id>l->size-1)//步骤1）如果位置不合法或表空		
	{ 
		printf("Getdata: id is illegal or list is empty！\n"); //错误类型提示
		exit(1);        						//停止程序运行
	}
	return(l->data[id]);						//步骤2）
}
int Size(const SeqList *l)
{	
	return l->size;
}

int Empty(const SeqList *l)//判空。表空时返回值为1，否则为0
{	
	return l->size==0;
}
int Full(const SeqList *l) //判满。表满时返回值为1，否则为0
{	
	return l->size==l->max;
}






