package com.iw.jarosandroid.products;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.iw.jarosandroid.Sqlite;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.Products;
import com.iw.jarosandroid.product.ConstProduct;
import com.iw.jarosandroid.product.LtProduct;

import java.util.ArrayList;
import java.util.List;

public final class ConstProducts implements Products {
    private final Sqlite sqlite;

    private final Products origin;

    public ConstProducts(Sqlite sqlite) {
        this(sqlite, new LtProducts(sqlite));
    }

    public ConstProducts(Sqlite sqlite, Products origin) {
        this.sqlite = sqlite;
        this.origin = origin;
    }

    @Override
    public List<Product> list() {
        try (final SQLiteDatabase database = this.sqlite.read();
             final Cursor cursor = database.rawQuery("SELECT * FROM product_table", null)) {
            final List<Product> columns = new ArrayList<>(0);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                final int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                columns.add(
                        new ConstProduct(
                                new LtProduct(sqlite, id),
                                cursor.getString(cursor.getColumnIndexOrThrow("name")),
                                cursor.getString(cursor.getColumnIndexOrThrow("category")),
                                cursor.getString(cursor.getColumnIndexOrThrow("ingredients")),
                                cursor.getDouble(cursor.getColumnIndexOrThrow("pln")),
                                cursor.getInt(cursor.getColumnIndexOrThrow("favorite")) == 1)
                );
                cursor.moveToNext();
            }
            return columns;
        }
    }

    @Override
    public void add(String name, String category, String ingredients, double pln, boolean favorite) {
        origin.add(name, category, ingredients, pln, favorite);
    }
}
