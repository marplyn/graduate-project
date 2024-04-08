package loanservice.positive;

import api.models.CreateOrderRequest;
import api.steps.LoanServiceSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CreateOrderTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @ParameterizedTest
    @CsvSource({
            "120356897, 2",
            "123456, 1",
            "4653785, 3",
            "120356894755, 1"
    })
    void postCreateOrderTest(Long userId, Integer tariffId) {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(userId, tariffId);
        loanServiceSteps.postCreateOrder(createOrderRequest)
                .responseStatusShouldBeEqualTo(200)
                .postCreateOrderShouldBeSuccessful();
    }
}
