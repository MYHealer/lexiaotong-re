package com.ubix.ssp.ad.e.b0.h.u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ubix.ssp.ad.e.b0.h.l;
import com.ubix.ssp.ad.e.b0.h.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class a extends SQLiteOpenHelper implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f8801a = {"_id", "url", "length", "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        l.a(context);
    }

    private ContentValues a(q qVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", qVar.f8796a);
        contentValues.put("length", Long.valueOf(qVar.b));
        contentValues.put("mime", qVar.c);
        return contentValues;
    }

    private q a(Cursor cursor) {
        return new q(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.ubix.ssp.ad.e.b0.h.u.c
    public q a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        l.a(str);
        q qVarA = null;
        try {
            cursorQuery = getReadableDatabase().query("SourceInfo", f8801a, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        qVarA = a(cursorQuery);
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
            return qVarA;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.u.c
    public void a(String str, q qVar) {
        l.a(str, qVar);
        boolean z = a(str) != null;
        ContentValues contentValuesA = a(qVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        l.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
