package ru.kpfu.itis.genatulin.hw5.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.kpfu.itis.genatulin.hw5.dtos.PersonForm;
import ru.kpfu.itis.genatulin.hw5.exceptions.PersonDoesNotExistException;
import ru.kpfu.itis.genatulin.hw5.models.Person;

import java.util.List;

@Tag(name = "Person API", description = "API used for CRUD operations on Person")
public interface PersonApi {
    @Operation(description = "Get all existing persons")
    List<Person> getPersons();
    @Operation(description = "Create a person")
    void createPerson(@Parameter(name = "Person creation form", description = "Info used for person creation") PersonForm personForm);
    @Operation(description = "Get a person by id")
    Person getPerson(@Parameter(name = "Id", description = "Person id") String id) throws PersonDoesNotExistException;
    @Operation(description = "Update person's information")
    void updatePerson(@Parameter(name = "Id", description = "Person id") String id, @Parameter(name = "Update person form", description = "Info to which one wants to update a person") PersonForm personForm) throws PersonDoesNotExistException;
    @Operation(description = "Delete a person by id")
    void deletePerson(@Parameter(name = "Id", description = "Person id") String id) throws PersonDoesNotExistException;
}
