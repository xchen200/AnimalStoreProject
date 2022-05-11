package com.example.task;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("pls enter a positive integer:");
        int num = input.nextInt();
        while (num != 0) {
            int b = num % 10;
            num = num / 10;
            System.out.print(b);
        }

    }
}