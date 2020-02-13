package HomeWork2;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0};
        int[] arr2 = new int[8];


        task1(arr);
        task2(arr2);

    }
    public static void task1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                arr[i] = 1;
            } else arr[i] = 0;
        } System.out.println("Получаем новый массив: " + Arrays.toString(arr));
    }


    public static void task2(int[] arr2){
        for (int i = 0; i < arr2.length; i++) {
          arr2[i] = i * 3;
           } System.out.println("Сгенерированный массив: " + Arrays.toString(arr2));
    }
}

