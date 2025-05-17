package com.example.tresenraya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para el Requerimiento 1:
 * Una pieza puede estar colocada en un espacio de un tablero 3x3
 */
public class PIezasTest {

    /**
     * Prueba 1: Cuando una pieza está fuera del eje X, entonces se debe lanzar una excepción
     */
    @Test
    void testPiezaFueraDelEjeX() {
        // Arrange
        Tablero tablero = new Tablero();
        
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarFicha(3, 0, Ficha.X); //Para fallar se cambia el valor de X a 2
        });
        
        String mensajeEsperado = "Posición X fuera del tablero";
        String mensajeActual = exception.getMessage();
        
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
    
    /**
     * Prueba 2: Cuando una pieza está fuera del eje Y, entonces se debe lanzar una excepción
     */
    @Test
    void testPiezaFueraDelEjeY() {
        // Arrange
        Tablero tablero = new Tablero();
        
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarFicha(0, 3, Ficha.X); //Para fallar se cambia el valor de X a 2
        });
        
        String mensajeEsperado = "Posición Y fuera del tablero";
        String mensajeActual = exception.getMessage();
        
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
    
    /**
     * Prueba 3: Cuando una pieza esté en un lugar ya ocupado, se debe lanzar una excepción
     */
    @Test
    void testPiezaEnLugarOcupado() {
        // Arrange
        Tablero tablero = new Tablero();
        tablero.colocarFicha(1, 1, Ficha.X); // Primero colocamos una ficha
        
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarFicha(1, 1, Ficha.O); // Para hacer fallar el test, se puede modificar las coordenadas a (0, 0)
        });
        
        String mensajeEsperado = "Posición ya ocupada";
        String mensajeActual = exception.getMessage();
        
        assertTrue(mensajeActual.contains(mensajeEsperado));
    }
}