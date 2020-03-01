package HomeWork6;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Какое-то животное было создано");
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Кузя");

        dog.jump(0.4);
        dog.run(200);
        dog.swim(7);
        dog.maxDogs();
        System.out.println();

        cat.jump(2);
        cat.run(150);
        cat1.swim(2);
        cat.maxCats();
        System.out.println();

        animal.countAnimals();
    }

}
