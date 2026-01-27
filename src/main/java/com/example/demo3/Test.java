package com.example.demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var communicator = reader.readLine();

        ListOfPeople testSet = new ListOfPeople();

        /*Person vasa = new Person("Вася", LocalDate.of(2004, 1, 26));
        Person petja = new Person("Петя", LocalDate.of(1991, 12, 7));
        Person lesha = new Person("Лёша", LocalDate.of(1987, 7, 17));
        Person sasha = new Person("Саша", LocalDate.of(1993, 12, 4));
        Person masha = new Person("Маша", LocalDate.of(2000, 3, 18));

        testSet.addPerson(vasa);
        testSet.addPerson(petja);
        testSet.addPerson(lesha);
        testSet.addPerson(sasha);
        testSet.addPerson(masha);

        testSet.printPeople();

        testSet.getPerson(4);
        testSet.delPerson(masha);
        System.out.println("==========================");
        testSet.printPeople();

        testSet.editPerson(vasa, "НеВася", LocalDate.of(1993, 3, 15));
        System.out.println("==========================");
        testSet.printPeople();

        testSet.sortPeople();
        System.out.println("==========================");
        testSet.printPeople();
         */
    }

}
