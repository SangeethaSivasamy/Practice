package com.subrat.array;

import java.util.Arrays;

/**
 *
 */
public class DutchNationalFlag {


    public static void sort(int a[])
    {
        int i = 0;
        int j = 0;
        int k=a.length-1;
        int temp = 0;
        

        while(j <= k) {
            switch(a[j]) {
                case 0:
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    temp = a[j];
                    a[j] = a[k];
                    a[k] = temp;
                    k--;
                    break;
            }
        }
    }


    public static void main(String[] args) {
        //int arr[] = {0, 1, 0, 1, 2};
    	int arr[] = {1,1,2,2,0,0};
        sort(arr);
        System.out.println("Array after seggregation ");
        System.out.println(Arrays.toString(arr));

    }
}