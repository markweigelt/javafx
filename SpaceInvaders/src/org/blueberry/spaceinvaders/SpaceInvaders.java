package org.blueberry.spaceinvaders;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Mark Weigelt
 */
public class SpaceInvaders extends Application {
    static final double WIDTH = 800, HEIGHT = 600;
    static final Color BACKGROUNDCOLOR = Color.BLACK;
    private boolean left, right, space;
    Group root;
    Ship iShip;
    private Scene scene;
    private Image imgShip;
    private GamePlayLoop gamePlayLoop;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Space Invaders");
        root = new Group();
        scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
        primaryStage.setScene(scene);

        createSceneEventHandling();
        createGameImages();
        createGameActors();
        addGameActors();
        createStartGameLoop();
       
        primaryStage.show();
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void createSceneEventHandling(){
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:  left  = true; break;
                case RIGHT: right = true; break;
                case SPACE: space = true; break;
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:  left  = false; break;
                 case RIGHT: right = false; break;
                case SPACE: space = false; break;
            }  
        });
    }
    
    private void createGameImages() {
        imgShip = new Image("resources/images/ship.png"); // https://placeholdit.imgix.net/~text?txtsize=15&bg=ff0000&txtclr=ffffff&txt=Ship&w=80&h=40&fm=png
    }
    
    private void createGameActors() {
       iShip = new Ship(this, imgShip, 340, 560);
    }
    
    private void addGameActors() {
        root.getChildren().add(iShip.imageView);
    }
    
    private void createStartGameLoop() {
        gamePlayLoop = new GamePlayLoop(this);
        gamePlayLoop.start();
    }
    
    public boolean isLeft() {
        return left;
    }
    
    public void setLeft(boolean left) {
        this.left = left;
    }
    
    public boolean isRight() {
        return right;
    }
    
    public void setRight(boolean right) {
        this.right = right;
    }
    
     public boolean isSpace() {
        return space;
    }
    
    public void setSpace(boolean space) {
        this.space = space;
    }
    
}
