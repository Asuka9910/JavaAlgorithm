package com.cz;

import java.util.Arrays;
import java.util.Scanner;


/*dp算法版*/
public class ChangeDP{



    private int change(int change,int[] value,int[][] d,int[] dp){





        for(int i = 0;i<=change;i++)
        {
            dp[i] = -1;            //初始值置为-1，不能到达

        }
        dp[0] = 0;

        for(int i = 1;i<=change;i++){           //从找零数1开始

            for(int j = 0;j<value.length;j++)   //当找零数为i时，对所有的钞票数值进行匹配
            {

                if(i-value[j]>=0 && dp[i-value[j]]!=-1){    //i-value一定要存在，且已经dp[i-value]被之前的循环所赋值 否则就是出现了边界问题

                    if(dp[i]==-1){                         //当找零为i的时候，第一次循环
                        dp[i]=dp[i-value[j]]+1;
                        d[i][j] = d[i-value[j]][j]+1;
                        for(int x =0;x<value.length;x++){
                            if(x == j){
                                continue;
                            }
                            d[i][x] = d[i][x] + d[i-value[j]][x];
                        }

                    }
                    else{                                  //非第一次，则比较以value[j]为面值的钞票+1与之前的方法哪个更优
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

        System.out.println("请输入n值：");
        int n = sc1.nextInt();
        int change = 30;

        int[] value = new int[n];
        int[][] d = new int[change+1][value.length];
        int[] dp = new int[change+1];


        System.out.println("请输入钞票面值：");
        for (int i = 0; i< n ;i++){
            int b = sc1.nextInt();
            value[i] = b ;
        }

   /*     Arrays.sort(value);
        reverseArray(value);*/

        System.out.println("零钱       张数       各面额张数");
        ch1.change(30,value,d,dp);

        for(int i = 1 ; i<=30;i++){
            System.out.print(i+"       "+dp[i]+"       ");
            for(int j = 0 ;j<value.length;j++) {
                System.out.print("面额为" + value[j] + "的纸币：" + d[i][j]+" ");
            }
            System.out.println();
        }


    }
}

