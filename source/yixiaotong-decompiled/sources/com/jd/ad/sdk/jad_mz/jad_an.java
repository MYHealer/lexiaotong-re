package com.jd.ad.sdk.jad_mz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DataBaseVideoStorage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an extends com.jd.ad.sdk.jad_sf.jad_an {
    public static jad_an jad_dq;
    public int jad_bo;
    public com.jd.ad.sdk.jad_pc.jad_an jad_cp;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_mz.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBaseVideoStorage.java */
    public class RunnableC0567jad_an implements Runnable {
        public final /* synthetic */ List jad_an;
        public final /* synthetic */ List jad_bo;

        public RunnableC0567jad_an(List list, List list2) {
            this.jad_an = list;
            this.jad_bo = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an.jad_an(jad_an.this, this.jad_an);
            jad_an.jad_bo(jad_an.this, this.jad_bo);
        }
    }

    /* JADX INFO: compiled from: DataBaseVideoStorage.java */
    public class jad_bo implements Runnable {
        public final /* synthetic */ List jad_an;
        public final /* synthetic */ List jad_bo;

        public jad_bo(List list, List list2) {
            this.jad_an = list;
            this.jad_bo = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an.jad_an(jad_an.this, this.jad_an);
            jad_an.jad_bo(jad_an.this, this.jad_bo);
        }
    }

    public jad_an(Context context, String str, int i) {
        super(context, str, i);
        this.jad_bo = 40;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r8.inTransaction() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r8.inTransaction() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        r8 = r7.jad_an;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void jad_an(jad_an jad_anVar, List list) {
        synchronized (jad_anVar) {
            if (list != null) {
                if (list.size() != 0) {
                    try {
                        jad_anVar.getWritableDatabase();
                        if (jad_anVar.jad_bo()) {
                            jad_anVar.jad_an.beginTransaction();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                jad_anVar.jad_an.delete("splashVideo", "_id=?", new String[]{String.valueOf(((Integer) it.next()).intValue())});
                            }
                            jad_anVar.jad_an.setTransactionSuccessful();
                            SQLiteDatabase sQLiteDatabase = jad_anVar.jad_an;
                            if (sQLiteDatabase != null) {
                            }
                        } else {
                            SQLiteDatabase sQLiteDatabase2 = jad_anVar.jad_an;
                            if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                                SQLiteDatabase sQLiteDatabase3 = jad_anVar.jad_an;
                                sQLiteDatabase3.endTransaction();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            Logger.w("Exception while clearing video:", th.getMessage());
                            SQLiteDatabase sQLiteDatabase4 = jad_anVar.jad_an;
                            if (sQLiteDatabase4 != null) {
                            }
                        } catch (Throwable th2) {
                            SQLiteDatabase sQLiteDatabase5 = jad_anVar.jad_an;
                            if (sQLiteDatabase5 != null && sQLiteDatabase5.inTransaction()) {
                                jad_anVar.jad_an.endTransaction();
                            }
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    public static void jad_bo(jad_an jad_anVar, List list) {
        jad_anVar.getClass();
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (!file.exists()) {
                        Logger.d("File does not exist");
                    } else if (file.delete()) {
                        Logger.d("File deleted successfully");
                    } else {
                        Logger.d("Failed to delete the file");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Logger.w("Exception while delete video:", e.getMessage());
            }
        }
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "splashVideo", "appIdPid", "videoUrl", "videoLocalPath", "timeStampInterval"));
            }
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("video render video sql create error:").append(Log.getStackTraceString(e)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT,  %s TEXT, %s TEXT, %s TEXT)", "splashVideo", "appIdPid", "videoUrl", "videoLocalPath", "timeStampInterval"));
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("video render template sql create error:").append(Log.getStackTraceString(e)).toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS splashVideo");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0112 A[Catch: all -> 0x0124, PHI: r6
  0x0112: PHI (r6v2 android.database.Cursor) = (r6v1 android.database.Cursor), (r6v3 android.database.Cursor) binds: [B:39:0x0110, B:33:0x00d5] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:32:0x00d1, B:40:0x0112, B:38:0x010c, B:45:0x011a, B:47:0x0120, B:48:0x0123, B:36:0x00d9, B:6:0x0015, B:10:0x0020, B:12:0x003d, B:13:0x004a, B:15:0x0050, B:17:0x0086, B:19:0x008c, B:21:0x0092, B:23:0x009a, B:25:0x00a0, B:28:0x00ac, B:30:0x00c2, B:29:0x00b8, B:31:0x00c6), top: B:52:0x0003, inners: #1, #2 }] */
    public synchronized List<jad_cp> jad_bo(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Cursor cursorQuery = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return arrayList;
            }
            cursorQuery = this.jad_an.query("splashVideo", null, "appIdPid =?", new String[]{String.valueOf(str)}, null, null, "timeStampInterval DESC");
            if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                long jCurrentTimeMillis = System.currentTimeMillis() - 2592000000L;
                while (!cursorQuery.isAfterLast()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String strJb = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("videoUrl")));
                    String strJb2 = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("videoLocalPath")));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("timeStampInterval"));
                    if (!TextUtils.isEmpty(strJb2) && !TextUtils.isEmpty(strJb) && ((arrayList.size() <= 1 || Long.parseLong(string) >= jCurrentTimeMillis) && !TextUtils.isEmpty(strJb2) && new File(strJb2).exists())) {
                        arrayList.add(new jad_cp(i, str, strJb, strJb2, string));
                    } else {
                        arrayList2.add(Integer.valueOf(i));
                        arrayList3.add(strJb2);
                    }
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
                WorkExecutor.execute(new jad_bo(arrayList2, arrayList3));
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Logger.w("Exception while query video: " + th.getMessage(), new Object[0]);
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_QUERY_TEMPLATE_DB_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
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

    public static synchronized jad_an jad_an(Context context, String str, int i) {
        if (jad_dq == null) {
            jad_dq = new jad_an(context, str, i);
        }
        return jad_dq;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00dc A[Catch: all -> 0x00ee, PHI: r10
  0x00dc: PHI (r10v5 android.database.Cursor) = (r10v4 android.database.Cursor), (r10v6 android.database.Cursor) binds: [B:41:0x00da, B:35:0x009d] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:34:0x0099, B:42:0x00dc, B:40:0x00d6, B:47:0x00e4, B:49:0x00ea, B:50:0x00ed, B:8:0x000a, B:12:0x0015, B:14:0x0036, B:15:0x003c, B:17:0x0040, B:18:0x0044, B:21:0x004a, B:22:0x0050, B:24:0x0054, B:25:0x0058, B:26:0x005b, B:29:0x0063, B:31:0x0088, B:32:0x008b, B:33:0x008e, B:38:0x00a1), top: B:58:0x0001, inners: #0, #1 }] */
    public synchronized void jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Cursor cursorQuery = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return;
            }
            cursorQuery = this.jad_an.query("splashVideo", null, null, null, null, null, "timeStampInterval ASC");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int count = cursorQuery.getCount();
            if (this.jad_cp == null) {
                this.jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            }
            com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_cp;
            if (jad_anVar != null) {
                this.jad_bo = jad_anVar.jad_re;
            }
            if (count > this.jad_bo) {
                if (jad_anVar == null) {
                    this.jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                }
                com.jd.ad.sdk.jad_pc.jad_an jad_anVar2 = this.jad_cp;
                if (jad_anVar2 != null) {
                    this.jad_bo = jad_anVar2.jad_re;
                }
                for (int i = count - this.jad_bo; cursorQuery.moveToNext() && i > 0; i--) {
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String strJb = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("videoLocalPath")));
                    arrayList.add(Integer.valueOf(i2));
                    if (!TextUtils.isEmpty(strJb)) {
                        arrayList2.add(strJb);
                    }
                }
            }
            cursorQuery.close();
            WorkExecutor.execute(new RunnableC0567jad_an(arrayList, arrayList2));
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                Logger.w("Exception while query video: " + th.getMessage(), new Object[0]);
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_VIDEO_RENDER_QUERY_DB_ERROR;
                jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
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
    }

    public final ContentValues jad_an(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                String strJa = ANEProxy.ja(jad_cpVar.jad_cp);
                String strJa2 = ANEProxy.ja(jad_cpVar.jad_dq);
                contentValues.put("videoUrl", strJa);
                contentValues.put("videoLocalPath", strJa2);
                contentValues.put("timeStampInterval", jad_cpVar.jad_er);
            } catch (Exception e) {
                e = e;
                Logger.w("Exception while add video:", e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
            contentValues = null;
        }
        return contentValues;
    }
}
