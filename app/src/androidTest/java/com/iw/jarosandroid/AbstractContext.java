package com.iw.jarosandroid;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Before;

public abstract class AbstractContext {
    protected Context context;

    @Before
    public void init() {
        context = ApplicationProvider.getApplicationContext();
    }
}
