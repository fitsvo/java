package ru.geeekbrains.java.homework5;

public class HomeWork5 {
    public static void main(String[] args) {
        // 4. Создать массив из 5 сотрудников.
        Employee[] empArray = new Employee[5]; // Вначале объявляем массив объектов
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        empArray[1] = new Employee("Fits Vladimir", "Soft Engineer", "fits.v@mail.ru", "+79990101010", 100000, 41);
        empArray[2] = new Employee("Akjanov Erlan", "Java Developer", "e.akjanov@mail.ru", "+77272641053", 150000, 36);
        empArray[3] = new Employee("Hendrix Richard", "SEO", "r.hendrix@piper.com", "+131010002552", 500000, 45);
        empArray[4] = new Employee("Brean Sergey", "Googler", "ilovyahoo@google.com", "+131010000000", 500001, 47);
        
        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Employee i: empArray) {
            if (i.getAge() > 40) i.info();
        }
    }
}
