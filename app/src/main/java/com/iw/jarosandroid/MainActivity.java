package com.iw.jarosandroid;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.DynamicColors;
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

        if (savedInstanceState == null) {
            new ContainerRoute(getSupportFragmentManager()).replace(new HomeFacet());
        }
    }
}
