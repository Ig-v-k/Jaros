package com.iw.jarosandroid;

import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.iw.jarosandroid.jaros.JsonJaros;
import com.iw.jarosandroid.products.ConstProducts;
import com.iw.jarosandroid.sqlite.SQLiteHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class JarosTest extends AbstractContext {
    @Test
    public void products() throws IOException {
        final String file = "jaros.json";
        final AssetManager assets = context.getAssets();
        final InputStreamReader inputStreamReader = new InputStreamReader(assets.open(file));
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final Jaros jaros = new JsonJaros().from(bufferedReader);
        final List<Product> products = jaros.products();
        assertEquals(1, products.size());
    }

    @Test
    public void initSQLite() throws IOException {
        final String json = "jaros.json";
        final AssetManager assets = context.getAssets();
        final InputStreamReader inputStreamReader = new InputStreamReader(assets.open(json));
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final Jaros jaros = new JsonJaros().from(bufferedReader);
        final List<Product> jsonProducts = jaros.products();

        final SQLiteHelper helper = new SQLiteHelper(context);
        try (final SQLiteDatabase database = helper.write()) {
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
        }
    }
}
