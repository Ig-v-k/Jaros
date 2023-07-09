package com.iw.jarosandroid;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.iw.jarosandroid.database.SQLiteHelper;
import com.iw.jarosandroid.products.ConstProducts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public final class ProductsTest extends AbstractContext {
    Products products;

    @Before
    public void start() {
        products = new ConstProducts(new SQLiteHelper(context));
    }

    @Test
    public void size() {
        final List<Product> list = products.list();
        assertEquals(list.size(), 0);
    }

    @Test
    public void add() {
        products.add("Kotlet pozarski", "Mieso", "", 14.0, false);
        products.add("Kotlet drobiowy", "Mieso", "", 14.0, false);
        products.add("Kotlet mielony", "Mieso", "", 14.0, false);
        products.add("Kotlet mielony wiepszowy", "Mieso", "", 14.0, false);
        products.add("Kotlet schabowy", "Mieso", "", 14.0, false);
        products.add("Kotlet zapiekany", "Mieso", "", 14.0, false);
        products.add("Filet z drobiu", "Mieso", "", 14.0, false);
        products.add("Pieczen z karkowki", "Mieso", "", 14.0, false);
        products.add("Devolay", "Mieso", "", 14.0, false);
        products.add("Schab po meksykansku", "Mieso", "", 14.0, false);
        products.add("Golabek", "Mieso", "", 14.0, false);
        products.add("Roztrzepaniec", "Mieso", "", 14.0, false);
        products.add("Rolada schabowa", "Mieso", "", 14.0, false);
        products.add("Pomidorowa z makaronem", "Zupa", "", 8.0, false);
        products.add("Barszcz ukrainski", "Zupa", "", 8.0, false);
        products.add("Gyrosowa", "Zupa", "", 8.0, false);
        products.add("Meksykanska", "Zupa", "", 8.0, false);
        products.add("Rosol", "Zupa", "", 8.0, false);
        products.add("Pieczarkowa", "Zupa", "", 8.0, false);
        products.add("Jarzynowa", "Zupa", "", 8.0, false);
        products.add("Bigos", "Zupa", "", 8.0, false);
        products.add("Fasolowa", "Zupa", "", 8.0, false);
    }
}
