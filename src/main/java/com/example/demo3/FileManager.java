package com.example.demo3;

import com.example.demo3.model.Person;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class FileManager {
    public static void saveToFile(List<Person> people, String fileName) throws IOException {
        try (BufferedWriter saver = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : people) {
                saver.write(person.getId() + " | " + person.getName() + " | " + person.getBirthday());
                saver.newLine();
            }
        }
    }

    public static void loadFromFile(List<Person> people, String fileName) throws IOException {
        try (BufferedReader loader = new BufferedReader(new FileReader(fileName))) {
            for (String line : loader.lines().toList()) {
                String[] stringArray = line.split("\\|");
                if (stringArray.length != 3) {
                    continue;
                }
                String loadUUID;
                String loadName;
                String loadBirthday;
                loadUUID = stringArray[0];
                loadName = stringArray[1];
                loadBirthday = stringArray[2];

                people.add(new Person(UUID.fromString(loadUUID.trim()), loadName.trim(), loadBirthday.trim()));
            }
        } catch (FileNotFoundException e) {
        }
    }
//пройти по строке, найти все разделители
    //из строки получить подстроки по разделителям
    //каждая подстрока -- ассоциируется со своим полем объекта people
    //Создаем объект Peoplе и заполняем данными согласно предыдущему пункту
    // потом объект сохраняем в список (простой add)
}