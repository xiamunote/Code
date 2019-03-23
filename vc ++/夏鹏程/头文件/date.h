//date.h 
#include<iostream.h>
class Date
{
	int yr,mo,day;								//�꣬�£���
	static const int dys[];						//��̬��Ա���ݣ�ƽ����ÿ�¶�Ӧ����
	bool Leapyear(int y)const					//�����ж�����
		{return (y%4==0&&y%100!=0)||(y%400==0);}
public:
//���������
	Date(){yr=mo=day=1;}						//Ĭ�Ϲ��캯�� 
	Date(int y,int m,int d)	{yr=y;mo=m;day=d;}	//���캯�� 
	Date(const Date& dt)						//���ƹ��캯��
		{yr=dt.yr;mo=dt.mo;day=dt.day;}
	Date(long ndays);							//ת�����캯��
	~Date(){}									//��������
//��ֵ�����
	Date& operator=(const Date& dt)				//���Ƹ�ֵ
		{yr=dt.yr;mo=dt.mo;day=dt.day;return *this;}
	Date& operator=(long ndays);				//ת����ֵ���������
//ת��	
	operator long()const; 						//��Աת������
//�����Լ������
	Date operator--(int);						//Date--
//���ݳ�Աȡֵ�͸�ֵ	
	void Set_day(int d){day=d;}					//�޸���

//�������
	friend ostream& operator<<(ostream& ostr,const Date& dt);	//���������
	friend istream& operator>>(istream& istr,Date& dt);			//��ȡ������
	void Display()const{cout<<yr<<'/'<<mo<<'/'<<day<<endl;}		//�������
};

//#include"date.h"
const int Date::dys[]={31,28,31,30,31,30,31,31,30,31,30,31};//��̬���ݶ���
Date::operator long()const			//��Աת����������	
{	
	long ndays=0;					//����1)	
	for(int i=1;i<yr;++i)			//����2)	
		ndays+=Leapyear(i)?366:365;	
	for(i=1;i<mo;++i)				//����3)
		ndays+=dys[i-1];			
	if(mo>2&&Leapyear(yr))			//�������¼�һ��	
		++ndays;	
	ndays+=day;						//����4)
	return ndays;					//����5)
}

Date::Date(long ndays)				//ת�����캯����ʵ��
{
	if(ndays==0)
		yr=mo=day=0;		
	else
	{
		day=ndays; 				//������
		yr=1; 					//����1��
		while(1)
		{
			int n=Leapyear(yr)?366:365;
			if(day<=n)
				break;
			day-=n;
			++yr;
		}
		for(mo=1;mo<13;mo++)	 //����2��
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
Date& Date::operator=(long ndays)	//ת����ֵ�����������ʵ��
{
	if(ndays==0)
		yr=mo=day=0;		
	else
	{
		day=ndays; 				//������
		yr=1; 					//����1��
		while(1)
		{
			int n=Leapyear(yr)?366:365;
			if(day<=n)
				break;
			day-=n;
			++yr;
		}
		for(mo=1;mo<13;mo++)	 //����2��
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

Date Date::operator--(int)	//��--
{
	Date temp(*this);		//���ø��ƹ��캯��
	long ndays=*this;		//���ó�Աת����������*thisת��Ϊ������
	--ndays; 
	*this=ndays;			//����ת����ֵ�������������������ת��ΪDate��
	return temp;
}


ostream& operator<<(ostream& ostr,const Date& dt)//����������Ķ���
{	
	ostr<<dt.yr<<'/'<<dt.mo<<'/'<<dt.day;		
	return ostr;
}

istream& operator>>(istream& istr,Date& dt)//��ȡ�������Ķ���
{	
	istr>>dt.yr>>dt.mo>>dt.day;		
	return istr;
}























	



	


	
