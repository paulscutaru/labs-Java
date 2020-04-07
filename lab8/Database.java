package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database single_instance = null;

    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    public Connection connent() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "dba", "sql");
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
        return con;
    }
    public void disconnect(Connection con) throws SQLException {
        con.close();
    }
}
