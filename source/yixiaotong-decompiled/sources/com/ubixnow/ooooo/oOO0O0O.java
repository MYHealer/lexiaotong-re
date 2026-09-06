package com.ubixnow.ooooo;

import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO0O0O {
    private static boolean OooO00o = false;
    private static boolean OooO0O0 = false;
    private static boolean OooO0OO = false;
    private static final int OooO0Oo = 4000;

    private static int OooO00o(byte[] bArr, int i) {
        int iMin = Math.min(i + 4000, bArr.length - 1);
        for (int i2 = iMin; i2 > iMin + AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo; i2--) {
            if (bArr[i2] == 10) {
                return i2;
            }
        }
        return iMin;
    }

    public static void OooO00o(Exception exc) {
        if (!OooO0O0 || OooO0OO || exc == null) {
            return;
        }
        Log.e("---埋点，Monitor.Exception", "", exc);
    }

    public static void OooO00o(String str, String str2) {
        if (!OooO00o || OooO0OO) {
            return;
        }
        OooO0OO(str, str2, null);
    }

    public static void OooO00o(String str, String str2, Throwable th) {
        if (!OooO00o || OooO0OO) {
            return;
        }
        OooO0OO(str, str2, th);
    }

    public static void OooO00o(String str, Throwable th) {
        if (!OooO0O0 || OooO0OO) {
            return;
        }
        OooO0OO(str, "", th);
    }

    public static void OooO00o(boolean z) {
        OooO00o = z;
    }

    public static boolean OooO00o() {
        return OooO0O0;
    }

    public static void OooO0O0(String str, String str2) {
        if (!OooO0O0 || OooO0OO) {
            return;
        }
        OooO0OO(str, str2, null);
    }

    public static void OooO0O0(String str, String str2, Throwable th) {
        if (!OooO0O0 || OooO0OO) {
            return;
        }
        OooO0OO(str, str2, th);
    }

    public static void OooO0O0(boolean z) {
        OooO0OO = z;
    }

    public static void OooO0OO(String str, String str2, Throwable th) {
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
                    int iOooO00o = OooO00o(bytes, i);
                    int i2 = iOooO00o - i;
                    Log.i(str, new String(bytes, i, i2), null);
                    if (i2 < 4000) {
                        iOooO00o++;
                    }
                    i = iOooO00o;
                }
                if (length <= i) {
                    return;
                } else {
                    str3 = new String(bytes, i, length - i);
                }
            } catch (Exception e) {
                OooO00o(e);
                return;
            }
        }
        Log.i(str, str3, th);
    }

    public static void OooO0OO(boolean z) {
        OooO0O0 = z;
    }
}
