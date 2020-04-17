package com.company;

import java.sql.*;

/**
 * The class ArtistController inserts data into the database (Insert) in the table named artists
 * and retrieves data from the database (Select) from the table named artist
 *
 */
public class ArtistController {
    private static Connection conn = Database.getConnection();

    /**
     * The method create inserts into the table artists the artist/band with the name given in the parameter called name
     * and the country of the artist/band lives in, given by the parameter called country
     *
     * @param name
     * @param country
     * @throws SQLException
     */
    public static void create(String name, String country) throws SQLException {
        try {
            String insert = "INSERT INTO artists (name, country) VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement(insert);
            st.setString(1, name);
            st.setString(2, country);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method findByName retrieves from the database the artist/band with the name given in the parameter called name
     * and shows his name and the country he lives in
     *
     * @param name
     */
    public static void findByName(String name) {
        try {
            String Select = "SELECT * FROM artists WHERE name = ?";
            PreparedStatement st = conn.prepareStatement(Select);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("The band: " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}