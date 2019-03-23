//date.h 
#include<iostream.h>
class Date
{
	int yr,mo,day;								//年，月，日
	static const int dys[];						//静态成员数据，平常年每月对应天数
	bool Leapyear(int y)const					//闰年判定函数
		{return (y%4==0&&y%100!=0)||(y%400==0);}
public:
//构造和析构
	Date(){yr=mo=day=1;}						//默认构造函数 
	Date(int y,int m,int d)	{yr=y;mo=m;day=d;}	//构造函数 
	Date(const Date& dt)						//复制构造函数
		{yr=dt.yr;mo=dt.mo;day=dt.day;}
	Date(long ndays);							//转换构造函数
	~Date(){}									//析构函数
//赋值运算符
	Date& operator=(const Date& dt)				//复制赋值
		{yr=dt.yr;mo=dt.mo;day=dt.day;return *this;}
	Date& operator=(long ndays);				//转换赋值运算符函数
//转换	
	operator long()const; 						//成员转换函数
//自增自减运算符
	Date operator--(int);						//Date--
//数据成员取值和赋值	
	void Set_day(int d){day=d;}					//修改日

//输入输出
	friend ostream& operator<<(ostream& ostr,const Date& dt);	//插入符函数
	friend istream& operator>>(istream& istr,Date& dt);			//提取符函数
	void Display()const{cout<<yr<<'/'<<mo<<'/'<<day<<endl;}		//输出函数
};

//#include"date.h"
const int Date::dys[]={31,28,31,30,31,30,31,31,30,31,30,31};//静态数据定义
Date::operator long()const			//成员转换函数定义	
{	
	long ndays=0;					//步骤1)	
	for(int i=1;i<yr;++i)			//步骤2)	
		ndays+=Leapyear(i)?366:365;	
	for(i=1;i<mo;++i)				//步骤3)
		ndays+=dys[i-1];			
	if(mo>2&&Leapyear(yr))			//闰年闰月加一天	
		++ndays;	
	ndays+=day;						//步骤4)
	return ndays;					//步骤5)
}

Date::Date(long ndays)				//转换构造函数的实现
{
	if(ndays==0)
		yr=mo=day=0;		
	else
	{
		day=ndays; 				//总天数
		yr=1; 					//步骤1）
		while(1)
		{
			int n=Leapyear(yr)?366:365;
			if(day<=n)
				break;
			day-=n;
			++yr;
		}
		for(mo=1;mo<13;mo++)	 //步骤2）
		{
			int n=dys[mo-1];
			if(mo==2&&Leapyear(yr))
				n++;
			if(day<=n)
				break;
			day-=n;
		}
	}
}
Date& Date::operator=(long ndays)	//转换赋值运算符函数的实现
{
	if(ndays==0)
		yr=mo=day=0;		
	else
	{
		day=ndays; 				//总天数
		yr=1; 					//步骤1）
		while(1)
		{
			int n=Leapyear(yr)?366:365;
			if(day<=n)
				break;
			day-=n;
			++yr;
		}
		for(mo=1;mo<13;mo++)	 //步骤2）
		{
			int n=dys[mo-1];
			if(mo==2&&Leapyear(yr))
				n++;
			if(day<=n)
				break;
			day-=n;
		}
	}
	return *this;
}

Date Date::operator--(int)	//后--
{
	Date temp(*this);		//调用复制构造函数
	long ndays=*this;		//调用成员转换函数，将*this转换为长整型
	--ndays; 
	*this=ndays;			//调用转换赋值运算符函数，将长整型转换为Date型
	return temp;
}


ostream& operator<<(ostream& ostr,const Date& dt)//插入符函数的定义
{	
	ostr<<dt.yr<<'/'<<dt.mo<<'/'<<dt.day;		
	return ostr;
}

istream& operator>>(istream& istr,Date& dt)//提取符函数的定义
{	
	istr>>dt.yr>>dt.mo>>dt.day;		
	return istr;
}























	



	


	
