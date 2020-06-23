package com.cz;

import java.util.Arrays;
import java.util.Scanner;

/*贪心算法版*/
public class Change {



    public  void change(int change,int[] value){

        int[] count = new int[value.length];
        int b = change;

        for(int i = 0; i<value.length; i++){

            while(change>=value[i]){

                change = change -value[i];

                count[i]++;
            }

        }

        for(int j = 0;j<value.length;j++){
            System.out.println("当change为" + b + "时需要" + count[j] + "个面额为" + value[j] + "的钞票");
        }

    }
    
    public static void reverseArray(int[] arr) {
 
        for (int i = 0;i < arr.length / 2 ; i++) {

        int temp = arr[i];
 
        arr[i] = arr[arr.length-1-i];
 
        arr[arr.length-1-i] = temp;
 
        }
 
    }


    public static void main(String[] args) {
        Change ch1 = new Change();
        Scanner sc1 = new Scanner(System.in);

        System.out.println("请输入n值：");
        int n = sc1.nextInt();

        int[] value = new int[n];


        System.out.println("请输入钞票面值：");
        for (int i = 0; i< n ;i++){
            int b = sc1.nextInt();
           value[i] = b ;
        }

        Arrays.sort(value);
        reverseArray(value);

        int change = 1;
        while(change <= 30 ) {
            ch1.change(change, value);
            change++;
        }


    }
}
