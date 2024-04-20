package loanservice;

import api.models.CommonRequest;
import api.models.get_tariffs.GetTariffsResponse;
import api.steps.LoanServiceSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestGetTariffs {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private static final CommonRequest commonRequest = CommonRequest.builder().build();

    @Test
    void successGetTariffs() {
        Response response = loanServiceSteps.getTariffs(commonRequest);

        GetTariffsResponse actualTariffs = GetTariffsResponse.createFrom(response);
    }
}
