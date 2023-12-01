package ua.ithillel.bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonProperties personConfig;
    private final PersonMapper personMapper;

    public List<PersonDto> findPersons(String name, String email, Pageable pageable) {
        var specification = Specification.where(fieldValueEqualQuery("name", name))
                .and(fieldValueEqualQuery("email", email));

        return personRepository.findAll(specification).stream()
                .map(personMapper::map)
                .toList();
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
}
