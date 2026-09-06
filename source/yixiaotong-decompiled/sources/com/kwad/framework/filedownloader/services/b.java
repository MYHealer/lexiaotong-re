package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.framework.filedownloader.f.c.d {
    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int f(String str, String str2, boolean z) {
        return g(str, str2, z);
    }

    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int g(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (z) {
                return com.kwad.framework.filedownloader.f.f.md5(com.kwad.framework.filedownloader.f.f.c("%sp%s@dir", str, str2)).hashCode();
            }
            return com.kwad.framework.filedownloader.f.f.md5(com.kwad.framework.filedownloader.f.f.c("%sp%s", str, str2)).hashCode();
        } catch (Throwable unused) {
            return str.hashCode();
        }
    }
}
