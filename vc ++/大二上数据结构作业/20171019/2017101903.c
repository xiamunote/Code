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
	printf("请输入你的生日（月日分开）姓名和年龄:\n");
	scanf("%d%d%s%Lf",&a.dt.mo,&a.dt.day,&a.name,&a.age);
	printf("%d%d%s%Lf",&a.dt.mo,&a.dt.day,&a.name,&a.age);
	printf("请输入上学期所有成绩（输入-1结束）：\n");
	for(i;;++i)
	{
		scanf("%Lf",b[i]);
		if(b[i]=-1)
			break;
	}

}