package com.example.tresenraya;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para el Requerimiento 1:
 * Una pieza puede estar colocada en un espacio de un tablero 3x3
 * 
 * Estas pruebas verifican que no se puedan colocar fichas fuera del tablero
 * o en posiciones ya ocupadas.
 */
public class PIezasTest {
    
    // Este objeto tablero se usará en todas las pruebas
    private Tablero tablero;
    
    @BeforeEach
    void setUp() {
        // Antes de cada prueba, creamos un tablero nuevo y vacío
        // Esto es como limpiar la pizarra antes de empezar cada ejercicio
        tablero = new Tablero();
    }

    /**
     * Prueba 1: Cuando una pieza está fuera del eje X, entonces se debe lanzar una excepción
     * 
     * Esta prueba verifica que no se pueda colocar una ficha fuera del límite horizontal del tablero
     */
    @Test
    void testPiezaFueraDelEjeX() {
        // Intentamos colocar una ficha en una posición que no existe (fuera del tablero)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // IMPORTANTE: Si cambias el 3 por un número entre 0 y 2, la prueba fallará
            // porque esas posiciones sí existen en el tablero
            tablero.colocarFicha(3, 0, Ficha.X); // El valor 3 está fuera del límite (el tablero es 3x3, con índices 0, 1, 2)
        });
        
        // Comprobamos que el mensaje de error sea el correcto
        String mensajeEsperado = "Posición X fuera del tablero";
        String mensajeActual = exception.getMessage();
        
        // Verificamos que el mensaje contenga el texto que esperamos
        assertTrue(mensajeActual.contains(mensajeEsperado), 
                "El programa debe avisar claramente que la posición X está fuera del tablero");
    }
    
    /**
     * Prueba 2: Cuando una pieza está fuera del eje Y, entonces se debe lanzar una excepción
     * 
     * Esta prueba verifica que no se pueda colocar una ficha fuera del límite vertical del tablero
     */
    @Test
    void testPiezaFueraDelEjeY() {
        // Intentamos colocar una ficha en una posición que no existe (fuera del tablero)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // IMPORTANTE: Si cambias el 3 por un número entre 0 y 2, la prueba fallará
            // porque esas posiciones sí existen en el tablero
            tablero.colocarFicha(0, 3, Ficha.X); // El valor 3 está fuera del límite (el tablero es 3x3, con índices 0, 1, 2)
        });
        
        // Comprobamos que el mensaje de error sea el correcto
        String mensajeEsperado = "Posición Y fuera del tablero";
        String mensajeActual = exception.getMessage();
        
        // Verificamos que el mensaje contenga el texto que esperamos
        assertTrue(mensajeActual.contains(mensajeEsperado), 
                "El programa debe avisar claramente que la posición Y está fuera del tablero");
    }
    
    /**
     * Prueba 3: Cuando una pieza esté en un lugar ya ocupado, se debe lanzar una excepción
     * 
     * Esta prueba verifica que no se pueda colocar una ficha donde ya hay otra ficha
     */
    @Test
    void testPiezaEnLugarOcupado() {
        // Primero colocamos una ficha X en la posición (1,1) - el centro del tablero
        tablero.colocarFicha(1, 1, Ficha.X);
        
        // Ahora intentamos colocar otra ficha (O) en la misma posición
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // IMPORTANTE: Si cambias las coordenadas (1,1) por otras donde no hay ficha,
            // como (0,0) o (2,2), la prueba fallará porque esas posiciones están vacías
            tablero.colocarFicha(1, 1, Ficha.O); // Intentamos poner una O donde ya hay una X
        });
        
        // Comprobamos que el mensaje de error sea el correcto
        String mensajeEsperado = "Posición ya ocupada";
        String mensajeActual = exception.getMessage();
        
        // Verificamos que el mensaje contenga el texto que esperamos
        assertTrue(mensajeActual.contains(mensajeEsperado), 
                "El programa debe avisar claramente que ya hay una ficha en esa posición");
    }
}