package ua.ithillel.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class);
    }
}

/*
6. Add pagination & sorting
7. Add query by example
8. Add test -> not today
 */
