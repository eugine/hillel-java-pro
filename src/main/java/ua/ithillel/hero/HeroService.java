package ua.ithillel.hero;

import java.util.List;

public class HeroService {
    private final HeroDao heroDao;

    public HeroService(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    public List<HeroDto> getHeroes() {
        return heroDao.getAll().stream()
                .map(hero -> new HeroDto("xxx", List.of("yyyy")))
                .toList();
    }
}
