package com.example.task;

public class FindGivenElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(seek(arr, 3));
    }

    public static int seek(int[] arr, int toFind){
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
}
