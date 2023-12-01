package ua.ithillel.bank.credit.score.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.bank.credit.score.CreditScoreService;
import ua.ithillel.bank.credit.score.DummyCreditScoreService;
import ua.ithillel.bank.credit.score.SquidexCreditScoreService;
import ua.ithillel.bank.credit.score.SquidexProperties;


@Configuration
public class CreditScoreConfig {

    @ConditionalOnProperty(name = "credit.score.provider", havingValue = "squidex")
    public static class SquidexCreditScoreConfiguration {
        @Bean
        public CreditScoreService creditScoreService(SquidexProperties squidexProperties) {
            return new SquidexCreditScoreService(squidexProperties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "credit.score.provider", havingValue = "dummy")
    public static class DummyCreditScoreConfiguration {
        @Bean
        public CreditScoreService creditScoreService() {
            return new DummyCreditScoreService();
        }
    }


}