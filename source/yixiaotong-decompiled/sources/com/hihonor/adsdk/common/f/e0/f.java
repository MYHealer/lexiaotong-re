package com.hihonor.adsdk.common.f.e0;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    private static final byte hnadsa = 0;
    private static final byte hnadsb = 1;
    private static final byte hnadsc = 2;
    private static final byte hnadsd = 3;
    private static final byte hnadse = 4;
    private static final byte hnadsf = 5;
    private static final byte hnadsg = 6;
    private static final byte hnadsh = 7;
    private static final byte hnadsi = 8;
    private static final byte hnadsj = 9;
    private static final byte hnadsk = 10;
    private static final byte hnadsl = -2;
    private static final byte hnadsm = -1;
    private static final byte hnadsn = 0;
    private static final byte hnadso = 16;
    private static final byte hnadsp = 32;
    private static final byte hnadsq = 48;
    private static final byte hnadsr = 64;
    private static final byte hnadss = 80;
    private static final byte hnadst = 96;
    private static final short[] hnadsu = new short[128];
    private static final byte[] hnadsv;

    private static void hnadsa(byte[] bArr, int i, int i2, byte b) {
        while (i <= i2) {
            bArr[i] = b;
            i++;
        }
    }

    public static int hnadsa(byte[] bArr, char[] cArr) {
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                short s = hnadsu[b & 127];
                int i4 = s >>> 8;
                byte b2 = (byte) s;
                while (b2 >= 0) {
                    if (i3 >= bArr.length) {
                        return -1;
                    }
                    int i5 = i3 + 1;
                    byte b3 = bArr[i3];
                    i4 = (i4 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
                    b2 = hnadsv[b2 + ((b3 & 255) >>> 4)];
                    i3 = i5;
                }
                if (b2 == -2) {
                    return -1;
                }
                if (i4 <= 65535) {
                    if (i2 >= cArr.length) {
                        return -1;
                    }
                    cArr[i2] = (char) i4;
                    i2++;
                } else {
                    if (i2 >= cArr.length - 1) {
                        return -1;
                    }
                    int i6 = i2 + 1;
                    cArr[i2] = (char) ((i4 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i2 += 2;
                    cArr[i6] = (char) ((i4 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | Utf8.LOG_SURROGATE_HEADER);
                }
                i = i3;
            } else {
                if (i2 >= cArr.length) {
                    return -1;
                }
                cArr[i2] = (char) b;
                i = i3;
                i2++;
            }
        }
        return i2;
    }

    static {
        byte[] bArr = new byte[112];
        hnadsv = bArr;
        byte[] bArr2 = new byte[128];
        hnadsa(bArr2, 0, 15, (byte) 1);
        hnadsa(bArr2, 16, 31, (byte) 2);
        hnadsa(bArr2, 32, 63, (byte) 3);
        hnadsa(bArr2, 64, 65, (byte) 0);
        hnadsa(bArr2, 66, 95, (byte) 4);
        hnadsa(bArr2, 96, 96, (byte) 5);
        hnadsa(bArr2, 97, 108, (byte) 6);
        hnadsa(bArr2, 109, 109, (byte) 7);
        hnadsa(bArr2, 110, 111, (byte) 6);
        hnadsa(bArr2, 112, 112, (byte) 8);
        hnadsa(bArr2, 113, 115, (byte) 9);
        hnadsa(bArr2, 116, 116, (byte) 10);
        hnadsa(bArr2, AppTypeIdUtil.Drink4GCostControl_1, 127, (byte) 0);
        hnadsa(bArr, 0, 111, (byte) -2);
        hnadsa(bArr, 8, 11, (byte) -1);
        hnadsa(bArr, 24, 27, (byte) 0);
        hnadsa(bArr, 40, 43, (byte) 16);
        hnadsa(bArr, 58, 59, (byte) 0);
        hnadsa(bArr, 72, 73, (byte) 0);
        hnadsa(bArr, 89, 91, (byte) 16);
        hnadsa(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, Ascii.US, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, hnadsq, 16, 64, hnadss, 32, hnadst};
        for (int i = 0; i < 128; i++) {
            byte b = bArr2[i];
            hnadsu[i] = (short) (bArr4[b] | ((bArr3[b] & i) << 8));
        }
    }
}
