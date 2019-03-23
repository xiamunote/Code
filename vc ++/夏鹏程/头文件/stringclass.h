#include<iostream.h>
#include<stdio.h>
#include<stdlib.h>
#include<cstring>
class String
{
private:
	char *str;	
	int size;		
	void Error(const char* c)const;			//错误信息报告
public:
//构造和析构
	String(const char *c="");				//转换构造
	String(const String& s);				//复制构造
	~String();								//析构
//访问
	String& operator=(const char *c);		//转换赋值:类串=C串
	String& operator=(const String& s);		//复制赋值:类串=类串
	String& Insert(int id,const String& s);	//子串插入 
	String& Erase(int id,int num);			//子串删除
	String SubStr(int id,int num)const;		//求子串

	String operator+(const String& s)const;	//串连接:类串=类串+类串
	String operator+(const char *c)const;	//串连接:类串+C串
	friend String operator+(const char *c,const String& s);//串连接:C串+类串

	bool operator==(const String& s)const;	//串比较：类串==类串
	bool operator==(const char *c)const;	//串比较：类串==C串
	friend bool operator==(const char* c,const String& s);//串比较:C串==类串
	operator char*()const;					//成员转换
	char& String::operator[](int id);		//下标运算符
	const char& String::operator[](int id)const;//常量型下标运算符
	int Size(void)const{return(size);}			//求串长	
	int Find_First_Of(char ch,int id)const;		//字符查找
	int Find_First_Of(const String& s,int id)const;	//字串查找
//输入输出
	friend istream& operator>>(istream& istr,String& s);	//提取符
	friend ostream& operator<<(ostream& ostr,const String& s);//插入符
	int ReadString(istream& istr,char delimiter); //串读取
};


//#include<iostream.h>

//#include"stringclass.h"
String::String(const char *c)//缺省构造函数
{
	size=strlen(c);
	str=new char[size+1];
	if(str==NULL)
		Error("String:overflow!");
	strcpy(str,c);
}

String::String(const String& s)//复制构造函数
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

String String::operator+(const String& s)const//类串+类串
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
String String::operator+(const char *c)const	//类串+C串
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
	return(w);       //相当于String _temp=w; 调用复制构造函数
}

String operator+(const char *c,const String& s1)//C串+类串
{
	String w;//不能简化为return(s1+c),因为连接后的串顺序不对
	delete[]w.str;
	w.size=strlen(c)+s1.size;
	w.str=new char[w.size+1];
	if(w.str==NULL)		//友元不能直接调用私有函数Error
		s1.Error("operator+:overflow!");
	strcpy(w.str,c);
	strcat(w.str,s1.str);
	return(w);
}

String& String::operator=(const String& s)//复制赋值：类串=类串	
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

String& String::operator=(const char *c)	//转换赋值：类串=C串
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

String String::SubStr(int id,int num)const//取子串
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

String& String::Insert(int id,const String& s)//子串插入
{
	char *p, *p1,*buf;
	int len=size;					//记录本串长度
	int len1=s.size;				//记录子串长度
	int left=len-id;				//计算后段长度
	int i;
	if(id<0||id>len)				//检验插入位置的合法性
	   Error("id illegal!"); 
	
	buf=str;						//保留本串的字符串
	str=new char[len+len1+1];		//重新分配本串的字符串空间
	if(str==NULL)
		Error("overflow!");
	strcpy(str, buf);				//取回保留的字符串
	delete[]buf;					//释放保留字符串的空间
	
	p=str+len;						//指向本串结束符
	p1=p+len1;						//指向本串结束符移动的终点
	for(i=1;i<=left+1;i++)				//移动字符是后段字符和串结束符
		*p1--=*p--;

	p=str+id;						//指向插入的起始位置
	p1=s.str;						//指向待插子串的起始位置
	while(*p1!='\0')				//逐个字符插入
		*p++=*p1++;
	size=len+len1;					//修改本串的长度
	return(*this);					//返回插入后的本串
}

String& String::Erase(int id,int num)//子串删除
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
bool String::operator==(const String& s)const	//类串==类串 
{
	return(strcmp(str,s.str)==0);
}
bool String::operator==(const char* c)const	//类串==C串 
{
	return(strcmp(str,c)==0);
}
bool operator==(const char* c,const String& s)	//C串==类串 
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

int String::Find_First_Of(char ch,int id)const//从id开始查找ch首次出现的位置
{
	int i=id;
	char *p;
	if(id<0||id>size-1)		//检验查找起始位置合法性
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
	char buf[256]; 	//256是输入缓冲区长度
	istr>> buf;
	s=buf;			//调用转换赋值函数
	return(istr);
}
int String::ReadString(istream& istr,char delimiter) 
{
	char buf [256];
	int token=-1;
	if(istr.getline(buf,256,delimiter))
	{
		*this= buf;	//调用转换赋值函数
		token=size;
	}
	return(token);
}





