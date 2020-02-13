package HomeWork2;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0};
        int[] arr2 = new int[8];
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr4 = new int[3][3];

        task1(arr);
        task2(arr2);
        task3(arr3);
        task4(arr4);

    }

        public static void task1(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else arr[i] = 0;
            }
            System.out.println("Меняем нули и еденицы друг на друга: " + Arrays.toString(arr));
        }


        public static void task2(int[] arr2) {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = i * 3;
            }
            System.out.println("Сгенерированный массив, элементы кратны трём: " + Arrays.toString(arr2));
        }

        public static void task3(int[] arr3) {

            for (int i = 0; i < arr3.length; i++) {
                if (arr3[i] < 6) {
                    arr3[i] *= 2;
                }
            }
            System.out.println("Все что меньше 6 умножил на 2: " + Arrays.toString(arr3));
        }

        public static void task4(int[][] arr4) {

            int n = arr4.length;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            arr4[i][j] = 1;
                        } else if ((i + j) == (n - 1)) {
                            arr4[i][j] = 1;
                        } else;
                        System.out.print(" " + arr4[i][j] + " ");
                    } System.out.println();
                }
        }

        public static void task5(int[][] arr3){


        }
    }



