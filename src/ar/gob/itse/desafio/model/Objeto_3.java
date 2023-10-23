/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.gob.itse.desafio.model;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Daniel Alejandro Sarmiento
 */
public class Objeto_3 {

    private Image imgObjeto;
    private int x;
    private int y;
    private int velocidadEjeX;
    private int velocidadEjeY;

    private int limiteIzquierdo = 0;
    private int limiteDerecho;
    private int limiteSuperior = 0;
    private int limiteInferior;

    // Constructor
    public Objeto_3(int x, int y) {
        this.x = x;
        this.y = y;
        String imagen = "imagenes/Great_Ball_icon-icons.com_67552.png";
        this.imgObjeto = new ImageIcon(
                getClass().getClassLoader().getResource(
                        imagen)).getImage();

    }

    public void limitesXY(int width, int heigth) {
        this.limiteDerecho = width - imgObjeto.getWidth(null);
        this.limiteInferior = heigth - imgObjeto.getHeight(null);

    }

    private int getNumberRandom(int maximo) {
        return (int) (Math.random() * maximo + 1);
    }

    public void setVelocidadXY() {
        this.velocidadEjeX = getNumberRandom(5);
        this.velocidadEjeY = getNumberRandom(8);
    }

    public void dibujar(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(imgObjeto, this.x, this.y, null);
    }

    public void move() {
        this.x += this.velocidadEjeX;
        this.y += this.velocidadEjeY;

        if (this.x < this.limiteIzquierdo) {
            this.x = 0;
            this.velocidadEjeX = -this.velocidadEjeX;
        } else if (this.x > this.limiteDerecho) {
            this.x = this.limiteDerecho;
            velocidadEjeX = -velocidadEjeX;
        }
        if (y < limiteSuperior) {
            y = 0;
            velocidadEjeY = -velocidadEjeY;
        } else if (y > limiteInferior) {
            y = limiteInferior;
            velocidadEjeY = -velocidadEjeY;
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, imgObjeto.getWidth(null), imgObjeto.getHeight(null));
    }
    
    
}