#ifndef QUEUE_H
#define QUEUE_H

#include"List.h"
template<class T>
class Queue
{ 
	List<T> queueL;
public:
	Queue(){}
	~Queue(){}
    int Size()const					//��
		{return queueL.Size();}	
	int Empty()const				//�п�
		{return queueL.Empty();}	
	const T& Front()const			//ȡ��ͷԪ��
		{return queueL.Front();}	
 	void Push(const T& item)		//���
		{queueL.Push_back(item);}
    T Pop()							//����
		{ T item=queueL.Front(); queueL.Pop_front(); return item;}
    void Clear()					//�ÿն�
		{queueL.Clear();}	
};

#endif