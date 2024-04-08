package loanservice.negative;

import api.models.DeleteOrderRequest;
import api.steps.LoanServiceSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DeleteOrderNegativeTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @ParameterizedTest
    @CsvSource({
            "123456, 720a4b3f-e8d6-4896-b854-4aa5c1946756",
            "233568957, 7275fe6b-b5b4-49fb-9ddc-4c90121776dc"
    })
    void deleteOrderInvalidParamsTest(Long userId, String orderId) {
        DeleteOrderRequest deleteOrderRequest = new DeleteOrderRequest(userId, orderId);
        loanServiceSteps.deleteOrder(deleteOrderRequest)
                .responseStatusShouldBeEqualTo(400)
                .deleteOrderShouldBeFailed();
    }

    @Test
    void deleteOrderEmptyTest() {
        Long userId = null;
        String orderId = null;
        DeleteOrderRequest deleteOrderRequest = new DeleteOrderRequest(userId, orderId);
        loanServiceSteps.deleteOrder(deleteOrderRequest)
                .responseStatusShouldBeEqualTo(400)
                .deleteOrderShouldBeFailed();
    }
}
