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
        moveShip(positionX, positionY);
    }
    
    private void setXPosition() {
        if(ship.isRight()) {
            positionX += velocityX;
        }
        if(ship.isLeft()) {
            positionX -= velocityX;
        }
    }
    
    private void moveShip(double x, double y) {
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
    }
   
}
