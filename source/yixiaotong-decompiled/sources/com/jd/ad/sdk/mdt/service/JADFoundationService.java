package com.jd.ad.sdk.mdt.service;

import android.app.Application;
import android.content.Context;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADFoundationService {
    Application getApplication();

    boolean isNetAvailable();

    void loadImage(Context context, String str, OnImageLoadListener onImageLoadListener);

    void preloadImage(Context context, String str, OnImageLoadListener onImageLoadListener);
}
