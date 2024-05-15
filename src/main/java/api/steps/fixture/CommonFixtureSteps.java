package api.steps.fixture;

import org.hibernate.Session;

import java.util.function.Function;

public class CommonFixtureSteps<T> {

    public CommonFixtureSteps(Class<T> entity) {
    }

    protected <R> R executeInSession(Function<Session, R> operation) {
        try (Session session = FixtureUtil.getSessionFactory().openSession()) {
            return operation.apply(session);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
