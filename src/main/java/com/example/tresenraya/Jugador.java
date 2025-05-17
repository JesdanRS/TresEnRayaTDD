package com.example.tresenraya;

public class Jugador {
    private char ficha;
    private String nombre;
    
    public Jugador(String nombre, char ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
    }
    
    public char getFicha() {
        return ficha;
    }
    
    public String getNombre() {
        return nombre;
    }
}
