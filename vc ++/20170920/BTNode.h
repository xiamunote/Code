#include<iostream.h>

template<class T>
struct BTNode	//Binary Tree Node
{
	T data;
	BTNode *left,*right;				//ָ�������Һ��ӵ�ָ��
	BtNode (const T& item=T(),BTNode* lptr=NULL,BTNode* rptr=NULL):data(item),left(lptr),right(rptr){}
};

template <class T>						//����һ������������ĺ���
BTNode<T> * GetBTNode(const T& item,BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
	BTNode<T> *p;
	p=new BTNode<T>(item,lp,rp);
	if(p==NULL)
	{
		cerr<<"Memory allocation failure!"<<endl;    exit(1);
	}
	return(p);
}
