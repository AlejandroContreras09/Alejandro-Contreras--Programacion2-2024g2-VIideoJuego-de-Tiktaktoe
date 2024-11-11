package Fichas;

import java.awt.Graphics;

import Tic_Tac_Toe.Ficha;

public class Tablero {
    private Ficha[][] celdas = new Ficha[3][3];
    
    public void colocarFicha(int fila, int columna, char tipo) {
        celdas[fila][columna] = new Ficha(tipo, fila, columna);
    }
    
    public Ficha getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }
    
    public boolean verificarGanador() {
        // Con esto verificamos filas, columnas y las diagonales
        for (int i = 0; i < 3; i++) {
            if (celdas[i][0] != null && celdas[i][0].getTipo() == celdas[i][1].getTipo() && celdas[i][1].getTipo() == celdas[i][2].getTipo()) {
                return true;  // para el ganador en  fila
            }
            if (celdas[0][i] != null && celdas[0][i].getTipo() == celdas[1][i].getTipo() && celdas[1][i].getTipo() == celdas[2][i].getTipo()) {
                return true;  // para el ganador en  columna
            }
        }
        
        // Con esto verificamos en las  diagonales
        if (celdas[0][0] != null && celdas[0][0].getTipo() == celdas[1][1].getTipo() && celdas[1][1].getTipo() == celdas[2][2].getTipo()) {
            return true;  // el ganador en la diagonal 1
        }
        if (celdas[0][2] != null && celdas[0][2].getTipo() == celdas[1][1].getTipo() && celdas[1][1].getTipo() == celdas[2][0].getTipo()) {
            return true;  // el ganador en la diagonal 2
        }
        
        return false;
    }
    
    public boolean esEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (celdas[i][j] == null) return false;  // Si en caso sobran celdas no habra empate hasta llenar todo
            }
        }
        return true;  // Si no hay celdas vacías y no hay ganador, entonces es empate
    }
    
    public void dibujar(Graphics g) {
        // con esto dibujamos el tablero 
        g.drawLine(100, 0, 100, 300);  // Vertical
        g.drawLine(200, 0, 200, 300);  // Vertical
        g.drawLine(0, 100, 300, 100);  // Horizontal
        g.drawLine(0, 200, 300, 200);  // Horizontal

        // Dibuja las fichas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (celdas[i][j] != null) {
                    celdas[i][j].dibujar(g);
                }
            }
        }
    }
}

