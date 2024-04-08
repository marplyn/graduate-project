package loanservice.negative;

import api.models.CreateOrderRequest;
import api.steps.LoanServiceSteps;
import org.junit.jupiter.api.Test;

public class CreateOrderNegativeTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @Test
    void postCreateOrderInvalidTariffTest() {
        Long userId = 420356955L;
        Integer tariffId = 25;
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(userId, tariffId);
        loanServiceSteps.postCreateOrder(createOrderRequest)
                .responseStatusShouldBeEqualTo(400)
                .postCreateOrderShouldHaveError();
    }

    @Test
    void postCreateOrderEmptyTest() {
        Long userId = null;
        Integer tariffId = null;
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(userId, tariffId);
        loanServiceSteps.postCreateOrder(createOrderRequest)
                .responseStatusShouldBeEqualTo(400)
                .postCreateOrderShouldHaveError();
    }
}
