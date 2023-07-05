package com.iw.jarosandroid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import com.iw.jarosandroid.facet.HomeFacet;
import com.iw.jarosandroid.facet.ProductFacet;
import com.iw.jarosandroid.route.ContainerRoute;

import java.util.ArrayList;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        final ArrayList<String> data = new ArrayList<String>() {{
            add("Rolada schabowa");
            add("Mielony wieprzowy");
            add("Golabek");
            add("Pieczen z karkowki");
            add("Kotlet schabowy");
            add("Filet z drobiu");
            add("Roztrzepaniec");
            add("Rolada schabowa");
        }};

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        final ListView vList = new ListView(MainActivity.this);
        vList.setAdapter(adapter);
        vList.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        final SearchBar vSearchBar = findViewById(R.id.v_searchbar);
        final SearchView vSearchView = findViewById(R.id.v_search);
        vSearchView.setupWithSearchBar(vSearchBar);
        vSearchView.addView(vList);
        vSearchView.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s);
            }
        });

        vList.setOnItemClickListener((parent, view, position, id) -> {
            vSearchView.hide();
            new ContainerRoute(getSupportFragmentManager()).forward(new ProductFacet(null));
        });

        new ContainerRoute(getSupportFragmentManager()).replace(new HomeFacet());
    }
}
