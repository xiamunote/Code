#ifndef BTNODE_H
#define BTNODE_H
#include<stdlib.h>

template<class T>
struct BTNode//Binary Tree Node 
{
	T data; 
	BTNode *left,*right;	//ָ�������Һ��ӵ�ָ��
	BTNode(const T& item=T(),BTNode* lptr=NULL,BTNode* rptr=NULL):
			data(item),left(lptr),right(rptr){}
};

#endif 

