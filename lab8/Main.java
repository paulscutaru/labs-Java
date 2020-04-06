package com;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {

        Database database = Database.getInstance();

        Connection con = database.connent();

        Statement stmt = con.createStatement();

        String tableCreateQuery = "create table artists(" +
                "id number(1) not null," +
                "name varchar(100) not null," +
                "country varchar(100)," +
                "CONSTRAINT artists_pk PRIMARY KEY (id)" +
                ")";
        String tableCreateQuery2 = "create table albums(" +
                "id number(1) not null," +
                "name varchar(100) not null," +
                "artist_id integer," +
                "release_year integer," +
                "CONSTRAINT albums_pk PRIMARY KEY (id)," +
                "CONSTRAINT albums_tk FOREIGN KEY (artist_id) REFERENCES artists ON DELETE CASCADE" +
                ")";

        stmt.execute(tableCreateQuery);
        stmt.execute(tableCreateQuery2);

        ArtistController artistController = new ArtistController(con);
        AlbumController albumController = new AlbumController(con);

        artistController.create("Gigel","Romania");
        artistController.findByName("Gigel");
        
        albumController.create("Manele rock",1,2020);
        albumController.findByArtist(1);
    }
}
