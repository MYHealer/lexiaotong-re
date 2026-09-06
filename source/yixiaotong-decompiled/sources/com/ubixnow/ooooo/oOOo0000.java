package com.ubixnow.ooooo;

import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOo0000 extends Exception {
    private int OooO00o;

    public oOOo0000(String str) {
        super(str);
        this.OooO00o = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
    }

    public oOOo0000(String str, String str2) {
        super(str);
        try {
            this.OooO00o = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            this.OooO00o = 0;
        }
    }

    public oOOo0000(Throwable th) {
        super(th);
    }

    public int OooO00o() {
        return this.OooO00o;
    }
}
