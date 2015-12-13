package com.nordeck.jam;

import com.badlogic.gdx.Game;
import com.nordeck.jam.screens.GameScreen;
import com.nordeck.jam.screens.MenuScreen;

public class JamGame extends Game {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
