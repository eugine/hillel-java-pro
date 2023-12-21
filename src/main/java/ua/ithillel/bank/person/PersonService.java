package ua.ithillel.bank.person;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonProperties personConfig;
    private final PersonMapper personMapper;

    public List<PersonDto> findPersons(String name, String email, Pageable pageable) {
        try {
            MDC.put("test", "testValue");
            MDC.put("test1", "testValue");
            MDC.put("test2", "testValue");
            MDC.put("test3", "testValue");
            var specification = Specification.where(fieldValueEqualQuery("name", name))
                    .and(fieldValueEqualQuery("email", email));

            if (true) {
                log.info("case 1");
                //1
            } else {
                log.info("case 2");
                ///2
            }
            return personRepository.findAll(specification).stream()
                    .map(personMapper::map)
                    .toList();
        } finally {
            MDC.clear();
        }

    }

    private Specification<Person> fieldValueEqualQuery(String fieldName, String fieldValue) {
        return fieldValue == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(fieldName), fieldValue);
    }

    public PersonDto getPerson(String id) {
        System.out.println(personConfig);
        return personRepository.findByUid(id)
                .map(personMapper::map)
                .orElseThrow();
    }

    public PersonDto create(PersonDto request) {
        return personMapper.map(personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(request.name())
                .email(request.email())
                .build()));
    }

//    @Transactional
    public void update(String uid) {
        var person = personRepository.findByUid(uid).orElseThrow();

        person.setEmail("email");
//          personRepository.save(person);
    }
}
