package ua.ithillel.bank.person;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> findPersons(String name, String email, Pageable pageable) {
//        var results = resolveAndExecuteQuery(name, email, pageable);

//        //example
//        Example<Person> example = Example.of(Person.builder()
//                .name(name)
//                .email(email)
//                .build());
//        var results = personRepository.findAll(example, pageable);

        var specification = Specification.where(fieldValueEqualQuery("name", name))
                .and(fieldValueEqualQuery("email", email));

        return personRepository.findAll(specification).stream()
                .map(this::mapPerson)
                .toList();
    }

    private Page<Person> resolveAndExecuteQuery(String name, String email, Pageable pageable) {
        if (name != null) {
            if (email != null) {
                return personRepository.findByNameAndEmail(name, email, pageable);
            }
            return personRepository.findByName(name, pageable);
        } else {
            if (email != null) {
                return personRepository.findByEmail(email, pageable);
            }
            return personRepository.findAll(pageable);
        }
    }

    private Specification<Person> fieldValueEqualQuery(String fieldName, String fieldValue) {
        return fieldValue == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(fieldName), fieldValue);
    }

    private PersonDto mapPerson(Person person) {
        return new PersonDto(person.getUid(), person.getName(), person.getEmail());
    }

    public PersonDto getPerson(String id) {
        return personRepository.findByUid(id)
                .map(this::mapPerson)
                .orElseThrow();
    }

    public PersonDto create(PersonDto request) {
        return mapPerson(personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(request.name())
                .email(request.email())
                .build()));
    }
}
