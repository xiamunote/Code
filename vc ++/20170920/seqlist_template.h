#include<stdlib.h>
#include<iostream.h>
template<class T>
class SeqList 
{	
private:   //˽��
	T *data;	
	int size; 
    int max;
public:	//����
//���캯������������
	SeqList(int n=100);     	//����
	SeqList(const SeqList& l);  //���ƹ���
     ~ SeqList(){delete[]data;} 	//����
//�����޸ĵĳ�Ա����
	SeqList& operator=(const SeqList& l);//���Ƹ�ֵ
	void InsertRear(const T& item);
	void Insert(int id,const T& item);
	void Erase(int id); 
	void Clear(){size=0;}
	T& operator[](int id);
	const T& operator[](int id)const;
//���ڶ�ȡ�ĳ�Ա����
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
		cout<<"Memmory allocation error\n";	//��������
		exit(1);        					//ֹͣ��������
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
		cout<<"Memmory allocation error\n";	//����������ʾ
		exit(1);        					//ֹͣ��������
	}
	for(int i=0;i<l.size;i++)
		data[i]=l.data[i];	
	size=l.size;			
	max=l.max;			
}
template<class T>
SeqList<T>& SeqList<T>::operator=(const SeqList& l)
{
	if(max!=l.max)							//�������������ͬ
	{
		delete[]data;
		data=new T[l.max];
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
template<class T> 
void SeqList<T>::InsertRear(const T& item)
{	
	if(size==max)
	{
		cout<<"InsertRear: list is full��\n";//����������ʾ
		exit(1);        				//ֹͣ��������
	}
	data[size]=item;
	size++;
}
template<class T> 
void SeqList<T>::Insert(int id,const T& item) 
{	
	if(id<0||id>size||size==max)						
	{
		cout<<"Insert: id is illegal or list is full��\n";//����������ʾ
		exit(1);        				//ֹͣ��������
	}
	for(int i=size-1;i>=id;i--)						
		data[i+1]=data[i];
	data[id]=item;
	size++;								
}
template<class T> 
void SeqList<T>::Erase(int id)
{	
	if(id<0||id>size-1)
	{
		cout<<"Erase: id is illegal or list is empty��\n"; //����������ʾ
		exit(1);        						//ֹͣ��������
	}
	for(int i=id+1;i<size;i++)					
		data[i-1]=data[i];
	size--;	
}
template<class T>
T& SeqList<T>::operator[](int id)	//�±����������
{
	if(id<0||id>size-1)
	{
		cout<<"operator[]:id is illegal��\n";	//����������ʾ
		exit(1);        						//ֹͣ��������
	}
	return data[id];
}
template<class T>
const T& SeqList<T>::operator[](int id)const//�������±����������
{
	if(id<0||id>size-1)
	{
		cout<<"operator[]:id is illegal��\n";	//����������ʾ
		exit(1);        						//ֹͣ��������
	}
	return  data[id];
}
template<class T> 
const T& SeqList<T>::Getdata(int id)const  
{	
	if(id<0||id>size-1)						
	{
		cout<<"Getdata: id is illegal or list is empty��\n"; //����������ʾ
		exit(1);        							//ֹͣ��������
	}
	return data[id];							
}