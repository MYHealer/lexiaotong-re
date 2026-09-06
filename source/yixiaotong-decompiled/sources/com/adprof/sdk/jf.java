package com.adprof.sdk;

import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class jf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kf f1248a;

    public jf(kf kfVar) {
        this.f1248a = kfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView = this.f1248a.f1266a;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }
}
