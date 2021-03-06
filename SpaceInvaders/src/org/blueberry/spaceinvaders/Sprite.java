package org.blueberry.spaceinvaders;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *  The Sprite class represents a image to be displayed on screen.
 */
public abstract class Sprite {
    
    protected Image image;
    protected ImageView imageView;
    protected double positionX, positionY;
    protected double velocityX, velocityY;
    protected double width;
    protected double height;


    public Sprite(Image img, double xLocation, double yLocation, double xVelocity, double yVelocity) {
        image = img;
        imageView = new ImageView(img);
        positionX = xLocation;
        positionY = yLocation;    
        velocityX = xVelocity;
        velocityY = yVelocity;
        width = img.getWidth();
        height = img.getHeight();
    }
    
    public abstract void update();
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
}
