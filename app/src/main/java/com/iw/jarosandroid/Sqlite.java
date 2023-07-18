package com.iw.jarosandroid;

import android.database.sqlite.SQLiteDatabase;

public interface Sqlite {
    SQLiteDatabase read();
    SQLiteDatabase write();
}
