package com.example.tresenraya;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Pruebas para la interfaz de consola del juego Tres en Raya
 * 
 * Estas pruebas verifican la interacción del usuario con el juego a través de la consola
 */
public class ConsolaTest {
    
    private Tablero tablero;
    private ByteArrayOutputStream salidaConsola;
    private PrintStream salidaOriginal;
    
    @BeforeEach
    void setUp() {
        // Inicializamos un tablero nuevo para cada prueba
        tablero = new Tablero();
        
        // Configuramos la captura de la salida de consola
        salidaConsola = new ByteArrayOutputStream();
        salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaConsola));
    }
    
    /**
     * Prueba 1: Verificar que el tablero se muestra correctamente
     * 
     * Esta prueba verifica que el método mostrarTablero() genera la representación
     * visual correcta del tablero en la consola
     */
    @Test
    void testMostrarTableroVacio() {
        // Creamos una consola con el tablero vacío
        Consola consola = new Consola(tablero);
        
        // Mostramos el tablero
        consola.mostrarTablero();
        
        // Verificamos que la salida contiene la estructura correcta del tablero vacío
        String salida = salidaConsola.toString();
        assertTrue(salida.contains("-------------"));
        assertTrue(salida.contains("|   |   |   |"));
        
        // Verificamos que hay 4 líneas horizontales (arriba, medio, medio, abajo)
        int contadorLineas = contarOcurrencias(salida, "-------------");
        assertEquals(4, contadorLineas, "El tablero debe tener 4 líneas horizontales");
        
        // Restauramos la salida estándar
        System.setOut(salidaOriginal);
    }
    
   
    
    /**
     * Método auxiliar para contar ocurrencias de una subcadena en una cadena
     */
    private int contarOcurrencias(String texto, String buscar) {
        int contador = 0;
        int indice = 0;
        while ((indice = texto.indexOf(buscar, indice)) != -1) {
            contador++;
            indice += buscar.length();
        }
        return contador;
    }
}