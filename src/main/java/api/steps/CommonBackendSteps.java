package api.steps;

import api.models.CommonRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.internal.common.assertion.AssertParameter;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class CommonBackendSteps {

    private RequestSpecificationImpl spec;

    protected RequestSpecBuilder getRequestSpecBuilder(CommonRequest request, String path) {
        return getRequestSpecBuilder(request, path, "empty_payload");
    }

    protected RequestSpecBuilder getRequestSpecBuilder(CommonRequest request, String path, Object payload) {
        Map<String, Object> queryParams = request.getQueryParams();

        return new RequestSpecBuilder()
                .setBasePath(path)
                .setBody(payload)
                .addQueryParams(queryParams)
                .log(LogDetail.ALL);
    }
}
