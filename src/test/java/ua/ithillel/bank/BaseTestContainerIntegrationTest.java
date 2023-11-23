package ua.ithillel.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ua.ithillel.bank.person.PersonRepository;

@SpringBootTest
@ActiveProfiles("testcontainers")
@AutoConfigureMockMvc
@Testcontainers
public class BaseTestContainerIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected PersonRepository personRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresSQLContainer = new PostgreSQLContainer<>("postgres:15.2");

    @DynamicPropertySource
    public static void registerWiremockBaseUrl(DynamicPropertyRegistry registry) {
//        registry.add("wiremock.baseurl", WiremockConfig.wireMockServer::baseUrl);
        registry.add("spring.datasource.url", postgresSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgresSQLContainer::getPassword);
    }
}
