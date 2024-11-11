package Tic_Tac_Toe;

import java.awt.Color;
import java.awt.Graphics;

public class Ficha {
    protected char tipo;  // 'X' o 'O'
    protected int fila, columna;
    
    
    public Ficha(char tipo, int fila, int columna) {
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }

    public char getTipo() {
        return tipo;
    }

    // Con esto dibujaremos las fichas 
    public void dibujar(Graphics g) {
        int x = columna * 100;  
        int y = fila * 100;    
        
        g.setColor(Color.RED);  

        if (tipo == 'X') {
            
            g.drawLine(x, y, x + 100, y + 100);  
            g.drawLine(x + 100, y, x, y + 100);  
        } else if (tipo == 'O') {
            
            g.drawOval(x, y, 100, 100);  
        }
    }
}
