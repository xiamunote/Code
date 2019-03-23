#include<stdio.h>
#include<malloc.h>
#define MaxSize 100
typedef char ElemType;
typedef struct node{
    ElemType data;      //����Ԫ��
    struct node *left;    //ָ������
    struct node *right;    //ָ���Һ���
}BTNode;
void CreateBTNode(BTNode *&b,char *str){    //��str������������
    BTNode *St[MaxSize],*p=NULL;
    int top=-1,k,j=0;
    char ch;
    b=NULL;     //�����Ķ�������ʼʱΪ��
    ch=str[j];
    while(ch!='\0'){    //strδɨ����ʱѭ��
        switch(ch){
            case '(':top++;St[top]=p;k=1;break;     //Ϊ����
            case ')':top--;break;
            case ',':k=2;break;     //Ϊ�ҽ��
            default :p=(BTNode *)malloc(sizeof(BTNode));
                    p->data=ch;
                    p->left=p->right=NULL;
                    if(b==NULL)
                        b=p;        //pָ��������ĸ����
                    else{
                        switch(k){
                            case 1:St[top]->left=p;break;
                            case 2:St[top]->right=p;break;
                        }
                    }
        }
        j++;
        ch=str[j];
    }
}

void DispBTNode(BTNode *b){     //�����ű�ʾ�����������
    if(b!=NULL){
        printf("%c",b->data);
        if(b->left!=NULL || b->right!=NULL){
            printf("(");
            DispBTNode(b->left);
            if(b->right!=NULL)
                printf(",");
            DispBTNode(b->right);
            printf(")");
        }
    }
}
void AllPath(BTNode *b){        //���÷ǵݹ鷽�������Ҷ�ӽ�㵽������·��
    struct snode{
        BTNode *node;   //��ŵ�ǰ���ָ��
        int parent;     //���˫�׽���ڶ����е�λ��
    }Qu[MaxSize];   //����˳�����
    int front,rear,p;       //�����ͷ�Ͷ�βָ��
    front=rear=-1;      //�ö���Ϊ�ն���
    rear++;
    Qu[rear].node=b;        //�����ָ��������
    Qu[rear].parent=-1;     //�����û��˫�׽��
    while(front<rear){      //���в�Ϊ��
        front++;
        b=Qu[front].node;       //��ͷ������
        if(b->left==NULL && b->right==NULL){ //*bΪҶ�ӽ��
            printf("%c�������·����",b->data);
            p=front;
            while(Qu[p].parent!=-1){
                printf("%c ",Qu[p].node->data);
                p=Qu[p].parent;
            }
            printf("%c\n",Qu[p].node->data);
        }
        if(b->left!=NULL){    //���������
            rear++;
            Qu[rear].node=b->left;
            Qu[rear].parent=front;
        }
        if(b->right!=NULL){    //�Һ��������
            rear++;
            Qu[rear].node=b->right;
            Qu[rear].parent=front;
        }
    }
}
void AllPath1(BTNode *b,ElemType path[],int pathlen){   //���õݹ鷽�������Ҷ�ӽ�㵽������·��
    int i;
    if(b!=NULL){
        if(b->left==NULL && b->right==NULL){ //*bΪҶ�ӽ��
            printf("%c�������·����%c ",b->data,b->data);
            for(i=pathlen-1;i>=0;i--)
                printf("%c ",path[i]);
            printf("\n");
        }else{
            path[pathlen]=b->data;  //����ǰ������·����
            pathlen++;
            AllPath1(b->left,path,pathlen);   //�ݹ�ɨ��������
            AllPath1(b->right,path,pathlen);   //�ݹ�ɨ��������
            pathlen--;
        }
    }
}
void LongPath(BTNode *b,ElemType path[],int pathlen,ElemType longpath[],int &longpathlen){  //���·��
    int i;
    if(b==NULL){
        if(pathlen>longpathlen){    //����ǰ·����������·��������longpath��
            for(i=pathlen-1;i>=0;i--)
                longpath[i]=path[i];
            longpathlen=pathlen;
        }
    }else{
        path[pathlen]=b->data;      //����ǰ������·����
        pathlen++;      //·��������1
        LongPath(b->left,path,pathlen,longpath,longpathlen);  //�ݹ�ɨ��������
        LongPath(b->right,path,pathlen,longpath,longpathlen);  //�ݹ�ɨ��������
        pathlen--;      //�ָ�����
    }
}
void DispLeaf(BTNode *b){   //���Ҷ�ӽ��
    if(b!=NULL){
        if(b->left==NULL && b->right==NULL)
            printf("%c ",b->data);
        else{
            DispLeaf(b->left);
            DispLeaf(b->right);
        }
    }
}
int main()
{
    BTNode *b;
    ElemType path[MaxSize],longpath[MaxSize];
    int i,longpathlen=0;
    CreateBTNode(b,"A(B(D,E(H(J,K(L,M(,N))))),C(F,G(,I)))");
    printf("������b:");DispBTNode(b);printf("\n\n");
    printf("b��Ҷ�ӽ�㣺");DispLeaf(b);printf("\n\n");
    printf("AllPath:\n");AllPath(b);printf("\n");
    printf("AllPath1:\n");AllPath1(b,path,0);printf("\n");
    LongPath(b,path,0,longpath,longpathlen);
    printf("��һ���·�����ȣ�%d\n",longpathlen);
    printf("��һ���·����");
    for(i=longpathlen;i>=0;i--)
        printf("%c ",longpath[i]);
    printf("\n");
    return 0;
}