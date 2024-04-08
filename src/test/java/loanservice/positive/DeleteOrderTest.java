package loanservice.positive;

import api.models.DeleteOrderRequest;
import api.steps.LoanServiceSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.Long;


public class DeleteOrderTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();


    @ParameterizedTest
    @CsvSource({
            "453156, 6be658df-8dc9-4846-85f0-bc72d1c13105",
            "90653785, f5ca3f42-0f57-4552-aa40-b6a314d47943"
    })
    void deleteOrderTest(Long userId, String orderId) {
        DeleteOrderRequest deleteOrderRequest = new DeleteOrderRequest(userId, orderId);
        loanServiceSteps.deleteOrder(deleteOrderRequest)
                .responseStatusShouldBeEqualTo(200);
    }
}
