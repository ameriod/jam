package com.nordeck.jam.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.nordeck.jam.JamGame;

/**
 * Base screen that includes a default stage {@link #getStage()} and the input multiplexer
 * {@link #getInputMultiplexer()} so there can be a stage and input fo the stage and game.
 */
public abstract class BaseScreen implements Screen {

    private Stage stage;
    private InputMultiplexer inputMultiplexer;

    public BaseScreen() {
        stage = new Stage(new FitViewport(JamGame.WIDTH, JamGame.HEIGHT));
        // Catch multiple input points (just add new input processors to the InputMultiplexer)
        inputMultiplexer = new InputMultiplexer(stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        renderStage(delta);
    }

    protected void renderStage(float delta) {
        stage.act(delta);
        stage.draw();
    }

    protected void clearScreen() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }

    /**
     * Changes the screen
     *
     * @param screen {@link Screen} to show
     */
    public void setScreen(Screen screen) {
        ((Game) Gdx.app.getApplicationListener()).setScreen(screen);
    }

}