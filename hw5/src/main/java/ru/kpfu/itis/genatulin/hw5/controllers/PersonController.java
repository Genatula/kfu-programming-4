package ru.kpfu.itis.genatulin.hw5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.kpfu.itis.genatulin.hw5.dtos.PersonForm;
import ru.kpfu.itis.genatulin.hw5.exceptions.PersonDoesNotExistException;
import ru.kpfu.itis.genatulin.hw5.models.Person;
import ru.kpfu.itis.genatulin.hw5.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController implements PersonApi {
    private final PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersons() {
        return personService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody PersonForm form) {
        personService.createPerson(form);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson(@PathVariable String id) {
        try {
            return personService.getPerson(Long.valueOf(id));
        } catch (PersonDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no person with such id", e);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePerson(@PathVariable String id, @RequestBody PersonForm form) {
        try {
            personService.updatePerson(form, Long.valueOf(id));
        } catch (PersonDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no person with such id", e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable String id) {
        try {
            personService.deletePerson(Long.valueOf(id));
        } catch (PersonDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no person with such id", e);
        }
    }
}
