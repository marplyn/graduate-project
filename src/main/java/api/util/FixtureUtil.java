package api.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FixtureUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new RuntimeException();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
