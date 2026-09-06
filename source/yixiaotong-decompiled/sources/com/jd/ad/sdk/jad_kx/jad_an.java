package com.jd.ad.sdk.jad_kx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PreLoadAdDataBaseStorage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_an jad_cp;
    public static final List<String> jad_dq = new ArrayList();
    public final List<String> jad_bo;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_kx.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PreLoadAdDataBaseStorage.java */
    public class RunnableC0561jad_an implements Runnable {
        public RunnableC0561jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an jad_anVar = jad_an.this;
            List<String> list = jad_an.jad_dq;
            synchronized (jad_anVar) {
                jad_anVar.jad_an(list);
            }
        }
    }

    public jad_an(Context context, String str, int i) {
        super(context, str, i);
        this.jad_bo = new ArrayList();
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        try {
            getWritableDatabase();
            if (!jad_bo()) {
                return;
            }
            ContentValues contentValuesJad_bo = jad_bo(jad_cpVar);
            int i = jad_cpVar.jad_an;
            if (i > 0) {
                this.jad_an.update("preloadAd", contentValuesJad_bo, "_id=?", new String[]{String.valueOf(i)});
            } else {
                this.jad_an.insert("preloadAd", null, contentValuesJad_bo);
            }
        } catch (Throwable th) {
            Logger.w("Exception while saving preload ad data: ", th.getMessage());
        }
    }

    public final ContentValues jad_bo(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdSlotId", jad_cpVar.jad_cp);
                contentValues.put("rId", jad_cpVar.jad_bo);
                contentValues.put("preloadAdJson", ANEProxy.ja(jad_cpVar.jad_dq));
                contentValues.put("preloadAdCacheTimeStamp", jad_cpVar.jad_er);
            } catch (Exception e) {
                e = e;
                Logger.w("Exception while add preload ad data: ", e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
            contentValues = null;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    public synchronized Cursor jad_er() {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.jad_an = sQLiteDatabase;
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preloadAd");
        onCreate(sQLiteDatabase);
    }

    public static synchronized jad_an jad_dq() {
        if (jad_cp == null) {
            jad_cp = new jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
        }
        return jad_cp;
    }

    public synchronized Cursor jad_bo(String str) {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, "appIdSlotId =?", new String[]{String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ca A[Catch: all -> 0x00dc, PHI: r3
  0x00ca: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:30:0x00c8, B:24:0x00a9] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:23:0x00a5, B:31:0x00ca, B:29:0x00c4, B:36:0x00d2, B:38:0x00d8, B:39:0x00db, B:5:0x0009, B:9:0x0014, B:11:0x0031, B:12:0x0043, B:14:0x0049, B:16:0x007b, B:19:0x0084, B:21:0x0096, B:20:0x008f, B:22:0x009a, B:27:0x00ad), top: B:45:0x0001, inners: #0, #2 }] */
    public synchronized List<jad_cp> jad_an(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return arrayList;
            }
            cursorQuery = this.jad_an.query("preloadAd", null, "appIdSlotId =?", new String[]{String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                long jCurrentTimeMillis = System.currentTimeMillis() - (((long) jad_er.jad_an.jad_an.jad_bo()) * 1000);
                while (!cursorQuery.isAfterLast()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdCacheTimeStamp"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("rId"));
                    String strJb = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdJson")));
                    if (!TextUtils.isEmpty(strJb) && Long.parseLong(string) >= jCurrentTimeMillis) {
                        arrayList.add(new jad_cp(i, str, string2, strJb, string));
                    } else {
                        ((ArrayList) jad_dq).add(string2);
                    }
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
                WorkExecutor.execute(new RunnableC0561jad_an());
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                throw th2;
            }
        }
        return arrayList;
    }

    public synchronized void jad_an(List<String> list) {
        SQLiteDatabase sQLiteDatabase;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    try {
                        getWritableDatabase();
                        if (!jad_bo()) {
                            SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                            if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                                this.jad_an.endTransaction();
                            }
                            return;
                        }
                        this.jad_an.beginTransaction();
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            this.jad_an.delete("preloadAd", "rId=?", new String[]{it.next()});
                        }
                        this.jad_an.setTransactionSuccessful();
                        SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                        if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                            sQLiteDatabase = this.jad_an;
                        }
                    } catch (Throwable th) {
                        try {
                            Logger.w("Exception while clearing preload ad data:", th.getMessage());
                            SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                            if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                                sQLiteDatabase = this.jad_an;
                            }
                        } catch (Throwable th2) {
                            SQLiteDatabase sQLiteDatabase5 = this.jad_an;
                            if (sQLiteDatabase5 != null && sQLiteDatabase5.inTransaction()) {
                                this.jad_an.endTransaction();
                            }
                            throw th2;
                        }
                    }
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void jad_an(String str, String[] strArr) {
        try {
            try {
                getWritableDatabase();
                if (!jad_bo()) {
                    SQLiteDatabase sQLiteDatabase = this.jad_an;
                    if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                        this.jad_an.endTransaction();
                    }
                    return;
                }
                this.jad_an.beginTransaction();
                this.jad_an.delete("preloadAd", str, strArr);
                this.jad_an.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                Logger.w("Exception while clearing events: ", th.getMessage());
                SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                }
            } catch (Throwable th2) {
                SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                    this.jad_an.endTransaction();
                }
                throw th2;
            }
        }
        this.jad_an.endTransaction();
    }
}
