package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTestV1 {
    @Test
    public void shouldPost() {
        // Given - When - Then
        // Предусловия
        String jsonData = "{ \"phone\" : \"IPhone\", \"serial\" : 5505 }";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(jsonData) // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("json.phone", equalTo("IPhone"))
                .body("json.serial", equalTo(5505));
    }
}
