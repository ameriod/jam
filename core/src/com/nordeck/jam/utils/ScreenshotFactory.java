package com.nordeck.jam.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.utils.ScreenUtils;

import java.nio.ByteBuffer;

/**
 * On Desktop saves in the android assets dir
 * <p/>
 * Created by Parker on 2/2/2015.
 */
public class ScreenshotFactory {
    public static final String TAG = "ScreenshotFactory";
    private static int counter = 1;

    public static void saveScreenshot() {
        try {
            FileHandle fh;
            do {
                fh = new FileHandle("screenshot" + counter++ + ".png");
            } while (fh.exists());
            Pixmap pixmap = getScreenshot(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
            PixmapIO.writePNG(fh, pixmap);
            pixmap.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Pixmap getScreenshot(int x, int y, int w, int h, boolean yDown) {
        final Pixmap pixmap = ScreenUtils.getFrameBufferPixmap(x, y, w, h);

        if (yDown) {
            // Flip the pixmap upside down
            ByteBuffer pixels = pixmap.getPixels();
            int numBytes = w * h * 4;
            byte[] lines = new byte[numBytes];
            int numBytesPerLine = w * 4;
            for (int i = 0; i < h; i++) {
                pixels.position((h - i - 1) * numBytesPerLine);
                pixels.get(lines, i * numBytesPerLine, numBytesPerLine);
            }
            pixels.clear();
            pixels.put(lines);
        }

        return pixmap;
    }
}
