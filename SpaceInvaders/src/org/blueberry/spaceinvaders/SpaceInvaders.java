package org.blueberry.spaceinvaders;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The main application class.
 */
public class SpaceInvaders extends Application {
    static final double WIDTH = 800, HEIGHT = 600;
    static final Color BACKGROUNDCOLOR = Color.BLACK;
    private boolean left, right;
    Group root;
    Ship iShip;
    Laser iLaser;
    private Scene scene;
    private Image imgShip, imgLaser, imgInvader1, imgInvader2, imgInvader3, imgMysteryShip;
    private GamePlayLoop gamePlayLoop;
    SpriteManager spriteManager;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Space Invaders");
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setResizable(false);
        root = new Group();
        scene = new Scene(root, WIDTH, HEIGHT, BACKGROUNDCOLOR);
        primaryStage.setScene(scene);

        createSpriteManager();
        createSceneEventHandling();
        loadGameImages();
        createInitialGameActors();
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
    
    private void createSpriteManager() {
       spriteManager = new SpriteManager();
    }
    
    private void createSceneEventHandling(){
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:  left  = true; break;
                case RIGHT: right = true; break;
                case SPACE: fire(); break;
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:  left  = false; break;
                case RIGHT: right = false; break;
            }  
        });
    }
    
    private void loadGameImages() {
        imgShip = new Image("resources/images/ship.png");
        imgLaser = new Image("resources/images/laser.png");
        imgInvader1 = new Image("resources/images/invader1.png");
        imgInvader2 = new Image("resources/images/invader2.png");
        imgInvader3 = new Image("resources/images/invader3.png");
        imgMysteryShip = new Image("resources/images/mystery_ship.png");
    }
    
    private void createInitialGameActors() {
       iShip = new Ship(this, imgShip, WIDTH/2 - imgShip.getWidth()/2 - 20, HEIGHT - imgShip.getHeight() - 30, 15, 15);
       root.getChildren().add(iShip.imageView);
       spriteManager.addSprites(iShip);
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
       
    private void fire() {
        iLaser = new Laser(imgLaser, iShip.getPositionX() + iShip.width/2 - imgLaser.getWidth()/2, HEIGHT - iShip.height - imgLaser.getHeight(), 10, 10);
        root.getChildren().add(iLaser.imageView);
        spriteManager.addSprites(iLaser);
    }
    
}
