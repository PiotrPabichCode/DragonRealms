package com.mygdx.dragonrealms;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.dragonrealms.map.Map;
import com.mygdx.dragonrealms.units.Unit;
import com.mygdx.dragonrealms.units.Warrior;

import java.util.Vector;

public class TiledTest extends ApplicationAdapter implements InputProcessor {

    Map map;
    OrthographicCamera camera;

    Vector<Unit> unitList;

    SpriteBatch sb;

    @Override
    public void create () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        map = new Map("maps/map_test/mapa_alpha.tmx");
        Gdx.input.setInputProcessor(this);
        unitList = new Vector<>();
        unitList.add(new Warrior(0,0));
        sb = new SpriteBatch();
    }

    @Override
    public void render(){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        map.render(camera);
        sb.begin();
        for (Unit unit : unitList) {
            unit.render(sb);
        }
        sb.end();

    }

    @Override
    public boolean keyDown(int keycode) {

        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP || keycode == Input.Keys.W)
            camera.translate(0, 32);
        if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S)
            camera.translate(0,-32);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 clickCoordinates = new Vector3(screenX, screenY, 0);
        Vector3 position = camera.unproject(clickCoordinates);
        Vector2 tile = map.convertCoordinates(position);
        System.out.println("x: " + tile.x + " y: " + tile.y );
        map.getTile(tile);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
