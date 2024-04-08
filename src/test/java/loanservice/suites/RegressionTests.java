package loanservice.suites;

import loanservice.*;
import loanservice.negative.CreateOrderNegativeTest;
import loanservice.negative.DeleteOrderNegativeTest;
import loanservice.negative.GetStatusOrderNegativeTest;
import loanservice.positive.CreateOrderTest;
import loanservice.positive.DeleteOrderTest;
import loanservice.positive.GetStatusOrderTest;
import loanservice.positive.GetTariffsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CreateOrderTest.class,
        DeleteOrderTest.class,
        GetStatusOrderTest.class,
        GetTariffsTest.class,
        CreateOrderNegativeTest.class,
        DeleteOrderNegativeTest.class,
        GetStatusOrderNegativeTest.class,
        E2ETests.class
})
public class RegressionTests {
}
