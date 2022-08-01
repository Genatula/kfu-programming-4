package ru.kpfu.itis.genatulin.hw5.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.genatulin.hw5.models.Person;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Schema(name = "Person creation schema", description = "Schema used to create a new person")
public class PersonForm {
    private String name;

    public static PersonForm from(Person person) {
        return PersonForm.builder()
                .name(person.getName())
                .build();
    }

    public static List<PersonForm> from(List<Person> people) {
        return people.stream().map(PersonForm::from).collect(Collectors.toList());
    }
}
