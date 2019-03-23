#ifndef LIST_H
#define LIST_H

#include<stdlib.h>

template<class T>
class List
{
	struct Node				//˫��������
	{
		T data;	
		Node *prev,*next;
		Node(const T &d=T(),Node *p=NULL,Node *n=NULL):data(d),prev(p),next(n){}
	};
	int size;				//���ݽ�����
	Node *head;				//ͷ���ָ��
	Node *tail;				//β���ָ��
	void Init()				//��ʼ������
	{size=0;head=new Node;tail=new Node;head->next=tail;tail->prev=head;}

public:
	class const_iterator
	{
	protected:
		Node *current;
		T& retrieve()const{return current->data;}
		const_iterator(Node *p):current(p){}
		friend class List<T>;
	public:
		const_iterator():current(NULL){}
		const T& operator*()const{return retrieve();}//current->data
		const_iterator& operator++()//ǰ++
		{
			current=current->next;
			return *this;
		}
		const_iterator operator++(int)//��++
		{
			const_iterator old=*this;	//old=current;
			++(*this);					//current=current->next;
			return old;
		}
		const_iterator& operator--()//ǰ--
		{
			current=current->prev;
			return *this;
		}
		const_iterator operator--(int)//��--
		{
			const_iterator old=*this;	//old=current;
			--(*this);					//current=current->next;
			return old;
		}
		bool operator==(const const_iterator & rhs)const
			{return current==rhs.current;}
		bool operator!=(const const_iterator & rhs)const
			{return current!=rhs.current;}

	};
	class iterator:public const_iterator
	{
	protected:
		iterator(Node *p):const_iterator(p){}
		friend class List<T>;
	public:
		iterator(){}
		T& operator*(){return retrieve();}
		const T& operator*()const{return const_iterator::operator*();}
		iterator& operator++()//ǰ++
		{
			current=current->next;
			return *this;
		}
		iterator operator++(int)//��++
		{
			iterator old=*this;			//old=current;
			++(*this);					//current=current->next;
			return old;
		}
		iterator& operator--()//ǰ--
		{
			current=current->prev;
			return *this;
		}
		iterator operator--(int)//��--
		{
			iterator old=*this;			//old=current;
			--(*this);					//current=current->next;
			return old;
		}
	};
	List(){Init();}								//Ĭ�Ϲ��캯��
	List(const List<T> &l){Init();operator=(l);}//���ƹ��캯��
	~List(){Clear();delete head;delete tail;}	//��������
	const List& operator=(const List& l);		//���Ƹ�ֵ���������
	int Size()const{return size;}				//�����ݸ���
	bool Empty()const{return size==0;}			//�пպ���
	void Clear(){while(!Empty())Pop_front();}	//���

	iterator Begin(){return iterator(head->next);}
	const_iterator Begin()const{return const_iterator(head->next);}
	iterator End(){return iterator(tail);}
	const_iterator End()const{return const_iterator(tail);}
	
	T& Front(){return *Begin();}			//������Ԫ�ص�����
	const T& Front()const{return *Begin();}	//������Ԫ�صĳ���������
	T& Back(){return *--End();}				//����βԪ�ص�����			
	const T& Back()const{return *--End();}	//����βԪ�صĳ���������
	void Push_front(const T& item){Insert(Begin(),item);}//�ײ�
	void Push_back(const T& item){Insert(End(),item);}//β��
	void Pop_front(){Erase(Begin());}		//ɾ���׽��
	void Pop_back(){Erase(--End());}		//ɾ��β���
	iterator Erase(iterator itr);			//ɾ��ָʾ��λ���ϵĽ��
	iterator Insert(iterator itr,const T& item);//��ָʾ����λ�ò���item

};
template<class T>//���Ƹ�ֵ��Ա�����������ʵ��
const List<T>& List<T>::operator=(const List<T>& l)
{
	Clear();					//��Ϊ�ձ�
	for(const_iterator itr=l.Begin();itr!=l.End();++itr) //�ѱ�l�Ľ���������
		Push_back(*itr);
	return *this;
}

template<class T>
List<T>::iterator List<T>::Erase(iterator itr)
{
	Node *p=itr.current;
	iterator re(p->next);
	p->prev->next=p->next;
	p->next->prev=p->prev;
	delete p;
	size--;
	return re;
}
template<class T>
List<T>::iterator List<T>::Insert(iterator itr,const T& item)
{
	Node *p=itr.current;
	size++;
	p->prev->next=new Node(item,p->prev,p);
	p->prev=p->prev->next;
	return iterator(p->prev);
}

#endif
