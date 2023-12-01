package ua.ithillel.bank.credit.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Configuration
@ConfigurationProperties(prefix = "squidex")
public class SquidexProperties {
    private String url;
    private String tokenUrl;

    private String clientId;
    private String clientSecret;

}
