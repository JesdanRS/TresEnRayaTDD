# JUnit Test

Recuerden que la metodología que se esta usando con el Inge, TDD, y que usaremos, es la de primero hacer las pruebas, y luego hacer código que FALLE esas pruebas, pero que posteriormente puedan pasar, por eso desarrollaremos primero los test, y luego el tres en raya

*  1. Escribir una prueba que falle (Red)

 * 2. Implementar el código mínimo para que la prueba pase (Green)

 * 3. Refactorizar el código manteniendo las pruebas en verde (Refactor)

 * 4. Repetir el proceso hasta que todas las pruebas pasen

#### Test para implementar

Es posible implementar mas Junit test, estos son solo unos ejemplos.

1. El tablero se inicializa vacío (todas las posiciones son null).
2. Se puede colocar una ficha X en una posición válida (dentro del rango 0-2, 0-2).
3. Se puede colocar una ficha O en una posición válida en el siguiente turno.
4. No se puede colocar una ficha fuera del eje X (fila < 0 o fila > 2).
5. No se puede colocar una ficha fuera del eje Y (columna < 0 o columna > 2).
6. No se puede colocar una ficha en una posición ya ocupada.
7. El método getFichaTurno alterna correctamente entre X y O.
8. El método getFicha(fila, columna) devuelve la ficha correcta después de colocarla.
9. El método colocarFicha devuelve false si la posición es inválida o está ocupada.
10. El tablero detecta si está lleno
11. El tablero detecta si hay un ganador
12. El tablero detecta empate

Estas pruebas cubren los casos de inicialización, alternancia de turnos, validación de límites y ocupación de posiciones, asegurando un desarrollo guiado por pruebas y cumpliendo con los requerimientos dados.

#### Otras posibles pruebas pruebas

    void testColocarFichaEnPosicionValida() 
    void testColocarFichaEnPosicionOcupada() 
    void testColocarFichaFueraDeLimites() 
    void testGetFichaTurnoAlternaCorrectamente() 
    void testGetFichaDevuelveFichaCorrecta() 
    void testGetTurnoInicialEsCero() 
    void testGetTurnoIncrementaDespuesDeColocarFicha() 
    void testConstructorInicializaTableroVacio() 
    void testComprobarVictoriaHorizontal()


## Recomendaciones

* 1. Escribir el nombre de la prueba de manera clara y descriptiva.
* 2. Utilizar métodos de prueba como assertEquals, assertTrue, assertFalse, assertNull, assertNotNull, etc.
* 3. Utilizar anotaciones @Test para indicar que un método es una prueba.
* 4. Utilizar anotaciones @Before para indicar que un método se debe ejecutar antes de cada prueba.
* 5. Utilizar anotaciones @After para indicar que un método se debe ejecutar después de cada prueba.

Recuerden que esto es una guía, y pueden implementar mas pruebas, o modificar las que ya estan, y la estructura del proyecto, dependiendo de lo que se necesite, las clases de main estan sujetas a cambios.

# Leer el README.md para entender como esta trabjajando el proyecto.