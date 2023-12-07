package ua.ithillel.bank;

import org.junit.jupiter.api.Test;
import ua.ithillel.bank.person.Person;
import ua.ithillel.bank.person.PersonDto;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//public class PersonControllerIntegrationTest extends BaseInMemoryIntegrationTest {
public class PersonControllerIntegrationTest extends BaseTestContainerIntegrationTest {

    @Test
    void shouldFindPerson() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .email("test_" + UUID.randomUUID() + "@example.com")
                .build());

        mockMvc.perform(get("/api/persons/{id}", person.getUid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(person.getName())))
                .andExpect(jsonPath("$.email", equalTo(person.getEmail())))
        ;
    }

    @Test
    void shouldCreatePerson() throws Exception {
        var request = new PersonDto(null, "Test", "test_" + UUID.randomUUID() + "@example.com");

        var body = mockMvc.perform(post("/api/persons")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.name", equalTo(request.name())))
                .andExpect(jsonPath("$.email", equalTo(request.email())))
                .andReturn()
                .getResponse()
                .getContentAsString();

        var personId = objectMapper.readValue(body, PersonDto.class).id();

        var persistedPerson = personRepository.findByUid(personId).orElseThrow();
        assertThat(persistedPerson.getName(), equalTo(request.name()));
        assertThat(persistedPerson.getEmail(), equalTo(request.email()));
        assertThat(persistedPerson.getCreatedAt(), is(notNullValue()));
        assertThat(persistedPerson.getUpdatedAt(), is(notNullValue()));
    }


}
