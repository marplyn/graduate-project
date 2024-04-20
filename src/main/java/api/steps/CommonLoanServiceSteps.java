package api.steps;

import api.models.CommonRequest;
import io.restassured.specification.RequestSpecification;

public class CommonLoanServiceSteps extends CommonSteps {

    protected RequestSpecification getTariffsRequestSpec(CommonRequest commonRequest) {
        final String path = "loan-service/getTariffs";

        return getRequestSpecBuilder(commonRequest, path).build();
    }
}
