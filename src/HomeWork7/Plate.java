package HomeWork7;

import java.util.Scanner;

public class Plate {
    private int food;
    public static Scanner sc = new Scanner(System.in);

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Осталось еды в тарелке " + food);
    }

    public boolean decreaseFood(int n) {
        if (maxFood(n)) {
            food -= n;
            return true;
        } else {
            System.out.println("Не хватит еды чтобы накормить кота");
            return false;
        }
    }

    public boolean maxFood(int a) {
        return food >= a;
    }

    public void putMoreFood() {
        int n = sc.nextInt();
        food += n;
        System.out.println();
    }
}
