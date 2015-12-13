package com.nordeck.jam;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Control the game
 * <p/>
 * Created by parker on 5/15/15.
 */
public class GameInputProcessor implements InputProcessor {
    public static final String TAG = "GameInputProcessor";

    private GameWorld gameWorld;
    private OrthographicCamera gameCamera;

    public GameInputProcessor(GameWorld gameWorld, OrthographicCamera gamCamera) {
        this.gameWorld = gameWorld;
        this.gameCamera = gamCamera;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            return true;
        } else if (keycode == Input.Keys.RIGHT) {
            return true;
        } else if (keycode == Input.Keys.UP) {
            return true;
        } else if (keycode == Input.Keys.DOWN) {
            return true;
        }
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
    public boolean scrolled(int amount) {
        return false;
    }
}
