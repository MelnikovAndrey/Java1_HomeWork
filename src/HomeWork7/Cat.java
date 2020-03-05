package HomeWork7;

public class Cat {
    private String name;
    private int appetite;
    boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Plate p) {
        System.out.println("Кот " + name + " кушает ...");
        satiety = p.decreaseFood(appetite);
    }

    public boolean getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
