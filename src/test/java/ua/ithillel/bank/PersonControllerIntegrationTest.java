package ua.ithillel.bank;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import ua.ithillel.bank.person.Person;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonControllerIntegrationTest extends BaseInMemoryIntegrationTest {
//public class PersonControllerIntegrationTest extends BaseTestContainerIntegrationTest {

    @Test
    void shouldFindPerson() throws Exception {
//
//        var person = personRepository.save(Person.builder()
//                .uid(UUID.randomUUID().toString())
//                .name("Test")
//                .build());

        var request = get("/api/persons/{}", "123");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo("name")));
    }
}
