package loanservice.positive;

import api.steps.LoanServiceSteps;
import org.junit.jupiter.api.Test;

public class GetTariffsTest {
    private final LoanServiceSteps loanServiceSteps = new LoanServiceSteps();

    @Test
    void getTariffsTest() {
        loanServiceSteps.getTariffs()
                .responseStatusShouldBeEqualTo(200)
                .getTariffsShouldBeSuccessful();
    }
}
