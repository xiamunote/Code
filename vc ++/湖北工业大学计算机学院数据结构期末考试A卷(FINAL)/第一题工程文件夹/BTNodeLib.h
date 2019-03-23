#ifndef BTNODELIB_H
#define BTNODELIB_H
#include"BTNode.h"
#include"Vector.h"

template<class T>//������������ڵ�
BTNode<T> * GetBTNode(const T& item,BTNode<T> *lp=NULL,BTNode<T> *rp=NULL)
{
	BTNode<T> *p;
	p=new BTNode<T>(item,lp,rp);	
	if(p==NULL)
	{
		cout<<"Memory allocation failure!"<<endl;	
		exit(1);
	}
	return p;
}

//��˳��洢�ṹתΪ��ʽ�洢�ṹ 
template<class T>
BTNode<T>* MakeLinked(const Vector<T>& L, int size, int pos)
{//�Ѷ�������˳��洢ת��Ϊ��ʽ�洢�ĵݹ��㷨
	if (pos >= size || L[pos] == T())
		return NULL;
	BTNode<T> *left = MakeLinked(L, size, 2 * pos + 1);
	BTNode<T> *right = _______________________;//��1���˴����(2 ��)
	BTNode<T> *t = ______________________;  //��2���˴����(2 ��)
	return t;
}


//ǰ������ݹ��㷨
template<class T>
void Preorder(const BTNode<T>* t)
{
	if (t == NULL)
		return;
	cout<<____________<<" ";//��3���˴����(2 ��)
	if (t->left)
		___________________; //��4���˴����(2 ��)
	if (t->right)
		___________________; //��5���˴����(2 ��)
}

#endif
