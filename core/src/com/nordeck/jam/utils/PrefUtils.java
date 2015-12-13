package com.nordeck.jam.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * This is equivalent to shared prefs on Android. Keeps everything nice and static.
 * <p/>
 * Created by Parker on 1/26/2015.
 */
public class PrefUtils {
    public static final String TAG = "PrefUtils";

    private static PrefUtils sInstance;
    private static Preferences prefs;

    private static final String STORAGE_NAME = PrefUtils.class.getPackage() + ".game_prefs";

    private PrefUtils() {
        prefs = Gdx.app.getPreferences(STORAGE_NAME);
    }

    public static PrefUtils getInstance() {
        if (sInstance == null) {
            sInstance = new PrefUtils();
        }
        return sInstance;
    }

}
