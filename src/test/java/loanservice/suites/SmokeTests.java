package loanservice.suites;

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
        GetTariffsTest.class
})
public class SmokeTests {

}
