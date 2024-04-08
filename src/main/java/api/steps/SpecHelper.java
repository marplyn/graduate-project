package api.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecHelper {
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setPort(8080)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
