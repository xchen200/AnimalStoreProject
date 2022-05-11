package com.example.task;

public class CheckSquare {

    public static void main(String[] args) {
        System.out.println(isSqu(10, 10));
    }

    public static boolean isSqu(int width, int height)
    {
        return width == height;
    }
}

