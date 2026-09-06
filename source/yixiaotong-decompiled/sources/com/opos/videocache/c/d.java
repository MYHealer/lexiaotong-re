package com.opos.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.opos.videocache.f;
import com.opos.videocache.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class d extends SQLiteOpenHelper implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f8435a = {"_id", "url", "length", "mime"};

    d(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        f.a(context);
    }

    private ContentValues a(j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", jVar.f8437a);
        contentValues.put("length", Long.valueOf(jVar.b));
        contentValues.put("mime", jVar.c);
        return contentValues;
    }

    private j a(Cursor cursor) {
        return new j(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.opos.videocache.c.b
    public j a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        f.a(str);
        j jVarA = null;
        try {
            cursorQuery = getReadableDatabase().query("SourceInfo", f8435a, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        jVarA = a(cursorQuery);
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
            return jVarA;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // com.opos.videocache.c.b
    public void a(String str, j jVar) {
        f.a(str, jVar);
        boolean z = a(str) != null;
        ContentValues contentValuesA = a(jVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
