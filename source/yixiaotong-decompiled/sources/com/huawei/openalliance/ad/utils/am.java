package com.huawei.openalliance.ad.utils;

import java.math.BigDecimal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class am {
    public static Double Code(Double d, int i, int i2) {
        if (d == null || Double.isInfinite(d.doubleValue()) || Double.isNaN(d.doubleValue())) {
            return null;
        }
        return Double.valueOf(new BigDecimal(d.doubleValue()).setScale(i, i2).doubleValue());
    }
}
