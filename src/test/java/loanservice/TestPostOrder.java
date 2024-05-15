package loanservice;

import api.entity.credit_app.LoanOrder;
import api.models.CommonRequest;
import api.models.post_order.PostOrderPayload;
import api.models.post_order.PostOrderResponse;
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
@Story("POST /order. Подача заявки на кредит")
class TestPostOrder {

    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    private final LoanOrderFixtureSteps loanOrderFixtureSteps = new LoanOrderFixtureSteps();

    private static final CommonRequest commonRequest = CommonRequest.builder().build();

    private static final PostOrderPayload commonPayload = PostOrderPayload.builder().build();

    @Test
    @DisplayName("Позитивный тест получения тарифов")
    @Description("Проверка получения успешного ответа с информацией о кредитных тарифах")
    void successPostOrder() {
        Response response = loanServiceSteps.postOrder(commonRequest, commonPayload);
        loanServiceSteps.responseShouldIndicateThatRequestWasSuccessful(response);

        PostOrderResponse actualLoanOrder = PostOrderResponse.createFrom(response);

        LoanOrder expectedLoanOrder = loanOrderFixtureSteps.getLoanOrder(actualLoanOrder.getOrderId());
        loanServiceSteps.loanOrderShouldBeEqualToExpected(actualLoanOrder, expectedLoanOrder);
    }
}
