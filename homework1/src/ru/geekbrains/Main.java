package ru.geekbrains;

public class Main {
    // 1 задание
    public static void main(String[] args) {
	// write your code here
    }

    //2 задание
    byte a = 127;
    short b = 32767;
    int c = -214748364;
    long d = 900000000;

    float e= 1.2f;
    double f = 1.2d;

    char g = 'a';
    boolean i = true;

    //3 задание
    public static int result4(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // 4 задание
    public static boolean limit(int a, int b) {
        return (a + b) <= 10 && (a + b) >= 20;
    }

    // 5 задание
    public static void posNumber(int a) {
        if (a >= 0){
            System.out.println("Положительное");
        } else System.out.println("Отрицательное");
    }

    // 6 задание
    public static boolean notPosNumber(int a) {
        return a < 0;
    }

    //7 задание
    public static void sayName(String name) {
        System.out.println("Привет, " + name);
    }

    //8 задание
    public static void leapYear(int year) {
        if ((year % 4 != 0) || (year % 1000 == 100)){
            System.out.println(year + " год не високосный");
        } else
            //if (year % 1000 == 400){
            //    System.out.println(year + " год високосный");
            //} else
            System.out.println(year + " год високосный");

    }


}


