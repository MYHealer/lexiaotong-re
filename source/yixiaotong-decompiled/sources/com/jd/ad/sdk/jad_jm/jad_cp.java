package com.jd.ad.sdk.jad_jm;

import java.io.Closeable;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static final /* synthetic */ int jad_an = 0;

    public class jad_an extends ThreadLocal<DecimalFormat> {
        @Override // java.lang.ThreadLocal
        public DecimalFormat initialValue() {
            try {
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
                decimalFormat.applyPattern("0.0");
                return decimalFormat;
            } catch (Exception unused) {
                return new DecimalFormat("0.0");
            }
        }
    }

    static {
        new jad_an();
    }

    public static void jad_an(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
