package ua.ithillel.bank.credit.score;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ua.ithillel.bank.credit.score.model.SquidexResponse;

import java.util.Map;

public class SquidexCreditScoreService implements CreditScoreService {

    private final SquidexProperties props;
    private RestClient restClient;

    public SquidexCreditScoreService(SquidexProperties props) {
        this.props = props;
    }

    private RestClient getRestClient() {
        if (restClient == null) {
            var token = createToken(props);

            restClient = RestClient.builder()
                    .defaultHeader("Authorization", "Bearer " + token)
                    .build();
        }
        return restClient;
    }

    private Object createToken(SquidexProperties props) {
        return RestClient.create().post()
                .uri(props.getTokenUrl())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with("client_id", props.getClientId())
                        .with("client_secret", props.getClientSecret())
                        .with("scope", "squidex-api")
                )
                .retrieve()
                .body(Map.class)
                .get("access_token");
    }


    @Override
    public int getScore(String personId) {
        var response = getRestClient().get()
                .uri(props.getUrl())
                .retrieve()
                .body(SquidexResponse.class);
        return response.getData().getScore().getIv();
    }
}
