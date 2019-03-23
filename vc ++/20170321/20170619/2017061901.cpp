#include <iostream>
#include <algorithm>
#define MAX_NUM 1000
using namespace std;
 
struct Goods //info of goods������Ʒ��Ϣ�ṹ��
{
    int weight;// the weight of goods����
    int value;// the value of goods��ֵ
    double ValPerWei;// value per weightȨ��
    double load; //��Ʒװ�뱳���Ĳ��ֵ�ϵ����������ͼ����Ʒȫ��װ����loadΪ1��װ��10/20��loadΪ0.5��
};
int cmp( Goods const &a, Goods const &b)//����sort�����ıȽϺ���
{
    if(a.ValPerWei<b.ValPerWei) return 0;
    else return 1;
}
void Greedy(Goods g[],int good_num, int content)//̰���㷨
{
    for(int i=0; i<good_num; i++)
    {
        if(content>g[i].weight)//��������㹻װ��������Ʒ
        {
            content-=g[i].weight;
            g[i].load=1;
        }
        else if(content>0){//�������������װ��������Ʒ
            g[i].load=(double)content/g[i].weight;//������Ʒװ�뱳���Ĳ���
            content=0;//����������0
            return;//�������������
        }
    }
}
int main()
{
    int goods_num;
    int bagvol;
    double total_value=0;
    double total_weight=0;
    cout<<"Please input the volum of bag:"<<endl;
    cin>>bagvol;
    cout<<"Please input the number of goods:"<<endl;
    cin>>goods_num;
    Goods G[goods_num+1];
    cout<<"Please inuput the weight and value of goods:"<<endl;
    for(int i=0; i<goods_num; i++)
    {
        cin>>G[i].weight>>G[i].value;//����������ֵ
        G[i].ValPerWei=(double)G[i].value/G[i].weight;//����Ȩ��
        G[i].load=0;//load��0
    }
 
    sort (G,G+goods_num,cmp);//sort by ValPerWei
 
    Greedy(G,goods_num,bagvol);
    cout<<"Info of loaded goods:"<<endl;
    for(int i=0;i<goods_num;i++)//output the info of goods
    {
        if(G[i].load==0.0)break;//�����⵽��Ʒδ��װ�뱳�������Ƴ�ѭ��
 
        total_value+=(G[i].value*G[i].load);//װ�뱳������Ʒ�ܼ�ֵ
        total_weight+=(G[i].weight*G[i].load);//װ�뱳������Ʒ������
        cout<<"weight: "<<G[i].weight<<"  "<<"value: "<<G[i].value<<"  "<<"the value per weight of good: "<<G[i].ValPerWei<<"  the part of goods: "<<G[i].load<<endl;//���װ�뱳������Ʒ��Ϣ
    }
    cout<<"the volum of bag is: "<<bagvol<<endl;//�����������
    cout<<"the total weight is: "<<total_weight<<endl;//���װ����Ʒ��������
    cout<<"the total value is: "<<total_value<<endl;//���װ����Ʒ���ܼ�ֵ

