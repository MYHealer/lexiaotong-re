package com.hihonor.hianalytics.hnha;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class m2 {
    public static String a(int i) {
        if (i == 2) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
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
