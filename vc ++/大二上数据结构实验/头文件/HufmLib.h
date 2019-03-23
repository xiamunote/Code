//HufmLib.h 
//#include<iostream.h>
//#include"BTNode.h"
#include"heap.h"

//哈夫曼树结点结构
template<class T>
struct HufmNode
{
BTNode<T>* t;
int operator<(const HufmNode& h){return(t->data<h.t->data);}
int operator<=(const HufmNode& h){return(t->data<=h.t->data);}
};

//哈夫曼算法
template<class T>
BTNode<T>* MakeHufm(const T* pa,int n)
{
HufmNode<T> hf;
BTNode<T> *t,*left,*right;
Heap<HufmNode<T> > H(n);
for(int i=0;i<n;i++)
{
t=GetBTNode(pa[i]);
hf.t=t;
H.Insert(hf);
}
for(int i=1;i<n;i++)
{
H.DeleteMin(hf);
left=hf.t;
H.DeleteMin(hf);
right=hf.t;
t=GetBTNode(left->data+right->data,left,right);
hf.t=t;
H.Insert(hf);
}
H.DeleteMin(hf);
t=hf.t;
return(t);
}