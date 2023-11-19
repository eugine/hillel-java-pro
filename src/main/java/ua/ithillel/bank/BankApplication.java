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
1. Add API
2. Add service
3. Add entity and repository
4. Add migration with UID
5. Add more fields
6. Add pagination & sorting
7. Add query by example
8. Add test -> not today
 */
