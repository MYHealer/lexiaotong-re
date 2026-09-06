package com.opos.mobad.activity.webview.a.a;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f6616a = new byte[0];
    private static volatile ExecutorService b;

    public static int a() {
        return 107;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return false;
            }
            return com.opos.cmn.biz.b.a.a(context, str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("JSUtils", "", (Throwable) e);
            return false;
        }
    }
}
