package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.*;

import static org.mockito.Mockito.*;

public class ScoreManagerTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private ScoreManager scoreManager;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);

        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        when(mockStatement.executeUpdate(anyString())).thenReturn(1);

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        scoreManager = new ScoreManager();
    }

    @Test
    public void testCreateDatabaseAndTable() throws SQLException {
        Statement mockStatement = mock(Statement.class);
        Connection mockConnection = mock(Connection.class);

        when(mockConnection.createStatement()).thenReturn(mockStatement);

        ScoreManager scoreManager = new ScoreManager();

        scoreManager.createDatabase();

        verify(mockStatement, times(1)).executeUpdate("CREATE DATABASE IF NOT EXISTS connect4");
        verify(mockStatement, times(1)).executeUpdate("CREATE TABLE IF NOT EXISTS Connect4Scores (id INT AUTO_INCREMENT PRIMARY KEY, nev VARCHAR(255) UNIQUE NOT NULL, nyert_meccsek INT DEFAULT 0)");
    }



    @Test
    public void testInsertPlayer() throws SQLException {
        String playerName = "Player1";

        scoreManager.jatekosHozzaad(playerName);

        verify(mockPreparedStatement).setString(1, playerName);
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    public void testUpdateWins() throws SQLException {
        String playerName = "Player1";

        scoreManager.nyertMeccsekFrissites(playerName);
        verify(mockPreparedStatement).setString(1, playerName);
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    public void testScoreKiirat() throws SQLException {
        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("nev")).thenReturn("Player1").thenReturn("Player2");
        when(mockResultSet.getInt("nyert_meccsek")).thenReturn(5).thenReturn(3);

        scoreManager.scoreKiirat();

        verify(mockPreparedStatement).executeQuery("SELECT nev, nyert_meccsek FROM Connect4Scores ORDER BY nyert_meccsek DESC");
        verify(mockResultSet, times(2)).getString("nev");
        verify(mockResultSet, times(2)).getInt("nyert_meccsek");
        verify(mockPreparedStatement).close();
    }
}
