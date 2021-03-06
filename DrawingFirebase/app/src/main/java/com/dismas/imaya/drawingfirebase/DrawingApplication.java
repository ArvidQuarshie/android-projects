package com.dismas.imaya.drawingfirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by imaya on 4/1/16.
 */
public class DrawingApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        //Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
        SyncedBoardManager.setContext(this);
    }
}
