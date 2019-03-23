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
    int Size()const					//求长
		{return queueL.Size();}	
	int Empty()const				//判空
		{return queueL.Empty();}	
	const T& Front()const			//取队头元素
		{return queueL.Front();}	
 	void Push(const T& item)		//入队
		{queueL.Push_back(item);}
    T Pop()							//出队
		{ T item=queueL.Front(); queueL.Pop_front(); return item;}
    void Clear()					//置空队
		{queueL.Clear();}	
};

#endif