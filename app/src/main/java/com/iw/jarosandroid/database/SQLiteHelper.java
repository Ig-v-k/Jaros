package com.iw.jarosandroid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.iw.jarosandroid.Container;

public final class SQLiteHelper extends SQLiteOpenHelper implements Container {

    public SQLiteHelper(final Context context) {
        this(context.getApplicationContext(), 2);
    }

    private SQLiteHelper(final Context context, final int version) {
        this(context, "jarosandroid_db", null, version);
    }

    private SQLiteHelper(final Context context,
                         final String databaseName,
                         final SQLiteDatabase.CursorFactory factory,
                         final int version) {
        super(context, databaseName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS product_table (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT, category TEXT, ingredients TEXT, pln REAL," +
                " favorite INTEGER NOT NULL CHECK (favorite IN (-1, 1)))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS product_table");

        onCreate(sqLiteDatabase);
    }

    @Override
    public SQLiteDatabase read() {
        return getReadableDatabase();
    }

    @Override
    public SQLiteDatabase write() {
        return getWritableDatabase();
    }
}