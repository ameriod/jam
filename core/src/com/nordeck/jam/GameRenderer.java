package com.nordeck.jam;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nordeck.jam.utils.Utils;

/**
 * Draw the game.
 * <p/>
 * Created by parker on 5/8/15.
 */
public class GameRenderer {
    public static final String TAG = "GameRenderer";

    private GameWorld gameWorld;
    private Camera camera;

    public GameRenderer(GameWorld gameWorld, Camera camera) {
        this.gameWorld = gameWorld;
        this.camera = camera;
    }

    public void render(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer, float runTime) {
        // update the game world
        gameWorld.update(runTime);

        camera.update();

        // update the camera so it fits inside the VeiwPort / stage
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        // draw sprites
        spriteBatch.end();
        // debug drawing
        if (Utils.DEBUG && shapeRenderer != null) {
            shapeRenderer.setProjectionMatrix(camera.combined);
            // draw debug lines
        }
    }
}
