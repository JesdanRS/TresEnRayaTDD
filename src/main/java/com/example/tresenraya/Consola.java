package com.example.tresenraya;

import java.util.Scanner;

public class Consola {
    private final Tablero tablero;
    private final Scanner scanner;

    public Consola(Tablero tablero) {
        this.tablero = tablero;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarTablero() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("-------------\n");
            sb.append("|");
            for (int j = 0; j < 3; j++) {
                Ficha ficha = tablero.obtenerFicha(i, j);
                String valor = ficha == Ficha.VACIA ? "   " : " " + ficha.toString() + " ";
                sb.append(valor).append("|");
            }
            sb.append("\n");
        }
        sb.append("-------------\n");
        System.out.print(sb.toString());
    }
 //   return new int[]{0,0}; 

    public int[] solicitarMovimiento() {
        System.out.print("Ingrese las coordenadas (x,y): ");
        String entrada = scanner.nextLine();
        String[] coordenadas = entrada.split(",");

        try {
            int x = Integer.parseInt(coordenadas[0].trim());
            int y = Integer.parseInt(coordenadas[1].trim());
            return new int[]{x, y};
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Las coordenadas deben ser números");
        }
    }
}