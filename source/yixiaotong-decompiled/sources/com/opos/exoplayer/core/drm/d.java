package com.opos.exoplayer.core.drm;

import android.media.MediaCrypto;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCrypto f6383a;
    private final boolean b;

    public MediaCrypto a() {
        return this.f6383a;
    }

    public boolean a(String str) {
        return !this.b && this.f6383a.requiresSecureDecoderComponent(str);
    }
}
