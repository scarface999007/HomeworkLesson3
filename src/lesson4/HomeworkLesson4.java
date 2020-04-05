package lesson4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class HomeworkLesson4 {
    public static int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {

        fillMap();
        printMap();

        do{
            humanTurn();
            printMap();
            if(checkWin(SIZE, DOT_X)){
                System.out.println("Победил человек!");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if(checkWin(SIZE, DOT_O)){
                System.out.println("Победил компьютер!");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }
        } while (!isMapFull());

    }

    private static boolean checkWin(int size, char symbol) {
        int countRow = 0;
        int countColumn = 0;
        int countFirstDiagonal = 0;
        int countSecondDiagonal = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == symbol){
                    countRow++;
                }
                if(map[j][i] == symbol){
                    countColumn++;
                }
            }

            if(countRow == size){
                return true;
            } else {
                countRow = 0;
            }

            if(countColumn == size){
                return true;
            } else {
                countColumn = 0;
            }

            if(map[i][i] == symbol){
                countFirstDiagonal++;
            }

            if(map[size - 1 - i][i] == symbol){
                countSecondDiagonal++;
            }
        }
        if(countFirstDiagonal == size){
            return true;
        }
        if(countSecondDiagonal == size){
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private static void humanTurn() {
        int x = -1;
        int y = -1;
        do{
            try {
                System.out.print("Ход игрока. Введите координаты в формате X Y: ");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } catch (InputMismatchException exception){
                System.out.println("Вы ввели не цифры! Введите цифры");
                sc.next();
                continue;
            }
        } while (!isValidCoordinates(x, y));
        map[x][y] = DOT_X;
    }

    private static void aiTurn() {
        int x;
        int y;
        do{
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isValidCoordinates(x, y));
        map[x][y] = DOT_O;
    }

    private static boolean isValidCoordinates(int x, int y) {
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            return false;
        }
        return map[x][y] == DOT_EMPTY;
    }

    private static void fillMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}


