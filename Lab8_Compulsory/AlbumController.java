package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class AlbumController inserts data into the database (Insert) in the table named albums
 * and retrieves data from the database (Select) from the table named albums
 *
 */
public class AlbumController {
    private static Connection conn = Database.getConnection();

    /**
     *
     * The method create inserts into the table albums the album with the name given in the parameter called name
     * the artist of the album, given by the parameter called country
     * and the year the album was released, given by the parameter releaseYear
     *
     * @param name
     * @param artistId
     * @param releaseYear
     * @throws SQLException
     */
    public static void create(String name, int artistId, int releaseYear) throws SQLException {
        try {
            String insert = "INSERT INTO albums (name, artist_id, release_year) VALUES (?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(insert);
            st.setString(1, name);
            st.setInt(2, artistId);
            st.setInt(3, releaseYear);
            st.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    /**
     * The method findByArtist retrieves from the database the albums sang by the artist wtih the id
     * given in the parameter called artistId and shows every album and the year of release
     *
     * @param artistId
     */
    public static void findByArtist(int artistId) {
        try {
            String select = "SELECT * FROM albums WHERE artist_id = ?";
            PreparedStatement st = conn.prepareStatement(select);
            st.setInt(1, artistId);
            ResultSet rs = st.executeQuery();
            System.out.println("The albums:  ");
            while (rs.next()) {
                System.out.println(" - " + rs.getString(2) + " (" + rs.getString(4) + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}