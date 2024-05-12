package api.steps.loan_service;

import api.entity.credit_app.LoanOrder;
import api.entity.credit_app.Tariff;
import api.models.CommonRequest;
import api.models.delete_order.DeleteOrderPayload;
import api.models.get_status_order.GetStatusOrderRequest;
import api.models.get_tariffs.TariffResponse;
import api.models.post_order.PostOrderPayload;
import api.models.post_order.PostOrderResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoanServiceSteps extends CommonLoanServiceSteps {

    @Step("Отправить запрос GET loan-service/getTariffs")
    public Response getTariffs(CommonRequest request) {
        return given().spec(getTariffsRequestSpec(request))
                .get();
    }

    @Step("Отправить запрос POST loan-service/order")
    public Response postOrder(CommonRequest request, PostOrderPayload payload) {
        return given().spec(getPostOrderRequestSpec(request, payload))
                .post();
    }

    @Step("Отправить запрос GET loan-service/getStatusOrder")
    public Response getStatusOrder(GetStatusOrderRequest request) {
        return given().spec(getStatusOrderRequestSpec(request))
                .get();
    }

    @Step("Отправить запрос DELETE loan-service/deleteOrder")
    public Response deleteOrder(CommonRequest request, DeleteOrderPayload payload) {
        return given().spec(getDeleteOrderRequestSpec(request, payload))
                .delete();
    }

    @Step("Список тарифов должен быть равен ожидаемому")
    public void tariffListShouldBeEqualToExpected(List<TariffResponse> actualTariffs,
                                                  List<Tariff> expectedTariffs) {
        assertThat(actualTariffs).hasSameSizeAs(expectedTariffs);

        for (int i = 0; i < actualTariffs.size(); i++) {
            TariffResponse actualTariff = actualTariffs.get(i);
            Tariff expectedTariff = expectedTariffs.get(i);

            assertThat(actualTariff.getId()).isEqualTo(expectedTariff.getId());
            assertThat(actualTariff.getInterestRate()).isEqualTo(expectedTariff.getInterestRate());
            assertThat(actualTariff.getType()).isEqualTo(expectedTariff.getType());
        }
    }

    @Step("Информация о заявке должна быть равна ожидаемой")
    public void loanOrderShouldBeEqualToExpected(PostOrderResponse actualLoanOrder, LoanOrder expectedLoanOrder) {
    }

    @Step("Информация о статусе заявки должна быть равна ожидаемой")
    public void statusOrderShouldBeEqualToExpected(String actualStatus, String expectedStatus) {

    }
}
