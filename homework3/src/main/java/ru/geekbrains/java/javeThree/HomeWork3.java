package ru.geekbrains.java.javeThree;
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Задание 1
        int x;
        do{
            guessNumber();
            x = sc.nextInt();
        } while (x == 1);

        //Задание 2
        guessArray();

    }

    public static void guessNumber() {
        Random random = new Random();
        int number = random.nextInt(10);
        int x, n=0;
        System.out.println("Отгадайте число от 0 до 9, которое загадал компьютер!");

        do {
            x = sc.nextInt();
            if (number > x) {System.out.println("Ваше число меньше загаданного");}
            else if (number < x){System.out.println("Ваше число больше загаданного");}
            n++;
        } while (x != number && n < 3);
        if ((n <= 3) && (x == number)) {
            System.out.printf("Вы победили! Компьютер загадал число: %s. Повторить игру еще раз? 1 – да / 0 – нет(1 – п" +
                    "овторить, 0 – нет).", number);
            System.out.println();
        }
        else System.out.println("Вы проиграли! Число попыток исчерпано. Повторить игру еще раз? 1 – да / 0 – нет(1 – по" +
                "вторить, 0 – нет).");
    }




    public static void guessArray() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",  "p" +
                "eanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        String x, res;
        char[] result = new char[] {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};

        do {
            System.out.println("Отгадайте слово, которое загадал компьютер!");
            System.out.println(new String(result));
            x = sc.nextLine();
            int minLength = Math.min(word.length(), x.length());
            for (int i =0; i < minLength; i++) {
                if (word.charAt(i) == x.charAt(i)) {
                    result[i] = x.charAt(i);
                }
            }
            res = new String(result).replaceAll("#","");
        } while (!res.equals(word));
        System.out.printf("Вы победили! Компьютер загадал слово: %s", word);
        System.out.println();
        sc.close();
    }
}
