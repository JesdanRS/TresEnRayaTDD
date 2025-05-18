package com.example.tresenraya;

public class Turnos {
    // Para hacer fallar el primer test (primerTurnoDebeSerX):
    // Cambiar el valor inicial a Ficha.O
    private Ficha jugadorActual = Ficha.X;

    // Para hacer fallar el segundo test (despuesDeXDebeSerO):
    // Modificar el método para que siempre retorne Ficha.X
    public Ficha obtenerJugadorActual() {
        // Implementación correcta que hace pasar todos los tests:
         Ficha jugadorARetornar = jugadorActual;
        jugadorActual = (jugadorActual == Ficha.X) ? Ficha.O : Ficha.X;
        return jugadorARetornar;

        // Implementación que hace fallar el segundo test:
        // return Ficha.X;

        // Implementación que hace fallar el tercer test:
        // if (jugadorActual == Ficha.O) {
        //     return Ficha.O;
        // }
        // return jugadorActual;
    }
}