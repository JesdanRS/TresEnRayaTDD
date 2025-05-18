package com.example.tresenraya;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TicTacToeVictoryTest  {

    private int[][] tablero;
    private int tamanoTablero = 3;
    private JuegoLogica juegoLogica;

    @BeforeEach
    void setUp() {
        tablero = new int[tamanoTablero][tamanoTablero];
        juegoLogica = new JuegoLogica();
    }

    @Test
    void testNoHayGanadorCuandoNoSeCumpleLaCondicion() {
        // Actuar
        tablero[0][0] = 1; // Jugador 1
        tablero[1][1] = 1; // Jugador 1

        // Verificar
        assertFalse(juegoLogica.hayGanador(tablero, 1), "Debería regresar false si no hay ganador");
        assertFalse(juegoLogica.hayGanador(tablero, 2), "Debería regresar false si no hay ganador");
    }

    @Test
    void testJugadorGanaConLineaHorizontal() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[0][i] = 1; // Jugador 1 ocupa toda la primera fila
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    @Test
    void testJugadorGanaConLineaVertical() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][0] = 1; // Jugador 1 ocupa toda la primera columna
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    @Test
    void testJugadorGanaConDiagonalPrincipal() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][i] = 1; // Jugador 1 ocupa toda la diagonal principal
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    @Test
    void testJugadorGanaConDiagonalSecundaria() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][tamanoTablero - 1 - i] = 1; // Jugador 1 ocupa toda la diagonal secundaria
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    /* 
    ! CODIGO MINIMO PARA QUE PASEN LAS PRUEBAS
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
    */
}