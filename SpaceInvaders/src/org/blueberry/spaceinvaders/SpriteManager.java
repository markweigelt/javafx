package org.blueberry.spaceinvaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sprite manager is responsible for holding all sprite objects.
 */
public class SpriteManager {


    private final List<Sprite> CURRENT_ACTORS;
    
    public SpriteManager() {
        CURRENT_ACTORS = new ArrayList<>();

   }
    
     public SpriteManager getSpriteManager() {
        return this;
    }
    
    /**
     * @return CURRENT_ACTORS */
    public List<Sprite> getAllSprites() {
        return CURRENT_ACTORS;
    }
    
    /**
     * VarArgs of sprite objects to be added to the game.
     * @param sprites 
     */
    public void addSprites(Sprite... sprites) {       
        CURRENT_ACTORS.addAll(Arrays.asList(sprites));
    }
    
    public void update() {
        this.getAllSprites().forEach((sprite) -> {
            sprite.update();
        });
    }
    
}