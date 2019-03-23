#include<iostream.h>
#include"seqlist_class.h"
void SeqList::Swap(int id1,int id2);
void SeqList::Replace(int id,const Type& item);
int main()
{
	printf(""yunxing"");
	return 0;

}

void SeqList::Swap(int id1,int id2)
{
	if(id1<0||id2>size-1)
		Error("id1 is illegal!\n");
	if(id1<0||id2>size-1)
		Error("id1 is illegal!\n");
	Type temp;
	temp=L[id1-1];
	L[id1-1]=L[id2-1];
	L[id2-1]=temp;

}
void SeqList::Replace(int id,const Type& item)
{
	if(id<0||id>size-1)
		Error("id is illegal !\n");
	L[id-1]=temp;

}
