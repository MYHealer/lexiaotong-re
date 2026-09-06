package com.opos.cmn.biz.monitor.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f5977a;

    public b(Context context) {
        super(context, "monitor_cache.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = this.f5977a;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.f5977a = writableDatabase;
        return writableDatabase;
    }

    private d a(Cursor cursor) {
        return new d(cursor.getString(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("monitorUrl")), cursor.getLong(cursor.getColumnIndex("createTime")));
    }

    public int a(long j) {
        return a().delete("monitor_cache", "createTime<=?", new String[]{String.valueOf(j)});
    }

    public int a(d dVar) {
        return TextUtils.isEmpty(dVar.f5987a) ? a().delete("monitor_cache", "monitorUrl=? and createTime=?", new String[]{dVar.c, String.valueOf(dVar.b)}) : a().delete("monitor_cache", "id=?", new String[]{dVar.f5987a});
    }

    public List<d> a(long j, long j2, int i) {
        LinkedList linkedList = new LinkedList();
        Cursor cursorRawQuery = a().rawQuery("select *\tfrom\tmonitor_cache\twhere\tcreateTime\t>=?\tand\tcreateTime\t<=?\torder by random() limit ?;", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(i)});
        if (cursorRawQuery != null) {
            try {
                for (boolean zMoveToFirst = cursorRawQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorRawQuery.moveToNext()) {
                    linkedList.add(a(cursorRawQuery));
                }
                try {
                    cursorRawQuery.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        return linkedList;
    }

    public void a(List<d> list) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            for (d dVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("monitorUrl", dVar.c);
                contentValues.put("createTime", Long.valueOf(dVar.b));
                sQLiteDatabaseA.insert("monitor_cache", null, contentValues);
            }
            sQLiteDatabaseA.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.f5977a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table\tmonitor_cache\t(id\tinteger primary key autoincrement,monitorUrl\ttext,createTime\tlong)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.opos.cmn.an.f.a.a("CacheDBHelper", "onDowngrade db old version code=" + i + "\tnew version code=" + i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
