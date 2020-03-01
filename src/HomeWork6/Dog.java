package HomeWork6;

public class Dog extends Animal {
    static int countDog = 0;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int a) {
        if (0 < a && a <= 500) {
            System.out.println(name + " пробежал " + a + " метров");
        } else if (a > 500) {
            System.out.println(name + " столько не пробежит, не то животное!");
        }
    }

    @Override
    public void jump(double b) {
        if (0 < b && b <= 0.5) {
            System.out.println(name + " подпрыгнул на " + b + " метров");
        } else if (b > 0.5) {
            System.out.println(name + " не умеет летать, так что ..... ");
        } else if (b < 0) {
            System.out.println(name + " похоже опять забыл где кость закопал!");
        }
    }

    @Override
    public void swim(int c) {
        if (c == 0) {
            System.out.println(name + " утонул?");
        }
        if (c > 0 && c < 10) {
            System.out.println(name + " проплыл " + c + " метров");
        }
    }
    public void maxDogs(){
        System.out.println("Всего было создано " + countDog + " собак");
    }
}
