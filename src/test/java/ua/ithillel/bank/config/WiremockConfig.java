package ua.ithillel.bank.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration
public class WiremockConfig {

    public final static WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());

    @Bean
    public WireMockServer wireMockServer() {
        return wireMockServer;
    }

    @PostConstruct
    public void startServer() {
        wireMockServer.start();
    }

    @PreDestroy
    public void stopServer() {
        wireMockServer.stop();
    }

}
