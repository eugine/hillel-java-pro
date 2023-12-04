package ua.ithillel.bank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ua.ithillel.bank.config.WiremockConfig;
import ua.ithillel.bank.person.PersonRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public abstract class BaseInMemoryIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected PersonRepository personRepository;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected WireMockServer wireMockServer;

    @AfterEach
    void tearDown() {
        wireMockServer.resetAll();
    }

    @DynamicPropertySource
    public static void registerDynamicProperties(DynamicPropertyRegistry registry) {
        registry.add("wiremock.baseurl", WiremockConfig.wireMockServer::baseUrl);
    }

}
