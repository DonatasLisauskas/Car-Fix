package Visitor_Pattern;

import carfix.entities.Car;

import java.util.Scanner;

public class CarDaoPartDisplayVisitor extends DaoPartVisitor {

    @Override
    public DaoPartVisitor visit() {

        welcome();

        switch (inputString()) {

            case "Create":
                System.out.println("Enter Series Name: ");
                String name = inputString();
                System.out.println("Enter Year of Manufacture : ");
                Long year = inputNumber();
                System.out.println("Enter Engine displacement by (0.0) L");
                String engineDisplacement_L = inputString();
                System.out.println("Enter Engine Power by KW ");
                Long enginePower_KW = inputNumber();

                Car car = new Car(name, year, engineDisplacement_L, enginePower_KW);

                carDao.createCar(car);
        }
        return this;
    }

    @Override
    protected Long inputNumber() {
        Scanner sc = new Scanner(System.in);
        Long number = sc.nextLong();
        return number;
    }

    @Override
    protected String inputString() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        return command;
    }

    @Override
    protected void welcome() {
        System.out.println("Welcome to CarFix");
        System.out.println("Please select a command: (Create, Update, Delete, ID (get by ID), List (get Car DB List");
    }
}
