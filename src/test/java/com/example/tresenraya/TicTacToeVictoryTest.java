package com.example.tresenraya;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TicTacToeVictoryTest {
    private int[][] tablero;
    private int tamanoTablero = 3; // Ejemplo con un tablero de 3x3

    @BeforeEach
    void setUp() {
        tablero = new int[tamanoTablero][tamanoTablero];
    }

    @Test
    void testNoHayGanadorCuandoNoSeCumpleLaCondicion() {
        // Actuar
        // Colocar algunas fichas en el tablero, por ejemplo, en la diagonal
        tablero[0][0] = 1; // Jugador 1
        tablero[1][1] = 1; // Jugador 1
        tablero[2][2] = 1; // Jugador 1

        // Verificar
        assertFalse(hayGanador(tablero, 2), "Debería regresar false si no hay ganador");
        assertFalse(hayGanador(tablero, 1), "Debería regresar false si no hay ganador");
    }

    @Test
    void testJugadorGanaConLineaHorizontal() {
        // Actuar: Llenar una fila completa con las fichas del jugador 1
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[0][i] = 1; // Jugador 1 ocupa toda la primera fila
        }

        // Verificar
        assertTrue(hayGanador(tablero, 2), "El jugador 1 debería ganar con una fila horizontal completa");
        assertFalse(hayGanador(tablero, 1), "El jugador 2 no debería ganar");
    }

    @Test
    void testJugadorGanaConLineaVertical() {
        // Actuar: Llenar una columna completa con las fichas del jugador 1
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][0] = 1; // Jugador 1 ocupa toda la primera columna
        }

        // Verificar
        assertTrue(hayGanador(tablero, 1), "El jugador 1 debería ganar con una columna vertical completa");
        assertFalse(hayGanador(tablero, 2), "El jugador 2 no debería ganar");
    }

    
    @Test
    void testJugadorGanaConDiagonalPrincipal() {
        // Actuar: Llenar la diagonal principal con las fichas del jugador 1
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][i] = 1; // Jugador 1 ocupa toda la diagonal principal
        }

        // Verificar
        assertTrue(hayGanador(tablero, 1), "El jugador 1 debería ganar con la diagonal principal completa");
        assertFalse(hayGanador(tablero, 2), "El jugador 2 no debería ganar");
    }

    @Test
    void testJugadorGanaConDiagonalSecundaria() {
        // Actuar: Llenar la diagonal secundaria con las fichas del jugador 1
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][tamanoTablero - 1 - i] = 1; // Jugador 1 ocupa toda la diagonal secundaria
        }

        // Verificar
        assertTrue(hayGanador(tablero, 1), "El jugador 1 debería ganar con la diagonal secundaria completa");
        assertFalse(hayGanador(tablero, 2), "El jugador 2 no debería ganar");
    }

    private boolean hayGanador(int[][] tablero, int jugador) {
        int tamano = tablero.length;

        // Verificar filas y columnas
        for (int i = 0; i < tamano; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }

        // Verificar diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }

        return false;
    }
}