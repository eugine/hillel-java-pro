package ua.ithillel.bank.credit.score;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ua.ithillel.bank.credit.score.model.SquidexResponse;

import java.util.Map;

public class SquidexCreditScoreService implements CreditScoreService {

    private final SquidexProperties props;
    private WebClient webClient;

    public SquidexCreditScoreService(SquidexProperties props) {
        this.props = props;
    }

    private WebClient getWebClient() {
        if (webClient == null) {
            var token = createToken(props);

            webClient = WebClient.builder()
                    .defaultHeader("Authorization", "Bearer " + token)
                    .build();
        }
        return webClient;
    }

    private Object createToken(SquidexProperties props) {
        return WebClient.create().post()
                .uri(props.getTokenUrl())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with("client_id", props.getClientId())
                        .with("client_secret", props.getClientSecret())
                        .with("scope", "squidex-api")
                )
                .retrieve()
                .bodyToMono(Map.class)
                .block()
                .get("access_token");
    }


    @Override
    public int getScore(String personId) {
        SquidexResponse response = getWebClient().get()
                .uri(props.getUrl())
                .retrieve()
                .bodyToMono(SquidexResponse.class)
                .block();
        return response.getData().getScore().getIv();
    }
}
