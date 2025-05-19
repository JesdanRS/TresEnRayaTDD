package com.example.tresenraya;

/**
 * Clase principal que implementa el juego Tres en Raya por consola
 * integrando los componentes: Tablero, Ficha, JuegoLogica, Turnos y Consola.
 */
public class TresEnRaya {
    private final Tablero tablero;
    private final Turnos turnos;
    private final JuegoLogica juegoLogica;
    private final Consola consola;
    private boolean juegoTerminado;
    
    /**
     * Constructor que inicializa todos los componentes del juego
     */
    public TresEnRaya() {
        tablero = new Tablero();
        turnos = new Turnos();
        juegoLogica = new JuegoLogica();
        consola = new Consola(tablero);
        juegoTerminado = false;
    }
    
    /**
     * Inicia el juego y maneja el flujo principal
     */
    public void iniciar() {
        System.out.println("¡Bienvenido a Tres en Raya!");
        System.out.println("El jugador X comienza el juego.");
        
        while (!juegoTerminado) {
            // Mostrar el tablero actual
            consola.mostrarTablero();
            
            // Obtener el jugador actual
            Ficha jugadorActual = turnos.obtenerJugadorActual();
            System.out.println("Turno del jugador: " + jugadorActual);
            
            try {
                // Solicitar movimiento al jugador
                int[] coordenadas = consola.solicitarMovimiento();
                int x = coordenadas[0];
                int y = coordenadas[1];
                
                // Colocar la ficha en el tablero
                tablero.colocarFicha(x, y, jugadorActual);
                
                // Verificar si hay ganador
                if (hayGanador(jugadorActual)) {
                    consola.mostrarTablero();
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                }
                
                // Verificar si hay empate
                if (!juegoTerminado && tableroLleno()) {
                    consola.mostrarTablero();
                    System.out.println("¡El juego ha terminado en empate!");
                    juegoTerminado = true;
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                // Si hay un error, el turno vuelve al mismo jugador
                turnos.obtenerJugadorActual(); // Llamada adicional para restaurar el turno
            }
        }
        
        System.out.println("Fin del juego. ¡Gracias por jugar!");
    }
    
    /**
     * Verifica si hay un ganador en el tablero actual
     * @param jugador El jugador a verificar
     * @return true si el jugador ha ganado, false en caso contrario
     */
    private boolean hayGanador(Ficha jugador) {
        // Convertir el tablero de Ficha a int para usar con JuegoLogica
        int[][] tableroInt = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Ficha ficha = tablero.obtenerFicha(i, j);
                if (ficha == Ficha.X) {
                    tableroInt[i][j] = 1;
                } else if (ficha == Ficha.O) {
                    tableroInt[i][j] = 2;
                } else {
                    tableroInt[i][j] = 0;
                }
            }
        }
        
        // Determinar el valor del jugador actual
        int valorJugador = (jugador == Ficha.X) ? 1 : 2;
        
        // Usar la lógica del juego para verificar si hay ganador
        return juegoLogica.hayGanador(tableroInt, valorJugador);
    }
    
    /**
     * Verifica si el tablero está lleno (empate)
     * @return true si el tablero está lleno, false en caso contrario
     */
    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero.obtenerFicha(i, j) == Ficha.VACIA) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Método principal para ejecutar el juego
     */
    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        juego.iniciar();
    }
}