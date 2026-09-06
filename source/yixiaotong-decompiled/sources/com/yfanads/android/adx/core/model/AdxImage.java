package com.yfanads.android.adx.core.model;

import com.yfanads.android.adx.core.annotate.AdSdkApi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkApi
public interface AdxImage {
    @AdSdkApi
    int getHeight();

    @AdSdkApi
    String getImageUrl();

    @AdSdkApi
    int getWidth();

    @AdSdkApi
    boolean isValid();
}
