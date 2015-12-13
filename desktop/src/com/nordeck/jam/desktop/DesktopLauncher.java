package com.nordeck.jam.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nordeck.jam.JamGame;

public class DesktopLauncher {
    private static final double SCALE_FACTOR = 0.75d;

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = (int) (JamGame.HEIGHT * SCALE_FACTOR);
        config.width = (int) (JamGame.WIDTH * SCALE_FACTOR);
        new LwjglApplication(new JamGame(), config);
    }
}
