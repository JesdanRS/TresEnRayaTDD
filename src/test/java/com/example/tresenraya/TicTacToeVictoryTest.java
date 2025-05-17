package com.example.tresenraya;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeVictoryTest {
    // Stub de la función checkVictory para la fase Red
    private String checkVictory(char[][] board) {
        return "None";
    }

    @Test
    void sinGanadorCuandoNoHayLineaCompleta() {
        // Arrange
        char[][] board = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'O'}
        };
        // Act
        String result = checkVictory(board);
        // Assert
        assertEquals("X", result);
    }

    @Test
    void jugadorGanaConLineaHorizontal() {
        // Arrange
        char[][] board = {
            {'X', 'X', 'X'},
            {'O', ' ', 'O'},
            {' ', 'O', 'X'}
        };
        // Act
        String result = checkVictory(board);
        // Assert
        assertEquals("X", result);
    }

    @Test
    void jugadorGanaConLineaVertical() {
        // Arrange
        char[][] board = {
            {'O', 'X', ' '},
            {'O', 'X', ' '},
            {'O', 'X', 'X'}
        };
        // Act
        String result = checkVictory(board);
        // Assert
        assertEquals("O", result);
    }

    @Test
    void jugadorGanaConLineaDiagonal() {
        // Arrange
        char[][] board = {
            {'X', 'O', 'O'},
            {' ', 'X', ' '},
            {'O', ' ', 'X'}
        };
        // Act
        String result = checkVictory(board);
        // Assert
        assertEquals("X", result);
    }
}
