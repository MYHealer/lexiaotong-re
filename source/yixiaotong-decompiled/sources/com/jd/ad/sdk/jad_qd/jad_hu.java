package com.jd.ad.sdk.jad_qd;

import android.os.Build;

/* JADX INFO: compiled from: JADOSIntoUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public static long jad_an;

    public static boolean jad_er() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            int iMax = 10;
            if (jad_anVarJad_an != null) {
                iMax = Math.max(10, jad_anVarJad_an.jad_wj);
            }
            long j = iMax * 1000;
            long j2 = jad_an;
            return j2 == 0 || jCurrentTimeMillis - j2 > j;
        } catch (Exception unused) {
            return true;
        }
    }

    public static int jad_fs() {
        if (!jad_fs.jad_an.jad_an.jad_an("tbAppInstalled")) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("tbAppInstalled", true)) {
            return jad_anVar.jad_cp("tbAppInstalled");
        }
        if (!jad_er()) {
            return -1;
        }
        jad_an = System.currentTimeMillis();
        boolean zJad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.taobao.taobao");
        jad_anVar.jad_bo("tbAppInstalled", Integer.valueOf(zJad_an ? 1 : 0));
        return zJad_an ? 1 : 0;
    }

    public static int jad_jt() {
        if (!jad_fs.jad_an.jad_an.jad_an("wcAppInstalled")) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("wcAppInstalled", true)) {
            return jad_anVar.jad_cp("wcAppInstalled");
        }
        if (!jad_er()) {
            return -1;
        }
        jad_an = System.currentTimeMillis();
        boolean zJad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.tencent.mm");
        jad_anVar.jad_bo("wcAppInstalled", Integer.valueOf(zJad_an ? 1 : 0));
        return zJad_an ? 1 : 0;
    }

    public static String jad_an() {
        String str = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("osVersion")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("osVersion", true)) {
                return jad_anVar.jad_dq("osVersion");
            }
            str = Build.VERSION.RELEASE;
            jad_anVar.jad_bo("osVersion", str);
            return str;
        } catch (Exception unused) {
        }
    }

    public static String jad_bo() {
        String strJad_dq = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("osUpdateTime")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("osUpdateTime", true)) {
                strJad_dq = jad_anVar.jad_dq("osUpdateTime");
            } else {
                strJad_dq = "" + Build.TIME;
                jad_anVar.jad_bo("osUpdateTime", strJad_dq);
            }
        } catch (Exception unused) {
        }
        return strJad_dq;
    }

    public static String jad_cp() {
        if (!jad_fs.jad_an.jad_an.jad_an("osApiVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osApiVersion", true)) {
            return jad_anVar.jad_dq("osApiVersion");
        }
        String string = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("").append(Build.VERSION.SDK_INT).toString();
        jad_anVar.jad_bo("osApiVersion", string);
        return string;
    }

    public static String jad_dq() {
        String str = "";
        try {
            if (!jad_fs.jad_an.jad_an.jad_an("ua")) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("ua", true)) {
                return jad_anVar.jad_dq("ua");
            }
            str = System.getProperty("http.agent") + " JADYunSDK/2.6.32";
            jad_anVar.jad_bo("ua", str);
            return str;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    public static synchronized int jad_an(boolean z) {
        int iJad_an = -1;
        if (!jad_fs.jad_an.jad_an.jad_an("jdAppInstalled")) {
            return -1;
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("jdAppInstalled", true) && !jad_er()) {
            iJad_an = jad_anVar.jad_cp("jdAppInstalled");
        } else if (z) {
            iJad_an = com.jd.ad.sdk.jad_fq.jad_bo.jad_an("com.jingdong.app.mall");
            jad_anVar.jad_bo("jdAppInstalled", Integer.valueOf((int) iJad_an));
            jad_an = System.currentTimeMillis();
        }
        return iJad_an;
    }
}
