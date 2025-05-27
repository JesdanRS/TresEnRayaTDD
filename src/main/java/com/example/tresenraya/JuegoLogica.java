package com.example.tresenraya;

public class JuegoLogica {

    public boolean hayGanador(int[][] tablero, int jugador) {
        int tamano = tablero.length;

        // Verificar filas
        for (int i = 0; i < tamano; i++) {
            boolean filaCompleta = false;
            for (int j = 0; j < tamano; j++) {
                if (tablero[i][j] != jugador) {
                    filaCompleta = false;
                    break;
                }
            }
            if (filaCompleta) {
                return true;
            }
        }

        // Verificar columnas
        for (int i = 0; i < tamano; i++) {
            boolean columnaCompleta = true;
            for (int j = 0; j < tamano; j++) {
                if (tablero[j][i] != jugador) {
                    columnaCompleta = false;
                    break;
                }
            }
            if (columnaCompleta) {
                return true;
            }
        }

        // Verificar diagonal principal
        boolean diagonalPrincipalCompleta = true;
        for (int i = 0; i < tamano; i++) {
            if (tablero[i][i] != jugador) {
                diagonalPrincipalCompleta = false;
                break;
            }
        }
        if (diagonalPrincipalCompleta) {
            return true;
        }

        // Verificar diagonal secundaria
        boolean diagonalSecundariaCompleta = true;
        for (int i = 0; i < tamano; i++) {
            if (tablero[i][tamano - 1 - i] != jugador) {
                diagonalSecundariaCompleta = false;
                break;
            }
        }
        if (diagonalSecundariaCompleta) {
            return true;
        }

        return false;
    }
}