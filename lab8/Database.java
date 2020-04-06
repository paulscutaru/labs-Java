package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Database single_instance = null;

    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    public Connection connent() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "student", "STUDENT");
    }
}
