package ua.ithillel.bank.person;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> getPersons(Pageable pageable) {
        return personRepository.findAll(pageable).stream()
                .map(this::convertPerson)
                .toList();
    }

    private PersonDto convertPerson(Person person) {
        return new PersonDto(person.getUid(), person.getName());
    }

    public PersonDto getPerson(String id) {
        return personRepository.findByUid(id)
                .map(this::convertPerson)
                .orElseThrow();
    }

    public PersonDto create(PersonDto request) {
        return convertPerson(personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(request.name())
                .build()));
    }
}
