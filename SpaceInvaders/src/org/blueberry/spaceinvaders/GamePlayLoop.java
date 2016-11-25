package org.blueberry.spaceinvaders;

import javafx.animation.AnimationTimer;

public class GamePlayLoop extends AnimationTimer {
    protected SpaceInvaders ship;
    public GamePlayLoop(SpaceInvaders iShip) {
        ship = iShip;
    }

    @Override
    public void handle(long now) {
        ship.iShip.update();
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
