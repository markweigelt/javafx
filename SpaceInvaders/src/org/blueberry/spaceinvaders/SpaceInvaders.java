package org.blueberry.spaceinvaders;

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
    private boolean left, right;
    Group root;
    Ship iShip;
    Laser iLaser;
    private Scene scene;
    private Image imgShip, imgLaser;
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
        imgShip = new Image("resources/images/ship.png"); // https://placeholdit.imgix.net/~text?txtsize=15&bg=ff0000&txtclr=ffffff&txt=Ship&w=80&h=40&fm=png
        imgLaser = new Image("resources/images/laser.png"); // https://placeholdit.imgix.net/~text?txtsize=5&txt=5%C3%9720&w=5&h=20&txtpad=1
    }
    
    private void createInitialGameActors() {
       iShip = new Ship(this, imgShip, WIDTH/2 - imgShip.getWidth()/2 - 20, HEIGHT - imgShip.getHeight() - 30);
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
        iLaser = new Laser(imgLaser, iShip.getPositionX() + iShip.width/2, HEIGHT - iShip.height - 30 - imgLaser.getHeight());
        root.getChildren().add(iLaser.imageView);
        spriteManager.addSprites(iLaser);
    }
    
}
