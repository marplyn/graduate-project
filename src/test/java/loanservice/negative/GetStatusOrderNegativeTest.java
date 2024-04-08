package loanservice.negative;

import api.steps.LoanServiceSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GetStatusOrderNegativeTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @ParameterizedTest
    @ValueSource(strings = {"84fa0932-3a29-4b1e-885e-11546cb59708", "739926c1-09e9-492b-ab3d-08e39ff6a5a4"})
    void getStatusOrderInvalidParamsTest(String orderId) {
        loanServiceSteps.getStatusOrder(orderId)
                .responseStatusShouldBeEqualTo(400)
                .getStatusOrderShouldBeFailed();
    }
}
