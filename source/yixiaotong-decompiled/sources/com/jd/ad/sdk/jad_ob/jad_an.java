package com.jd.ad.sdk.jad_ob;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;

/* JADX INFO: compiled from: ANRequestBuilder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static long jad_an() {
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        Class cls = Long.TYPE;
        jad_anVar.getClass();
        Object objJad_an = TextUtils.isEmpty("cat") ? null : jad_anVar.jad_an(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("cat").append(JADYunSdk.getAppId()).toString(), cls);
        long jLongValue = (objJad_an == null || !(objJad_an instanceof Long)) ? 0L : ((Long) objJad_an).longValue();
        if (com.jd.ad.sdk.jad_re.jad_an.jad_bo()) {
            return jLongValue;
        }
        return 0L;
    }
}
