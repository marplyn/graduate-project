package loanservice;

import api.models.CommonRequest;
import api.models.get_tariffs.GetTariffsResponse;
import api.steps.LoanServiceSteps;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGetTariffs {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private static final CommonRequest commonRequest = CommonRequest.builder().build();

    @Test
    @DisplayName("Позитивный тест получения тарифов")
    @Description("Проверка получения успешного ответа с информацией о кредитных тарифах")
    void successGetTariffs() {
        Response response = loanServiceSteps.getTariffs(commonRequest);

        GetTariffsResponse actualTariffs = GetTariffsResponse.createFrom(response);
    }
}
