package ru.geekbrains.java.javaFour;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    //Переменные - параметры игры
    public static final int SIZE = 5;
    public static final char DOTS_TO_WIN = 4;

    //Константы
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final int LINE_LIMIT = 15;


    //Переменные - игровое поле, работа с клавой, случайные числа
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int counter = 0;

    //Основной метод
    public static void main(String[] args) {

        //Игровое поле
        initMap();

        //Вывод игрового поля
        printMap();


        //Главный игровой цикл
        while (true) {

            counter++;
            //Ход игрока
            humanTurn();

            //Печать игр.поля
            printMap();

            //Проверка победителя
            if (checkWin(DOT_X)){
                System.out.println("Игрок одержал победу");
                break;
            }

            //Проверка заполненного поля
            if (isMapFull()){
                System.out.println("Ничья!");
                break;
            }

            //Ход ИИ
            aiTurn();

            //Печать игр.поля
            printMap();

            //Проверка победителя
            if (checkWin(DOT_O)){
                System.out.println("Компьютер одержал победу");
                break;
            }
            //Проверка заполненного поля
            if (isMapFull()){
                System.out.println("Ничья!");
                break;
            }

        }
        System.out.println("Игра окончена!");
        scanner.close();
    }

    private static boolean isMapFull() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;

    }

    private static boolean checkWin(char symbol) {
        //Проверка диагоналей
        int diag = 0, diagRev = 0;
        for (int y = 0; y < SIZE; y++) {
            if (map[y][y] == symbol) diag++;
            if (map[y][SIZE - y - 1] == symbol) diagRev++;
            if (diag == DOTS_TO_WIN || diagRev == DOTS_TO_WIN) return true;
        }
        //Проверка линий
        for (int y = 0; y < SIZE; y++) {
            int line = 0, lineRev = 0;
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == symbol) line++;            // Проверка горизонтальной линии
                if (map[x][y] == symbol) lineRev++;         // Проверка вертикальной линии
                if (line == DOTS_TO_WIN || lineRev == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }

    private static void aiTurn() {

       for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (isCellValid(i, j)){
                    map[j][i] = DOT_O;
                    if (checkWin(DOT_O)) return;
                    map[j][i] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++){
                if (isCellValid(i, j)){
                    map[j][i] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[j][i] = DOT_O;
                        return;
                    }
                    map[j][i] = DOT_EMPTY;
                }
            }

        int x, y;
        do{
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    private static void humanTurn() {
        int x, y;
        do{
            System.out.println("Введите координаты в формате X Y [1.." + SIZE + "]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE) return false;
        if (y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    private static void printMap() {
        //Отступ
        for (int i = 0; i < LINE_LIMIT; i++) {
            System.out.println();
        }
        //Легенда сверху
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Выводим поле
        for (int y = 0; y < SIZE; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < SIZE; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }

        //Доп. отступ
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i=0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

}
