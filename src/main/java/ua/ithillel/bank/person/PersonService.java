package ua.ithillel.bank.person;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
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

    public List<PersonDto> findPersons(Pageable pageable) {
//        var specification = Specification.where(nameEqualQuery(name))
//                .and(emailEqualQuery(email));

        return personRepository.findAll(pageable).stream()
                .map(this::mapPerson)
                .toList();
    }

    private Specification<Person> emailEqualQuery(String email) {
//        return email == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
        return email == null ? null : new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("email"), email);
            }
        };
    }

    private Specification<Person> nameEqualQuery(String name) {
        return name == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }


    private PersonDto mapPerson(Person person) {
        return new PersonDto(person.getUid(), person.getName());
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
                .build()));
    }
}
