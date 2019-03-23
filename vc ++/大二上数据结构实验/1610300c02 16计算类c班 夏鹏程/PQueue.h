//PQueue.h
#ifndef PQUEUE_H
#define PQUEUE_H

#include"list.h"
template<class T>
class PQueue
{ 
	List<T> queueL;
public:
	PQueue(){}
	~PQueue(){}
    int Size()const			//��
		{return(queueL.Size());}	
	bool Empty()const		//�п�
		{return(queueL.Empty());}	
	const T& Front()const		//ȡ��ͷԪ��
		{return(queueL.Front());}	
 	void Push(const T& item)	//���
		{queueL.Push_back(item);}
    T Pop();				//����
    void Clear()			//�ÿն�
		{queueL.Clear();}	
};
template<class T>
T PQueue<T>::Pop()	
{	
	List<T>::iterator itr,min=queueL.Begin(); //�������ָ��������Ԫ��
	for(itr=min;itr!=queueL.End();++itr)//����Ѱ����СֵԪ��
		if((*itr)<(*min))
			min=itr;	//ָ��ǰ��СԪ��
	T item=*min;			//�洢��СԪ��ֵ
	queueL.Erase(min);    		//ɾ����СԪ�ؽ��
	return(item);			//������СԪ��ֵ
}



#endif