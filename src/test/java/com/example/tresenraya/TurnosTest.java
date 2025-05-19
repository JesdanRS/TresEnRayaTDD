package com.example.tresenraya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;

public class TurnosTest {

    @Test
    void primerTurnoDebeSerX() {
        // 1. Preparación de la prueba
        Turnos turnos = new Turnos();

        // 2. Lógica de la prueba
        Ficha resultadoActual = turnos.obtenerJugadorActual();
        Ficha resultadoEsperado = Ficha.X;

        // 3. Verificación o Assert
        assertEquals(resultadoEsperado, resultadoActual, "El primer turno debe ser X");
    }

    @Test
    void despuesDeXDebeSerO() {
        // 1. Preparación de la prueba
        Turnos turnos = new Turnos();

        // 2. Lógica de la prueba
        turnos.obtenerJugadorActual(); // Primer turno (X)
        Ficha resultadoActual = turnos.obtenerJugadorActual(); // Siguiente turno
        Ficha resultadoEsperado = Ficha.O;

        // 3. Verificación o Assert
        assertEquals(resultadoEsperado, resultadoActual, "Después de X debe ser O");
    }

    @Test
    void despuesDeODebeSerX() {
        // 1. Preparación de la prueba
        Turnos turnos = new Turnos();

        // 2. Lógica de la prueba
        turnos.obtenerJugadorActual(); // Primer turno (X)
        turnos.obtenerJugadorActual(); // Segundo turno (O)
        Ficha resultadoActual = turnos.obtenerJugadorActual(); // Siguiente turno
        Ficha resultadoEsperado = Ficha.X;

        // 3. Verificación o Assert
        assertEquals(resultadoEsperado, resultadoActual, "Después de O debe ser X");
    }

    @Test
    void alternanciaMultipleDebeSerCorrecta() {
        // 1. Preparación de la prueba
        Turnos turnos = new Turnos();

        // 2. Lógica de la prueba
        Ficha[] esperado = {Ficha.X, Ficha.O, Ficha.X, Ficha.O, Ficha.X};
        for (int i = 0; i < esperado.length; i++) {
            Ficha resultado = turnos.obtenerJugadorActual();
            assertEquals(esperado[i], resultado, "En la llamada " + (i+1) + " debe ser " + esperado[i]);
        }
    }
    //--------------------COMPARACION CON IA CHATGPT--------------------
    /*private Turnos turnos;

    @BeforeEach
    void setUp() {
        turnos = new Turnos();
    }

    @Test
    public void testPrimerTurnoEsX() {
        // Al iniciar, el siguiente turno debe ser 'X'
        assertEquals('X', turnos.obtenerSiguienteTurno());
    }

    @Test
    public void testTurnoDespuesDeXEsMas() {
        turnos.registrarTurno('X');
        assertEquals('O', turnos.obtenerSiguienteTurno());
    }

    @Test
    public void testTurnoDespuesDeMasEsX() {
        turnos.registrarTurno('O');
        assertEquals('X', turnos.obtenerSiguienteTurno());
    }

    @Test
    public void testJugadorInvalidoLanzaExcepcion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            turnos.registrarTurno('Z');
        });
        assertEquals("Jugador inválido. Solo se permite 'X' o 'O'", exception.getMessage());
    }*/

    /*
    COMPARACIÓN ENTRE LÓGICA COMENTADA Y ACTUAL:
    - Lógica actual: usa enum Ficha y alternancia automática de turnos, menos flexible, ideal para alternancia fija.
    - Lógica IA: usa char ('X', '+'), registro explícito del turno anterior, permite validaciones y mayor control sobre los turnos.
    - La lógica de IA es más adecuada si se requiere validar el jugador o modificar la secuencia de turnos.
    */
}