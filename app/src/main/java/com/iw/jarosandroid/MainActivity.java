package com.iw.jarosandroid;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public final class MainActivity extends AppCompatActivity implements Route {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
    }

    @Override
    public void forward(final Facet facet) {
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.v_main_container, facet.fragment(), facet.tag())
                .commit();
    }

    @Override
    public void back() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void replace(final Facet facet) {
        final FragmentManager fManager = getSupportFragmentManager();
        fManager.popBackStack();
        fManager.beginTransaction()
                .setReorderingAllowed(false)
                .replace(R.id.v_main_container, facet.fragment(), facet.tag())
                .commit();
    }
}
