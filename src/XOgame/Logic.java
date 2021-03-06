package XOgame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static boolean gameOver;
    public static String winnerGame = "...";
    private static String file = "D:\\5. JAVA\\1. Курс обучения Java lvl 1\\img";
    private static ImageIcon img;

    BattleMap battleMap;

    public static void go() {
        gameOver = true;

        printMap();
        String title = "GAME OVER!!!";
        if (checkWin(DOT_X)) {
            winnerGame = "Победил человек";
            file+="HumanWin.jpg";
            JOptionPane.showMessageDialog(null, winnerGame, title, JOptionPane.PLAIN_MESSAGE, new ImageIcon(file));
            return;
        }
        if (isMapFull()) {
            winnerGame = "Ничья";
            file+="noOne.jpg";
            JOptionPane.showMessageDialog(null, winnerGame, title, JOptionPane.PLAIN_MESSAGE, new ImageIcon(file));
        return;
    }
        aiTurn();
        printMap();
        if (checkWin(DOT_O)) {
            winnerGame = "Победил Искуственный Интеллект";
            file+="AiWin.jpg";
            JOptionPane.showMessageDialog(null, winnerGame, title, JOptionPane.PLAIN_MESSAGE, new ImageIcon(file));
            return;
        }
        if (isMapFull()) {
            winnerGame = "Ничья";
            file+="noOne.jpg";
            JOptionPane.showMessageDialog(null, winnerGame, title, JOptionPane.PLAIN_MESSAGE, new ImageIcon(file));
            return;
        }
        gameOver = false;
    }

    public static boolean checkWin(char symb) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    if (checkWinHorizontal(i, j, symb)) return true;
                    if (checkWinVertical(i, j, symb)) return true;
                    if (checkWinDiagonal(i, j, symb)) return true;
                    if (checkWinDiagonalRev(i, j, symb)) return true;
                }
            }
        }
        return false;
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

    public static boolean checkWinDiagonalRev(int y, int x, char symb) {
        int point = 1;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((x + i) < SIZE && (y - i) >= 0 && map[x + i][y - i] == symb) point++;
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
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            y = rand.nextInt(SIZE);
            x = rand.nextInt(SIZE);
        } while (!isCellValid(y, x));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }


    public static void setHumanYX(int x, int y){
        if(isCellValid(y,x)){
            map[y][x] = DOT_X;
            go();
        }
    }

    public static boolean isCellValid(int y, int x) {
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
