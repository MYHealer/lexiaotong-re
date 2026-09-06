package com.opos.cmn.func.dl.base.exception;

import android.content.Context;
import com.opos.cmn.func.dl.base.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f6134a;
    private static Context b;

    private b(Context context) {
        b = context;
    }

    public static b a(Context context) {
        if (f6134a == null) {
            synchronized (b.class) {
                if (f6134a == null) {
                    f6134a = new b(context);
                }
            }
        }
        return f6134a;
    }

    public void a(String str, int i, String str2, long j, e eVar) {
    }
}
