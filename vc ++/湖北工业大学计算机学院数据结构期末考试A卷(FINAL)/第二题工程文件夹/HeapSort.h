//堆排序
template<class T>
void BuildHeap(T* pa, int size)		//将数组调整为堆
{
	for(_____________________)//（1）此处填空（3分）
		PercolateDown(pa, i, size); //将下标[i,size)范围内的数组元素向下调整为堆
}
template<class T>	//将下标[pos,size)范围内的数组元素向下调整为堆
void PercolateDown(T* pa, int pos, int size)
{
	int p = pos, c = 2 * p + 1;
	T temp = pa[p];
	while (c<size)
	{
		if(c+1<size&&pa[c+1]>pa[c])	  //找左右孩子中的最大者
			++c;
		if (temp >= pa[c])
			break;
		else
		{
			__________________;//（2）此处填空（3分）    
			p = c;	
			c = 2 * p + 1;
		}
	}
	pa[p] = temp;
}

template<class T>
void HeapSort(T* pa, int n)
{
	T temp;
	BuildHeap(pa, n);			//对无序子集建大根堆
	for(______________________)	  //（3）此处填空（3分）
	{
		temp = pa[0]; 			//首尾元素交换
		pa[0] = pa[i];
		pa[i] = temp;
		_______________________;//（4）此处填空（3分）
	}
}
