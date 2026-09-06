package com.ubix.ssp.ad.e.a0.d0;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getFilesDir() != null ? context.getFilesDir().getPath() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
