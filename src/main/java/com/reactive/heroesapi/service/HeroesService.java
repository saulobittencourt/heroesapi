package com.reactive.heroesapi.service;

import com.reactive.heroesapi.exceptions.ServiceBusinessException;
import com.reactive.heroesapi.model.Hero;
import com.reactive.heroesapi.repo.HeroesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HeroesService {
    private final HeroesRepo heroesRepo;

    public Flux<Hero> findAllHeroes(){
        return Flux.fromIterable(heroesRepo.findAll());
    }

    public Mono<Hero> findHeroById(String heroId){
        return Mono.justOrEmpty(heroesRepo.findById(heroId));
    }

    public Mono<Hero> saveHeroData(Hero hero){
        return Mono.justOrEmpty(heroesRepo.save(hero));
    }

    public Mono<Void> deleteHeroDate(String heroId){
        Optional<Hero> heroe = heroesRepo.findById(heroId);
        if (!heroe.isPresent()){
            throw new ServiceBusinessException("Hero not found");
        }

        heroesRepo.deleteById(heroId);
        return Mono.empty();
    }
}
