#include<stdio.h>
#include<math.h>
int main()
{
	int a=0;
	long b=0;
	double c=0.0,d=0.0,e=0.0,f=0.0,g=0.0,h=0.0,i=0.0,x=0.0,y=0.0;
	printf("������һ��������");
	scanf("%d",&a);
	a=abs(a);		//���㲢��������x�ľ���ֵ
	printf("%d\n",a);
	printf("������һ������������");
	scanf("%Ld",&b);
	b=labs(b);		//���㲢���س�������x�ľ���ֵ
	printf("%Ld\n",b);
	printf("������һ������0������");
	scanf("%Lf",&c);
	f=log(c);		//���㲢������Ȼ����ln��x����ֵ��x>0��
	printf("%Lf\n",f);
	g=log10(c);	//���㲢���س��ö���log10(x)��ֵ��x>0��
	printf("%Lf\n",g);
	printf("������һ�����ڵ���0������");
	scanf("%Lf",&d);
	d=sqrt(d);		//���㲢����d��ƽ������x>=0��
	printf("%Lf\n",d);
	printf("������һ������-1С��1������");
	scanf("%Lf",&e);
	h=acos(e);		//���㲢����arccos(x)��ֵ��x��-1~1֮�䣩
	printf("%Lf\n",h);
	i=asin(e);		//���㲢����arcsin(x)��ֵ��x��-1~1֮�䣩
	printf("%Lf\n",i);
	printf("������������:");
	scanf("%Lf%Lf",&x,&y);
	i=atan(x);		//���㲢����arctan(x)��ֵ
	printf("%Lf\n",i);
	i=atan2(x,y);		//���㲢����arctan(x/y)��ֵ
	printf("%Lf\n",i);
	i=cos(x);		//���㲢����cos(x)��ֵ
	printf("%Lf\n",i);
	i=cosh(x);	//���㲢����˫�����Һ���cos(x)��ֵ
	printf("%Lf\n",i);
	i=exp(x);		//���㲢����e��x�η�
	printf("%Lf\n",i);
	i=fabs(x);		//���㲢����˫������x��ֵ
	printf("%Lf\n",i);
	i=floor(x);	//���㲢���ز�����x�����˫��������
	printf("%Lf\n",i);
	i=fmod(x,y);	//���㲢����x/y�������
	printf("%Lf\n",i);
	i=pow(x,y);	//���㲢����x��y�η���ֵ
	printf("%Lf\n",i);
	i=sin(x);		//���㲢����sin(x)��ֵ
	printf("%Lf\n",i);
	i=sinh(x);		//���㲢����˫�����Һ���sinh(x)��ֵ
	printf("%Lf\n",i);
	i=tan(x);		//���㲢����tan(x)��ֵ
	printf("%Lf\n",i);
	i=tanh(x);		//���㲢���ط����к���tanh(x)��ֵ
	printf("%Lf\n",i);
	return 0;

}