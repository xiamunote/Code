#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    int a,b;
	a=rand()%100;
	b=rand()%100;
	float c=(float)((a+b)/2);
	printf("%d,%d",a,b);
    printf("\n");
    return 0;
}