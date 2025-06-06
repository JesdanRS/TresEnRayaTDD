package com.example.tresenraya;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para el Requerimiento 1
 */
public class PIezasTest {
    
    // Este objeto tablero se usará en todas las pruebas
    private Tablero tablero;
    
    @BeforeEach
    void setUp() {
        tablero = new Tablero();
    }

    /**
     * Prueba 1: Cuando una pieza está fuera del eje X, entonces se debe lanzar una excepción
     */
    @Test
    void testPiezaFueraDelEjeX() {
        
        // Verificamos que se lance una excepción cuando X está fuera del tablero
        boolean seHaLanzadoExcepcion = false;
        try {
            tablero.colocarFicha(3, 0, Ficha.X); // El valor 3 está fuera del límite (el tablero es 3x3, con índices 0, 1, 2)
        } catch (IllegalArgumentException e) {
            seHaLanzadoExcepcion = true;
        }
        
        // Si cambiamos esto a assertFalse, la prueba fallará
        assertTrue(seHaLanzadoExcepcion, 
                "Debe lanzarse una excepción cuando la posición X está fuera del tablero");
    }
    
    /**
     * Prueba 1 de Chatgpt
     * 
    @Test
    void testPiezaFueraDelEjeXAlternativo() {
        // Actuar y Verificar
        // IMPORTANTE: Si cambias el 3 por un número entre 0 y 2, la prueba fallará
        // porque esas posiciones sí existen en el tablero
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarFicha(3, 0, Ficha.X); // Coordenada X fuera del límite
        });
        
        // Verificar el mensaje de error
        assertEquals("Posición X fuera del tablero", exception.getMessage());
    }
    */
    
    /**
     * Prueba 2: Cuando una pieza está fuera del eje Y, entonces se debe lanzar una excepción
     */
    @Test
    void testPiezaFueraDelEjeY() {
        // Verificamos que se lance una excepción cuando Y está fuera del tablero
        boolean seHaLanzadoExcepcion = false;
        try {
            tablero.colocarFicha(0, 3, Ficha.X); // El valor 3 está fuera del límite (el tablero es 3x3, con índices 0, 1, 2)
        } catch (IllegalArgumentException e) {
            seHaLanzadoExcepcion = true;
        }
        
        // Si cambiamos esto a assertFalse, la prueba fallará
        assertTrue(seHaLanzadoExcepcion, 
                "Debe lanzarse una excepción cuando la posición Y está fuera del tablero");
    }
    
    /**
     * Prueba 2 de Chatgpt
     * 
    @Test
    void testPiezaFueraDelEjeYAlternativo() {
        // Actuar y Verificar
        // IMPORTANTE: Si cambias el 3 por un número entre 0 y 2, la prueba fallará
        // porque esas posiciones sí existen en el tablero
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarFicha(0, 3, Ficha.X); // Coordenada Y fuera del límite
        });
        
        // Verificar el mensaje de error
        assertEquals("Posición Y fuera del tablero", exception.getMessage());
    }
    */
    
    /**
     * Prueba 3: Cuando una pieza esté en un lugar ya ocupado, se debe lanzar una excepción
     */
    @Test
    void testPiezaEnLugarOcupado() {
        // Primero colocamos una ficha X en la posición (1,1) - el centro del tablero
        tablero.colocarFicha(1, 1, Ficha.X);
        
        // Verificamos que se lance una excepción al intentar colocar en posición ocupada
        boolean seHaLanzadoExcepcion = false;
        try {
            tablero.colocarFicha(1, 1, Ficha.O); 
        } catch (IllegalArgumentException e) {
            seHaLanzadoExcepcion = true;
        }
        
        // Si cambiamos esto a assertFalse, la prueba fallará
        assertTrue(seHaLanzadoExcepcion, 
                "Debe lanzarse una excepción cuando la posición ya está ocupada");
    }
    
    /**
     * Prueba 3 de Chatgpt
     * 
    @Test
    void testPiezaEnLugarOcupadoAlternativo() {
        // Preparar
        tablero.colocarFicha(1, 1, Ficha.X); // Colocamos una ficha en el centro
        
        // Actuar y Verificar
        // IMPORTANTE: Si cambias las coordenadas (1,1) por otras donde no hay ficha,
        // como (0,0) o (2,2), la prueba fallará porque esas posiciones están vacías
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tablero.colocarFicha(1, 1, Ficha.O); // Intentamos colocar otra ficha en el mismo lugar
        });
        
        // Verificar el mensaje de error
        assertEquals("Posición ya ocupada", exception.getMessage());
    }
    */
    
}