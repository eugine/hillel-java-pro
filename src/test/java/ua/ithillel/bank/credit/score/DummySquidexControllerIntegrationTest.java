package ua.ithillel.bank.credit.score;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import ua.ithillel.bank.BaseInMemoryIntegrationTest;
import ua.ithillel.bank.credit.score.model.IvInteger;
import ua.ithillel.bank.credit.score.model.SquidexResponse;
import ua.ithillel.bank.credit.score.model.SquidexResponseData;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DummySquidexControllerIntegrationTest extends BaseInMemoryIntegrationTest {

    @Test
    void shouldCalculateCreditScore() throws Exception {
        wireMockServer.stubFor(WireMock.post(urlEqualTo("/token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(Map.of("access_token", "hillel-token")))));


        var response = SquidexResponse.builder()
                        .data(SquidexResponseData.builder()
                                .score(IvInteger.builder()
                                        .iv(205)
                                        .build())
                                .build())
                        .build();

        wireMockServer.stubFor(WireMock.get(urlEqualTo("/score"))
                .withHeader("Authorization", WireMock.equalTo("Bearer hillel-token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));

        var rawScore = mockMvc.perform(get("/squidex/score"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        int score = Integer.parseInt(rawScore);

        assertThat(score, equalTo(205));
    }
}
