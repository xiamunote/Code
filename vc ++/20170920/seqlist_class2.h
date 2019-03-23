#include<stdlib.h>
#include<iostream.h>
class SeqList 
{	
private:   //˽��
	Type *data;	
	int size; 
    int max;
public:	//����
//���캯������������
	SeqList(int n=100);     	//ȱʡ����
	SeqList(const SeqList& l);	//���ƹ��캯��
     ~ SeqList(){delete[]data;} 	//����
//�����޸ĵĵĳ�Ա����
SeqList& SeqList::operator=(const SeqList& l);
	void InsertRear(const Type& item);
	void Insert(Type *itr,const Type& item);
	void Erase(Type *itr); 
	void Clear(){size=0;}
Type& SeqList::operator[](int id);
const Type& SeqList::operator[](int id)const;
//���ڶ�ȡ�ĳ�Ա����
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
		cout<<"Memmory allocation error\n";	//����������ʾ
		exit(1);        					//ֹͣ��������
	}
	size=0;
	max=n;
}
SeqList::SeqList(const SeqList& l)
{
	data=new Type[l.max]; 	// this->data=new Type[l.max];
	if(data==NULL)
	{
		cout<<"Memmory allocation error\n";	//����������ʾ
		exit(1);        					//ֹͣ��������
	}
	for(int i=0;i<l.size;i++)
		data[i]=l.data[i];	
	size=l.size;			
	max=l.max;			
}
SeqList& SeqList::operator=(const SeqList& l)
{
	if(max!=l.max)							//�������������ͬ
	{
		delete[]data;
		data=new Type[l.max];
		if(data==NULL)
		{
			cout<<"Memmory allocation error\n";	//����������ʾ
			exit(1);        					//ֹͣ��������
		}
	}
	for(int i=0;i<l.size;i++)
		data[i]=l.data[i]; 
	size=l.size;
	max=l.max;
	return *this;             
}

Type& SeqList::operator[](int id)	//�±����������
{
	if(id<0||id>size-1)
	{
		cout<<"id illegal!";
		exit(1);
	}
	return data[id];
}
const Type& SeqList::operator[](int id)const//�������±����������
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
		cout<<"InsertRear: list is full��\n";//����������ʾ
		exit(1);        				//ֹͣ��������
	}
	data[size]=item;
	size++;
}
void SeqList::Insert(Type *itr,const Type& item) //����ָ�����
{	//��Ԫ��item���뵽ָ��itrָ���λ��
	for(Type *p=data+size,*q=data+size-1;p!=itr;--p,--q)
	*p=*q;
	*itr=item;				//����Ԫ�ص�ָ��λ��
	size++;					//���ݸ�����1			
}

void SeqList::Erase(Type *itr)
{	//ɾ��ָ��itrָ���Ԫ��
	for(Type *p=itr,*q=itr+1;p!=data+size;++p,++q)
	*p=*q;
	size--;	
}
const Type& SeqList::Getdata(int id)const  
{	
	if(id<0||id>size-1)						
	{
		cout<<"Getdata: id is illegal or list is empty��\n"; //����������ʾ
		exit(1);        						//ֹͣ��������
	}
	return data[id];							
}
