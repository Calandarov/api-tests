package helpers.specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Specifications {
    public static RequestSpecification requestSpecificationNoBody(String baseUri) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .build();
    }

    public static RequestSpecification requestSpecificationJsonBody(String baseUri, Object body) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .setBody(body)
                .build();
    }

    public static ResponseSpecification responseSpecification(int httpCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(httpCode)
                .build();
    }
}
