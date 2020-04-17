package com.company;

import java.sql.*;

/**
 * The singleton class Database creates the connection to the database
 */
public class Database {
    private static Database instance;
    private static Connection con;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/MusicAlbums";
    static final String USER = "username";
    static final String PASS = "password";

    /**
     * Database() is the private constructor
     *
     * @throws SQLException
     */
    private Database() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            this.con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }
        return instance;
    }


}