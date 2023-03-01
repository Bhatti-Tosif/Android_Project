package com.example.android_practice.calculation;

public class InterfaceCalculate implements add,div,mod{

    int num1,num2;
    public int addi(int num1,int num2)
    {
        return num1+num2;
    }
    public int div(int num1,int num2)
    {
        return num1/num2;
    }
    public int mod(int num1,int num2)
    {
        return num1%num2;
    }
    int x;

    void calculate()
    {
        int total, sum = 0, digit;
        total = addi(num1, num2);
        while (total!=0)
        {
            digit=mod(total,10);
            sum=addi(sum,digit);
            total=div(total,10);
        }
    }
}
