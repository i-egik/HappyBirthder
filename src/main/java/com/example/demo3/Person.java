package com.example.demo3;

import java.util.UUID;

public class Person {
    String name;
    String birthday;
    final UUID id;

    public Person(UUID id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
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
