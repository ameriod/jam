package com.nordeck.jam.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by parker on 8/14/15.
 */
public class SpriteDecomposer {
    public static final String TAG = "SpriteDecomposer";

    private String folderName;
    private Texture texture;
    private Pixmap pixmap;
    private int width, height, margins;
    private int textureWidth, textureHeight;

    /**
     * @param folderName
     * @param texture
     * @param width      of region
     * @param height     of region
     * @param margins    around region
     */
    public SpriteDecomposer(String folderName, Texture texture, int width, int height, int margins) {
        this.folderName = folderName;
        this.texture = texture;
        this.texture.getTextureData().prepare();
        this.pixmap = texture.getTextureData().consumePixmap();
        this.textureHeight = this.texture.getHeight();
        this.textureWidth = this.texture.getWidth();
        this.width = width;
        this.height = height;
        this.margins = margins;
    }

    public void decompose() {
        // the first and last items do not have margins, just what separates out the images
        int tickCountX = 0;
        int tickCountY = 0;
        for (int x = 0; x < textureWidth; x = x + (width + margins)) {
            for (int y = 0; y < textureHeight; y = y + (width + margins)) {
                Pixmap pixmap = getRegionPixmap(x, y);
                if (pixmap != null) {
                    Gdx.app.log(TAG, "Saves Region at x: " + tickCountY + " y: " + tickCountY + " transparent");
                    saveRegion(tickCountX, tickCountY, pixmap);
                } else {
                    Gdx.app.log(TAG, "Region at x: " + tickCountX + " y: " + tickCountY + " transparent");
                }
                tickCountY++;
            }
            tickCountX++;
        }
    }

    private Pixmap getRegionPixmap(int srcX, int srcY) {
        Pixmap regionPixmap = new Pixmap(width, height, pixmap.getFormat());
        regionPixmap.drawPixmap(pixmap, 0, 0, srcX, srcY, textureHeight, textureWidth);
        if (isAllTransparent(regionPixmap)) {
            return null;
        }
        return regionPixmap;
    }

    private boolean isAllTransparent(Pixmap pixmap) {
        for (int x = 0, sizeX = pixmap.getWidth(); x < sizeX; x++) {
            for (int y = 0, sizeY = pixmap.getHeight(); y < sizeY; y++) {
                int color = pixmap.getPixel(x, y);
                if (color != Color.argb8888(Color.CLEAR)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void saveRegion(int indexX, int indexY, Pixmap pixmap) {
        try {
            FileHandle fh;
            do {
                fh = new FileHandle(folderName + "/" + indexX + "_" + indexY + ".png");
            } while (fh.exists());
            PixmapIO.writePNG(fh, pixmap);
            pixmap.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
