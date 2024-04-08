package loanservice.positive;

import api.steps.LoanServiceSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetStatusOrderTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @ParameterizedTest
    @ValueSource(strings = {"ace41169-c147-4be4-8492-518125aa1c0a", "f5ca3f42-0f57-4552-aa40-b6a314d47943"})
    void getStatusOrderPositive(String orderId) {
        loanServiceSteps.getStatusOrder(orderId)
                .responseStatusShouldBeEqualTo(200)
                .getStatusOrderShouldBeSuccessful();
    }
}
