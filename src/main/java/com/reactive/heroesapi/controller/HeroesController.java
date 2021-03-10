package com.reactive.heroesapi.controller;

import com.reactive.heroesapi.model.Hero;
import com.reactive.heroesapi.service.HeroesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/heroes")
@AllArgsConstructor
public class HeroesController {
    private final HeroesService heroesService;

    @GetMapping
    public ResponseEntity<Flux<Hero>> findAllHeroes(){
        return ResponseEntity.ok(heroesService.findAllHeroes());
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Mono<Hero>> findHeroesById(@PathVariable String heroId){
        return ResponseEntity.ok(heroesService.findHeroById(heroId));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Mono<Hero>> saveHeroData(@RequestBody Hero hero){
        return ResponseEntity.ok(heroesService.saveHeroData(hero));
    }

    @DeleteMapping("/{heroId}")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public ResponseEntity<Mono<Void>> deleteHeroData(@PathVariable String heroId){
        heroesService.deleteHeroDate(heroId);
        return ResponseEntity.noContent().build();
    }
}
