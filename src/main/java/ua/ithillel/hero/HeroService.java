package ua.ithillel.hero;

import java.util.List;

public class HeroService {

    private final HeroRepository repository;

    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public List<HeroDto> getAll() {
        return repository.findAll().stream()
                .map(hero -> new HeroDto("name"))
                .toList();
    }

    public void persist(HeroDto request) {
        repository.save(new HeroEntity(request.name()));
    }



}
