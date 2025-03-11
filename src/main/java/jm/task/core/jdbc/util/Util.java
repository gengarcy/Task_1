package jm.task.core.jdbc.util;

import com.mysql.cj.conf.ConnectionUrl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static SessionFactory sessionFactory;

    public void getConnection() throws ClassNotFoundException {
        String userName = "postgres";
        String password = "vosage50";
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName("org.postgresql.Driver");

        try (Connection connection1 = DriverManager.getConnection(connectionUrl, userName, password)) {
            System.out.println("JDBC_connected");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
                configuration.setProperty("hibernate.connection.username", "postgres");
                configuration.setProperty("hibernate.connection.password", "vosage50");
                configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // или "create", "validate" по необходимости
                configuration.setProperty("show_sql", "true"); // для отображения SQL-запросов в консоли

                // Добавьте классы ваших сущностей, например:
                // configuration.addAnnotatedClass(User.class);
                System.out.println("Hibernate_Connected");

                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        return sessionFactory;
    }


}


