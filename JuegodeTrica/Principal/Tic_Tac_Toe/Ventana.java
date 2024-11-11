package Tic_Tac_Toe;

import javax.swing.*;

import Mouse.MouseInput;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private Juego juego;
    private MouseInput mouseInput;
    
    public Ventana() {
        juego = new Juego();
        mouseInput = new MouseInput(juego);
        
        // el tamaño de la ventana 
        setTitle("Tic Tac Toe");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addMouseListener(mouseInput);
        
        // utilizamos el panel para dibujar 
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                juego.dibujar(g);
            }
        });
        
        // y el hilo para actualizar la ventana
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint(); 
            }
        });
        timer.start();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }
}
