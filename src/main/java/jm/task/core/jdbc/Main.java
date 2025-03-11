package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;



public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        try {
            util.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Иван", "Иванов", (byte) 30);
        System.out.println("User с именем – Иван добавлен в базу данных");

        userService.saveUser("Петр", "Петров", (byte) 25);
        System.out.println("User с именем – Петр добавлен в базу данных");

        userService.saveUser("Светлана", "Сидорова", (byte) 28);
        System.out.println("User с именем – Светлана добавлен в базу данных");

        userService.saveUser("Алексей", "Алексеев", (byte) 35);
        System.out.println("User с именем – Алексей добавлен в базу данных");


        System.out.println("Список всех пользователей:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }


        userService.cleanUsersTable();

        userService.dropUsersTable();
















    }

}
