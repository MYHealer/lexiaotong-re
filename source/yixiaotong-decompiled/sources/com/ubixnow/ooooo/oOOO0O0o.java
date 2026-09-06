package com.ubixnow.ooooo;

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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOO0O0o {
    private ContentResolver OooO00o;
    private SQLiteOpenHelper OooO0O0;
    private Context OooO0OO;
    private boolean OooO0Oo = true;
    private boolean OooO0o0 = true;
    private int OooO0o = 0;
    private int OooO0oO = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;

    public interface OooO00o {
        public static final int OooO = 9;
        public static final int OooO00o = 1;
        public static final int OooO0O0 = 2;
        public static final int OooO0OO = 3;
        public static final int OooO0Oo = 4;
        public static final int OooO0o = 6;
        public static final int OooO0o0 = 5;
        public static final int OooO0oO = 7;
        public static final int OooO0oo = 8;
        public static final int OooOO0 = 10;
        public static final int OooOO0O = 11;
        public static final int OooOO0o = 12;
    }

    public oOOO0O0o(Context context, SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            this.OooO0O0 = sQLiteOpenHelper;
            this.OooO0OO = context;
            this.OooO00o = context.getContentResolver();
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    private SQLiteDatabase OooO00o() {
        try {
            if (!OooO0O0()) {
                this.OooO0O0.close();
                this.OooO0Oo = true;
            }
            return this.OooO0O0.getWritableDatabase();
        } catch (SQLiteException e) {
            oOO0O0O.OooO00o(e);
            this.OooO0Oo = false;
            return null;
        }
    }

    private boolean OooO0O0() {
        return this.OooO0OO.getDatabasePath(oOOOoo00.OooO0o).exists();
    }

    public int OooO00o(String str, String[] strArr) {
        if (!this.OooO0Oo) {
            return 0;
        }
        try {
            SQLiteDatabase sQLiteDatabaseOooO00o = OooO00o();
            if (sQLiteDatabaseOooO00o != null) {
                return sQLiteDatabaseOooO00o.delete("events", str, strArr);
            }
        } catch (SQLiteException e) {
            this.OooO0Oo = false;
            oOO0O0O.OooO00o(e);
        }
        return 0;
    }

    public Cursor OooO00o(int i) {
        Integer numValueOf;
        String str;
        try {
            if (i == 2) {
                numValueOf = Integer.valueOf(this.OooO0o);
                str = oOOOoo00.OooO0oo;
            } else if (i == 6) {
                numValueOf = Integer.valueOf(this.OooO0oO);
                str = oOOOoo00.OooOOO;
            } else if (i != 10) {
                numValueOf = null;
                str = null;
            } else {
                numValueOf = Integer.valueOf(this.OooO0o0 ? 1 : 0);
                str = oOOOoo00.OooOOO0;
            }
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{str});
            matrixCursor.addRow(new Object[]{numValueOf});
            return matrixCursor;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return null;
        }
    }

    public Cursor OooO00o(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        if (!this.OooO0Oo) {
            return null;
        }
        try {
            SQLiteDatabase sQLiteDatabaseOooO00o = OooO00o();
            if (sQLiteDatabaseOooO00o != null) {
                return sQLiteDatabaseOooO00o.query(str, strArr, str2, strArr2, null, null, str3);
            }
            return null;
        } catch (SQLiteException e) {
            this.OooO0Oo = false;
            oOO0O0O.OooO00o(e);
            return null;
        }
    }

    public Uri OooO00o(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseOooO00o = OooO00o();
            if (sQLiteDatabaseOooO00o != null && contentValues.containsKey("event_name") && contentValues.containsKey("result")) {
                return ContentUris.withAppendedId(uri, sQLiteDatabaseOooO00o.insertWithOnConflict(oOOOoo00.OooO0O0, null, contentValues, 5));
            }
            return uri;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return uri;
        }
    }

    public void OooO00o(int i, Uri uri, ContentValues contentValues) {
        try {
            if (i == 2) {
                this.OooO0o = contentValues.getAsInteger(oOOOoo00.OooO0oo).intValue();
            } else {
                if (i != 6) {
                    return;
                }
                this.OooO0oO = contentValues.getAsInteger(oOOOoo00.OooOOO).intValue();
                this.OooO00o.notifyChange(uri, null);
            }
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO00o(UriMatcher uriMatcher, String str) {
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
            oOO0O0O.OooO00o(e);
        }
    }

    public Uri OooO0O0(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseOooO00o = OooO00o();
            if (sQLiteDatabaseOooO00o != null && contentValues.containsKey("data") && contentValues.containsKey(oOOOoo00.OooOo0)) {
                return ContentUris.withAppendedId(uri, sQLiteDatabaseOooO00o.insert("events", "_id", contentValues));
            }
            return uri;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return uri;
        }
    }
}
