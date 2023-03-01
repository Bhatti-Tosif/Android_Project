package com.example.android_practice.calculation;

import java.util.Scanner;

public class MagicNumber extends Calculate {

    public static void main() {
        Scanner scaner = new Scanner(System.in);
        int num1, num2;
        num1 = scaner.nextInt();
        num2 = scaner.nextInt();

}


    @Override
    public void calculate(int num1, int num2) {
        int total=add(num1,num2);
        int sum=0,digit;
        while(total!=0)
        {
            digit=modulo(total,10);
            sum=add(sum,digit);
            total=division(total,10);
        }
        System.out.print(sum);
    }
}
