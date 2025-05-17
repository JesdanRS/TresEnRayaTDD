package com.example.tresenraya;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeVictoryTest {
    // Stub de la función checkVictory para la fase Red
    private String checkVictory(char[][] board) {
        // Verificar líneas horizontales
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return String.valueOf(board[i][0]);
            }
        }

        // Verificar líneas verticales
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return String.valueOf(board[0][j]);
            }
        }

        // Verificar diagonal principal
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return String.valueOf(board[0][0]);
        }

        // Verificar diagonal secundaria
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return String.valueOf(board[0][2]);
        }

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
        assertEquals("None", result);
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
