package client.android.yixiaotong.zksoundwave.b;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f973a;

    public static void a(String str, String str2) {
        if (f973a) {
            Log.v(str, str2);
        }
    }

    public static void a(boolean z) {
        f973a = z;
    }

    public static void b(String str, String str2) {
        if (f973a) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f973a) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f973a) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f973a) {
            Log.e(str, str2);
        }
    }
}
