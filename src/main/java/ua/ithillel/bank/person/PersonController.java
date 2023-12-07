package ua.ithillel.bank.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return personService.findPersons(name, email, pageable);
    }

    @GetMapping("/{id}")
    public PersonDto person(@PathVariable("id") String id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto request) {
        return personService.create(request);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        //TODO: delete
    }

    @PutMapping("/{id}")
    public PersonDto updatedPerson(
            @PathVariable("id") String id,
            @RequestBody PersonDto request) {
        return null;
    }


}
