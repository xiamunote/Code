#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	
	int num = 1;
	int score = 0;
	srand(time(NULL));
	for(num=1;num <= 10;num++)
	{
		int m = rand() % 50;
		int n = rand() % (50 - m);
		int result = 0;
		printf("��%d��:", num);
		if (rand() % 2 ==0) 
		{
			result = m + n;
			printf("%d+%d=\n",m,n);
		} 
		else 
		{
			if (m > n) 
			{
				printf("%d-%d=\n",m,n);
				result = m - n;
			} 
			else 
			{
				printf("%d-%d=\n",n,m);
				result = n - m;
			}
			printf("������𰸣�\n");
		}	
     	int i = 1;
		int answer;
		for (i=1;i<=3;i++) 
		{
			scanf("%d", &answer);
			if (answer == result) 
			{
				break;
			} 
			else 
			{
				if (i < 3)
				{
				printf("�𰸴���,����������:\n");
				}
				else 
				{
				printf("3�δ𰸾�����\n");
				}
			}
		}
		switch(i) 
		{
		case 1:score+=10;printf("�ش���ȷ��10��");break;
		case 2:score+=7;printf("�ش���ȷ��7��");break;
		case 3:score+=5;printf("�ش���ȷ��5��");break;
		default:printf("�����0��,��ȷ��:%d", result);
		}
		printf("\n\n");

	}
	printf("�÷�:%d,", score);
	if (score >= 90) 
	{
		printf("SMART");
	} 
	else if (score >= 80 && score < 90)
	{
		printf("GOOD");
	}
	else if (score >= 70 && score < 80)
	{
		printf("OK");
	}
	else if (score >= 60 && score < 70)
	{
		printf("PASS");
	} else {
		printf("TRY AGAIN");
	}
	printf("\n");
    return 0;
}
