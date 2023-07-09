package com.iw.jarosandroid.products;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.iw.jarosandroid.Container;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.Products;
import com.iw.jarosandroid.product.LtProduct;

import java.util.ArrayList;
import java.util.List;

public final class LtProducts implements Products {

    private final Container container;

    public LtProducts(final Container container) {
        this.container = container;
    }

    @Override
    public List<Product> list() {
        try (final SQLiteDatabase database = container.read();
             final Cursor cursor = database.rawQuery("SELECT _id FROM product_table", null)) {
            final List<Product> columns = new ArrayList<>(0);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                final int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                columns.add(new LtProduct(container, id));
                cursor.moveToNext();
            }
            return columns;
        }
    }

    @Override
    public void add(String name, String category, String ingredients, double pln, boolean favorite) {
        try (final SQLiteDatabase database = container.read()) {
            final ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("category", category);
            values.put("ingredients", ingredients);
            values.put("pln", pln);
            values.put("favorite", favorite ? 1 : -1);
            database.insertOrThrow("product_table", null, values);
        }
    }
}
