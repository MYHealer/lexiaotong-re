package com.jd.ad.sdk.jad_uh;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SPUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_dq {
    public static final Map<String, jad_dq> jad_bo = new HashMap();
    public final SharedPreferences jad_an;

    public jad_dq(String str, int i) {
        this.jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getSharedPreferences(str, i);
    }

    public static jad_dq jad_an(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "spUtils";
                break;
            }
            if (!Character.isWhitespace(str.charAt(i))) {
                break;
            }
            i++;
        }
        Map<String, jad_dq> map = jad_bo;
        jad_dq jad_dqVar = (jad_dq) ((HashMap) map).get(str);
        if (jad_dqVar == null) {
            synchronized (jad_dq.class) {
                jad_dqVar = (jad_dq) ((HashMap) map).get(str);
                if (jad_dqVar == null) {
                    jad_dqVar = new jad_dq(str, 0);
                    ((HashMap) map).put(str, jad_dqVar);
                }
            }
        }
        return jad_dqVar;
    }
}
