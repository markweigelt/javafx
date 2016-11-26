/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blueberry.spaceinvaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mark Weigelt
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
     * @return  */
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
        //System.out.print(this.getAllSprites().size());
        this.getAllSprites().forEach((sprite) -> {
            sprite.update();
        });
    }
    
}