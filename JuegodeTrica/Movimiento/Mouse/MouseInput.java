package Mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Tic_Tac_Toe.Juego;

public class MouseInput extends MouseAdapter {
    private Juego juego;
    
    public MouseInput(Juego juego) {
        this.juego = juego;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = e.getY() / 100;  // Para el tamaño de las celdas 
        int columna = e.getX() / 100;
        juego.hacerMovimiento(fila, columna);  // Para que coloquemos las fichas 
    }
}
