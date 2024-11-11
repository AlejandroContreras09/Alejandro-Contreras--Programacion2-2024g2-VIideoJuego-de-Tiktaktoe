package Tic_Tac_Toe;

import java.awt.Graphics;
import javax.swing.JOptionPane;

import Fichas.Tablero;

public class Juego {
    private Tablero tablero;
    private boolean turnoX = true; 
    private boolean juegoTerminado = false; 
    
    public Juego() {
        this.tablero = new Tablero();
    }
    
    public void hacerMovimiento(int fila, int columna) {
        if (!juegoTerminado && tablero.getCelda(fila, columna) == null) {  
            char ficha = turnoX ? 'X' : 'O';
            tablero.colocarFicha(fila, columna, ficha);
            turnoX = !turnoX;  // esto para el cambio de turno 
            
       
            if (verificarGanador()) {
                String ganador = turnoX ? "O" : "X";  
                JOptionPane.showMessageDialog(null, "¡El jugador " + ganador + " ha ganado!");
                juegoTerminado = true; 
            } else if (esEmpate()) {
                JOptionPane.showMessageDialog(null, "¡Empate!");
                juegoTerminado = true; 
            }
        }
    }
    
    public boolean verificarGanador() {
        return tablero.verificarGanador();
    }

    public boolean esEmpate() {
        return tablero.esEmpate();
    }

    public void dibujar(Graphics g) {
        tablero.dibujar(g);
    }
    
    public void reiniciarJuego() {
        tablero = new Tablero();  
        turnoX = true;  
        juegoTerminado = false;  
    }
}

