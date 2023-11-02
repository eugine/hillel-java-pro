package ua.ithillel.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ua.ithillel.dao.student.DummyStudentDao;
import ua.ithillel.dao.student.StudentDao;
import ua.ithillel.dao.student.StudentDaoImpl;
import ua.ithillel.dao.student.StudentService;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan("ua.ithillel.spring.core")
@PropertySource("classpath:application.properties")
public class SpringCoreConfig {

    @Value("${my.property}")
    private String myProperty;

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository(List.of(
                new Product(1L, "product-1", 100),
                new Product(2L, "product-2", 200),
                new Product(3L, "product-3", 300)
        ));
    }

    @Bean
    public StudentService studentService(StudentDao dao) {
        return new StudentService(dao);
    }
    
    @Bean
    public StudentDao studentDao(DataSource dataSource) {
        return new StudentDaoImpl(dataSource);
    }

}
