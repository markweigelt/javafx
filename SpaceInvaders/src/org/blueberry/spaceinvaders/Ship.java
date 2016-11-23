package org.blueberry.spaceinvaders;

import javafx.scene.image.Image;


public class Ship extends Sprite {
    SpaceInvaders ship;
    public Ship (SpaceInvaders iShip, Image img, double xLocation, double yLocation){
        super(img, xLocation, yLocation);
        ship = iShip;
    }
    @Override
    public void update() {
        setXPosition();
        setXMovement(positionX);
    }
    
    private void setXPosition() {
        if(ship.isRight()) {
            positionX += velocityX;
        }
        if(ship.isLeft()) {
            positionX -= velocityX;
        }
    }
    
    private void setXMovement(double x) {
        imageView.setTranslateX(x);
    }
   
}