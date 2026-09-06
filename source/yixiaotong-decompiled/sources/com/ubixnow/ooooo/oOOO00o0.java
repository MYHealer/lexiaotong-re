package com.ubixnow.ooooo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOO00o0 extends SQLiteOpenHelper {
    private static final String OooO00o = "----.SQLiteOpenHelper";
    private static final String OooO0O0 = String.format("CREATE TABLE %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL);", "events", "data", oOOOoo00.OooOo0);
    private static final String OooO0OO = String.format("CREATE INDEX IF NOT EXISTS time_idx ON %s (%s);", "events", oOOOoo00.OooOo0);
    private static final String OooO0Oo = String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s INTEGER)", oOOOoo00.OooO0O0, "event_name", "result");

    public oOOO00o0(Context context) {
        super(context, oOOOoo00.OooO0o, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        oOO0O0O.OooO0O0(OooO00o, "Creating a new UbixDataDBHelper Analytics DB");
        sQLiteDatabase.execSQL(OooO0O0);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
