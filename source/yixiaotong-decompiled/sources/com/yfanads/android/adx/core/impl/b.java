package com.yfanads.android.adx.core.impl;

import android.text.TextUtils;
import com.yfanads.android.adx.core.model.AdxImage;

/* JADX INFO: compiled from: AdxImageImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b implements AdxImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9589a;
    public final int b;
    public final String c;

    public b(int i, int i2, String str) {
        this.f9589a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // com.yfanads.android.adx.core.model.AdxImage
    public final int getHeight() {
        return this.b;
    }

    @Override // com.yfanads.android.adx.core.model.AdxImage
    public final String getImageUrl() {
        return this.c;
    }

    @Override // com.yfanads.android.adx.core.model.AdxImage
    public final int getWidth() {
        return this.f9589a;
    }

    @Override // com.yfanads.android.adx.core.model.AdxImage
    public final boolean isValid() {
        return this.f9589a > 0 && this.b > 0 && !TextUtils.isEmpty(this.c);
    }
}
