#include<stdio.h>
#include<iostream.h>

#include<stdlib.h>

#include<malloc.h>

#include<string.h>

#include<conio.h>

#define SUCCESS 1

#define UNSUCCESS 0

#define DUPLICATE -1

#define NULL_KEY 0//无记录元素 

int hashsize[]={17,19,23,29};//存储容量 

int m=0;//表长 

typedef struct       

{ int year;      

  int month;     

  int day;       

}date;

typedef struct     

{

  char num[5];      //读者编号记录 

  date  bro;          

  date  back;         

}ReaderNode;

typedef struct       

{

  char title[15];      

  char writer[15];     

  int current;     

  int total;  

  int key;                 //书的编号       

  ReaderNode reader[10];   //记录借读该书的读者记录 

}BookNode;

typedef struct

{

        BookNode *elem; 

        int count;         //记录节点中的总数    

}HashTable;

 

void InitHashTable(HashTable *H)

{ 

   int i;

   (*H).count=0;  

   m=hashsize[0];

   (*H).elem=(BookNode *)malloc(m*sizeof(BookNode));

   for(i=0;i<m;i++)

     (*H).elem[i].key=NULL_KEY; 

}

unsigned Hash(int K)//哈希函数,自己设定

 {  

   return K%m;

 }

 

 void collision(int *p,int d) // 开放定址法处理冲突 

 { 

   *p=(*p+d)%m;

 }

 

int SearchHash(HashTable H,int K,int *p,int *c)//p为数据的地址位置，返回 

 { 

   *p=Hash(K); 

   while(H.elem[*p].key != NULL_KEY && (K != H.elem[*p].key))

   { 

     (*c)++;

     if(*c<m)

       collision(p,*c); //下一地址 

     else

       break;

   }

   if (K  ==  H.elem[*p].key)

     return SUCCESS; 

   else

     return UNSUCCESS; 

 }

int InsertHash(HashTable *H,BookNode e)

{

   int c,p;

   c=0;

   if(SearchHash(*H,e.key,&p,&c))  

     return DUPLICATE;

   else if(c<hashsize[0]/2) 

   { 

     (*H).elem[p]=e;

     ++(*H).count;

     return 1;

   }

   return 0;

}

 

int DeleteHash(HashTable *H,BookNode e)

{

   int c,p;

   c=0;

   if(SearchHash(*H,e.key,&p,&c))  

   {

       (*H).elem[p].key=NULL_KEY;

       --(*H).count; 

       return 1;                               

   }

   else

   { 

        cout<<"不好意思，不存在"<<endl;

   }

   return 0;

}

 

void AddBook(HashTable *H)

{

      BookNode e;

      int i;

      system("CLS");

      cout<<"*****************************************************************************"<<endl;
      cout<<"************              你能在此目录下添加图书信息             ************"<<endl;
      cout<<"*****************************************************************************"<<endl;
      cout<<"请输入书的编号(形如: 1***):";
      cin>>e.key;
	  cout<<endl;
      cout<<"请输入书名:";   
      cin>>e.title;
	  cout<<endl;
      cout<<"请输入该书作者:";
      cin>>e.writer;
	  cout<<endl;
      cout<<"请输入该书现库存量:";
      cin>>e.current;
	  cout<<endl;
      cout<<"请输入该书总库存量:";
      cin>>e.total;
	  cout<<endl;

      for(i=0;i<10;i++)

     
		  (e.reader[i]).num[0]='\0';   //用'\0'来初始化借该书的读者证号，表示一开始时没人借书

      if(InsertHash(&(*H),e))

      cout<<"************              图书添加成功！                         ************"<<endl;

      (*H).count++;  

}

void ShowBook(HashTable H)

{

   int i;

   system("CLS");

   cout<<"*****************************************************************************"<<endl;

   cout<<"********                  你能在此目录查看图书信息                   ********"<<endl;

   cout<<"*****************************************************************************"<<endl;

   for(i=0;i<m;i++)

     if(H.elem[i].key != NULL_KEY) /* 有数据 */

     {

          cout<<"********                  图书编号："<< H.elem[i].key<<"                                ********"<<endl;

          cout<<"********                  书名： 《"<<H.elem[i].title<<"》                               ********"<<endl;

          cout<<"********                  作者： "<<H.elem[i].writer<<"                                   ********"<<endl;

          cout<<"********                  图书现存量： "<<H.elem[i].current<<"                             ********"<<endl;

          cout<<"********                  图书总量  ： "<<H.elem[i].total<<"                             ********"<<endl;

          cout<<"*****************************************************************************"<<endl;

     }

}

void Find(HashTable *H)

{

     int x,p,c;

     system("CLS");

     cout<<"*****************************************************************************"<<endl;

     cout<<"*******                你能在此目录下按编号查找图书信息               *******"<<endl;

     cout<<"*****************************************************************************"<<endl;      

     cout<<"请输入你想查找的书的编号: ";

     cin>>x;
	 cout<<endl;

     if(SearchHash(*H,x,&p,&c))

     {

          cout<<"*******                图书编号："<<(*H).elem[p].key<<"                                   ********"<<endl;

          cout<<"*******                书名： 《"<<(*H).elem[p].title<<"》                                  ********"<<endl;

          cout<<"*******                作者：  "<<(*H).elem[p].writer<<"                                     ********"<<endl;

          cout<<"*******                图书现存量： "<<(*H).elem[p].current<<"                                ********"<<endl;

          cout<<"*******                图书总量  ： "<<(*H).elem[p].total<<"                               ********"<<endl;              

     }

     else

         cout<<"对不起，不存在该书！"<<endl;    

 

}

void BorrowBook(HashTable *H)

{

  int i,k, x, f;
  char t;

  system("CLS");

  cout<<"*****************************************************************************"<<endl;

  cout<<"*******                  你能在此目录下按编号借阅图书                 *******"<<endl;

  cout<<"*****************************************************************************"<<endl;

  cout<<"请输入你想借的书编号: ";

  cin>>x;
  cout<<endl;

  if(SearchHash(*H,x,&k,&f))   

  {

  cout<<"*******                      书名:  《"<<(*H).elem[k].title<<"》                    *******"<<endl;

  cout<<"*******                      作者:   "<<(*H).elem[k].writer<<"                 *******"<<endl;

  cout<<"*******                      现库存量:  "<<(*H).elem[k].current<<"                 *******"<<endl;

  cout<<"*******                      总库存量:  "<<(*H).elem[k].total<<"                 *******"<<endl;
  cout<<"你想借这本书吗 ?(y/n)";
  cin>>t;

        if(t=='y'||t=='Y')

        {

             if( ((*H).elem[k].current)==0)
				 cout<<"\t对不起，这本书已经被借光了..."<<endl;

             else

             {

                  for(i=0;i<10;i++)     

                       if( ((*H).elem[k].reader[i]).num[0]=='\0') break;

                  cout<<"\t    请输入你的借书证号: ";

                  cin>>((*H).elem[k].reader[i]).num;
				  cout<<endl;

                  cout<<"\t    请输入借书日期: "<<endl; //输入借书日期

                  cout<<"\t    年: ";

                  cin>>(((*H).elem[k].reader[i]).bro.year);

                  cout<<"\t    月: ";

                  cin>>(((*H).elem[k].reader[i]).bro.month);

                  cout<<"\t    日: ";

                  cin>>(((*H).elem[k].reader[i]).bro.day);
				  cout<<endl;

 

                  cout<<"\t    输入应还书日期: "<<endl;; //输入应还书日期

                  cout<<"\t    年: ";

                  cin>>(((*H).elem[k].reader[i]).back.year);

                  cout<<"\t    月: ";

                  cin>>(((*H).elem[k].reader[i]).back.month);

                  cout<<"\t    日: ";

                  cin>>(((*H).elem[k].reader[i]).back.day);
				  cout<<endl;

 

                  (*H).elem[k].current--;        //现存书量减1

                  cout<<"\t    你已借了该书."<<endl;

             }

        }

 

     }

  else 
	  cout<<"\t    这本书不存在！"<<endl;    

}

void ReturnBook(HashTable *H)

{

  int i,k, x, f,j;
  char t;

  int year,month,day,d;

  int pay;

  char temp[20];

  system("CLS");

  cout<<"**************************************************"<<endl;

  cout<<"\t你能在此目录下按编号归还图书"<<endl;

  cout<<"**************************************************"<<endl;

  cout<<"\t    请输入你还的书: ";

  cin>>x;

  if(SearchHash(*H,x,&k,&f))

  {

      cout<<"\t    书名:    《"<<(*H).elem[k].title<<"》"<<endl;

      cout<<"\t    作者:     "<<(*H).elem[k].writer<<endl;

      cout<<"\t    现库存量:  "<<(*H).elem[k].current<<endl;

      cout<<"\t    总库存量:  "<<(*H).elem[k].total<<endl;
	  cout<<"\t    你想还这本书吗 ?(y/n)";
      cin>>t;
	  cout<<endl;

      if(t=='y'||t=='Y')

      {

          cout<<"\t    请输入你的借书证号: ";

          cin>>temp;

          j=0;

          for(i=0;i<5;i++)

          {

           if(!(strcmp(temp,((*H).elem[k].reader[i]).num))) {j=1;break;} //查看是否有借书

          }

          if(j==0) 

          { 
			  cout<<"\t    你没有借书."<<endl;
			  return;
		  }  //该借书证号的人没借书

          cout<<"\t    今天是:"<<endl;  

          cout<<"\t    年: "  ;
          cin>>year;

          cout<<"\t    月: ";

          cin>>month;

          cout<<"\t    日: ";

          cin>>day;
		  cout<<endl;

          d=0;

          if(year<((*H).elem[k].reader[i]).back.year) 
			  d=1; //判断是否已过了还书日期,d=1还没过期，d=0过期

          if(year<=((*H).elem[k].reader[i]).back.year && month<((*H).elem[k].reader[i]).back.month)
			  d=1;

          if(year<=((*H).elem[k].reader[i]).back.year && month<=((*H).elem[k].reader[i]).back.month && day<((*H).elem[k].reader[i]).back.day) 
			  d=1;

          if(d==0)

          {

            pay=(year-((*H).elem[k].reader[i]).back.year)*365+(month-((*H).elem[k].reader[i]).back.month)*30+(day-((*H).elem[k].reader[i]).back.day);

			cout<<"\t    你在       "<<((*H).elem[k].reader[i]).bro.year<< "-"<<((*H).elem[k].reader[i]).bro.month<<"-"<<((*H).elem[k].reader[i]).bro.day<<" 借了这本书"<<endl;  

            cout<<"\t    你应该在   "<<((*H).elem[k].reader[i]).back.year<<"-"<<((*H).elem[k].reader[i]).back.month<<"-"<<((*H).elem[k].reader[i]).back.day<<" 还这本书"<<endl;

            cout<<"\t    今天是     "<<year<<"-"<<month<<"-"<<day<<endl;

            cout<<"\t    所以你超出了还书日期,总计 "<<pay<<"天,每天罚款0.1元"<<endl;
			double a=0.1*(double)pay;

            cout<<"\t    你应该被罚款   "<<a<<"  元."<<endl;  //过期一天还1角钱

          }

          ((*H).elem[k].reader[i]).num[0]='\0'; //已还，清除该读者借书记录

          (*H).elem[k].current++;  //现存书量加1

          cout<<"\t    你已经还了这本书."<<endl;

       }

 

  }

  else 
	  cout<<"\t  你要还一本没库存的书 ???"<<endl;  

     

}


void DeleteBook(HashTable H)

{

    int x,p,c,t;

     system("CLS");

     cout<<"**************************************************"<<endl;

     cout<<"\t你能在此目录下按编号删除图书信息"<<endl;

     cout<<"**************************************************"<<endl;      

     cout<<"\t    请输入你想删除的书的编号: "<<endl;

     cin>>x;

     if(SearchHash(H,x,&p,&c))

     {

         

          cout<<"图书编号："<<(H).elem[p].key<<endl;

          cout<<"书名： 《"<<(H).elem[p].title<<"》"<<endl;

          cout<<"作者：  "<<(H).elem[p].writer<<endl;

          cout<<"图书现存量： "<<(H).elem[p].current<<endl;

          cout<<"图书总量  ： "<<(H).elem[p].total<<endl;
		  cout<<"\t    你想删除这本书吗 ?(y/n)"<<endl;

     }

     else

         cout<<"对不起，不存在该书！"<<endl; 

     t=getch();

      if(t=='y'||t=='Y')

      {

           (H).elem[p].key=NULL_KEY;

           cout<<"删除成功！"<<endl;                  

      }

       

}

void menu(void)

{

        system("cls");

        cout<<"*****************************************************************************"<<endl;

        cout<<"************                                         ************************"<<endl;

        cout<<"************                 图书管理系统            ************************"<<endl;

        cout<<"************                                         ************************"<<endl;

        cout<<"*****************************************************************************"<<endl;

        cout<<"************              选择你需要操作的功能:      ************************"<<endl;

        cout<<"************                1.添加图书信息           ************************"<<endl;
		cout<<"************                2.显示图书信息           ************************"<<endl;
		cout<<"************                3.查找图书信息           ************************"<<endl;
		cout<<"************                4.删除图书               ************************"<<endl;
		cout<<"************                5.借阅图书               ************************"<<endl;
		cout<<"************                6.归还图书               ************************"<<endl;
        cout<<"*****************************************************************************"<<endl;     

}

int main()

{
	int c;
	HashTable H;
	system("cls"); 
        cout<<"*****************************************************************************"<<endl;
        cout<<"************                                         ************************"<<endl;
        cout<<"************                 图书管理系统            ************************"<<endl;
        cout<<"************                                         ************************"<<endl;
        cout<<"*****************************************************************************"<<endl;
        cout<<"************             湖北工业大学计算机学院      ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
        cout<<"************               指导老师：董新华          ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
		cout<<"************              班级：16计算机类c班        ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
		cout<<"************              制作团队：第二小组         ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
		cout<<"************              制作时间：2017年12月       ************************"<<endl;
        cout<<"*****************************************************************************"<<endl; 
        cout<<"请按ENTER进入主菜单"<<endl;
        getchar();
        InitHashTable(&H);        

        while(1)

         {

                menu();

                cout<<"选择你需要操作的功能号码:";

                cin>>c;
                switch(c)

                {

                         case 1:

                              AddBook(&(H));break;

                         case 2:

                              ShowBook((H));break;

                         case 3:

                              Find(&(H));break;

                         case 4:

                              DeleteBook(H);break;

                         case 5:

                              BorrowBook(&(H));break;

                         case 6:

                              ReturnBook(&(H));break;

                         default : cout<<"Enter error!!"<<endl;        

                }

                cout<<"请按ENTER返回主菜单"<<endl;

                getchar();

                system("CLS");

         }
		return 0;

}