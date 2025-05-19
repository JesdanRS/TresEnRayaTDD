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
        //return Ficha.X;
        //AL cambiar el return, igual fallará la alternancia de turnos.(el ultimo test)
        // Implementación que hace fallar el tercer test:
        /*if (jugadorActual == Ficha.X) {
            jugadorActual = Ficha.O;
        }
        return jugadorActual;*/

    }
        //-------------------COMPARACION CON IA CHATGPT-------------------------------
        /*    private char ultimoTurno;
        
            // Constructor: El juego siempre empieza con 'X'
            public Turnos() {
                this.ultimoTurno = 'O'; //cambiar  a X
            }

    // Para hacer fallar el segundo test: haz que siempre retorne 'X'
    public char obtenerSiguienteTurno() {
        if (ultimoTurno == 'X') {
            return 'O'; // cambiar a X
        } else {
            return 'X'; //cambiar a O
        }
    }

    // Para hacer fallar el test de validación: permite cualquier carácter
    public void registrarTurno(char jugador) {
        if (jugador == 'X' || jugador == 'O') { //cambiar por x o a o etc
            this.ultimoTurno = jugador;
        } else {
            throw new IllegalArgumentException("Jugador inválido. Solo se permite 'X' o 'O'");
        }
    }

    public char getUltimoTurno() {
        return ultimoTurno;
    }*/ 
    //-----------------FIN IA ------------------------------

    private void alternarJugador() {
        jugadorActual = (jugadorActual == Ficha.X) ? Ficha.O : Ficha.X; //Cambiar cualquiera
    }

    // --- Comparación entre lógica comentada y actual ---
    /*
    COMPARACIÓN ENTRE LÓGICA COMENTADA Y ACTUAL:
    - Lógica actual: usa enum Ficha y alternancia automática de turnos, menos flexible, ideal para alternancia fija.
    - Lógica IA: usa char ('X', 'O'), registro explícito del turno anterior, permite validaciones y mayor control sobre los turnos.
    - La lógica de IA es más adecuada si se requiere validar el jugador o modificar la secuencia de turnos.
    */
}