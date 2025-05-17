package com.example.tresenraya;

public class Juego {
    private Ficha[][] tablero;
    private Ficha ganador;
    
    public Juego() {
        // Inicializar tablero 3x3 vacío
        tablero = new Ficha[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = Ficha.VACIA;
            }
        }
        ganador = null;
    }
    
    public void colocarFicha(int fila, int columna, Ficha ficha) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            tablero[fila][columna] = ficha;
        }
    }
    
    public boolean hayGanador() {
        return false;
    }
    
    public Ficha obtenerGanador() {
        return null;
    }
    
}