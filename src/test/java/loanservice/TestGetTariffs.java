package loanservice;

import api.models.CommonRequest;
import api.steps.LoanServiceSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestGetTariffs {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private static CommonRequest commonRequest;

    @BeforeAll
    static void setUp() {
        commonRequest = CommonRequest.builder()
                .build();
    }

    @Test
    void getTariffsTest() {
        Response response = loanServiceSteps.getTariffs(commonRequest);
    }
}
