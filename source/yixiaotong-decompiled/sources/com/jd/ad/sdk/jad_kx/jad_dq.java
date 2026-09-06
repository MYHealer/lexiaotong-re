package com.jd.ad.sdk.jad_kx;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_qd.jad_jw;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: PreloadAdDataCacheHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements Runnable {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ jad_er jad_bo;

    public jad_dq(jad_er jad_erVar, Context context) {
        this.jad_bo = jad_erVar;
        this.jad_an = context;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00da A[Catch: all -> 0x012a, PHI: r9
  0x00da: PHI (r9v5 android.database.Cursor) = (r9v4 android.database.Cursor), (r9v7 android.database.Cursor) binds: [B:36:0x00d8, B:27:0x00b6] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {, blocks: (B:14:0x003e, B:26:0x00b2, B:37:0x00da, B:35:0x00d4, B:60:0x0120, B:62:0x0126, B:63:0x0129, B:33:0x00bd), top: B:142:0x003e, outer: #8, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01f0 A[Catch: all -> 0x023f, PHI: r10
  0x01f0: PHI (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:98:0x01ee, B:91:0x01ce] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #9 {, blocks: (B:74:0x013f, B:90:0x01ca, B:99:0x01f0, B:97:0x01ea, B:123:0x0235, B:125:0x023b, B:126:0x023e, B:95:0x01d3), top: B:148:0x013f, outer: #2, inners: #1 }] */
    @Override // java.lang.Runnable
    public void run() {
        LinkedHashMap linkedHashMap;
        ArrayList<jad_cp> arrayList;
        Cursor cursorQuery;
        LinkedHashMap linkedHashMap2;
        ArrayList<jad_cp> arrayList2;
        Cursor cursorQuery2;
        this.jad_bo.jad_jt = jad_jw.jad_dq(this.jad_an);
        jad_er jad_erVar = this.jad_bo;
        if (jad_erVar.jad_bo == null) {
            jad_erVar.jad_bo = jad_fs.jad_an.jad_an;
        }
        LinkedHashMap linkedHashMap3 = null;
        if (!jad_erVar.jad_jt) {
            jad_fs jad_fsVar = jad_erVar.jad_bo;
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                linkedHashMap = new LinkedHashMap();
                synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                    String str = com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_preload_ad/query";
                    arrayList = new ArrayList();
                    ContentResolver contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                    if (contentResolverJad_an != null) {
                        try {
                            cursorQuery = contentResolverJad_an.query(Uri.parse(str), null, null, null, "preloadAdCacheTimeStamp ASC");
                            if (cursorQuery != null) {
                                try {
                                    if (cursorQuery.getCount() > 0) {
                                        cursorQuery.moveToFirst();
                                        while (!cursorQuery.isAfterLast()) {
                                            arrayList.add(new jad_cp(cursorQuery.getInt(cursorQuery.getColumnIndex("_id")), cursorQuery.getString(cursorQuery.getColumnIndex("appIdSlotId")), cursorQuery.getString(cursorQuery.getColumnIndex("rId")), ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdJson"))), cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdCacheTimeStamp"))));
                                            cursorQuery.moveToNext();
                                        }
                                        cursorQuery.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
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
                            }
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursorQuery = null;
                        }
                    }
                }
                jad_fsVar.getClass();
                if (linkedHashMap3 != null || linkedHashMap3.size() <= 0) {
                    return;
                }
                jad_fsVar.jad_an = linkedHashMap3;
                return;
            }
            if (arrayList.size() > 0) {
                for (jad_cp jad_cpVar : arrayList) {
                    String str2 = jad_cpVar.jad_cp;
                    ArrayList arrayList3 = (ArrayList) linkedHashMap.get(str2);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(jad_cpVar);
                    linkedHashMap.put(str2, arrayList3);
                }
                linkedHashMap3 = linkedHashMap;
            }
            jad_fsVar.getClass();
            if (linkedHashMap3 != null) {
                return;
            } else {
                return;
            }
        }
        if (jad_erVar.jad_an == null) {
            jad_erVar.jad_an = jad_an.jad_dq();
            this.jad_bo.jad_an.jad_cp();
        }
        jad_er jad_erVar2 = this.jad_bo;
        jad_fs jad_fsVar2 = jad_erVar2.jad_bo;
        jad_an jad_anVar2 = jad_erVar2.jad_an;
        synchronized (jad_anVar2) {
            linkedHashMap2 = new LinkedHashMap();
            synchronized (jad_anVar2) {
                arrayList2 = new ArrayList();
                try {
                    jad_anVar2.getReadableDatabase();
                    if (jad_anVar2.jad_bo()) {
                        cursorQuery2 = jad_anVar2.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
                        try {
                            if (cursorQuery2.getCount() > 0) {
                                cursorQuery2.moveToFirst();
                                while (!cursorQuery2.isAfterLast()) {
                                    arrayList2.add(new jad_cp(cursorQuery2.getInt(cursorQuery2.getColumnIndex("_id")), cursorQuery2.getString(cursorQuery2.getColumnIndex("appIdSlotId")), cursorQuery2.getString(cursorQuery2.getColumnIndex("rId")), ANEProxy.jb(cursorQuery2.getString(cursorQuery2.getColumnIndex("preloadAdJson"))), cursorQuery2.getString(cursorQuery2.getColumnIndex("preloadAdCacheTimeStamp"))));
                                    cursorQuery2.moveToNext();
                                }
                                cursorQuery2.close();
                            }
                            if (!cursorQuery2.isClosed()) {
                                cursorQuery2.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
                                if (cursorQuery2 != null && !cursorQuery2.isClosed()) {
                                    cursorQuery2.close();
                                }
                            } catch (Throwable th5) {
                                if (cursorQuery2 != null && !cursorQuery2.isClosed()) {
                                    cursorQuery2.close();
                                }
                                throw th5;
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cursorQuery2 = null;
                }
            }
            jad_fsVar2.getClass();
            if (linkedHashMap3 != null || linkedHashMap3.size() <= 0) {
            }
            jad_fsVar2.jad_an = linkedHashMap3;
            return;
        }
        if (arrayList2.size() > 0) {
            for (jad_cp jad_cpVar2 : arrayList2) {
                String str3 = jad_cpVar2.jad_cp;
                ArrayList arrayList4 = (ArrayList) linkedHashMap2.get(str3);
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList4.add(jad_cpVar2);
                linkedHashMap2.put(str3, arrayList4);
            }
            linkedHashMap3 = linkedHashMap2;
        }
        jad_fsVar2.getClass();
        if (linkedHashMap3 != null) {
        }
    }
}
