package com.nordeck.jam.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nordeck.jam.GameInputProcessor;
import com.nordeck.jam.GameRenderer;
import com.nordeck.jam.GameWorld;
import com.nordeck.jam.JamGame;
import com.nordeck.jam.utils.Utils;

/**
 * Screen for the game. Combines the {@link GameWorld}, {@link GameRenderer} and {@link GameInputProcessor}
 * <p/>
 * Created by parker on 12/12/15.
 */
public class GameScreen extends BaseScreen {

    private GameWorld gameWorld;
    private GameRenderer gameRenderer;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;
    private float runTime;

    public GameScreen() {
        this.spriteBatch = new SpriteBatch();
        if (Utils.DEBUG) {
            this.shapeRenderer = new ShapeRenderer();
        }
        OrthographicCamera gameCamera = new OrthographicCamera(JamGame.WIDTH, JamGame.HEIGHT);
        this.gameWorld = new GameWorld();
        this.gameRenderer = new GameRenderer(gameWorld, gameCamera);
        getInputMultiplexer().addProcessor(new GameInputProcessor(gameWorld, gameCamera));
        this.runTime = 0;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        gameWorld.update(delta);
        gameRenderer.render(spriteBatch, shapeRenderer, runTime);
        // Draw the stage (UI) over the game
        super.render(delta);
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        spriteBatch.dispose();
        shapeRenderer.dispose();
    }
}
