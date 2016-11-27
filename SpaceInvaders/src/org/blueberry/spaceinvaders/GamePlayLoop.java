package org.blueberry.spaceinvaders;

import javafx.animation.AnimationTimer;

/**
 * The game loop.
 */
public class GamePlayLoop extends AnimationTimer {

    /**
     *
     */
    protected SpaceInvaders spaceInv;

    /**
     *
     * @param spaceInvaders
     */
    public GamePlayLoop(SpaceInvaders spaceInvaders) {
        spaceInv = spaceInvaders;
    }
    
    /**
     * Called in every frame and update all sprites on screen.
     * @param now 
     */
    @Override
    public void handle(long now) {
       spaceInv.spriteManager.update();
    }
    
    /**
     * Start the game loop.
     */
    @Override
    public void start() {
        super.start();
    }
    
    /**
     * Stop the game loop.
     */
    @Override
    public void stop() {
        super.stop();
    }

}
