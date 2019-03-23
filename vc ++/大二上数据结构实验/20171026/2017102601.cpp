//程序7.1 树的输出、输入
#include<iostream.h>
#include<fstream.h>
#include"Tree.h"
int main()
{
	Tree<char> T(20);
	ifstream fin;
	fin.open("D:\\treein.txt",ios::in||ios::nocreate);
	if(!fin)
	{
		cout<<"cannot open E:\\treein.txt. \n";
		exit(1);
	}
	fin>>T;
	ofstream fout;
	fout.open("D:\\treeout.txt",ios::out);
	if(!fout)
	{
		cout<<"cannot open E:\\treeout.txt. \n";
		exit(1);
	}
	fout<<T;
	return(0);

}