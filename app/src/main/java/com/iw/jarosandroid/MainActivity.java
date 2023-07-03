package com.iw.jarosandroid;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.iw.jarosandroid.route.ContainerRoute;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Route route = new ContainerRoute(getSupportFragmentManager());
        setContentView(R.layout.a_main);
    }
}
