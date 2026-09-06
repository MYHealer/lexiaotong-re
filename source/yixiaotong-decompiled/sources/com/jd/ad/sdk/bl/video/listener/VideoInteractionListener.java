package com.jd.ad.sdk.bl.video.listener;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface VideoInteractionListener {
    void onAdClicked(int i, int i2);

    void onAdCountdown(int i);

    void onAdSkip(View view);

    void onAdTimeOver();

    void onVideoAnimationEnd();
}
