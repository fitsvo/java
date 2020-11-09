package ru.geeekbrains.java.homework5;

public class Employee {

    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    private String fio;
    private String position;
    private String email;
    private String phone;
    private long salary;
    private int age;



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
    public void info() {
        System.out.println("Employee:");
        System.out.println("    Full name: " + this.fio);
        System.out.println("    Position: " + this.position);
        System.out.println("    Email: " + this.email);
        System.out.println("    Phone Number: " + this.phone);
        System.out.println("    Salary: " + this.salary);
        System.out.println("    Age: " + this.age);
    }

    // Задачи №4 и №5 сделаны в классе HomeWork5

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
