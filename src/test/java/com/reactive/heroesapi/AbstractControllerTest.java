package com.reactive.heroesapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;

public abstract class AbstractControllerTest {

    @LocalServerPort
    protected int port;

    protected RequestSpecification specification;

    @BeforeEach
    public void setUp() {
        specification = new RequestSpecBuilder()
                .setPort(port)
                .setBasePath("/ws_heroes")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

}
