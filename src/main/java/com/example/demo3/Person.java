package com.example.demo3;

import java.util.UUID;

public class Person {
    String name;
    String birthday;
    UUID id;

    public Person(UUID id, String name, String birthday) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthday = birthday;
    }

    public static void toCongradulate(Person person) {
        System.out.println("Товарисч " + person.getName() + " поздравляем тебя с днём авторизации в нашем сервере, денег тебе, здоровья и дружбы со своей кукушечкой");
    }

    UUID getUUID() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getBirthdayDate() {
        return this.birthday;
    }

    void setBirthdayDate(String birthday) {
        this.birthday = birthday;
    }
}
