package com.example.demo3;

import com.example.demo3.model.Person;

import java.util.List;
import java.util.UUID;

public interface PeopleService {
    void addPerson(Person person);

    Person editPerson(UUID id, String newName, String newBirthday);

    void delPerson(UUID id);

    void sortPeople();

    void printPeople();

    void printAll();

    Person getPerson(UUID id);

    List<Person> getPeopleList();

}
