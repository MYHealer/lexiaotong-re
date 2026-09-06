package com.jd.ad.sdk.jad_tg;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_fq.jad_cp;
import com.jd.ad.sdk.jad_kx.jad_er;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiProcessManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static final List<String> jad_an = new ArrayList();
    public static final List<String> jad_bo = new ArrayList();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_tg.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MultiProcessManager.java */
    public class RunnableC0583jad_an implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (jad_an.class) {
                jad_an.jad_an(jad_an.jad_an);
            }
        }
    }

    public static String jad_an(Uri uri) {
        String[] strArrSplit;
        if (uri == null) {
            return "";
        }
        try {
            return (TextUtils.isEmpty(uri.getPath()) || (strArrSplit = uri.getPath().split("/")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String jad_bo() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("content://").append(jad_jw.jad_an(jad_cp.jad_an())).append(".JADMultiProvider").append("/").toString();
    }

    public static List<com.jd.ad.sdk.jad_hu.jad_cp> jad_cp(String str) {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolverJad_an = jad_an();
        if (contentResolverJad_an == null) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolverJad_an.query(Uri.parse(jad_bo() + "db_dynamic_render/query/" + str), null, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                long jCurrentTimeMillis = System.currentTimeMillis() - 2592000000L;
                while (!cursorQuery.isAfterLast()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("templateID"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("templateUpdateTimeStamp"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("templateJSON"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("timeStampInterval"));
                    if (!TextUtils.isEmpty(string2) && (arrayList.size() <= 1 || Long.parseLong(string3) >= jCurrentTimeMillis)) {
                        arrayList.add(new com.jd.ad.sdk.jad_hu.jad_cp(i, str, i2, string, string2, string3));
                    }
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_TEMPLATE_QUERY_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    public static List<com.jd.ad.sdk.jad_ly.jad_cp> jad_bo(String str) {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolverJad_an = jad_an();
        if (contentResolverJad_an == null) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolverJad_an.query(Uri.parse(jad_bo() + "db_video_render/query/" + str), null, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                long jCurrentTimeMillis = System.currentTimeMillis() - 2592000000L;
                while (!cursorQuery.isAfterLast()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("videoUrl"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("videoLocalPath"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("timeStampInterval"));
                    if (!TextUtils.isEmpty(string2) && (arrayList.size() <= 1 || Long.parseLong(string3) >= jCurrentTimeMillis)) {
                        arrayList.add(new com.jd.ad.sdk.jad_ly.jad_cp(i, str, string, string2, string3));
                    }
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_TEMPLATE_QUERY_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        } finally {
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    public static synchronized List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(String str) {
        String str2 = jad_bo() + "db_preload_ad/query/" + str;
        ArrayList arrayList = new ArrayList();
        ((ArrayList) jad_an).clear();
        Cursor cursorQuery = null;
        try {
            ContentResolver contentResolverJad_an = jad_an();
            if (contentResolverJad_an == null) {
                return arrayList;
            }
            cursorQuery = contentResolverJad_an.query(Uri.parse(str2), null, null, null, "preloadAdCacheTimeStamp ASC");
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - (((long) jad_er.jad_an.jad_an.jad_bo()) * 1000);
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("appIdSlotId"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("rId"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdCacheTimeStamp"));
                    String strJb = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdJson")));
                    if (!TextUtils.isEmpty(strJb) && Long.parseLong(string3) >= jCurrentTimeMillis) {
                        arrayList.add(new com.jd.ad.sdk.jad_kx.jad_cp(i, string, string2, strJb, string3));
                    } else {
                        ((ArrayList) jad_an).add(string2);
                    }
                    cursorQuery.moveToNext();
                }
                cursorQuery.close();
            }
            WorkExecutor.execute(new RunnableC0583jad_an());
            if (cursorQuery != null && !cursorQuery.isClosed()) {
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                }
            } catch (Throwable th2) {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                throw th2;
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public static synchronized void jad_an(List<String> list) {
        String str = jad_bo() + "db_preload_ad/remove";
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            ContentResolver contentResolverJad_an = jad_an();
            if (contentResolverJad_an == null) {
                return;
            }
            Uri uri = Uri.parse(str);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                contentResolverJad_an.delete(uri, "rId=?", new String[]{it.next()});
            }
        } catch (Throwable th) {
            Logger.w("Exception while clearing preload ad data list:", th.getMessage());
        }
    }

    public static ContentValues jad_an(com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar) {
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
                Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while add preload data:").append(e.getMessage()).toString(), new Object[0]);
            }
        } catch (Exception e2) {
            e = e2;
            contentValues = null;
        }
        return contentValues;
    }

    public static ContentResolver jad_an() {
        try {
            Application applicationJad_an = jad_cp.jad_an();
            if (applicationJad_an != null) {
                return applicationJad_an.getContentResolver();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
