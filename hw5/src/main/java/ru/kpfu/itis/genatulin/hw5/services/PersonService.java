package ru.kpfu.itis.genatulin.hw5.services;

import ru.kpfu.itis.genatulin.hw5.dtos.PersonForm;
import ru.kpfu.itis.genatulin.hw5.exceptions.PersonDoesNotExistException;
import ru.kpfu.itis.genatulin.hw5.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    void createPerson(PersonForm form);

    Person getPerson(Long id) throws PersonDoesNotExistException;

    void updatePerson(PersonForm form, Long id) throws PersonDoesNotExistException;

    void deletePerson(Long id) throws PersonDoesNotExistException;
}
