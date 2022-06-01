package com.mygdx.dragonrealms.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.dragonrealms.Player;
import com.mygdx.dragonrealms.map.Tile;

public class GoldMine extends Unit {
    public GoldMine(Tile tile, Player player, Matrix4 projectionMatrix) {
        super("Gold Mine", new Texture(Gdx.files.internal("textures/buildings/goldmine.png")) , 5, 0, 10, 0, 0, player, (int)tile.getCoordinates().x, (int)tile.getCoordinates().y, projectionMatrix);
    }
}
