package com.ubix.ssp.ad.core.monitor.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ubix.ssp.ad.e.w.h;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8589a = String.format("CREATE TABLE %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL);", "events", "data", oOOOoo00.OooOo0);
    private static final String b = String.format("CREATE INDEX IF NOT EXISTS time_idx ON %s (%s);", "events", oOOOoo00.OooOo0);
    private static final String c = String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s INTEGER)", oOOOoo00.OooO0O0, "event_name", "result");

    a(Context context) {
        super(context, "ubix_sdk", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        h.b("----.SQLiteOpenHelper", "Creating a new UbixDataDBHelper Analytics DB");
        sQLiteDatabase.execSQL(f8589a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
