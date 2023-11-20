package ua.ithillel.bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDto> getAll(Pageable pageable) {
        return personService.getPersons(pageable);
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
