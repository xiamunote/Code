
#include<stdlib.h>
#include<stdio.h>
struct SeqList						//˳���ṹ
{	
		Type *data;					//Type��ʾ������˳���Ԫ������
		int size;					//˳��������Ԫ�ظ���
		int max;
}; 
typedef struct SeqList SeqList;	

//׼���캯����׼��������
void IniList(SeqList *l,int n);				//���ṹ���Ա����ֵ�����ɿձ�
void FreeList(SeqList *l);					//�ͷŶ�̬����ռ�
//�����޸ĵĻ�����������
void InsertRear(SeqList *l, Type item);		//β�塣�����һ������֮�����һ������
void Insert(SeqList *l,int id,Type item);	//������롣���±�id������һ������
void Erase(SeqList *l,int id);				//����ɾ�������±�id������ɾ��
void Clear(SeqList *l);						//��������ݸ���sizeΪ0
//���ڶ�ȡ�Ļ�����������
Type Getdata(const SeqList *l,int id);		//ȡֵ����ȡ�±�Ϊid������
int Size(const SeqList *l);					//ȡ���ݸ�������ȡsize��ֵ
int Empty(const SeqList *l);				//�п�
int Full(const SeqList *l);					//����



void IniList(SeqList *l,int n) 
{	
	l->data=(Type*)malloc(n*sizeof(Type));
	if(l->data==NULL)							//�����̬����ռ����ʧ��
	{
		printf("Memmory allocation error\n");	//��ʾ
		exit(1);        						//ֹͣ��������
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
	if(l->size==l->max)					//�������
	{
		printf("InsertRear: list is full��\n");//����������ʾ
		exit(1);        				//ֹͣ��������
	}
	l->data[l->size]=item;				//����
	l->size++;							//���ݸ�����1
}
void Insert(SeqList *l,int id,Type item) 
{	
	int i;
	if(id<0||id>l->size||l->size==l->max)		//����1��		
	{
		printf("Insert: id is illegal or list is full��\n"); //����������ʾ
		exit(1);        						//ֹͣ��������
	}
	for(i=l->size-1;i>=id;i--)					//����2��					
		l->data[i+1]=l->data[i];
	l->data[id]=item;  							//����3��
	l->size++;								
}

void Erase(SeqList *l,int id) 
{	
	int i;
	if(id<0||id>l->size-1)      //����1�����ɾ��λ�ò��Ϸ�����		
	{ 
		printf("Erase: id is illegal or list is empty��\n"); //����������ʾ
		exit(1);        						//ֹͣ��������
	}
	for(i=id+1;i<l->size;i++)					//����2��
		l->data[i-1]=l->data[i];
	l->size--;									//����3��
}
void Clear(SeqList *l) 
{	
	l->size=0;
}
Type Getdata(const SeqList *l,int id) 
{	
	if(id<0||id>l->size-1)//����1�����λ�ò��Ϸ�����		
	{ 
		printf("Getdata: id is illegal or list is empty��\n"); //����������ʾ
		exit(1);        						//ֹͣ��������
	}
	return(l->data[id]);						//����2��
}
int Size(const SeqList *l)
{	
	return l->size;
}

int Empty(const SeqList *l)//�пա����ʱ����ֵΪ1������Ϊ0
{	
	return l->size==0;
}
int Full(const SeqList *l) //����������ʱ����ֵΪ1������Ϊ0
{	
	return l->size==l->max;
}






