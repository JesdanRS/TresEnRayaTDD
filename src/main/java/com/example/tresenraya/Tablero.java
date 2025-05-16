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
     * @throws IllegalArgumentException si la posición está fuera del tablero
     */
    public void colocarFicha(int x, int y, Ficha ficha) {
        if (x < 0 || x >= TAMANIO) {
            throw new IllegalArgumentException("Posición X fuera del tablero");
        }
        
        // Aquí se implementarán las demás validaciones en futuras iteraciones
        
        casillas[x][y] = ficha;
    }
}