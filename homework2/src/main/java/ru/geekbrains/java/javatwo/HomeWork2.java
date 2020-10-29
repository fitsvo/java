package ru.geekbrains.java.javatwo;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        isNegativArr();
        multipleThree();
        isNotOverSix();
        diagOne();
        minMaxArr();
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 7, 2, 11,1}));
        System.out.println(Arrays.toString(circleArray(new int[]{1, 2, 3, 4, 5, 6}, -3)));

    }

    //1 задание
    public static void isNegativArr() {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    //2 задание
    public static void multipleThree() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 3 * i;
        }
        System.out.println(Arrays.toString(arr));
    }

    //
    //3 задание
    public static void isNotOverSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {arr[i] *= 2;}
        }
        System.out.println(Arrays.toString(arr));
    }

    //4 задание
    public static void diagOne() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i == j) || (9 - i == j)) {
                    arr[i][j] = 1;
                } else arr[i][j] = 0;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    //5 задание
    public static void minMaxArr() {
        int[] arr = {10, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] < min) {min = arr[i];}
            if (arr[i] > max) {max = arr[i];}
        }
        System.out.println("Минимальный элемент массива " + min);
        System.out.println("Максимальный элемент массива " + max);
    }

    //6 задание
    public static boolean checkBalance(int[] arr) {
        boolean result = false;
        for (int i = 1; i < arr.length; i++){
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += arr[j];
            }
            for (int k = i; k < arr.length; k++) {
                sumRight += arr[k];
            }
            if (sumLeft == sumRight) {
                result = true;
            }
        }
        return result;
    }

    //7 задание
    public static int[] circleArray(int[] arr, int n) {
        if (n >= 0){
            n = n % (arr.length - 1);
        } else n = arr.length + n;
            for (int i = 0; i < n; i++) {
                int buf = arr[arr.length - 1];
                for (int j = 1; j < arr.length ; j++) {
                    arr[arr.length - j] = arr[arr.length - j - 1];
                }
                arr[0] = buf;
            }
        return arr;
    }

}
