package loanservice;

import api.models.CreateOrderRequest;
import api.models.DeleteOrderRequest;
import api.steps.LoanServiceSteps;
import org.junit.jupiter.api.Test;

public class E2ETests {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @Test
    void createGetStatusDeleteTest(){
        Long userId = 98803985L;
        Integer tariffId = 3;

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(userId, tariffId);
        loanServiceSteps.postCreateOrder(createOrderRequest)
                .responseStatusShouldBeEqualTo(200)
                .postCreateOrderShouldBeSuccessful();
        String responseOrderId = loanServiceSteps.orderIdFromResponse();

        loanServiceSteps.getStatusOrder(responseOrderId)
                .responseStatusShouldBeEqualTo(200)
                .getStatusOrderShouldBeSuccessful();

        DeleteOrderRequest deleteOrderRequest = new DeleteOrderRequest(userId, responseOrderId);
        loanServiceSteps.deleteOrder(deleteOrderRequest)
                .responseStatusShouldBeEqualTo(200);
    }

    @Test
    void createTwoTimesTest() {
        Long userId = 106703412L;
        Integer tariffId = 2;

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(userId, tariffId);
        loanServiceSteps.postCreateOrder(createOrderRequest)
                .responseStatusShouldBeEqualTo(200)
                .postCreateOrderShouldBeSuccessful();

        loanServiceSteps.postCreateOrder(createOrderRequest)
                .responseStatusShouldBeEqualTo(400)
                .postCreateOrderShouldHaveError();
    }
}
