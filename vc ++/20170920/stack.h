#ifndef STACK_H
#define STACK_H

#include"list.h"
template<class T>
class Stack  
{
	List<T> stackL;							//����
public:
	Stack(){}
	~Stack(){}
	int Size()const{return stackL.Size();}		//������Ԫ�ظ���
	int Empty()const{return stackL.Empty();}	//�п�
	const T& Top()const{return stackL.Back();}	//ȡջ��Ԫ�صĳ���������
	T Pop(){T item=stackL.Back();stackL.Pop_back();return item;}//��ջ
	void Push(const T& item) {stackL.Push_back(item);}	//ѹջ
	void Clear(){stackL.Clear();}						//��Ϊ��ջ
};

#endif
