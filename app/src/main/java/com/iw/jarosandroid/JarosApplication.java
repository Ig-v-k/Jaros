package com.iw.jarosandroid;

import android.app.Application;
import com.google.android.material.color.DynamicColors;

public final class JarosApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
