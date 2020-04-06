package com;

import java.sql.*;

public class ArtistController {
    private final Connection con;

    public ArtistController(Connection con) {
        this.con = con;
    }

    public void create(String name, String country) throws SQLException {
        String sql = "insert into artists(id,name,country) values(1,'" + name + "','" + country + "')";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
    }

    public void findByName(String name) throws SQLException {
        ResultSet rs;
        String sql = "select * from artists where name='" + name + "'";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    }
}
