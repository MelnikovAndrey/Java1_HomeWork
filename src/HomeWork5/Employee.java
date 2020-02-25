package HomeWork5;

// первый пункт ДЗ
public class Employee {
    String name;
    String position;
    int salary;
    String email;
    String phoneNumber;
    int age;

// третий пункт ДЗ
    public void info() {
        System.out.printf("ФИО сотрудника: %s\nЗанимаемая должность: %s с окладом в %s\nВозраст сотрудника: %s лет" +
                        "\nКонтактные данные:\nНомер телефона: %s\nЭлектронная почта: %s",
                name, position, salary, age, phoneNumber, email);
        System.out.println();
    }
    // конструктор для массива
    public Employee(String name, String position, int salary, int age, String phoneNumber, String email){
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
