package HomeWork4;

import java.util.Random;
import java.util.Scanner;

public class HoneWork4 {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    checkWinHorizontal(i, j, symb);
                    if(checkWinHorizontal(i, j, symb)) return true;
                    checkWinVertical(i, j, symb);
                    if(checkWinVertical(i, j, symb)) return true;
                    checkWinDiagonal(i, j, symb);
                    if(checkWinDiagonal(i, j, symb)) return true;
                    checkWinDiagonalRev(i, j, symb);
                    if(checkWinDiagonalRev(i, j, symb)) return true;
                }
            }
        } return false;
    }

        public static boolean checkWinHorizontal(int x, int y, char symb) {
            int point = 1;
            for (int i = 1; i < DOTS_TO_WIN; i++) {
                if ((y + i) < SIZE && map[x][y + i] == symb) point++;
            }
            return point == DOTS_TO_WIN;
        }
        public static boolean checkWinVertical(int x, int y, char symb) {
            int point = 1;
            for (int i = 1; i < DOTS_TO_WIN; i++) {
                if ((x + i) < SIZE && map[x + i][y] == symb) point++;
            }
            return point == DOTS_TO_WIN;
        }
        public static boolean checkWinDiagonal(int x, int y, char symb) {
            int point = 1;
            for (int i = 1; i < DOTS_TO_WIN; i++) {
                if ((y + i) < SIZE && (x + i) < SIZE && map[x + i][y + i] == symb) point++;
            }
            return point == DOTS_TO_WIN;
        }
        public static boolean checkWinDiagonalRev(int x, int y, char symb) {
        int point = 1;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((x + i) < SIZE && (y - i) > 0 && map[x + i][y - i] == symb) point++;
        }
            return point == DOTS_TO_WIN;
        }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(isCellValid(i, j)){
                    map[i][j] = DOT_X;
                    if(checkWin(DOT_X)){
                        map[i][j] = DOT_O;
                        return;
                    } map[i][j] = DOT_EMPTY;
                }
            }
        }
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
