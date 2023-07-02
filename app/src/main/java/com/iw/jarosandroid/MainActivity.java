package com.iw.jarosandroid;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.iw.jarosandroid.facet.MainFacet;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class MainActivity extends AppCompatActivity implements Route {
    private final List<WeakReference<Facet>> facets = new ArrayList<>();
    private TextView vScheme;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        vScheme = findViewById(R.id.v_scheme);
        replace(new MainFacet(1, this));
    }

    private void printScheme() {
        final List<String> names = new ArrayList<String>(){{
            for (WeakReference<Facet> weak : facets) {
                final Facet facet = weak.get();
                add(facet.name());
            }
        }};
        vScheme.setText(String.join(" → ", names));
    }

    @Override
    public void forward(final Facet facet) {
        facets.add(new WeakReference<>(facet));
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.v_main_container, facet.fragment(), facet.tag())
                .commit();
        printScheme();
    }

    @Override
    public void back() {
        facets.remove(facets.size() - 1);
        getSupportFragmentManager()
                .popBackStack();
        printScheme();
    }

    @Override
    public void replace(final Facet facet) {
        final FragmentManager fManager = getSupportFragmentManager();
        fManager.popBackStack();
        if (facets.isEmpty()) {
            facets.add(new WeakReference<>(facet));
        } else {
            facets.set(facets.size() - 1, new WeakReference<>(facet));
        }
        fManager.beginTransaction()
                .setReorderingAllowed(false)
                .replace(R.id.v_main_container, facet.fragment(), facet.tag())
                .commit();
        printScheme();
    }
}
