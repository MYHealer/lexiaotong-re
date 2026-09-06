package com.jd.ad.sdk.jad_xk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventUploadManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv implements jad_ly.jad_an {
    public ConcurrentLinkedQueue<jad_dq> jad_cp;
    public com.jd.ad.sdk.jad_xk.jad_cp jad_dq;
    public ConcurrentLinkedQueue<jad_dq> jad_er;
    public final AtomicBoolean jad_an = new AtomicBoolean(false);
    public final AtomicInteger jad_bo = new AtomicInteger(1);
    public boolean jad_fs = true;
    public String jad_jt = "";

    /* JADX INFO: compiled from: EventUploadManager.java */
    public class jad_an implements Runnable {
        public final /* synthetic */ JSONObject jad_an;

        public jad_an(JSONObject jSONObject) {
            this.jad_an = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ContentResolver contentResolverJad_an;
            com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("event: ").append(this.jad_an).toString());
            jad_iv jad_ivVar = jad_iv.this;
            jad_dq jad_dqVarJad_an = jad_iv.jad_an(this.jad_an);
            jad_iv.this.getClass();
            com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            String str = (jad_cpVarJad_cp == null || (jad_dqVar = jad_cpVarJad_cp.jad_bo) == null) ? "" : jad_dqVar.jad_an;
            if (jad_ivVar.jad_cp == null) {
                jad_ivVar.jad_cp = new ConcurrentLinkedQueue<>();
            }
            if (jad_ivVar.jad_er == null) {
                jad_ivVar.jad_er = new ConcurrentLinkedQueue<>();
            }
            jad_ivVar.jad_cp.add(jad_dqVarJad_an);
            if (jad_ivVar.jad_fs) {
                com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar = jad_ivVar.jad_dq;
                if (jad_cpVar != null) {
                    jad_cpVar.jad_an(jad_dqVarJad_an, jad_ivVar.jad_jt);
                }
            } else {
                String str2 = jad_ivVar.jad_jt;
                synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                    List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            if (!TextUtils.isEmpty(jad_dqVarJad_an.jad_an().toString()) && (contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an()) != null) {
                                Uri uri = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event/update");
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(NotificationCompat.CATEGORY_EVENT, jad_dqVarJad_an.jad_an().toString());
                                contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str2);
                                contentValues.put("key", Integer.valueOf(jad_dqVarJad_an.jad_an));
                                contentResolverJad_an.update(uri, contentValues, null, null);
                            }
                        } catch (Exception e) {
                            Logger.w("Exception while multi process saving events: ", e.getMessage());
                        }
                    }
                }
            }
            if (jad_ivVar.jad_cp.size() >= jad_ivVar.jad_bo.get()) {
                jad_ivVar.jad_an(str);
            }
        }
    }

    /* JADX INFO: compiled from: EventUploadManager.java */
    public class jad_bo implements Runnable {
        public final /* synthetic */ String[] jad_an;

        public jad_bo(String[] strArr) {
            this.jad_an = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jd.ad.sdk.jad_zm.jad_fs jad_fsVarJad_an = jad_jt.jad_an();
                for (int i = 0; i < this.jad_an.length; i++) {
                    jad_ly.jad_bo jad_boVarJad_an = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
                    jad_boVarJad_an.jad_er = this.jad_an[i];
                    jad_boVarJad_an.jad_bo = jad_fsVarJad_an;
                    jad_boVarJad_an.jad_cp = 50000;
                    jad_boVarJad_an.jad_dq = 100000;
                    jad_boVarJad_an.jad_jt = jad_iv.this;
                    jad_boVarJad_an.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
                }
            } catch (Exception e) {
                Logger.w("Exception while gw event: ", e.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: EventUploadManager.java */
    public static class jad_cp {
        public static final jad_iv jad_an = new jad_iv();
    }

    public void jad_bo(JSONObject jSONObject) {
        jad_er.jad_an.execute(new jad_an(jSONObject));
    }

    /* JADX WARN: Code duplicated, block: B:122:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:58:0x0149  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v56, types: [int] */
    /* JADX WARN: Type inference failed for: r11v57, types: [int] */
    /* JADX WARN: Type inference failed for: r11v58, types: [int] */
    /* JADX WARN: Type inference failed for: r11v59 */
    /* JADX WARN: Type inference failed for: r11v60 */
    /* JADX WARN: Type inference failed for: r11v61 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:193:0x0337
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static com.jd.ad.sdk.jad_xk.jad_dq jad_an(org.json.JSONObject r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xk.jad_iv.jad_an(org.json.JSONObject):com.jd.ad.sdk.jad_xk.jad_dq");
    }

    public static jad_dq jad_an(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, OapsKey.KEY_TYPE, 5);
        JsonUtils.put(jSONObject, "extp", 1);
        JsonUtils.put(jSONObject, "ercd", Integer.valueOf(com.jd.ad.sdk.jad_wj.jad_an.CRASH_ERROR.jad_an));
        JsonUtils.put(jSONObject, "erin", str);
        JsonUtils.put(jSONObject, "crt", Integer.valueOf(i));
        return jad_an(jSONObject);
    }

    public final synchronized void jad_an(String str) {
        try {
            ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue = this.jad_cp;
            if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty() && !this.jad_an.get()) {
                if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
                    return;
                }
                this.jad_an.set(true);
                Iterator<jad_dq> it = this.jad_cp.iterator();
                for (int i = 0; i < this.jad_bo.get(); i++) {
                    if (it.hasNext()) {
                        this.jad_er.add(it.next());
                    }
                }
                if (this.jad_er.isEmpty()) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                byte[] bArrJad_an = jad_jt.jad_an(this.jad_er);
                if (bArrJad_an == null) {
                    return;
                }
                com.jd.ad.sdk.jad_zm.jad_er jad_erVar = new com.jd.ad.sdk.jad_zm.jad_er(bArrJad_an);
                com.jd.ad.sdk.jad_zm.jad_fs jad_fsVarJad_an = jad_jt.jad_an();
                jad_ly.jad_bo jad_boVarJad_an = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
                jad_boVarJad_an.jad_er = str;
                jad_boVarJad_an.jad_fs = jad_erVar;
                jad_boVarJad_an.jad_bo = jad_fsVarJad_an;
                jad_boVarJad_an.jad_cp = 50000;
                jad_boVarJad_an.jad_dq = 100000;
                jad_boVarJad_an.jad_jt = this;
                jad_boVarJad_an.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
                jad_an();
            }
        } catch (Exception unused) {
            this.jad_an.set(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ae A[Catch: all -> 0x003b, Exception -> 0x003e, TryCatch #1 {Exception -> 0x003e, blocks: (B:16:0x002a, B:18:0x002e, B:20:0x0034, B:34:0x008b, B:36:0x008f, B:45:0x00ae, B:41:0x00a4, B:43:0x00a8, B:47:0x00b5, B:49:0x00b9, B:51:0x00bf, B:52:0x00c4), top: B:87:0x0021, outer: #5 }] */
    public final void jad_an() {
        ContentResolver contentResolverJad_an;
        if (this.jad_er.isEmpty()) {
            return;
        }
        ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue = this.jad_cp;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.removeAll(this.jad_er);
        }
        if (this.jad_fs) {
            com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar = this.jad_dq;
            if (jad_cpVar != null) {
                ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue2 = this.jad_er;
                synchronized (jad_cpVar) {
                    try {
                        try {
                            jad_cpVar.getWritableDatabase();
                            if (!jad_cpVar.jad_bo()) {
                                SQLiteDatabase sQLiteDatabase = jad_cpVar.jad_an;
                                if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                                    jad_cpVar.jad_an.endTransaction();
                                }
                            } else {
                                jad_cpVar.jad_an.beginTransaction();
                                for (jad_dq jad_dqVar : concurrentLinkedQueue2) {
                                    int i = jad_dqVar.jad_an;
                                    if (i > 0) {
                                        jad_cpVar.jad_an.delete("events", "_id=?", new String[]{String.valueOf(i)});
                                    } else {
                                        jad_cpVar.jad_an.delete("events", "event=?", new String[]{ANEProxy.ja(jad_dqVar.jad_an().toString())});
                                    }
                                }
                                jad_cpVar.jad_an.setTransactionSuccessful();
                                SQLiteDatabase sQLiteDatabase2 = jad_cpVar.jad_an;
                                if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                                    jad_cpVar.jad_an.endTransaction();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            Logger.w("Exception while clearing events: ", th.getMessage());
                            SQLiteDatabase sQLiteDatabase3 = jad_cpVar.jad_an;
                            if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                                jad_cpVar.jad_an.endTransaction();
                            }
                        } catch (Throwable th2) {
                            SQLiteDatabase sQLiteDatabase4 = jad_cpVar.jad_an;
                            if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                                jad_cpVar.jad_an.endTransaction();
                            }
                            throw th2;
                        }
                    }
                }
            }
        } else {
            ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue3 = this.jad_er;
            String str = this.jad_jt;
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                try {
                    if (!TextUtils.isEmpty(str) && concurrentLinkedQueue3 != null && concurrentLinkedQueue3.size() != 0 && (contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an()) != null) {
                        Uri uri = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event/remove");
                        for (jad_dq jad_dqVar2 : concurrentLinkedQueue3) {
                            int i2 = jad_dqVar2.jad_an;
                            if (i2 > 0) {
                                contentResolverJad_an.delete(uri, "_id=?", new String[]{String.valueOf(i2)});
                            } else {
                                contentResolverJad_an.delete(uri, "event=?", new String[]{ANEProxy.ja(jad_dqVar2.jad_an().toString())});
                            }
                        }
                    }
                } catch (Exception e2) {
                    Logger.w("Exception while multi process clearing events: ", e2.getMessage());
                }
            }
        }
        this.jad_er.clear();
    }

    public void jad_an(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        jad_er.jad_an.execute(new jad_bo(strArr));
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
    public void jad_an(jad_mz jad_mzVar) {
        com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
        this.jad_an.set(false);
        if (this.jad_cp.size() >= this.jad_bo.get()) {
            com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            jad_an((jad_cpVarJad_cp == null || (jad_dqVar = jad_cpVarJad_cp.jad_bo) == null) ? "" : jad_dqVar.jad_an);
        }
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
    public void jad_an(int i, String str) {
        this.jad_an.set(false);
    }
}
