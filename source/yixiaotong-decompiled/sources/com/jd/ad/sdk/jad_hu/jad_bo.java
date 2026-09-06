package com.jd.ad.sdk.jad_hu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DataBaseTemplateStorage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_bo jad_bo;

    /* JADX INFO: compiled from: DataBaseTemplateStorage.java */
    public class jad_an implements Runnable {
        public final /* synthetic */ List jad_an;

        public jad_an(List list) {
            this.jad_an = list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        
            if (r1.inTransaction() != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        
            if (r1.inTransaction() != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        
            r1 = r0.jad_an;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            jad_bo jad_boVar = jad_bo.this;
            List list = this.jad_an;
            synchronized (jad_boVar) {
                if (list != null) {
                    try {
                        if (list.size() != 0) {
                            try {
                                jad_boVar.getWritableDatabase();
                                if (jad_boVar.jad_bo()) {
                                    jad_boVar.jad_an.beginTransaction();
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        jad_boVar.jad_an.delete("lottieTemplate", "_id=?", new String[]{String.valueOf(((Integer) it.next()).intValue())});
                                    }
                                    jad_boVar.jad_an.setTransactionSuccessful();
                                    SQLiteDatabase sQLiteDatabase = jad_boVar.jad_an;
                                    if (sQLiteDatabase != null) {
                                    }
                                } else {
                                    SQLiteDatabase sQLiteDatabase2 = jad_boVar.jad_an;
                                    if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                                        SQLiteDatabase sQLiteDatabase3 = jad_boVar.jad_an;
                                        sQLiteDatabase3.endTransaction();
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    Logger.w("Exception while clearing templates:", th.getMessage());
                                    SQLiteDatabase sQLiteDatabase4 = jad_boVar.jad_an;
                                    if (sQLiteDatabase4 != null) {
                                    }
                                } catch (Throwable th2) {
                                    SQLiteDatabase sQLiteDatabase5 = jad_boVar.jad_an;
                                    if (sQLiteDatabase5 != null && sQLiteDatabase5.inTransaction()) {
                                        jad_boVar.jad_an.endTransaction();
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public jad_bo(Context context, String str, int i) {
        super(context, str, i);
    }

    public final ContentValues jad_bo(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                contentValues.put("templateID", Integer.valueOf(jad_cpVar.jad_cp));
                contentValues.put("templateJSON", ANEProxy.ja(jad_cpVar.jad_er));
                contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
                contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
            } catch (Exception e) {
                e = e;
                Logger.w("Exception while add templates:", e.getMessage());
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
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
            }
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:").append(Log.getStackTraceString(e)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:").append(Log.getStackTraceString(e)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS lottieTemplate");
        onCreate(sQLiteDatabase);
    }

    public static synchronized jad_bo jad_an(Context context, String str, int i) {
        if (jad_bo == null) {
            jad_bo = new jad_bo(context, str, i);
        }
        return jad_bo;
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        if (jad_cpVar != null) {
            try {
                getWritableDatabase();
                if (!jad_bo()) {
                    return;
                }
                ContentValues contentValuesJad_bo = jad_bo(jad_cpVar);
                int i = jad_cpVar.jad_an;
                if (i > 0) {
                    this.jad_an.update("lottieTemplate", contentValuesJad_bo, "_id=?", new String[]{String.valueOf(i)});
                } else {
                    this.jad_an.insert("lottieTemplate", null, contentValuesJad_bo);
                }
            } catch (Throwable th) {
                Logger.w("Exception while saving template: ", th.getMessage());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f9 A[Catch: all -> 0x010b, PHI: r5
  0x00f9: PHI (r5v2 android.database.Cursor) = (r5v1 android.database.Cursor), (r5v3 android.database.Cursor) binds: [B:33:0x00f7, B:27:0x00bc] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:26:0x00b8, B:34:0x00f9, B:32:0x00f3, B:39:0x0101, B:41:0x0107, B:42:0x010a, B:30:0x00c0, B:6:0x0010, B:10:0x001b, B:12:0x0038, B:13:0x0045, B:15:0x004b, B:17:0x0087, B:19:0x008d, B:22:0x0096, B:24:0x00a9, B:23:0x00a2, B:25:0x00ad), top: B:46:0x0003, inners: #1, #2 }] */
    public synchronized List<jad_cp> jad_an(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return arrayList;
            }
            cursorQuery = this.jad_an.query("lottieTemplate", null, "appIdPid =?", new String[]{String.valueOf(str)}, null, null, "timeStampInterval DESC");
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                long jCurrentTimeMillis = System.currentTimeMillis() - 2592000000L;
                while (!cursorQuery.isAfterLast()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("templateID"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("templateUpdateTimeStamp"));
                    String strJb = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("templateJSON")));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("timeStampInterval"));
                    if (!TextUtils.isEmpty(strJb) && (arrayList.size() <= 1 || Long.parseLong(string2) >= jCurrentTimeMillis)) {
                        arrayList.add(new jad_cp(i, str, i2, string, strJb, string2));
                    } else {
                        arrayList2.add(Integer.valueOf(i));
                    }
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
                WorkExecutor.execute(new jad_an(arrayList2));
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Logger.w("Exception while query templates: " + th.getMessage(), new Object[0]);
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_QUERY_TEMPLATE_DB_ERROR;
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
}
