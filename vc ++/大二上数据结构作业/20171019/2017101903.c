#include<stdio.h>
#include<stdlib.h>
#include<math.h>
typedef struct
{
	int mo;
	int day;
}Date;

typedef struct
{
	Date dt;
	char name[20];
	double age;
}Student;

int main()
{
	int i=0;
	double b[100];
	Student a;
	printf("������������գ����շֿ�������������:\n");
	scanf("%d%d%s%Lf",&a.dt.mo,&a.dt.day,&a.name,&a.age);
	printf("%d%d%s%Lf",&a.dt.mo,&a.dt.day,&a.name,&a.age);
	printf("��������ѧ�����гɼ�������-1��������\n");
	for(i;;++i)
	{
		scanf("%Lf",b[i]);
		if(b[i]=-1)
			break;
	}

}