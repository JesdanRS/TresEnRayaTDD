package com.example.tresenraya;

public class Tablero {
    private char[][] matriz;
    private static final int TAMANIO = 3;
    
    public Tablero() {
        matriz = new char[TAMANIO][TAMANIO];
        // Inicializar el tablero con espacios vacíos
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                matriz[i][j] = ' ';
            }
        }
    }
    
    public void colocarFicha(int fila, int columna, char ficha) {
        if (fila >= 0 && fila < TAMANIO && columna >= 0 && columna < TAMANIO) {
            matriz[fila][columna] = ficha;
        }
    }
    
    public boolean hayGanador() {
        // Implementación mínima para que las pruebas fallen
        return false;
    }
}