package com.kwad.library.solder.lib;

import android.util.Log;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static String DH() {
        return "";
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", F(str, str2));
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", F(str, ""), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", F(str, str2), th);
    }

    private static String F(String str, String str2) {
        return "[" + str + "]: " + str2 + PPSLabelView.Code + DH();
    }
}
