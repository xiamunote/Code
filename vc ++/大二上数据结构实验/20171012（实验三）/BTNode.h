
template<class T>
struct BTNode
{
	T data;
	BTNode *left,*right;
	BTNode(const T& item=T(),BTNode* lptr=NULL,BTNode* rptr=NULL):data(item),left(lptr),right(rptr){}
};
