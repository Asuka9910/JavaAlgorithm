package com.cz;
import java.util.Arrays;

public class SelectSort {

        public static void main(String[] args) {
            int [] arr = {49,38,65,97,76,13,27,49};
            selectSort(arr,arr.length);
        }

        public static void selectSort(int [] arr,int n){
            for (int i = 0; i < n - 1; i++) {
                int index = i;
                int j;
                // �ҳ���Сֵ��Ԫ���±�
                for (j = i + 1; j < n; j++) {
                    if (arr[j] < arr[index]) {
                        index = j;
                    }
                }
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
                System.out.println(Arrays.toString(arr));
            }

        }
    }


