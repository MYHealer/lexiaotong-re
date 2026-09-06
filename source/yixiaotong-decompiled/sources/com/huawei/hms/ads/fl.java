package com.huawei.hms.ads;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class fl {
    public static final int Code = 3;
    public static final int I = 5;
    public static final int V = 4;
    public static final int Z = 6;

    public static String Code(int i) {
        if (i == 3) {
            return "D";
        }
        if (i == 4) {
            return "I";
        }
        if (i != 5) {
            return i != 6 ? String.valueOf(i) : ExifInterface.LONGITUDE_EAST;
        }
        return "W";
    }
}
