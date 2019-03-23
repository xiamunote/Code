#ifndef VECTOR_H
#define VECTOR_H

#include<iostream.h>
#include<stdlib.h>

template<class T>
class Vector
{
private:
	T *data;						//����ָ��
	int theSize;					//�����е�����Ԫ�ظ���
	int theMax;						//��������
	void Error(const char* cs)const{cout<<cs<<endl;exit(1);}//������Ϣ����
public:
	explicit Vector(int n=0):theSize(0),theMax(n+SPARE_MAX)
		{if(theMax>0) data=new T[theMax];}
	Vector(const Vector& v):data(NULL),theMax(0){operator=(v);}//�������캯��
	~Vector(void){delete[]data;}
	Vector& operator=(const Vector<T>& v);		//������ֵ����
	T& operator[](int id){return(data[id]);}	//�±����������
	const T& operator[](int id)const{return(data[id]);}//�������±����������
	bool Empty(void)const{return(theSize==0);}	//�п�
	int Size(void)const{return(theSize);}		//�����ݸ���
	int Max(void)const{return(theMax);}			//����������
	void Push_back(const T& item);				//β��
	void Pop_back(void);						//βɾ
	const T& Back(void)const;					//����βԪ�ص�����
	const T& Front(void)const;					//������ʼԪ�ص�����
	void Clear(void){theSize=0;}				//ɾ����������Ԫ��
	void Reserve(int newMax);					//������������ΪnewtheMax������ԭ������
	void Resize(int newSize,const T& item=T());	//�����ݸ�������ΪnewtheSize��ԭ�������ݱ����������ֵΪitem
	enum{SPARE_MAX=16};							//ö�ٳ�����ʾ������С����
//����������
	typedef T* iterator;						//������
	typedef const T* const_iterator;			//ָ��const�����ĵ�����
	iterator begin(){return &data[0];}			//ʹ������ָ��������ʼλ��
	const_iterator begin()const{return &data[0];}
	iterator end(){	return(&data[theSize]);}	//ʹ������ָ����������λ��
	const_iterator end()const{	return(&data[theSize]);}
	iterator Insert(iterator itr,const T& item);
	iterator Erase(iterator itr);
};

template<class T>
Vector<T>& Vector<T>::operator=(const Vector<T>& v)//������ֵ����
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
void Vector<T>::Push_back(const T& item)//β��
{
	if(theSize==theMax)			//����ռ�������������Ҫ����������
		Reserve(2*theMax+1);
	data[theSize++]=item;		//����Ԫ�ص�β�������ݸ�����1
}

template<class T>				//ģ�������
Vector<T>::iterator				//����ֵ����
Vector<T>::Erase(iterator itr)	//ɾ��ָʾ��ָ���Ԫ��
{
	if(theSize==0)				//����Ƿ��ǿձ�			
		Error("Erase:an empty Vector!");		
	if(itr<begin()||itr>end()-1)//���ɾ��λ���Ƿ�Ϸ�					
		Error("Erase: out of illegal!");
	for(iterator p=itr;p!=end();++p)
		*p=*(p+1);
	theSize--;
	return(itr);
}
template<class T>				//ģ�������
Vector<T>::iterator				//����ֵ����
Vector<T>::Insert(iterator itr,const T& item)//��Ԫ��item���뵽ָʾ��ָ���λ��
{
	if(theSize==theMax)					
		Reserve(2*theMax+1);	//����ռ�������������Ҫ����������
	if(itr<begin()||itr>end())	//������λ���Ƿ�Ϸ�
		Error("Insert:out of range");
	for(iterator p=end();p!=itr;--p)//��βԪ�ص�����λ����Ԫ�������ƶ�һ��λ��
		*p=*(p-1);
	*itr=item;					//����Ԫ�ص�ָ��λ��
	theSize++;					//���ݸ�����1
	return(itr);
}
template<class T>
void Vector<T>::Pop_back(void)	//βɾ
{
	if(theSize==0)
		Error("Empty Vector!");
	theSize--;
}

template<class T>
const T& Vector<T>::Back(void)const//����βԪ�ص�����
{
	if(theSize==0)
		Error("Empty Vector!");
	return(data[theSize-1]);
}
template<class T>
const T& Vector<T>::Front(void)const//������ʼԪ�ص�����
{
	if(theSize==0)
		Error("Empty Vector!");
	return(data[0]);
}
template<class T>
void Vector<T>::Reserve(int newMax)	//������������ΪnewtheMax������ԭ������						
{
	if(newMax<theSize)
		return;
	T* old=data;				//��ָ��ָ�򼴽��ͷŵ�����
	data=new T[newMax];			//���·���������ռ�		
	for(int i=0;i<theSize;i++)	//��ԭ�����е����ݿ���������
		data[i]=old[i];
	theMax=newMax;				//�޸�������¼
	delete[]old;				//�ͷ�ԭ����ռ�			
}
template<class T>//���ݸ�����ΪnewtheSize��ԭ���ݱ��������ӵ�����Ԫ�س�ʼ��Ϊitem
void Vector<T>::Resize(int newSize,const T& item)				
{
	if(newSize>theMax)//������Ӻ������Ԫ�ظ�������������������ô��Ҫ������������
		Reserve(newSize*2+1);
	for(int i=theSize;i<newSize;i++)//�����ӵ�����Ԫ�س�ʼ��Ϊitem
		data[i]=item;
	theSize=newSize;
}

	
#endif