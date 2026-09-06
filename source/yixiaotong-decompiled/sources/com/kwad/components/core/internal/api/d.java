package com.kwad.components.core.internal.api;

import android.text.TextUtils;
import com.kwad.sdk.api.KsImage;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d implements KsImage {
    private int height;
    private String imageUrl;
    private int width;

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.height;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.width;
    }

    public static void register() {
        com.kwad.sdk.service.c.a(KsImage.class, d.class);
    }

    public d(int i, int i2, String str) {
        this.width = i;
        this.height = i2;
        this.imageUrl = str;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.width > 0 && this.height > 0 && !TextUtils.isEmpty(this.imageUrl);
    }
}
