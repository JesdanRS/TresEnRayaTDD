package com.example.tresenraya;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TicTacToeVictoryTest  {

    private int[][] tablero;
    private int tamanoTablero = 3;
    private JuegoLogica juegoLogica;

    @BeforeEach
    void setUp() {
        tablero = new int[tamanoTablero][tamanoTablero];
        juegoLogica = new JuegoLogica();
    }

    @Test
    void testNoHayGanadorCuandoNoSeCumpleLaCondicion() {
        // Actuar
        tablero[0][0] = 1; // Jugador 1
        tablero[1][1] = 1; // Jugador 1

        // Verificar
        assertFalse(juegoLogica.hayGanador(tablero, 1), "Debería regresar false si no hay ganador");
        assertFalse(juegoLogica.hayGanador(tablero, 2), "Debería regresar false si no hay ganador");
    }


    // * Respuesta de ChatGPT
//     @Test
// void sinGanador_conTableroParcialmenteOcupado() {
//     // Given: un tablero con dos marcas del Jugador 1 sin formar línea ganadora
//     tablero[0][0] = 1;
//     tablero[1][1] = 1;

//     // When: consulto si alguno de los jugadores ha ganado
//     boolean ganaJugador1 = juegoLogica.hayGanador(tablero, 2);
//     boolean ganaJugador2 = juegoLogica.hayGanador(tablero, 1);

//     // Then: ninguno debe resultar ganador
//     assertAll(
//         () -> assertFalse(ganaJugador1, "Jugador 1 no debería ser declarado ganador"),
//         () -> assertFalse(ganaJugador2, "Jugador 2 no debería ser declarado ganador")
//     );
// }


    @Test
    void testJugadorGanaConLineaHorizontal() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[0][i] = 1; // Jugador 1 ocupa toda la primera fila
        }
        assertTrue(juegoLogica.hayGanador(tablero, 2));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    // @Test
    // public void testVictoriaHorizontal() {
    //     // Arrange
    //     Tablero tablero = new Tablero(3, 3); // Tablero de 3x3
    //     Jugador jugador = new Jugador("X");
        
    //     // Act - Colocar piezas del jugador en una fila horizontal completa
    //     tablero.colocarPieza(0, 0, jugador); // Primera fila, primera columna
    //     tablero.colocarPieza(0, 1, jugador); // Primera fila, segunda columna
    //     tablero.colocarPieza(0, 2, jugador); // Primera fila, tercera columna
        
    //     // Assert - Verificar que el jugador ha ganado
    //     assertTrue("El jugador debería ganar con una línea horizontal completa", 
    //                tablero.verificarVictoria(jugador));
    // }

    @Test
    void testJugadorGanaConLineaVertical() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][0] = 1; // Jugador 1 ocupa toda la primera columna
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    // public void testVictoriaVertical() {
    //     // Arrange
    //     Tablero tablero = new Tablero(3, 3); // Tablero de 3x3
    //     Jugador jugador = new Jugador("X");
        
    //     // Act - Colocar piezas del jugador en una columna vertical completa
    //     tablero.colocarPieza(0, 0, jugador); // Primera fila, primera columna
    //     tablero.colocarPieza(1, 0, jugador); // Segunda fila, primera columna
    //     tablero.colocarPieza(2, 0, jugador); // Tercera fila, primera columna
        
    //     // Assert - Verificar que el jugador ha ganado
    //     assertTrue("El jugador debería ganar con una línea vertical completa", 
    //                tablero.verificarVictoria(jugador));
    // }

    @Test
    void testJugadorGanaConDiagonalPrincipal() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][i] = 1; // Jugador 1 ocupa toda la diagonal principal
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    @Test
    void testJugadorGanaConDiagonalSecundaria() {
        for (int i = 0; i < tamanoTablero; i++) {
            tablero[i][tamanoTablero - 1 - i] = 1; // Jugador 1 ocupa toda la diagonal secundaria
        }
        assertTrue(juegoLogica.hayGanador(tablero, 1));
        assertFalse(juegoLogica.hayGanador(tablero, 2));
    }

    // @Test
    // public void testVictoriaDiagonalPrincipal() {
    //     // Arrange
    //     Tablero tablero = new Tablero(3, 3); // Tablero de 3x3
    //     Jugador jugador = new Jugador("X");
        
    //     // Act - Colocar piezas del jugador en la diagonal principal
    //     tablero.colocarPieza(0, 0, jugador); // Esquina superior izquierda
    //     tablero.colocarPieza(1, 1, jugador); // Centro
    //     tablero.colocarPieza(2, 2, jugador); // Esquina inferior derecha
        
    //     // Assert - Verificar que el jugador ha ganado
    //     assertTrue("El jugador debería ganar con una diagonal principal completa", 
    //                tablero.verificarVictoria(jugador));
    // }
    
    // @Test
    // public void testVictoriaDiagonalSecundaria() {
    //     // Arrange
    //     Tablero tablero = new Tablero(3, 3);
    //     Jugador jugador = new Jugador("X");
        
    //     // Act - Colocar piezas del jugador en la diagonal secundaria
    //     tablero.colocarPieza(0, 2, jugador); // Esquina superior derecha
    //     tablero.colocarPieza(1, 1, jugador); // Centro
    //     tablero.colocarPieza(2, 0, jugador); // Esquina inferior izquierda
        
    //     // Assert - Verificar que el jugador ha ganado
    //     assertTrue("El jugador debería ganar con una diagonal secundaria completa", 
    //                tablero.verificarVictoria(jugador));
    // }

}