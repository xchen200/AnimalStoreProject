package com.example.task;

import java.util.Scanner;

public class CompanyBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many years have you been in the company?");
        int year = 0;
        double salary = 0;
        if (scanner.hasNextInt()) {
            year = scanner.nextInt();
        }
        System.out.println("How many salary do you have?");
        if (scanner.hasNextDouble()) {
            salary = scanner.nextDouble();
        }
        if (year >= 5) {
            System.out.println("Your new salary: " + salary*1.05);
        } else {
            System.out.println("Your new salary: " + salary);
        }
    }
}
