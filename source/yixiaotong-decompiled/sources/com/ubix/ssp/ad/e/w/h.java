package com.ubix.ssp.ad.e.w;

import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8903a;
    private static boolean b;
    private static boolean c;

    private static int a(byte[] bArr, int i) {
        int iMin = Math.min(i + 4000, bArr.length - 1);
        for (int i2 = iMin; i2 > iMin + AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo; i2--) {
            if (bArr[i2] == 10) {
                return i2;
            }
        }
        return iMin;
    }

    public static void a(Exception exc) {
        if (!b || c || exc == null) {
            return;
        }
        Log.e("Monitor.Exception", "", exc);
    }

    public static void a(String str, String str2) {
        if (!f8903a || c) {
            return;
        }
        b(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!b || c) {
            return;
        }
        b(str, str2, th);
    }

    public static void a(boolean z) {
        c = z;
    }

    public static boolean a() {
        return b;
    }

    public static void b(String str, String str2) {
        if (!b || c) {
            return;
        }
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        String str3 = null;
        if (str2 != null) {
            try {
                byte[] bytes = str2.getBytes();
                int length = bytes.length;
                if (length <= 4000) {
                    Log.i(str, str2, th);
                    return;
                }
                int i = 0;
                while (i < length + AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo) {
                    int iA = a(bytes, i);
                    int i2 = iA - i;
                    Log.i(str, new String(bytes, i, i2), null);
                    if (i2 < 4000) {
                        iA++;
                    }
                    i = iA;
                }
                if (length <= i) {
                    return;
                } else {
                    str3 = new String(bytes, i, length - i);
                }
            } catch (Exception e) {
                a(e);
                return;
            }
        }
        Log.i(str, str3, th);
    }

    public static void b(boolean z) {
        b = z;
    }
}
