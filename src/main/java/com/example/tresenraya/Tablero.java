package com.example.tresenraya;

public class Tablero {
    private Ficha[][] casillas;
    private static final int TAMANIO = 3;
    
    /**
     * Constructor que inicializa el tablero con casillas vacías
     */
    public Tablero() {
        casillas = new Ficha[TAMANIO][TAMANIO];
        // Inicializar todas las casillas como vacías
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                casillas[i][j] = Ficha.VACIA;
            }
        }
    }
    
    /**
     * Coloca una ficha en la posición especificada
     * @param x Coordenada X (0-2)
     * @param y Coordenada Y (0-2)
     * @param ficha Tipo de ficha a colocar
     * @throws IllegalArgumentException si la posición está fuera del tablero o ya está ocupada
     */
    public void colocarFicha(int x, int y, Ficha ficha) {
        if (x < 0 || x >= TAMANIO) {
            throw new IllegalArgumentException("Posición X fuera del tablero");
        }
        
        if (y < 0 || y >= TAMANIO) {
            throw new IllegalArgumentException("Posición Y fuera del tablero");
        }
        
        // Verificar si la posición ya está ocupada
        if (casillas[x][y] != Ficha.VACIA) {
            throw new IllegalArgumentException("Posición ya ocupada");
        }
        
        casillas[x][y] = ficha;
    }
}