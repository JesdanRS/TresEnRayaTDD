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
}