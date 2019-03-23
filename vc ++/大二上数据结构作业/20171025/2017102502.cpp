#include<stdio.h>
#include<malloc.h>
#define MaxSize 100
typedef char ElemType;
typedef struct node{
    ElemType data;      //数据元素
    struct node *left;    //指向左孩子
    struct node *right;    //指向右孩子
}BTNode;
void CreateBTNode(BTNode *&b,char *str){    //由str串创建二叉链
    BTNode *St[MaxSize],*p=NULL;
    int top=-1,k,j=0;
    char ch;
    b=NULL;     //建立的二叉树初始时为空
    ch=str[j];
    while(ch!='\0'){    //str未扫描完时循环
        switch(ch){
            case '(':top++;St[top]=p;k=1;break;     //为左结点
            case ')':top--;break;
            case ',':k=2;break;     //为右结点
            default :p=(BTNode *)malloc(sizeof(BTNode));
                    p->data=ch;
                    p->left=p->right=NULL;
                    if(b==NULL)
                        b=p;        //p指向二叉树的根结点
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

void DispBTNode(BTNode *b){     //以括号表示法输出二叉树
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
void AllPath(BTNode *b){        //采用非递归方法输出从叶子结点到根结点的路径
    struct snode{
        BTNode *node;   //存放当前结点指针
        int parent;     //存放双亲结点在队列中的位置
    }Qu[MaxSize];   //定义顺序队列
    int front,rear,p;       //定义队头和队尾指针
    front=rear=-1;      //置队列为空队列
    rear++;
    Qu[rear].node=b;        //根结点指针进入队列
    Qu[rear].parent=-1;     //根结点没有双亲结点
    while(front<rear){      //队列不为空
        front++;
        b=Qu[front].node;       //队头出队列
        if(b->left==NULL && b->right==NULL){ //*b为叶子结点
            printf("%c到根结点路径：",b->data);
            p=front;
            while(Qu[p].parent!=-1){
                printf("%c ",Qu[p].node->data);
                p=Qu[p].parent;
            }
            printf("%c\n",Qu[p].node->data);
        }
        if(b->left!=NULL){    //左孩子入队列
            rear++;
            Qu[rear].node=b->left;
            Qu[rear].parent=front;
        }
        if(b->right!=NULL){    //右孩子入队列
            rear++;
            Qu[rear].node=b->right;
            Qu[rear].parent=front;
        }
    }
}
void AllPath1(BTNode *b,ElemType path[],int pathlen){   //采用递归方法输出从叶子结点到根结点的路径
    int i;
    if(b!=NULL){
        if(b->left==NULL && b->right==NULL){ //*b为叶子结点
            printf("%c到根结点路径：%c ",b->data,b->data);
            for(i=pathlen-1;i>=0;i--)
                printf("%c ",path[i]);
            printf("\n");
        }else{
            path[pathlen]=b->data;  //将当前结点放入路径中
            pathlen++;
            AllPath1(b->left,path,pathlen);   //递归扫描左子树
            AllPath1(b->right,path,pathlen);   //递归扫描右子树
            pathlen--;
        }
    }
}
void LongPath(BTNode *b,ElemType path[],int pathlen,ElemType longpath[],int &longpathlen){  //求最长路径
    int i;
    if(b==NULL){
        if(pathlen>longpathlen){    //若当前路径更长，将路径保存在longpath中
            for(i=pathlen-1;i>=0;i--)
                longpath[i]=path[i];
            longpathlen=pathlen;
        }
    }else{
        path[pathlen]=b->data;      //将当前结点放入路径中
        pathlen++;      //路径长度增1
        LongPath(b->left,path,pathlen,longpath,longpathlen);  //递归扫描左子树
        LongPath(b->right,path,pathlen,longpath,longpathlen);  //递归扫描右子树
        pathlen--;      //恢复环境
    }
}
void DispLeaf(BTNode *b){   //输出叶子结点
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
    printf("二叉树b:");DispBTNode(b);printf("\n\n");
    printf("b的叶子结点：");DispLeaf(b);printf("\n\n");
    printf("AllPath:\n");AllPath(b);printf("\n");
    printf("AllPath1:\n");AllPath1(b,path,0);printf("\n");
    LongPath(b,path,0,longpath,longpathlen);
    printf("第一条最长路径长度：%d\n",longpathlen);
    printf("第一条最长路径：");
    for(i=longpathlen;i>=0;i--)
        printf("%c ",longpath[i]);
    printf("\n");
    return 0;
}