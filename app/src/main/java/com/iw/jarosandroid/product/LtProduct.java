package com.iw.jarosandroid.product;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.iw.jarosandroid.Sqlite;
import com.iw.jarosandroid.Product;

import java.util.Arrays;

public final class LtProduct implements Product {

    private final Sqlite sqlite;

    private final int id;

    public LtProduct(Sqlite sqlite, int id) {
        this.sqlite = sqlite;
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
        try (final SQLiteDatabase database = sqlite.read();
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
        try (final SQLiteDatabase database = sqlite.read();
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
        try (final SQLiteDatabase database = sqlite.read();
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
        try (final SQLiteDatabase database = sqlite.read();
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
        try (final SQLiteDatabase database = sqlite.read();
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

    @Override
    public void update(String name, String category, String ingredients, double pln, boolean favorite) {
        final String where = "_id = ?";
        final ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("category", category);
        values.put("ingredients", ingredients);
        values.put("pln", pln);
        values.put("favorite", favorite ? 1 : -1);
        try (final SQLiteDatabase database = sqlite.read()) {
            database.update("product_table", values, where, new String[]{String.valueOf(this.id)});
        }
    }
}
