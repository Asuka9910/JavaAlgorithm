package com.cz;

import java.util.Arrays;
import java.util.Scanner;


/*dp�㷨��*/
public class ChangeDP{



    private int change(int change,int[] value,int[][] d,int[] dp){





        for(int i = 0;i<=change;i++)
        {
            dp[i] = -1;            //��ʼֵ��Ϊ-1�����ܵ���

        }
        dp[0] = 0;

        for(int i = 1;i<=change;i++){           //��������1��ʼ

            for(int j = 0;j<value.length;j++)   //��������Ϊiʱ�������еĳ�Ʊ��ֵ����ƥ��
            {

                if(i-value[j]>=0 && dp[i-value[j]]!=-1){    //i-valueһ��Ҫ���ڣ����Ѿ�dp[i-value]��֮ǰ��ѭ������ֵ ������ǳ����˱߽�����

                    if(dp[i]==-1){                         //������Ϊi��ʱ�򣬵�һ��ѭ��
                        dp[i]=dp[i-value[j]]+1;
                        d[i][j] = d[i-value[j]][j]+1;
                        for(int x =0;x<value.length;x++){
                            if(x == j){
                                continue;
                            }
                            d[i][x] = d[i][x] + d[i-value[j]][x];
                        }

                    }
                    else{                                  //�ǵ�һ�Σ���Ƚ���value[j]Ϊ��ֵ�ĳ�Ʊ+1��֮ǰ�ķ����ĸ�����
                        if(dp[i]>dp[i-value[j]]+1){
                            dp[i] = dp[i-value[j]]+1;
                   /*         d[i][j] = d[i-value[j]][j]+1;*/
                            d[i][j] = d[i-value[j]][j]+1;
                            for(int x =0;x<value.length;x++){
                                if(x == j){

                                    continue;
                                }
                                d[i][x] = 0;
                                d[i][x] = d[i][x] + d[i-value[j]][x];
                            }


                        }
                        else{
                            dp[i] = dp[i];

                        }
                    }
                }

            }


        }

        return dp[change];


    }

/*    private static void reverseArray(int[] arr) {

        for (int i = 0;i < arr.length / 2 ; i++) {

            int temp = arr[i];

            arr[i] = arr[arr.length-1-i];

            arr[arr.length-1-i] = temp;

        }

    }*/


    public static void main(String[] args) {
        ChangeDP ch1 = new ChangeDP();
        Scanner sc1 = new Scanner(System.in);

        System.out.println("������nֵ��");
        int n = sc1.nextInt();
        int change = 30;

        int[] value = new int[n];
        int[][] d = new int[change+1][value.length];
        int[] dp = new int[change+1];


        System.out.println("�����볮Ʊ��ֵ��");
        for (int i = 0; i< n ;i++){
            int b = sc1.nextInt();
            value[i] = b ;
        }

   /*     Arrays.sort(value);
        reverseArray(value);*/

        System.out.println("��Ǯ       ����       ���������");
        ch1.change(30,value,d,dp);

        for(int i = 1 ; i<=30;i++){
            System.out.print(i+"       "+dp[i]+"       ");
            for(int j = 0 ;j<value.length;j++) {
                System.out.print("���Ϊ" + value[j] + "��ֽ�ң�" + d[i][j]+" ");
            }
            System.out.println();
        }


    }
}

