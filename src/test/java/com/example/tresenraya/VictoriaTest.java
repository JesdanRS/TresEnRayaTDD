package com.example.tresenraya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VictoriaTest {
        
    @Test
    void testNoHayGanadorSiNoSeCumpleCondicionVictoria() {
        Tablero tablero = new Tablero();
        // Simular algunas jugadas sin victoria
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(1, 1, 'O');
        tablero.colocarFicha(0, 1, 'X');

        assertFalse(tablero.hayGanador());
    }

    @Test
    void testJugadorGanaConLineaHorizontal() {
        Tablero tablero = new Tablero();
        // Simular una victoria horizontal para 'X'
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(0, 1, 'X');
        tablero.colocarFicha(0, 2, 'X');

        assertTrue(tablero.hayGanador());
    }

    @Test
    void testJugadorGanaConLineaVertical() {
        Tablero tablero = new Tablero();
        // Simular una victoria vertical para 'X'
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(1, 0, 'X');
        tablero.colocarFicha(2, 0, 'X');

        assertTrue(tablero.hayGanador());
    }

    @Test
    void testJugadorGanaConLineaDiagonal() {
        Tablero tablero = new Tablero();
        // Simular una victoria diagonal para 'X' (ejemplo: de arriba izquierda a abajo derecha)
        tablero.colocarFicha(0, 0, 'X');
        tablero.colocarFicha(1, 1, 'X');
        tablero.colocarFicha(1, 2, 'X');

        assertTrue(tablero.hayGanador());
    }
}
