package com.example.demo3;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {


        try (Scanner scanner = new Scanner(System.in)) {

            ListOfPeople listOfPeople = new ListOfPeople();


            listOfPeople.load();//тут будет заполнение списка из загрузчика

            System.out.println("Программа автоматически сортирует именинников и показывает ближайшие ДР");
            System.out.println("список команд: ");
            System.out.println("add - добавить");
            System.out.println("del - удалить");
            System.out.println("edit - редактировать");
            System.out.println("print - показать список именинников");
            System.out.println("printAll - показать список именинников вместе с индексами");
            System.out.println("end - закрыть программу");

            String command = "";

            while (!command.equals("end")) {
                command = scanner.nextLine();
                switch (command) {
                    case "add" -> {
                        System.out.println("введите через enter ИМЯ и день рождения в формате ГОД-МЕСЯЦ-ДЕНЬ");
                        String name = scanner.nextLine();
                        String birthday = scanner.nextLine();
                        UUID id = UUID.randomUUID();
                        listOfPeople.addPerson(new Person(id, name, birthday));
                        System.out.println(name + " " + birthday + " года рождения добавлен(а) в список");
                        listOfPeople.sortPeople();
                    }
                    case "del" -> {
                        System.out.println("Выберите из списка человека которого хотите удалить и впишите его индекс в списке (Person@...)");
                        listOfPeople.printAll();
                        String id = scanner.nextLine();
                        listOfPeople.delPerson(UUID.fromString(id));
                    }
                    case "edit" -> {
                        System.out.println("Выберите из списка человека, которого нужно отредактировать");
                        listOfPeople.printAll();
                        String id = scanner.nextLine();
                        System.out.println("Теперь впишите через enter новое имя и новый день рождения в формате ГОД-МЕСЯЦ-ДЕНЬ");
                        String newName = scanner.nextLine();
                        String newBirthday = scanner.nextLine();
                        Person editedPerson = listOfPeople.editPerson(UUID.fromString(id), newName, newBirthday);
                        System.out.println("персонаж с именем " + editedPerson.getName() + " " + editedPerson.getBirthdayDate() + " года рождения изменён");
                    }
                    case "print" -> {
                        listOfPeople.printPeople();
                    }
                    case "printAll" -> {
                        listOfPeople.printAll();
                    }

                }
            }
        }
    }
}
//TODO: добавить плагины StyleChecker и PMD
//TODO: добавить метод, который показывает список вместе с индексами

