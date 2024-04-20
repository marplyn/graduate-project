package api.steps;

import api.models.CommonRequest;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class LoanServiceSteps extends CommonLoanServiceSteps {

    public Response getTariffs(CommonRequest commonRequest) {
        return given().spec(getTariffsRequestSpec(commonRequest))
                .get();
    }
}
