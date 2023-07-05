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
import com.iw.jarosandroid.product.SimpleProduct;
import com.iw.jarosandroid.route.ContainerRoute;

import java.util.ArrayList;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        final ArrayList<Product> products = new ArrayList<Product>() {{
            add(new SimpleProduct(1, "Rolada schabowa", "Mieso", "Meal", "14", "product1"));
            add(new SimpleProduct(2, "Mielony wieprzowy", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(3, "Golabek", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(4, "Pieczen z karkowki", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(5, "Kotlet schabowy", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(6, "Filet z drobiu", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(7, "Roztrzepaniec", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(8, "Schab po meksykansku", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(9, "Kotlet zapiekany", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(10, "Devolay", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(11, "Potrawka z kurczaka", "Mieso", "Meal", "14", ""));
            add(new SimpleProduct(12, "Kotlet pozarski", "Mieso", "Meal", "14", ""));
        }};

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);

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
