package com.example.demo3.controller.representation;

import lombok.Data;

import java.util.UUID;
public record PeopleRepresentation(UUID id, String name, String birthday) {
}
