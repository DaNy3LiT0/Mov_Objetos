package ar.gob.itse.desafio.controller;

import ar.gob.itse.desafio.model.Objeto_1;
import ar.gob.itse.desafio.model.Objeto_2;
import ar.gob.itse.desafio.model.Objeto_3;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author DaNy3LiT0 Sarmiento
 */
public class Universo extends JPanel {

    private Objeto_1 objeto_1;
    private Objeto_2 objeto_2;
    private Objeto_3 objeto_3;
    private Timer timer;
//    private Random random;
    

    private int getNumberRandomX() {
        return (int) (Math.random() * (this.getWidth()));
    }
    
    private int getNumberRandomY() {
        return (int) (Math.random() * (this.getHeight()));
    }
    
    public Universo(Dimension d) {
        
        this.setSize(d);
        this.setPreferredSize(d);
        
        
        
        this.objeto_1 = new Objeto_1(getNumberRandomX(),getNumberRandomY());
        this.objeto_2 = new Objeto_2(getNumberRandomX(),getNumberRandomY());
        this.objeto_3 = new Objeto_3(getNumberRandomX(),getNumberRandomY());
        this.objeto_1.limitesXY(this.getWidth(), this.getHeight());
        this.objeto_2.limitesXY(this.getWidth(), this.getHeight());
        this.objeto_3.limitesXY(this.getWidth(), this.getHeight());
        
        this.timer = new Timer(15, (ActionEvent e) -> {
            objeto_1.move();
            objeto_2.move();
            objeto_3.move();
            repaint();
        });
    }

    public void animar(boolean turnOnOff) {
        if (turnOnOff) {
            
            objeto_1.setVelocidadXY();
            objeto_2.setVelocidadXY();
            objeto_3.setVelocidadXY();
            timer.start();
        } else {
            timer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        objeto_1.dibujar(g);
        objeto_2.dibujar(g);
        objeto_3.dibujar(g);
    }
    
  
}
