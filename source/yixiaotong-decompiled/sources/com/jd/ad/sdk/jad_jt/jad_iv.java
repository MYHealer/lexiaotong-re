package com.jd.ad.sdk.jad_jt;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: TemplateUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv {
    public static int jad_an(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return (int) (new BigDecimal(String.valueOf(i)).divide(new BigDecimal(String.valueOf(i2)), 2, RoundingMode.HALF_UP).floatValue() * 100.0f);
    }
}
