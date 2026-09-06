package com.miui.zeus.landingpage.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.m;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LandingPageHelper {
    private static final String TAG = s.d(new byte[]{46, 89, 86, 2, 81, 92, 6, 52, 7, 5, 84, 45, 7, 84, 72, 3, 74}, "b88f82");
    public static final String PRE_LOCALPATH_STRATEGY_URL_MD5 = s.d(new byte[]{124, 33, 83}, "1efede");
    public static final String PRE_LOCALPATH_STRATEGY_PATH = s.d(new byte[]{96, 120, 103, 121}, "093119");
    public static final String PRE_LOCALPATH_STRATEGY_URL_MIMO = s.d(new byte[]{124, 44, 127, 41}, "1e2fdf");

    public static boolean land(String str) {
        return land(str, false);
    }

    public static boolean land(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            m.b(TAG, s.d(new byte[]{77, Ascii.DC4, 88, Ascii.DC2, 88, Ascii.SYN, 65, 1, 11, Ascii.DC2, 69, Ascii.FS}, "8f421e"));
            return false;
        }
        boolean zA = d.a(str, z, -1);
        m.a(TAG, s.d(new byte[]{17, 93, 65, 76, 14, 65, 92}, "c829b5") + zA);
        return zA;
    }

    public static boolean land(String str, boolean z, int i) {
        if (TextUtils.isEmpty(str)) {
            m.b(TAG, s.d(new byte[]{16, 65, 85, Ascii.NAK, 88, 16, 65, 1, 11, Ascii.DC2, 69, Ascii.FS}, "e3951c"));
            return false;
        }
        boolean zA = d.a(str, z, i);
        m.a(TAG, s.d(new byte[]{69, 81, 66, 65, 88, 70, 92}, "741442") + zA);
        return zA;
    }

    public static void preLoadWithLocalPath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            m.b(TAG, s.d(new byte[]{65, 87, 65, 93, Ascii.DC4, 93, Ascii.DC2, 68, 3, 15, 65, 17, 72}, "165544"));
        } else {
            e.a(str, str2);
        }
    }

    public static void preLoadWithWebView(String str) {
        if (TextUtils.isEmpty(str)) {
            m.b(TAG, s.d(new byte[]{67, Ascii.DC4, 89, 68, 8, 71, 65, 1, 11, Ascii.DC2, 69, Ascii.FS}, "6f5da4"));
        } else {
            e.b(str);
        }
    }

    public static void registerAppLaunchListener(OnAppLaunchListener onAppLaunchListener) {
        a.a().a(onAppLaunchListener);
    }

    public static void registerDownloadListener(DownloadListener downloadListener) {
        b.a().a(downloadListener);
    }

    public static void unRegisterAppLaunchListener(OnAppLaunchListener onAppLaunchListener) {
        a.a().b(onAppLaunchListener);
    }

    public static void unRegisterDownloadListener(DownloadListener downloadListener) {
        b.a().b(downloadListener);
    }
}
