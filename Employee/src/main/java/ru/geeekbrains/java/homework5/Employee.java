package ru.geeekbrains.java.homework5;

public class Employee {

    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    public String fio;
    public String position;
    public String email;
    public String phone;
    public long salary;
    public int age;

    //2.Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String fio, String pos, String email, String phone, long sal, int age) {
        this.fio = fio;
        this.position = pos;
        this.email = email;
        this.phone = phone;
        this.salary = sal;
        this.age = age;
    }
    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void print() {
        System.out.println("Employee:");
        System.out.println("    Full name: " + this.fio);
        System.out.println("    Position: " + this.position);
        System.out.println("    Email: " + this.email);
        System.out.println("    Phone Number: " + this.phone);
        System.out.println("    Salary: " + this.salary);
        System.out.println("    Age: " + this.age);
    }

    // Задачи №4 и №5 сделаны в классе HomeWork5
}
