
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class ScoreManager {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "connect4";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String TABLE_NAME = "Connect4Scores";


    public ScoreManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC driver nem található", e);
        }
        createDatabase();
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);

    }


    public void createDatabase() {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createDatabaseQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createTable();
    }

    public void createTable() {
        String createTableQuery = """
                CREATE TABLE IF NOT EXISTS %s (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nev VARCHAR(255) UNIQUE NOT NULL,
                    nyert_meccsek INT DEFAULT 0
                )
                """.formatted(TABLE_NAME);
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void jatekosHozzaad(String name) {
        String query = "INSERT INTO " + TABLE_NAME + " (nev) VALUES (?) ON DUPLICATE KEY UPDATE nev = nev";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nyertMeccsekFrissites(String name) {
        String query = "UPDATE " + TABLE_NAME + " SET nyert_meccsek = nyert_meccsek + 1 WHERE nev = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void scoreKiirat() {
        System.out.println("\n");
        String query = "SELECT nev, nyert_meccsek FROM " + TABLE_NAME + " ORDER BY nyert_meccsek DESC";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            System.out.println("Játékosok és nyert meccseik száma:");
            while (rs.next()) {
                String name = rs.getString("nev");
                int wins = rs.getInt("nyert_meccsek");
                System.out.println(name + " - " + wins + " nyert meccs");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}




