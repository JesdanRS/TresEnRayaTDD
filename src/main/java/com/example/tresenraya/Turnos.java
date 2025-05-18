package com.example.tresenraya;

public class Turnos {
    // Para hacer fallar el primer test (primerTurnoDebeSerX):
    // Cambiar el valor inicial a Ficha.O
    private Ficha jugadorActual = Ficha.X;

    public Ficha obtenerJugadorActual() {
        // Implementación correcta que hace pasar todos los tests:
        Ficha jugadorARetornar = jugadorActual;
        alternarJugador();
        return jugadorARetornar;

        // Implementación que hace fallar el segundo test:
        // return Ficha.X;
        //AL cambiar el return, igual fallará la alternancia de turnos.(el ultimo test)
        // Implementación que hace fallar el tercer test:
        /*if (jugadorActual == Ficha.X) {
            jugadorActual = Ficha.O;
        }
        return jugadorActual;*/
    }

    private void alternarJugador() {
        jugadorActual = (jugadorActual == Ficha.X) ? Ficha.O : Ficha.X;
    }
}