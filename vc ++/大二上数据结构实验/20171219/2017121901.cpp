#include<stdio.h>
#include<iostream.h>

#include<stdlib.h>

#include<malloc.h>

#include<string.h>

#include<conio.h>

#define SUCCESS 1

#define UNSUCCESS 0

#define DUPLICATE -1

#define NULL_KEY 0//�޼�¼Ԫ�� 

int hashsize[]={17,19,23,29};//�洢���� 

int m=0;//�� 

typedef struct       

{ int year;      

  int month;     

  int day;       

}date;

typedef struct     

{

  char num[5];      //���߱�ż�¼ 

  date  bro;          

  date  back;         

}ReaderNode;

typedef struct       

{

  char title[15];      

  char writer[15];     

  int current;     

  int total;  

  int key;                 //��ı��       

  ReaderNode reader[10];   //��¼�������Ķ��߼�¼ 

}BookNode;

typedef struct

{

        BookNode *elem; 

        int count;         //��¼�ڵ��е�����    

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

unsigned Hash(int K)//��ϣ����,�Լ��趨

 {  

   return K%m;

 }

 

 void collision(int *p,int d) // ���Ŷ�ַ�������ͻ 

 { 

   *p=(*p+d)%m;

 }

 

int SearchHash(HashTable H,int K,int *p,int *c)//pΪ���ݵĵ�ַλ�ã����� 

 { 

   *p=Hash(K); 

   while(H.elem[*p].key != NULL_KEY && (K != H.elem[*p].key))

   { 

     (*c)++;

     if(*c<m)

       collision(p,*c); //��һ��ַ 

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

        cout<<"������˼��������"<<endl;

   }

   return 0;

}

 

void AddBook(HashTable *H)

{

      BookNode e;

      int i;

      system("CLS");

      cout<<"*****************************************************************************"<<endl;
      cout<<"************              �����ڴ�Ŀ¼�����ͼ����Ϣ             ************"<<endl;
      cout<<"*****************************************************************************"<<endl;
      cout<<"��������ı��(����: 1***):";
      cin>>e.key;
	  cout<<endl;
      cout<<"����������:";   
      cin>>e.title;
	  cout<<endl;
      cout<<"�������������:";
      cin>>e.writer;
	  cout<<endl;
      cout<<"����������ֿ����:";
      cin>>e.current;
	  cout<<endl;
      cout<<"����������ܿ����:";
      cin>>e.total;
	  cout<<endl;

      for(i=0;i<10;i++)

     
		  (e.reader[i]).num[0]='\0';   //��'\0'����ʼ�������Ķ���֤�ţ���ʾһ��ʼʱû�˽���

      if(InsertHash(&(*H),e))

      cout<<"************              ͼ����ӳɹ���                         ************"<<endl;

      (*H).count++;  

}

void ShowBook(HashTable H)

{

   int i;

   system("CLS");

   cout<<"*****************************************************************************"<<endl;

   cout<<"********                  �����ڴ�Ŀ¼�鿴ͼ����Ϣ                   ********"<<endl;

   cout<<"*****************************************************************************"<<endl;

   for(i=0;i<m;i++)

     if(H.elem[i].key != NULL_KEY) /* ������ */

     {

          cout<<"********                  ͼ���ţ�"<< H.elem[i].key<<"                                ********"<<endl;

          cout<<"********                  ������ ��"<<H.elem[i].title<<"��                               ********"<<endl;

          cout<<"********                  ���ߣ� "<<H.elem[i].writer<<"                                   ********"<<endl;

          cout<<"********                  ͼ���ִ����� "<<H.elem[i].current<<"                             ********"<<endl;

          cout<<"********                  ͼ������  �� "<<H.elem[i].total<<"                             ********"<<endl;

          cout<<"*****************************************************************************"<<endl;

     }

}

void Find(HashTable *H)

{

     int x,p,c;

     system("CLS");

     cout<<"*****************************************************************************"<<endl;

     cout<<"*******                �����ڴ�Ŀ¼�°���Ų���ͼ����Ϣ               *******"<<endl;

     cout<<"*****************************************************************************"<<endl;      

     cout<<"������������ҵ���ı��: ";

     cin>>x;
	 cout<<endl;

     if(SearchHash(*H,x,&p,&c))

     {

          cout<<"*******                ͼ���ţ�"<<(*H).elem[p].key<<"                                   ********"<<endl;

          cout<<"*******                ������ ��"<<(*H).elem[p].title<<"��                                  ********"<<endl;

          cout<<"*******                ���ߣ�  "<<(*H).elem[p].writer<<"                                     ********"<<endl;

          cout<<"*******                ͼ���ִ����� "<<(*H).elem[p].current<<"                                ********"<<endl;

          cout<<"*******                ͼ������  �� "<<(*H).elem[p].total<<"                               ********"<<endl;              

     }

     else

         cout<<"�Բ��𣬲����ڸ��飡"<<endl;    

 

}

void BorrowBook(HashTable *H)

{

  int i,k, x, f;
  char t;

  system("CLS");

  cout<<"*****************************************************************************"<<endl;

  cout<<"*******                  �����ڴ�Ŀ¼�°���Ž���ͼ��                 *******"<<endl;

  cout<<"*****************************************************************************"<<endl;

  cout<<"����������������: ";

  cin>>x;
  cout<<endl;

  if(SearchHash(*H,x,&k,&f))   

  {

  cout<<"*******                      ����:  ��"<<(*H).elem[k].title<<"��                    *******"<<endl;

  cout<<"*******                      ����:   "<<(*H).elem[k].writer<<"                 *******"<<endl;

  cout<<"*******                      �ֿ����:  "<<(*H).elem[k].current<<"                 *******"<<endl;

  cout<<"*******                      �ܿ����:  "<<(*H).elem[k].total<<"                 *******"<<endl;
  cout<<"������Ȿ���� ?(y/n)";
  cin>>t;

        if(t=='y'||t=='Y')

        {

             if( ((*H).elem[k].current)==0)
				 cout<<"\t�Բ����Ȿ���Ѿ��������..."<<endl;

             else

             {

                  for(i=0;i<10;i++)     

                       if( ((*H).elem[k].reader[i]).num[0]=='\0') break;

                  cout<<"\t    ��������Ľ���֤��: ";

                  cin>>((*H).elem[k].reader[i]).num;
				  cout<<endl;

                  cout<<"\t    �������������: "<<endl; //�����������

                  cout<<"\t    ��: ";

                  cin>>(((*H).elem[k].reader[i]).bro.year);

                  cout<<"\t    ��: ";

                  cin>>(((*H).elem[k].reader[i]).bro.month);

                  cout<<"\t    ��: ";

                  cin>>(((*H).elem[k].reader[i]).bro.day);
				  cout<<endl;

 

                  cout<<"\t    ����Ӧ��������: "<<endl;; //����Ӧ��������

                  cout<<"\t    ��: ";

                  cin>>(((*H).elem[k].reader[i]).back.year);

                  cout<<"\t    ��: ";

                  cin>>(((*H).elem[k].reader[i]).back.month);

                  cout<<"\t    ��: ";

                  cin>>(((*H).elem[k].reader[i]).back.day);
				  cout<<endl;

 

                  (*H).elem[k].current--;        //�ִ�������1

                  cout<<"\t    ���ѽ��˸���."<<endl;

             }

        }

 

     }

  else 
	  cout<<"\t    �Ȿ�鲻���ڣ�"<<endl;    

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

  cout<<"\t�����ڴ�Ŀ¼�°���Ź黹ͼ��"<<endl;

  cout<<"**************************************************"<<endl;

  cout<<"\t    �������㻹����: ";

  cin>>x;

  if(SearchHash(*H,x,&k,&f))

  {

      cout<<"\t    ����:    ��"<<(*H).elem[k].title<<"��"<<endl;

      cout<<"\t    ����:     "<<(*H).elem[k].writer<<endl;

      cout<<"\t    �ֿ����:  "<<(*H).elem[k].current<<endl;

      cout<<"\t    �ܿ����:  "<<(*H).elem[k].total<<endl;
	  cout<<"\t    ���뻹�Ȿ���� ?(y/n)";
      cin>>t;
	  cout<<endl;

      if(t=='y'||t=='Y')

      {

          cout<<"\t    ��������Ľ���֤��: ";

          cin>>temp;

          j=0;

          for(i=0;i<5;i++)

          {

           if(!(strcmp(temp,((*H).elem[k].reader[i]).num))) {j=1;break;} //�鿴�Ƿ��н���

          }

          if(j==0) 

          { 
			  cout<<"\t    ��û�н���."<<endl;
			  return;
		  }  //�ý���֤�ŵ���û����

          cout<<"\t    ������:"<<endl;  

          cout<<"\t    ��: "  ;
          cin>>year;

          cout<<"\t    ��: ";

          cin>>month;

          cout<<"\t    ��: ";

          cin>>day;
		  cout<<endl;

          d=0;

          if(year<((*H).elem[k].reader[i]).back.year) 
			  d=1; //�ж��Ƿ��ѹ��˻�������,d=1��û���ڣ�d=0����

          if(year<=((*H).elem[k].reader[i]).back.year && month<((*H).elem[k].reader[i]).back.month)
			  d=1;

          if(year<=((*H).elem[k].reader[i]).back.year && month<=((*H).elem[k].reader[i]).back.month && day<((*H).elem[k].reader[i]).back.day) 
			  d=1;

          if(d==0)

          {

            pay=(year-((*H).elem[k].reader[i]).back.year)*365+(month-((*H).elem[k].reader[i]).back.month)*30+(day-((*H).elem[k].reader[i]).back.day);

			cout<<"\t    ����       "<<((*H).elem[k].reader[i]).bro.year<< "-"<<((*H).elem[k].reader[i]).bro.month<<"-"<<((*H).elem[k].reader[i]).bro.day<<" �����Ȿ��"<<endl;  

            cout<<"\t    ��Ӧ����   "<<((*H).elem[k].reader[i]).back.year<<"-"<<((*H).elem[k].reader[i]).back.month<<"-"<<((*H).elem[k].reader[i]).back.day<<" ���Ȿ��"<<endl;

            cout<<"\t    ������     "<<year<<"-"<<month<<"-"<<day<<endl;

            cout<<"\t    �����㳬���˻�������,�ܼ� "<<pay<<"��,ÿ�췣��0.1Ԫ"<<endl;
			double a=0.1*(double)pay;

            cout<<"\t    ��Ӧ�ñ�����   "<<a<<"  Ԫ."<<endl;  //����һ�컹1��Ǯ

          }

          ((*H).elem[k].reader[i]).num[0]='\0'; //�ѻ�������ö��߽����¼

          (*H).elem[k].current++;  //�ִ�������1

          cout<<"\t    ���Ѿ������Ȿ��."<<endl;

       }

 

  }

  else 
	  cout<<"\t  ��Ҫ��һ��û������ ???"<<endl;  

     

}


void DeleteBook(HashTable H)

{

    int x,p,c,t;

     system("CLS");

     cout<<"**************************************************"<<endl;

     cout<<"\t�����ڴ�Ŀ¼�°����ɾ��ͼ����Ϣ"<<endl;

     cout<<"**************************************************"<<endl;      

     cout<<"\t    ����������ɾ������ı��: "<<endl;

     cin>>x;

     if(SearchHash(H,x,&p,&c))

     {

         

          cout<<"ͼ���ţ�"<<(H).elem[p].key<<endl;

          cout<<"������ ��"<<(H).elem[p].title<<"��"<<endl;

          cout<<"���ߣ�  "<<(H).elem[p].writer<<endl;

          cout<<"ͼ���ִ����� "<<(H).elem[p].current<<endl;

          cout<<"ͼ������  �� "<<(H).elem[p].total<<endl;
		  cout<<"\t    ����ɾ���Ȿ���� ?(y/n)"<<endl;

     }

     else

         cout<<"�Բ��𣬲����ڸ��飡"<<endl; 

     t=getch();

      if(t=='y'||t=='Y')

      {

           (H).elem[p].key=NULL_KEY;

           cout<<"ɾ���ɹ���"<<endl;                  

      }

       

}

void menu(void)

{

        system("cls");

        cout<<"*****************************************************************************"<<endl;

        cout<<"************                                         ************************"<<endl;

        cout<<"************                 ͼ�����ϵͳ            ************************"<<endl;

        cout<<"************                                         ************************"<<endl;

        cout<<"*****************************************************************************"<<endl;

        cout<<"************              ѡ������Ҫ�����Ĺ���:      ************************"<<endl;

        cout<<"************                1.���ͼ����Ϣ           ************************"<<endl;
		cout<<"************                2.��ʾͼ����Ϣ           ************************"<<endl;
		cout<<"************                3.����ͼ����Ϣ           ************************"<<endl;
		cout<<"************                4.ɾ��ͼ��               ************************"<<endl;
		cout<<"************                5.����ͼ��               ************************"<<endl;
		cout<<"************                6.�黹ͼ��               ************************"<<endl;
        cout<<"*****************************************************************************"<<endl;     

}

int main()

{
	int c;
	HashTable H;
	system("cls"); 
        cout<<"*****************************************************************************"<<endl;
        cout<<"************                                         ************************"<<endl;
        cout<<"************                 ͼ�����ϵͳ            ************************"<<endl;
        cout<<"************                                         ************************"<<endl;
        cout<<"*****************************************************************************"<<endl;
        cout<<"************             ������ҵ��ѧ�����ѧԺ      ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
        cout<<"************               ָ����ʦ�����»�          ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
		cout<<"************              �༶��16�������c��        ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
		cout<<"************              �����Ŷӣ��ڶ�С��         ************************"<<endl;
		cout<<"************                                         ************************"<<endl;
		cout<<"************              ����ʱ�䣺2017��12��       ************************"<<endl;
        cout<<"*****************************************************************************"<<endl; 
        cout<<"�밴ENTER�������˵�"<<endl;
        getchar();
        InitHashTable(&H);        

        while(1)

         {

                menu();

                cout<<"ѡ������Ҫ�����Ĺ��ܺ���:";

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

                cout<<"�밴ENTER�������˵�"<<endl;

                getchar();

                system("CLS");

         }
		return 0;

}