package com.ubixnow.ooooo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O00O0o extends SQLiteOpenHelper {
    private static final int OooO00o = 2;

    public o0O00O0o(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
    }

    private void OooO00o(SQLiteDatabase sQLiteDatabase) {
        o0O00OO.OooO00o(sQLiteDatabase);
        o0O00OOO.OooO00o(sQLiteDatabase);
    }

    private void OooO0O0(SQLiteDatabase sQLiteDatabase) {
        o0O00OO.OooO0O0(sQLiteDatabase);
        o0O00OOO.OooO0O0(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        OooO00o(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        OooO0O0(sQLiteDatabase);
        OooO00o(sQLiteDatabase);
    }
}
