package com.iw.jarosandroid;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.iw.jarosandroid.sqlite.SQLiteHelper;
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
        products.add("Kotlet pozarski", "Mieso", "", 15.0, false);
        products.add("Kotlet drobiowy", "Mieso", "", 14.0, false);
        products.add("Kotlet mielony", "Mieso", "", 14.0, false);
        products.add("Kotlet mielony wieprzowy", "Mieso", "", 15.0, false);
        products.add("Kotlet schabowy", "Mieso", "", 19.0, false);
        products.add("Kotlet zapiekany", "Mieso", "", 14.0, false);
        products.add("Filet z drobiu", "Mieso", "", 19.0, false);
        products.add("Pieczen z karkowki", "Mieso", "", 19.0, false);
        products.add("Devolay", "Mieso", "", 14.0, false);
        products.add("Schab po meksykansku", "Mieso", "", 14.0, false);
        products.add("Golabek", "Mieso", "", 17.0, false);
        products.add("Roztrzepaniec", "Mieso", "", 19.0, false);
        products.add("Rolada schabowa", "Mieso", "", 24.0, false);
        products.add("Udko faszerowane", "Mieso", "", 24.0, false);
        products.add("Udko pieczone", "Mieso", "", 15.0, false);
        products.add("Pulpety w sosie grzybowym", "Mieso", "", 13.0, false);
        products.add("Pulpety drobiowe", "Mieso", "", 17.0, false);
        products.add("Watroba drobiowa", "Mieso", "", 15.0, false);
        products.add("Potrawka z kurczaka", "Mieso", "", 15.0, false);
        products.add("Placek po cygansku", "Mieso", "", 24.0, false);
        products.add("Pomidorowa z makaronem", "Zupa", "", 8.0, false);
        products.add("Barszcz ukrainski", "Zupa", "", 8.0, false);
        products.add("Gyrosowa", "Zupa", "", 8.0, false);
        products.add("Meksykanska", "Zupa", "", 8.0, false);
        products.add("Rosol", "Zupa", "", 8.0, false);
        products.add("Pieczarkowa", "Zupa", "", 8.0, false);
        products.add("Jarzynowa", "Zupa", "", 8.0, false);
        products.add("Kwasnica", "Zupa", "", 8.0, false);
        products.add("Bigos", "Zupa", "", 8.0, false);
        products.add("Fasolowa", "Zupa", "", 8.0, false);
        products.add("Botwinka", "Zupa", "", 8.0, false);
        products.add("Leczo", "Zupa", "", 8.0, false);
        products.add("Nalesniki z twarogiem", "Nalesniki", "", 12.0, false);
        products.add("Nalesniki z dzemem", "Nalesniki", "", 12.0, false);
        products.add("Ruskie", "Pierogi", "", 14.0, false);
        products.add("Szpinak-twarog", "Pierogi", "", 14.0, false);
        products.add("Miesne", "Pierogi", "", 14.0, false);
        products.add("Kawa", "Napoje", "", 5.0, false);
        products.add("Herbata", "Napoje", "", 5.0, false);
        products.add("Kakao", "Napoje", "", 4.0, false);
        products.add("Kompot", "Napoje", "", 4.0, false);
        products.add("Maslanka", "Napoje", "", 4.0, false);
        products.add("Ziemniaki", "Garnirunek", "", 4.0, false);
        products.add("Kasza", "Garnirunek", "", 4.0, false);
        products.add("Ryz", "Garnirunek", "", 4.0, false);
        products.add("Warzywa na cieplo", "Garnirunek", "", 4.0, false);
        products.add("Surowka", "Garnirunek", "", 4.0, false);
        products.add("Jajecznica", "Sniadanie", "", 6.0, false);
        products.add("Jajka sadzone", "Sniadanie", "", 6.0, false);
        products.add("Kielbasa smazona", "Sniadanie", "", 6.0, false);
        products.add("Pojemnik", "Opakowanie", "", 1.0, false);
        products.add("Torba papierowa", "Opakowanie", "", 1.0, false);
        products.add("Buleczka", "Dodatki", "", 1.0, false);
    }
}
