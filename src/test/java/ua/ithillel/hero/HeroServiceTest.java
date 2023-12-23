package ua.ithillel.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTest {

    @Mock
    private HeroRepository repository;
    private HeroService target;

    @Captor
    private ArgumentCaptor<HeroEntity> captor;


    @BeforeEach
    public void setup() {
        target = new HeroService(repository);
    }

    @Test
    public void shouldPersist() {
        target.persist(new HeroDto("test"));

        Mockito.verify(repository).save(captor.capture());
        var entity = captor.getValue();
       D
    }

}
