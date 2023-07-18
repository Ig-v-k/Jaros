package com.iw.jarosandroid;

import android.content.res.AssetManager;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.iw.jarosandroid.jaros.JsonJaros;
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
}
