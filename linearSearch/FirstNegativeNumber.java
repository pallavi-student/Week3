package com.week3.day4.linearSearch;

public class FirstNegativeNumber {
    public static int FirstNegativeFinder(int[]arr){
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                index=i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[]arr={1,23,54,-4,5,6};
        int firstNegativeElementIndex=FirstNegativeFinder(arr);
        System.out.println("index of first negative number in array is "+firstNegativeElementIndex);
    }
}
