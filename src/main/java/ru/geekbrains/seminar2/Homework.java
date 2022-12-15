package ru.geekbrains.seminar2;

import java.util.Random;

public class Homework {

    public static int getRandomNumber(int bound) {
        Random r = new Random();
        return r.nextInt(bound) + 1;
    }

    static Employee generateEmployee() {

        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};

        if ((getRandomNumber(10) > 5 ? 1 : 0) == 1) {
            return new Worker(names[getRandomNumber(9)], surnames[getRandomNumber(9)],getRandomNumber(10) *10000);
        }
        else
        {
            return new Freelancer(names[getRandomNumber(9)], surnames[getRandomNumber(9)],getRandomNumber(10) *10000);
        }

        //TODO: доработать метод

    }

    public static void main(String[] args) {

        Worker worker = new Worker("Анатолий", "Шестаков", 30000);
        System.out.println(worker);

        //TODO: Домашнее задание
        // 1. Доработать метод generateEmployee(), метод должен возвращать сотрудников
        // типа Worker или Freelancer
        // 2***. Метод generateEmployee() не должен иметь параметров на вход.

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

}

class Freelancer extends Employee {

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    protected double calculateSalary() {
        return 5 * 4 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.); Почасовая ставка: %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}


class Worker extends Employee {

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    protected double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surname, name, salary);
    }
}

abstract class Employee {

    protected String name;
    protected String surname;

    /**
     * Ставка ЗП
     */
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Расчет среднемесячной заработной платы
     *
     * @return
     */
    protected abstract double calculateSalary();
}