package HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Привет. Это игра угадай число!");
        System.out.println("Введите диапазон чисел!");
        int a = scanner.nextInt();
        System.out.println("Введите кол-во попыток в игре!");
        int b = scanner.nextInt();

        System.out.println();

        guessTheNumber(a, b);
        guessTheWord();
    }

    public static void guessTheNumber(int n, int x) {
        int num = rand.nextInt(n);
        int maxTryCount = x;
        System.out.println("Угадайте загаданное число.\nУ Вас осталось " + x + " попытки");

        for (int i = 1; i <= x; i++) {
            int userAnswer = scanner.nextInt();
            maxTryCount--;
            if (maxTryCount == 0) {
                System.out.println("Вы проиграли! Все попытки закончились. Было загадано число: " + num);
                break;
            } else if (userAnswer == num) {
                System.out.println("Поздравляем, Вы угадали!");
                break;
            } else if (userAnswer >= num) {
                System.out.println("Ваше число больше загаданного!\nПопробуйте еще раз.");
            } else {
                System.out.println("Ваше число меньше загаданного!\nПопробуйте еще раз.");
            }
            System.out.println("У Вас осталось " + maxTryCount + " попытки");
        }
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        String answer = words[rand.nextInt(words.length)];
        StringBuilder strBuffer = new StringBuilder("###############");
        System.out.println("Попробуйте угадать загаданное название фрукта");

        for ( ; ; ) {
            String userAnswer = scanner.next();
            int x = (Math.min(userAnswer.length(), answer.length()));
            if (answer.equals(userAnswer)) {
                System.out.println("Поздравляем, Вы угадали. Игра окончена");
                System.exit(0);
            } else {
                for (int j = 0; j < x; j++) {
                    if (userAnswer.charAt(j) == answer.charAt(j)) {
                        strBuffer.setCharAt(j, answer.charAt(j));
                    }
                } System.out.println(strBuffer.toString());
            }
        }
    }
}

