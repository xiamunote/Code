#include<iostream.h>
#include"BTNode.h"
#include"BTNodeLib.h"
#include"Vector.h"

int main()
{
	//��������˳��洢ת��Ϊ��ʽ�洢
	char a[15] = { 'A','B','C','D','\0','E','F','\0','\0','\0','\0','G' };//������ȫ�������
	Vector<char> L;
	for (int i = 0; i<12; i++)
		L.Push_back(a[i]);
	BTNode<char>*at;
	at=_________________;	//��6���˴���գ����ɶ�������at (2��)
	cout<<"ǰ���������Ϊ��"<<endl;
	_______________;	//��7���˴���գ�ǰ����������õݹ��ʵ�֣���2�֣�
	cout<<endl;

	return 0;
}
