package com.example.tresenraya;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}