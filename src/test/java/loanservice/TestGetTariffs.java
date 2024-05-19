package loanservice;

import api.entity.credit_app.Tariff;
import api.models.CommonRequest;
import api.models.get_tariffs.GetTariffsResponse;
import api.models.get_tariffs.TariffResponse;
import api.steps.fixture.loan_service.TariffFixtureSteps;
import api.steps.loan_service.LoanServiceSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@Epic("main")
@Feature("loan-service")
@Story("GET /getTariffs. Получение списка тарифов")
class TestGetTariffs {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private final TariffFixtureSteps tariffFixtureSteps = new TariffFixtureSteps();

    private static final CommonRequest commonRequest = CommonRequest.builder().build();

    @Test
    @DisplayName("Позитивный тест получения тарифов")
    @Description("Проверка получения успешного ответа с информацией о кредитных тарифах")
    void successGetTariffs() {
        Response response = loanServiceSteps.getTariffs(commonRequest);
        loanServiceSteps.responseShouldIndicateThatRequestWasSuccessful(response);

        List<TariffResponse> actualTariffs = GetTariffsResponse.createFrom(response)
                .getData()
                .getTariffs();

        List<Tariff> expectedTariffs = tariffFixtureSteps.getTariffList();
        loanServiceSteps.tariffListShouldBeEqualToExpected(actualTariffs, expectedTariffs);
    }
}
