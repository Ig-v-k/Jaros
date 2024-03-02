package com.iw.jarosandroid;

import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.iw.jarosandroid.facet.HomeFacet;
import com.iw.jarosandroid.jaros.JsonJaros;
import com.iw.jarosandroid.route.ContainerRoute;
import com.iw.jarosandroid.sqlite.SQLiteHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        if (savedInstanceState == null) {
            refreshDatabase();

            final Route route = new ContainerRoute(getSupportFragmentManager());
            route.replace(new HomeFacet(route));

            Window window = this.getWindow();
            // fit bars
//            WindowCompat.setDecorFitsSystemWindows(window, false);

            // bars color
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(Color.TRANSPARENT);
                window.setNavigationBarColor(Color.TRANSPARENT);
            }

            // system ui color
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
            insetsController.setAppearanceLightStatusBars(false);
        }
    }

    public void refreshDatabase() {
        final String json = "jaros.json";
        final AssetManager assets = getAssets();
        try (final SQLiteHelper helper = new SQLiteHelper(this);
             final SQLiteDatabase database = helper.write();
             final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assets.open(json)))) {
            final Jaros jaros = new JsonJaros().from(bufferedReader);
            final List<Product> jsonProducts = jaros.products();

            database.execSQL("DROP TABLE IF EXISTS product_table");
            helper.onCreate(database);

            for (Product jsonProduct : jsonProducts) {
                final ContentValues values = new ContentValues();
                values.put("name", jsonProduct.name());
                values.put("category", jsonProduct.category());
                values.put("ingredients", jsonProduct.ingredients());
                values.put("pln", jsonProduct.pln());
                values.put("favorite", jsonProduct.favorite() ? 1 : -1);
                database.insert("product_table", null, values);
            }

            int version = database.getVersion();
            database.setVersion(++version);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
