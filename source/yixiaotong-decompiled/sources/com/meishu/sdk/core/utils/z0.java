package com.meishu.sdk.core.utils;

import android.content.Context;

/* JADX INFO: compiled from: ResourceHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class z0 {
    public static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }
}
