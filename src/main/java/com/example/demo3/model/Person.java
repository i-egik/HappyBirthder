package com.example.demo3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Person {
    private final UUID id;
    private String name;
    private String birthday;
}