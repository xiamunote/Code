#ifndef STACK_H
#define STACK_H

#include"list.h"
template<class T>
class Stack  
{
	List<T> stackL;							//链表
public:
	Stack(){}
	~Stack(){}
	int Size()const{return stackL.Size();}		//求数据元素个数
	int Empty()const{return stackL.Empty();}	//判空
	const T& Top()const{return stackL.Back();}	//取栈顶元素的常量型引用
	T Pop(){T item=stackL.Back();stackL.Pop_back();return item;}//弹栈
	void Push(const T& item) {stackL.Push_back(item);}	//压栈
	void Clear(){stackL.Clear();}						//清为空栈
};

#endif
