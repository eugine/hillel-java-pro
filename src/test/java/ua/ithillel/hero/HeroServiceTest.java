package ua.ithillel.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {

    @Mock
    private HeroDao heroDao;

    private HeroService target;

    @BeforeEach
    void setUp() {
        target = new HeroService(heroDao);
    }

    @Test
    void shouldGetHeroes() {
        Mockito.when(heroDao.getAll()).thenReturn(List.of(
                new Hero(),
                new Hero()
        ));

        List<HeroDto> result = target.getHeroes();

        assertThat(result, hasSize(2));

    }
}