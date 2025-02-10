package com.week3.day5;

import java.util.Arrays;
import java.util.Random;



public class SearchTargetInLargeData {
   public static int[] randomArray(int n) {
       Random random = new Random();
       int[] randomArray = new int[n];
       for (int i = 0; i < n; i++) {
           randomArray[i] = random.nextInt(n);
       }
       return randomArray;
   }
    public static boolean linearSearch(int[]arr,int target){

         for(int i=0;i<arr.length;i++){
              if(arr[i]==target){
              return true;
              }
    }return false;

    }
    public static boolean binarySearch(int[]arr,int target){
       int start=0;
       int end=arr.length-1;
       while(start<=end){
           int mid=start+((end-start)/2);
           if(arr[mid]==target)
               return true;
           else if(target<arr[mid]){
               end=mid-1;
           }
           else
               start=mid+1;

       }
       return false;
    }
    public static void linearCalculateTiminmilli(int[]arr,int target){
       long start=System.nanoTime();
       linearSearch(arr,target);
       long end=System.nanoTime();
       System.out.println("Linear Search Takes "+(end-start)/1000000.0+"ms");

    }
    public static void binarytcalculateTiminmilli(int[]arr,int target){
        long start1=System.nanoTime();
        binarySearch(arr,target);
        long  end1=System.nanoTime();
        System.out.println("Binary Search Takes "+(end1-start1)/1000000.0+"ms");


    }


    public static void main(String[] args) {
        int[] dataSize = {1000, 10000, 1000000};
        Random random = new Random();
        for (int data : dataSize) {
            System.out.println("DataSet Size" + data);
            int[] array = SearchTargetInLargeData.randomArray(data);
            int target = array[random.nextInt(data)];

            SearchTargetInLargeData.linearCalculateTiminmilli(array,target);
            Arrays.sort(array);
            SearchTargetInLargeData.binarytcalculateTiminmilli(array,target);
        }
    }



    }

