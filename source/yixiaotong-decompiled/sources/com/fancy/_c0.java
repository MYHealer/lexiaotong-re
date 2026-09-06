package com.fancy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c0 extends SQLiteOpenHelper implements _nn {
    public static final String[] _a = {"_id", "url", "length", "mime"};

    public _c0(Context context) {
        super(context, "fancy_video_cache.db", (SQLiteDatabase.CursorFactory) null, 1);
        _hy._a(context);
    }

    @Override // com.fancy._nn
    public final _nm _a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        str.getClass();
        _nm _nmVar = null;
        try {
            cursorQuery = getReadableDatabase().query("SourceInfo", _a, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        _nmVar = new _nm(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("url")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime")), cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("length")));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return _nmVar;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.fancy._nn
    public final void _a(String str, _nm _nmVar) {
        Object[] objArr = {str, _nmVar};
        for (int i = 0; i < 2; i++) {
            objArr[i].getClass();
        }
        boolean z = _a(str) != null;
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", _nmVar._a);
        contentValues.put("length", Long.valueOf(_nmVar._b));
        contentValues.put("mime", _nmVar._c);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValues, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValues);
        }
    }
}
