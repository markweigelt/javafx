package org.blueberry.spaceinvaders;

import static org.blueberry.spaceinvaders.SpaceInvaders.HEIGHT;
import static org.blueberry.spaceinvaders.SpaceInvaders.WIDTH;
import javafx.scene.image.Image;

public class Ship extends Sprite {
    protected static final double LEFT_BOUNDARY = 0;
    protected static double rightBoundary;
    SpaceInvaders ship;
    
    public Ship(SpaceInvaders iShip, Image img, double xLocation, double yLocation) {
        super(img, xLocation, yLocation);
        ship = iShip;
        rightBoundary = WIDTH - img.getWidth();
    }
    
    @Override
    public void update() {
        setXPosition();
        setBoundaries();
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
    
    private void setBoundaries() {
        if(positionX >= rightBoundary) {
            positionX = rightBoundary;
        }
        if(positionX <= LEFT_BOUNDARY) {
            positionX = LEFT_BOUNDARY;
        }
    }
    
    private void moveShip(double x, double y) {
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
    }
    
   

}
