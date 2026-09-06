package com.jd.ad.sdk.jad_fq;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv {
    public static String jad_an(double d) {
        float fLog;
        float fRandom = (float) Math.random();
        double d2 = fRandom;
        if (d2 <= 0.5d) {
            fLog = (float) (Math.log(1.0f - fRandom) * ((double) (-0.001f)));
        } else {
            fLog = (float) (Math.log(d2) * ((double) 0.001f));
        }
        try {
            return new DecimalFormat("0.000000").format(((double) fLog) + d);
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }
}
