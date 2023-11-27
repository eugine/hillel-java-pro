package ua.ithillel.bank.person;

import jakarta.transaction.Transactional;
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

    public PersonDto getPerson(String uid) {
        return personRepository.findByUid(uid)
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

    @Transactional
    public void delete(String uid) {
        //1
        personRepository.deleteByUid(uid);

        //2
        var person = findRequiredPerson(uid);
        personRepository.deleteById(person.getId());

        //3
        personRepository.findByUid(uid)
                .ifPresent(personRepository::delete);

    }

    private Person findRequiredPerson(String uid) {
        return personRepository.findByUid(uid)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @Transactional
    public PersonDto update(String uid, PersonDto request) {
        var person = findRequiredPerson(uid);

        person.setName(request.name());
        person.setEmail(request.email());

        return mapPerson(person);
    }


    public static class TransactionProxy {
        private PersonService personService;

        public PersonDto update(String uid, PersonDto request) {
            //begin tx
            try {
                personService.update(uid, request);
                //commit tx
            } catch (Exception ex) {
                //rollback tx
            }
            return null;
        }
    }

}


