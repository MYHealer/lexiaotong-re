package com.byazt.wi;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.bwm.sp;
import com.byazt.ete.x;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.br;
import com.umeng.analytics.pro.aq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 983, 13})
public class tt {
    public static final tt c = new tt();
    public final LruCache<String, c> tt = new LruCache<>(64);
    public final ConcurrentHashMap<String, Boolean> ve = new ConcurrentHashMap<>();

    public static tt c() {
        return c;
    }

    public long c(int i, String str) {
        long j;
        x.ve veVarC = x.c(i);
        if (veVarC != null && veVarC.nu() != null) {
            x.n nVarNu = veVarC.nu();
            if (nVarNu.tt() && nVarNu.ve() > 0) {
                String strC = c(nVarNu, i, str);
                if (TextUtils.isEmpty(strC)) {
                    return -1L;
                }
                c cVar = this.tt.get(strC);
                if (cVar == null) {
                    j = -1;
                } else {
                    if (!cVar.c(nVarNu)) {
                        return cVar.c;
                    }
                    j = cVar.c;
                }
                c cVarC = c(strC);
                if (cVarC != null) {
                    if (!cVarC.c(nVarNu)) {
                        this.tt.put(strC, cVarC);
                        return cVarC.c;
                    }
                    j = cVarC.c;
                }
                long j2 = j;
                c(strC, nVarNu, i, str, j2);
                if (j2 > 0) {
                    return j2;
                }
            }
        }
        return -1L;
    }

    private void c(final String str, final x.n nVar, final int i, final String str2, final long j) {
        if (this.ve.putIfAbsent(str, Boolean.TRUE) != null) {
            return;
        }
        com.byazt.bzd.x.c(new sp("dynamic_tmax_calc") { // from class: com.byazt.wi.tt.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c cVarC = tt.this.c(nVar, i, str2, j);
                    if (cVarC != null) {
                        tt.this.tt.put(str, cVarC);
                        tt.this.c(str, cVarC);
                    }
                } finally {
                    tt.this.ve.remove(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:131:0x0272 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x0279 A[Catch: all -> 0x0290, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0290, blocks: (B:17:0x0034, B:23:0x0054, B:32:0x006c, B:33:0x0077, B:35:0x007d, B:37:0x0083, B:39:0x0091, B:41:0x0099, B:43:0x00a1, B:45:0x00ab, B:49:0x00b8, B:51:0x00c4, B:54:0x00cf, B:60:0x00de, B:62:0x00e9, B:68:0x00f6, B:70:0x00ff, B:71:0x0102, B:73:0x0124, B:76:0x012c, B:79:0x0137, B:83:0x0143, B:85:0x014e, B:89:0x0195, B:91:0x019b, B:92:0x019e, B:96:0x01ab, B:98:0x01b1, B:103:0x01ca, B:105:0x01d4, B:113:0x01fa, B:115:0x020c, B:116:0x022b, B:118:0x023c, B:128:0x0260, B:135:0x0279, B:120:0x0246, B:122:0x024e, B:95:0x01a7, B:88:0x018f), top: B:157:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0274 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    public c c(x.n nVar, int i, String str, long j) {
        Cursor cursorC;
        long j2;
        long jC;
        long jCurrentTimeMillis = System.currentTimeMillis() - 604800000;
        long j3 = 0;
        if (jCurrentTimeMillis <= 0) {
            return null;
        }
        try {
            if (nVar.n() != 0) {
                cursorC = n.c(i, jCurrentTimeMillis, "record_time DESC");
            } else {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                cursorC = n.c(i, str, jCurrentTimeMillis, "record_time DESC");
            }
            if (cursorC == null) {
                if (cursorC != null) {
                    try {
                        cursorC.close();
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int columnIndex = cursorC.getColumnIndex("loaded_duration");
                int columnIndex2 = cursorC.getColumnIndex("is_shown");
                if (columnIndex >= 0 && columnIndex2 >= 0) {
                    long jVe = j <= 0 ? nVar.ve() : j;
                    if (jVe <= 0) {
                        if (cursorC != null) {
                            try {
                                cursorC.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return null;
                    }
                    long jFloor = (long) Math.floor(jVe * 0.8d);
                    long j4 = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (cursorC.moveToNext() && i3 < nVar.sp()) {
                        i3++;
                        long j5 = cursorC.getLong(columnIndex);
                        int i6 = cursorC.getInt(columnIndex2);
                        if (j5 > j3 && j5 >= nVar.uj() && j5 <= nVar.ve()) {
                            arrayList.add(Long.valueOf(j5));
                            if (i6 == 1) {
                                arrayList2.add(Long.valueOf(j5));
                            }
                        }
                        if (j5 <= j3 || j5 > jVe) {
                            j4 = j4;
                        } else {
                            i4++;
                            j4 += j5;
                            i5++;
                            if (j5 >= jFloor) {
                                i2++;
                            }
                        }
                        j3 = 0;
                    }
                    long j6 = j4;
                    if (arrayList.isEmpty()) {
                        if (cursorC == null) {
                            return null;
                        }
                        try {
                            cursorC.close();
                            return null;
                        } catch (Throwable unused3) {
                            return null;
                        }
                    }
                    int iMax = Math.max(0, nVar.a());
                    if (iMax > 0 && arrayList.size() < iMax) {
                        if (cursorC == null) {
                            return null;
                        }
                        try {
                            cursorC.close();
                            return null;
                        } catch (Throwable unused4) {
                            return null;
                        }
                    }
                    Collections.sort(arrayList);
                    if (!arrayList2.isEmpty()) {
                        Collections.sort(arrayList2);
                    }
                    com.byazt.wi.c.c(arrayList, (int) (nVar.i() * 100.0f));
                    long jC2 = com.byazt.wi.c.c(arrayList, (int) (nVar.da() * 100.0f));
                    com.byazt.wi.c.c(arrayList, (int) (nVar.sl() * 100.0f));
                    float f = i3 > 0 ? (i4 * 1.0f) / i3 : 0.0f;
                    float f2 = i5 > 0 ? ((j6 * 1.0f) / i5) / jVe : 0.0f;
                    float f3 = i4 > 0 ? (i2 * 1.0f) / i4 : 0.0f;
                    float f4 = jC2 > 0 ? ((jVe - jC2) * 1.0f) / jC2 : 0.0f;
                    int iMin = Math.min(99, Math.max(1, Math.round(nVar.u() * 100.0f)));
                    int iMin2 = Math.min(99, Math.max(1, Math.round(nVar.yp() * 100.0f)));
                    int iMin3 = Math.min(99, Math.max(1, Math.round(nVar.z() * 100.0f)));
                    long jC3 = arrayList2.isEmpty() ? 0L : com.byazt.wi.c.c(arrayList2, iMin);
                    if (!arrayList2.isEmpty()) {
                        com.byazt.wi.c.c(arrayList2, iMin2);
                    }
                    long jC4 = arrayList2.isEmpty() ? 0L : com.byazt.wi.c.c(arrayList2, iMin3);
                    float size = !arrayList.isEmpty() ? (arrayList2.size() * 1.0f) / arrayList.size() : 0.0f;
                    float f5 = (jC4 <= 0 || jC2 <= 0) ? 0.0f : (jC4 * 1.0f) / jC2;
                    long jC5 = c(jVe, jC2, f, f2, f3, f4, nVar);
                    if (arrayList2.size() < 5 || size <= 0.02f || f5 <= 0.0f || f5 >= 0.95f) {
                        if (f4 <= nVar.nu() || f3 >= nVar.rh() || jC3 <= 0) {
                            j2 = jC5;
                        }
                        jC = com.byazt.wi.c.c(j2, nVar.uj(), nVar.ve());
                        if (jC > 0) {
                            c cVar = new c(jC, System.currentTimeMillis());
                            if (cursorC != null) {
                                try {
                                    cursorC.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            return cVar;
                        }
                        if (cursorC != null) {
                            return null;
                        }
                        try {
                            cursorC.close();
                            return null;
                        } catch (Throwable unused6) {
                            return null;
                        }
                    }
                    float f6 = jC4;
                    long jFloor2 = (long) Math.floor(nVar.t() * f6);
                    if (jFloor2 > 0) {
                        float f7 = jVe;
                        float fMin = (Math.min(1.0f, (Math.abs(jVe - jFloor2) * 1.0f) / f7) * 0.35f) + 0.15f;
                        jC5 = (long) ((f7 * (1.0f - fMin)) + (jFloor2 * fMin));
                    }
                    long jFloor3 = (long) Math.floor(f6 * nVar.m());
                    jC3 = jFloor3 > 0 ? Math.min(jC5, jFloor3) : jC5;
                    j2 = jC3;
                    jC = com.byazt.wi.c.c(j2, nVar.uj(), nVar.ve());
                    if (jC > 0) {
                        if (cursorC != null) {
                            return null;
                        }
                        cursorC.close();
                        return null;
                    }
                    c cVar2 = new c(jC, System.currentTimeMillis());
                    if (cursorC != null) {
                        cursorC.close();
                    }
                    return cVar2;
                }
                if (cursorC == null) {
                    return null;
                }
                try {
                    cursorC.close();
                    return null;
                } catch (Throwable unused7) {
                    return null;
                }
            } catch (Throwable unused8) {
                if (cursorC == null) {
                    return null;
                }
                try {
                    cursorC.close();
                    return null;
                } catch (Throwable unused9) {
                    return null;
                }
            }
        } catch (Throwable unused10) {
            cursorC = null;
        }
    }

    public static long c(long j, long j2, float f, float f2, float f3, float f4, x.n nVar) {
        float f5;
        if (j <= 0 || j2 <= 0) {
            return -1L;
        }
        boolean z = false;
        boolean z2 = f2 < nVar.my() || (f4 > nVar.nu() && f3 < nVar.rh());
        if (f < nVar.gt() || f3 > nVar.qy() || (f4 < nVar.gu() && f < nVar.rl())) {
            z = true;
        }
        if (!z2 || z) {
            if (!z) {
                return j;
            }
            long jCeil = (long) Math.ceil(j2 * 1.15d);
            if (jCeil <= j) {
                return j;
            }
            if (f < 0.85f) {
                f5 = 0.4f;
            } else {
                f5 = f < 0.9f ? 0.25f : 0.15f;
            }
            return Math.min(((long) Math.ceil((jCeil - j) * f5)) + j, (long) Math.floor(j * 1.25d));
        }
        float f6 = 0.1f;
        if (f3 > 0.1f) {
            return j;
        }
        if (f2 < 0.2f) {
            f6 = 0.3f;
        } else if (f2 < 0.3f) {
            f6 = 0.2f;
        } else if (f4 < 0.2f || f4 > 0.3f) {
            f6 = 0.0f;
        }
        return Math.max(Math.max((long) ((j * (1.0f - f6)) + (j2 * f6)), (long) Math.ceil(j * 0.85d)), j2);
    }

    private static String c(x.n nVar, int i, String str) {
        if (nVar == null) {
            return null;
        }
        if (nVar.n() == 0) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "slot_" + i + "_" + str;
        }
        return br.f.R.concat(String.valueOf(i));
    }

    private SharedPreferences tt() {
        return com.byazt.nys.tt.tt(gt.getContext(), "sp_dynamic_tmax_timeout", 0);
    }

    private c c(String str) {
        long jC;
        long jC2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (com.byazt.by.ve.c().tt()) {
                jC = com.byazt.ti.tt.c("sp_dynamic_tmax_timeout", str + "_v", -1L);
                jC2 = com.byazt.ti.tt.c("sp_dynamic_tmax_timeout", str + aq.h, 0L);
            } else {
                SharedPreferences sharedPreferencesTt = tt();
                jC = sharedPreferencesTt.getLong(str + "_v", -1L);
                jC2 = sharedPreferencesTt.getLong(str + aq.h, 0L);
            }
            if (jC <= 0) {
                return null;
            }
            return new c(jC, jC2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        try {
            if (com.byazt.by.ve.c().tt()) {
                com.byazt.ti.tt.c("sp_dynamic_tmax_timeout", str + "_v", Long.valueOf(cVar.c));
                com.byazt.ti.tt.c("sp_dynamic_tmax_timeout", str + aq.h, Long.valueOf(cVar.tt));
            } else {
                SharedPreferences.Editor editorEdit = tt().edit();
                editorEdit.putLong(str + "_v", cVar.c);
                editorEdit.putLong(str + aq.h, cVar.tt);
                editorEdit.apply();
            }
        } catch (Throwable unused) {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 983, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private static class c {
        public final long c;
        public final long tt;

        public c(long j, long j2) {
            this.c = j;
            this.tt = j2;
        }

        public boolean c(x.n nVar) {
            return this.tt <= 0 || System.currentTimeMillis() - this.tt > ((long) nVar.x()) * 1000;
        }
    }
}
