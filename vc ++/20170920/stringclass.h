#include<iostream.h>
#include<stdio.h>
#include<stdlib.h>
#include<cstring>
class String
{
private:
	char *str;	
	int size;		
	void Error(const char* c)const;			//������Ϣ����
public:
//���������
	String(const char *c="");				//ת������
	String(const String& s);				//���ƹ���
	~String();								//����
//����
	String& operator=(const char *c);		//ת����ֵ:�മ=C��
	String& operator=(const String& s);		//���Ƹ�ֵ:�മ=�മ
	String& Insert(int id,const String& s);	//�Ӵ����� 
	String& Erase(int id,int num);			//�Ӵ�ɾ��
	String SubStr(int id,int num)const;		//���Ӵ�

	String operator+(const String& s)const;	//������:�മ=�മ+�മ
	String operator+(const char *c)const;	//������:�മ+C��
	friend String operator+(const char *c,const String& s);//������:C��+�മ

	bool operator==(const String& s)const;	//���Ƚϣ��മ==�മ
	bool operator==(const char *c)const;	//���Ƚϣ��മ==C��
	friend bool operator==(const char* c,const String& s);//���Ƚ�:C��==�മ
	operator char*()const;					//��Աת��
	char& String::operator[](int id);		//�±������
	const char& String::operator[](int id)const;//�������±������
	int Size(void)const{return(size);}			//�󴮳�	
	int Find_First_Of(char ch,int id)const;		//�ַ�����
	int Find_First_Of(const String& s,int id)const;	//�ִ�����
//�������
	friend istream& operator>>(istream& istr,String& s);	//��ȡ��
	friend ostream& operator<<(ostream& ostr,const String& s);//�����
	int ReadString(istream& istr,char delimiter); //����ȡ
};


//#include<iostream.h>

//#include"stringclass.h"
String::String(const char *c)//ȱʡ���캯��
{
	size=strlen(c);
	str=new char[size+1];
	if(str==NULL)
		Error("String:overflow!");
	strcpy(str,c);
}

String::String(const String& s)//���ƹ��캯��
{
	size=s.size;
	str=new char[size+1];
	if(str==NULL)
		Error("String:overflow!");
	strcpy(str,s.str);
}


String::~String()
{
	delete[]str;
}
void String::Error(const char* c)const
{
	cout<<c<<endl;
	exit(1);
}

String String::operator+(const String& s)const//�മ+�മ
{
	String w;
	int len=size+s.size;
	delete[]w.str;
	w.str=new char[len+1];
	if(w.str==NULL)
		Error("operator+:overflow!");
	strcpy(w.str,str);
	strcat(w.str,s.str);
	w.size=len;
	return(w);
}
String String::operator+(const char *c)const	//�മ+C��
{
	String w;
	int len=size+strlen(c);
	delete[]w.str;
	w.str=new char[len+1];
	if(w.str==NULL)
		Error("operator+:overflow!");
	strcpy(w.str,str);
	strcat(w.str,c);
	w.size=len;
	return(w);       //�൱��String _temp=w; ���ø��ƹ��캯��
}

String operator+(const char *c,const String& s1)//C��+�മ
{
	String w;//���ܼ�Ϊreturn(s1+c),��Ϊ���Ӻ�Ĵ�˳�򲻶�
	delete[]w.str;
	w.size=strlen(c)+s1.size;
	w.str=new char[w.size+1];
	if(w.str==NULL)		//��Ԫ����ֱ�ӵ���˽�к���Error
		s1.Error("operator+:overflow!");
	strcpy(w.str,c);
	strcat(w.str,s1.str);
	return(w);
}

String& String::operator=(const String& s)//���Ƹ�ֵ���മ=�മ	
{
	if(size!= s.size)
	{
		delete[]str;
		str=new char[s.size+1];
		if(str==NULL)
			Error("operator=:overflow!");
		size=s.size;
	}
	strcpy(str, s.str);
	return(*this);
}

String& String::operator=(const char *c)	//ת����ֵ���മ=C��
{
	int len=strlen(c);
	if(size!=len)
	{
		delete[]str;
		str=new char[len+1];
		if(str==NULL)
			Error("operator=:overflow!");
		size=len;
	}
	strcpy(str,c);
	return(*this);
}

String String::SubStr(int id,int num)const//ȡ�Ӵ�
{
	String s;
	int len=size;
	int left=len-id,i; 
	if(id<0||id>len-1)	  
		Error("id illegal!");
	if(num<=0||num>left)   
		Error("num illegal!");
	delete[]s.str;
	s.str=new char[num+1];
	if(s.str==NULL)
		Error("overflow!");
	s.size=num;
	char* p=str+id;
	char* p1=s.str;
	for(i=1;i<=num;i++)
		*p1++=*p++;
	*p1='\0';
	return(s);
}

String& String::Insert(int id,const String& s)//�Ӵ�����
{
	char *p, *p1,*buf;
	int len=size;					//��¼��������
	int len1=s.size;				//��¼�Ӵ�����
	int left=len-id;				//�����γ���
	int i;
	if(id<0||id>len)				//�������λ�õĺϷ���
	   Error("id illegal!"); 
	
	buf=str;						//�����������ַ���
	str=new char[len+len1+1];		//���·��䱾�����ַ����ռ�
	if(str==NULL)
		Error("overflow!");
	strcpy(str, buf);				//ȡ�ر������ַ���
	delete[]buf;					//�ͷű����ַ����Ŀռ�
	
	p=str+len;						//ָ�򱾴�������
	p1=p+len1;						//ָ�򱾴��������ƶ����յ�
	for(i=1;i<=left+1;i++)				//�ƶ��ַ��Ǻ���ַ��ʹ�������
		*p1--=*p--;

	p=str+id;						//ָ��������ʼλ��
	p1=s.str;						//ָ������Ӵ�����ʼλ��
	while(*p1!='\0')				//����ַ�����
		*p++=*p1++;
	size=len+len1;					//�޸ı����ĳ���
	return(*this);					//���ز����ı���
}

String& String::Erase(int id,int num)//�Ӵ�ɾ��
{
	char *p,*q,*buf;
	int len=size;
	int left=len-id;
	if(id<0||id>len-1)	
		Error("id illegal!");
	if(num<=0||num>left)				
		Error("num illegal!");
	p=str+id;
	q=str+id+num;
	while(*q!='\0')
		*p++=*q++;
	*p='\0';
	buf=str;
	len=strlen(buf);
	str=new char[len +1];
	if(str==NULL)
		Error("overflow!");
	strcpy(str,buf);
    size=len;
	delete[]buf;
	return(*this);
}
bool String::operator==(const String& s)const	//�മ==�മ 
{
	return(strcmp(str,s.str)==0);
}
bool String::operator==(const char* c)const	//�മ==C�� 
{
	return(strcmp(str,c)==0);
}
bool operator==(const char* c,const String& s)	//C��==�മ 
{
	return(strcmp(c,s.str)==0);
}
String::operator char*(void)const
{
	char *c=new char[size+1];
	if(c==NULL)
		Error("overflow");
	strcpy(c,str);
	return(c);
}

char& String::operator[](int id)	
{
	if(id<0||id>size-1)
		Error("operator[]:Id illegal!");
	return(*(str+id));	//return(str[id]);
}

const char& String::operator[](int id)const
{
	if(id<0||id>size-1)
		Error("operator[]:Id illegal!");
	return(*(str+id));	//return(str[id]);
}

int String::Find_First_Of(char ch,int id)const//��id��ʼ����ch�״γ��ֵ�λ��
{
	int i=id;
	char *p;
	if(id<0||id>size-1)		//���������ʼλ�úϷ���
		Error("Start illegal!"); 
	p=str+id;
	while(*p!='\0')
		if(*p==ch)
			break;
		else
		{
			i++;	p++;
		}
	return(*p=='\0'?-1:i);			
}

int String::Find_First_Of(const String& s,int id)const
{
		int len=s.Size(),end=Size()-1;
		char first=s[0], last=s[len-1];
		int firstid,lastid;	
		String mid,cs;
		
		if(len>2)	
			mid=s.SubStr(1,len-2);
		firstid=Find_First_Of(first,id);
		lastid=firstid+len-1;
		while(firstid!=-1&&lastid<=end) 
		{
			if(str[lastid]==last)	
			{
		    	if(len<=2)	
			  		return(firstid);	
				cs=SubStr(firstid+1,len-2);
				if(cs==mid)
			 		return(firstid);
			}
			id=firstid+1;	
			firstid=Find_First_Of(first,id);
			lastid=firstid+len-1;
		}
		return(-1);
}


ostream& operator<<(ostream& ostr,const String& s)
{
		ostr<<s.str;
		return(ostr);
}
istream& operator>>(istream& istr,String& s)
{
	char buf[256]; 	//256�����뻺��������
	istr>> buf;
	s=buf;			//����ת����ֵ����
	return(istr);
}
int String::ReadString(istream& istr,char delimiter) 
{
	char buf [256];
	int token=-1;
	if(istr.getline(buf,256,delimiter))
	{
		*this= buf;	//����ת����ֵ����
		token=size;
	}
	return(token);
}





