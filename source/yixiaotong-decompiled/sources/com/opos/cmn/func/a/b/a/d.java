package com.opos.cmn.func.a.b.a;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f6082a = "";

    public static String a(Context context) {
        return TextUtils.isEmpty(f6082a) ? com.opos.cmn.biz.a.d.a(context) : f6082a;
    }
}
