package com.example.demo3.controller;

import com.example.demo3.PeopleService;
import com.example.demo3.controller.representation.PeopleRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/people")
public class PeopleController {
    private final PeopleService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PeopleRepresentation>> getPeopleList() {
        var list = service.getPeopleList().stream().map(person -> new PeopleRepresentation(person.getId(), person.getName(), person.getBirthday())).toList();
        return ResponseEntity.ok(list);
    }
}
//TODO: добавить сюда мметоды управления: добавление, убавление, изменение и прочие. (реализованы раннее) Методы взаимодействуют с PeopleService. CRUD -- почитать про эту штуку
//поискать какие аннотации отвечают за всякие void и прочие методы
//TODO: попробовать добавить тесты (на перспективу)