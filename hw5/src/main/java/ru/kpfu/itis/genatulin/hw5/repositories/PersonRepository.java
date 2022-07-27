package ru.kpfu.itis.genatulin.hw5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.genatulin.hw5.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}