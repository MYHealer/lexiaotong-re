package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class DevTools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8502a;

    public String getDemoGameUrl() {
        String str = this.f8502a;
        this.f8502a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f8502a = str;
        }
    }
}
