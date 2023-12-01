package ua.ithillel.bank.person;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDto map(Person person) {
        return new PersonDto(person.getUid(), person.getName(), person.getEmail());
    }
}
