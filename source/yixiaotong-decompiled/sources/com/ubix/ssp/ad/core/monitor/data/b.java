package com.ubix.ssp.ad.core.monitor.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.ubix.ssp.ad.e.w.h;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentResolver f8590a;
    private SQLiteOpenHelper b;
    private Context c;
    private boolean d = true;
    private boolean e = true;
    private int f = 0;
    private int g = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;

    public b(Context context, SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            this.b = sQLiteOpenHelper;
            this.c = context;
            this.f8590a = context.getContentResolver();
        } catch (Exception e) {
            h.a(e);
        }
    }

    private SQLiteDatabase a() {
        try {
            if (!b()) {
                this.b.close();
                this.d = true;
            }
            return this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            h.a(e);
            this.d = false;
            return null;
        }
    }

    private boolean b() {
        return this.c.getDatabasePath("ubix_sdk").exists();
    }

    public int a(String str, String[] strArr) {
        if (!this.d) {
            return 0;
        }
        try {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA != null) {
                return sQLiteDatabaseA.delete("events", str, strArr);
            }
        } catch (SQLiteException e) {
            this.d = false;
            h.a(e);
        }
        return 0;
    }

    public Cursor a(int i) {
        Integer numValueOf;
        String str;
        try {
            if (i == 2) {
                numValueOf = Integer.valueOf(this.f);
                str = oOOOoo00.OooO0oo;
            } else if (i == 6) {
                numValueOf = Integer.valueOf(this.g);
                str = oOOOoo00.OooOOO;
            } else if (i != 10) {
                numValueOf = null;
                str = null;
            } else {
                numValueOf = Integer.valueOf(this.e ? 1 : 0);
                str = oOOOoo00.OooOOO0;
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{str});
            matrixCursor.addRow(new Object[]{numValueOf});
            return matrixCursor;
        } catch (Exception e) {
            h.a(e);
            return null;
        }
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        if (!this.d) {
            return null;
        }
        try {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA != null) {
                return sQLiteDatabaseA.query(str, strArr, str2, strArr2, null, null, str3);
            }
            return null;
        } catch (SQLiteException e) {
            this.d = false;
            h.a(e);
            return null;
        }
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA != null && contentValues.containsKey("event_name") && contentValues.containsKey("result")) {
                return ContentUris.withAppendedId(uri, sQLiteDatabaseA.insertWithOnConflict(oOOOoo00.OooO0O0, null, contentValues, 5));
            }
            return uri;
        } catch (Exception e) {
            h.a(e);
            return uri;
        }
    }

    public void a(int i, Uri uri, ContentValues contentValues) {
        try {
            if (i == 2) {
                this.f = contentValues.getAsInteger(oOOOoo00.OooO0oo).intValue();
            } else {
                if (i != 6) {
                    return;
                }
                this.g = contentValues.getAsInteger(oOOOoo00.OooOOO).intValue();
                this.f8590a.notifyChange(uri, null);
            }
        } catch (Exception e) {
            h.a(e);
        }
    }

    public void a(UriMatcher uriMatcher, String str) {
        try {
            uriMatcher.addURI(str, "events", 1);
            uriMatcher.addURI(str, oOOOoo00.OooO0oo, 2);
            uriMatcher.addURI(str, oOOOoo00.OooO, 3);
            uriMatcher.addURI(str, oOOOoo00.OooOO0O, 4);
            uriMatcher.addURI(str, oOOOoo00.OooOO0, 5);
            uriMatcher.addURI(str, oOOOoo00.OooOOO, 6);
            uriMatcher.addURI(str, oOOOoo00.OooOOoo, 7);
            uriMatcher.addURI(str, oOOOoo00.OooO0O0, 8);
            uriMatcher.addURI(str, oOOOoo00.OooOO0o, 9);
            uriMatcher.addURI(str, oOOOoo00.OooOOO0, 10);
            uriMatcher.addURI(str, oOOOoo00.OooOOo0, 11);
            uriMatcher.addURI(str, oOOOoo00.OooOOo, 12);
        } catch (Exception e) {
            h.a(e);
        }
    }

    public Uri b(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA != null && contentValues.containsKey("data") && contentValues.containsKey(oOOOoo00.OooOo0)) {
                return ContentUris.withAppendedId(uri, sQLiteDatabaseA.insert("events", "_id", contentValues));
            }
            return uri;
        } catch (Exception e) {
            h.a(e);
            return uri;
        }
    }
}
