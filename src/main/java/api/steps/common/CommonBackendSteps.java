package api.steps.common;

import api.models.CommonRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.Map;

public class CommonBackendSteps {

    protected RequestSpecBuilder getRequestSpecBuilder(CommonRequest request, String path) {
        return getRequestSpecBuilder(request, path, "empty_payload");
    }

    protected RequestSpecBuilder getRequestSpecBuilder(CommonRequest request, String path, Object payload) {
        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
                        .enablePrettyPrinting(true));
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        Map<String, Object> queryParams = request.getQueryParams();

        return new RequestSpecBuilder()
                .setBasePath(path)
                .setBody(payload)
                .addQueryParams(queryParams);
    }
}
