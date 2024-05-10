package api.steps.fixture.loan_service;

import api.entity.credit_app.Tariff;
import api.steps.fixture.CommonFixtureSteps;

import java.util.List;

public class TariffFixtureSteps extends CommonFixtureSteps<Tariff> {

    public TariffFixtureSteps() {
        super(Tariff.class);
    }

    public List<Tariff> getTariffList() {
        return executeInSession(
                session -> {
                    String hql = "SELECT t FROM Tariff t ";

                    return session.createQuery(hql, Tariff.class).list();
        });
    }
}
