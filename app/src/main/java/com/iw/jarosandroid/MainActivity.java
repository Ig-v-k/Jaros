package com.iw.jarosandroid;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import com.iw.jarosandroid.facet.HomeFacet;
import com.iw.jarosandroid.route.ContainerRoute;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        final SearchBar vSearchBar = findViewById(R.id.v_searchbar);
        final SearchView vSearchView = findViewById(R.id.v_search);
        vSearchView.setupWithSearchBar(vSearchBar);

        new ContainerRoute(getSupportFragmentManager()).replace(new HomeFacet());
    }
}
