#include<iostream.h>
#include"seqlist_class2.h"
void SeqList::Swap(int id1,int id2)
{
	if(id1<0||id1>size-1)
		Error("id1 is illegal !\n");
	if(id2<0||id2>size-1)
		Error("id2 is illegal !\n");
	Type temp;
	typedef int Type;
	temp=L[id1-1];
	L[id1-1]=L[id2-1];
	L[id2-1]=temp;
	return ;

}
void SeqList::Replace(int id,const Type& item)
{
		if(id<0||id>size-1)
			Error("id is illegal !\n");
		typedef int Type;
		L[id-1]=item;

}
