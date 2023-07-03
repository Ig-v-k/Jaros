package com.iw.jarosandroid;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.iw.jarosandroid.facet.HomeFacet;
import com.iw.jarosandroid.route.ContainerRoute;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        new ContainerRoute(getSupportFragmentManager()).replace(new HomeFacet());
    }
}
