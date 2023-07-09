package com.iw.jarosandroid.product;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.iw.jarosandroid.Container;
import com.iw.jarosandroid.Product;

import java.util.Arrays;

public final class LtProduct implements Product {

    private final Container container;

    private final int id;

    public LtProduct(Container container, int id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        final String query = "SELECT name FROM product_table WHERE _id = ?";
        final String[] params = new String[]{String.valueOf(id)};
        try (final SQLiteDatabase database = container.read();
             final Cursor cursor = database.rawQuery(query, params)) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndexOrThrow("name"));
            } else {
                final String mes = String.format(
                        "Cannot find column title with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(params));
                throw new RuntimeException(mes);
            }
        }
    }

    @Override
    public String category() {
        final String query = "SELECT category FROM product_table WHERE _id = ?";
        final String[] params = new String[]{String.valueOf(id)};
        try (final SQLiteDatabase database = container.read();
             final Cursor cursor = database.rawQuery(query, params)) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndexOrThrow("category"));
            } else {
                final String mes = String.format(
                        "Cannot find column title with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(params));
                throw new RuntimeException(mes);
            }
        }
    }

    @Override
    public String ingredients() {
        final String query = "SELECT ingredients FROM product_table WHERE _id = ?";
        final String[] params = new String[]{String.valueOf(id)};
        try (final SQLiteDatabase database = container.read();
             final Cursor cursor = database.rawQuery(query, params)) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getString(cursor.getColumnIndexOrThrow("ingredients"));
            } else {
                final String mes = String.format(
                        "Cannot find column title with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(params));
                throw new RuntimeException(mes);
            }
        }
    }

    @Override
    public double pln() {
        final String query = "SELECT pln FROM product_table WHERE _id = ?";
        final String[] params = new String[]{String.valueOf(id)};
        try (final SQLiteDatabase database = container.read();
             final Cursor cursor = database.rawQuery(query, params)) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getDouble(cursor.getColumnIndexOrThrow("pln"));
            } else {
                final String mes = String.format(
                        "Cannot find column title with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(params));
                throw new RuntimeException(mes);
            }
        }
    }

    @Override
    public boolean favorite() {
        final String query = "SELECT favorite FROM product_table WHERE _id = ?";
        final String[] params = new String[]{String.valueOf(id)};
        try (final SQLiteDatabase database = container.read();
             final Cursor cursor = database.rawQuery(query, params)) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getInt(cursor.getColumnIndexOrThrow("favorite")) == 1;
            } else {
                final String mes = String.format(
                        "Cannot find column title with query: \"%s\", and arguments: %s",
                        query, Arrays.toString(params));
                throw new RuntimeException(mes);
            }
        }
    }
}
