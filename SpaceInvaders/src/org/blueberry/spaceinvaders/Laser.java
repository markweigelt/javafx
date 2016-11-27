package org.blueberry.spaceinvaders;

import javafx.scene.image.Image;

/**
 * A laser fired from ship.
 */
public class Laser extends Sprite {
    
    /**
     * Constructor that is called by the SpaceInvaders class, when press the space key. 
     * @param img       Laser image.
     * @param xLocation Laser x-coordinate.
     * @param yLocation Laser y-coordinate.
     * @param xVelocity Laser velocity for the x-coordinate.
     * @param yVelocity Laser velocity for the y-coordinate.
     */
    public Laser(Image img, double xLocation, double yLocation, double xVelocity, double yVelocity) {
        super(img, xLocation, yLocation, xVelocity, yVelocity);
        moveLaser(positionX, positionY);
    }
    
    /**
     * Update method to call position and move the laser.
     */
    @Override
    public void update() {
        setYPosition();
        moveLaser(positionX, positionY);
    }
    
    /**
     * Sets the lasers y-coordinate depending on velocity speed.
     */
    private void setYPosition() {
        if(positionY > 0 - this.height*2) {
            positionY -= velocityY;
        } else {
            System.out.print("delete");
            // TODO: Delete sprite from spriteManager
        }
    }
    
    /**
     * Sets the lasers x- and y-cordinate. 
     * @param x Laser new x-coordinate.
     * @param y Laser new y-coordinate.
     */
    private void moveLaser(double x, double y) {
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
    }
    
}
