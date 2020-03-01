package HomeWork6;

public class Animal {
    String name;
    static int countAnimals = 0;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public static void main(String[] args) {


    }

    public void run(int a) {
        System.out.println("Животное пробежало " + a + " метров");
    }

    public void jump(double b){
        System.out.println("Животное может подпрыгнуть на высоту до " + b + " метров");
    }
    public void swim(int c){
        System.out.println("Животное может проплыть - " + c + " метров");
    }
    public void countAnimals(){
        System.out.println("Всего было создано " + countAnimals + " животных");
    }

}
