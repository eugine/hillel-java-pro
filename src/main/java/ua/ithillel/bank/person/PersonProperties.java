package ua.ithillel.bank.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonProperties {

    private String firstName;
    private String secondName;
    private String street;
    private String homeTown;

}
// person.home-town ->