public class Main1 {
    //HomeWork part.1
    public static void main(String[] args) {
        //HomeWork part.2
        byte a = 2;
        short b = 5;
        int c = 12;
        long l = 65452132;
        float fl = 125.4f;
        double d = 4;
        char ch = 'a';
        boolean boo = true;
        final int x = 200;
        //  . . . . . . . . . . .
        System.out.println("Сумма чисел:");
        System.out.println(calculate(2, 2, 2, 2));

        System.out.println("Проверка диапазона суммы 5 и 6:");
        System.out.println(task10and20(5, 6));

        System.out.println("Проверка на четность:");
        isPositiveOrNegative(11);

        System.out.println("Проверка на отрицание:");
        System.out.println(isNegative(10));

        System.out.println("Приветствие:");
        greetings("Mike");

        System.out.println("Високосный или нет:");
        WhatYearNow(2020);

    }

    // HomeWork part.3
    public static int calculate(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // HomeWork part.4
    public static boolean task10and20(int x, int y) {
        int summ = x + y;
        return summ >= 10 && summ <= 20;
    }

    // HomeWork part.5
    public static void isPositiveOrNegative(int x) {
        if (x % 2 == 0) System.out.println(true);
        else System.out.println(false);
    }

    // HomeWork part.6
    public static boolean isNegative(int x) {
        return x < 0;
    }

    //HomeWork part.7
    public static void greetings(String name) {
        System.out.println("Привет " + name + "!");
    }

    //HomeWork part.8

    public static void WhatYearNow(int year){
        if ( year % 100 == 0 && year % 400 == 0 )
            System.out.println("Год считается високосным!");
        else if (year % 4 == 0 && year % 100 > 0 )
            System.out.println("Год считается високосным!");
        else if ( year % 100 == 0 )
            System.out.println("Год не является високосным!");
        else
            System.out.println("Год не является високосным!");
    }
}
