package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class z extends SQLiteOpenHelper {
    public z(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    private long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA cache_size;", null);
            if (cursorRawQuery.moveToFirst()) {
                long j = cursorRawQuery.getLong(0);
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                return j;
            }
        } catch (Throwable th) {
            try {
                j2.g(a(), "queryCacheSize db=" + sQLiteDatabase + ",failE=" + SystemUtils.getDesensitizedException(th));
            } finally {
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            }
        }
        return -1L;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        long j;
        int iJ = g.j();
        if (iJ < 0) {
            j2.a(a(), "setCacheSize noNeedWithDb=" + sQLiteDatabase + ",dbCacheSize=" + iJ);
            return;
        }
        try {
            long jA = j2.d() ? a(sQLiteDatabase) : 0L;
            long pageSize = sQLiteDatabase.getPageSize();
            if (pageSize > 0) {
                long j2 = iJ;
                j = (j2 / pageSize) + ((long) (j2 % pageSize == 0 ? 0 : 1));
            } else {
                j = -1;
            }
            if (j >= 0) {
                sQLiteDatabase.execSQL("PRAGMA cache_size=" + j + ";");
            }
            j2.c(a(), "setCacheSize db=" + sQLiteDatabase + ",dbCacheSize=" + iJ + ",nowSize=" + jA + ",pageSize=" + pageSize + ",newPageNum=" + j + ",newSize=" + (j2.d() ? a(sQLiteDatabase) : 0L));
        } catch (Throwable th) {
            j2.g(a(), "setCacheSize db=" + sQLiteDatabase + ",dbCacheSize=" + iJ + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("PRAGMA synchronous = NORMAL");
        } catch (Throwable th) {
            j2.g(a(), "setDefaultMode db=" + sQLiteDatabase + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public abstract String a();

    protected boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = cursorRawQuery.getColumnIndex("name");
            while (cursorRawQuery.moveToNext()) {
                if (str2.equals(cursorRawQuery.getString(columnIndex))) {
                    j2.a(a(), "isColumnExist db=" + sQLiteDatabase + ",tableName=" + str + ",columnName=" + str2 + " exist");
                    com.hihonor.hianalytics.util.k.a(cursorRawQuery);
                    return true;
                }
            }
        } catch (Throwable th) {
            try {
                j2.g(a(), "isColumnExist db=" + sQLiteDatabase + ",tableName=" + str + ",columnName=" + str2 + ",failE=" + SystemUtils.getDesensitizedException(th));
            } finally {
                com.hihonor.hianalytics.util.k.a(cursorRawQuery);
            }
        }
        return false;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        try {
            sQLiteDatabase.enableWriteAheadLogging();
            c(sQLiteDatabase);
            b(sQLiteDatabase);
            j2.a(a(), "onConfigure db=" + sQLiteDatabase + ",pageSize=" + sQLiteDatabase.getPageSize() + ",maxSize=" + sQLiteDatabase.getMaximumSize());
        } catch (Throwable th) {
            j2.g(a(), "onConfigure db=" + sQLiteDatabase + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        j2.e(a(), "onDowngrade oldVersion=" + i + ",newVersion=" + i2 + ",db=" + sQLiteDatabase);
    }
}
