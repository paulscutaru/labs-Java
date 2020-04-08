package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    private final Connection con;

    public AlbumController(Connection con) {
        this.con = con;
    }

    public void create(String name, int artistId, int releaseYear) throws SQLException {
        String sql = "insert into albums(id,name,artist_id,release_year) values(1,'" + name + "'," + artistId + "," + releaseYear + ")";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public void findByArtist(int artistId) throws SQLException {
        ResultSet rs;
        String sql = "select * from albums where artist_id=" + artistId;
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
                     + rs.getString(4));
        }
        stmt.close();
    }
}
