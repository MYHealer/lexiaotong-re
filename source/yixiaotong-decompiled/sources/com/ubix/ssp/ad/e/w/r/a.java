package com.ubix.ssp.ad.e.w.r;

import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8916a;

    public a(String str) {
        super(str);
        this.f8916a = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
    }

    public a(String str, String str2) {
        super(str);
        try {
            this.f8916a = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            this.f8916a = 0;
        }
    }

    public a(Throwable th) {
        super(th);
    }
}
