package com.ubixnow.utils.monitor.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.SystemClock;
import com.ubixnow.ooooo.oOO0O0O;
import com.ubixnow.ooooo.oOOO00o0;
import com.ubixnow.ooooo.oOOO0O0o;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixDataContentProvider extends ContentProvider {
    private static final UriMatcher OooO00o = new UriMatcher(-1);
    public static long OooO0O0;
    private oOOO00o0 OooO0OO;
    private oOOO0O0o OooO0Oo;

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.OooO0OO.getWritableDatabase();
                writableDatabase.beginTransaction();
                int length = contentValuesArr.length;
                for (ContentValues contentValues : contentValuesArr) {
                    insert(uri, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return length;
            } catch (SQLiteException e) {
                oOO0O0O.OooO00o(e);
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            if (1 == OooO00o.match(uri)) {
                return this.OooO0Oo.OooO00o(str, strArr);
            }
            return 0;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() != 0) {
            try {
                int iMatch = OooO00o.match(uri);
                if (iMatch == 1) {
                    return this.OooO0Oo.OooO0O0(uri, contentValues);
                }
                if (iMatch == 8) {
                    return this.OooO0Oo.OooO00o(uri, contentValues);
                }
                this.OooO0Oo.OooO00o(iMatch, uri, contentValues);
                return uri;
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
            }
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            OooO0O0 = SystemClock.elapsedRealtime();
            Context context = getContext();
            if (context == null) {
                return true;
            }
            oOOO00o0 oooo00o0 = new oOOO00o0(context);
            this.OooO0OO = oooo00o0;
            oOOO0O0o oooo0o0o = new oOOO0O0o(context, oooo00o0);
            this.OooO0Oo = oooo0o0o;
            oooo0o0o.OooO00o(OooO00o, context.getPackageName() + ".mediation.now.UbixDataContentProvider");
            return true;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorOooO00o;
        try {
            int iMatch = OooO00o.match(uri);
            if (iMatch == 1) {
                cursorOooO00o = this.OooO0Oo.OooO00o("events", strArr, str, strArr2, str2);
            } else {
                cursorOooO00o = iMatch == 8 ? this.OooO0Oo.OooO00o(oOOOoo00.OooO0O0, strArr, str, strArr2, str2) : this.OooO0Oo.OooO00o(iMatch);
            }
            return cursorOooO00o;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
