package org.blueberry.spaceinvaders;

import javafx.animation.AnimationTimer;

public class GamePlayLoop extends AnimationTimer {
    protected SpaceInvaders spaceInv;
    public GamePlayLoop(SpaceInvaders spaceInvaders) {
        spaceInv = spaceInvaders;
    }

    @Override
    public void handle(long now) {
       //spaceInv.iShip.update();
       spaceInv.spriteManager.update();
    }
    
    @Override
    public void start() {
        super.start();
    }
    
    @Override
    public void stop() {
        super.stop();
    }

}
