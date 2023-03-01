package com.example.android_practice.calculation;

abstract public class Calculate {
        public int add(int num1,int num2)
        {
            return num1+num2;
        }

        public int sub(int num1,int num2)
        {
            return num1-num2;
        }
        public int division(int num1,int num2)
        {
            return num1/num2;
        }
        public int modulo(int num1,int num2)
        {
            return num1%num2;
        }

        abstract public void calculate(int num1,int num2);

}
