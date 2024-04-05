package helpers.requests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Requests {
    public static <T> List<T> getList(RequestSpecification requestSpec, String pathToResource,
                                      ResponseSpecification responseSpec, String jsonPath, Class<T> tClass) {
        return given()
                .filter(new AllureRestAssured())
                .spec(requestSpec)
                .when()
                .get(pathToResource)
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getList(jsonPath, tClass);
    }

    public static <T> T get(RequestSpecification requestSpec, String pathToResource,
                            ResponseSpecification responseSpec, Class<T> tClass) {
        return given()
                .filter(new AllureRestAssured())
                .spec(requestSpec)
                .when()
                .get(pathToResource)
                .then()
                .spec(responseSpec)
                .extract().body().as(tClass);
    }

    public static <T> T post(RequestSpecification requestSpec, String pathToResource,
                               ResponseSpecification responseSpec, Class<T> tClass) {
        return given()
                .filter(new AllureRestAssured())
                .spec(requestSpec)
                .when()
                .post(pathToResource)
                .then()
                .spec(responseSpec)
                .extract().body().as(tClass);
    }

    public static <T> T put(RequestSpecification requestSpec, String pathToResource,
                               ResponseSpecification responseSpec, Class<T> tClass) {
        return given()
                .filter(new AllureRestAssured())
                .spec(requestSpec)
                .when()
                .put(pathToResource)
                .then()
                .spec(responseSpec)
                .extract().body().as(tClass);
    }

    public static <T> T patch(RequestSpecification requestSpec, String pathToResource,
                            ResponseSpecification responseSpec, Class<T> tClass) {
        return given()
                .filter(new AllureRestAssured())
                .spec(requestSpec)
                .when()
                .patch(pathToResource)
                .then()
                .spec(responseSpec)
                .extract().body().as(tClass);
    }

    public static <T>  T delete(RequestSpecification requestSpec, String pathToResource,
                                ResponseSpecification responseSpec, Class<T> tClass) {
        return given()
                .filter(new AllureRestAssured())
                .spec(requestSpec)
                .when()
                .delete(pathToResource)
                .then()
                .spec(responseSpec)
                .extract().body().as(tClass);
    }
}
