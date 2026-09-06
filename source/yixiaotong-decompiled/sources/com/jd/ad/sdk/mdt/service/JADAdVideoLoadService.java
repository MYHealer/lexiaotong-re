package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADAdVideoLoadService {
    void loadAdVideo(Context context, String str, String str2, String str3, VideoLoadListener videoLoadListener);

    void registerAd(String str);

    void unregisterAd(String str);
}
