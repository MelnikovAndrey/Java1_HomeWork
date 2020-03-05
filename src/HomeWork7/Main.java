package HomeWork7;

public class Main {
    public static void main(String[] args) {
        Cat[] cat = {
                new Cat("Barsik", 25, false),
                new Cat("Murzik", 35, false),
                new Cat("Begemot", 50, false)
        };
        Plate plate = new Plate(100);

        for (Cat koteika : cat) {
            koteika.eat(plate);
            System.out.println("Сытость " + koteika.getName() + " " + koteika.getSatiety());
            plate.info();
            System.out.println();

        }
        System.out.println("Докинь еды бро, котейке пожрать не хватает))");
        plate.putMoreFood();
    }
}
