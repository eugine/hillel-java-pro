package ua.ithillel.hero;

import java.util.List;

public interface HeroRepository {

    List<HeroEntity> findAll();
    HeroEntity save(HeroEntity hero);
}
