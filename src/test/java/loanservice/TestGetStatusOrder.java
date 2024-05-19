package loanservice;

import api.models.get_status_order.GetStatusOrderRequest;
import api.models.get_status_order.GetStatusOrderResponse;
import api.steps.fixture.loan_service.LoanOrderFixtureSteps;
import api.steps.loan_service.LoanServiceSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("main")
@Feature("loan-service")
@Story("GET /getStatusOrder. Получение статуса заявки")
class TestGetStatusOrder {

    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private final LoanOrderFixtureSteps loanOrderFixtureSteps = new LoanOrderFixtureSteps();

    private static final GetStatusOrderRequest commonRequest = GetStatusOrderRequest.builder().build();

    @Test
    @DisplayName("Позитивный тест получения статуса заявки")
    @Description("Проверка получения успешного ответа с информацией о статусе заявки")
    void successGetStatusOrder() {
    }
}
