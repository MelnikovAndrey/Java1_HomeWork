package HomeWork6;

public class Cat extends Animal {
    static int countCat = 0;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    @Override
    public void run(int a) {
        if (0 < a && a < 200) {
            System.out.println(name + " пробежал " + a + " метров");
        } else if (a > 200) {
            System.out.println(name + " точно столько не пробежит");
        } else if (a == 200) {
            System.out.println(name + " пробежал " + a + " метров и охренел от такой дистанции))");
        }
    }

    @Override
    public void jump(double b) {
        if (0 < b && b < 2) {
            System.out.println(name + " подпрыгнул на " + b + " метров");
        } else if (b > 2){
            System.out.println(name + " не умеет летать, так что ..... ");
        } else if(b<0){
            System.out.println(name + " вроде был котом, а не землеройкой!");
        } else if(b==2){
            System.out.println(name + " подпрыгнул на  " + b + " метра и это ему было проще чем пробежать 200!!! ))");
        }
    }

    @Override
    public void swim(int c) {
        System.out.println(name + " не умеет плавать!");
    }
    public void maxCats(){
        System.out.println("Всего было создано " + countCat + " котов");
    }
}
