#include<stdio.h>
#include<math.h>
int main()
{
	int a=0;
	long b=0;
	double c=0.0,d=0.0,e=0.0,f=0.0,g=0.0,h=0.0,i=0.0,x=0.0,y=0.0;
	printf("请输入一个整数：");
	scanf("%d",&a);
	a=abs(a);		//计算并返回整数x的绝对值
	printf("%d\n",a);
	printf("请输入一个长整型数：");
	scanf("%Ld",&b);
	b=labs(b);		//计算并返回长整型数x的绝对值
	printf("%Ld\n",b);
	printf("请输入一个大于0的数：");
	scanf("%Lf",&c);
	f=log(c);		//计算并返回自然对数ln（x）的值（x>0）
	printf("%Lf\n",f);
	g=log10(c);	//计算并返回常用对数log10(x)的值（x>0）
	printf("%Lf\n",g);
	printf("请输入一个大于等于0的数：");
	scanf("%Lf",&d);
	d=sqrt(d);		//计算并返回d的平方根（x>=0）
	printf("%Lf\n",d);
	printf("请输入一个大于-1小于1的数：");
	scanf("%Lf",&e);
	h=acos(e);		//计算并返回arccos(x)的值（x在-1~1之间）
	printf("%Lf\n",h);
	i=asin(e);		//计算并返回arcsin(x)的值（x在-1~1之间）
	printf("%Lf\n",i);
	printf("请输入两个数:");
	scanf("%Lf%Lf",&x,&y);
	i=atan(x);		//计算并返回arctan(x)的值
	printf("%Lf\n",i);
	i=atan2(x,y);		//计算并返回arctan(x/y)的值
	printf("%Lf\n",i);
	i=cos(x);		//计算并返回cos(x)的值
	printf("%Lf\n",i);
	i=cosh(x);	//计算并返回双曲余弦函数cos(x)的值
	printf("%Lf\n",i);
	i=exp(x);		//计算并返回e的x次方
	printf("%Lf\n",i);
	i=fabs(x);		//计算并返回双精度数x的值
	printf("%Lf\n",i);
	i=floor(x);	//计算并返回不大于x的最大双精度整数
	printf("%Lf\n",i);
	i=fmod(x,y);	//计算并返回x/y后的余数
	printf("%Lf\n",i);
	i=pow(x,y);	//计算并返回x的y次方的值
	printf("%Lf\n",i);
	i=sin(x);		//计算并返回sin(x)的值
	printf("%Lf\n",i);
	i=sinh(x);		//计算并返回双区正弦函数sinh(x)的值
	printf("%Lf\n",i);
	i=tan(x);		//计算并返回tan(x)的值
	printf("%Lf\n",i);
	i=tanh(x);		//计算并返回反正切函数tanh(x)的值
	printf("%Lf\n",i);
	return 0;

}