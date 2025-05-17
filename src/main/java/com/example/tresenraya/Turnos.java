package com.example.tresenraya;

public class Turnos {
    // Para hacer fallar el primer test (primerTurnoDebeSerX):
    // Cambiar el valor inicial a Ficha.O
    private Ficha jugadorActual = Ficha.X;

    // Para hacer fallar el segundo test (despuesDeXDebeSerO):
    // Modificar el método para que siempre retorne Ficha.X
    public Ficha obtenerJugadorActual() {
        // Implementación que hace fallar el test:
        // return Ficha.X; // Esto hará que siempre retorne X, incluso cuando debería ser O
        
        // Implementación correcta:
        Ficha jugadorARetornar = jugadorActual;
        jugadorActual = (jugadorActual == Ficha.X) ? Ficha.O : Ficha.X;
        //return jugadorARetornar;
        return Ficha.X;
    }
}