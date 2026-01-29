package com.example.demo3.service;

import com.example.demo3.PeopleService;
import com.example.demo3.model.Person;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static com.example.demo3.FileManager.loadFromFile;
import static com.example.demo3.FileManager.saveToFile;
@Service
public class PeopleServiceInMemory implements PeopleService {
    @Getter
    private final List<Person> peopleList = new ArrayList<>();

    public void defaultPrint(List<Person> peopleList) {
        sortPeople();
        if (peopleList.size() < 3) {
            System.out.println(peopleList.get(0).getName() + " " + peopleList.get(0).getBirthday());
            System.out.println(peopleList.get(1).getName() + " " + peopleList.get(1).getBirthday());
            return;
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(peopleList.get(i).getName() + " " + peopleList.get(i).getBirthday());
        }
    }


    public void toCongradulate(UUID id) {
        Person happyPerson = getPerson(id);
        System.out.println("Товарисч " + happyPerson.getName() + " поздравляем тебя с днём авторизации в нашем сервере, денег тебе, здоровья и дружбы со своей кукушечкой");
    }

    public void autoHappyBirthder(List<Person> people) {
        LocalDate today = LocalDate.now();
        for (Person person : people) {
            LocalDate happyDayX = LocalDate.parse(person.getBirthday());
            if (happyDayX.getMonth() == today.getMonth() && happyDayX.getDayOfMonth() == today.getDayOfMonth()) {
                System.out.println("Сегодня у нас родился " + person.getName() + " поздравляем тебя с днём авторизации в нашем сервере, денег тебе, здоровья и дружбы со своей кукушечкой");
            }
        }
    }


    @Override
    public Person getPerson(UUID id) {
        for (Person person : peopleList) {
            UUID carrentPerson = person.getId();
            if (id.equals(carrentPerson)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void addPerson(Person person) {
        peopleList.add(person);
        save();
    }

    @Override
    public void delPerson(UUID id) {
        Person deletedPerson = getPerson(id);
        if (deletedPerson == null) {
            return;
        }
        peopleList.remove(deletedPerson);
        save();
    }

    private void save() {
        try {
            saveToFile(peopleList, "People.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() {
        try {
            loadFromFile(peopleList, "People.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person editPerson(UUID id, String newName, String newBirthday) {
        Person carrentPerson = getPerson(id);
        if (carrentPerson == null) {
            return null;
        }
        carrentPerson.setName(newName);
        carrentPerson.setBirthday(newBirthday);
        save();
        return carrentPerson;
    }

    @Override
    public void printPeople() {
        for (Person person : peopleList) {
            System.out.println(person.getName() + ", " + person.getBirthday());
        }
    }

    @Override
    public void printAll() {
        for (Person person : peopleList) {
            System.out.println(person.getId() + ", " + person.getName() + ", " + person.getBirthday());
        }
    }

    public void sortPeople() {
        LocalDate today = LocalDate.now();

        peopleList.sort(Comparator.comparing(person -> {
            // берём день и месяц
            MonthDay birthday = MonthDay.from(LocalDate.parse(person.getBirthday()));

            // строим дату ближайшего дня рождения
            LocalDate nextBirthday = birthday.atYear(today.getYear());
            if (nextBirthday.isBefore(today) || !nextBirthday.isEqual(today) && nextBirthday.isBefore(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }
            return nextBirthday;
        }));
    }
}

