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
     * Prueba 2: Verificar que se puede ingresar coordenadas correctamente
     * 
     * Esta prueba simula la entrada del usuario y verifica que el método
     * solicitarMovimiento() interpreta correctamente las coordenadas
     */
    @Test
    void testSolicitarMovimientoValido() {
        // Simulamos la entrada del usuario "1,2"
        String entradaSimulada = "1,2\n";
        ByteArrayInputStream entradaConsola = new ByteArrayInputStream(entradaSimulada.getBytes());
        System.setIn(entradaConsola);
        
        // Creamos la consola con la entrada simulada
        Consola consola = new Consola(tablero);
        
        // Solicitamos el movimiento
        int[] coordenadas = consola.solicitarMovimiento();
        
        // Verificamos que las coordenadas son las esperadas
        assertEquals(1, coordenadas[0], "La coordenada X debe ser 1");
        assertEquals(2, coordenadas[1], "La coordenada Y debe ser 2");
        
        // Restauramos la entrada estándar
        System.setIn(System.in);
        System.setOut(salidaOriginal);
    }
    
   /**
     * Prueba 3: Verificar que se manejan correctamente las entradas inválidas
     * 
     * Esta prueba verifica que el método solicitarMovimiento() lanza una excepción
     * cuando se ingresan coordenadas en formato incorrecto
     */
    @Test
    void testSolicitarMovimientoInvalido() {
        // Simulamos una entrada inválida "x,y"
        String entradaSimulada = "x,y\n";
        ByteArrayInputStream entradaConsola = new ByteArrayInputStream(entradaSimulada.getBytes());
        System.setIn(entradaConsola);
        
        // Creamos la consola con la entrada simulada
        Consola consola = new Consola(tablero);
        
        // Verificamos que se lanza la excepción esperada
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consola.solicitarMovimiento();
        });
        
        // Verificamos el mensaje de error
        assertEquals("Las coordenadas deben ser números", exception.getMessage());
        
        // Restauramos la entrada estándar
        System.setIn(System.in);
        System.setOut(salidaOriginal);}
    
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