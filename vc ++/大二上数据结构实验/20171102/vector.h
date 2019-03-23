#include<iostream.h>
#include<stdlib.h>

template<class T>
class Vector
{
private:
	T *data;						//ָ��̬����ָ��
	int size;						//���������Ԫ�ظ���
	int max;						//��������
	void Error(const char* cs)const{cout<<cs<<endl;exit(1);}//������Ϣ����
public:
	enum{SPARE_MAX=16};				//ö�ٳ�����ʾ������С����
	explicit Vector(int n=SPARE_MAX):size(0),max(n)
		{if(max>0) data=new T[max];}
	Vector(const Vector& v):data(NULL),max(0){operator=(v);}//���ƹ��캯��
	~Vector(){delete[]data;}
	Vector& operator=(const Vector<T>& v);		//���Ƹ�ֵ����
	T& operator[](int id){return data[id];}		//�±����������
	const T& operator[](int id)const{return data[id];}//�������±����������
	bool Empty()const{return size==0;}			//�п�
	int Size()const{return size;}				//�����ݸ���
	int Max()const{return max;}					//����������
	void Clear(){size=0;}						//��ա�ɾ����������Ԫ��
//����������
	typedef T* iterator;						//������
	typedef const T* const_iterator;			//ָ��const�����ĵ�����
	iterator Begin(){return data;}				//ʹ������ָ��������ʼλ��
	const_iterator Begin()const{return data;}
	iterator End(){return data+size;}			//ʹ������ָ���������һ������Ԫ�صĺ��
	const_iterator End()const{return data+size;}
	
	const T& Front()const{return data[0];}		//������Ԫ�ص�����(���Է���*begin())
	T& Front(){return data[0];}	
	const T& Back()const{return data[size-1];}	//����βԪ�ص�����(���ܷ���*--end())
	T& Back(){return data[size-1];}
	void Push_back(const T& item){data[size++]=item;}	//β��
	void Pop_back(){size--;}					//βɾ
	void Reserve(int newMax);					//������������Ϊnewmax������ԭ������
	void Resize(int newSize,const T& item=T());	//�����ݸ�������Ϊnewsize������ԭ�������ݣ������ֵΪitem
	iterator Insert(iterator itr,const T& item);
	iterator Erase(iterator itr);

};

template<class T>
Vector<T>& Vector<T>::operator=(const Vector<T>& v)//���Ƹ�ֵ����
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

template<class T>				//ģ�������
Vector<T>::iterator				//����ֵ����
Vector<T>::Erase(iterator itr)	//ɾ��ָʾ��ָ���Ԫ��
{
	for(iterator p=itr,q=itr+1;q!=data+size;++p,++q)
		*p=*q;
	size--;
	return itr;
}
template<class T>	//��Ԫ��item���뵽������itr��λ��
Vector<T>::iterator	
Vector<T>::Insert(iterator itr,const T& item) 
{
	if(size==max)					
		Reserve(2*max+1);	    //����ռ�����������������������
	for(iterator p=data+size,q=data+size-1;p!=itr;--p,--q) 
			*p=*q;
	*itr=item;					//����Ԫ�ص�ָ��λ��
	size++;						//���ݸ�����1
	return itr;
}
template<class T>
void Vector<T>::Reserve(int newmax)							
{
	if(newmax<max)			//������������������򷵻�
		return;
	T* old=data;			//����ԭ����
	data=new T[newmax];		//���·���������		
	for(int i=0;i<size;i++)	//��ԭ�����е����ݸ��Ƶ�������
		data[i]=old[i];
	max=newmax;				//�޸���������
	delete[]old;			//�ͷ�ԭ����ռ�			
}

template<class T>//���ݸ�����Ϊnewsize��ԭ���ݱ��������ӵ�����Ԫ�س�ʼ��Ϊitem
void Vector<T>::Resize(int newsize,const T& item)				
{
	if(newsize>max)					//�������Ԫ�ظ���������������
		Reserve(newsize*2+1);		//������������
	for(int i=size;i<newsize;i++)	//�����ӵ�����Ԫ�س�ʼ��Ϊitem
		data[i]=item;
	size=newsize;
}
