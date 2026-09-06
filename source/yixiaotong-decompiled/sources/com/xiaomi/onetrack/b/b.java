package com.xiaomi.onetrack.b;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9449a;
    public final /* synthetic */ a b;

    public b(a aVar, String str) {
        this.b = aVar;
        this.f9449a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f9449a)) {
            return;
        }
        this.b.c(this.f9449a);
    }
}
