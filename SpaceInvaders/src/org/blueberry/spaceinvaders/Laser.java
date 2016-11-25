/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueberry.spaceinvaders;

import javafx.scene.image.Image;

/**
 *
 * @author Mark Weigelt
 */
public class Laser extends Sprite {
    
    public Laser(Image img, double xLocation, double yLocation) {
        super(img, xLocation, yLocation);
        moveLaser(positionX, positionY);
       
    }
    
     @Override
    public void update() {
        setYPosition();
        moveLaser(positionX, positionY);
    }
    
    private void setYPosition() {
        System.out.println(positionY);
        positionY -= velocityY;
    }
    
     private void moveLaser(double x, double y) {
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
    }
}
