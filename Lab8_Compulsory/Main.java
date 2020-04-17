package com.company;
import java.sql.*;

/**
 * The class Main uses the class Database to create the connection and classes AlbumController and ArtistController to
 * add and retrieve data from the database
 *
 * After the database is created, the privileges are granted  and the user is created
 *
 */
public class Main {

    /**
     * The method main creates the connection, the database, the user and the tables and also inserts and retrieves data from them
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            Database dataBase = Database.getInstance();
            conn = dataBase.getConnection();
            System.out.println("Connected");

            st = conn.createStatement();
            String sql = "CREATE DATABASE  MusicAlbums";
            String create_user = "grant all privileges on mydb.* to 'dba'@'localhost' identified by 'sql';";
            st.executeUpdate(create_user);
            System.out.println("User created successfully");
            createTable(st);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * The method getStringArtists returns the string needed the create the table artists in sql
     *
     * @return
     */
    private static String getStringArtists()
    {
        return "create table artists(" +
                "    id integer not null auto_increment," +
                "    name varchar(100) not null," +
                "    country varchar(100)," +
                "    primary key (id)" +
                ");";
    }
    /**
     * The method getStringAlbums returns the string needed the create the table albums in sql
     *
     * @return
     */
    private static String getStringAlbums()
    {
        return "create table albums(" +
                "id integer not null auto_increment," +
                "name varchar(100) not null," +
                "artist_id integer not null references artists on delete restrict," +
                "release_year integer," +
                "primary key (id)" +
                ");";
    }

    /**
     * The method createTable creates the tables artists and albums, inserts data into those table
     * and retrieves data from those tables
     *
     * @param st
     * @throws SQLException
     */
    private static void createTable(Statement st) throws SQLException {
        String artists = getStringArtists();
        String albums = getStringAlbums();
        st.executeUpdate("DROP TABLE artists;");
        st.executeUpdate(artists);
        System.out.println("Artists table created successfully");
        st.executeUpdate("DROP TABLE albums;");
        st.executeUpdate(albums);
        System.out.println("Albums table created successfully");
        ArtistController.create("The Fratellis", "Scotland");
        ArtistController.create("Rainbow Kitten Surprise", "US");
        AlbumController.create("RKS", 2, 2015);
        AlbumController.create("Seven + Mary", 2, 2013);
        AlbumController.create("Here we stand", 1, 2008);
        AlbumController.create("We need medicine", 1, 2013);
        AlbumController.create("In your own sweet time", 1, 2018);
        AlbumController.create("Half drunk under a full moon", 1, 2020);
        ArtistController.findByName("Rainbow Kitten Surprise");
        AlbumController.findByArtist(1);
    }

}