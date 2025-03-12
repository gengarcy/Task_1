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
}


