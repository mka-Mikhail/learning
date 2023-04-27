package lesson2.homework.HW3;

import java.util.Arrays;

class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Сотрудник:\n" +
                "ФИО: " + fullName + "\n" +
                "Должность: " + position + "\n" +
                "email: " + email + "\n" +
                "Телефон: " + phone + "\n" +
                "Зарплата: " + salary + "\n" +
                "Возраст: " + age + "\n";
    }
}

public class HW3 {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Сергей Иванович", "Инженер", "ivivan@mailbox.com", "892312312", 70000, 42);
        employees[1] = new Employee("Михайлов Даниил Кириллович", "Прогаммист", "kird@mail.com", "89874336158", 80000, 35);
        employees[2] = new Employee("Куликов Михаил Дмитриевич", "QA-тестрировщик", "mikhkul@sit.com", "89012563789", 50000, 41);
        employees[3] = new Employee("Воронцова Мария Владимировна", "HR", "mari_vv@qaz.com", "89367854232", 40000, 30);
        employees[4] = new Employee("Кузнецов Владимир Алексеевич", "Менеджер", "kuzva@ver.com", "896543596482", 40000, 40);

        for (Employee e : employees) {
            if (e.getAge() > 40) {
                System.out.println(e);
            }
        }

//        Arrays.stream(employees).filter(employee -> employee.getAge() > 40).forEach(System.out::println);
    }
}