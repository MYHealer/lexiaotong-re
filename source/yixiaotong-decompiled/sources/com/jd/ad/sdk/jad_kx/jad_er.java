package com.jd.ad.sdk.jad_kx;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PreloadAdDataCacheHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public com.jd.ad.sdk.jad_kx.jad_an jad_an;
    public jad_fs jad_bo;
    public com.jd.ad.sdk.jad_pc.jad_an jad_er;
    public int jad_cp = 3600;
    public int jad_dq = 2;
    public int jad_fs = 3;
    public boolean jad_jt = true;

    /* JADX INFO: compiled from: PreloadAdDataCacheHelper.java */
    public static class jad_an {
        public static final jad_er jad_an = new jad_er();
    }

    public int jad_bo() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_cp = jad_anVar.jad_kx;
        }
        return this.jad_cp;
    }

    public int jad_cp() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_fs = jad_anVar.jad_mz;
        }
        if (this.jad_fs < 3) {
            this.jad_fs = 3;
        }
        return this.jad_fs;
    }

    public int jad_an() {
        if (this.jad_er == null) {
            this.jad_er = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        }
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_er;
        if (jad_anVar != null) {
            this.jad_dq = jad_anVar.jad_ly;
        }
        return this.jad_dq;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004a A[Catch: all -> 0x005c, DONT_GENERATE, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x000d, B:10:0x0011, B:11:0x0015, B:13:0x001f, B:14:0x0025, B:16:0x0030, B:23:0x0044, B:25:0x004a, B:28:0x004e, B:32:0x005a, B:18:0x0036, B:20:0x003a, B:21:0x003f), top: B:37:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    public boolean jad_bo(String str) {
        List<jad_cp> listJad_an;
        List<jad_cp> listJad_an2;
        com.jd.ad.sdk.jad_kx.jad_an jad_anVar;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        synchronized (this) {
            if (this.jad_jt) {
                if (this.jad_bo == null) {
                    this.jad_bo = jad_fs.jad_an.jad_an;
                }
                listJad_an2 = this.jad_bo.jad_an(str);
                if (this.jad_an == null) {
                    this.jad_an = com.jd.ad.sdk.jad_kx.jad_an.jad_dq();
                }
                this.jad_an.jad_an(this.jad_bo.jad_bo);
                if ((listJad_an2 == null || listJad_an2.size() <= 0) && (jad_anVar = this.jad_an) != null) {
                    listJad_an = jad_anVar.jad_an(str);
                }
                if (jad_an() <= 0) {
                    return true;
                }
                if (listJad_an2 != null || listJad_an2.size() < jad_an()) {
                    z = false;
                }
                return z;
            }
            listJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an(str);
            listJad_an2 = listJad_an;
            if (jad_an() <= 0) {
                return true;
            }
            if (listJad_an2 != null) {
                z = false;
            } else {
                z = false;
            }
            return z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0280  */
    /* JADX WARN: Code duplicated, block: B:133:0x02af A[Catch: all -> 0x02d1, TRY_ENTER, TryCatch #0 {all -> 0x02d1, blocks: (B:92:0x01b9, B:122:0x028b, B:136:0x02b6, B:133:0x02af, B:147:0x02c7, B:149:0x02cd, B:150:0x02d0, B:131:0x0298), top: B:154:0x01b9, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x02be  */
    /* JADX WARN: Code duplicated, block: B:143:0x02c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:80:0x019b  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a1 A[PHI: r12 r13
  0x01a1: PHI (r12v21 com.jd.ad.sdk.jad_kx.jad_cp) = (r12v18 com.jd.ad.sdk.jad_kx.jad_cp), (r12v24 com.jd.ad.sdk.jad_kx.jad_cp) binds: [B:81:0x019f, B:70:0x0177] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r13v4 android.database.Cursor) = (r13v2 android.database.Cursor), (r13v5 android.database.Cursor) binds: [B:81:0x019f, B:70:0x0177] A[DONT_GENERATE, DONT_INLINE]] */
    public String jad_an(String str) {
        Cursor cursorQuery;
        jad_cp jad_cpVar;
        jad_cp jad_cpVar2;
        jad_cp jad_cpVar3;
        Cursor cursor;
        jad_cp jad_cpVar4;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (this.jad_jt) {
            if (this.jad_bo == null) {
                this.jad_bo = jad_fs.jad_an.jad_an;
            }
            jad_fs jad_fsVar = this.jad_bo;
            Map<String, ArrayList<jad_cp>> map = jad_fsVar.jad_an;
            ArrayList<jad_cp> arrayList = map != null ? map.get(str) : null;
            if (arrayList != null && arrayList.size() > 0) {
                jad_fsVar.jad_bo.clear();
                jad_fsVar.jad_cp.clear();
                long jCurrentTimeMillis = System.currentTimeMillis() - (((long) jad_an.jad_an.jad_bo()) * 1000);
                Iterator<jad_cp> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        jad_cpVar3 = null;
                        break;
                    }
                    jad_cp next = it.next();
                    if (next != null) {
                        int i = next.jad_an;
                        String str2 = next.jad_er;
                        String str3 = next.jad_dq;
                        String str4 = next.jad_bo;
                        if (!TextUtils.isEmpty(str3) && Long.parseLong(str2) >= jCurrentTimeMillis) {
                            jad_cp jad_cpVar5 = new jad_cp(i, str, str4, str3, str2);
                            jad_fsVar.jad_cp.add(str4);
                            it.remove();
                            jad_cpVar3 = jad_cpVar5;
                            break;
                        }
                        jad_fsVar.jad_bo.add(str4);
                        it.remove();
                    }
                }
            } else {
                jad_cpVar3 = null;
                break;
            }
            if (this.jad_an == null) {
                this.jad_an = com.jd.ad.sdk.jad_kx.jad_an.jad_dq();
            }
            this.jad_an.jad_an(this.jad_bo.jad_bo);
            if (jad_cpVar3 != null) {
                this.jad_an.jad_an(this.jad_bo.jad_cp);
                return jad_cpVar3.jad_dq;
            }
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = this.jad_an;
            if (jad_anVar != null) {
                try {
                    jad_anVar.getReadableDatabase();
                    if (jad_anVar.jad_bo()) {
                        Cursor cursorQuery2 = jad_anVar.jad_an.query("preloadAd", null, "appIdSlotId =?", new String[]{String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
                        try {
                            if (cursorQuery2.getCount() > 0) {
                                cursorQuery2.moveToFirst();
                                long jCurrentTimeMillis2 = System.currentTimeMillis() - (((long) jad_an.jad_an.jad_bo()) * 1000);
                                while (true) {
                                    if (cursorQuery2.isAfterLast()) {
                                        jad_cpVar4 = null;
                                        break;
                                    }
                                    int i2 = cursorQuery2.getInt(cursorQuery2.getColumnIndex("_id"));
                                    String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("preloadAdCacheTimeStamp"));
                                    String string2 = cursorQuery2.getString(cursorQuery2.getColumnIndex("rId"));
                                    String strJb = ANEProxy.jb(cursorQuery2.getString(cursorQuery2.getColumnIndex("preloadAdJson")));
                                    if (!TextUtils.isEmpty(strJb) && Long.parseLong(string) >= jCurrentTimeMillis2) {
                                        jad_cp jad_cpVar6 = new jad_cp(i2, str, string2, strJb, string);
                                        try {
                                            jad_anVar.jad_bo.add(string2);
                                            jad_cpVar4 = jad_cpVar6;
                                            break;
                                        } catch (Throwable th) {
                                            th = th;
                                            jad_cpVar = jad_cpVar6;
                                            try {
                                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(th.getMessage()));
                                                if (cursorQuery2 != null && !cursorQuery2.isClosed()) {
                                                    cursorQuery2.close();
                                                }
                                            } catch (Throwable th2) {
                                                if (cursorQuery2 != null && !cursorQuery2.isClosed()) {
                                                    cursorQuery2.close();
                                                }
                                                throw th2;
                                            }
                                        }
                                    }
                                    ((ArrayList) com.jd.ad.sdk.jad_kx.jad_an.jad_dq).add(string2);
                                    cursorQuery2.moveToNext();
                                }
                                try {
                                    cursorQuery2.close();
                                    WorkExecutor.execute(new jad_bo(jad_anVar));
                                    jad_cpVar = jad_cpVar4;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor = cursorQuery2;
                                    cursorQuery2 = cursor;
                                    jad_cpVar = jad_cpVar4;
                                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
                                    if (cursorQuery2 != null) {
                                        cursorQuery2.close();
                                    }
                                }
                            } else {
                                jad_cpVar = null;
                            }
                            if (!cursorQuery2.isClosed()) {
                                cursorQuery2.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = cursorQuery2;
                            jad_cpVar4 = null;
                            cursorQuery2 = cursor;
                            jad_cpVar = jad_cpVar4;
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(th.getMessage()));
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            if (jad_cpVar != null) {
                                return jad_cpVar.jad_dq;
                            }
                            return "";
                        }
                    } else {
                        jad_cpVar = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = null;
                }
            } else {
                jad_cpVar = jad_cpVar3;
            }
        } else {
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                try {
                    String str5 = com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_preload_ad/query/" + str;
                    ((ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_an).clear();
                    ((ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_bo).clear();
                    try {
                        ContentResolver contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                        if (contentResolverJad_an == null) {
                            jad_cpVar = null;
                        } else {
                            cursorQuery = contentResolverJad_an.query(Uri.parse(str5), null, null, null, "preloadAdCacheTimeStamp ASC");
                            if (cursorQuery != null) {
                                try {
                                    if (cursorQuery.getCount() > 0) {
                                        long jCurrentTimeMillis3 = System.currentTimeMillis() - (((long) jad_an.jad_an.jad_bo()) * 1000);
                                        cursorQuery.moveToFirst();
                                        while (true) {
                                            if (cursorQuery.isAfterLast()) {
                                                jad_cpVar = null;
                                                break;
                                            }
                                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("appIdSlotId"));
                                            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("rId"));
                                            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdCacheTimeStamp"));
                                            String strJb2 = ANEProxy.jb(cursorQuery.getString(cursorQuery.getColumnIndex("preloadAdJson")));
                                            if (!TextUtils.isEmpty(strJb2) && Long.parseLong(string5) >= jCurrentTimeMillis3) {
                                                jad_cpVar2 = new jad_cp(i3, string3, string4, strJb2, string5);
                                                try {
                                                    ((ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_bo).add(string4);
                                                    jad_cpVar = jad_cpVar2;
                                                    break;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    try {
                                                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                                        com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar5.jad_an, jad_anVar5.jad_an(th.getMessage()));
                                                        if (cursorQuery != null) {
                                                        }
                                                        jad_cpVar = jad_cpVar2;
                                                    } catch (Throwable th7) {
                                                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                                                            cursorQuery.close();
                                                        }
                                                        throw th7;
                                                    }
                                                }
                                            }
                                            ((ArrayList) com.jd.ad.sdk.jad_tg.jad_an.jad_an).add(string4);
                                            cursorQuery.moveToNext();
                                        }
                                        try {
                                            cursorQuery.close();
                                        } catch (Throwable th8) {
                                            th = th8;
                                            jad_cpVar2 = jad_cpVar;
                                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar6.jad_an, jad_anVar6.jad_an(th.getMessage()));
                                            if (cursorQuery != null || cursorQuery.isClosed()) {
                                                jad_cpVar = jad_cpVar2;
                                            } else {
                                                jad_cpVar = jad_cpVar2;
                                                cursorQuery.close();
                                            }
                                        }
                                    } else {
                                        jad_cpVar = null;
                                    }
                                    WorkExecutor.execute(new com.jd.ad.sdk.jad_tg.jad_bo());
                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                        cursorQuery.close();
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    jad_cpVar = null;
                                    jad_cpVar2 = jad_cpVar;
                                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar7.jad_an, jad_anVar7.jad_an(th.getMessage()));
                                    if (cursorQuery != null) {
                                    }
                                    jad_cpVar = jad_cpVar2;
                                    if (jad_cpVar != null) {
                                        return jad_cpVar.jad_dq;
                                    }
                                    return "";
                                }
                            } else {
                                jad_cpVar = null;
                                WorkExecutor.execute(new com.jd.ad.sdk.jad_tg.jad_bo());
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        cursorQuery = null;
                    }
                } catch (Throwable th11) {
                    throw th11;
                }
            }
        }
        if (jad_cpVar != null) {
            return jad_cpVar.jad_dq;
        }
        return "";
    }
}
