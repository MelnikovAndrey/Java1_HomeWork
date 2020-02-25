package HomeWork5;

public class Main {

    public static void main(String[] args) {
// второй пункт ДЗ

////        Employee employee1 = new Employee();
////        employee1.name = "Иван";
////        employee1.position  = "Менеджер1";
////        employee1.email  = "ivanov@ivanov.ru";
////        employee1.phoneNumber = "+7.777.777-77-77";
////        employee1.salary = "500";
////        employee1.age = 45;

// третий пункт ДЗ
//        employee1.info();


            // четвертый пункт ДЗ
    Employee[] personArr = new Employee[5];
        personArr[0] = new Employee("Степан", "Водитель", 5000, 47, "+7.888.888-88-88", "step@step.ru");
        personArr[1] = new Employee("Артём", "Повар", 1000, 41, "+7.555.555-55-55","art@art.ru");
        personArr[2] = new Employee("Макс", "Директор", 50000,43,"+7.999.666-69-69","director@director.ru");
        personArr[3] = new Employee("Анна", "Секретарь Макса", 3000, 22,"+7.111.111-11-11","anna@uffff.ru");
        personArr[4] = new Employee("Ксения", "Жена Макса", 3500, 35, "+7.333.333-33-33", "ksenia@ksenia.ru");
    }

}
