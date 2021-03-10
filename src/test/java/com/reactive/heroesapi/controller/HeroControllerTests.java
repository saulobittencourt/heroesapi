package com.reactive.heroesapi.controller;

import com.reactive.heroesapi.AbstractControllerTest;
import com.reactive.heroesapi.model.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.with;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class HeroControllerTests  extends AbstractControllerTest {
    @Test
    void whenGETHeroes_thenReturnOk() {
        with().spec(specification)
                .when()
                .get("/heroes")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void whenPOSTHeroes_thenReturnOk() {
        Hero hero = new Hero();
        hero.setId("1");
        hero.setName("Spider-man");
        hero.setUniverse("Marvel");
        hero.setFilms(20L);

        with().spec(specification)
                .given()
                .body(hero)
                .when()
                .post("/heroes")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}
