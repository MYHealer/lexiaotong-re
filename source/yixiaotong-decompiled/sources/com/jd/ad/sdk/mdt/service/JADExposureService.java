package com.jd.ad.sdk.mdt.service;

import android.view.View;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADExposureService {
    ConcurrentHashMap<String, WeakReference<View>> getNativeExposureFeedShakeViewMap();

    void registerExposureView(String str);

    void registerNativeExposureFeedShakeView(String str, View view);

    void setViewExposureCallback(String str, int i, View view, JADExposureListener jADExposureListener);

    void setViewForceExposure(String str);

    void unregisterExposureView(String str);

    void unregisterNativeExposureFeedShakeView(String str);
}
