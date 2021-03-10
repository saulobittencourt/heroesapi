package com.reactive.heroesapi.repo;

import com.reactive.heroesapi.model.Hero;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface HeroesRepo extends CrudRepository<Hero, String> {
}