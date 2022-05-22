package com.mygdx.dragonrealms.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.awt.image.BufferedImage;

public class Archer extends Unit {

    public Archer() {
        super("Warrior", new Texture(Gdx.files.internal("textures/knight.png")) , 4, 3, 6, 1, 1, 1);
    }
}
