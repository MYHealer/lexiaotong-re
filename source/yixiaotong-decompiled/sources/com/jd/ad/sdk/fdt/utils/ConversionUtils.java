package com.jd.ad.sdk.fdt.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ConversionUtils {
    public static double floatToDouble(float f) {
        try {
            return Double.valueOf(String.valueOf(f)).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
