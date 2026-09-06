package com.hihonor.adsdk.common.f.e0;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final b hnadsa = new b();
    private static final char hnadsb = 'H';

    public static byte[] hnadsa(byte[] bArr, int i, int i2) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                hnadsa.hnadsb(bArr, i, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            throw new a("exception encoding Hex string: " + e.getMessage(), e);
        }
    }

    public static String hnadsb(byte[] bArr, int i, int i2) {
        return e.hnadsb(hnadsa(bArr, i, i2));
    }

    public static String hnadsc(byte[] bArr) {
        return hnadsb(bArr, 0, bArr.length);
    }

    private static void hnadsd(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 72);
        }
    }

    public static byte[] hnadsb(byte[] bArr) {
        return hnadsa(bArr, 0, bArr.length);
    }

    public static void hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        hnadsd(bytes);
        Log.i("TAG-encode", Arrays.toString(bytes));
    }

    public static String hnadsa(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        hnadsd(bArrCopyOf);
        return new String(bArrCopyOf, StandardCharsets.UTF_8);
    }
}
