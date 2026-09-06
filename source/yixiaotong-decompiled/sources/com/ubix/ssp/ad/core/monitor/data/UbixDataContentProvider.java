package com.ubix.ssp.ad.core.monitor.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.ubix.ssp.ad.e.w.h;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixDataContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final UriMatcher f8588a = new UriMatcher(-1);
    private a b;
    private b c;

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                writableDatabase.beginTransaction();
                int length = contentValuesArr.length;
                for (ContentValues contentValues : contentValuesArr) {
                    insert(uri, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return length;
            } catch (SQLiteException e) {
                h.a(e);
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            if (1 == f8588a.match(uri)) {
                return this.c.a(str, strArr);
            }
            return 0;
        } catch (Exception e) {
            h.a(e);
            return 0;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() != 0) {
            try {
                int iMatch = f8588a.match(uri);
                if (iMatch == 1) {
                    return this.c.b(uri, contentValues);
                }
                if (iMatch == 8) {
                    return this.c.a(uri, contentValues);
                }
                this.c.a(iMatch, uri, contentValues);
                return uri;
            } catch (Exception e) {
                h.a(e);
            }
        }
        return uri;
    }

    public boolean onCreate(Context context) {
        if (context == null) {
            return true;
        }
        try {
            a aVar = new a(context);
            this.b = aVar;
            b bVar = new b(context, aVar);
            this.c = bVar;
            bVar.a(f8588a, context.getPackageName() + ".UbixDataContentProvider");
            return true;
        } catch (Exception e) {
            h.a(e);
            return true;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorA;
        try {
            int iMatch = f8588a.match(uri);
            if (iMatch == 1) {
                cursorA = this.c.a("events", strArr, str, strArr2, str2);
            } else {
                cursorA = iMatch == 8 ? this.c.a(oOOOoo00.OooO0O0, strArr, str, strArr2, str2) : this.c.a(iMatch);
            }
            return cursorA;
        } catch (Exception e) {
            h.a(e);
            return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
