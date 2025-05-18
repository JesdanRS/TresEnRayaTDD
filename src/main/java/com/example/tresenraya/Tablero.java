package com.example.tresenraya;

/**
 * Representa un tablero de juego Tres en Raya.
 * El tablero es una matriz 3x3 donde se pueden colocar fichas X, O o dejar vacío.
 */
public class Tablero {
    private final Ficha[][] casillas;
    private static final int TAMANIO = 3;
    
    /**
     * Constructor que inicializa el tablero con casillas vacías
     */
    public Tablero() {
        casillas = new Ficha[TAMANIO][TAMANIO];
        inicializarTablero();
    }
    
    /**
     * Inicializa todas las casillas del tablero como vacías
     */
    private void inicializarTablero() {
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
        validarCoordenadas(x, y);
        validarPosicionLibre(x, y);
        casillas[x][y] = ficha;
    }
    
    /**
     * Valida que las coordenadas estén dentro del tablero
     * @param x Coordenada X a validar
     * @param y Coordenada Y a validar
     * @throws IllegalArgumentException si alguna coordenada está fuera del tablero
     */
    private void validarCoordenadas(int x, int y) {
        if (x < 0 || x >= TAMANIO) {
            throw new IllegalArgumentException("Posición X fuera del tablero");
        }
        
        if (y < 0 || y >= TAMANIO) {
            throw new IllegalArgumentException("Posición Y fuera del tablero");
        }
    }
    
    /**
     * Valida que la posición no esté ocupada
     * @param x Coordenada X a validar
     * @param y Coordenada Y a validar
     * @throws IllegalArgumentException si la posición ya está ocupada
     */
    private void validarPosicionLibre(int x, int y) {
        if (casillas[x][y] != Ficha.VACIA) {
            throw new IllegalArgumentException("Posición ya ocupada");
        }
    }
}