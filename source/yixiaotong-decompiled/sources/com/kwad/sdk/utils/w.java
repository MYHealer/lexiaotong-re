package com.kwad.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class w {
    private static String hE(String str) {
        return bq.i("kssdk_api_pref", str, "");
    }

    public static String bo(Context context) {
        return hE("curversion");
    }
}
