package com.jd.ad.sdk.jad_xk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: EventUploadManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu implements Runnable {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ jad_iv jad_bo;

    public jad_hu(jad_iv jad_ivVar, Context context) {
        this.jad_bo = jad_ivVar;
        this.jad_an = context;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01f4 A[Catch: all -> 0x0211, PHI: r3
  0x01f4: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:105:0x01f2, B:99:0x01d2] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:75:0x0140, B:98:0x01ce, B:106:0x01f4, B:104:0x01ee, B:114:0x0207, B:116:0x020d, B:117:0x0210, B:102:0x01d6, B:78:0x014f, B:81:0x0157, B:83:0x017e, B:85:0x0184, B:86:0x0187, B:88:0x018d, B:90:0x01a7, B:92:0x01af, B:94:0x01b7, B:95:0x01bb, B:96:0x01c9), top: B:121:0x0140, inners: #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x010c A[Catch: all -> 0x0122, PHI: r3
  0x010c: PHI (r3v5 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:54:0x010a, B:48:0x00f7] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {, blocks: (B:27:0x007b, B:47:0x00f3, B:55:0x010c, B:53:0x0106, B:60:0x0118, B:62:0x011e, B:63:0x0121, B:51:0x00fb, B:30:0x0088, B:33:0x0093, B:35:0x00ab, B:36:0x00ae, B:38:0x00b4, B:40:0x00ce, B:42:0x00d6, B:44:0x00de, B:45:0x00e2, B:46:0x00f0), top: B:122:0x007b, inners: #4, #6 }] */
    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        jad_cp jad_cpVar;
        this.jad_bo.jad_fs = com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(this.jad_an);
        this.jad_bo.jad_jt = com.jd.ad.sdk.jad_qd.jad_jw.jad_cp(this.jad_an);
        this.jad_bo.jad_cp = new ConcurrentLinkedQueue<>();
        this.jad_bo.jad_er = new ConcurrentLinkedQueue<>();
        jad_iv jad_ivVar = this.jad_bo;
        Cursor cursorQuery = null;
        if (!jad_ivVar.jad_fs) {
            if (jad_ivVar.jad_cp == null) {
                jad_ivVar.jad_cp = new ConcurrentLinkedQueue<>();
            }
            if (jad_ivVar.jad_er == null) {
                jad_ivVar.jad_er = new ConcurrentLinkedQueue<>();
            }
            String str = jad_ivVar.jad_jt;
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        ContentResolver contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                        if (contentResolverJad_an != null) {
                            cursorQuery = contentResolverJad_an.query(Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event/query/" + str), null, null, null, null);
                            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                                cursorQuery.moveToFirst();
                                while (!cursorQuery.isAfterLast()) {
                                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_EVENT));
                                    if (!TextUtils.isEmpty(string) && (!string.startsWith("{") || !string.endsWith(i.d))) {
                                        string = ANEProxy.jb(string);
                                    }
                                    jad_dq jad_dqVar = new jad_dq(i, string);
                                    jad_dqVar.jad_kv = 1;
                                    arrayList.add(jad_dqVar);
                                    cursorQuery.moveToNext();
                                }
                                cursorQuery.close();
                            }
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_EVENT_QUERY_ERROR;
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
                }
            }
            if (arrayList.size() > 0) {
                jad_ivVar.jad_cp.addAll(arrayList);
                return;
            }
            return;
        }
        if (jad_ivVar.jad_dq == null) {
            Context context = this.jad_an;
            synchronized (jad_cp.class) {
                if (jad_cp.jad_bo == null) {
                    jad_cp.jad_bo = new jad_cp(context, "jaddb.db", 2);
                }
                jad_cpVar = jad_cp.jad_bo;
            }
            jad_ivVar.jad_dq = jad_cpVar;
            this.jad_bo.jad_dq.jad_cp();
        }
        jad_iv jad_ivVar2 = this.jad_bo;
        if (jad_ivVar2.jad_dq != null) {
            if (jad_ivVar2.jad_cp == null) {
                jad_ivVar2.jad_cp = new ConcurrentLinkedQueue<>();
            }
            if (jad_ivVar2.jad_er == null) {
                jad_ivVar2.jad_er = new ConcurrentLinkedQueue<>();
            }
            ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue = jad_ivVar2.jad_cp;
            jad_cp jad_cpVar2 = jad_ivVar2.jad_dq;
            String str2 = jad_ivVar2.jad_jt;
            synchronized (jad_cpVar2) {
                arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jad_cpVar2.getReadableDatabase();
                        if (jad_cpVar2.jad_bo()) {
                            cursorQuery = jad_cpVar2.jad_an.query("events", null, "process_name =?", new String[]{str2}, null, null, null);
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.moveToFirst();
                                while (!cursorQuery.isAfterLast()) {
                                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_EVENT));
                                    if (!TextUtils.isEmpty(string2) && (!string2.startsWith("{") || !string2.endsWith(i.d))) {
                                        string2 = ANEProxy.jb(string2);
                                    }
                                    jad_dq jad_dqVar2 = new jad_dq(i2, string2);
                                    jad_dqVar2.jad_kv = 1;
                                    arrayList2.add(jad_dqVar2);
                                    cursorQuery.moveToNext();
                                }
                                cursorQuery.close();
                            }
                            if (!cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            Logger.w("Exception while loading events: ", th3);
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                        } catch (Throwable th4) {
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            throw th4;
                        }
                    }
                }
            }
            concurrentLinkedQueue.addAll(arrayList2);
        }
    }
}
