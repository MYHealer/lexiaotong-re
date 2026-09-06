package com.ubix.ssp.ad.core.monitor.data.c;

import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f8593a;
    private final Uri b;
    private final Uri c;

    private c(String str) {
        this.b = Uri.parse("content://" + str + ".UbixDataContentProvider/events");
        this.c = Uri.parse("content://" + str + ".UbixDataContentProvider/data_collect");
    }

    public static c a(String str) {
        if (f8593a == null) {
            f8593a = new c(str);
        }
        return f8593a;
    }

    Uri a() {
        return this.b;
    }
}
