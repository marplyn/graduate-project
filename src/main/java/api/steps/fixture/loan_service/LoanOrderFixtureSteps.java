package api.steps.fixture.loan_service;

import api.entity.credit_app.LoanOrder;;
import api.steps.fixture.CommonFixtureSteps;

public class LoanOrderFixtureSteps extends CommonFixtureSteps<LoanOrder> {

    public LoanOrderFixtureSteps() {
        super(LoanOrder.class);
    }

    public LoanOrder getLoanOrder(String orderId) {
        return executeInSession(
                session -> {
                    String hql = "SELECT l FROM LoanOrder l " +
                                 "WHERE l.orderId =: orderId";

                    return session.createQuery(hql, LoanOrder.class)
                            .setParameter("orderId", orderId)
                            .getSingleResult();
                });
    }
}
