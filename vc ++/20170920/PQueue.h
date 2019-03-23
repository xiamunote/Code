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
    int Size()const			//求长
		{return(queueL.Size());}	
	bool Empty()const		//判空
		{return(queueL.Empty());}	
	const T& Front()const		//取队头元素
		{return(queueL.Front());}	
 	void Push(const T& item)	//入队
		{queueL.Push_back(item);}
    T Pop();				//出队
    void Clear()			//置空队
		{queueL.Clear();}	
};
template<class T>
T PQueue<T>::Pop()	
{	
	List<T>::iterator itr,min=queueL.Begin(); //令迭代器指向链表首元素
	for(itr=min;itr!=queueL.End();++itr)//遍历寻找最小值元素
		if((*itr)<(*min))
			min=itr;	//指向当前最小元素
	T item=*min;			//存储最小元素值
	queueL.Erase(min);    		//删除最小元素结点
	return(item);			//返回最小元素值
}



#endif