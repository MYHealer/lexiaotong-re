package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkDynamicApi
public interface ICompletedRemoteView {
    @KsAdSdkDynamicApi
    RemoteViews build();

    @KsAdSdkDynamicApi
    void setIcon(int i);

    @KsAdSdkDynamicApi
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    void setInstallText(String str);

    @KsAdSdkDynamicApi
    void setName(String str);

    @KsAdSdkDynamicApi
    void setSize(String str);

    @KsAdSdkDynamicApi
    void setStatus(String str);
}
