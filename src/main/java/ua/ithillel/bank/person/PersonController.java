package ua.ithillel.bank.person;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDto> getAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            Pageable pageable) {
        log.info("getPersons: name={}, email={}", name, email);
        return personService.findPersons(name, email, pageable);
    }

    @GetMapping("/{uid}")
    public PersonDto person(@PathVariable("uid") String uid) {
        return personService.getPerson(uid);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto request) {
        return personService.create(request);
    }

    @DeleteMapping("/{uid}")
    public void deletePerson(@PathVariable("uid") String uid) {
        personService.delete(uid);
    }

    @PutMapping("/{uid}")
    public PersonDto updatedPerson(
            @PathVariable("uid") String uid,
            @RequestBody PersonDto request) {
        return personService.update(uid, request);
    }


}
