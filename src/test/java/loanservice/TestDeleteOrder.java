package loanservice;

import api.models.CommonRequest;
import api.models.delete_order.DeleteOrderPayload;
import api.steps.loan_service.LoanServiceSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("loan-service")
public class TestDeleteOrder {

    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private static final CommonRequest commonRequest = CommonRequest.builder().build();

    private static final DeleteOrderPayload commonPayload = DeleteOrderPayload.builder().build();

    @Test
    @DisplayName("Позитивный тест удаления заявки")
    @Description("Проверка получения успешного статуса при удалении заявки")
    void successDeleteOrder() {
        Response response = loanServiceSteps.deleteOrder(commonRequest, commonPayload);
        loanServiceSteps.responseShouldIndicateThatRequestWasSuccessful(response);
    }
}
