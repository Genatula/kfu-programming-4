package ru.kpfu.itis.genatulin.hw5.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.genatulin.hw5.dtos.PersonForm;
import ru.kpfu.itis.genatulin.hw5.exceptions.PersonDoesNotExistException;
import ru.kpfu.itis.genatulin.hw5.models.Person;
import ru.kpfu.itis.genatulin.hw5.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void createPerson(PersonForm form) {
        Person person = new Person();
        person.setName(form.getName());
        personRepository.save(person);
    }

    @Override
    public Person getPerson(Long id) throws PersonDoesNotExistException {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        else {
            throw new PersonDoesNotExistException("Person with a provided id does not exist");
        }
    }

    @Override
    public void updatePerson(PersonForm form, Long id) throws PersonDoesNotExistException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(form.getName());
            personRepository.save(person);
        }
        else {
            throw new PersonDoesNotExistException("Person with a provided id does not exist");
        }
    }

    @Override
    public void deletePerson(Long id) throws PersonDoesNotExistException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            personRepository.delete(person);
        }
        else {
            throw new PersonDoesNotExistException("Person with a provided id does not exist");
        }
    }
}
