//������
template<class T>
void BuildHeap(T* pa, int size)		//���������Ϊ��
{
	for(_____________________)//��1���˴���գ�3�֣�
		PercolateDown(pa, i, size); //���±�[i,size)��Χ�ڵ�����Ԫ�����µ���Ϊ��
}
template<class T>	//���±�[pos,size)��Χ�ڵ�����Ԫ�����µ���Ϊ��
void PercolateDown(T* pa, int pos, int size)
{
	int p = pos, c = 2 * p + 1;
	T temp = pa[p];
	while (c<size)
	{
		if(c+1<size&&pa[c+1]>pa[c])	  //�����Һ����е������
			++c;
		if (temp >= pa[c])
			break;
		else
		{
			__________________;//��2���˴���գ�3�֣�    
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
	BuildHeap(pa, n);			//�������Ӽ��������
	for(______________________)	  //��3���˴���գ�3�֣�
	{
		temp = pa[0]; 			//��βԪ�ؽ���
		pa[0] = pa[i];
		pa[i] = temp;
		_______________________;//��4���˴���գ�3�֣�
	}
}
