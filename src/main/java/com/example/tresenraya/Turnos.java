package com.example.tresenraya;

public class Turnos {
    private Ficha jugadorActual = Ficha.X;

    public Ficha obtenerJugadorActual() {
        Ficha jugadorARetornar = jugadorActual;
        jugadorActual = (jugadorActual == Ficha.X) ? Ficha.O : Ficha.X;
        return jugadorARetornar;
    }
}