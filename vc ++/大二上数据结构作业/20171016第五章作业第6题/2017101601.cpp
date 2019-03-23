#include<iostream.h>
#include"BTNodeLib.h"

/*template<class T>
BTNode<T>* MakeLinkedEx(const Vector<T>& L,int size,int pos)
{
	if(pos>=size||L[pos]==T())
		return(NULL);
	BTNode<T> *right=MakeLinked(L,size,2*pos+1);
	BTNode<T> *left=MakeLinked(L,size,2*pos+2);
	BTNode<T> *t=GetBTNode(L[pos],left,right);
	return(t);
}
*/

template<class T>
void SwapBTNode(BTNode<T> *t) 
{ 
	if(!t)
		return; 
	SwapBTNode(t->left); 
	SwapBTNode(t->right); 
	BTNode<T> *temp = t->left; 
	t->left = t->right; 
	t->right = temp; 
}

int main()
{
	Vector<char> L;
	char a[15]={'A','B','C','\0','D','\0','E','\0','\0','F'};
	for(int i=0;i<10;i++)
		L.Push_back(a[i]);
	BTNode<char>* t=MakeLinked(L);
	//BTNode<char>* m=MakeLinkedEx(L);
	PrintBTree(t,40);
	Level(t);
	cout<<endl;
	SwapBTNode(t);
	PrintBTree(t,40);
	Level(t);
	cout<<endl;
	return(0);
}