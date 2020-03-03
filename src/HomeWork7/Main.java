package HomeWork7;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5);
        Plate plate = new Plate(100);

        plate.info();
        cat1.eat(plate);
        plate.info();
    }
}
