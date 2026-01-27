package com.example.demo3;

import java.util.UUID;

public interface PeopleSetInterface {
    public void addPerson(Person person);

    public Person editPerson(UUID id, String newName, String newBirthday);

    public void delPerson(UUID id);

    public void sortPeople();

    public void printPeople();

    public void printAll();

    public Person getPerson(UUID id);

}
