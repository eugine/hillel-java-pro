package ua.ithillel.testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.testing.service.repository.PersonRepository;

class PersonServiceTest {
    private PersonRepository personRepository;
    private PersonService target;

    @BeforeEach
    void setUp() {
        target = new PersonService(personRepository);
    }

    @Test
    void shouldCreateNewPerson() {
        var person = new Person("petro1", "Petro");
//        personService.process(new Event(PERSON_CREATED, person));
    }
}
