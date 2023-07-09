package com.iw.jarosandroid;

import android.database.sqlite.SQLiteDatabase;

public interface Container {
    SQLiteDatabase read();
    SQLiteDatabase write();
}
